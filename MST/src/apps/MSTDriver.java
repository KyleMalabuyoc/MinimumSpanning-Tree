package apps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import structures.Graph;

public class MSTDriver
{
   public static void main(String[] args) throws IOException
   {
	   
	   Graph test1 = new Graph("graph1.txt");
		PartialTreeList list1 = MST.initialize(test1);
	        Iterator<PartialTree> iter = list1.iterator();
               while (iter.hasNext()) {
                PartialTree pt = iter.next();
                System.out.println(pt.toString());
               
               }
            
		System.out.println("-----------------------");
		Graph test2 = new Graph("graph2.txt");
		PartialTreeList list2 = MST.initialize(test2);
               iter = list2.iterator();
               while (iter.hasNext()) 
               {
                    PartialTree pt = iter.next();
                    System.out.println(pt.toString());
               }
            /*  System.out.println("-----------------------");
             System.out.println(list2.remove());
             System.out.println("-----------------------");
             iter = list2.iterator();
              while (iter.hasNext()) 
               {
                    PartialTree pt = iter.next();
                    System.out.println(pt.toString());
               }
             */
               System.out.println("-----------------------");
               System.out.println(MST.execute(list1));
               System.out.println("-----------------------");
               System.out.println(MST.execute(list2));

	
      
   }

}
