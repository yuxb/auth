package com.auth.util;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yuxb on 6/25/16.
 */
public class AppTest {
    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void generateId() throws Exception {
        for (int i = 0; i <10 ; i++) {
            System.out.println( App.generateId());
        }
    }


}