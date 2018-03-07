package com.facebook.captcha.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_billing_zip_valid */
public class CaptchaAnalyticsLogger {
    private static volatile CaptchaAnalyticsLogger f10665b;
    public final AnalyticsLogger f10666a;

    /* compiled from: is_billing_zip_valid */
    public enum EventType {
        CAPTCHA_SHOWN("captcha_shown"),
        CAPTCHA_FETCH_REQUEST_SUCCEEDED("captcha_fetch_request_succeeded"),
        CAPTCHA_FETCH_REQUEST_FAILED("captcha_fetch_request_failed"),
        TRY_ANOTHER_CAPTCHA_CLICKED("try_another_captcha_clicked"),
        SUBMIT_CAPTCHA_INPUT_CLICKED("submit_captcha_input_clicked"),
        CAPTCHA_SOLVE_REQUEST_SUCCEEDED("captcha_solve_request_succeeded"),
        CAPTCHA_SOLVE_REQUEST_FAILED("captcha_solve_request_failed");
        
        private final String mEventType;

        private EventType(String str) {
            this.mEventType = str;
        }

        public final String getEventName() {
            return this.mEventType;
        }
    }

    public static com.facebook.captcha.logging.CaptchaAnalyticsLogger m12599a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10665b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.captcha.logging.CaptchaAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f10665b;	 Catch:{ all -> 0x003a }
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
        r0 = m12600b(r0);	 Catch:{ all -> 0x0035 }
        f10665b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10665b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.captcha.logging.CaptchaAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.captcha.logging.CaptchaAnalyticsLogger");
    }

    private static CaptchaAnalyticsLogger m12600b(InjectorLike injectorLike) {
        return new CaptchaAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CaptchaAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f10666a = analyticsLogger;
    }

    public final void m12601a(Boolean bool) {
        AnalyticsLogger analyticsLogger = this.f10666a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.CAPTCHA_SOLVE_REQUEST_SUCCEEDED.getEventName());
        honeyClientEvent.c = "captcha";
        analyticsLogger.b(honeyClientEvent.a("captcha_solved", bool), 1);
    }
}
