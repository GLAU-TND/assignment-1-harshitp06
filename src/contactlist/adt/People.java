package contactlist.adt;

public class People {
    private String firstName;
    private String lastName;
    private String number;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMultiNumber(String number) {
        this.number = this.number+","+number;
    }

    public void setMultiEmail(String email) {
        this.email = this.email+","+email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
