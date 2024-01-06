package in.podtest;

import org.testng.annotations.*;

public class AnnotationsDemo {

    @AfterSuite
    public void AS() {
        System.out.println("AS");
    }

    @AfterTest
    public void AT() {
        System.out.println("BT");
    }

    @AfterClass
    public void AC() {
        System.out.println("AC");
    }

    @AfterMethod
    public void AM() {
        System.out.println("AM");
    }

    @AfterMethod
    public void AM2() {
        System.out.println("AM");
    }

    @BeforeSuite
    public void BS() {
        System.out.println("BS");
    }

    @BeforeTest
    public void BT() {
        System.out.println("BT");
    }


    @BeforeClass
    public void BC() {
        System.out.println("BC");
    }

    @BeforeMethod
    public void BM() {
        System.out.println("BM");
    }
    @Test
    public void T1() {
        System.out.println("T1");
    }

    @Test
    public void T2() {
        System.out.println("T2");
    }


}
