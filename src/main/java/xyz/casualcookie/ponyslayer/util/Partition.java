package xyz.casualcookie.ponyslayer.util;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

/**
 * Based on google guavo partition.
 * Divides a list in several lists with specified size
 * @author mpinto
 *
 * @param <T>
 */
public class Partition<T> extends AbstractList<List<T>> {
	final List<T> list;
    final int size;

    public Partition(List<T> list, int size) {
        this.list = list;
        this.size = size;
      }
    
    public List<List<T>> getAll(){
    	List<List<T>> result = new LinkedList<>();
    	for(int index=0;index<size();index++) result.add(this.get(index));
		return result;
    	
    }
    
	@Override
	public List<T> get(int index) {
		if (index < 0 || index >= size()) {
		      throw new IndexOutOfBoundsException("Out of bounds"+index+ size());
		}
		int start = index * size;
    	int end = Math.min(start + size, list.size());
    	return list.subList(start, end);
	}

	@Override
	public int size() {
		return (int) Math.ceil(list.size()/(double)size);
	}
	
	@Override
    public boolean isEmpty() {
      return list.isEmpty();
    }

}

