import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * A bar graph visualization of various sort methods
 * 
 * @author Steve McLaughlin
 * @version (1.0)
 */
public class BarGraphSortVisualizer extends JFrame implements Observer
{
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 400;
    private ArrayList<Integer> d;

    public BarGraphSortVisualizer()
    { 
        super ("Sort Visualizer");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        getContentPane().setBackground(Color.black);
        d = new ArrayList<Integer>();
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.black);
        
        int max_width = WINDOW_WIDTH/20;
        g.setColor(Color.magenta);
        

        int x, y;
        x = WINDOW_WIDTH/10;
        
        for(int i=0; i<d.size(); i++)
        {
            y = 2*d.get(i);
            g.fillRect(x,300-y,max_width,y);
            x+= (max_width*2);
        }

    }

    public void update (Observable observed, Object data )
    {
        d = (ArrayList<Integer>) data;
        repaint();
    }
    
        /**
     * main method called when user executes at the command prompt
     * java TextSortVisualizer
     */
    public static void main ( String args[] ) {
     
        // create a sorter and its comparator
        Sorter<Integer> sorter = new BubbleSorter<Integer> ( ); // the observed (observable) object
        
        Comparator<Integer> comp = new  Comparator<Integer>() {
            
            public int compare (Integer x, Integer y) {
                return ((int) x) - ((int) y);
            }
            
        };
        
        // create a visualizer that observes the sorter
        BarGraphSortVisualizer gVisualizer = new BarGraphSortVisualizer();
        sorter.addObserver ( gVisualizer);
        // create a list to be sorted
        ArrayList<Integer> list = new ArrayList<Integer>( ); 
        list.add ( 30 );
        list.add (15 );
        list.add(45);
        list.add (60);
        list.add ( 10);
        
        // invoke the sorter and watch the effects of the observing visualizer on the screen
        sorter.sort ( list, comp );
    } // main

}
