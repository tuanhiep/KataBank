package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import account.Account;
/**
 * 
 * @author Tuan Hiep TRAN
 *
 */
public class Launch {

	public static void main(String[] args) throws ParseException {
		Account account = new Account();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		account.deposit(1000.00, dateFormat.parse("01/04/2018"));
		account.deposit(2000.00, dateFormat.parse("02/04/2018"));
		account.withdraw(500.00, dateFormat.parse("30/04/2018"));
		account.printStatement(System.out);
	}

}
