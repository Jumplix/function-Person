import java.util.ArrayList;
import java.util.Scanner;

public class UtilsFunctions {
    private Scanner scanner;
    private ArrayList<Person> personArrayList;

    public UtilsFunctions(Scanner scanner, ArrayList<Person> personArrayList){
        this.scanner = scanner;
        this.personArrayList = personArrayList;
    }
    //Person info
    public void personInfo(){
        if(Person.counter != 0) {
            System.out.println("Сотрудников " + Person.counter + " :");
            for (int i = 0; i < Person.counter; i++) {
                System.out.println(personArrayList.get(i));
            }
        }else {
            System.out.println("Файл пустой");
        }
    }

    //Add person
    public void addPerson(){
        int number;

        System.out.print("Введите количество сотрудников, которых хотите внести в список:");
        number = scanner.nextInt();
        for(int i = 0; i < number; i++){
            String login;
            String name;
            String surname;
            String password;
            int age;

            System.out.println("Введите логин сотрудника:");
            login = scanner.next();
            System.out.println("Введите имя сотрудника:");
            name = scanner.next();
            System.out.println("Введите фамилию сотрудника:");
            surname = scanner.next();
            System.out.println("Введите пароль сотрудника:");
            password = scanner.next();
            System.out.println("Введите возраст сотрудника:");
            age = scanner.nextInt();
            System.out.println("Сотрудник добавлен!");

            Person person = new Person(login,name,surname,password,age);

            personArrayList.add(person);
        }
    }

    //Search person
    public void searchPerson(){
        String line;
        int number;
        System.out.println("1 - Поиск по имени\n" +
                "2 - Поиск по фамилии\n" +
                "3 - Поиск по возрасту");
        switch (scanner.nextInt()) {
            case 1: //Search name
                System.out.println("Введите имя работников по которому хотите начать поиск работников: ");
                line = scanner.next();
                for (int i = 0; i < Person.counter; i++) {
                    if (personArrayList.get(i).getName().equalsIgnoreCase(line)) {
                        System.out.println(personArrayList.get(i));
                    }
                }
                break;

            case 2: //Search surname
                System.out.println("Введите фамилию работников по которой хотите начать поиск работников: ");
                line = scanner.next();
                for (int i = 0; i < Person.counter; i++) {
                    if (personArrayList.get(i).getSurname().equalsIgnoreCase(line)) {
                        System.out.println(personArrayList.get(i));
                    }
                }
                break;
            case 3://Search age
                System.out.println("Введите возраст работников по которой хотите начать поиск работников: ");
                number = scanner.nextInt();
                for (int i = 0; i < Person.counter; i++) {
                    if (personArrayList.get(i).getAge() == number) {
                        System.out.println(personArrayList.get(i));
                    }
                }
                break;
        }
    }

    //Remove person
    public void removePerson(){
        int number;
        if(Person.counter != 0) {
            for (int i = 0; i < Person.counter; i++) {
                System.out.println(personArrayList.get(i));
            }
            System.out.println("Введите id сотрудника, которого хотите удалить из списка");
            number = scanner.nextInt();
            personArrayList.remove(number-1);
            Person.counter--;
            System.out.println("Сотрудник удален!");
            for (int i = number-1; i < Person.counter; i++){
                personArrayList.get(i).id--;
            }
        }else{
            System.out.println("Сотрудников нет");
        }
    }
}
