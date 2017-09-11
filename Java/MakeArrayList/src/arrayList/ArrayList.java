package arrayList;

public class ArrayList<T> {
	private int arrayLength;
	private Object[] value;
	
	public ArrayList() {
		arrayLength = 10;
		value = new Object[arrayLength];
	}
	
	public void add(T value) {
		int i = getI();
		if(i == arrayLength - 3) {
			arrayLength += 10;
			Object[] imsiValue = new Object[arrayLength];
			for(int j = 0; j < this.value.length; j++) {
				imsiValue[j] = this.value[j];
			}
			this.value = imsiValue;
		}
		
		this.value[i] = value;
	}
	
	public void add(int index, T value) {
		int i = getI();
		if(i == arrayLength - 3) {
			arrayLength += 10;
			Object[] imsiValue = new Object[arrayLength];
			for(int j = 0; j < this.value.length; j++) {
				imsiValue[j] = this.value[j];
			}
			this.value = imsiValue;
		}
		for(int index2 = this.value.length - 1; index <= index; index2--) {
			this.value[index2] = this.value[index2 - 1];
		}
		this.value[index] = value;
	}
	
	public T get(int index) {
		if(this.value[index] == null) {
			this.value[index].equals(null);
		}
		return (T) this.value[index];
	}
	
	public int size() {
		int i = getI();
		return i;
	}
	
	public T remove(int index) {
		int i = getI();
		T imsi = (T) value[index];
		for(int j = index; j < i - 1; j++) {
			value[j] = value[j + 1];
		}
		return imsi;
	}
	
	public void clear() {
		arrayLength = 10;
		value = new Object[arrayLength];
	}
	
	public int getI() {
		int i = 0;
		for(i = 0; i < arrayLength; i++) {
			if(this.value[i] == null) {
				break;
			}
		}
		return i;
	}
}
