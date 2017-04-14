import java.util.ArrayList;

public class Quicksort {
	
	public void Quicksort(){
		
		
	}
	
	/**
	 * The quick sort works by partitioning 
	 * array so that smaller number are on the
	 *  left and the larger are on the right.
	 *  
	 */
	public int[] sort(int[] list) {
		int end = list.length -1;
		return partition(list, 0, end);
	}
	
	public int[] partition(int[] list, int lower, int higher){
		
		int left = lower;
		int right = higher;
		
		int pivot = list[right];
		
		while (left <= right) {
			
			//searching number which is greater than pivot
			while (list[left] < pivot) {
				left++;
			}
			
			//searching number which is less than pivot
			while (list[right] > pivot) {
				right--;
			}
			
			//Swap the values
			if (left <= right) {
				int tmp = list[left];
				list[left] = list[right];
				list[right] = tmp;
				
				left++;
				right--;
			}
		}
		
		if (lower < right) {
			partition(list, lower, right);
		}
		
		if (left < higher) {
			partition(list, left, higher);
		}
		
		return list;
	}
	
	
}
