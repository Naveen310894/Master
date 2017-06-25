/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package service;

import java.math.BigDecimal;
import model.Snack;
import model.SnackDao;
import model.SnackDaoStubImpl;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 7ravis
 */
public class SnackServiceImplTest {
    
    public SnackServiceImplTest() {
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
     * Test of addMoney method, of class SnackServiceImpl.
     */
    @Test
    public void testAddMoney() {
        SnackDao dao = new SnackDaoStubImpl();
        SnackService instance = new SnackServiceImpl(dao);
        instance.setBalance(new BigDecimal("0.00"));
        instance.addMoney("dollar");
        assertEquals(instance.getBalance(), new BigDecimal("1.00"));
        instance.setBalance(new BigDecimal("0.00"));
        instance.addMoney("quarter");
        assertEquals(instance.getBalance(), new BigDecimal("0.25"));
        instance.setBalance(new BigDecimal("0.00"));
        instance.addMoney("dime");
        assertEquals(instance.getBalance(), new BigDecimal("0.10"));
        instance.setBalance(new BigDecimal("0.00"));
        instance.addMoney("nickel");
        assertEquals(instance.getBalance(), new BigDecimal("0.05"));
    }
    
    /**
     * Test of makePurchase method, of class SnackServiceImpl.
     */
    @Test
    public void testMakePurchase() {
        SnackDao dao = new SnackDaoStubImpl();
        SnackService instance = new SnackServiceImpl(dao);
        instance.setSelection(0);
        try {
            instance.makePurchase();
        } catch (NullPointerException e) {
            fail("Selection number = 0: caused NullPointerException.");
        }
        instance.setSelection(6);
        instance.makePurchase();
        assertEquals("Snack sold out: message does not match expected result.", instance.getMessage(), "SOLD OUT!!!");
        instance.setSelection(3);
        instance.setBalance(new BigDecimal("1.50"));
        instance.makePurchase();
        assertEquals("Insufficient funds: message does not match expected result.", instance.getMessage(), "Please Deposit: $0.60");
        Snack snack = dao.getSnackById(3);
        int startingQty = snack.getQuantity();
        instance.setSelection(3);
        instance.setBalance(new BigDecimal("3.29"));
        instance.makePurchase();
        assertEquals("Successful purchase: balance does not match expected result.", instance.getBalance(), new BigDecimal("0.00"));
        assertEquals("Successful purchase: message does not match expected result.", instance.getMessage(), "Thank You!!!");
        assertEquals("Successful purchase: snack quantity not decremeting.", startingQty - 1, snack.getQuantity());
        Change change = instance.getMyChange();
        assertEquals("Successful purchase: change quarters do not match expected quantity.", 4, change.getQuarters());
        assertEquals("Successful purchase: change dimes do not match expected quantity.", 1, change.getDimes());
        assertEquals("Successful purchase: change nickels do not match expected quantity.", 1, change.getNickels());
        assertEquals("Successful purchase: change pennies do not match expected quantity.", 4, change.getPennies());
    }
    
    /**
     * Test of changeReturn method, of class SnackServiceImpl.
     */
    @Test
    public void testChangeReturn() {
        SnackDao dao = new SnackDaoStubImpl();
        SnackService instance = new SnackServiceImpl(dao);
        instance.setSelection(4);
        instance.setMessage("test message");
        instance.setBalance(new BigDecimal("2.43"));
        instance.changeReturn();
        assertEquals("Balance not reset to 0.00", new BigDecimal("0.00"), instance.getBalance());
        assertEquals("Selection number not reset to 0", 0, instance.getSelection());
        assertEquals("Message not reset to null.", null, instance.getMessage());
        Change change = instance.getMyChange();
        assertEquals("Quarters do not match expected quantity.", 9, change.getQuarters());
        assertEquals("Dimes do not match expected quantity.", 1, change.getDimes());
        assertEquals("Nickels do not match expected quantity.", 1, change.getNickels());
        assertEquals("Pennies do not match expected quantity.", 3, change.getPennies());        
    }
    
}
