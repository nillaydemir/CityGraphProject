/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citygraph;

/**
 *
 * @author 90551
 */
public class Hash<Key> {
      Key[] table;
    int M;
    int N; // number of full elements
    boolean[] full;

    public Hash(int M) {
        table = (Key[]) new Object[M];
        this.M = M;
    }

    public Key B(int i){
        return table[i];
    }

    public int hash(Key t) {
        return ((t.hashCode() & 0x7fffffff) % M);
    }

    private void resize(int capacity) {
        System.out.println("resize");

        Hash<Key> temp = new Hash<Key>(capacity);
        for (int i = 0; i < M; i++) {
            if (table[i] != null) {
                temp.insert(table[i]);
            }
        }
        table = temp.table;
        full = temp.full;
        M = temp.M;
    }

    public boolean insert2(Key key) {
        int i;
        int h = hash(key);

        for (i = h; table[i] != null; i = (i + 1) % M) {
            if (table[i].equals(key)) {
                return true;
            }
            if (i + 1 == h) {
                return false; // table is full
            }
        }
        table[i] = key;
        N++; // increase number of stored items
        return true;
    }

    //contains method returns true if hash map contains the Key
    public boolean contains(Key key) {
        int ix = hash(key);
       // System.out.print(" hash : " + ix);
        int startIx = ix;

        while (table[ix] != null && (ix + 1 != startIx)) {
            if (table[ix].equals(key)) {
                return true; //found
            }            //if (ix + 1 == startIx) return false; // starting point
            ix = (ix + 1) % M; // cycle through
            //System.out.print(" ix : " + ix);
        }
        return false;
    }

    public boolean insert(Key key) {
        int ix = hash(key);

        if (N == M) {

            return false;
        }
        while (table[ix] != null) {
            if (table[ix].equals(key)) {

                return false;
            }
            ix = (ix + 1) % M;
        }

        table[ix] = key;
        N++;
        return true;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < M; i++) {
            s += table[i] + ",";
        }
        return s + "]";
    }
}
