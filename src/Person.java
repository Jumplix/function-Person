import java.io.Serializable;

/**
 * @author Chernoritky Ilya
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -5964255265349940202L;
    public static int counter = 0;
    public int id;
    private String login;
    private String name;
    private String surname;
    private String password;
    private int age;

    public Person(String login, String name, String surname, String password, int age){
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.age = age;
        counter++;
        id = counter;
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

    @Override
    public String toString() {
        return "Id = " + id +
                "; Name = " + name +
                "; Surname = " + surname +
                "; Age = " + age;

    }
}
