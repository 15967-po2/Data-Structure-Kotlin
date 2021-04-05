/**
* Nuno Ricardo Martins Cruz
* 15967@alunos.ipbeja.pt
* 15967
*/

class Memory(number: Int) {

    var p:IntArray = IntArray(number)
    var key:IntArray = IntArray(number)
    var left:IntArray = IntArray(number)
    var right:IntArray = IntArray(number)
    val NIL = 0;
    var stack:Stack = Stack(number)

    init {
        for (k in 1 until number) {
            stack.push(k)
        }
        for (k in 0 until number) {
            p[k] = NIL
            left[k] = NIL
            right[k] = NIL
        }
    }
	
	// Removes last indexed value from tail stack
	// Pushs new indexed value in to stack using the same allocate memory
    fun allocateObject(): Int {
        var x = stack.pop()
        if (x == 0) return 0
        else return x
    }
	
    fun freeObject(x: Int) {
        stack.push(x)
    }

    override fun toString(): String {
        var res = StringBuilder()
        res.append(("\n"))
        for (k in p.indices.reversed()) {
            res.append(k)
            res.append("-> [p = ")
            res.append(if (p[k] == 0) "nil" else p[k])
            res.append(", key = ")
            res.append((key[k]))
            res.append(", left = ")
            res.append(if (left[k] == 0) "nil" else left[k])
            res.append(", right = ")
            res.append(if (right[k] == 0) "nil" else right[k])
            res.append("]\n")
        }
        return res.toString()
    }
}

