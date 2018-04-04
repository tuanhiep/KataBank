package account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import org.junit.Test;
/**
 * 
 * @author Tuan Hiep TRAN
 *
 */
public class AccountTest {

	@Test
	public void should_return_the_balance_1000_because_i_deposit_1000() throws ParseException {
		Account account = new Account();
		assertEquals(0, account.getBalance(), 0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		account.deposit(1000.00, dateFormat.parse("01/04/2018"));
		assertEquals("The balance should be 1000 ",1000.0, account.getBalance(), 0);
	}

	@Test
	public void should_return_balance_17000_because_i_withdraw_3000_from_20000() throws ParseException {
		Account account = new Account();
		account.setBalance(20000.0);
		assertEquals(20000.0, account.getBalance(), 0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		account.withdraw(3000.00, dateFormat.parse("01/04/2018"));
		assertEquals("The balance should be 20000 - 3000 = 17000  ",17000.0, account.getBalance(), 0);
	}

	@SuppressWarnings("resource")
	@Test
	public void should_return_the_same_printed_statement_as_expected_statement() throws ParseException, IOException {
		Account account = new Account();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		account.deposit(1000.00, dateFormat.parse("01/04/2018"));
		account.deposit(2000.00, dateFormat.parse("02/04/2018"));
		account.withdraw(500.00, dateFormat.parse("30/04/2018"));
		Files.deleteIfExists(Paths.get("src/test/resources/account/statement.txt"));
		FileOutputStream output = new FileOutputStream("src/test/resources/account/statement.txt", true);
		PrintStream printer = new PrintStream(output);
		account.printStatement(printer);
		String printed = new Scanner(new File("src/test/resources/account/statement.txt")).useDelimiter("\\Z").next();
		String expected = new Scanner(new File("src/test/resources/account/statementExpected.txt")).useDelimiter("\\Z")
				.next();
		assertTrue("The printed statement should be the same as expected statement",expected.trim().equals(printed.trim()));

	}

}
