package model;

import java.util.ArrayList;

// *********** ArrayList == Database 
// Database�� model������ �����ؾ��Ѵ�

public class Memo_Model implements Memo_Model_I{

	// Database�� ������ �ϴ� ArrayList
	ArrayList<Memo_Object> memoList = new ArrayList<Memo_Object> ();

	// View���� �Է¹���  Memo_Object���¸� Controller���� �޾Ƽ�  ArrayList�� �ֱ�
	@Override
	public void createList(Memo_Object memo) {
		memo.setNo(memoList.size() + 1);
		memoList.add(memo);
	}

	// View���� �Է¹��� int ����  memo���� Controller���� �޾� ArrayList�� �ִ� �ش� memo�� ����
	@Override
	public void updateList(int number, Memo_Object memo) {
		memoList.get(number - 1).setContent(memo.getContent());
		memoList.get(number - 1).setDataTime(memo.getDataTime());

	}
	
	// View���� �Է¹��� int ���� Controller���� �޾� ArrayList���� memo�� ���� �� ArrayList�ȿ� �ִ� memo�� No���� ������
	@Override
	public void deleteList(int number) {
		memoList.remove(number - 1);
		for(int i = number - 1; i < memoList.size(); i++) {
			memoList.get(i).setNo(memoList.get(i).getNo() - 1);
		}
	}

	// ArrayList���� Controller�� ��ȯ���ش�.
	@Override
	public ArrayList<Memo_Object> getList() {
		return memoList;
	}

	// View���� �Է¹��� int ���� Controller���� �޾� ArrayList�� ���� ���� �� Controller�� ��ȯ
	@Override
	public Memo_Object searchList(int number) {
		return memoList.get(number - 1);
	}

}