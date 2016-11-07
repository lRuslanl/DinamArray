import netcracker.java.first.DecreaseComparator;
import netcracker.java.first.IncreaseComparator;
import netcracker.java.first.MyList;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class ComparatorTest {
    static int a,b;
    @BeforeClass
    public static void defaultStart(){
        a = 10;
        b = 5;
    }
    @Test
    public void testIncreaseComparator() {
        IncreaseComparator increaseComparator = new IncreaseComparator();
        System.out.println("Test of IncreaseComparator: compare numbers "+a+" and "+b+":");
        try {
            Assert.assertTrue(increaseComparator.compare(a,b)>0);
            Assert.assertTrue(increaseComparator.compare(a,10)==0);
            Assert.assertTrue(increaseComparator.compare(b,a)<0);
            System.out.println("All assertTrue are true -> comparator works correct");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }
    @Test
    public void testDecreaseComparator() {
        DecreaseComparator decreaseComparator = new DecreaseComparator();
        System.out.println("Test of DecreaseComparator: compare numbers "+a+" and "+b+":");
        try {
            Assert.assertTrue(decreaseComparator.compare(a,b)<0);
            Assert.assertTrue(decreaseComparator.compare(a,10)==0);
            Assert.assertTrue(decreaseComparator.compare(b,a)>0);
            System.out.println("All assertTrue are true -> comparator works correct");
        }
        catch (AssertionError e){
            System.out.println("AssertionError "+e.getLocalizedMessage());
            System.out.println("Method works incorrect.");
        }
    }
}
