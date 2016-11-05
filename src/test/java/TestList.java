import org.junit.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static junit.framework.Assert.*;

public class TestList {
    static MyList list;
    static int data[];
    @BeforeClass
    public static void defaultStart(){
        data = new int[500000];
        for (int i=0;i<500000;i++)
            data[i]=new Random().nextInt(i+100);
    }
    @Test
    public void test1add() {
        list = new MyList();
        System.out.println("Test of the method add: ");
        try {
            for (int i = 0; i < data.length; i++) {
                list.add(data[i]);
            }
            Assert.assertArrayEquals(data, list.toArray());
            System.out.println("Method works correct.");
        }
        catch (Exception e){
            System.out.println("Error in method add "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }
    @Test
    public void test2insert(){
        int index = 5347;
        int element = 789;
        list = new MyList(data);
        System.out.println("Test of the insert method. Try to insert "+element+" to the position "+index+" :");
        try {
            list.insert(index,element);
            Assert.assertEquals(element,list.get(index));
            System.out.println("Method works correct.");
        }
        catch (Exception e){
            System.out.println("Error in method insert "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }

    @Test
    public void test3delete(){
        list = new MyList(data);
        int indexDel=579;
        int element = list.get(indexDel);
        System.out.println("Test of the delete method. Try to delete "+indexDel+" element:");
        try {
            list.delete(indexDel);
            Assert.assertNotEquals(element,list.get(indexDel));
            System.out.println("Method works correct");
        }
        catch (Exception e){
            System.out.println("Error in method delete "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }

    @Test
    public  void test4sortIncrease(){
        list = new MyList(data);
        Arrays.sort(data);
        System.out.println("Test of the sort method. Compare data with automatic sort and sort from class");
        try {
            list.sortIncrease();
            Assert.assertArrayEquals(data, list.toArray());
            System.out.println("Method works correct.");
        }
        catch (Exception e){
            System.out.println("Error in method sort "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }

    @Test
    public  void test5sortDecrease(){
        for (int i=0;i<500000;i++)
            data[i]=new Random().nextInt(i+100);
        list = new MyList(data);
        Arrays.sort(data);
        int[] data2 = new int[data.length];
        int j=0;
        for (int i = data.length-1; i >=0;i--) {
            data2[j] = data[i];
            j++;
        }
        System.out.println("Test of the sort method. Compare data with automatic sort and sort from class");
        try {
            list.sortDecrease();
            Assert.assertArrayEquals(data2, list.toArray());
            System.out.println("Method works correct.");
        }
        catch (Exception e){
            System.out.println("Error in method sort "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }

    @Test
    public void test6equals(){
        System.out.println("Test the equals method. At first check the same arrays:");
        list = new MyList(data);
        MyList list2 = new MyList(data);
        try {
            if (list.equals(list2)) System.out.println("Arrays are the same. Method works correct.");
            System.out.println("Change one element in first array and check:");
            list.set(44, 32);
            if (!list.equals(list2)) System.out.println("Arrays are different. Method works correct.");
        }
        catch (Exception e){
            System.out.println("Error in equals method "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }
}
