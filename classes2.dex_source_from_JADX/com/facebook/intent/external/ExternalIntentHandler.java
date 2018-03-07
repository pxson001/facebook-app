package com.facebook.intent.external;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: logout_reason_param */
public class ExternalIntentHandler {
    private static final String f15957e = ExternalIntentHandler.class.getSimpleName();
    private static volatile ExternalIntentHandler f15958f;
    protected final SecureContextHelper f15959a;
    protected final CommonEventsBuilder f15960b;
    protected final AnalyticsLogger f15961c;
    protected final AbstractFbErrorReporter f15962d;

    public static com.facebook.intent.external.ExternalIntentHandler m22740a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15958f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.intent.external.ExternalIntentHandler.class;
        monitor-enter(r1);
        r0 = f15958f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m22744b(r0);	 Catch:{ all -> 0x0035 }
        f15958f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15958f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.intent.external.ExternalIntentHandler.a(com.facebook.inject.InjectorLike):com.facebook.intent.external.ExternalIntentHandler");
    }

    private static ExternalIntentHandler m22744b(InjectorLike injectorLike) {
        return new ExternalIntentHandler(DefaultSecureContextHelper.m4636a(injectorLike), CommonEventsBuilder.m14539b(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public ExternalIntentHandler(SecureContextHelper secureContextHelper, CommonEventsBuilder commonEventsBuilder, AnalyticsLogger analyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f15959a = secureContextHelper;
        this.f15960b = commonEventsBuilder;
        this.f15961c = analyticsLogger;
        this.f15962d = abstractFbErrorReporter;
    }

    private void m22743a(Intent intent, Context context) {
        this.f15959a.mo665b(intent, context);
    }

    public final void m22745a(Intent intent, Context context, @Nullable JsonNode jsonNode, boolean z, TrackingNode trackingNode) {
        try {
            m22743a(intent, context);
        } catch (ActivityNotFoundException e) {
            BLog.b(f15957e, "Unable to launch for result from fragment for intent " + intent);
        }
        if (jsonNode == null || jsonNode.mo712e() == 0) {
            this.f15962d.m2343a("missing tracking codes", m22742a(intent), new RuntimeException("missing tracking codes trace"));
            return;
        }
        HoneyClientEvent a = this.f15960b.m14541a(m22742a(intent), z, jsonNode, m22741a());
        TrackingNodes.m27143a(a, trackingNode);
        this.f15961c.mo528a(a);
    }

    private static String m22742a(Intent intent) {
        return (intent == null || intent.getData() == null) ? "" : intent.getData().toString();
    }

    private static String m22741a() {
        return "native_newsfeed";
    }
}
