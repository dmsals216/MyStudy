package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import model.Memo;

public class Memo_View {
	
	Scanner scanner = new Scanner(System.in);
	
	public void startMemoView() {
		System.out.println("���α׷��� �����մϴ�!!!!!");
	}
	
	public String checkInputView() {
		System.out.println("=============��ɾ �Է��ϼ���=============");
		System.out.println("c : ����, r : �б�, u : ����, d : ����, l : ���, exit : ����");
		System.out.println("=======================================");
		String input = scanner.nextLine();
		return input;
	}
	
	public Memo insertAndReturnMemoView() {
		System.out.print("�̸� : ");
		String author = scanner.nextLine();
		System.out.print("���� : ");
		String content = scanner.nextLine();
		
		Memo memo = new Memo(author, content);
		return memo;
	}
	
	public Memo updateAndReturnMemo_UpdateView() {
		System.out.print("������ ��ȣ : ");
		int index = Integer.parseInt(scanner.nextLine());
		System.out.print("������ �̸� : ");
		String author = scanner.nextLine();
		System.out.print("������ ���� : ");
		String content = scanner.nextLine();
		
		Memo memoUpdate = new Memo(index, author, content);
		return memoUpdate;
		
	}
	
	public String deleteAndReturnIndexNumberView() {
		System.out.println("������ ��ȣ : ");
		String index = scanner.nextLine();
		return index;
	}
	
	public String getReadIndexNumberView() {
		System.out.println("����� ��ȣ : ");
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
