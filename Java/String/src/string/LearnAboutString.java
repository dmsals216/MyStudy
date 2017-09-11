package string;

public class LearnAboutString {
	public void text() {
		String a = "String Text";
		
		//길이
		System.out.println(a.length());
		
		
		//위치검색
		System.out.println(a.indexOf("Text"));
		
		
		//특정 구분자로 분해
		String temp[] = a.split("/");
		for(String item : temp ) {
			System.out.println(item);
		}
		
		
		//문자열 자르기
		System.out.println(a.substring(2, 7));
	}
	
}
