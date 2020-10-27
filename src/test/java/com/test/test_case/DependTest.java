package com.test.test_case;


import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 依赖测试
 */
public class DependTest {


    /**
     * test1 执行，然后test2执行。如果test1失败，则不执行test2
     */

    @Test
    public void test1() {
        System.out.println("test1 run");

        //
//        throw new RuntimeException("test1 exception");
//        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2() {
        /**
         * 此时单独运行test2 ，会先执行test1。
         * 如果test1 失败, test2会被忽略。
         *
         */

        System.out.println("test2 run");
    }
}
