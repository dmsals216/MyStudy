package string;

public class LearnAboutString {
	public void text() {
		String a = "String Text";
		
		//����
		System.out.println(a.length());
		
		
		//��ġ�˻�
		System.out.println(a.indexOf("Text"));
		
		
		//Ư�� �����ڷ� ����
		String temp[] = a.split("/");
		for(String item : temp ) {
			System.out.println(item);
		}
		
		
		//���ڿ� �ڸ���
		System.out.println(a.substring(2, 7));
	}
	
}
