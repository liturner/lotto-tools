package turnertech.lotto;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Draw> draws = new ArrayList<>(150);

        draws.add(new Draw(1,2,3,4,5,6,7)); 

        AnalysisResult results = new BasicAnalysis().analyse(draws);
        results.print();

    }

}