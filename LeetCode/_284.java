import java.util.*;
class _284{
	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(1);
		Iterator<Integer> iterator = list.iterator();
		PeekingIterator peekingIterator = new PeekingIterator(iterator);
		System.out.println(peekingIterator.hasNext());
		System.out.println(peekingIterator.peek());
		System.out.println(peekingIterator.peek());
		System.out.println(peekingIterator.next());
		System.out.println(peekingIterator.peek());
		System.out.println(peekingIterator.next());
		System.out.println(peekingIterator.next());
		System.out.println(peekingIterator.hasNext());
		System.out.println(peekingIterator.peek());
	}		
}

class PeekingIterator implements Iterator<Integer> {

	private Integer peekNext;
	private Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    if(iterator.hasNext()) {
	    	peekNext = iterator.next();
	    }	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(peekNext == null)
        	throw new NoSuchElementException();
		return peekNext;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(peekNext == null) {
	    	throw new NoSuchElementException();
	    } 
	    Integer retVal = peekNext;
		peekNext = iterator.hasNext() ? iterator.next() : null;
    	return retVal;
	}

	@Override
	public boolean hasNext() {
	    return peekNext != null;
	}
}