package com.mooc.meetingfilm.testng.demo;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.testng.demo
 * @description :
 **/
@Slf4j
public class HelloWorld {

    @Test
    public void test(){
        log.error("this is test!");
    }

    @Test
    public void test02(){
        log.error("this is test02!");
    }

    /**
     * 方法之前 每次都执行
     */
    @BeforeMethod
    public void beforemethod(){
        log.info("this is beforemethod test!");
    }

    /**
     * 方法之后 每次都执行
     */
    @AfterMethod
    public void aftermethod(){
        log.info("this is aftermethod test!");
    }

    @BeforeClass
    public void beforeclass(){
        log.info("this is beforeclass test!");
    }

    @AfterClass
    public void afterclass(){
        log.info("this is afterclass test!");
    }

    /**
     * 套件前置
     */
    @BeforeSuite
    public void beforesuite(){
        log.info("this is beforesuite test!");
    }

    /**
     * 套件后置
     */
    @AfterSuite
    public void aftersutie(){
        log.info("this is aftersutie test!");
    }

}
