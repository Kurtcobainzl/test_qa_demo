package com.test.test_case;

import org.testng.annotations.Test;

/**
 * 异常测试
 */
public class ExceptionTest {


    @Test(priority = 1, expectedExceptions = RuntimeException.class)
    public void runTimeExpection() {

        /**
         * Method ExceptionTest.runTimeExpection()[pri:0, instance:com.test.test_case.ExceptionTest@7bb11784] should have thrown an exception of type class java.lang.RuntimeException
         */
        System.out.println("这是一个失败的异常测试");
    }

    @Test(priority = 2, expectedExceptions = RuntimeException.class)
    public void runTimeExpection2() {
        int a = 0;
        int b = 1 / a;

        //  throw new RuntimeException("抛出一个exception");

    }
}
