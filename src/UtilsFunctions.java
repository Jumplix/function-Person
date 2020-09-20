import Models.Employee;
import Models.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class UtilsFunctions {
    private Scanner scanner;
    private ArrayList<Employee> personArrayList;

    public UtilsFunctions(Scanner scanner, ArrayList<Employee> personArrayList){
        this.scanner = scanner;
        this.personArrayList = personArrayList;
    }
    //Models.Person info
    public void personInfo(){
        if(Employee.counter != 0) {
            System.out.println("Сотрудников " + Employee.counter + " :");
            for (int i = 0; i < Employee.counter; i++) {
                System.out.println(personArrayList.get(i).displayPerson());
            }
        }else {
            System.out.println();
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

            Employee employee = new Employee(name,surname,age,login,password);

            personArrayList.add(employee);
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
                for (int i = 0; i < Employee.counter; i++) {
                    if (personArrayList.get(i).getName().equalsIgnoreCase(line)) {
                        System.out.println(personArrayList.get(i).displayPerson());
                    }
                }
                break;

            case 2: //Search surname
                System.out.println("Введите фамилию работников по которой хотите начать поиск работников: ");
                line = scanner.next();
                for (int i = 0; i < Employee.counter; i++) {
                    if (personArrayList.get(i).getSurname().equalsIgnoreCase(line)) {
                        System.out.println(personArrayList.get(i).displayPerson());
                    }
                }
                break;
            case 3://Search age
                System.out.println("Введите возраст работников по которой хотите начать поиск работников: ");
                number = scanner.nextInt();
                for (int i = 0; i < Employee.counter; i++) {
                    if (personArrayList.get(i).getAge() == number) {
                        System.out.println(personArrayList.get(i).displayPerson());
                    }
                }
                break;
        }
    }

    //Remove person
    public void removePerson(){
        int number;
        if(Employee.counter != 0) {
            for (int i = 0; i < Employee.counter; i++) {
                System.out.println("id " + personArrayList.get(i).id + "\n" + personArrayList.get(i).displayPerson());
            }
            System.out.println("Введите id сотрудника, которого хотите удалить из списка");
            number = scanner.nextInt();
            personArrayList.remove(number-1);
            Employee.counter--;
            System.out.println("Сотрудник удален!");
            for (int i = number-1; i < Employee.counter; i++){
                personArrayList.get(i).id--;
                }
        }else{
            System.out.println("Сотрудников нет");
        }
    }
}
