
public class LightingScheduleRoutine extends DailyRoutineTemplate {
	@Override
	protected void checkSecurity() {
		System.out.println("Rutin : Güvenlik sensörleri taranıyor");
	}
	@Override
	protected void adjustCityLighting() {
		System.out.println("Rutin : Gün doğumu , ışıklar kapatılıyor");
	}
}
