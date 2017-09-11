package arrayList;

public class ListMain {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("String");
		System.out.println(list.get(0));
		list.clear();
		list.add("Clear");
		System.out.println(list.get(0));
	}
}

