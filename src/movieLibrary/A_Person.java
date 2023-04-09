package movieLibrary;

public abstract class A_Person {

	public Long id;
	public String name;

	public A_Person() {
		super();
	}

	public A_Person(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void printPersonDetail();

}
