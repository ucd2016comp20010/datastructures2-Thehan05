package project20280.list;

import org.junit.jupiter.api.Test;
import project20280.interfaces.List;

import static org.junit.jupiter.api.Assertions.*;


class SinglyLinkedListTest {

    @Test
    void testIsEmpty() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        assertTrue(ll.isEmpty());
        assertEquals("[]", ll.toString());

        ll.addLast(1);
        assertFalse(ll.isEmpty());

        ll.removeLast();
        assertTrue(ll.isEmpty());
    }

    @Test
    void testGet() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        Integer r = ll.get(2);
        assertEquals(3, r, "did not get right element" + r);
    }

    @Test
    void testAdd() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        ll.add(1, 100);

        assertEquals("[1, 100, 2, 3]", ll.toString(), "item not added correctly");
    }

    @Test
    void testRemove() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        assertEquals(3, ll.remove(2), "the removed value should be 3");
        assertEquals(2, ll.size(), "the size should be 2");
    }

    @Test
    void testSize() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        assertEquals(0, ll.size());

        ll.addFirst(1);
        assertEquals(1, ll.size());

        ll.removeFirst();
        assertEquals(0, ll.size());
    }

    @Test
    void testRemoveFirst() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
		assertNull(ll.removeFirst());

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        Integer r = ll.removeFirst();
        assertEquals(1, r);
        assertEquals(2, ll.size());
    }

    @Test
    void testRemoveLast() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        assertEquals(3, ll.removeLast());
        assertEquals(2, ll.size());
    }

    @Test
    void testAddFirst() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(-1);
        ll.addFirst(1);

        assertEquals(2, ll.size());
        assertEquals("[1, -1]", ll.toString());
    }

    @Test
    void testAddLast() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addFirst(1);
        ll.addLast(-1);

        assertEquals(2, ll.size());
        assertEquals("[1, -1]", ll.toString());
    }

    @Test
    void testToString() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        assertEquals("[1, 2, 3]", ll.toString());
    }

    @Test
    void testSortedMerge() {
        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
        l1.addLast(2);
        l1.addLast(6);
        l1.addLast(20);
        l1.addLast(24);

        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.addLast(1);
        l2.addLast(3);
        l2.addLast(5);
        l2.addLast(8);
        l2.addLast(12);
        l2.addLast(19);
        l2.addLast(25);

        SinglyLinkedList<Integer> result =
                SinglyLinkedList.sortedMerge(l1, l2);

        assertEquals("[1, 2, 3, 5, 6, 8, 12, 19, 20, 24, 25]",
                result.toString());
    }

    @Test
    void testReverseList() {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        ll.reverse();

        assertEquals("[3, 2, 1]", ll.toString());
    }

    @Test
    void testCopyNormalList() {
        SinglyLinkedList<Integer> original = new SinglyLinkedList<>();
        original.addLast(1);
        original.addLast(2);
        original.addLast(3);

        SinglyLinkedList<Integer> copy = original.copy();

        assertEquals("[1, 2, 3]", copy.toString());
        assertEquals("[1, 2, 3]", original.toString());
    }


}
