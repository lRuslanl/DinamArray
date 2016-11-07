@startuml
interface Comparator{
}
Comparator <|-- IncreaseComparator

Comparator <|-- DecreaseComparator

class MyList<T> {
    private T array[];
    private int size=0;
    private int realsize=5;
    public MyList();

    public MyList(T el);

    public MyList (T mas[]);

    private void resize();
    public int getSize();

    public T get(int index);

    public void set(int index, T el);
    public void add(T el);

    public void delete(int index);
    public void insert (int index, T el);

    public void sort(Comparator comparator);

    private int partition (T[] array1, int start, int end, Comparator comparator);

    private void quicksort (T[] array, int start, int end, Comparator comparator);

    public T[] toArray();

    @Override
    public boolean equals (Object obj);

    public Iterator<T> iterator();

}

interface Iterable{
}
Iterable <|-- MyList
@enduml
