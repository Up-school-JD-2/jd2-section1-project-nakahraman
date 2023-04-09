package movieLibrary;

public interface I_User {

	public boolean signIn(String email, String password);

	public void signUp(String name, String email, String password);

	public void signOut();

	public void showMenu();

}
