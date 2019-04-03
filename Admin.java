public class Admin extends Moderator {
    //===============================constructors

    public Admin(String userName, String password) {
        super(userName, password);
    }

    public Admin() {
    }

    //===============================methods
    public void approve(APP a) {

    }

    public void deny(APP a) {

    }

    @Override
    public void deletePost(String comment) {
        super.deletePost(comment);
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
