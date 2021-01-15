import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileChooser
/*
 * By: Evan NG
 * ICS4U0-D1
 * 323058826
 */
{
    private static String fileName;

    public static void chooseFile()
    { // creates a file chooser so the user can choose a file from his/her library.
      
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT Files", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            //System.out.println("You chose to open this file: " + chooser.getSelectedFile());
            fileName = chooser.getSelectedFile().getAbsolutePath();
        }
    }

    public static String getFile()
    /*
     * This method returns the File that the user has choosen.
     */
    {
        chooseFile();
        return fileName;
    }
}

