import java.util.Comparator;

public class MyList {
    private int array[];
    private int size=0;
    private int realsize=5;
    MyList(){
        array = new int[realsize];
    }

    MyList(int el){
        size++;
        array=new int[realsize];
        array[size-1]=el;
    }

    MyList (int mas[]){
        size=mas.length;
        realsize=size;
        array=new int[size];
        for (int i=0;i<size;i++)
        array[i]=mas[i];
    }

    private void resize(){
        if (size+1>realsize-1) {
            realsize = (size * 3) / 2 + 1;
            int array1[] = new int[realsize];
            for (int i = 0; i < array.length; i++)
                array1[i] = array[i];
            array = new int[realsize];
            array = array1;

        }
    }

    public int getSize(){
        return size;
    }

    public int get(int index)
    {
        if (index<0||index>size-1) throw new IndexOutOfBoundsException("error in index");
        else return array[index];
    }

    public void set(int index, int el){
        array[index] = el;
    }

    public void add(int el){

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

    public void insert (int index, int el){
        if (index<0||index>size-1) throw new IndexOutOfBoundsException("eror in index");

        resize();
        size++;
        for(int i=size-1;i>index;i--)
            array[i]=array[i-1];
        array[index]=el;

    }

    public void sortIncrease(){
        quicksort(array,0,size-1, increase);
    }

    public void sortDecrease(){
        quicksort(array,0,size-1, decrease);
    }




    private Comparator increase =  new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };

    private Comparator decrease =  new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };

    private int partition (int[] array1, int start, int end, Comparator comparator)
    {
        int marker = start;
        for ( int i = start; i <= end; i++ )
        {
            if ( comparator.compare( array1[i],array1[end])<=0 )
            {
                int temp = array1[marker]; // swap
                array1[marker] = array1[i];
                array1[i] = temp;
                marker += 1;
            }
        }
        return marker - 1;
    }

    private void quicksort (int[] array, int start, int end, Comparator comparator)
    {
        if ( start >= end )
        {
            return;
        }
        int pivot = partition (array, start, end, comparator);
        quicksort (array, start, pivot-1,comparator);
        quicksort (array, pivot+1, end,comparator);
    }

    public int[] toArray(){
        int[] array1= new int[size];
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


}