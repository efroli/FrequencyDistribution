package ciic4020.project2.strategiesClasses;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * <b>MapFD</b> <br>
 * Hashtable class will be used as an implementation of the Map ADT.
 * A hastable object, initially empty, will be used in this approach.<br>
 * In the dataset there will be one entry for each different object.<br>
 * Each such entry will contain as its value the frequency of that object and its key.
 * <p>
 * The strategy processes each object from the dataset as follows:<br>
 * 
 * -The object itself is used as a key. If not found in the map, then a new entry is added to the map.
 * and the value associated will be 1.<br>
 * - If the object is found in the map (as the key of some entry... see containsKey and/or get method), 
 * then the associated entry is modified by increasing its current value by 1.<br>
 * -At the end, when all of the objects in the original dataset have been processed, 
 * the entries in the map are placed into the final list of entries (results).
 * 
 * @param dataSet is a ArrayList
 * @return results is a list of the entries once they are processed. 
 * @author efroli
 *
 **/
public class MapFD<E  extends Comparable<E>> extends AbstractFDStrategy<E> 
{

	public MapFD() 
	{	super("Map");	}

	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) 
	{
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>(); 
		Hashtable<E, Integer> hashtable = new Hashtable<E, Integer>();
	
		for(E entry: dataSet)
		{
				if(hashtable.containsKey(entry))
				{
					//The value can be retrieved by calling the get method with a key that is equal to the original key.
					//...(entry)+1 because returns the previous value. We want the value not previous. 
					hashtable.put(entry, hashtable.get(entry)+1); 
					
				}
				//Since not found, a new entry is created in hashtable.
				else
					hashtable.put(entry, 1);			
		}	
		//All entries are added into the results ArrayList
		results.addAll(hashtable.entrySet()); 
		
		return results;
	}

}
