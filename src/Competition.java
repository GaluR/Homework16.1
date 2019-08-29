import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Competition {
    private static String STOP = "stop";

    public static void main(String[] args) {

        File file = new File("stats.csv");
        write(file, load());
        System.out.println("Dane posortowane i zapisano do pliku stats.csv .");
    }

    private static List<Participant> load() {
        List<Participant> participants = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int result = 0;
        String name = null;
        do {
            try {
                System.out.println("Podaj imię następnego gracza lub wpisz komendę STOP w celu zakończenia działania programu.");
                name = input.nextLine();
                if (name.equals(STOP)) {
                    break;
                } else {
                    result = input.nextInt();
                    input.nextLine();
                    participants.add(new Participant(name, result));
                }
            } catch (InputMismatchException ex) {
                System.out.println("Wynik musi być wyrażony liczbowo");
            }
        } while (name != STOP);
        return participants;
    }

    private static void write(File file, List<Participant> participants) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bfw = new BufferedWriter(fw);
            Collections.sort(participants);
            bfw.write(participants.toString());
            bfw.flush();
        } catch (InputMismatchException | IOException ex) {
            System.out.println("Wynik musi być wyrażony liczbowo");
        }
    }
}
