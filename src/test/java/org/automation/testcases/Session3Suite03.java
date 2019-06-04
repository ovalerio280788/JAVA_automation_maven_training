package org.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Session3Suite03 {

    @Test(description = "Test 01")
    public void test01(){
        Assert.assertTrue(false);
    }

    @Test(description = "Test 02", dependsOnMethods = {"test01"})
    public void test02(){

    }

    @Test(description = "Test 03", dependsOnMethods = {"test01"}, alwaysRun = true)
    public void test03(){

    }

    @Test(description = "Test 04")
    public void test04(){

    }
}
