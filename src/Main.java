
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Chernoritky Ilya
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String line;
        int number;

        ReadAndWrite readAndWrite = new ReadAndWrite();
        ArrayList<Person> personArray;


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            readAndWrite.readCounterWithFile();
            System.out.println();
            //Загрузить сотрудников
            readAndWrite.readPersonWithFile(personArray = new ArrayList<>());

            System.out.println("Menu");
            System.out.println(
                            "1 - Информация о сотрудниках\n" +
                            "2 - Внести в базу сотрудника\n" +
                            "3 - Поиск сотрудников по ...\n" +
                            "4 - Сортировка сотрудников\n" +
                            "5 - Удалить сотрудника по id\n" +
                            "6 - Удалить всех сотрудников");

            switch (scanner.nextInt()) {
                case 1: // Person info
                    if(Person.counter != 0) {
                        System.out.println("Сотрудников " + Person.counter + " :");
                        for (int i = 0; i < Person.counter; i++) {
                            System.out.println(personArray.get(i));
                        }
                    }else {
                        System.out.println("Файл пустой");
                    }
                    break;

                case 2:// Add person
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

                        personArray.add(person);
                    }
                    break;
                case 3://Search person
                    System.out.println("1 - Поиск по имени\n" +
                            "2 - Поиск по фамилии\n" +
                            "3 - Поиск по возрасту");
                    switch (scanner.nextInt()) {
                        case 1: //Search name
                            System.out.println("Введите имя работников по которому хотите начать поиск работников: ");
                            line = scanner.next();
                            for (int i = 0; i < Person.counter; i++) {
                                if (personArray.get(i).getName().equalsIgnoreCase(line)) {
                                    System.out.println(personArray.get(i));
                                }
                            }
                            break;

                        case 2: //Search surname
                            System.out.println("Введите фамилию работников по которой хотите начать поиск работников: ");
                            line = scanner.next();
                            for (int i = 0; i < Person.counter; i++) {
                                if (personArray.get(i).getSurname().equalsIgnoreCase(line)) {
                                    System.out.println(personArray.get(i));
                                }
                            }
                            break;
                        case 3://Search age
                            System.out.println("Введите возраст работников по которой хотите начать поиск работников: ");
                            number = scanner.nextInt();
                            for (int i = 0; i < Person.counter; i++) {
                                if (personArray.get(i).getAge() == number) {
                                    System.out.println(personArray.get(i));
                                }
                            }
                            break;
                    }
                    break;
                case 4:
                    break;
                case 5://Remove person
                    if(Person.counter != 0) {
                        for (int i = 0; i < Person.counter; i++) {
                            System.out.println(personArray.get(i));
                        }
                        System.out.println("Введите id сотрудника, которого хотите удалить из списка");
                        number = scanner.nextInt();
                        personArray.remove(number-1);
                        Person.counter--;
                        System.out.println("Сотрудник удален!");
                    }else{
                        System.out.println("Сотрудников нет");
                    }


                    break;
                case 6:// Remove All
                    personArray.removeAll(personArray);
                    Person.counter = 0;

                    break;
                default:
                    System.out.println("Такого варианта нет. Выберите вариант из представленного ниже");
            }

            // Save person array in File
            readAndWrite.writePersonInFile(personArray);
            readAndWrite.writeCounterInFile();

        }
    }
}
