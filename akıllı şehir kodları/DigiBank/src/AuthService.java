
public class AuthService {
	
	public boolean validateMFA(String code) {
		System.out.println("güvenlik : mfa kontrol ediliyor...");
		return code.equals("123456");
	}
	public String quantumEncrypt(String data) {
		System.out.println("Güvenlik : kuantum şifreleme uygulandı");
		return "Q-" + data;
	}
}
