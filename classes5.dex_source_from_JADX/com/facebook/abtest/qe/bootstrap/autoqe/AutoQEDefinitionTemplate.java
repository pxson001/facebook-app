package com.facebook.abtest.qe.bootstrap.autoqe;

import com.facebook.inject.Module;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Deprecated
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* compiled from: transaction_subtotal_cost */
public @interface AutoQEDefinitionTemplate {
    Class<? extends Module> inModule();
}
