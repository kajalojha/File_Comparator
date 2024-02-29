package File_Comparator;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSV_File_Comparator
{
    public boolean compare_CSV_Files(String ActualFile, String ExpectedFile) throws IOException
    {

            File file1 = new File(ActualFile);//to pass the path of file in the File class contructor
            File file2 = new File(ExpectedFile);

            Scanner sc1 = new Scanner(new FileReader(file1));    //to scan the files using fileReader
            Scanner sc2 = new Scanner(new FileReader(file2));

            String line1, line2;
            boolean flag = true;    //Initially we treat the files as same
            int row=0;    //    to count the no. of rows
            int col;     //to count the no. of cols
            File output ;      //Declaring the output file if the files are not equal then the output will be written in this file
            FileWriter fileWriter = null;
            while (sc1.hasNextLine() && sc2.hasNextLine())
            {
                row++;
                line1 = sc1.nextLine();   // The current line of files are stored in the form of strings
                line2 = sc2.nextLine();
                String[] a1 = line1.split(","); //The on the basis of delimeter , we have splitted the strings into string arrays
                String[] a2 = line2.split(",");
                for (int i = 0; i < Math.min(a1.length, a2.length); i++) {
                    String s1 = a1[i];    //then we are putting every element of the arrays into s1 and s2
                    String s2 = a2[i];
                    col=i+1;
                    if (!s1.equals(s2)) {        //the comparison is done character by character
                        if(flag==true)           //if the flag is true this means the files are equal yet but now their words are not equal so initialize the output file to write the difference between the files
                        //as well as the flag will become false
                        {
                         //   output = new File("C:/Users/HP/Desktop/AVI Software/File_Comparator/resultfile.csv");
                            output = new File("C:/Users/HP/Desktop/result/resultant.csv");
                            fileWriter = new FileWriter(output);
                            fileWriter.append("(Row:" + row + "Col:" + col + ") : " + s1 + "------------- " + s2+"\n");
                        }
                        else                    //if the flag becomes false even if one time , then else will be executed every time when the strings will not be equal
                        {
                            fileWriter.append("(Row:" + row + "Col:" + col + ") : " + s1 + "------------- " + s2+"\n");
                        }
                        flag = false;
                    }
                }
            }
            sc1.close();
            sc2.close();
            if(fileWriter!=null)
            {
                fileWriter.close();
            }
            return flag;
        }
    }



