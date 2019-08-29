import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Competition {
    private static String STOP = "stop";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File file = new File("stats.csv");
        try {
            file.createNewFile();
            List<Participant> participants = new ArrayList<>();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bfw = new BufferedWriter(fw);
            loadWriteAndSort(input, participants, bfw);
            System.out.println("Dane posortowane i zapisano do pliku stats.csv .");
        } catch (IOException ex) {
            System.out.println("Nie udało się odnaleźć lub utworzyć pliku.");
        }
    }

    private static void loadWriteAndSort(Scanner input, List<Participant> participants, BufferedWriter bfw) {
        int result = 0;
        String name = null;
        try {
            do {

                System.out.println("Podaj imię następnego gracza lub wpisz komendę STOP w celu zakończenia działania programu.");
                name = input.nextLine();
                if (name.equals(STOP)) {
                    break;
                } else {
                    result = input.nextInt();
                    input.nextLine();
                    participants.add(new Participant(name, result));
                }

            } while (name != STOP);
            Collections.sort(participants);
            bfw.write(participants.toString());
            bfw.flush();
        } catch (InputMismatchException | IOException ex) {
            System.out.println("Wynik musi być wyrażony liczbowo");
        }
    }
}
