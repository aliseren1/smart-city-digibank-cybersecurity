public class Resident implements Observer {
	private String name;
	public Resident(String n) {
		this.name = n;
	}
	@Override
	public void update(String event) {
		System.out.println("Sakin [" + name + "] Mobil Bildirim: " + event);
	}
}
