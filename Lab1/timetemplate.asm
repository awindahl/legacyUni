  # timetemplate.asm
  # Written 2015 by F Lundevall
  # Copyright abandonded - this file is in the public domain.

.macro	PUSH (%reg)
	addi	$sp,$sp,-4
	sw	%reg,0($sp)
.end_macro

.macro	POP (%reg)
	lw	%reg,0($sp)
	addi	$sp,$sp,4
.end_macro

	.data
	.align 2
mytime:	.word 0x5957 #the time Byte
timstr:	.ascii "text more text lots of text\0"
	.text
main:
	# print timstr
	la	$a0,timstr
	li	$v0,4
	syscall
	nop
	# wait a little
	li	$a0,-1
	jal	delay
	nop
	# call tick
	la	$a0,mytime
	jal	tick
	nop
	# call your function time2string
	la	$a0,timstr
	la	$t0,mytime
	lw	$a1,0($t0)
	jal	time2string
	nop
	# print a newline
	li	$a0,10
	li	$v0,11
	syscall
	nop
	# go back and do it all again
	j	main
	nop
# tick: update time pointed to by $a0
tick:	lw	$t0,0($a0)	# get time
	addiu	$t0,$t0,1	# increase
	andi	$t1,$t0,0xf	# check lowest digit
	sltiu	$t2,$t1,0xa	# if digit < a, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0x6	# adjust lowest digit
	andi	$t1,$t0,0xf0	# check next digit
	sltiu	$t2,$t1,0x60	# if digit < 6, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0xa0	# adjust digit
	andi	$t1,$t0,0xf00	# check minute digit
	sltiu	$t2,$t1,0xa00	# if digit < a, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0x600	# adjust digit
	andi	$t1,$t0,0xf000	# check last digit
	sltiu	$t2,$t1,0x6000	# if digit < 6, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0xa000	# adjust last digit
	
tiend:	sw	$t0,0($a0)	# save updated result
	jr	$ra		# return
	nop

hexasc:
	andi	$t0,$a0, 15	# extracts the LSB
	ble	$t0,9,number	# checks if the value is 9 or smaller
	addi	$t1,$t0,0x37	# adds the appropriate LETTER
	j	returner
	nop
	
number:
	addi	$t1,$t0,0x30	# adds the appropriate NUMBER
	
returner:	
	move	$v0,$t1		# writes the result to the return address
	jr 	$ra		# goes back to the main


delay:
	subi	$a0,$a0,1
	slt	$t1,$a0,$0
	beq	$t1,$0,delay
	nop
	jr	$ra
	nop
	
time2string:	
	PUSH	($ra)		# saves the return address
	PUSH	($v0)		# saves the function return
	PUSH	($a2)		# saves the second argument
	PUSH	($a3)		# saves the third argument
	
	addi 	$a2,$0, 15
	addi	$a3,$0, 12
	
	jal	convert
	nop
	sb	$v0,0($a0)	# upper minute stored at "position 0" of $a0
	
	subi	$a3,$a3,4	# moves 4 bits down the time Byte to reach the lower minute
	jal	convert
	nop
	sb	$v0,1,($a0)	# lower minute stored at "position 1" of $a0
	
	addi	$t5,$0,0x3a	# saves colon sign in $t5
	sb	$t5,2($a0)	# colon-sign stored at "position 2" of $a0
	
	subi	$a3,$a3,4	# move 4-bits further down the time Byte to reach the upper second
	jal 	convert
	nop
	sb	$v0,3($a0)	# upper second stored at "position 3" of $a0 
	
	subi	$a3,$a3,4	# moves down to the last part of the time Byte
	jal	convert
	nop
	sb	$v0,4($a0)	# lower second stored at "position 4" of $a0
	
	
	addi 	$t5, $0, 0x00	# adds null byte
	sb	$t5, 5($a0)

	POP	($v0)		# restores the function return address
	POP	($a3)		# restores the third argument address
	POP	($a2)		# restores the second argument address
	POP	($ra)		# restores the return address
	jr	$ra
	nop
			
extract:
	sllv	$v0,$a2,$a3
	and	$v0,$a1,$v0
	srlv	$v0,$v0,$a3
	jr	$ra
	nop
	
convert:
	PUSH	($ra)
	jal 	extract
	nop
	
	PUSH	($a0)
	add 	$a0,$v0,$0
	jal	hexasc
	nop
	POP	($a0)
	
	POP	($ra)
	jr 	$ra
	nop
