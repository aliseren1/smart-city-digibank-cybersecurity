public class Main{
	public static void main(String[] args) {
		//1.singleton erişimi
		CityController city = CityController.getInstance();
		
		//2. yardımcı servis hazırlkanması
		AuthService auth = new AuthService();
		ThreatMonitor securityMonitor = new ThreatMonitor();
		CloudAnalyticsEngine cloudAI = new CloudAnalyticsEngine();
		
		//3. gözlemciler isisteme kaydedelim
		Resident sakinAli = new Resident("Ali");
		PublicSafetyAuthority emniyet = new PublicSafetyAuthority();
		
		city.attach(sakinAli);
		city.attach(emniyet);
		
		System.out.println("========================================");
		System.out.println("DIGIBANK SMART CITY GÜVENLİ GİRİŞ PANELİ");
		System.out.println("========================================");
		
		//4.GÜVENLİ GİRİŞ VE KUANTUM ŞİFRELEME SİMULASYONU
		if (auth.validateMFA("123456")) {
			System.out.println("Giriş Başarılı");
			String secretData = auth.quantumEncrypt("Kullanıcı Özel Verileri");
			System.out.println("Şifrelenmilş Durum : " + secretData);
		}
		System.out.println("\n--- GÜNLÜK ŞEHİR RUTİNİ BAŞLATILIYOR ---");
		
		//5. şehir rutinlerini çalıştıralım
		DailyRoutineTemplate morningRoutine = new LightingScheduleRoutine();
		morningRoutine.runCycle();
		
		System.out.println("\n--- SİSTEM DURUMU VE TEHDİT ANALİZİ ---");
		
		//6.SALDIRI TESPİTİ VE ŞEHİR YÖNETİMİ
		if(securityMonitor.detecDDoS()) {
			securityMonitor.triggerCountermeasure();
		}
		else {
			city.manageCity();
		}
		
		System.out.println("\n--- DİJİTAL BANKACILIK İŞLEMLERİ ---");
		
		//7. KRİPTO ÖDEME YAPALIM
		BankingService bank = city.getBankingService();
		CryptoTarget cryptoPayment = new CryptoAdapter(bank);
		cryptoPayment.sendCrypto(0.05, "BTC");
		
		//8. COMMAND İLE IŞIKLARIN YÖNETİMİ
		Command lightTurnOff = new LightingCommand("kapalı");
		lightTurnOff.execute();
		
		System.out.println("\n--- bulut ve yapay zeka analizi ---");
		
		//9.BULUT ANALİTİĞİNİ ÇALIŞTIRMA
		cloudAI.forecastTraffic();
		cloudAI.predictEenrgy();
		
		
		System.out.println("========================================");
		System.out.println("    SİSTEM GÜVENLİ VE ÇALIŞIR DURUMDA   ");
		System.out.println("========================================");
		
		
		
		
	}
}