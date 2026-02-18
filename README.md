 Starting repository for `Data Structures` COMP20280 2025-2026


Q6. What is the difference between a singly linked list and a circularly linked list?
* A singly linked list is a list of items where each item points to the next one, and the last item points to nothing (null).
* A circularly linked list is a list where the last item points back to the first item instead of stopping. The list goes around in a loop.

Q7. In what situations would you prefer to use a linked list to an array?
* You would prefer to use a linked list instead of an array when the size of the collection needs to change often and when elements are frequently insterteed or removed. Also, when you do not need fast access by index.

Q8. Describe 2 possible use-cases for a circularly linked list 
* Round-robin scheduling:
A circularly linked list is useful when several tasks need to take turns. After the last task is done, the list goes back to the first task automatically, so the cycle can continue smoothly.


* Playlists or turn-based games:
A circularly linked list is helpful when items repeat in order, like songs in a playlist or players taking turns in a game. When you reach the end, it loops back to the start without stopping.

PSEUDOCODE

     PROCEDURE enqueue(x)
    PUSH x onto Stack1

     dequeue():
          if outStack is empty:
               if inStack is empty:
                    return Queue is empty
               
               while inStack is NOT empty:
                    outStack.push(inStack.pop())

               return outStack.pop()

Q3 - Stack A
Stack B
Stack C

     while C is not empty:
        A.push(C.pop())

    while A is not empty:
        B.push(A.pop())

    while B is not empty:
        C.push(B.pop())