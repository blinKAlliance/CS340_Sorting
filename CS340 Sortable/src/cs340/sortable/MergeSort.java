/*
 * @author Jordan Kramer
 * CS 340 
 * John Matta
 * Merge Sort
 */
package cs340.sortable;


public class MergeSort implements Sortable {
    
    public void sort( String [] array ) {
        long mergeTime = System.currentTimeMillis(); // Start Time for Merge Sort
        
        mergeSort( array, 0, array.length - 1 );
        
        System.out.println( "Time taken for Merge Sort: " + ( System.currentTimeMillis() - mergeTime ) + "ms" ); // End Time for Merge Sort
    }
    
    void merge( String [] array, int beginning, int middle, int end ) {
        int num1 = middle - beginning + 1;
        int num2 = end - middle;
        
        String L[] = new String [ num1 + 1 ]; // Temp Left array to store data
        String R[] = new String [ num2 + 1 ]; // Temp Right array to store data
        
        for ( int i = 0; i < num1; i++ ) {
            L[ i ] = array[ beginning + i ];
        }
        for ( int i = 0; i < num2; i++ ) {
            R[ i ] = array[ middle + i + 1 ];
        }
        
        int i = 0;
        int j = 0;
        L[ num1 ] = "zzzzzzzzzzzzz"; // Temp Left array
        R[ num2 ] = "zzzzzzzzzzzzz"; // Temp Right array z's serve as placeholder
        
        for( int k = beginning; k <= end; k++ ) { 
            
            if ( L[ i ].compareTo( R[j] ) <= 0 ) {
                array[ k ] = L[ i ];
                i++;
            } else {
                array[ k ] = R[ j ];
                j++;
            }
        }
    }
    
    void mergeSort( String [] array, int beginning, int end ) { 
        if ( beginning < end ) {
            int middle = ( beginning + end ) / 2;
            mergeSort( array, beginning, middle ); // Sorts front half
            mergeSort( array, middle + 1, end ); // Sorts back half
            merge( array, beginning, middle, end ); // Combines halves back sorted
        }
    }
}