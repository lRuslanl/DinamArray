package netcracker.java.first;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<T> implements Iterable<T> {
    private T array[];
    private int size=0;
    private int realsize=5;
    public MyList(){
        array = (T[]) new Object[realsize];
    }

    public MyList(T el){
        size++;
        array = (T[]) new Object[realsize];
        array[size-1]=el;
    }

    public MyList (T mas[]){
        size=mas.length;
        realsize=size;
        array = (T[]) new Object[size];
        for (int i=0;i<size;i++)
        array[i]=mas[i];
    }

    private void resize(){
        if (size+1>realsize-1) {
            realsize = (size * 3) / 2 + 1;
            T array1[] =(T[]) new Object[realsize];
            for (int i = 0; i < array.length; i++)
                array1[i] = array[i];
            array = (T[]) new Object[realsize];
            array = array1;

        }
    }

    public int getSize(){
        return size;
    }

    public T get(int index)
    {
        if (index<0||index>size-1) throw new IndexOutOfBoundsException("error in index");
        else return array[index];
    }

    public void set(int index, T el){
        array[index] = el;
    }

    public void add(T el){
        resize();
        size++;
        array[size-1]=el;
    }

    public void delete(int index){
        if (index<0||index>size-1) throw new IndexOutOfBoundsException("error in index");
        size--;
        for(int i=index;i<size-1;i++)
            array[i]=array[i+1];
    }

    public void insert (int index, T el){
        if (index<0||index>size-1) throw new IndexOutOfBoundsException("eror in index");

        resize();
        size++;
        for(int i=size-1;i>index;i--)
            array[i]=array[i-1];
        array[index]=el;

    }

    public void sort(Comparator comparator){
        quicksort(array,0,size-1, comparator);
    }

    private int partition (T[] array1, int start, int end, Comparator comparator)
    {
        int marker = start;
        for ( int i = start; i <= end; i++ )
        {
            if ( comparator.compare( array1[i],array1[end])<=0 )
            {
                T temp = array1[marker]; // swap
                array1[marker] = array1[i];
                array1[i] = temp;
                marker += 1;
            }
        }
        return marker - 1;
    }

    private void quicksort (T[] array, int start, int end, Comparator comparator)
    {
        if ( start >= end )
        {
            return;
        }
        int pivot = partition (array, start, end, comparator);
        quicksort (array, start, pivot-1,comparator);
        quicksort (array, pivot+1, end,comparator);
    }

    public T[] toArray(){
        T[] array1= (T[]) new Object[size];
        for (int i=0;i<size;i++){
            array1[i]=array[i];
        }
        return array1;
    }

    @Override
    public boolean equals (Object obj){
        if (this == obj) return true;
        if (obj instanceof MyList){
            MyList list = (MyList) obj;
            if (this.size!=list.size) return false;
            else for (int i=0;i<this.size;i++)
                if (this.array[i]!=list.array[i]) return false;
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i =0;
            public boolean hasNext() {
                return size!=i;
            }
            public T next() {
                if (hasNext()){
                    return get(i++);
                }
                else throw new NoSuchElementException("No elements"+size);
            }
            public void remove() {
                delete(i);
                //if (i>size) i--;
            }
        };
    }

}