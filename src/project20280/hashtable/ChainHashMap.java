package project20280.hashtable;

import project20280.interfaces.Entry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Map implementation using hash table with separate chaining.
 */

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    // a fixed capacity array of UnsortedTableMap that serve as buckets
    private UnsortedTableMap<K, V>[] table; // initialized within createTable

    /**
     * Creates a hash table with capacity 11 and prime factor 109345121.
     */
    public ChainHashMap() {
        super();
    }

    /**
     * Creates a hash table with given capacity and prime factor 109345121.
     */
    public ChainHashMap(int cap) {
        super(cap);
    }

    /**
     * Creates a hash table with the given capacity and prime factor.
     */
    public ChainHashMap(int cap, int p) {
        super(cap, p);
    }

    /**
     * Creates an empty table having length equal to current capacity.
     */
    @Override
    @SuppressWarnings({"unchecked"})
    protected void createTable() {
        table = new UnsortedTableMap[capacity];
    }

    /**
     * Returns value associated with key k in bucket with hash value h. If no such
     * entry exists, returns null.
     *
     * @param h the hash value of the relevant bucket
     * @param k the key of interest
     * @return associate value (or null, if no such entry)
     */
    @Override
    protected V bucketGet(int h, K k) {
        if (table[h] == null) return null;
        return table[h].get(k);
    }

    /**
     * Associates key k with value v in bucket with hash value h, returning the
     * previously associated value, if any.
     *
     * @param h the hash value of the relevant bucket
     * @param k the key of interest
     * @param v the value to be associated
     * @return previous value associated with k (or null, if no such entry)
     */
    @Override
    protected V bucketPut(int h, K k, V v) {
        if (table[h] == null) {
            table[h] = new UnsortedTableMap<>();
        }

        int oldSize = table[h].size();
        V oldValue = table[h].put(k, v);
        if(table[h].size() > oldSize) {
            n++;
        }
        return oldValue;
    }


    /**
     * Removes entry having key k from bucket with hash value h, returning the
     * previously associated value, if found.
     *
     * @param h the hash value of the relevant bucket
     * @param k the key of interest
     * @return previous value associated with k (or null, if no such entry)
     */
    @Override
    protected V bucketRemove(int h, K k) {
        UnsortedTableMap<K, V> bucket = this.table[h];
        if(bucket == null){
            return null;
        }
        int oldSize = bucket.size();
        V oldValue = bucket.remove(k);
        if(bucket.size() < oldSize) {
            n--;
        }

        return oldValue;
    }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return iterable collection of the map's entries
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        /*
        for each element in (UnsortedTableMap []) table
            for each element in bucket:
                print element
        */
        ArrayList<Entry<K, V>> entries = new ArrayList<>();
        for (UnsortedTableMap<K, V> tm : table) {
            if (tm != null) {
                for (Entry<K, V> e : tm.entrySet()) {
                    entries.add(e);
                }
            }
        }
        return entries;
    }

    public String toString() {
        return entrySet().toString();
    }

//    public static void main(String[] args) {
//        ChainHashMap<Integer, String> m = new ChainHashMap<Integer, String>();
//        m.put(1, "One");
//        m.put(10, "Ten");
//        m.put(11, "Eleven");
//        m.put(20, "Twenty");
//
//        System.out.println("m: " + m);
//
//        m.remove(11);
//        System.out.println("m: " + m);
//    }

    public static void main(String [] args) throws FileNotFoundException {
        File f = new File("src/project20280/hashtable/sample_text.txt");
        ChainHashMap<String, Integer> counter = new ChainHashMap<>();
        Scanner scanner = new Scanner(f);

        while(scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
            if(word.isEmpty()) continue;
            Integer count = counter.get(word);
            if(count == null) {
                counter.put(word, 1);
            } else {
                counter.put(word, count + 1);
            }
        }
        scanner.close();

        ArrayList<Entry<String, Integer>> entries = new ArrayList<>();
        for (Entry<String, Integer> e : counter.entrySet()) {
            entries.add(e);
        }


        entries.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Top 10 words: ");
        for(int i=0; i < 10; i++) {
            System.out.println(entries.get(i).getKey() + " " + entries.get(i).getValue());
        }
    }
}
