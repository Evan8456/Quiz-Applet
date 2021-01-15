import java.util.*;
import java.io.*;
import javax.swing.*;
public class File2
/*
 * By : Evan NG
 * ICS4U0-D1
 * 323058826
 *
 * This program contains 4 methods, process(), SortINcreasing(),SortDecreasing(), and getArray(). It opens
 * my file full of questions, of which it prints
 * the questions and then prompts the user for their answer.
 */
{
    private static ArrayList <Questions>  array = new ArrayList();
    private static ArrayList <Questions>  array2 = new ArrayList();
    public File2()
    // Null constructor
    {

    }

    public static void process(String A)throws Exception
    {
        /*This method process creats a file reader and reads the file. 
         * This method reads my quiz file by using Scanner. The way it reads
         * my file is it uses deliminters to tell the end of each field. 
         * After reading my file, it stores it in a arraylist of objects.
         * it then reads the txt file that has been chosen by the user.
         * each field will be read into an temporary varibles where 
         * it will then be stored in an arraylist of objects.
         */
        //array = new ArrayList();
        try{
            FileReader reader = new FileReader(A);
            Scanner in = new Scanner(reader);

            in.useDelimiter(",");
            int i=0;

            while(in.hasNext())// main loop
            {     
                String q= in.next();
                String a = in.next();
                String b=in.next();
                String c= in.next();
                String d= in.next();
                String e= in.next();
                char ans = in.next().charAt(0);   
                int diff = Integer.parseInt(in.next().substring(0,1));
                array.add( new Questions (q,a,b,c,d,e,ans,diff));
                i++;
            }

            in.reset();
            in.close();
            reader.close();
        }
        catch (Exception e )
        {
            JOptionPane.showMessageDialog(null,"Please Choose a Compatible File","Error",JOptionPane.ERROR_MESSAGE); 
        }
    }

    public static void sortIncreasing(ArrayList<Questions> arr)
    {
        /*
         * this method will sort the arraylist of questions by accending order.
         */

        int minIndex;
        for (int i=0; i < arr.size()-1; i++)
        {
            //find smallest element in arr starting at location i
            minIndex = i;
            for (int j = i+1; j < arr.size(); j++)
            {
                if(arr.get(j).getDifficulty() < arr.get(minIndex).getDifficulty())
                {
                    minIndex = j;
                }
            }

            //swap arr.get(i).getDifficulty() with smallest element

            Questions temp = arr.get(i);
            arr.set(i, arr.get(minIndex));
            arr.set(minIndex, temp);
        }
    }

    public static void sortDecreasing(ArrayList<Questions> arr)
    {

        /*
         * this method will sort the arraylist of questions by decending order.
         */        

        int maxIndex;
        for (int i=0; i < arr.size()-1; i++)
        {
            //find smallest element in arr starting at location i
            maxIndex = i;
            for (int j = i+1; j < arr.size(); j++)
            {
                if(arr.get(j).getDifficulty() > arr.get(maxIndex).getDifficulty())
                {
                    maxIndex = j;
                }
            }

            //swap arr.get(i).getDifficulty() with smallest element

            Questions temp = arr.get(i);
            arr.set(i, arr.get(maxIndex));
            arr.set(maxIndex, temp);
        }
    }

    public static ArrayList<Questions>  getQuiz()
    {  //returns the arraylist
        array2= array;
        array =  new ArrayList();
        return array2;
    }

}