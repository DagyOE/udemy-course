package sk.udemy.oop.person;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age >= 0 || age <= 100){
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean isTeen(){
        return (this.age > 12 && this.age < 20);
    }
}
