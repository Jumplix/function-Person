
import Models.Employee;
import Models.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Chernoritky Ilya
 */
public class Main {
    public static void main(String[] args) throws IOException {

        ReadAndWrite readAndWrite = new ReadAndWrite();
        ArrayList<Employee> personArray;
        UtilsFunctions utilsFunctions;

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println();
            readAndWrite.readCounterWithFile();
            System.out.println();

            //Загрузить сотрудников
            if(Employee.counter != 0) {
                readAndWrite.readPersonWithFile(personArray = new ArrayList<>());
            } else{
                personArray = new ArrayList<>();
            }
            utilsFunctions = new UtilsFunctions(scanner,personArray);


            //Вызов основного меню
            System.out.println("Menu");
            System.out.println(
                            "1 - Информация о сотрудниках\n" +
                            "2 - Внести в базу сотрудника\n" +
                            "3 - Поиск сотрудников по ...\n" +
                            "4 - Сортировка сотрудников\n" +
                            "5 - Удалить сотрудника по id\n" +
                            "6 - Удалить всех сотрудников");

            switch (scanner.nextInt()) {
                case 1: // Models.Person info
                    utilsFunctions.personInfo();

                    break;
                case 2:// Add person
                    utilsFunctions.addPerson();

                    break;
                case 3://Search person
                    utilsFunctions.searchPerson();

                    break;
                case 4:
                    break;
                case 5://Remove person
                    utilsFunctions.removePerson();

                    break;
                case 6:// Remove All
                    personArray.removeAll(personArray);
                    Employee.counter = 0;

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
