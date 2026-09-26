
public class PaymentCommand implements Command {
	private BankingService service;
	private double amount;
	
	public PaymentCommand(BankingService s, double a) {
		this.service = s;
		this.amount = a;
	}
	@Override
	public void execute() {
			service.processFiatPayment(amount);
	}
}