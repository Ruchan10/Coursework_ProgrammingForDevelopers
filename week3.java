package CourseWork;

class week3 {
     // Main function to find the minimum cost required
     static void main(int houses[][], int r, int c) {
          // declaring and initializing required variables
          int arr = 0, arr0 = 0, dis = 0, shortest = 0, count = 0, distance;
          // loopint through rows
          for (int i = 0; i < r - 1; i++) {
               // looping through columns
               for (int j = 0; j < c; j++) {
                    arr = arr + houses[i][j]; // finding sum of a column
               }
               for (int j = 0; j < c; j++) {
                    arr0 = arr0 + houses[i + 1][j]; // finding sum of another column
               }
               if (count == 0) { // to initialize shortest once
                    shortest = arr0 - arr; // initilizing shortest with the first distance
                    dis=shortest; // putting the value of shortest in dis variable
                    count = 1; 
               }
               if (count != 1) { // No need to run these codes in first loop
                    distance = arr0 - shortest; // finding cost from one point to another
                    if (shortest > distance) { // shortest chances if another shortest point is found
                         shortest = distance; // change the variable in shortest
                    }
                    dis = dis + distance; // add all the distance in dis
               }
               // reinitialize the variables
               arr = 0; 
               arr0 = 0;
               count=2;
          }
          System.out.println("Minimum Cost:- "+dis);
     }

     public static void main(String args[]) {

          // Graph in form of 2D array
          int houses[][] = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 4, 4 }, { 5, 2 }, { 7, 0 } };
          int r = houses.length; // length of row
          int c = houses[0].length; // length of column

          // Function Call
          main(houses, r, c);
     }
}
