import netcracker.java.first.DecreaseComparator;
import netcracker.java.first.IncreaseComparator;
import netcracker.java.first.MyList;
import org.junit.*;

import java.util.Arrays;
import java.util.Random;
import java.lang.*;
import java.util.Iterator;

public class TestList {
    static MyList list;
    static Integer data[];
    @BeforeClass
    public static void defaultStart(){
        data = new Integer[500000];
        for (int i=0;i<500000;i++)
            data[i]=new Random().nextInt(i+100);
    }
    @Test
    public void test1add() {
        list = new MyList();
        System.out.println("Test of the method add: add 500001 element to the end of the array ");
        try {
            for (int i = 0; i < data.length; i++) {
                list.add(data[i]);
            }
            Assert.assertArrayEquals(data, list.toArray());
            System.out.println("Method works correct.");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
        catch (Exception e){
            System.out.println("Error in method add "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }
    @Test
    public void test2insert() {
        int index = 5347;
        int element = 789;
        list = new MyList(data);
        System.out.println("Test of the insert method. Try to insert "+element+" to the position "+index+" :");
        try {
            list.insert(index,element);
            Assert.assertEquals(element,list.get(index));
            System.out.println("Method works correct.");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
        catch (Exception e){
            System.out.println("Error in method insert "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }

    @Test
    public void test3delete() {
        list = new MyList(data);
        int indexDel=579;
        Integer element = (Integer)list.get(indexDel);
        System.out.println("Test of the delete method. Try to delete "+indexDel+" element:");
        try {
            list.delete(indexDel);
            Assert.assertNotEquals(element,(Integer)list.get(indexDel));
            System.out.println("Method works correct");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
        catch (Exception e){
            System.out.println("Error in method delete "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }

    @Test
    public  void test4sortIncrease(){
        list = new MyList(data);
        Arrays.sort(data);
        System.out.println("Test of the sort method. Compare data with automatic sort and sort from class");
        try {
            list.sort(new IncreaseComparator());
            Assert.assertArrayEquals(data, list.toArray());
            System.out.println("Method works correct.");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
        catch (Exception e){
            System.out.println("Error in method sort "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }

    @Test
    public  void test5sortDecrease(){
        for (int i=0;i<500000;i++)
            data[i]=new Random().nextInt(i+100);
        list = new MyList(data);
        Arrays.sort(data);
        Integer[] data2 = new Integer[data.length];
        int j=0;
        for (int i = data.length-1; i >=0;i--) {
            data2[j] = data[i];
            j++;
        }
        System.out.println("Test of the sort method. Compare data with automatic sort and sort from class");
        try {
            list.sort(new DecreaseComparator());
            Assert.assertArrayEquals(data2, list.toArray());
            System.out.println("Method works correct.");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
        catch (Exception e){
            System.out.println("Error in method sort "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }

    @Test
    public void test6equals() {
        System.out.println("Test the equals method. At first check the same arrays with 500000 elements:");
        list = new MyList(data);
        MyList list2 = new MyList(data);
        try {
            if (list.equals(list2)) System.out.println("Arrays are the same. Method works correct.");
            System.out.println("Change one element in first array and check the difference:");
            list.set(44, 32);
            if (!list.equals(list2)) System.out.println("Arrays are different. Method works correct.");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
        catch (Exception e){
            System.out.println("Error in equals method "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }

    @Test
    public void test7Iterator(){
        System.out.println("Iterator test: Make array with 10 strings, then making 2 strings with iterator and for each." +
                " Then delete all elements using iterator and add one for check. If only one element in array Iterator remove works correct." +
                "Then if 2 strings are the same, iterator and for each works the same");
        MyList<String> array = new MyList<String>();
        Iterator<String> iterator = array.iterator();
        String text1="", text2="",text3="";
        for (int i = 0; i < 10; i++) {
            array.add("Line #" + i);
        }
        while (iterator.hasNext()){
            text1=text1+iterator.next();
        }
        for (String str : array) {
            text2=text2+str;
        }
        while (iterator.hasNext()){
            iterator.remove();
        }
        for (int i = 0; i < 10; i++) {
            text3=text3+array.get(i);
        }
        array.add("ShouldBeOneElement");
        int count=0;
        while (iterator.hasNext()) {
            count++;
            iterator.next();
        }
        if (count==1) System.out.println("Iterator remove works correct.");
        else System.out.println("Iterator remove works incorrect.");
        try {
            Assert.assertEquals(text1, text2);
            Assert.assertEquals(text2, text3);
            System.out.println("Iterator works correct.");
        }
        catch (AssertionError e) {
            System.out.println("AssertionError: " + e.getLocalizedMessage());
        }
    }
}
