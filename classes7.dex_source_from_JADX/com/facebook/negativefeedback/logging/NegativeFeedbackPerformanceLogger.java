package com.facebook.negativefeedback.logging;

import com.facebook.quicklog.QuickPerformanceLogger;
import javax.inject.Inject;

/* compiled from: notifications_default_count */
public class NegativeFeedbackPerformanceLogger {
    public final QuickPerformanceLogger f7976a;

    @Inject
    public NegativeFeedbackPerformanceLogger(QuickPerformanceLogger quickPerformanceLogger) {
        this.f7976a = quickPerformanceLogger;
    }

    public final void m9606a() {
        this.f7976a.b(5046273);
    }

    public final void m9607b() {
        this.f7976a.b(5046273, (short) 2);
    }

    public final void m9608c() {
        this.f7976a.b(5046273, (short) 3);
    }
}
