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
			// 입력
			if(input.equals("c")) {
				Memo memo = mv.insertAndReturnMemoView();
				md.insertMemoDao(memo);
			// 수정
			}else if(input.equals("u")) {
				Memo memoUpdate = mv.updateAndReturnMemo_UpdateView();
				md.updateMemoDao(memoUpdate);
			// 삭제
			}else if(input.equals("d")) {
				String index = mv.deleteAndReturnIndexNumberView();
				md.deleteMemoDao(index);
			// 하나의 값 읽기
			}else if(input.equals("r")) {
				String index = mv.getReadIndexNumberView();
				Memo memo = md.getOneMemoDao(index);
				mv.showOneMemoView(memo);
			// 리스트 뽑기
			}else if(input.equals("l")) {
				ArrayList<Memo> memoList = md.getMemoListDao();
				mv.showMemoListView(memoList);
			// 나가기
			}else if(input.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			// 그 외의 값
			}else {
				System.out.println("값을 제대로 넣어주세요.");
			}
		}
	}
}
