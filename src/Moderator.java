public class Moderator extends User {
    //===============================constructors

    public Moderator(String userName, String password) {
        super(userName, password);
    }

    public Moderator() {
    }

    //===============================methods
    public void deletePost(String comment) {

    }

    @Override
    public void request(APP a) {
        super.request(a);
    }

    @Override
    public boolean logIn(String userName, String password) {
        return super.logIn(userName, password);
    }

    @Override
    public boolean logOut() {
        return super.logOut();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
