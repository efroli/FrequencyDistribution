package ciic4020.project2.strategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

import ciic4020.project2.sortedlist.SortedList;
import ciic4020.project2.sortedlist.SortedArrayList;

/**
 * This class implements the SortedList strategy to count frequencies in an ArrayList.
 * @author Efrain Oliveras
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SortedListFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	/**
	 * Our SortedList classes require the data type to be Comparable.
	 * However, Map.Entry and AbstractMap.SimpleEntry are not Comparable,
	 * so we extend AbstractMap.SimpleEntry and create a Comparable
	 * version that we can use with our SortedList.
	 * Note: The K (key) of this class will be the E of SortedListFD,
	 *       so it will be Comparable.
	 * @author Juan O. Lopez
	 *
	 * @param <K>  The type of the key of each entry
	 * @param <V>  The type of the value of each entry
	 */
	@SuppressWarnings("serial")
	private static class ComparableEntry<K extends Comparable<K>, V>
			extends AbstractMap.SimpleEntry<K, V>
			implements Comparable<Map.Entry<K, V>> {

		public ComparableEntry(K key, V value) {
			super(key, value);
		}

		@Override
		public int compareTo(Map.Entry<K, V> entry) {
			/* Entries will be compared based on their keys, which are Comparable */
			return getKey().compareTo(entry.getKey());
		}
		
	} // End of ComparableEntry class

	/* Constructor */
	public SortedListFD() {
		super("SortedList");
	}

	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) 
	{
		
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>(); 
		SortedList<ComparableEntry<E, Integer>> sortedlist = new SortedArrayList<ComparableEntry<E, Integer>>(1000);
		
		/* TODO ADD YOUR CODE HERE */
		/* Instead of directly storing the entries in results, you will first store them in a SortedList.
		 * we can stop as soon as we find an object that is bigger (why?), 
		 * without needing to reach the end of the SortedList.
		 * Once you’ve finished counting, copy the frequencies to results.
		 * Note: Because you’ll be frequently traversing the list and accessing its elements, 
		 * you should use the SortedArrayList implementation for efficiency.
		 */
		for( E e: dataSet) 
		{ 
			
			boolean isEntryFound= false;
			for (int i = 0; i < sortedlist.size() && (sortedlist.get(i).getKey().compareTo(e)) <=0; i++)
			{
				//Allows keys and values from the sortedList comparable
				ComparableEntry<E, Integer> entry = sortedlist.get(i);	
				//if null break the loop. No need to iterate. 
				if(sortedlist.get(i).getKey() == null)
				{	break;	}
				
				else if(entry.getKey().equals(e))
				{	
					//if in list add the 1
					entry.setValue(entry.getValue()+1); 
					isEntryFound=true;	
					break;
				}	
			}
			//If entry not found or null, create a new entry
			if(!isEntryFound)
			{	
				ComparableEntry<E, Integer> newEntry = new ComparableEntry<E,Integer>(e, 1);
				sortedlist.add(newEntry);
			}
		
		} 
		
		//copy sortedList to results
		for (int i = 0; i < sortedlist.size(); i++)
		{	results.add(sortedlist.get(i));		}
		
		return results;
	}

}