package project20280.tree;
import project20280.interfaces.Tree;

import java.util.*;

public class BSTsort {

    public static List<Integer> TreeMapSort(List<Integer> input) {
        TreeMap<Integer, Integer> bst = new TreeMap<>();
        for(int e : input) bst.put(e,e);
        List<Integer> sorted = new ArrayList<>();
        while(!bst.isEmpty()) {
            sorted.add(bst.firstEntry().getKey());
            bst.remove(bst.firstEntry().getKey());
        }
        return sorted;
    }

    public static List<Integer> AVLSort(List<Integer> input) {
        AVLTreeMap<Integer, Integer> avl = new AVLTreeMap<>();
        for (int e : input) avl.put(e, e);

        List<Integer> sorted = new ArrayList<>();
        while (!avl.isEmpty()) {
            sorted.add(avl.firstEntry().getKey());
            avl.remove(avl.firstEntry().getKey());
        }
        return sorted;
    }

    public static List<Integer> JavaTreeMapSort(List<Integer> input) {
        java.util.TreeMap<Integer, Integer> jtm = new java.util.TreeMap<>();
        for (int e : input) jtm.put(e, e);

        List<Integer> sorted = new ArrayList<>();
        while (!jtm.isEmpty()) {
            sorted.add(jtm.firstKey());
            jtm.remove(jtm.firstKey());
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        Random rnd = new Random(42);

        System.out.println("n, TreeMap(ms), AVL(ms), java.util.TreeMap(ms)");

        for (int n : sizes) {
            List<Integer> input = new ArrayList<>();
            for (int i = 0; i < n; i++) input.add(rnd.nextInt(n * 10));

            // time TreeMap
            long start = System.nanoTime();
            TreeMapSort(new ArrayList<>(input));
            long treeMapTime = (System.nanoTime() - start) / 1_000_000;

            // time AVL
            start = System.nanoTime();
            AVLSort(new ArrayList<>(input));
            long avlTime = (System.nanoTime() - start) / 1_000_000;

            // time java.util.TreeMap
            start = System.nanoTime();
            JavaTreeMapSort(new ArrayList<>(input));
            long javaTime = (System.nanoTime() - start) / 1_000_000;

            System.out.println(n + ",   " + treeMapTime + ",    " + avlTime + ",    " + javaTime);
        }
    }
}
