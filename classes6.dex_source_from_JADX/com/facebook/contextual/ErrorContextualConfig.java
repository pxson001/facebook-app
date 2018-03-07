package com.facebook.contextual;

import javax.annotation.Nullable;

/* compiled from: overflow_friends */
public class ErrorContextualConfig implements ContextualConfig {
    private RawConfig f8517a;
    private String f8518b;

    public ErrorContextualConfig(RawConfig rawConfig, String str) {
        this.f8517a = rawConfig;
        this.f8518b = str;
    }

    public final RawConfig m12335a() {
        return this.f8517a;
    }

    public final ContextualConfigEvaluationResult m12334a(@Nullable LocalContextsProvider localContextsProvider) {
        throw new ContextualConfigError(this.f8518b);
    }
}
