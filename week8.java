package CourseWork;


class week8 {
	//declaring required variables
	static int keys=0; // to store number of keys
	static String[] foundKeys; // store the keys found in the matrix
	static boolean[][] traveled; //  to store traveled matrix
	static int collectedKeys=0; // keep track of number of keys found
	static int travel=-1; // how many steps taken
	// Assign sizes
	public static void assignKeys(int r, int c){
		traveled =new boolean[r][c];
		foundKeys=new String[r*c];

	}
	// function to find the starting point
	static int[] findStartingPoint(String[][] a, String c){
		// search for number of keys
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(isLowerCase(a[i][j])){ // letters in lower cases are keys
					keys++;
				}
			}
		}
		//searching starting point using binary search
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
			    if (a[i][j] == c) {
				   return new int[] { i, j }; // return the points where starting point is found
			    }
			}
		 }
		 return new int[] { -1, -1 }; // else return negative vertices 
		}
	
	// Check if loewrcase
	private static boolean isLowerCase(String string) {
		return Character.isLowerCase(string.charAt(0));
	}
	// check if uppercase
	private static boolean isUpperCase(String string) {
		return Character.isUpperCase(string.charAt(0));
	}
	// function to check lowercase else return required output
	static int doThis(int w,int e,int r,int c,String[][]A){
		travel++;
		// if it is a key
		if(isLowerCase(A[w][e])){
			collectedKeys++;
			foundKeys[collectedKeys]=A[w][e].toUpperCase();
			if(collectedKeys==keys){
				return travel;
			}
			return UniquePathHelper(w,e,r,c,A);
		}
		return UniquePathHelper(w,e,r,c,A);
	}
	// function to check uppercase else return required output
	static void firstDoThis(int i,int j,int r,int c,String[][]A){
		traveled[i][j]=true;
		if(isUpperCase(A[i][j])){
			for(int l=0;l<5;l++){
                    String st=foundKeys[l];
                    if(st==null){
					continue;
				}
				String v1=A[i][j];
				if(v1.equals(st)){
					doThis(i,j,r,c,A);
				}
			}
		}
		else{
			doThis(i,j,r,c,A);
		}
	}

	static int UniquePathHelper(int i, int j, int r, int c,String[][] A)
	{
		// boundary condition 
		if (i == r || j == c) {
		return 0;
		}
		// try catch to prevent ArrayIndexOutOfBoundsException
		// can travel to four directions checking the condition for all four directions
		try{
			if(i+1<r &&j<c&& A[i+1][j] != "#" && !traveled[i+1][j]){
				firstDoThis(i+1,j,r,c,A);
			}
		}
		catch(Exception e){

		}
		try{
			if(i<r &&j+1<c && A[i][j+1] != "#"  && !traveled[i][j+1]){
				firstDoThis(i,j+1,r,c,A);
			}
		}
		catch(Exception e){

		}
		try{
			if(i<r &&j-1<c && A[i][j-1] != "#" && !traveled[i][j-1]){
				firstDoThis(i,j-1,r,c,A);
			}
		}
		catch(Exception e){

		}
		try{
			if(i-1<r &&j<c && A[i-1][j] != "#" && !traveled[i-1][j]){
				firstDoThis(i-1,j,r,c,A);
			}
		}
		catch(Exception e){
			
		}
			
		// return negative value if not found
		return -99999;
	}

	static int uniquePathsWithObstacles(String[][] A)
	{	// get the starting point
		int[] array0 =findStartingPoint(A,"@");
		// length of row and column
		int r = A.length, c = A[0].length;
		// call function to assign array sizes
		assignKeys(r, c);
		// assign i and j
		int i=array0[0];
		int j=array0[1];
		// call the main function
		return UniquePathHelper(i, j, r, c, A);
	}

	// Driver Code
	public static void main(String[] args)
	{	week8 g=new week8();
		String[][] A = {
			{"@", "*", "a","*","#"},
			{"#", "#", "#","*","#"},
			{"b", "*", "A","*","B"}
		};
		uniquePathsWithObstacles(A);
		System.out.println("Travel:- "+travel);

	}
	}


