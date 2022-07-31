package CourseWork;


class week2 {
	static int count=0;
	//recursion function to print desired output
	static void thenDoThis(int arr[], int length, int l, int index, int data[], int i)
	{
		// Current combination is ready to be printed,
		// print it
		
		if (index == l) {
			int sum=1;
			// finds product of n subsets of array
			for (int j = 0; j < l; j++)
				{
					sum=sum*data[j];
				}
			// searches for the product in the array
			for(int k=0;k<arr.length;k++){
				if(sum==arr[k] && sum!=0 && count==0){ // count to stop program if the product is found
					System.out.println(arr[k]);
					count++; 
				}
			}
			return;
		}

		// end function case
		if (i >= length)
			return;

		// location
		data[index] = arr[i];
		// gives a number to data[]
		thenDoThis(arr, length, l, index + 1, data, i + 1);

		// gives another number to data[]
		thenDoThis(arr, length, l, index, data, i + 1);
	}


	// creates a array and calls the recursive function
	static void doThis(int arr[], int length, int l)
	{

		int data[] = new int[l];

		// Print all combination using temporary
		thenDoThis(arr, length, l, 0, data, 0);
	}

	/* Driver function to check for above function */
	public static void main(String[] args)
	{
		int arr[] = { 10,10,5,0,2,1,2,5 };
		int l = 3;
		int length = arr.length;
		doThis(arr, length, l);
	}
}
