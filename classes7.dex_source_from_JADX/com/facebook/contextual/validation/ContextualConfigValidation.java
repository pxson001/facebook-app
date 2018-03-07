package com.facebook.contextual.validation;

import com.facebook.contextual.ContextualConfigEvaluationResult;
import com.facebook.contextual.ContextualResolverImpl;
import com.facebook.debug.log.BLog;

/* compiled from: tap_status_button */
public class ContextualConfigValidation {
    public ContextualResolverImpl f2227a;

    public ContextualConfigValidation(ContextualResolverImpl contextualResolverImpl) {
        this.f2227a = contextualResolverImpl;
    }

    private String m2191d() {
        ContextualConfigEvaluationResult a = this.f2227a.a(ContextualConfigValidationXConfig.e);
        String a2 = a.a(0, "DefaultValue");
        return a2 + "-" + a.a(1, 123456);
    }

    public final void m2192a() {
        BLog.b("Contextual", "Validating alpha: %s , beta: %d , multi: %s", new Object[]{this.f2227a.a(ContextualConfigValidationXConfig.c, "hard-coded"), Long.valueOf(this.f2227a.a(ContextualConfigValidationXConfig.d, 123456)), m2191d()});
    }
}
