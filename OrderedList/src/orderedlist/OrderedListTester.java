

package orderedlist;
/**
 Author: Kevin De Jesus
 File: OrderedListTester.java
 I affirm that this program is entirely my own work and none of it is the work 
 of any other person.
	__________Kevin De Jesus_________
	(your signature)
 */
import java.io.File;

import java.io.IOException;

import java.util.Scanner;

public class OrderedListTester {

    public static void main(String[] args) throws IOException {

        Scanner fileScan = new Scanner(new File("ordlist.txt"));

        OrderedList<Integer> ol = new OrderedList<Integer>();


        while(fileScan.hasNextLine()){

            String line = fileScan.nextLine().trim();

            if(line.isEmpty()){
                continue;
            }

            System.out.println(line);

            String[] instruction = line.split("\\s+");

            if(instruction[0].equalsIgnoreCase("INSERT"))

            ol.insert(Integer.parseInt(instruction[1]));

            else if(instruction[0].equalsIgnoreCase("DELETE")){   

                    if(!ol.delete(Integer.parseInt(instruction[1])))

                        System.out.println("Could not delete " + 
                                instruction[1]);

            }

            else if(instruction[0].equalsIgnoreCase("REVERSE"))

                ol.reverse();

            else if(instruction[0].equalsIgnoreCase("CLEAR"))

                ol.clear();

            else

                System.out.println("Command Invalid: " + instruction[0]);

                System.out.println("Current list : " + ol);

        }       

            fileScan.close();

    }
}