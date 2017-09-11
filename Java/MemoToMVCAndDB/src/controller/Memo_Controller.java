package controller;

import java.util.ArrayList;

import dao.Memo_Dao;
import model.Memo;
import view.Memo_View;

public class Memo_Controller {
	private Memo_View mv;
	private Memo_Dao md;
	
	public Memo_Controller() {
		mv = new Memo_View();
		md = new Memo_Dao();
	}
	
	public void startMemo() {
		mv.startMemoView();
		checkInputControll();
	}
	
	private void checkInputControll() {
		while(true) {
			String input = mv.checkInputView();
			// �Է�
			if(input.equals("c")) {
				Memo memo = mv.insertAndReturnMemoView();
				md.insertMemoDao(memo);
			// ����
			}else if(input.equals("u")) {
				Memo memoUpdate = mv.updateAndReturnMemo_UpdateView();
				md.updateMemoDao(memoUpdate);
			// ����
			}else if(input.equals("d")) {
				String index = mv.deleteAndReturnIndexNumberView();
				md.deleteMemoDao(index);
			// �ϳ��� �� �б�
			}else if(input.equals("r")) {
				String index = mv.getReadIndexNumberView();
				Memo memo = md.getOneMemoDao(index);
				mv.showOneMemoView(memo);
			// ����Ʈ �̱�
			}else if(input.equals("l")) {
				ArrayList<Memo> memoList = md.getMemoListDao();
				mv.showMemoListView(memoList);
			// ������
			}else if(input.equals("exit")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			// �� ���� ��
			}else {
				System.out.println("���� ����� �־��ּ���.");
			}
		}
	}
}
