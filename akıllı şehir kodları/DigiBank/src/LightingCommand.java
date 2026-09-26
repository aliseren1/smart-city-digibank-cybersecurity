public class LightingCommand implements Command{
	private String action;
	public LightingCommand(String action) {
		this.action = action;
	}
	@Override
	public void execute() {
		System.out.println("Işık Komutu : Sokak lambaları" + action + "yapıldı");
	}
}
