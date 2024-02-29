package File_Comparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Text_file_comparator
{
    public void textFilecompare(String ActualFile ,String ExpectedFile) throws IOException
    {
        List<String>file1Line = readFile(ActualFile);// read line from file1
        List<String>file2Line = readFile(ExpectedFile);// read line from file2
        for(int i=0;i<file1Line.size();i++)
        {
            String line1 = file1Line.get(i);// current line of file1
            String line2 = file2Line.get(i);//current line of file2
            if(!line1.equals(line2))// line1 and line2 is not equal
            {
                String[] words1 = line1.split(" "); // split line1
                String[] words2 = line2.split(" "); //split line2

                for(int j=0;j<Math.min(words1.length,words2.length);j++ )// Math.min for  loop iterates up to the length of the shorter array
                {
                    if(!words1[j].equals(words2[j])) //if words are not equal
                    {
                        System.out.println(" Line " + (i+1) + " error in word : " + (j+1) + "("+ words1[j] + "," + words2[j] +")");
                    }
                }
            }
        }
    }
    public List<String>readFile(String filepath) throws IOException {
        List<String>liness = new ArrayList<>(); // list to store lines
        try
        {
            FileReader fileReader = new FileReader(filepath);// for reading the file
            BufferedReader bufferedreader = new BufferedReader(fileReader);
            String Line;// to storee lines
            while((Line= bufferedreader.readLine())!=null)//lines not equal to null
            {
                String [] line = Line.split("\\.");// split into sentence
                liness.addAll(Arrays.asList(line));// add sentence into list
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
      return liness;
    }

}
