package nerdschool;

import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) throws IOException {
        ControlUnit controlUnit = new ControlUnit();
        controlUnit.startPolling();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(input != "exit") {
            input = scanner.nextLine();
        }
    }
}
