package controller;

import java.util.ArrayList;

import model.Memo_Model;
import model.Memo_Model_I;
import model.Memo_Object;
import view.Memo_View;
import view.Memo_View_I;

public class Memo_Project {
	
	// View를 메모리에 올린다.
	Memo_View_I view = new Memo_View();
	
	// Model을 메모리에 올린다.
	Memo_Model_I model = new Memo_Model();
	
	
	
	public static void main(String[] args) {
		
		// class를 메모리에 올린다.
		Memo_Project mp = new Memo_Project();
		
		while(true) {
			// 처음 화면을 View로 띄워주고 아래와 비교할 String 값을 넣어준다.
			String input = mp.view.showMain();
			
			// 입력하기
			if(input.equals("c")) {
				// View의 crateList()를 실행시켜 화면을 띄워주고 입력받은 값을 Memo_Object형태의 변수에 담는다.
				Memo_Object memo = mp.view.createList();
				// Memo_Object에 시간값을 Controller에서 셋팅을 해준다.
				memo.setDataTime(System.currentTimeMillis());
				// Memo_Object를 Model로 넣어주고 Model에서는 이 Memo_Object를 Database인 ArrayList에 넣는다.
				mp.model.createList(memo);
				
			// 검색해서 출력하기
			}else if(input.equals("r")) {
				// Controller에서 r과 상응되는 "검색"을 View에 넣어주고 int값을 받아온다.
				int input2 = mp.view.inputString("검색");
				// View에서 받은 int값을 Model에 넣어 ArrayList에서 뺴온 값(Memo_Object)을 Memo_Object형태의 변수에 넣는다.
				Memo_Object memo = mp.model.searchList(input2);
				// Model에서 받아온 Memo_Object를 View에 보내 출력한다. 
				mp.view.readList(memo);
			
			// 수정하기
			}else if(input.equals("u")) {
				// Controller에서 u과 상응되는 "수정"을 View에 넣어주고 int값을 받아온다.
				int input2 = mp.view.inputString("수정");
				// View에서 수정화면을 띄우고 수정을 완료하면 Memo_Object형태를 받는다.
				Memo_Object memo = mp.view.updateList();
				// Controller에서 수정한 시간을 셋팅해준다.
				memo.setDataTime(System.currentTimeMillis());
				// Model에 View에서 받아온 int와 Memo_Object형태를 넘겨준다
				mp.model.updateList(input2, memo);
				
			// 삭제하기
			}else if(input.equals("d")) {
				// Controller에서 d과 상응되는 "삭제"을 View에 넣어주고 int값을 받아온다.
				int input2 = mp.view.inputString("삭제");
				// View에서 삭제하고 싶어하는 Memo를 Model에서 삭제를 한다.
				mp.model.deleteList(input2);
				// 팝업을 띄워준다.
				mp.view.showPopUp(input);
				
			// 리스트 뽑기
			}else if(input.equals("l")) {
				// ********* 여기의 ArrayList != Database (데이터베이스가 아니다)
				ArrayList<Memo_Object> memoList = new ArrayList<>();
				// Model에서 리스트를 모두 뽑은걸 ArrayList에 담아 뽑아온다.
				memoList = mp.model.getList();
				// View에 ArrayList를 보내 모두 뽑아낸다.
				mp.view.printList(memoList);
				
			//나가기
			}else if(input.equals("exit")) {
				// 팜업을 띄워준다.
				mp.view.showPopUp(input);
				break;
			}else {
				// 팝업을 띄워준다.
				mp.view.showPopUp(input);
			}
		}
		
		
	}
}
