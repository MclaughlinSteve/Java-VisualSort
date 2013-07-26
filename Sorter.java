import java.util.*;
/**
 * Write a description of interface Sorter here.
 * 
 * @author (Steve McLaughlin) 
 * @version (1.0)
 */
public abstract class Sorter<T> extends Observable
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    public abstract void sort(List<T> items, Comparator<T> c);
    
    public void swap(List<T> items, int posOfSmallest, int startPos) 
    {
        T temp = items.get(posOfSmallest);
        T temp2 = items.get(startPos);
        items.remove(startPos);
        items.add(startPos, temp);
        items.remove(posOfSmallest);
        items.add(posOfSmallest, temp2);
        
        setChanged();
        notifyObservers( items );
        
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
         Thread.currentThread().interrupt();   
        }
        
    }
}
