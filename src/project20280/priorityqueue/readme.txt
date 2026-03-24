1)
    Insert 2 : [2]
    Insert 5 : [2, 5]
    Instert 16 : [2, 5, 16]
    Insert 4 : [2, 5, 16, 4]  Swap 4 and 5: [2, 4, 16, 5]
    Insert 10 : [2, 4, 16, 5, 10]
    Insert 23 : [2, 4, 16, 5, 10, 23]
    Insert 39 : [2, 4, 16, 5, 10, 23, 39]
    Insert 18 : [2, 4, 16, 5, 10, 23, 39, 18] Swap 18 and 5: [2, 4, 16, 18, 10, 23, 39, 5]
    Insert 26 : [2, 4, 16, 18, 10, 23, 39, 5, 26]
    Insert 15 : [2, 4, 16, 18, 10, 23, 39, 5, 26, 15] Swap 10 and 15 : [2, 4, 16, 18, 15, 23, 39, 5, 26, 10]

2) 2, 4, 5, 18, 16, 10, 23, 15, 26, 39
3) 5, 4, 18, 10, 15, 26, 16, 2, 23, 39

4) Yes,
A heap only guarantees that each parent node is larger than its children (in a max-heap).
It does not guarantee ordering between subtrees.
Therefore a pre-order traversal does not necessarily list keys in descending order.
Preorder : [100, 50, 20, 40, 80, 60, 70]
Postorder : [20, 40, 50, 60, 70, 80, 100]


// take away 1 and floor divide it by 2