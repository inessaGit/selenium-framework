package demo.priceless.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderFactory {

    @DataProvider( name = "createData" )
    public static Iterator<Object[]> createTestData() {

        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] { "Sam", 21 });
        list.add(new Object[] { "Smith", 22 });

        return list.iterator();
    }

}

 class TestClass {
    //If the test method and data provider are in different classes, use:
    @Test(dataProvider = "createData", dataProviderClass = DataProviderFactory.class)
    public void testMethod(String name, int age) {

    }
     @Test(dataProvider = "createData")
     public void testMethod2(String name, int age) {
     }
}
