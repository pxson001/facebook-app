package com.facebook.feed.photoreminder;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.inject.InjectorLike;
import com.facebook.productionprompts.logging.ProductionPromptsLogger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: module_tag */
public class PhotoReminderLogger {
    private static volatile PhotoReminderLogger f13351e;
    public final AnalyticsLogger f13352a;
    private SystemBatteryStateManager f13353b;
    private Context f13354c;
    public ProductionPromptsLogger f13355d;

    public static com.facebook.feed.photoreminder.PhotoReminderLogger m19675a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13351e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.photoreminder.PhotoReminderLogger.class;
        monitor-enter(r1);
        r0 = f13351e;	 Catch:{ all -> 0x003a }
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
        r0 = m19676b(r0);	 Catch:{ all -> 0x0035 }
        f13351e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13351e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.photoreminder.PhotoReminderLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.photoreminder.PhotoReminderLogger");
    }

    private static PhotoReminderLogger m19676b(InjectorLike injectorLike) {
        return new PhotoReminderLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), SystemBatteryStateManager.m11461a(injectorLike), (Context) injectorLike.getInstance(Context.class), ProductionPromptsLogger.m18862a(injectorLike));
    }

    @Inject
    public PhotoReminderLogger(AnalyticsLogger analyticsLogger, SystemBatteryStateManager systemBatteryStateManager, Context context, ProductionPromptsLogger productionPromptsLogger) {
        this.f13352a = analyticsLogger;
        this.f13353b = systemBatteryStateManager;
        this.f13354c = context;
        this.f13355d = productionPromptsLogger;
    }

    public final void m19677a(String str, String str2) {
        AnalyticsLogger analyticsLogger = this.f13352a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("photo_reminder_animation_start");
        honeyClientEvent.f3099c = "photo_reminder";
        HoneyAnalyticsEvent b = honeyClientEvent.m5090b("prompt_type", str2);
        b.f3102f = str;
        analyticsLogger.mo526a(b);
    }
}
