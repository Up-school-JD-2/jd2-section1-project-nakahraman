package movieLibrary;

public class RegularUser extends A_User {

	private static Long idGenerator = 1L;

	public RegularUser(String name, String email, String password) {

		super(idGenerator++, name, email, password);
	}

	@Override
	public void printPersonDetail() {

		System.out.println("Regular User ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println();
	}

	@Override
	public void signUp(String name, String email, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void signOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showMenu() {

		System.out.println("1. List Movies");
		System.out.println("2. Find Movie");
		System.out.println("3. List Directors");
		System.out.println("4. List Stars");

	}

}
