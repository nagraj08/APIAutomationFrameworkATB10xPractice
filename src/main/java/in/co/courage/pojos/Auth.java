package in.co.courage.pojos;

public class Auth {
    private String email;
    private String password;

    // Constructor
//    public Auth(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString Method for Debugging
    @Override
    public String toString() {
        return "Auth{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
