package view;

import java.util.ArrayList;

import model.Memo_Object;

public interface Memo_View_I {
	public String showMain();
	public Memo_Object createList();
	public void readList(Memo_Object memo);
	public Memo_Object updateList();
	public void showPopUp(String input);
	public void printList(ArrayList<Memo_Object> memoList);
	public int inputString(String checkString);
}
