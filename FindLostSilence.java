package tutorial;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Resource;

public class FindLostSilence {
	
	public static boolean IsNeighbourhood(QuerySolution currentQuerySolution, Double longitude, Double latitude) {
		
		// get the current longitude
		double currentLongitude = currentQuerySolution.get("y").asLiteral().getDouble();

		// get the current latitude
		double currentLatitude = currentQuerySolution.get("z").asLiteral().getDouble();
		
		if (( Math.abs(currentLongitude - longitude) <= 0.001 ) && (Math.abs(currentLatitude - latitude) <= 0.001)) {
			return true;
		}
		else 
			return false;
	} 
		
	public static void findLostSilence(ArrayList<QuerySolution> LostArrayList, ArrayList<Integer> Counter) {
		System.out.println(LostArrayList.size());	
		System.out.println("This is the start of findLostSilence");
		
		ResultSet TempResultSet = SparqlTest.runQuery();
		
		System.out.println("TempResultSet to String");
		System.out.println(TempResultSet.hasNext());
		
		double inListLongitude = 0.0;
		double inListLatitude = 0.0;
		int listPosition = 0;	// to mark the position in the array list

		for(; TempResultSet.hasNext(); ) {
			//System.out.println("for ResultSet hasNext");
			
			QuerySolution solution = TempResultSet.nextSolution();
			
			// for every QuerySolution in ResultSet, search from the beginning of the LostArrayList
			listPosition = 0;

			// to iterate the array list
			Iterator<QuerySolution> TempIterator = LostArrayList.iterator();
			while (TempIterator.hasNext()) {
				
				// get the QuerySolution in the array list
				QuerySolution inListQuerySolution = (QuerySolution) TempIterator.next();
				listPosition ++;

				// get the longitude, latitude information of current QuerySolution in the array list
				inListLongitude = inListQuerySolution.get("y").asLiteral().getDouble();
				inListLatitude = inListQuerySolution.get("z").asLiteral().getDouble();
				
				System.out.println(listPosition);
				
				if (IsNeighbourhood(solution, inListLongitude, inListLatitude )) {
					System.out.println("Node 1 is in the neighbourhood of Node 2");
					
					// Corresponding counter plus 1 
					Counter.set((listPosition - 1), (Counter.get(listPosition - 1)) + 1);
					
					// Send alert when there are more than 10 UEs get lost
					if (Counter.get(listPosition -1) >= 10) {
						System.out.println("Tragedy Suspect! More than 10 Users get lost! ");
						System.out.println("Node 1 Position: longitude:" + inListLongitude + "\t latitude:" + inListLatitude);
						System.out.println("Node 2 Position: longitude:" + solution.get("y").asLiteral().getDouble() + "\t latitude:" + solution.get("z").asLiteral().getDouble());
					}
					break;
				} else {
					listPosition = 0;
					continue;
				}
			}
			if (listPosition == 0) {
				System.out.println("if listPosition == 0");
				LostArrayList.add(solution);
				Counter.add(1);

			}
			
		}
		System.out.println("This is the end of findLostSilence");
		System.out.println(LostArrayList.size());
	}
}
