import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIO {

    private final static String INPUT_FILENAME = "tourist.txt";
    public ArrayList<Integer> readFile() {
        ArrayList<Integer> days = new ArrayList<>();

        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileReader(INPUT_FILENAME));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(",");
                //convert to integers
                for (String item: items)  {
                    int value = Integer.parseInt(item);
                    days.add(value);
                }
            }
        }  catch (FileNotFoundException e) {
            System.out.print(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return days;
    }
}
