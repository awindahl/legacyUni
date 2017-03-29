  # hexmain.asm
  # Written 2015-09-04 by F Lundevall
  # Copyright abandonded - this file is in the public domain.

	.text
main:
	li	$a0,17		# change this to test different values

	jal	hexasc		# call hexasc
	nop			# delay slot filler (just in case)	
	
	move	$a0,$v0		# copy return value to argument register
		
	li	$v0,11		# syscall with v0 = 11 will print out
	syscall			# one byte from a0 to the Run I/O window
	
stop:	j	stop		# stop after one run
	nop			# delay slot filler (just in case)

  # You can write your own code for hexasc here
  #

hexasc:
	andi	$t0,$a0, 15	# extracts the LSB
	ble	$t0,9,number	# checks if the value is 9 or smaller
	addi	$t1,$t0,0x37
	j	returner
	nop
	
number:
	addi	$t1,$t0,0x30	# adds a hex-value
	j	returner
	nop
	
returner:	
	move	$v0,$t1		# writes the result to the return address
	jr 	$ra		#goes back to the main
	nop
