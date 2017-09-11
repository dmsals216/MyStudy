package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import model.Memo_Object;

public class Memo_View implements Memo_View_I{

	Scanner scanner = new Scanner(System.in);
	
	//ó�� ���� ȭ���� ����ְ� String���� �޾� Controller�� ��ȯ���ִ� ȭ��
	@Override
	public String showMain() {
		
		System.out.println("=============��ɾ �Է��ϼ���=============");
		System.out.println("c : ����, r : �б�, u : ����, d : ����, l : ���, exit : ����");
		System.out.println("=======================================");
		String input = scanner.nextLine();
		return input;
		
	}

	
	// �����͸� �Է½�Ű������ �Է� ȭ��  ---- �Է� ���� ���� Memo_Object ��ü�� �ְ� �� ���� Controller�� ��ȯ���ش�. 
	@Override
	public Memo_Object createList() {
		Memo_Object memo = new Memo_Object();
		System.out.print("�̸� : ");
		String name = scanner.nextLine();
		System.out.print("���� : ");
		String content = scanner.nextLine();
		
		memo.setName(name);
		memo.setContent(content);
		
		return memo;
		
	}

	// Controller�� Model���� �޾ƿ� Memo_Object���� ������ش�.
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

	// �����ϴ� �����͸� �޾� Memo_Object�� ���� �־� Controller�� ��ȯ���ִ� ȭ��
	@Override
	public Memo_Object updateList() {
		Memo_Object memo = new Memo_Object();
		System.out.print("���� : ");
		String content = scanner.nextLine();
		
		memo.setContent(content);
		
		return memo;
	}

	// �ٸ� ó������ �׿� ���� ��¹��� �ִ°�� popup�� ����ִ� ȭ��
	@Override
	public void showPopUp(String input) {
		// TODO Auto-generated method stub
		if(input.equals("d")) {
			System.out.println("�����Ǿ����ϴ�.");
		}else if(input.equals("exit")) {
			System.out.println("���α׷��� �����մϴ�.~~~~ Good Bye ~~~~~");
		}else {
			System.out.println("�ٸ� ���� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���~~");
		}
		
	}

	// Controller�� Model���� �޾ƿ� ArrayList�� �޾Ƽ� ����Ʈ�� �̾��ִ� ȭ��
	@Override
	public void printList(ArrayList<Memo_Object> memoList) {
		for(Memo_Object item : memoList) {
			System.out.print("NO : " + item.getNo());
			System.out.println("  |  Author : " + item.getNo());
		}
		
	}

	// ��ȣ�� �Է¹޾Ƽ� Controller�� ��ȯ���ִ� ȭ��
	// ������ int���� �޾ƾ��� ��ɵ��� ���� �װ͵��� �ϳ��� ��ģ ȭ��
	@Override
	public int inputString(String checkString) {
		System.out.print(checkString + "�� �������� ��ȣ : ");
		int input = Integer.parseInt(scanner.nextLine());
		return input;
	}

}
