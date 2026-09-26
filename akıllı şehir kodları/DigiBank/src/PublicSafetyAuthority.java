public class PublicSafetyAuthority implements Observer {
	@Override
	public void update(String event) {
		System.out.println("emniyet birimine '" + event + "' oalyı bildirildi.ekiplergeliyor ");
	}
}
