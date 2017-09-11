package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LearnAboutAnnotation {
	public static void main(String[] args) {
		UseAnnotation use = new UseAnnotation();
		String key = use.getClass().getAnnotation(CustomAnnotation.class).key();
		if(key.equals("Student")) {
			
		}
	}
}


// Target = 적용할 대상 : 생성자, 멤버변수, 타입(클래스), 파라미터, 메소드
// Retention = 애너테이션 정보의 유지단계 : 소스코드, 클래스, 런타임
// Documented = javadoc에 문서화되어져야하는 엘리먼트
// Inherited = 상송되는 애너테이션
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
	public String value() default "값";
	public String key();
}


@CustomAnnotation(key = "String")
class UseAnnotation {
	
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface GetConnection {
	public String url();
	public String id();
	public String pw();
}


class UseAnnotation2 {
	String key = "Student";
	
	@GetConnection(url = "주소", id = "아이디", pw = "비밀번호")
	public void process() {
		int a = 156;
		int b = 121312;
		int result = a + b / 1450;
		
		try {
			DriverManager.getConnection("주소", "아이디", "패스워드");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("result : " + result);
		String array[] = {"a", "b", "c"};
		for(String item : array) {
			System.out.println("내용은 " + item + "입니다.");
		}
		
	}
}