package com.facebook.feed.quickcam;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: drawerPosition */
public class ComposerQuickCamAnalyticsLogger {
    private static volatile ComposerQuickCamAnalyticsLogger f7514b;
    private AnalyticsLogger f7515a;

    /* compiled from: drawerPosition */
    public enum Events {
        BIRTHDAY_CAM_ENTRY("birthday_cam_entry"),
        BIRTHDAY_CAM_CANCEL("birthday_cam_cancel"),
        BIRTHDAY_CAM_START_RECORDING("birthday_cam_start_recording"),
        BIRTHDAY_CAM_POST_PROCESSING_START("birthday_cam_post_processing_start"),
        BIRTHDAY_CAM_POST_PROCESSING_FINISHED("birthday_cam_post_processing_finished"),
        BIRTHDAY_CAM_POST("birthday_cam_post");
        
        public final String name;

        private Events(String str) {
            this.name = str;
        }
    }

    public static com.facebook.feed.quickcam.ComposerQuickCamAnalyticsLogger m8732a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7514b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.quickcam.ComposerQuickCamAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f7514b;	 Catch:{ all -> 0x003a }
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
        r0 = m8733b(r0);	 Catch:{ all -> 0x0035 }
        f7514b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7514b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.quickcam.ComposerQuickCamAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.quickcam.ComposerQuickCamAnalyticsLogger");
    }

    private static ComposerQuickCamAnalyticsLogger m8733b(InjectorLike injectorLike) {
        return new ComposerQuickCamAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ComposerQuickCamAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f7515a = analyticsLogger;
    }

    public final void m8734a(Events events, String str) {
        AnalyticsLogger analyticsLogger = this.f7515a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(events.name);
        honeyClientEvent.c = "composer_quick_cam";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = str;
        analyticsLogger.a(honeyClientEvent);
    }
}
