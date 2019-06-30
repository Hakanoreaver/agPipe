package FarmEd.beta.InformationPipeline.Models;

public class CreateRequest {
    String username;
    String password;
    String pin;

    public CreateRequest() {
        super();
    }

    public CreateRequest(String username, String password, String pin) {
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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
