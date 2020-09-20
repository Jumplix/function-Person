package Models;

import java.io.Serializable;

/**
 * @author Chernoritsky Ilya
 */
public abstract class Person implements Serializable {
    private static final long serialVersionUID = -5964255265349940202L;
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname,int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName(){
        return name;
    };

    public String getSurname(){
        return surname;
    };

    public int getAge(){
        return age;
    };

    public abstract String displayPerson();
}
