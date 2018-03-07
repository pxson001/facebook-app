package com.facebook.contextual;

import com.facebook.contextual.models.Resolved;
import javax.annotation.Nullable;

/* compiled from: outer radii must have >= 8 values */
public class ResolvedContextualConfig implements ContextualConfig {
    RawConfig f8538a;
    ContextualConfigEvaluationResult f8539b;

    public ResolvedContextualConfig(RawConfig rawConfig, Resolved resolved, ContextualConfigLogger contextualConfigLogger) {
        if (resolved == null) {
            throw new ContextualConfigError("Bad config");
        } else if (resolved.b.intValue() != 1) {
            throw new ContextualConfigError("Unsupported config version");
        } else {
            this.f8538a = rawConfig;
            if (ContextValue.a(resolved.c) == null) {
                throw new ContextualConfigError("Missing output type definition");
            }
            this.f8539b = new ContextualConfigEvaluationResult(this, new ContextValue[]{new ContextValue(ContextValue.a(resolved.c), resolved.d)}, contextualConfigLogger, rawConfig);
        }
    }

    public final RawConfig m12345a() {
        return this.f8538a;
    }

    public final ContextualConfigEvaluationResult m12344a(@Nullable LocalContextsProvider localContextsProvider) {
        return this.f8539b;
    }
}
