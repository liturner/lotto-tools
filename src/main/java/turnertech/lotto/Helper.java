package turnertech.lotto;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * 6aus49 helper information, such as constants and validation
 * functions.
 */
public class Helper {
    
    private Helper() {
        
    }

    /**
     * Chance of any one ball occuring in any one draw.
     */
    public static final double SINGLE_BALL_CHANCE = 6.0 / 49.0;

    /**
     * Check if a number is a valid 6aus49 ball.
     * 
     * @param number The number to check
     * @return True or False
     */
    public static boolean isValidBall(final int number) {
        return number > -1 && number < 50;
    }

    /**
     * Check if a probability is between 0.0 and 1.0.
     * 
     * @param probability The number to check
     * @return True or False
     */
    public static boolean isValidProbability(final double probability) {
        return probability >= 0.0 && probability <= 1.0;
    }

    /**
     * Loads a lotto draw archive into memory.
     * 
     * https://www.lotto-bayern.de/lotto6aus49/gewinnzahlen
     *
     * @param drawFile The lotto data to open.
     * @return A List of draws.
     */
    public static List<Draw> loadDraws(URL drawFile) {
        ArrayList<Draw> draws = new ArrayList<>(2400);

        int day = 0;
        int month = 0;
        int year = 0;
        int ball1 = 0;
        int ball2 = 0;
        int ball3 = 0;
        int ball4 = 0;
        int ball5 = 0;
        int ball6 = 0;
        int bonusball = 0;

        try (InputStream inputStream = drawFile.openStream()) {
            try (Scanner scanner = new Scanner(inputStream)) {
                // Skip the first header line, assumes there are headers of course
                if(scanner.hasNextLine()) {
                    scanner.nextLine();
                }

                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    String[] column = line.split("\t");

                    day = Integer.valueOf(column[0]);
                    month = Integer.valueOf(column[1]);
                    year = Integer.valueOf(column[2]);
                    ball1 = Integer.valueOf(column[3]);
                    ball2 = Integer.valueOf(column[4]);
                    ball3 = Integer.valueOf(column[5]);
                    ball4 = Integer.valueOf(column[6]);
                    ball5 = Integer.valueOf(column[7]);
                    ball6 = Integer.valueOf(column[8]);
                    bonusball = Integer.valueOf(column[11]);

                    draws.add(new Draw(List.of(ball1, ball2, ball3, ball4, ball5, ball6, bonusball), LocalDate.of(year, month, day)));
                }
            }
        } catch (NumberFormatException | IOException e) {
            Logging.LOGGER.log(Level.SEVERE, "Exception loading lotto numbers file", e);
        }
        return draws;        
    }

}
