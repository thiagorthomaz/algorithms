import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("****************************************");
		System.out.println("Welcome to my 10 algorithm by heart.");
		System.out.println("****************************************");
		System.out.println("");
		
		
		int list[] = {24,1,45,20,56,75,2,56,99,53,12,100};
		BinarySearch bs = new BinarySearch(list);
		
		int found = bs.find(75);
		
		if (found >= 0) {
			System.out.println(list[found]);	
		} else {
			System.out.println("Not found.");
		}
		
		
		
		
		
		
		
		//menu();
		
	}
	
	private static void menu(){
		
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("MAIN MENU");
		System.out.println("");
		
		System.out.println("Select one option:");
		System.out.println("1 - Quicksort");
		
		int option = s.nextInt();
		
		switch (option) {
		case 1:
			System.out.println("Quicksort:");
			
			Quicksort qs = new Quicksort();
			int[] list = {24,2,45,20,56,75,2,56,99,53,12};
			int[] sorted_list = qs.sort(list);
			
			System.out.println("Before sorting: ");
			System.out.print(Arrays.toString(list));		
			System.out.println("");
			System.out.println("After sorting: ");
			System.out.print(Arrays.toString(sorted_list));
			
			break;

		default:
			System.out.println("Unknown option");
			System.out.println("");
			menu();
			break;
		}
		
		
		
		
	}

}
