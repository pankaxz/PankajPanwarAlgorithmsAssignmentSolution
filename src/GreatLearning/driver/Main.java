package GreatLearning.driver;
import GreatLearning.models.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* The program uses Menu class to perform user inputs. */
        Menu menu = new Menu();
        try {
            menu.InitialiseDB();
        }
        catch (Exception e){
            System.out.println("Something wrong in the database");
            System.exit( 0 );
        }

        try {
            Scanner sc = new Scanner( System.in );
            int input;
            /* Analyse Input takes the input from the user for the menu shown in the console. */
            do {
                menu.InitialiseMenu();
                input = sc.nextInt();
                menu.AnalyseInput( input );
            } while (input >= 0 && input <= 5);
        }
        catch (Exception e){
            System.out.println(e);
            System.exit( 0 );
        }

    }
}
