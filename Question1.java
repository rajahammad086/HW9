
/* Raja Hammad Mehmood
 Performs multiple timing tests for searching in the following collection 
classes:
 1. TreeSet
 2. HashSet
 3. HashMap
*/
import java.util.HashSet;
import java.util.HashMap;
import java.util.TreeSet;

public class Question1{
	public static void main(String[] args) {
		Long trials = 20000L;
		Long N = 30000L;
		long startTime, stopTime; // For recording start/stop times
		
		
		// ****************** TreeSet test ******************
	
		// Set up a sorted tree with N items
		TreeSet<Long> tree = new TreeSet<>();
		for (Long i = 1L; i <= N; i++)
			tree.add(i); // Add value and let TreeSet decide where to put it
		for (int x = 0; x < 6; x++) { // Test multiple searches for highest value (N)
			System.out.print("N = " + N + ": ");
			startTime = System.currentTimeMillis();
			for (Long i = 1L; i <= (trials + 1000000); i++)
				tree.contains(N);
			stopTime = System.currentTimeMillis();
			System.out.println("TreeSet time: " + (stopTime - startTime) + "milliseconds");
			for (Long i = N + 1; i <= N + 30000; i++)
				tree.add(i); // Add to end of list
			N += 30000;
		}
		

		// ****************** HashSet  test ******************
		N = 900000L;
			// Set up a HashSet with N items
			HashSet<Long> set = new HashSet<>();
			for (Long i = 1L; i <= N; i++)
				set.add(i); // Add value and let HashSet decide where to put it
			for (int x = 0; x < 6; x++) { // Test multiple searches for highest value (N)
				System.out.print("N = " + N + ": ");
				startTime = System.currentTimeMillis();
				for (Long i = 1L; i <= (trials + 20000000); i++)
					set.contains(N);
				stopTime = System.currentTimeMillis();
				System.out.println("HashSet time: " + (stopTime - startTime) + "milliseconds");
				for (Long i = N + 1; i <= N + 30000; i++)
					set.add(i); // Add to end of list
				N += 30000;
			}
			
			// ****************** HashMap  test ******************
			N = 900000L;
				// Set up a HashMap with N items
			HashMap<Long,Long> map= new HashMap<>();
				for (Long i = 1L; i <= N; i++)
					map.put(i,i); // Add values and let HashMap decide where to put it
				for (int x = 0; x < 6; x++) { // Test multiple searches for highest value (N)
					System.out.print("N = " + N + ": ");
					startTime = System.currentTimeMillis();
					for (Long i = 1L; i <= (trials + 20000000); i++)
						map.get(N);
					stopTime = System.currentTimeMillis();
					System.out.println("HashMap time: " + (stopTime - startTime) + "milliseconds");
					for (Long i = N + 1; i <= N + 30000; i++)
						set.add(i); // Add to end of list
					N += 30000;
				}
		
	}
}
