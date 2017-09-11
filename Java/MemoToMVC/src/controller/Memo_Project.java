package controller;

import java.util.ArrayList;

import model.Memo_Model;
import model.Memo_Model_I;
import model.Memo_Object;
import view.Memo_View;
import view.Memo_View_I;

public class Memo_Project {
	
	// View�� �޸𸮿� �ø���.
	Memo_View_I view = new Memo_View();
	
	// Model�� �޸𸮿� �ø���.
	Memo_Model_I model = new Memo_Model();
	
	
	
	public static void main(String[] args) {
		
		// class�� �޸𸮿� �ø���.
		Memo_Project mp = new Memo_Project();
		
		while(true) {
			// ó�� ȭ���� View�� ����ְ� �Ʒ��� ���� String ���� �־��ش�.
			String input = mp.view.showMain();
			
			// �Է��ϱ�
			if(input.equals("c")) {
				// View�� crateList()�� ������� ȭ���� ����ְ� �Է¹��� ���� Memo_Object������ ������ ��´�.
				Memo_Object memo = mp.view.createList();
				// Memo_Object�� �ð����� Controller���� ������ ���ش�.
				memo.setDataTime(System.currentTimeMillis());
				// Memo_Object�� Model�� �־��ְ� Model������ �� Memo_Object�� Database�� ArrayList�� �ִ´�.
				mp.model.createList(memo);
				
			// �˻��ؼ� ����ϱ�
			}else if(input.equals("r")) {
				// Controller���� r�� �����Ǵ� "�˻�"�� View�� �־��ְ� int���� �޾ƿ´�.
				int input2 = mp.view.inputString("�˻�");
				// View���� ���� int���� Model�� �־� ArrayList���� ���� ��(Memo_Object)�� Memo_Object������ ������ �ִ´�.
				Memo_Object memo = mp.model.searchList(input2);
				// Model���� �޾ƿ� Memo_Object�� View�� ���� ����Ѵ�. 
				mp.view.readList(memo);
			
			// �����ϱ�
			}else if(input.equals("u")) {
				// Controller���� u�� �����Ǵ� "����"�� View�� �־��ְ� int���� �޾ƿ´�.
				int input2 = mp.view.inputString("����");
				// View���� ����ȭ���� ���� ������ �Ϸ��ϸ� Memo_Object���¸� �޴´�.
				Memo_Object memo = mp.view.updateList();
				// Controller���� ������ �ð��� �������ش�.
				memo.setDataTime(System.currentTimeMillis());
				// Model�� View���� �޾ƿ� int�� Memo_Object���¸� �Ѱ��ش�
				mp.model.updateList(input2, memo);
				
			// �����ϱ�
			}else if(input.equals("d")) {
				// Controller���� d�� �����Ǵ� "����"�� View�� �־��ְ� int���� �޾ƿ´�.
				int input2 = mp.view.inputString("����");
				// View���� �����ϰ� �;��ϴ� Memo�� Model���� ������ �Ѵ�.
				mp.model.deleteList(input2);
				// �˾��� ����ش�.
				mp.view.showPopUp(input);
				
			// ����Ʈ �̱�
			}else if(input.equals("l")) {
				// ********* ������ ArrayList != Database (�����ͺ��̽��� �ƴϴ�)
				ArrayList<Memo_Object> memoList = new ArrayList<>();
				// Model���� ����Ʈ�� ��� ������ ArrayList�� ��� �̾ƿ´�.
				memoList = mp.model.getList();
				// View�� ArrayList�� ���� ��� �̾Ƴ���.
				mp.view.printList(memoList);
				
			//������
			}else if(input.equals("exit")) {
				// �ʾ��� ����ش�.
				mp.view.showPopUp(input);
				break;
			}else {
				// �˾��� ����ش�.
				mp.view.showPopUp(input);
			}
		}
		
		
	}
}
