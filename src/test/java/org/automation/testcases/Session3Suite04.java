package org.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Session3Suite04 {

    @Test(description = "Test 01", groups = {"grupo01"})
    public void test01(){
        Assert.assertTrue(false);
    }

    @Test(description = "Test 02", groups = {"grupo02"})
    public void test02(){

    }

    @Test(description = "Test 03", dependsOnGroups = {"grupo01", "grupo02"})
    public void test03(){

    }
}
