package Interface;

public class A implements InterfaceB{
	
	public static void main(String[] args) {
		
	}
	public void create() {
		ClassC c = new ClassC();
		c.d(this);
	}

	@Override
	public void c() {
		System.out.println("ssss");
	}
	
}
