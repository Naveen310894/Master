/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 7ravis
 */
public class SnackDaoImplTest {
    
    public SnackDaoImplTest() {
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
     * Test of getSnackById method, of class SnackDaoImpl.
     */
    @Test
    public void testGetSnackById() {
        SnackDaoImpl instance = new SnackDaoImpl();
        Snack snack = instance.getSnackById(1);
        assertTrue(snack != null);
        snack = instance.getSnackById(1000000);
        assertTrue(snack == null);
    }

    /**
     * Test of getSnacks method, of class SnackDaoImpl.
     */
    @Test
    public void testGetSnacks() {
        SnackDaoImpl instance = new SnackDaoImpl();
        List<Snack> snacks = instance.getSnacks();
        assertTrue(snacks.size() != 0);
    }
    
}
