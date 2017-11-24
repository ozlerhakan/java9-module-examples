package com.modi.api.query.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by hakan on 19/11/2017
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Search {

    /**
     * specifies multiple flags
     *
     * @return list of flags
     */
    String[] value() default {};
}
