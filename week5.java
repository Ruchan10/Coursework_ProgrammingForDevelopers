package CourseWork;

import java.util.Arrays;

public class week5 {
    // array to store indexes of given array
    static int []index;
    // function to check how many sub sets were used
    public static void checkSubset(String target, String[] set) {
        // string to keep count of visited sub arrays
        String visited = "";
        // variables to store individual counts
        int ans = 0;
        int first =0;
        int second =0;
        int third =0;
        // initializing index array
        index = new int[target.length()];
        // loop to find the desired output
        for (int i = 0; i < target.length(); i++) {
            // looping through each subsets
            for (int j = 0; j < set.length; j++) {
                for (int k = 0; k < set[j].length(); k++) {
                    // if characters are equal and not visited
                    if (target.toUpperCase().charAt(i) == set[j].toUpperCase().charAt(k)
                            && !visited.contains(target.charAt(i) + ""))
                    {
                        visited += target.charAt(i);


                        String some = set[j].toUpperCase();
                        if(set[j].toUpperCase().equals(set[0].toUpperCase())){
                            first ++;
                        }else if(set[j].toUpperCase().equals(set[1].toUpperCase())) {
                            second++;
                        }else if(set[j].toUpperCase().equals(set[2].toUpperCase())) {
                            third++;

                        }

                        if (ans <= j + 1) {
                            ans++;
                        }



                    }


                }
            }
        }
        // if all the characters are visited
        if (first==target.length()) {
            System.out.println(1);
        }else if(second==target.length()) {
            System.out.println(2);
        }else if(third==target.length()) {
            System.out.println(3);
        }else if((first+second)==target.length()) {
            System.out.println(2);
        }else if((first+third)==target.length()) {
                System.out.println(2);
        }else if((second+third)==target.length()) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }

    public static void main(String[] args) {
        String target = "dev";

        String[] set = { "programming", "For", "developers" };

        checkSubset(target, set);
        }
    }
