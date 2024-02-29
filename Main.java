package File_Comparator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select type of file");
        System.out.println(" 0. exit : ");
        System.out.println(" 1. text file : ");
        System.out.println(" 2. csv file : ");
        int choice = sc.nextInt();
        //while (true)
           if(choice == 0)// if useer select 0 tehn return
           {
               return;
           }

        switch (choice)
        {
            case 1:
            {
                CompareTextFile(sc);// for compare text file
                break;
            }
            case 2:
            {
                CompareCsvFile(sc);// for compare csc file
                break;
            }
            default:
            {
                System.out.println(" make a valid choice ");// if user select any invalid choice
            }
        }

//C:/Users/HP/Desktop/AVI Software/CSV_file_handler/emp.csv  csvFile1
        //C:\Users\HP\Downloads
    }
    public static void CompareTextFile(Scanner sc) {
        System.out.println("Enter the path of actual file:");
        String actualFile = sc.next();// take actual path
        System.out.println("Enter the path of expected file:");
        String expectedFile = sc.next();// expected file

        Text_file_comparator textFileComparator = new Text_file_comparator();// create object of textfilecomparator

        try
        {
            textFileComparator.textFilecompare(actualFile, expectedFile);// compare actual file or expected file
            System.out.println("Files are equal.");
        }
        catch (IOException e) {
            System.out.println("Files are different.");
            e.printStackTrace(); // Print stack trace for debugging purposes
        }
    }
    // to compare csv file
    public static void  CompareCsvFile(Scanner sc)
    {
        System.out.println("Enter the path of actual file:");
        String actualFile = sc.next();// for actual path
        System.out.println("Enter the path of expected file:");
        String expectedFile = sc.next();// expected file
        // Get the current timestamp
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestampString = timestamp.format(formatter);

        // Append the timestamp to the result file name
        String resultFile = "C:/Users/HP/Desktop/result/result_" + timestampString + ".csv";
        CSV_File_Comparator csvFileComparator = new CSV_File_Comparator();
        try{
            boolean areEqual = csvFileComparator.compare_CSV_Files(actualFile,expectedFile);
            if(areEqual)
            {
                System.out.println("file are equal");
            }
            else
            {
                System.out.println("files are different " + "\n" + "changes are reflected on result file");
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}

