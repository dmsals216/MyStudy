package model;

import java.util.ArrayList;

// *********** ArrayList == Database 
// Database는 model에서만 접근해야한다

public class Memo_Model implements Memo_Model_I{

	// Database의 역할을 하는 ArrayList
	ArrayList<Memo_Object> memoList = new ArrayList<Memo_Object> ();

	// View에서 입력받은  Memo_Object형태를 Controller에서 받아서  ArrayList에 넣기
	@Override
	public void createList(Memo_Object memo) {
		memo.setNo(memoList.size() + 1);
		memoList.add(memo);
	}

	// View에서 입력받은 int 값과  memo값을 Controller에서 받아 ArrayList에 있는 해당 memo를 수정
	@Override
	public void updateList(int number, Memo_Object memo) {
		memoList.get(number - 1).setContent(memo.getContent());
		memoList.get(number - 1).setDataTime(memo.getDataTime());

	}
	
	// View에서 입력받은 int 값을 Controller에서 받아 ArrayList안의 memo를 삭제 후 ArrayList안에 있는 memo의 No값을 재정의
	@Override
	public void deleteList(int number) {
		memoList.remove(number - 1);
		for(int i = number - 1; i < memoList.size(); i++) {
			memoList.get(i).setNo(memoList.get(i).getNo() - 1);
		}
	}

	// ArrayList값을 Controller에 반환해준다.
	@Override
	public ArrayList<Memo_Object> getList() {
		return memoList;
	}

	// View에서 입력받은 int 값을 Controller에서 받아 ArrayList의 값을 빼낸 후 Controller에 반환
	@Override
	public Memo_Object searchList(int number) {
		return memoList.get(number - 1);
	}

}