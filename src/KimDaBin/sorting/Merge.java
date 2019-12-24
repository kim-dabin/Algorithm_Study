package sorting;

public class Merge {
	
	private static int[] sorted; // 변경사항 잠시 저장 

	public static void merge(int[] arr, int l, int mid, int r) {
		int i = l;
		int j = mid+1;
		int idx = l;
		while(i<=mid&&j<=r) {
			if(arr[i] <= arr[j]) {
				sorted[idx] = arr[i];
				i++;
			}else {
				sorted[idx] = arr[j];
				j++;
			}
			idx++;
		}
		
		if(i>mid) {
			for(int k = j; k<=r ; k++) {
				sorted[idx] = arr[k];
				idx++;
			}
		}else {
			for(int k=i; k <=mid ; k++) {
				sorted[idx] = arr[k];
				idx++;
			}
		}
		
		//정렬한 배열 원본에 넣기 
		for(int k = l; k<=r; k++) {
			arr[k]=sorted[k];
		}
		
		
	}
	public static void mergeSort(int[] arr, int l, int r) {
		
		if(l<r) { //왼쪽이 오른쪽보다 작을 때 
			int mid = (l+r)/2; //중간 값 
			
			System.out.println(l+" "+mid+" "+r);
			mergeSort(arr, l, mid);//왼쪽 
			mergeSort(arr, mid+1, r);//오른쪽 
			merge(arr, l, mid, r);
			
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {10,6,3,7,1,21,3,7,99,11};
		sorted = new int[arr.length];
		mergeSort(arr, 0, arr.length-1);
		for(int a : arr) {
			System.out.print(a+" ");
		}
	}
}
