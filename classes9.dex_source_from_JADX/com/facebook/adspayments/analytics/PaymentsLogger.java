package com.facebook.adspayments.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: sender_credential */
public class PaymentsLogger {
    private static volatile PaymentsLogger f3978e;
    @VisibleForTesting
    String f3979a;
    public final AnalyticsLogger f3980b;
    private Provider<TriState> f3981c;
    private long f3982d;

    public static com.facebook.adspayments.analytics.PaymentsLogger m3873a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f3978e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.adspayments.analytics.PaymentsLogger.class;
        monitor-enter(r1);
        r0 = f3978e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3876b(r0);	 Catch:{ all -> 0x0035 }
        f3978e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3978e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adspayments.analytics.PaymentsLogger.a(com.facebook.inject.InjectorLike):com.facebook.adspayments.analytics.PaymentsLogger");
    }

    private static PaymentsLogger m3876b(InjectorLike injectorLike) {
        return new PaymentsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 628));
    }

    @Inject
    public PaymentsLogger(AnalyticsLogger analyticsLogger, Provider<TriState> provider) {
        this.f3980b = analyticsLogger;
        this.f3981c = provider;
    }

    public final void m3879a(PaymentsLogEvent paymentsLogEvent) {
        paymentsLogEvent.a("ads_payments_holdout_2016_h1", this.f3981c.get());
        this.f3980b.a(paymentsLogEvent);
    }

    public final void m3880a(String str, PaymentsFlowContext paymentsFlowContext) {
        m3879a(new PaymentsLogEvent(str, paymentsFlowContext));
    }

    private void m3875a(PaymentsReliabilityLogEvent paymentsReliabilityLogEvent) {
        if (paymentsReliabilityLogEvent instanceof PaymentsReliabilityTransitionLogEvent) {
            PaymentsReliabilityTransitionLogEvent paymentsReliabilityTransitionLogEvent = (PaymentsReliabilityTransitionLogEvent) paymentsReliabilityLogEvent;
            if (!paymentsReliabilityTransitionLogEvent.f3983c.equals(this.f3979a)) {
                this.f3979a = paymentsReliabilityTransitionLogEvent.f3983c;
            } else {
                return;
            }
        }
        this.f3980b.a(paymentsReliabilityLogEvent);
    }

    private void m3874a(PaymentsFlowContext paymentsFlowContext) {
        this.f3979a = PaymentsFlowState.START_STATE.toString();
        this.f3982d = paymentsFlowContext.f3968c;
    }

    public final PaymentsReliabilityTransitionLogEvent m3878a(PaymentsFlowState paymentsFlowState, PaymentsFlowContext paymentsFlowContext) {
        return m3881b(paymentsFlowState.toString(), paymentsFlowContext);
    }

    public final PaymentsReliabilityTransitionLogEvent m3881b(String str, PaymentsFlowContext paymentsFlowContext) {
        if (this.f3982d != paymentsFlowContext.f3968c) {
            m3874a(paymentsFlowContext);
        }
        PaymentsReliabilityLogEvent paymentsReliabilityTransitionLogEvent = new PaymentsReliabilityTransitionLogEvent(str, paymentsFlowContext);
        paymentsReliabilityTransitionLogEvent.m3883p(this.f3979a);
        m3875a(paymentsReliabilityTransitionLogEvent);
        return paymentsReliabilityTransitionLogEvent;
    }

    public final PaymentsReliabilityErrorLogEvent m3877a(Throwable th, PaymentsFlowContext paymentsFlowContext) {
        if (this.f3982d != paymentsFlowContext.f3968c) {
            m3874a(paymentsFlowContext);
        }
        PaymentsReliabilityLogEvent paymentsReliabilityErrorLogEvent = new PaymentsReliabilityErrorLogEvent(th, paymentsFlowContext);
        paymentsReliabilityErrorLogEvent.m3883p(this.f3979a);
        m3875a(paymentsReliabilityErrorLogEvent);
        return paymentsReliabilityErrorLogEvent;
    }

    public final PaymentsReliabilityErrorLogEvent m3882c(String str, PaymentsFlowContext paymentsFlowContext) {
        if (this.f3982d != paymentsFlowContext.f3968c) {
            m3874a(paymentsFlowContext);
        }
        PaymentsReliabilityLogEvent paymentsReliabilityErrorLogEvent = new PaymentsReliabilityErrorLogEvent(str, paymentsFlowContext);
        paymentsReliabilityErrorLogEvent.m3883p(this.f3979a);
        m3875a(paymentsReliabilityErrorLogEvent);
        return paymentsReliabilityErrorLogEvent;
    }
}
