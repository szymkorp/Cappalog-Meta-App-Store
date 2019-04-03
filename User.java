public abstract class User {
    //===============================properties
    private String userName;
    private String password;

    //===============================constructors
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {
        this.userName = null;
        this.password = null;
    }

    //===============================methods
    public void request(APP a) {
        //default
    }

    public boolean logIn(String userName, String password) {
        //default
        return false;
    }

    public boolean logOut() {
        //default
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //===============================getter/setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
