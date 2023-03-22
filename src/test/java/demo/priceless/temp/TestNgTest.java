package demo.priceless.temp;
import org.testng.annotations.*;

/*
The following is the order for the execution of annotated methods.
@BeforeSuite
@BeforeTest
@BeforeClass
@BeforeMethod
@Test
@AfterMethod
@AfterClass
@AfterTest
@AfterSuite
 */
public class TestNgTest extends ParentClass {
    public TestNgTest(){
        System.out.println("test class inside constructor");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("testclass - inside beforeClass()");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("testclass - inside afterClass()");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("testclass - inside beforeMethod()");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("testclass - inside afterMethod()");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("testclass - inside beforeTest()");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("testclass - inside afterTest()");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("testclass - inside beforeSuite()");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("testclass - inside afterSuite()");
    }

    @Test
    public void test() {
        System.out.println("testclass - inside test()");
    }

}
class ParentClass {

    public ParentClass() {
        System.out.println("parentclass - inside constructor()");
    }

    @BeforeClass
    public void parentBeforeClass() {
        System.out.println("parentclass - inside beforeClass()");
    }

    @AfterClass
    public void parentAfterClass() {
        System.out.println("parentclass - inside afterClass()");
    }

    @BeforeMethod
    public void parentBeforeMethod() {
        System.out.println("parentclass - inside beforeMethod()");
    }

    @AfterMethod
    public void parentAfterMethod() {
        System.out.println("parentclass - inside afterMethod()");
    }

    @BeforeTest
    public void parentBeforeTest() {
        System.out.println("parentclass - inside beforeTest()");
    }

    @AfterTest
    public void parentAfterTest() {
        System.out.println("parentclass - inside afterTest()");
    }

    @BeforeSuite
    public void parentBeforeSuite() {
        System.out.println("parentclass - inside beforeSuite()");
    }

    @AfterSuite
    public void parentAfterSuite() {
        System.out.println("parentclass - inside afterSuite()");
    }

}