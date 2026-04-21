package project20280.hashtable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashFunctionCollisions {
    public static int hash_poly(String s, int a) {
        int h = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char s_i = (char) s.charAt(i);
            int v = s_i * ((int) Math.pow(a, n - i - 1));
            h += v;
        }
        return h;
    }

    public static int hash_cyclic(String s, int shift) {
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = (h << shift) | (h >>> (32 - shift));
            h += (int) s.charAt(i);
        }
        return h;
    }

    public static int hashCode(String s) {
        int hash = 0;
        int skip = Math.max(1, s.length() / 8);
        for (int i = 0; i < s.length(); i += skip) {
            hash = (hash * 37) + s.charAt(i);
        }
        return hash;
    }

    public static int countCollisions(int[] hashValues, int tableSize) {
        ChainHashMap<Integer, Integer> counter = new ChainHashMap<>(tableSize);

        for (int h : hashValues) {
            int slot = Math.abs(h) % tableSize;
            Integer count = counter.get(slot);
            if (count == null) {
                counter.put(slot, 1);
            } else {
                counter.put(slot, count + 1);
            }
        }

        int collisions = 0;
        for (project20280.interfaces.Entry<Integer, Integer> e : counter.entrySet()) {
            if (e.getValue() > 1) {
                collisions += e.getValue() - 1;
            }
        }
        return collisions;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // read all words
        File f = new File("src/project20280/hashtable/words.txt");
        Scanner scanner = new Scanner(f);

        java.util.ArrayList<String> words = new java.util.ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) words.add(word);
        }
        scanner.close();

        System.out.println("Total words: " + words.size());
        int tableSize = words.size() * 2;

        int[] polyA41   = new int[words.size()];
        int[] polyA17   = new int[words.size()];
        int[] cyclic7   = new int[words.size()];
        int[] oldJava   = new int[words.size()];

        for (int i = 0; i < words.size(); i++) {
            polyA41[i] = hash_poly(words.get(i), 41);
            polyA17[i] = hash_poly(words.get(i), 17);
            cyclic7[i] = hash_cyclic(words.get(i), 7);
            oldJava[i] = hashCode(words.get(i));
        }

        // (a) polynomial a=41
        System.out.println("(a) Collisions poly a=41:  " + countCollisions(polyA41, tableSize));

        // (b) polynomial a=17
        System.out.println("(b) Collisions poly a=17:  " + countCollisions(polyA17, tableSize));

        // (c) cyclic shift=7
        System.out.println("(c) Collisions cyclic s=7: " + countCollisions(cyclic7, tableSize));

        // (d) all cyclic shift values 0-31
        System.out.println("\n(d) Collisions for all cyclic shift values:");
        int bestShift = 0;
        int bestCount = Integer.MAX_VALUE;

        for (int shift = 0; shift <= 31; shift++) {
            int[] cyclicN = new int[words.size()];
            for (int i = 0; i < words.size(); i++) {
                cyclicN[i] = hash_cyclic(words.get(i), shift);
            }
            int collisions = countCollisions(cyclicN, tableSize);
            System.out.println("  shift=" + shift + " -> " + collisions + " collisions");

            if (collisions < bestCount) {
                bestCount = collisions;
                bestShift = shift;
            }
        }
        System.out.println("Best shift value: " + bestShift + " with " + bestCount + " collisions");

        // (e) old Java hash
        System.out.println("\n(e) Collisions old Java:   " + countCollisions(oldJava, tableSize));
    }
}
