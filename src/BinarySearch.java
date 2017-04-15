import java.util.Arrays;

/**
 * 
 * @author Thiago
 *
 *	Binary search works on sorted arrays.
 *	Binary search begins by comparing the middle element of the array with the target value.
 *	If the target value matches the middle the element, its position in the array is returned.
 *	If the target value is less than the middle, the search continues in the lower half of the array.
 *	If the target value is bigger than the middle, the search continues in the upper half of the array.
 *
 */
public class BinarySearch {
	
	private int[] list;
	
	public BinarySearch(int[] list){
		
		Quicksort qs = new Quicksort();
		this.list = qs.sort(list);
		
	}
	
	public int find(int value){
		
		System.out.println(Arrays.toString(this.list));
		return this.search(value, this.list, 0, this.list.length -1);
	
	}
	
	private int search(int value, int[] sorted_list, int start, int end){
		
		int middle =(start+end)/2;
		
		if (sorted_list[middle] == value) {
			return middle;
		}
		
		/**
		 * If the middle value is less than the value, get the upper half of array
		 */
		if (sorted_list[middle] < value) {
			start = middle+1;
			return search(value, sorted_list, start, end);
		}

		/**
		 * If the middle is larger than the value, get the lower half of array
		 */
		if (sorted_list[middle] > value) {
			end = middle;
			return search(value, sorted_list, start, end);
		}
		
		return -1;//Not found
		
	}
	

}
