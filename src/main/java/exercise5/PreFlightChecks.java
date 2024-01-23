package exercise5;

import java.util.Scanner;

public class PreFlightChecks {
    public Boolean hasFuel() {
        System.out.println("Do we have fuel?");
        Scanner reader = new Scanner(System.in);
        String answer = reader.nextLine();
        return answer.equals("yes") || answer.equals("y");
    }

    public Boolean isDoorClosed() {
        System.out.println("Is the door closed?");
        Scanner reader = new Scanner(System.in);
        String answer = reader.nextLine();
        return answer.equals("yes") || answer.equals("y");
    }
}
