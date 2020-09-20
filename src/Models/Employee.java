package Models;

public class Employee extends Person{
    public static int counter = 0;
    public int id;
    private String login;
    private String password;

    public Employee(String name, String surname, int age, String login, String password){
        super(name,surname,age);
        this.login = login;
        this.password = password;
        this.id = ++counter;
    }

    @Override
    public String displayPerson() {
        return "Имя " + getName() + "\n" +
            "Фамилия " + getSurname() + "\n" +
            "Возраст " + getAge();
    }
}
