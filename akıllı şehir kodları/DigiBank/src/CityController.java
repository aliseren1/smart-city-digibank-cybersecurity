import java.util.ArrayList;
import java.util.List;

public class CityController implements Subject{
	private static CityController instance;
	private List<Observer> observers = new ArrayList<>();
	private BankingService bankingService = new BankingService();
	
	private CityController() {
		System.out.println("Akıllı Şehir Sistemi Başlatıldı");
	}
	
	public static CityController getInstance() {
		if (instance == null) {
			instance = new CityController();
			}
		return instance;
	}
	
	@Override
	public void attach(Observer o) {
		observers.add(o);
		}
	@Override
	public void detach(Observer o) {
		observers.add(o);
		}
	@Override
	public void notifyObservers(String event) {
		for(Observer obs : observers) {
			obs.update(event);
		}
	}
	public void manageCity() {
		System.out.println("Altyapı Kontrol Ediliyor");
		//şüpheli durumda observeri uyar
		notifyObservers("SİSTEM UYARISI : Mahallede şüpheli hareket tespit edildi");
		bankingService.dynamicCountermeasure();
	}
	public BankingService getBankingService() {
		return bankingService;
		}
}
