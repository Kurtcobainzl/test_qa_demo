package com.test.listener;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

public class TestReport extends TestListenerAdapter {

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        System.out.println("onStart-----=======---------=========---------==========-----------===========-----------");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        System.out.println("onFinish-----=======---------=========---------==========-----------===========-----------");

    }
}
