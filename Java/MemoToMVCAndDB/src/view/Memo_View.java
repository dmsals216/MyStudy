package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import model.Memo;

public class Memo_View {
	
	Scanner scanner = new Scanner(System.in);
	
	public void startMemoView() {
		System.out.println("프로그램을 시작합니다!!!!!");
	}
	
	public String checkInputView() {
		System.out.println("=============명령어를 입력하세요=============");
		System.out.println("c : 쓰기, r : 읽기, u : 수정, d : 삭제, l : 목록, exit : 종료");
		System.out.println("=======================================");
		String input = scanner.nextLine();
		return input;
	}
	
	public Memo insertAndReturnMemoView() {
		System.out.print("이름 : ");
		String author = scanner.nextLine();
		System.out.print("내용 : ");
		String content = scanner.nextLine();
		
		Memo memo = new Memo(author, content);
		return memo;
	}
	
	public Memo updateAndReturnMemo_UpdateView() {
		System.out.print("수정할 번호 : ");
		int index = Integer.parseInt(scanner.nextLine());
		System.out.print("수정할 이름 : ");
		String author = scanner.nextLine();
		System.out.print("수정할 내용 : ");
		String content = scanner.nextLine();
		
		Memo memoUpdate = new Memo(index, author, content);
		return memoUpdate;
		
	}
	
	public String deleteAndReturnIndexNumberView() {
		System.out.println("삭제할 번호 : ");
		String index = scanner.nextLine();
		return index;
	}
	
	public String getReadIndexNumberView() {
		System.out.println("출력할 번호 : ");
		String index = scanner.nextLine();
		return index;
	}
	
	public void showOneMemoView(Memo memo) {
		System.out.println("NO : " + memo.getIndex());
		System.out.println("Author : " + memo.getAuthor());
		System.out.println("Content : " + memo.getContent());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		String formattedDate = sdf.format(memo.getDatetime());
		System.out.println("Date : " + formattedDate);
	}
	
	public void showMemoListView(ArrayList<Memo> memoList) {
		for(Memo item : memoList) {
			System.out.print("NO : " + item.getIndex());
			System.out.println("  |  Author : " + item.getAuthor());
		}
	}
	
	
}
