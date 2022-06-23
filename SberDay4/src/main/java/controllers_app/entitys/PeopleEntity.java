package controllers_app.entitys;

public class PeopleEntity {
    private String firstName;
    private String secondName;
    private String lastName;

    public PeopleEntity(){

    }

    public PeopleEntity(String firstName, String secondName, String lastName){
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
