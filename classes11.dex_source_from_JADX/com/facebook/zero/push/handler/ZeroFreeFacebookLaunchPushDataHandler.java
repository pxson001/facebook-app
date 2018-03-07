package com.facebook.zero.push.handler;

import android.content.Context;
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
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.logging.NotificationsLogger.Component;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.model.SystemTrayNotification;
import com.facebook.notifications.model.SystemTrayNotificationBuilder;
import com.facebook.notifications.util.SystemTrayNotificationHelper;
import com.facebook.notifications.util.SystemTrayNotificationManager;
import com.facebook.notifications.util.SystemTrayNotificationUtil;
import com.facebook.push.PushProperty;
import com.facebook.push.fbpushdata.BaseFbPushDataHandler;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mimeTypes */
public class ZeroFreeFacebookLaunchPushDataHandler extends BaseFbPushDataHandler {
    private static final Class<?> f5396b = ZeroFreeFacebookLaunchPushDataHandler.class;
    private static volatile ZeroFreeFacebookLaunchPushDataHandler f5397m;
    private final Provider<TriState> f5398c;
    private final BaseFbBroadcastManager f5399d;
    private final LoggedInUserSessionManager f5400e;
    private final AnalyticsLogger f5401f;
    private final SystemTrayNotificationUtil f5402g;
    private final Provider<SystemTrayNotificationBuilder> f5403h;
    private final SystemTrayNotificationHelper f5404i;
    private final SystemTrayNotificationManager f5405j;
    private final UriIntentMapper f5406k;
    private final Context f5407l;

    public static com.facebook.zero.push.handler.ZeroFreeFacebookLaunchPushDataHandler m6632a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5397m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.push.handler.ZeroFreeFacebookLaunchPushDataHandler.class;
        monitor-enter(r1);
        r0 = f5397m;	 Catch:{ all -> 0x003a }
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
        r0 = m6634b(r0);	 Catch:{ all -> 0x0035 }
        f5397m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5397m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.push.handler.ZeroFreeFacebookLaunchPushDataHandler.a(com.facebook.inject.InjectorLike):com.facebook.zero.push.handler.ZeroFreeFacebookLaunchPushDataHandler");
    }

    private static ZeroFreeFacebookLaunchPushDataHandler m6634b(InjectorLike injectorLike) {
        return new ZeroFreeFacebookLaunchPushDataHandler(ReliabilityAnalyticsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 816), (BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(injectorLike), LoggedInUserSessionManager.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), SystemTrayNotificationUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 8699), SystemTrayNotificationHelper.a(injectorLike), SystemTrayNotificationManager.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public ZeroFreeFacebookLaunchPushDataHandler(ReliabilityAnalyticsLogger reliabilityAnalyticsLogger, Provider<TriState> provider, FbBroadcastManager fbBroadcastManager, LoggedInUserAuthDataStore loggedInUserAuthDataStore, AnalyticsLogger analyticsLogger, SystemTrayNotificationUtil systemTrayNotificationUtil, Provider<SystemTrayNotificationBuilder> provider2, SystemTrayNotificationHelper systemTrayNotificationHelper, SystemTrayNotificationManager systemTrayNotificationManager, Context context, UriIntentMapper uriIntentMapper) {
        super(reliabilityAnalyticsLogger);
        this.f5398c = provider;
        this.f5399d = fbBroadcastManager;
        this.f5400e = loggedInUserAuthDataStore;
        this.f5401f = analyticsLogger;
        this.f5402g = systemTrayNotificationUtil;
        this.f5403h = provider2;
        this.f5404i = systemTrayNotificationHelper;
        this.f5405j = systemTrayNotificationManager;
        this.f5407l = context;
        this.f5406k = uriIntentMapper;
    }

    public final void m6635b(JsonNode jsonNode, PushProperty pushProperty) {
        if (TriState.YES.equals(this.f5398c.get())) {
            if ("mobile_zero_free_facebook_launch".equals(JSONUtil.b(jsonNode.b("type"))) && this.f5400e.b()) {
                this.f5401f.a(new HoneyClientEvent("zero_push_on_free_facebook_launch").g("zero_push"));
                try {
                    SystemTrayNotification a = this.f5402g.a(jsonNode).a(pushProperty.b).b(pushProperty.a.toString()).a(pushProperty.c);
                    this.f5399d.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.FREE_FACEBOOK_LAUNCH_PUSH));
                    m6633a(a);
                } catch (Throwable e) {
                    BLog.b(f5396b, "IOException", e);
                    this.a.a(pushProperty.a.toString(), pushProperty.b, e);
                }
            }
        }
    }

    private void m6633a(SystemTrayNotification systemTrayNotification) {
        NotificationType a = systemTrayNotification.a();
        NotificationLogObject c = systemTrayNotification.c();
        SystemTrayNotificationBuilder a2 = ((SystemTrayNotificationBuilder) this.f5403h.get()).a((CharSequence) systemTrayNotification.c("lnb").get()).d((CharSequence) systemTrayNotification.c("lnt").get()).a(2130843529).c((CharSequence) systemTrayNotification.c("lnt").get()).a(SystemTrayNotificationHelper.a(systemTrayNotification));
        a2.c = systemTrayNotification;
        this.f5405j.a(a, a2, this.f5406k.a(this.f5407l, FBLinks.bT), Component.ACTIVITY, c);
    }
}
