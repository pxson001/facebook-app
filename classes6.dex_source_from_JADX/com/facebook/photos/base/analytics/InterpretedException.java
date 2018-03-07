package com.facebook.photos.base.analytics;

import com.facebook.photos.base.analytics.ExceptionInterpreter.Diagnostic;

/* compiled from: interaction_position */
public class InterpretedException extends Exception {
    private final Diagnostic mDiagnostic;
    private final boolean mRetryMightWork;

    public InterpretedException(String str, boolean z) {
        this(str, z, null);
    }

    public InterpretedException(String str, Throwable th, boolean z) {
        super(str, th);
        this.mRetryMightWork = z;
        this.mDiagnostic = null;
    }

    public InterpretedException(String str, boolean z, Diagnostic diagnostic) {
        super(str);
        this.mRetryMightWork = z;
        this.mDiagnostic = diagnostic;
    }

    public final boolean m19971a() {
        return this.mRetryMightWork;
    }

    public final Diagnostic m19972b() {
        return this.mDiagnostic;
    }
}
