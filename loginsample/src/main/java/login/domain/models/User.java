package login.domain.models;

public class User {
    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private int id;
    private String email;
    private String password; // Should be hashed and secured
    private String role;

     public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

}

