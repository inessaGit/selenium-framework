package demo.priceless.test.actions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

Configuration methods of the parent class will be called first and then the child class
if the test class is extending another class having configuration methods.
This parent hierarchy continues until the parent class is not in the Object class.
 */
public class TestTestng extends ParentClass {

	public TestTestng() {
		System.out.println("TestTestng class - inside constructor()");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("TestTestng - inside beforeClass()");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("TestTestng - inside afterClass()");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("TestTestng - inside beforeMethod()");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("TestTestng - inside afterMethod()");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("TestTestng - inside beforeTest()");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("TestTestng - inside afterTest()");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("TestTestng - inside beforeSuite()");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("TestTestng - inside afterSuite()");
	}

	@Test
	public void test() {
		System.out.println("TestTestng - inside test()");
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