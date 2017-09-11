package math;

import java.util.Random;

public class LearnAboutMath {
	
	public void testMath() {
		
		//절댓값 구하기
		System.out.println(Math.abs(-123));
		
		//반올림
		System.out.println(Math.round(123.5));
		
		//올린
		System.out.println(Math.ceil(343.1543));
		
		//내림
		System.out.println(Math.floor(563.8));
		
		
		//랜덤값 가져오기
		System.out.println(Math.random());
		
		Random random = new Random();
		
		// 1 ~ 100사이의 랜덤한 숫자 가져오기
		random.nextInt(100);
		int r = random.nextInt(100) + 1;
		
	}
	
}
