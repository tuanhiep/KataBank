package service;


import static org.junit.Assert.assertEquals;

import java.util.Date;

import account.Account;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author Tuan Hiep TRAN
 *
 */
public final class ServiceStepdefs {

    private Account account = new Account();
    
    /**
     * i_deposit.
     *
     * @param deposit
     */
    @Given("^I deposit (\\d+) euros$")
    public void i_deposit(double credit) {
        account.deposit(credit, new Date());
    }
    
    /**
     * i_withdraw.
     *
     * @param deposit
     */
    @Given("^I withdraw (\\d+) euros$")
    public void i_withdraw(double credit) {
        account.withdraw(credit, new Date());
    }
    
    /**
     * i_print_the_statement.
     *
     */
    @When("^I print the statement$")
    public void i_print_the_statement() {
        account.printStatement(System.out);
    }
    
    /**
     * my_balance_should_be.
     *
     * @param expectedBalance
     */
    @Then("^My balance should be (-?\\d+)")
    public void my_balance_should_be(double expectedBalance) {
        assertEquals(expectedBalance, account.getBalance(), 0);
    }
    
}
