package com.facebook.attachments.angora.actionbutton.ctamessagesend;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: used_pan_control */
public class CtaMessageSendLogger {
    private static final String f907a = CtaMessageSendLogger.class.getSimpleName();
    private static volatile CtaMessageSendLogger f908d;
    private final AnalyticsLogger f909b;
    private final AbstractFbErrorReporter f910c;

    public static com.facebook.attachments.angora.actionbutton.ctamessagesend.CtaMessageSendLogger m888a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f908d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.attachments.angora.actionbutton.ctamessagesend.CtaMessageSendLogger.class;
        monitor-enter(r1);
        r0 = f908d;	 Catch:{ all -> 0x003a }
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
        r0 = m889b(r0);	 Catch:{ all -> 0x0035 }
        f908d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f908d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.attachments.angora.actionbutton.ctamessagesend.CtaMessageSendLogger.a(com.facebook.inject.InjectorLike):com.facebook.attachments.angora.actionbutton.ctamessagesend.CtaMessageSendLogger");
    }

    private static CtaMessageSendLogger m889b(InjectorLike injectorLike) {
        return new CtaMessageSendLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public CtaMessageSendLogger(AnalyticsLogger analyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f909b = analyticsLogger;
        this.f910c = abstractFbErrorReporter;
    }

    public final void m890a(JsonNode jsonNode, String str, boolean z) {
        HoneyClientEvent honeyClientEvent;
        if (jsonNode == null || jsonNode.e() == 0) {
            honeyClientEvent = null;
        } else {
            honeyClientEvent = new HoneyClientEvent("cta_message_send").a("tracking", jsonNode).b(z);
            honeyClientEvent.c = "native_newsfeed";
            honeyClientEvent = honeyClientEvent;
            if (str != null) {
                honeyClientEvent.b(str, "1");
            } else {
                honeyClientEvent.b("cta_click", "1");
            }
        }
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        if (honeyClientEvent2 == null) {
            this.f910c.a(f907a, "Honey Client Event is null as there are no Tracking codes in source: " + str);
        } else {
            this.f909b.a(honeyClientEvent2);
        }
    }
}
