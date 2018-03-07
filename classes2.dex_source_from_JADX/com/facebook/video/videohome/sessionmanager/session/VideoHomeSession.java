package com.facebook.video.videohome.sessionmanager.session;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.video.analytics.VideoAnalytics.VideoHomeAnalyticsAttributes;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: iorg_image_view */
public class VideoHomeSession {
    private static volatile VideoHomeSession f19433i;
    public final String f19434a = VideoHomeSession.class.getName();
    public final AbstractFbErrorReporter f19435b;
    public final Clock f19436c;
    public String f19437d = null;
    public boolean f19438e = false;
    public boolean f19439f = false;
    public long f19440g = 0;
    public long f19441h = 0;

    public static com.facebook.video.videohome.sessionmanager.session.VideoHomeSession m27130a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19433i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.videohome.sessionmanager.session.VideoHomeSession.class;
        monitor-enter(r1);
        r0 = f19433i;	 Catch:{ all -> 0x003a }
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
        r0 = m27131b(r0);	 Catch:{ all -> 0x0035 }
        f19433i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19433i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.videohome.sessionmanager.session.VideoHomeSession.a(com.facebook.inject.InjectorLike):com.facebook.video.videohome.sessionmanager.session.VideoHomeSession");
    }

    private static VideoHomeSession m27131b(InjectorLike injectorLike) {
        return new VideoHomeSession(FbErrorReporterImpl.m2317a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public VideoHomeSession(AbstractFbErrorReporter abstractFbErrorReporter, Clock clock) {
        this.f19435b = abstractFbErrorReporter;
        this.f19436c = clock;
    }

    public final long m27133g() {
        return this.f19440g == 0 ? 0 : this.f19436c.mo211a() - this.f19440g;
    }

    public final boolean m27134i() {
        return this.f19437d != null;
    }

    public final void m27132a(HoneyClientEvent honeyClientEvent) {
        if (m27134i()) {
            honeyClientEvent.m5090b(VideoHomeAnalyticsAttributes.VIDEO_HOME_SESSION_ID.value, this.f19437d);
        }
    }
}
