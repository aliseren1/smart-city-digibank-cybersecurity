public class CryptoAdapter implements CryptoTarget {
	private BankingService bankingService;
	
	public CryptoAdapter(BankingService bs) {
		this.bankingService = bs;
}
	@Override
	public void sendCrypto(double amount, String currency) {
		//kripto parayı bankanın anladığı dile çevir
		double conversionRate = currency.equals("BTC")? 3728992 : 1;
		double fiatValue = amount * conversionRate;
		System.out.println(currency + "dönüştürüldü");
		bankingService.processFiatPayment(fiatValue);
	}
}