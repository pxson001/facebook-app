package com.facebook.abtest.qe.bootstrap.autoqe;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Deprecated
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: transaction_total_cost */
public @interface AutoQEDefinition {
    String experimentName();

    String shortName();
}
