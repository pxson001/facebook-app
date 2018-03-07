package com.facebook.timeline.profilevideo.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.timeline.profilevideo.model.ProfileVideoModel;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mPandoraInstanceId was null when trying to create MemoryCacheEntryKey */
public class ProfileVideoSessionTracker {
    private static volatile ProfileVideoSessionTracker f9357c;
    private final AnalyticsLogger f9358a;
    private final BaseAnalyticsConfig f9359b;

    public static com.facebook.timeline.profilevideo.logging.ProfileVideoSessionTracker m11111a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9357c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.profilevideo.logging.ProfileVideoSessionTracker.class;
        monitor-enter(r1);
        r0 = f9357c;	 Catch:{ all -> 0x003a }
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
        r0 = m11113b(r0);	 Catch:{ all -> 0x0035 }
        f9357c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9357c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.profilevideo.logging.ProfileVideoSessionTracker.a(com.facebook.inject.InjectorLike):com.facebook.timeline.profilevideo.logging.ProfileVideoSessionTracker");
    }

    private static ProfileVideoSessionTracker m11113b(InjectorLike injectorLike) {
        return new ProfileVideoSessionTracker(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (BaseAnalyticsConfig) FbAnalyticsConfig.a(injectorLike));
    }

    @Inject
    public ProfileVideoSessionTracker(AnalyticsLogger analyticsLogger, BaseAnalyticsConfig baseAnalyticsConfig) {
        this.f9358a = analyticsLogger;
        this.f9359b = baseAnalyticsConfig;
    }

    public final void m11114a(ProfileVideoEvent profileVideoEvent, String str) {
        m11112a(m11110a(str, profileVideoEvent.getEventName()));
    }

    public final void m11118b(ProfileVideoEvent profileVideoEvent, String str) {
        HoneyClientEvent a = m11110a(null, profileVideoEvent.getEventName());
        a.b("profile_video_cta_video_id", str);
        m11112a(a);
    }

    public final void m11115a(String str, int i) {
        HoneyClientEvent a = m11110a(str, ProfileVideoEvent.VIDEO_TOO_LONG.getEventName());
        a.a("video_duration", i);
        m11112a(a);
    }

    public final void m11116a(String str, long j) {
        HoneyClientEvent a = m11110a(str, ProfileVideoEvent.UPLOAD_STARTED.getEventName());
        a.a("thumbnail_ms", j);
        m11112a(a);
    }

    public final void m11117a(String str, ProfileVideoModel profileVideoModel) {
        HoneyClientEvent a = m11110a(str, ProfileVideoEvent.SCRUBBER_OPENED.getEventName());
        a.a("video_duration", profileVideoModel.f9369b);
        a.a("start_ms", profileVideoModel.m11131h());
        a.a("end_ms", profileVideoModel.m11132i());
        m11112a(a);
    }

    private void m11112a(HoneyClientEvent honeyClientEvent) {
        if (this.f9359b.a(honeyClientEvent.d)) {
            this.f9358a.a(honeyClientEvent);
        }
    }

    private static HoneyClientEvent m11110a(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str2);
        honeyClientEvent.c = "create_profile_video_android";
        return honeyClientEvent.b("session_id", str);
    }
}
