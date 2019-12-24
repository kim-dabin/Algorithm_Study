package sorting;

public class MergeSort {
	
	private static int check = 0;
	private static int[] sorted;

	
	public static void merge(int[] arr, int l, int mid, int r) {
		int i = l;
		int j = mid+1;
		int k = l;
		
		while (i<=mid && j<=r) {
			if(arr[i] <= arr[j]) {
				sorted[k]= arr[i];
				i++;
			}else {
				sorted[k]=arr[j];
				j++;
			}
			k++;
		}
		
		if(i>mid) {
			for(int t = j; t <= r; t++) {
				sorted[k]= arr[t];
				k++;
			}
		}else {
			for(int t = i; t <= mid; t++) {
				sorted[k]= arr[t];
				k++;
			}
		}
		
		for(int t=l; t <= r; t++) {
			arr[t]= sorted[t];
		}
	check++;
		
	}
	
	public static void mergeSoring(int[] arr, int l, int r) {
		
		if(l<r) {
			int mid = (l+r)/2;
			
			mergeSoring(arr, l, mid);	
			mergeSoring(arr, mid+1, r);
			merge(arr, l, mid, r);
		}
	
	}
	
	public static void main(String[] args) {
		int arr[] = {10,6,3,7,1,21,3,7};
		
		sorted = new int[arr.length];
		mergeSoring(arr, 0, arr.length-1);
		for(int a: arr) {
			System.out.print(a+" ");
		}
		System.out.println();

		System.out.println(check);
	}

}
