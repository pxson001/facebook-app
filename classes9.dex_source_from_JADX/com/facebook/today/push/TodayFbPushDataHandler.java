package com.facebook.today.push;

import android.os.Handler;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.common.util.JSONUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.push.PushProperty;
import com.facebook.push.fbpushdata.BaseFbPushDataHandler;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: turn_server_port */
public class TodayFbPushDataHandler extends BaseFbPushDataHandler {
    private static volatile TodayFbPushDataHandler f1245d;
    public volatile Handler f1246b;
    public volatile TodayUnitUpdatePushNotificationListener f1247c;

    /* compiled from: turn_server_port */
    public interface TodayUnitUpdatePushNotificationListener {
    }

    public static com.facebook.today.push.TodayFbPushDataHandler m1390a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1245d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.today.push.TodayFbPushDataHandler.class;
        monitor-enter(r1);
        r0 = f1245d;	 Catch:{ all -> 0x003a }
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
        r0 = m1391b(r0);	 Catch:{ all -> 0x0035 }
        f1245d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1245d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.today.push.TodayFbPushDataHandler.a(com.facebook.inject.InjectorLike):com.facebook.today.push.TodayFbPushDataHandler");
    }

    private static TodayFbPushDataHandler m1391b(InjectorLike injectorLike) {
        return new TodayFbPushDataHandler(ReliabilityAnalyticsLogger.a(injectorLike));
    }

    @Inject
    public TodayFbPushDataHandler(ReliabilityAnalyticsLogger reliabilityAnalyticsLogger) {
        super(reliabilityAnalyticsLogger);
    }

    public final void m1392b(JsonNode jsonNode, PushProperty pushProperty) {
        final TodayUnitUpdatePushNotificationListener todayUnitUpdatePushNotificationListener = this.f1247c;
        if (todayUnitUpdatePushNotificationListener != null) {
            if ("today_unit_update".equals(JSONUtil.b(jsonNode.b("type")))) {
                JsonNode b = jsonNode.b("params");
                if (b != null) {
                    final String b2 = JSONUtil.b(b.b("o"));
                    HandlerDetour.a(this.f1246b, new Runnable(this) {
                        final /* synthetic */ TodayFbPushDataHandler f1244c;

                        public void run() {
                        }
                    }, -1781663199);
                }
            }
        }
    }
}
