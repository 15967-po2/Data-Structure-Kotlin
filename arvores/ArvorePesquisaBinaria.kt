/**
* Nuno Ricardo Martins Cruz
* 15967@alunos.ipbeja.pt
* 15967
*/

open class ArvorePesquisaBinaria(number : Int) {

    protected var memory:Memory = Memory(number)

	// representes the leafs in BST
    protected val NIL = 0
    protected var root = NIL
    protected var z = 0

    open fun insert(key:Int) {

		// Variable responsible for allocate memory		
		z = memory.allocateObject()

		// Memory position
        memory.key[z] = key

        var y = NIL
        var x = root
	
		// Responsible to distribuite data for each node
		// Recursive descendent till leaf is found
        while (x != NIL) {
            y = x
            if (memory.key[z] < memory.key[x]) {
                x = memory.left[x]
            }
            else {
                x = memory.right[x]
            }
        }
        memory.p[z] = y
        if (y == NIL) {
            root = z
        }
        else if (memory.key[z] < memory.key[y]) {
            memory.left[y] = z
        }
        else {
            memory.right[y] = z
        }
    }
	
	
    override fun toString(): String {

		// Converts memory data to string into readeble form
        var s = memory.toString() + "root -> " + if (root == 0) "nil" else root
        return s
    }
}
