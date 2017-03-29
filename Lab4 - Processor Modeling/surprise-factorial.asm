.text
	addi	$a0,$0,1
	add	$0,$0,$0	# No Operation
	beq	$a0,$0,zero
	add	$0,$0,$0	# No Operation
	beq	$a0,1, zero
	add	$0, $0, $0	# No Operation
	add	$a1, $a0, $0
multip:
	beq	$a1, 1, done
	add	$0, $0, $0	# No Operation
	addi	$a1, $a1, -1
	mul	$a0, $a1, $a0
	add	$v0, $a0, $0
	add	$0,$0,$0	# No Operation
	beq	$0, $0, multip
	add	$0, $0, $0	# No Operation
zero:
	addi	$v0, $0, 1	# zero factorial is 1
done:
	beq	$0, $0, done
	add	$0, $0, $0	# No Operations
