package account;

import java.util.Date;
import service.BankOperation;
/**
 * 
 * @author Tuan Hiep TRAN
 *
 */
public class Transaction {
	private Double currentBalance;
	private Double nextBalance;
	private Double value;
	private Date date;
	private BankOperation typeOperation;

	public Transaction(Double current, Double value, Date date, BankOperation typeOperation) {
		this.currentBalance = current;
		this.value = value;
		this.date = date;
		this.typeOperation = typeOperation;
	}

	public void operate() {

		switch (typeOperation) {
		
		case DEPOSIT:
			this.nextBalance = currentBalance + value;
			break;
		case WITHDRAW:
			this.nextBalance = currentBalance - value;
			break;
		default:
            throw new AssertionError("Unknown operation ");
		}
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BankOperation getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(BankOperation typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Double getNextBalance() {
		return nextBalance;
	}

	public void setNextBalance(Double nextBalance) {
		this.nextBalance = nextBalance;
	}

}
