package math;

import java.util.Random;

public class LearnAboutMath {
	
	public void testMath() {
		
		//���� ���ϱ�
		System.out.println(Math.abs(-123));
		
		//�ݿø�
		System.out.println(Math.round(123.5));
		
		//�ø�
		System.out.println(Math.ceil(343.1543));
		
		//����
		System.out.println(Math.floor(563.8));
		
		
		//������ ��������
		System.out.println(Math.random());
		
		Random random = new Random();
		
		// 1 ~ 100������ ������ ���� ��������
		random.nextInt(100);
		int r = random.nextInt(100) + 1;
		
	}
	
}
