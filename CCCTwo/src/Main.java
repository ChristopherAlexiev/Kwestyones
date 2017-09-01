import java.util.*;
public class Main {

	public static void main(String[] args) {
	
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		
		int[] tides = new int[n];
		for (int i = 0; i< n; i++){
			tides[i] = keyboard.nextInt();
		}
			Arrays.sort(tides);
		
		

		
		if (tides.length %2 == 0){
		
		
			int lowTide = tides[tides.length/2-1];
			
			int count = 0;
			
			int[] lows = new int[tides.length/2];
			count = 0;
			for (int i = 0; i< n; i++){
				if (tides[i] <= lowTide){
				lows[count] = tides[i];
				count++;
				}
				
			}
			
			int[] highs = new int[tides.length/2];
			count = 0;
			for (int i = 0; i < n; i++){
				if (tides[i] > lowTide){
					highs[count] = tides[i];
				count++;
				}
				
			}
			
			Arrays.sort(highs);
			Arrays.sort(lows);
			
			int countHigh=0;
			int countLow=0;
			for (int i = 0; i<n; i++){
				if (i%2==1){
					tides[i] = highs[countHigh];
					countHigh++;
				} else {
					tides[i] = lows[lows.length - 1 - countLow];
					countLow++;
				}
			}
			
			for (int i = 0; i<tides.length; i++){
				if (i != tides.length-1){
				System.out.print(tides[i]+ " ");
				} else {
					System.out.print(tides[i]);
				}
			}
			
		} else {////////////////////////////////////////////////////////////////
	
			
			int lowTide = tides[tides.length/2];
			
			int[] lows = new int[tides.length/2+1];
			int count = 0;
			for (int i = 0; i< n; i++){
				if (tides[i] <= lowTide){
				lows[count] = tides[i];
				count++;
				}
				
			}
			
			int[] highs = new int[tides.length/2];
			count = 0;
			for (int i = 1; i< n; i++){
				if (tides[i] > lowTide){
					highs[count] = tides[i];
				count++;
				}
				
			}
			
			Arrays.sort(highs);
			Arrays.sort(lows);
			
			int countHigh=0;
			int countLow=0;
			for (int i = 0; i<n; i++){
				if (i%2==1){
					tides[i] = highs[countHigh];
					countHigh++;
				} else {
					tides[i] = lows[lows.length- 1- countLow];
					countLow++;
				}
			}
			
			for (int i = 0; i<tides.length; i++){
				if (i != tides.length-1){
				System.out.print(tides[i]+ " ");
				} else {
					System.out.print(tides[i]);
				}
				
		}
		}
	
	
	
	
	
	
	}
}
