package ex02;

public class Watch {

	private int hour;  // 0 ~ 23
	private int minute;  // 0 ~ 59
	private int second;  // 0 ~ 59
	
	public Watch(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public void addHour(int hour) {
		for(int i = 0; i <= hour; i++) {
			this.hour += 1;
		}
	}
	public void addMinute(int minute) {
		
	}
	public void addSecond(int second) {
		
	}
	public void see() {
		
	}
	
	
	
	
	
	
	
	
}
