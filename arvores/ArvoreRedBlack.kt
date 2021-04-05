/**
* Nuno Ricardo Martins Cruz
* 15967@alunos.ipbeja.pt
* 15967
*/

import kotlin.text.StringBuilder

class ArvoreRedBlack(number: Int): ArvorePesquisaBinaria(number) {
	
    var color:IntArray = IntArray(number)
    val BLACK = 0
    val RED = 1
	var right:IntArray = memory.right
    var left:IntArray = memory.left
    var p:IntArray = memory.p

	// Rotates tree in counter clockwise
	// Swaps parent node with its right child
    fun leftRotate(x: Int) {
        var y = right[x]
        right[x] = left[y]
        if (left[y] != NIL)
            p[left[y]] = x
        p[y] = p[x]
        if (p[x] == NIL) {
            root = y
        }
        else if (x == p[left[x]]) {
            p[left[x]] = y
        }
        else {
            right[p[x]] = y
        }
        left[y] = x
        p[x] = y
    }

	// Rotates tree in clockwise
	// Swaps parent node with its left child
	fun rightRotate(x: Int) {
        var y = left[x]
        left[x] = right[y]
        if (right[y] != NIL) {
            p[right[y]] = x
        }
        p[y] = p[x]
        if (p[x] == NIL) {
            root = y
        }
        else if (x == p[right[x]]) {
            p[right[x]] = y
        }
        else {
            left[p[x]] = y
        }
        right[y] = x
        p[x] = y
    }

	// Rearange tree color values and do rotations when insertion is added
	fun insertFixUp(z: Int) {
        var t = z
        var y = 0
        while (color[p[t]] == RED) {
            if (p[t] == left[p[p[t]]]) {
                y = right[p[p[t]]]
                if (color[y] == RED) {
                    color[p[t]] = BLACK
                    color[y] = BLACK
                    color[p[p[t]]] = RED
                    t = p[p[t]]
                }
                else {
                    if (t == right[p[t]]) {
                        t = p[t]
                        leftRotate(t)
                    }
                    color[p[t]] = BLACK
                    color[p[p[t]]] = RED
                    rightRotate(p[p[t]])
                }
            }
            else {
                y = left[p[p[z]]]
                if (color[y] == RED) {
                    color[p[t]] = BLACK
                    color[y] = BLACK
                    color[p[p[t]]] = RED
                }
                else {
                    if (t == left[p[t]]) {
                        t = p[t]
                        rightRotate(t)
                    }
                }
            }
        }
        color[root] = BLACK
    }

    override fun insert(key: Int) {
        super.insert(key)
        color[z] = RED
        print("z = ")
        println(z)
        insertFixUp(z)
    }

    override fun toString(): String {
        var s = super.toString()
        var res = StringBuilder()
        res.append("\n")
 
        for(k in color.indices.reversed()) {
            res.append(k)
            res.append("-> color = ")
            res.append(if (color[k] == 0)"BLACK" else "RED")
            res.append("\n")
        }
        return s + res
    }
}

fun main(args:Array<String>) {

	val number = 10
    var key = 0

    var bs = ArvoreRedBlack(number)
    println("BINARY TREE RED BLACK")

    println(bs)
    key = 12; bs.insert(key)
    key = 5; bs.insert(key)
    key = 18; bs.insert(key)
    key = 2; bs.insert(key)
    key = 9; bs.insert(key)
    key = 15; bs.insert(key)
    key = 19; bs.insert(key)
    key = 13; bs.insert(key)
    key = 17; bs.insert(key)

    println()
    println("AFTER")
    println(bs)
}


