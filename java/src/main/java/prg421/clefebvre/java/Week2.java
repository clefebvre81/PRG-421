/**********************************************************************
 *	Program:	Week 2 Code Assignment
 * 	Purpose: 	Console/file input and output
 *	Programmer:	Chris Lefebvre
 *	Class:		PRG/421r13, Java Programming II
 *	Instructor:	ROLAND MORALES
 *	Creation Date:	6/18/18
 * 	Comments:  	Fill in code
 *
 ***********************************************************************/

package prg421.clefebvre.java;
import java.io.*;

public class Week2 {
    public static void main(String[] args) {

        // prompts and accepts user input
        InputStream istream;
        OutputStream ostream = null;
        int d;
        final int EOF = -1;
        istream = System.in;

        // accepts file input
        String fileName = "data.txt";                  // name of the file to open
        String line = null;                // will reference one line at a time

        try {
            FileReader fileReader =                 //  FileReader reads text file
                    new FileReader(fileName);             //   reads in data from the file

            // always wrap FileReader in BufferedReader  (to verify)
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            System.out.println("Here are the contents of the current file names " + fileName + ":\n");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }


        System.out.println("\nType here (Press Enter)(Ctrl+Shift+Del to End):");
        File outFile = new File("data.txt");

        // produces both console and file output
        try {                        // coding block to output data to file
            ostream = new FileOutputStream(outFile);    // output file name is data.txt
            while ((d = istream.read()) != EOF)
                ostream.write(d);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                istream.close();
                ostream.close();
            } catch (IOException e) {
                System.out.println("File did not close");
            }
        }
    }
}