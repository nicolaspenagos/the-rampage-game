package model;

import java.util.Comparator;

public class CustomDateComparator implements Comparator<PlayerScore> {

	@Override
	public int compare(PlayerScore py1, PlayerScore py2) {
		CustomDate cD1 = py1.getDate();
		CustomDate cD2 = py2.getDate();

		int year1 = cD1.getYear();
		int year2 = cD2.getYear();

		int month1 = cD1.getMonth();
		int month2 = cD2.getMonth();

		int day1 = cD1.getDay();
		int day2 = cD2.getDay();

		if (year1 > year2) {
			return 1;
		} else if (year1 == year2) {
			if (month1 > month2) {
				return 1;
			}else if(month1 == month2) {
				if(day1>day2) {
					return 1;
				}else if(day1==day2){
					return 0;
				}
			}
		}
		return -1;
	}

}
