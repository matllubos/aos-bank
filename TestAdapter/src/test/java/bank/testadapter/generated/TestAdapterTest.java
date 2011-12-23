/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.testadapter.generated;

import client.ClientService;
import client.Client;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lubos
 */
public class TestAdapterTest {

    private static ClientService client = new Client().getClientPort();
    private static int accountId1 = -1;
    private static int accountId2 = -1;
    
    public TestAdapterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        java.lang.String name = "test";
        java.lang.String currency = "CZK";
        accountId1 = client.createAccount(name, currency);
        accountId2 = client.createAccount(name, currency);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    

    /**
     * Test of setUpAccount method, of class TestAdapter.
     */
    @Test
    public void testSetUpAccount() throws Exception {
        System.out.println("Test setUp");
        try {
            java.lang.String name = "test";
            java.lang.String currency = "CZK";
            int result = client.createAccount(name, currency);
            assertTrue(result > 0);
        } catch (Exception ex) {
            fail("Client not working");
        }

        try {
            java.lang.String name = "test";
            java.lang.String currency = "nejaka spatna mena";
            int result = client.createAccount(name, currency);
            fail("Client not working");
        } catch (Exception ex) {
            
        }


    }

    /**
     * Test of depositMoney method, of class TestAdapter.
     */
    @Test
    public void testDepositMoney() throws Exception {
        System.out.println("Test deposit");
         client.depositMoney(accountId1, new BigDecimal(1000), "CZK");
         
         BigDecimal result = client.getCurrentBalance(accountId1, "CZK");
         assertEquals(new BigDecimal(1000), result);
         
         try {
            client.depositMoney(accountId1, new BigDecimal(1000), "neexistující měna"); 
            fail("Client not check currency");
         }  catch (Exception ex) {
            
         }
         
         
         try {
            client.depositMoney(accountId1, new BigDecimal(-1000), "CZK"); 
            fail("Can deposit a negative number");
         }  catch (Exception ex) {
            
         }
         
         try {
            client.depositMoney(-1, new BigDecimal(1000), "CZK"); 
            fail("This account non exist");
         }  catch (Exception ex) {
            
         }
    }
    /**
     * Test of withdrawMoney method, of class TestAdapter.
     */
    @Test
    public void testWithdrawMoney() throws Exception {
        System.out.println("Test windraw");
        
        
        try {
            client.withdrawMoney(accountId1, new BigDecimal(-1000), "CZK"); 
            fail("Can winthdraw a negative number");
         }  catch (Exception ex) {
            
         }
         
         try {
            client.withdrawMoney(-1, new BigDecimal(1000), "CZK"); 
            fail("Can winthdraw a negative number");
         }  catch (Exception ex) {
            
         }
        
        try {
            client.withdrawMoney(accountId1, new BigDecimal(1000), "nějaká měna"); 
            fail("Client not check currency");
         }  catch (Exception ex) {
            
         }
        
        
        client.withdrawMoney(accountId1, new BigDecimal(1000), "CZK");
         
         BigDecimal result = client.getCurrentBalance(accountId1, "CZK");
         assertEquals(BigDecimal.ZERO, result);
         
         try {
            client.withdrawMoney(accountId1, new BigDecimal(1000), "CZK"); 
            fail("There is no money");
         }  catch (Exception ex) {
            
         }

    }

    /**
     * Test of transferMoney method, of class TestAdapter.
     */
    @Test
    public void testTransferMoney() throws Exception {
         try {
            client.transferMoney(-1, accountId2, "matllubo", new BigDecimal(1000), "CZK");
            fail("First account non exists");
         }  catch (Exception ex) {
            
         }
        
        try {
            client.transferMoney(accountId1, -1, "matllubo", new BigDecimal(1000), "CZK");
            fail("Second account non exists");
         }  catch (Exception ex) {
            
         }
        
        try {
            client.transferMoney(accountId1,accountId2, "matllubo", new BigDecimal(1000), "nějaka měna");
            fail("Client non check currency");
         }  catch (Exception ex) {
            
         }
        
        try {
            client.transferMoney(accountId1,accountId2, "matllubo", new BigDecimal(-1000), "CZK");
            fail("Negate number");
         }  catch (Exception ex) {
            
         }
        System.out.println("Test transfer money");
         client.depositMoney(accountId1, new BigDecimal(1000), "CZK");
         
         client.transferMoney(accountId1, accountId2, "matllubo", new BigDecimal(1000), "CZK");
         
         BigDecimal result1 = client.getCurrentBalance(accountId1, "CZK");
         assertEquals(BigDecimal.ZERO, result1);
         
         
         BigDecimal result2 = client.getCurrentBalance(accountId2, "CZK");
         assertEquals(new BigDecimal(1000), result2);
         
         try {
            client.transferMoney(accountId1,accountId2, "matllubo", new BigDecimal(1000), "CZK");
            fail("First client does not have money");
         }  catch (Exception ex) {
            
         }
    }


}
