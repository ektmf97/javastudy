package practice03_Watch;

public class Watch {

	// 필드
		private int hour;  // 0 ~ 23
		private int minute;  // 0 ~ 59
		private int second;  // 0 ~ 59
		
		// 생성자
		public Watch(int hour, int minute, int second) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
			
		}


		// 메소드
		
		public void addHour(int hour) {
			for(int i = 1; i <= hour; i++) {
				this.hour += 1;
				if(this.hour == 24) {
					this.hour = 0;
				}
			}
			System.out.println(hour + "시간 후");
		}
		
		public void addMinute(int minute) {
			for(int i = 1; i <= minute; i++) {
				this.minute += 1;
				if(this.minute == 60) {
					this.hour++;
					this.minute = 0;
				}
			}
			System.out.println(minute + "분 후");
		}
		
		public void addSecond(int sceond)	{
			for(int i = 1; i <= sceond; i++) {
				this.second += 1;
				if(this.second == 60) {
					this.minute++;
					this.second = 0;
					if(this.minute == 60) {
						this.hour++;
						this.minute = 0;
						
					}
				}
			}
		System.out.println(second + "초 후");
		}
		/////
		
		public void see() {
			System.out.println(hour + "시 " +  minute + "분 " +  second + "초 ");
			
		}
		
}