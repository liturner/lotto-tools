package turnertech.lotto.analysis;

import java.util.List;

import turnertech.lotto.Draw;

/**
 * An analysis method provides the core functionaity of the analysis engine.
 * It is a simple interface which takes in a list of draws and returns an 
 * {@link AnalysisResult}.
 * 
 * This interface aims to make it possible to easily compar the results of
 * several analysis methods.
 * 
 * @author Luke Ian Turner
 * @since 1.0.0
 */
public interface AnalysisMethod {
    
    /**
     * The analyse function implemented by a subclass. This function must 
     * simply return an {@link AnalysisResult} based on the list of {@link Draw}
     * instances it is passed.
     * 
     * @author Luke Ian Turner
     * @since 1.0.0
     * @param draws An ordered list of draws. Assumes that the first element is the oldest draw.
     * @return An {@link AnalysisResult} containing this methods results. Implementing classes should ensure this is never null.
     */
    public AnalysisResult analyse(final List<Draw> draws);

}
