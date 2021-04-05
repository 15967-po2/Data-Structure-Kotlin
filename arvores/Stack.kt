/**
* Nuno Ricardo Martins Cruz
* 15967@alunos.ipbeja.pt
* 15967
*/

import kotlin.text.StringBuilder


class Stack(number: Int) {

	// Sets stack max - 1, so it doesnt overflow
    var top = -1
    var stack:IntArray = IntArray(number)

	// Check iff stack is empty
    fun stackEmpty():Boolean {
        if (top == -1) return true
        else return false
    }
	
	// Adds last element to stack
    fun push(x: Int) {
        top++
        stack[top] = x
    }
	
	// Checks iff overflow doesnt occur
	// By checking the top of the stack last element added
    fun pop(): Int {
        if (stackEmpty()) {
            println("underflow")
            return 0
        }
        else {
            top--
            return stack[top + 1]
        }
    }

    override fun toString(): String {
        val res = StringBuilder()
        for (x in stack) {
            res.append((x))
            res.append(" ")
        }
        return res.toString()
    }

}
