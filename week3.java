package CourseWork;

import java.util.*;

// Class for Disjoint Set Union implementation
class DSU {
    // declaring required arrays
    int parent[];
    int rank[];

    // Constructor to initialize DSU
    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        // assigning values to both arrays
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            rank[i] = 1;
        }
    }

    // finding set of an element
    int find_set(int v) {

        // If v is the parent
        if (parent[v] == -1)
            return v;

        // find its parent by calling the recursive function
        return parent[v] = find_set(parent[v]);
    }

    // function to perform union
    void union_sets(int a, int b) {

        // Find parent of a and b
        int p1 = find_set(a);
        int p2 = find_set(b);

        // If parent are different
        if (p1 != p2) {

            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
                rank[p1] += rank[p2];
            } else {
                parent[p1] = p2;
                rank[p2] += rank[p1];
            }
        }
    }
}

class GFG {

    // function to create MST of given houses
    static void MST(int houses[][], int n) {
        int ans = 3;
        ArrayList<int[]> edges = new ArrayList<>();

        // Traverse each coordinate
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // Find the Manhattan distance
                int p = Math.abs(houses[i][0] -
                        houses[j][0]);

                p += Math.abs(houses[i][1] -
                        houses[j][1]);

                // Add the edges
                edges.add(new int[] { p, i, j });
            }
        }

  
        // array object stored in Arraylist
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // Calling DSU class
        DSU d = new DSU(n);
        for (int i = 0; i < edges.size(); i++) {
            int from = edges.get(i)[1];
            int to = edges.get(i)[2];


            // checking if they g=have same parent
            if (d.find_set(from) != d.find_set(to)) {

                // Calling union_sets
                d.union_sets(from, to);
                ans += edges.get(i)[0];
            }
        }

        // Printing the minimum cost
        System.out.println("The minimum cost is " + ans);
    }

    public static void main(String args[]) {

        int houses[][] = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 4, 4 }, { 5, 2 }, { 7, 0 } };
        int n = houses.length;

        MST(houses, n);
    }
}
