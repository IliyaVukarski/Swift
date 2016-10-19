package Task1_School;

public class Classes {
	private int numberOfClass;
	private String className;
	
	public Classes(int numberOfClass, String className) {
		this.setClassName(className);
		this.setNumberOfClass(numberOfClass);
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getNumberOfClass() {
		return numberOfClass;
	}

	public void setNumberOfClass(int numberOfClass) {
		this.numberOfClass = numberOfClass;
	}
}
