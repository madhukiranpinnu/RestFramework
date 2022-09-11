package AnnotationsP;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Retention(RetentionPolicy.RUNTIME)//To use annotation at runtime
@Target({METHOD})//Scope only for methods
public @interface FrameworkAnnotations {
    String[] author() default "default_Author";
    String[] category() default "default_Category";
}
