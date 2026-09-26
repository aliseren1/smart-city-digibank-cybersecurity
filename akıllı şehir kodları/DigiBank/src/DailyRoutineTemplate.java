
public abstract class DailyRoutineTemplate {
	
	public final void runCycle() {
		checkSecurity();
		adjustCityLighting();
		System.out.println("Günlük rutin tamam");
	}
	
	protected abstract void checkSecurity();
	protected abstract void adjustCityLighting();
}
