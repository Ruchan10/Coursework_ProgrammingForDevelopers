package CourseWork;



public class week4 {
     // function to sort an array
     private static void sortArray(int array[]) {
         for (int i = 1; i < array.length; i++) {
             int j = i;
             int a = array[i];
 
             // comparing the current element with the previous element
             while ((j > 0) && (array[j - 1] > a)) {
                 array[j] = array[j - 1]; 
                 j--; 
             }
             array[j] = a; 
         }
     }
     // function to find the total required containers
     public static void findTotalContainers(int array[]) {
         // sort the array
         sortArray(array);
 
         int prevValue = 0; 
         int containerForCurrentVillage = 0; 
         int totalContainers = 0; 
 
         // looping through the elements the array
         for (int i = 0; i < array.length; i++) {
             // if the current element is not same as the previous element
             if (array[i] != prevValue) {
                 prevValue = array[i];
                 containerForCurrentVillage += 1;
                 totalContainers += containerForCurrentVillage;
             }
             // if the curret element is same as the previous element
             else {
                 prevValue = array[i];
                 totalContainers += containerForCurrentVillage;
             }
         }
 
         System.out.println(totalContainers);
     }
 
     public static void main(String[] args) {
         int array[] = { 5, 2, 6 };
 
         // calling the function
         findTotalContainers(array);
     }
 }