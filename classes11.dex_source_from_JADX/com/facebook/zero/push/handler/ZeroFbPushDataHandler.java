package com.facebook.zero.push.handler;

import android.content.Intent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.push.PushProperty;
import com.facebook.push.fbpushdata.BaseFbPushDataHandler;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: minDigitsForThousandsSeparator */
public class ZeroFbPushDataHandler extends BaseFbPushDataHandler {
    private static final Class<?> f5390b = ZeroFbPushDataHandler.class;
    private static volatile ZeroFbPushDataHandler f5391g;
    private final Provider<TriState> f5392c;
    private final BaseFbBroadcastManager f5393d;
    private final LoggedInUserSessionManager f5394e;
    private final AnalyticsLogger f5395f;

    public static com.facebook.zero.push.handler.ZeroFbPushDataHandler m6629a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5391g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.push.handler.ZeroFbPushDataHandler.class;
        monitor-enter(r1);
        r0 = f5391g;	 Catch:{ all -> 0x003a }
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
        r0 = m6630b(r0);	 Catch:{ all -> 0x0035 }
        f5391g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5391g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.push.handler.ZeroFbPushDataHandler.a(com.facebook.inject.InjectorLike):com.facebook.zero.push.handler.ZeroFbPushDataHandler");
    }

    private static ZeroFbPushDataHandler m6630b(InjectorLike injectorLike) {
        return new ZeroFbPushDataHandler(ReliabilityAnalyticsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 816), (BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(injectorLike), LoggedInUserSessionManager.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ZeroFbPushDataHandler(ReliabilityAnalyticsLogger reliabilityAnalyticsLogger, Provider<TriState> provider, FbBroadcastManager fbBroadcastManager, LoggedInUserAuthDataStore loggedInUserAuthDataStore, AnalyticsLogger analyticsLogger) {
        super(reliabilityAnalyticsLogger);
        this.f5392c = provider;
        this.f5393d = fbBroadcastManager;
        this.f5394e = loggedInUserAuthDataStore;
        this.f5395f = analyticsLogger;
    }

    public final void m6631b(JsonNode jsonNode, PushProperty pushProperty) {
        if (TriState.YES.equals(this.f5392c.get())) {
            if ("zero".equals(JSONUtil.b(jsonNode.b("type"))) && this.f5394e.b()) {
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("zero_push_to_refresh_token");
                honeyClientEvent.c = "zero_push";
                this.f5395f.a(honeyClientEvent);
                this.f5393d.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.PUSH));
            }
        }
    }
}
