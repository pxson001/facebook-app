package com.facebook.video.videohome.sessionmanager;

import com.facebook.analytics.NavigationLogger;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.calls.VideoHomeVisitInputData.Event;
import com.facebook.inject.InjectorLike;
import com.facebook.video.analytics.VideoAnalytics.CacheStatus;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;
import com.facebook.video.videohome.protocol.VideoHomeMutationsHelper;
import com.facebook.video.videohome.sessionmanager.session.VideoHomeSession;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pre_log */
public class VideoHomeSessionManager {
    private static volatile VideoHomeSessionManager f4349g;
    List<WeakReference<SessionStatusListener>> f4350a = new ArrayList();
    public final VideoHomeMutationsHelper f4351b;
    public final VideoHomeLoggingUtils f4352c;
    public final VideoHomeSession f4353d;
    private final NavigationLogger f4354e;
    private final Clock f4355f;

    public static com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager m4877a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4349g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager.class;
        monitor-enter(r1);
        r0 = f4349g;	 Catch:{ all -> 0x003a }
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
        r0 = m4879b(r0);	 Catch:{ all -> 0x0035 }
        f4349g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4349g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager.a(com.facebook.inject.InjectorLike):com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager");
    }

    private static VideoHomeSessionManager m4879b(InjectorLike injectorLike) {
        return new VideoHomeSessionManager(VideoHomeMutationsHelper.m4889a(injectorLike), VideoHomeLoggingUtils.a(injectorLike), VideoHomeSession.a(injectorLike), NavigationLogger.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public VideoHomeSessionManager(VideoHomeMutationsHelper videoHomeMutationsHelper, VideoHomeLoggingUtils videoHomeLoggingUtils, VideoHomeSession videoHomeSession, NavigationLogger navigationLogger, Clock clock) {
        this.f4351b = videoHomeMutationsHelper;
        this.f4352c = videoHomeLoggingUtils;
        this.f4353d = videoHomeSession;
        this.f4354e = navigationLogger;
        this.f4355f = clock;
    }

    public final void m4882a(SessionStatusListener sessionStatusListener) {
        Preconditions.checkNotNull(sessionStatusListener);
        this.f4350a.add(new WeakReference(sessionStatusListener));
    }

    public final void m4884b(SessionStatusListener sessionStatusListener) {
        Preconditions.checkNotNull(sessionStatusListener);
        Iterator it = this.f4350a.iterator();
        while (it.hasNext()) {
            if (sessionStatusListener == ((WeakReference) it.next()).get()) {
                it.remove();
            }
        }
    }

    public final void m4881a(CacheStatus cacheStatus) {
        String str;
        VideoHomeSession videoHomeSession = this.f4353d;
        if (videoHomeSession.d != null) {
            videoHomeSession.b.b(videoHomeSession.a, "Start a new session before previous end.");
        }
        videoHomeSession.d = SafeUUIDGenerator.a().toString();
        videoHomeSession.g = videoHomeSession.c.a();
        videoHomeSession.h = videoHomeSession.g;
        long a = this.f4355f.a();
        this.f4351b.m4891a(Event.START);
        VideoHomeLoggingUtils videoHomeLoggingUtils = this.f4352c;
        String str2 = this.f4354e.v;
        if ("swipe".equals(str2)) {
            str = "swipe";
        } else if ("cold_start".equals(str2)) {
            str = "cold_start";
        } else {
            str = "tab";
        }
        videoHomeLoggingUtils.a(a, str, cacheStatus);
        m4878a(Event.START);
    }

    private void m4878a(Event event) {
        for (WeakReference weakReference : this.f4350a) {
            SessionStatusListener sessionStatusListener = (SessionStatusListener) weakReference.get();
            if (sessionStatusListener != null) {
                if (event == Event.START) {
                    sessionStatusListener.a();
                } else if (event == Event.RESUME) {
                    sessionStatusListener.kN_();
                } else if (event == Event.PAUSE) {
                    sessionStatusListener.kM_();
                } else if (event == Event.END) {
                    sessionStatusListener.e();
                }
            }
        }
    }

    public final void m4880a() {
        this.f4351b.m4891a(Event.END);
        this.f4352c.c(this.f4353d.g());
        m4878a(Event.END);
        VideoHomeSession videoHomeSession = this.f4353d;
        if (videoHomeSession.d == null) {
            videoHomeSession.b.b(videoHomeSession.a, "Session is already ended.");
        }
        videoHomeSession.d = null;
        videoHomeSession.g = 0;
        videoHomeSession.h = 0;
    }

    public final void m4883b() {
        VideoHomeSession videoHomeSession = this.f4353d;
        if (videoHomeSession.d == null) {
            videoHomeSession.b.b(videoHomeSession.a, "Pause a session before session start.");
        } else if (videoHomeSession.e) {
            videoHomeSession.b.b(videoHomeSession.a, "Session is already paused.");
            m4878a(Event.PAUSE);
        }
        videoHomeSession.e = true;
        m4878a(Event.PAUSE);
    }

    public final void m4885c() {
        VideoHomeSession videoHomeSession = this.f4353d;
        if (videoHomeSession.d == null) {
            videoHomeSession.b.b(videoHomeSession.a, "Resume a session before session start.");
        } else if (!videoHomeSession.e) {
            videoHomeSession.b.b(videoHomeSession.a, "Session is already resumed.");
            m4878a(Event.RESUME);
        }
        videoHomeSession.e = false;
        m4878a(Event.RESUME);
    }

    public final boolean m4886g() {
        return this.f4353d.i();
    }

    public final boolean m4887h() {
        return this.f4353d.f;
    }

    public final boolean m4888i() {
        return this.f4353d.e;
    }
}
