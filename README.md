# Questions

### WK2 - Linked Lists

**What is the difference between a singly linked list and a circularly linked list?**
* A singly linked list is a list of items where each item points to the next one, and the last item points to nothing (null).
* A circularly linked list is a list where the last item points back to the first item instead of stopping. The list goes around in a loop.

**In what situations would you prefer to use a linked list to an array?**
* You would prefer to use a linked list instead of an array when the size of the collection needs to change often and when elements are frequently inserted or removed. Also, when you do not need fast access by index.

**Describe 2 possible use-cases for a circularly linked list** 
* Round-robin scheduling:
A circularly linked list is useful when several tasks need to take turns. After the last task is done, the list goes back to the first task automatically, so the cycle can continue smoothly.
* Playlists or turn-based games:
A circularly linked list is helpful when items repeat in order, like songs in a playlist or players taking turns in a game. When you reach the end, it loops back to the start without stopping.

### WK3 - Stacks, Queues, Deques


**Write  the pseudocode for an algorithm which implements a Queue using two stacks.
Provide implementations for the enqueue() and dequeue() methods.**

    PROCEDURE enqueue(x)
    PUSH x onto Stack1

    dequeue():
    if outStack is empty:
        if inStack is empty:
            return "Queue is empty"
        while inStack is NOT empty:
            outStack.push(inStack.pop())
    return outStack.pop()    

**Write the pseudocode algorithm which reverses the elements on a Stack using two additional Stack's (no other data structures are allowed)**

Stack A,
Stack B,
Stack C

    while C is not empty:
        A.push(C.pop())

    while A is not empty:
        B.push(A.pop())

    while B is not empty:
        C.push(B.pop())


### WK4 - Trees I

**Write a recursive function (pseudo-code) to count the number of external nodes in a binary tree.**

    countExternal(p):
    if isExternal(p):
    return 1
    return countExternal(left(p)) + countExternal(right(p))


    public int countExternal(Position<E> p) {
        if (isExternal(p)) return 1;
        return countExternal(left(p)) + countExternal(right(p));
    }

**Describe, with a figure or pseudocode, an algorithm which counts only the left external
nodes in a binary tree.**

        A
       / \
      B*  C
     / \
    D*  E
    
    Nodes Marked * are left external nodes.

**Consider a binary tree, where each node holds a single character. The nodes, in no
particular order are ['A', 'E', 'F', 'M', 'N', 'U', 'X'].**

**Draw a representation of this binary tree such that a preorder traversal of the tree gives
the result: "EXAMFUN"**

        E
        \
        X
        /
        A
        \
        M
        /
        F
        \
        U
        /
        N

**Draw a representation of this binary tree such that an inorder traversal of the tree gives
the result: "EXAMFUN".**

         M
        / \
       A   U
      / \ / \
     E  X F  N

**Draw a representation of this binary tree such that an postorder traversal of the tree
gives the result: "EXAMFUN".**

           M
          / \
         X   U
        / \ / \
       E  A F  N

**Write the pseudocode for an algorithm which counts the total number of descendants of
a node in a binary tree.**

    countDescendants(p):
    if isExternal(p):  return 0
    left  ← 1 + countDescendants(left(p))
    right ← 1 + countDescendants(right(p))
    return left + right

### WK5 - Trees II
Describe a method (using pseudocode) to find the diameter of a binary tree.

    diameter(root):
    result ← 0
    diameterHelper(root, result)
    return result

    diameterHelper(node, result):
    if node is null: return -1
    left  ← diameterHelper(node.left,  result)
    right ← diameterHelper(node.right, result)
    path  ← left + right + 2
    if path > result: result ← path
    return 1 + max(left, right)










RECURSION

Q1

A={12, 5, 19, 6, 11, 3, 9, 34, 2, 1, 15};

ReverseArray(0,10)
swaps(12,15) = A={15, 5, 19, 6, 11, 3, 9, 34, 2, 1, 12};

ReverseArray(1,9)
    swaps(5,1) = A={15, 1, 19, 6, 11, 3, 9, 34, 2, 5, 12};

ReverseArray(2,8)
    swaps(19,2) = A={15, 1, 2, 6, 11, 3, 9, 34, 19, 5, 12};

ReverseArray(3,7)
    swaps(6,34) = A={15, 1, 2, 34, 11, 3, 9, 6, 19, 5, 12};

ReverseArray(4,6)
    swaps(11,9) = A={15, 1, 2, 34, 9, 3, 11, 6, 19, 5, 12};

ReverseArray(5,5)
    swaps(3,3) = A={15, 1, 2, 34, 9, 3, 11, 6, 19, 5, 12};



question 6

function printReverse(node)

    if node == null
        return

    printReverse(node.next)
    print node.data

end function

function copyList(node)

    if node == null
        return null

    newNode = new Node(node.data)

    newNode.next = copyList(node.next)

    return newNode