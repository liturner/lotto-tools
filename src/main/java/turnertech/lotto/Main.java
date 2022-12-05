package turnertech.lotto;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import turnertech.lotto.analysis.AnalysisMethod;
import turnertech.lotto.analysis.methods.BasicAnalysis;
import turnertech.lotto.analysis.methods.PureRandom;
import turnertech.lotto.analysis.verification.Verification;
import turnertech.lotto.analysis.verification.VerificationResult;
import turnertech.lotto.gui.SeppFrame;
import turnertech.lotto.gui.SeppTrayIcon;

/**
 * Currently the only executable method for this application. Used to analyse
 * all balls with all methods.
 */
public class Main {

    /**
     * Basic no gui analysis using all methods and printing results using the loggers.
     * 
     * @param args System provided arguments
     */
    public static void main(String[] args) {




        //Check the SystemTray is supported
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final SeppTrayIcon trayIcon = new SeppTrayIcon();
        final SystemTray tray = SystemTray.getSystemTray();
              
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }






        SeppFrame frame = new SeppFrame();        
        frame.setVisible(true);

        List<Draw> draws = Helper.loadDraws(Main.class.getResource("/lotto.txt"));

        List<Class<? extends AnalysisMethod>> analysisMethods = new ArrayList<>();
        analysisMethods.add(BasicAnalysis.class);
        analysisMethods.add(PureRandom.class);

        for (Class<? extends AnalysisMethod> analysisMethod : analysisMethods) {
            VerificationResult verificationResult = new Verification(analysisMethod, draws).verify();
            Logging.LOGGER.log(Level.INFO, () -> verificationResult.toString());
            Logging.LOGGER.log(Level.INFO, () -> verificationResult.getLastAnalysisResult().toString());
        }
    }
}