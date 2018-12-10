/*
 * @author Jordan Kramer
 * CS 340 
 * John Matta
 * Insertion Sort
 */
package cs340.sortable;

public class InsertionSort implements Sortable {
      
    public void sort( String [] array ) {
        
       long insertionTime = System.currentTimeMillis(); // Start Time for Insertion Sort
       
        String key;
        int i;
        int j;
        
        for ( j = 1; j < array.length; j++ ) {
            key = array[ j ];
            i = j - 1;
            
            while ( i >= 0  && array[ i ].compareTo( key ) > 0 ) { // If string is > key, shifts that string infront on its current location 
                array[ i + 1 ] = array[ i ];
                i--;
            }
            array[ i + 1 ] = key;
        }   
        
        System.out.println( "Time taken for Insertion Sort: " + (System.currentTimeMillis() - insertionTime ) + "ms" ); // End Time for Insertion Sort
    }
}
