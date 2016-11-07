# DinamArray
Class, which make dinamic array of int

@startuml

class MyList {
    private int array[];
    private int size=0;
    private int realsize=5;
    MyList()
    MyList(int el)
    MyList (int mas[])
    private void resize();
    public int getSize();
    public int get(int index);
    public void set(int index, int el);
    public void add(int el);
    public void delete(int index);
    public void insert (int index, int el);
    public void sortIncrease();
    public void sortDecrease();
    public static void main(String[] args);
    private Comparator increase =  new Comparator<Integer>();
    private Comparator decrease =  new Comparator<Integer>();
    private int partition (int[] array1, int start, int end, Comparator comparator);
    private void quicksort (int[] array, int start, int end, Comparator comparator);
    @Override
    public boolean equals (Object obj);
}

@enduml
