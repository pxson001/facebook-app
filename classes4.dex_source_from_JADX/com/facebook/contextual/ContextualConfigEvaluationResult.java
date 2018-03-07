package com.facebook.contextual;

import javax.annotation.Nullable;

/* compiled from: speex_initial_bitrate */
public class ContextualConfigEvaluationResult {
    private ContextualConfig f1947a;
    public ContextHandler f1948b;
    public ContextValue f1949c;
    public String f1950d;
    public ContextValue[] f1951e;
    private ContextualConfigLogger f1952f;
    private RawConfig f1953g;

    public ContextualConfigEvaluationResult(ContextualConfig contextualConfig, @Nullable ContextHandler contextHandler, @Nullable ContextValue contextValue, @Nullable String str, ContextValue[] contextValueArr, ContextualConfigLogger contextualConfigLogger, RawConfig rawConfig) {
        this.f1947a = contextualConfig;
        this.f1948b = contextHandler;
        this.f1949c = contextValue;
        this.f1950d = str;
        this.f1951e = contextValueArr;
        this.f1952f = contextualConfigLogger;
        this.f1953g = rawConfig;
    }

    public ContextualConfigEvaluationResult() {
        this.f1947a = null;
        this.f1951e = null;
    }

    public ContextualConfigEvaluationResult(ContextualConfig contextualConfig, ContextValue[] contextValueArr, ContextualConfigLogger contextualConfigLogger, RawConfig rawConfig) {
        this(contextualConfig, null, null, null, contextValueArr, contextualConfigLogger, rawConfig);
    }

    public final long m2019a(int i, long j) {
        if (m2018e()) {
            try {
                j = m2017a(i).m1977a();
            } catch (ContextualConfigError e) {
                this.f1952f.mo136a(this.f1953g, e.getMessage());
            }
        }
        return j;
    }

    public final String m2020a(int i, String str) {
        if (m2018e()) {
            try {
                str = m2017a(i).m1979c();
            } catch (ContextualConfigError e) {
                this.f1952f.mo136a(this.f1953g, e.getMessage());
            }
        }
        return str;
    }

    private boolean m2018e() {
        return this.f1951e != null;
    }

    private ContextValue m2017a(int i) {
        if (i < 0 || i >= this.f1951e.length) {
            throw new ContextualConfigError("Output index out of range");
        }
        ContextValue contextValue = this.f1951e[i];
        if (contextValue != null) {
            return contextValue;
        }
        throw new ContextualConfigError("Param value not specified");
    }
}
