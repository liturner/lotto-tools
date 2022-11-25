package turnertech.lotto.analysis;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation serves two purposes. Firstly it enables easy
 * searching of Analysis Methods on the class path. Other than 
 * that it is a usefull meta holder for information about the
 * method.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AnalysisDescription {

    /**
     * The name of the method.
     * @return The name of the method.
     */
    public String name();

    /**
     * The name of the author.
     * @return The name of the author, or "anonymous".
     */
    public String author() default "anonymous";
}
