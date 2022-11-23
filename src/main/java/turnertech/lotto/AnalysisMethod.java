package turnertech.lotto;

import java.util.List;

/**
 * An analysis method provides the core functionaity of the analysis engine.
 * It is a simple interface which takes in a list of draws and returns an 
 * {@link AnalysisResult}.
 * 
 * This interface aims to make it possible to easily compar the results of
 * several analysis methods.
 */
public interface AnalysisMethod {
    
    public AnalysisResult analyse(final List<Draw> draws);

}
