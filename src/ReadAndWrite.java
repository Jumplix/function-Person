import java.io.*;
import java.util.ArrayList;

/**
 * @author Chernoritsky Ilya
 */
public class ReadAndWrite {
    private final String PATH_WORKERS = "people.bin";
    private final String PATH_COUNTERS_WORKERS = "counter.bin";

    /**
     * Read counter with File
     */
    public void readCounterWithFile(){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_COUNTERS_WORKERS))) {
                Person.counter = ois.readInt();
                ois.close();
                if(Person.counter == 0){
                    System.out.println("Файл пустой");
                } else{
                    System.out.println("Количество сотрудников: " + Person.counter +
                            "\nЕсли вы хотите узнать информацию о загруженных сотрудниках, " +
                            "то выберите соответствующий пункт в меню");
                }
            } catch (IOException e) {
                System.out.println("Число из файла не типа long или файл пустой");
            }
    }

    /**
     * Write counter in File
     */
    public void writeCounterInFile(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_COUNTERS_WORKERS))) {
            oos.writeInt(Person.counter);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read objects with File
     */
    public ArrayList<Person> readPersonWithFile(ArrayList<Person> personArrayList) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_WORKERS))) {
                ArrayList<Person> personArrayListInFile = ((ArrayList<Person>) ois.readObject());
                for (int i = 0; i < Person.counter; i++){
                    personArrayList.add(personArrayListInFile.get(i));
                }

                ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personArrayList;
    }

    /**
     * Write objects in File
     * @param personArrayList
     */
    public void writePersonInFile(ArrayList<Person> personArrayList) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_WORKERS))) {
                oos.writeObject(personArrayList);
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
