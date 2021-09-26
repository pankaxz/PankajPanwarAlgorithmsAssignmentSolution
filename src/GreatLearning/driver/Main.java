package GreatLearning.driver;
import GreatLearning.models.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /***
         * The program uses main menu as the main driver for the data.
         */
        Menu menu = new Menu();
        menu.InitialiseDB();

        Scanner sc = new Scanner( System.in );
        int input;
        do {
            menu.InitialiseMenu();
            input = sc.nextInt();
            menu.AnalyseInput( input );
        } while (input >= 0 && input <= 5);
    }
}
