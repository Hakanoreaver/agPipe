package FarmEd.beta.InformationPipeline.Models;

public class UserResponse {
    String username;
    String password;
    int pin;

    public UserResponse() {
        super();
    }

    public UserResponse(String username, String password, int pin) {
        this.username = username;
        this.password = password;
        this.pin = pin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
