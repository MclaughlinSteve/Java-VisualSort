import java.util.*;
/**
 * Write a description of class BubbleSorter here.
 * 
 * @author (Steve McLaughlin) 
 * @version (1.0)
 */
public class BubbleSorter<T> extends Sorter<T>
{


    /**
     * Constructor for objects of class BubbleSorter
     */
    public BubbleSorter()
    {

    }

    public void sort(List<T> items, Comparator<T> c)
    {
        int startPos = 0;
        int endPos = items.size()-1;
        while(startPos<endPos)
        {
            bubble(items, startPos, endPos, c);
            endPos--;
        }
    }
    
    private void bubble(List<T> items, int startPos, int endPos, Comparator<T> c)
    {
        while(startPos<endPos)    
        {if(c.compare(items.get(startPos),items.get(startPos+1))>0)
            {swap(items, startPos+1, startPos);}
            startPos++;
        }
        }
        

}




