package edu.mission;

public class Mission1 {

	public static void main(String[] args) {
		double xt = 1000;
		double t = 5.0 ;
		double a = -9.81;
		double v = 0.0;
		
		double fp = 0.0;
		fp = 0.5 * a * t*t + v*t + xt;
		
		//System.out.printf("%.2f초 후 위치 : %.2fm\n", t, fp);
		//System.out.printf(t + "초 후 위치 : "+ fp +"m");
		
//		for( t = 0; t <10; t++ ) {
//			fp = 0.5 * a * t*t + v*t + xt;
//			System.out.printf("%.1f초 후 위치 : %.1fm\n", t, fp);
//		}
		
		while(true) {
			fp = 0.5 * a * t*t + v*t + xt;
			if(fp<0.0) break;
			System.out.printf("%.1f초 후 위치 : %.1fm\n", t, fp);
			t += 0.5;
		}
	}
	
}
