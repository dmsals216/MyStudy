package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import model.Memo_Object;

public class Memo_View implements Memo_View_I{

	Scanner scanner = new Scanner(System.in);
	
	//처음 메인 화면을 띄워주고 String값을 받아 Controller에 반환해주는 화면
	@Override
	public String showMain() {
		
		System.out.println("=============명령어를 입력하세요=============");
		System.out.println("c : 쓰기, r : 읽기, u : 수정, d : 삭제, l : 목록, exit : 종료");
		System.out.println("=======================================");
		String input = scanner.nextLine();
		return input;
		
	}

	
	// 데이터를 입력시키기위한 입력 화면  ---- 입력 받은 값을 Memo_Object 객체에 넣고 그 값을 Controller에 반환해준다. 
	@Override
	public Memo_Object createList() {
		Memo_Object memo = new Memo_Object();
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		System.out.print("내용 : ");
		String content = scanner.nextLine();
		
		memo.setName(name);
		memo.setContent(content);
		
		return memo;
		
	}

	// Controller가 Model에서 받아온 Memo_Object값을 출력해준다.
	@Override
	public void readList(Memo_Object memo) {
		// TODO Auto-generated method stub
		System.out.println("NO : " + memo.getNo());
		System.out.println("Author : " + memo.getName());
		System.out.println("Content : " + memo.getContent());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		String formattedDate = sdf.format(memo.getDataTime());
		System.out.println("Date : " + formattedDate);
	}

	// 수정하는 데이터를 받아 Memo_Object에 값을 넣어 Controller에 반환해주는 화면
	@Override
	public Memo_Object updateList() {
		Memo_Object memo = new Memo_Object();
		System.out.print("내용 : ");
		String content = scanner.nextLine();
		
		memo.setContent(content);
		
		return memo;
	}

	// 다른 처리없이 그에 따른 출력물만 있는경우 popup을 띄워주는 화면
	@Override
	public void showPopUp(String input) {
		// TODO Auto-generated method stub
		if(input.equals("d")) {
			System.out.println("삭제되었습니다.");
		}else if(input.equals("exit")) {
			System.out.println("프로그램을 종료합니다.~~~~ Good Bye ~~~~~");
		}else {
			System.out.println("다른 값을 입력하셨습니다. 다시 입력해주세요~~");
		}
		
	}

	// Controller가 Model에서 받아온 ArrayList를 받아서 리스트를 뽑아주는 화면
	@Override
	public void printList(ArrayList<Memo_Object> memoList) {
		for(Memo_Object item : memoList) {
			System.out.print("NO : " + item.getNo());
			System.out.println("  |  Author : " + item.getNo());
		}
		
	}

	// 번호를 입력받아서 Controller로 반환해주는 화면
	// 하지만 int형을 받아야할 기능들이 많아 그것들을 하나로 합친 화면
	@Override
	public int inputString(String checkString) {
		System.out.print(checkString + "할 데이터의 번호 : ");
		int input = Integer.parseInt(scanner.nextLine());
		return input;
	}

}
