/*
 * @author Jordan Kramer
 * CS 340 
 * John Matta
 * Main
 */
package cs340.sortable;

import java.util.*;
import java.io.*;

public class CS340Sortable {
    
    public static void main( String[] args ) {
        
        int fileSize = 0;
        char repeat = 'y';
        Scanner keyboard = new Scanner( System.in );
    
        while ( repeat != 'n' ) { // Allows user to continously read in files until they type 'n'
        
            System.out.println( "Enter the number of the file you would like to run. Ex: 1" );

            System.out.println( "(1)  Unsorted 15k    (11) Sorted 15k\n(2)  Unsorted 30k    (12) Sorted 30k\n"
                              + "(3)  Unsorted 45k    (13) Sorted 45k\n(4)  Unsorted 60k    (14) Sorted 60k\n"
                              + "(5)  Unsorted 75k    (15) Sorted 75k" );

            System.out.println( "(6)  Unsorted 90k    (16) Sorted 90k\n(7)  Unsorted 105k   (17) Sorted 105k\n"
                              + "(8)  Unsorted 120k   (18) Sorted 120k\n(9)  Unsorted 135k   (19) Sorted 135k\n"
                              + "(10) Unsorted 150k   (20) Sorted 150k" );

            System.out.print( "Enter a number: " );

            int fileNum = -1;
            String fileName = "";
            
            while( fileNum < 1 || fileNum > 20 ) { // User chooses a file
                fileNum = keyboard.nextInt();
                
                if ( fileNum < 0 || fileNum > 20 ) {
                    System.out.print( "The number you entered was invalid.\nEnter a number: " );
                }
            }

            switch ( fileNum ) { // Assigns file size and name

                case 1:
                    fileName = "Perm15K.txt";
                    fileSize = 15000;
                    break;
                case 2:
                    fileName = "Perm30K.txt";
                    fileSize = 30000;
                    break;
                case 3:
                    fileName = "Perm45K.txt";
                    fileSize = 45000;
                    break;
                case 4:
                    fileName = "Perm60K.txt";
                    fileSize = 60000;
                    break;
                case 5:
                    fileName = "Perm75K.txt";
                    fileSize = 75000;
                    break;
                case 6:
                    fileName = "Perm90K.txt";
                    fileSize = 90000;
                    break;    
                case 7:
                    fileName = "Perm105K.txt";
                    fileSize = 105000;
                    break;    
                case 8:
                    fileName = "Perm120K.txt";
                    fileSize = 120000;
                    break;    
                case 9:
                    fileName = "Perm135K.txt";
                    fileSize = 135000;
                    break;
                case 10:
                    fileName = "Perm150K.txt";
                    fileSize = 150000;
                    break;
                case 11:
                    fileName = "Sorted15K.txt";
                    fileSize = 15000;
                    break;
                case 12:
                    fileName = "Sorted30K.txt";
                    fileSize = 30000;
                    break;
                case 13:
                    fileName = "Sorted45K.txt";
                    fileSize = 45000;
                    break;
                case 14:
                    fileName = "Sorted60K.txt";
                    fileSize = 60000;
                    break;
                case 15:
                    fileName = "Sorted75K.txt";
                    fileSize = 75000;
                    break;
                case 16:
                    fileName = "Sorted90K.txt";
                    fileSize = 90000;
                    break;    
                case 17:
                    fileName = "Sorted105K.txt";
                    fileSize = 105000;
                    break;    
                case 18:
                    fileName = "Sorted120K.txt";
                    fileSize = 120000;
                    break;    
                case 19:
                    fileName = "Sorted135K.txt";
                    fileSize = 135000;
                    break;
                case 20:
                    fileName = "Sorted150K.txt";
                    fileSize = 150000;
                    break;     
            }

            Scanner inFile = null;
       
            try {
                inFile = new Scanner( new File( fileName ) );
            } catch ( FileNotFoundException e ) {
                System.err.println( "File not found." );
                return;
            }

            String [] array = new String[ fileSize ];
            int j = 0;

            while( inFile.hasNextLine() ) {
                array[ j ] = inFile.nextLine();
                j++;
            }

            System.out.println( "What type of sorting would you like?" );
            System.out.println( "(1) Insertion Sort   (2) Merge Sort   (3) Heap Sort" );
            
            int sortNum = -1; 

            while( sortNum < 1 || sortNum > 3 ) { // User chooses Sorting algorithm
                sortNum = keyboard.nextInt();
                
                if ( sortNum < 0 || sortNum > 3 ) {
                    System.out.print( "The number you entered was invalid.\nEnter a number: " );
                }   
            }
            
            PrintStream oFile = null;
            
            try { // Makes appropriate oFile Name
                if ( sortNum == 1 ) {
                    oFile = new PrintStream( new File( "IS_" + fileName ) );
                } else if ( sortNum == 2 ) {
                    oFile = new PrintStream( new File( "MS_" + fileName ) );
                } else {
                    oFile = new PrintStream( new File( "HS_" + fileName ) );
                }      
            } catch ( IOException e ) {
                System.err.println( "File not found." );
                return;
            }
               
            switch ( sortNum ) { // Runs the specified sort and prints to oFile

                case 1:
                    Sortable InsertionSort = new InsertionSort();
                    InsertionSort.sort( array );

                    for( int z = 0; z < array.length; z++ ) {
                    
                        oFile.println( array[ z ] );
                    }

                    break;
                case 2:
                    Sortable MergeSort = new MergeSort();
                    MergeSort.sort( array );

                    for( int z = 0; z < array.length; z++ ) {
                        oFile.println( array[ z ] );
                    }

                    break;
                case 3:
                    Sortable HeapSort = new HeapSort();
                    HeapSort.sort( array );

                    for( int z = 0; z < array.length; z++ ) {
                        oFile.println( array[ z ] );
                    }
                    break;
            }

            oFile.close(); // Closes current oFile to avoid memory leaks
            
            System.out.println( "Would you like to try another file? (y/n)" );
            repeat = keyboard.next().charAt( 0 );
        }
    }   
}
