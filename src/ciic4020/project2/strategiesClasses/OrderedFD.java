package ciic4020.project2.strategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

/**
 * <b>OrderedFD</b> <br>
 * Sort the dataset. Since it's a ArrayList, sort method will be used from the ArrayList class.<br> 
 * Specify null as the argument <b>verify the documentation if more doubts arise</b>.
 * <p>
 * The strategy processes each object from the dataset as follows:<br>
 * 
 * -Examine all objects in that sorted list, 
 * taking advantage of the fact that they are in order, to determine the frequency of each different object.
 * -For each different object in the dataset add an entry to the <b>results</b> ArrayList
 * (where an object is the key and its frequency is the value).<br> 
 * -The strategy receives a copy of the original dataset, so you are only sorting a copy of the dataset; 
 * the original one remains intact.
 * 
 * @param dataSet is a ArrayList
 * @return results is a list of the entries once they are processed. 
 * @author efroli
 *
 **/
public class OrderedFD<E  extends Comparable<E>> extends AbstractFDStrategy<E> 
{
	public OrderedFD() 
	{	super("Ordered");	}
	
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet)
	{
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>(); 
		//null argument allows the sort method (which its argument is a comparator) to work with all data types.
		dataSet.sort(null); 

		//The first elem of dataSate will be added streight away to the results ArrayList.
		//From the second elem on the comparisons will begin. 
		E elem = dataSet.get(0); 
		Map.Entry<E, Integer> entry = new AbstractMap.SimpleEntry<E,Integer>(elem,1); 
		results.add(entry);  
	
		for (int i = 1; i < dataSet.size(); i++) 
		{	
			if(elem.equals(dataSet.get(i)))
			{	entry.setValue(entry.getValue()+1);	}
			//if no repetition change new entry
			else
			{ 
				entry= new AbstractMap.SimpleEntry<E,Integer>(dataSet.get(i),1);  
				elem= dataSet.get(i);	
				results.add(entry);	
			}	
		}
		
		return results;
	}	
}
	