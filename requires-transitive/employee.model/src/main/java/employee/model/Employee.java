package employee.model;

/**
 * Created by hakan on 23/11/2017
 */
public class Employee {

    private int age;
    private String name;
    private String surname;
    private String address;

    public Employee(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "{" +
                "\"age\":" + age +
                ", \"name\":'" + name + '\'' +
                ", \"surname\":'" + surname + '\'' +
                ", \"address\":'" + address + '\'' +
                '}';
    }
}
