package com.facebook.conditionalworker;

import com.facebook.conditionalworker.CurrentStates.Factory;
import com.facebook.performancelogger.PerformanceLogger;

/* compiled from: timestamp_ms DESC */
public class ConditionalWorkerRunner implements ConditionalWorkerExecutionInfo {
    private static final Class<?> f986a = ConditionalWorkerRunner.class;
    private final ConditionalWorkerInfo f987b;
    private final boolean f988c;
    private final String f989d;
    private final PerformanceLogger f990e;
    public final Factory f991f;

    /* compiled from: timestamp_ms DESC */
    class ConditionalWorkerResult {
        final ConditionalWorkerInfo f1018a;
        final boolean f1019b;

        public ConditionalWorkerResult(ConditionalWorkerInfo conditionalWorkerInfo, boolean z) {
            this.f1018a = conditionalWorkerInfo;
            this.f1019b = z;
        }
    }

    public Object call() {
        String str = null;
        boolean z = false;
        try {
            ConditionalWorker conditionalWorker = (ConditionalWorker) this.f987b.mo790c().get();
            if (this.f988c) {
                str = this.f989d + "." + conditionalWorker.getClass().getSimpleName();
                this.f990e.d(2883585, str);
            }
            if (conditionalWorker != null) {
                z = conditionalWorker.mo83a(this);
            }
            Object conditionalWorkerResult = new ConditionalWorkerResult(this.f987b, z);
            return conditionalWorkerResult;
        } finally {
            if (this.f988c) {
                if (z) {
                    this.f990e.c(2883585, str);
                } else {
                    this.f990e.f(2883585, str);
                }
            }
        }
    }

    ConditionalWorkerRunner(ConditionalWorkerInfo conditionalWorkerInfo, boolean z, String str, PerformanceLogger performanceLogger, Factory factory) {
        this.f987b = conditionalWorkerInfo;
        this.f988c = z;
        this.f989d = str;
        this.f990e = performanceLogger;
        this.f991f = factory;
    }

    final ConditionalWorkerInfo m1309c() {
        return this.f987b;
    }

    public final boolean m1308a() {
        boolean a = this.f991f.m10569a().m10801a(this.f987b.mo791d());
        Boolean.valueOf(a);
        return a;
    }
}
