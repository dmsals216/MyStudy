package model;

import java.util.ArrayList;

public interface Memo_Model_I {
	public void createList(Memo_Object memo);
	public ArrayList<Memo_Object> getList();
	public Memo_Object searchList(int number);
	public void updateList(int number, Memo_Object memo);
	public void deleteList(int number);
}
