/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 7ravis
 */
public class ChangeTest {
    
    public ChangeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getQuarters method, of class Change.
     */
    @Test
    public void testChangeCalculations() {
        Change change = new Change(new BigDecimal("3.19"));
        assertEquals("Number of quarters does not match expected result", 12, change.getQuarters());
        assertEquals("Number of dimes does not match expected result.", 1, change.getDimes());
        assertEquals("Number of nickels does not match expected result.", 1, change.getNickels());
        assertEquals("Number of pennies does not match expected result.", 4, change.getPennies());
    } 
}
