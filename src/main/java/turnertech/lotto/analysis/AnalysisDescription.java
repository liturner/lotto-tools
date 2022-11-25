package turnertech.lotto.analysis;

/**
 * This annotation serves two purposes. Firstly it enables easy
 * searching of Analysis Methods on the class path. Other than 
 * that it is a usefull meta holder for information about the
 * method.
 */
public @interface AnalysisDescription {

    /**
     * The name of the method.
     * @return The name of the method.
     */
    String name();

    /**
     * The name of the author.
     * @return The name of the author, or "anonymous".
     */
    String author() default "anonymous";
}
