/*
 * @author Jordan Kramer
 * CS 340 
 * John Matta
 * Heap Sort
 */
package cs340.sortable;

public class HeapSort implements Sortable {
    
    @Override
    public void sort( String [] array ) {
        long buildTime = System.currentTimeMillis(); // Start Time for Build Heap
        int heapsize = array.length;
        
        for( int i = ( heapsize / 2 ) - 1; i >= 0; i-- ) { // Builds Heap
            heapify( array, heapsize - 1, i );
        }
        
        System.out.println("Time taken for Build Heap: " + (System.currentTimeMillis() - buildTime ) + "ms" ); // End Time for Build Heap
    
        long heapTime = System.currentTimeMillis(); // Start Time for Heapify
        
        for ( int i = array.length - 1; i >= 0; i-- ) { // Gets element from heap
            String tempArray = array[ 0 ];
            array [ 0 ] = array[ i ];
            array [ i ] = tempArray;
            
            heapify( array, i, 0 );
        }
        
        System.out.println( "Time taken for Heap Sort: " + ( System.currentTimeMillis() - heapTime ) + "ms\n" ); // End Time for Heapify
       
    }
    public void heapify( String [] array, int heapsize, int i ) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i; // Root
        
        if ( left < heapsize && ( array[ left ].compareTo( array[ i ] ) ) >= 0 ) { // Checks if left sub-node is larger than heap's root
            largest = left;
        }
        
        if ( right < heapsize && ( array[ right ].compareTo( array[ largest ] ) ) >= 0 ) { // Checks if right sub-node is larger than heap's root
            largest = right;
        }
        
        if ( largest != i ) { // Checks if Largest isn't actually the root
            
            String tempArray = array[ i ];
            array[ i ] = array[ largest ];
            array[ largest ] = tempArray;
            
            heapify( array, heapsize, largest ); // Recursive Call
        }
    }
}
