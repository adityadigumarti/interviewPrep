package com.google.interviews.misc;

public class AngleCalculator {

	public static float calculateAngle(Time time) {
		float hourAngle = calculateHourAngle(time);
		float minuteAngle = calculateMinuteAngle(time.getMinutes());
		
		return (hourAngle - minuteAngle);
	}

	private static float calculateMinuteAngle(int minutes) {
		return minutes * 6;
	}

	private static float calculateHourAngle(Time time) {
		return (float) (30 * time.getHour()) + (time.getMinutes()/2.0f);
	}
	
	public static void main(String args[]) {
		Time time1 = new Time(7, 0);
		Time time2 = new Time(11, 20);
		Time time3 = new Time(10, 30);
		Time time4 = new Time(11, 20);
		Time time5 = new Time(3, 40);
		Time time6 = new Time(5, 15);
		Time time7 = new Time(8, 45);
		
		
		System.out.println(calculateAngle(time1));
		System.out.println(calculateAngle(time2));
		System.out.println(calculateAngle(time3));
		System.out.println(calculateAngle(time4));
		System.out.println(calculateAngle(time5));
		System.out.println(calculateAngle(time6));
		System.out.println(calculateAngle(time7));
	}

}
