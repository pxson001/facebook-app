package com.facebook.video.engine.logverifier;

import android.util.Pair;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.analytics.VideoAnalytics.VideoAnalyticsAttributes;
import com.facebook.video.analytics.VideoAnalytics.VideoAnalyticsEvents;
import com.facebook.video.engine.logverifier.VideoLoggingFullVerifierBase.VideoSessionEntry;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is */
public class VideoLoggingStateMachineVerifier extends VideoLoggingFullVerifierBase {
    private static final String f19400a = VideoLoggingStateMachineVerifier.class.getSimpleName();
    private static final Map<BasicVideoState, Set<VideoAnalyticsEvents>> f19401f;
    public static final Set<VideoAnalyticsEvents> f19402g = ImmutableSet.of(VideoAnalyticsEvents.VIDEO_REQUESTED_PLAYING, VideoAnalyticsEvents.VIDEO_START, VideoAnalyticsEvents.VIDEO_UNPAUSED, VideoAnalyticsEvents.VIDEO_PAUSE, VideoAnalyticsEvents.VIDEO_COMPLETE, VideoAnalyticsEvents.VIDEO_CANCELLED_REQUESTED_PLAYING, VideoAnalyticsEvents.VIDEO_EXCEPTION, VideoAnalyticsEvents.VIDEO_SEEK);
    public static final Map<VideoAnalyticsAttributes, Set<String>> f19403h;
    private static volatile VideoLoggingStateMachineVerifier f19404i;
    private final MonotonicClock f19405b;
    private final AbstractFbErrorReporter f19406c;
    private final Map<String, VideoStateChecker> f19407d = new HashMap();
    public final QeAccessor f19408e;

    /* compiled from: is */
    enum BasicVideoState {
        REQUESTED_PLAY,
        PLAYING,
        PAUSED,
        ERROR,
        SEEKING
    }

    public static com.facebook.video.engine.logverifier.VideoLoggingStateMachineVerifier m27116a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19404i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.engine.logverifier.VideoLoggingStateMachineVerifier.class;
        monitor-enter(r1);
        r0 = f19404i;	 Catch:{ all -> 0x003a }
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
        r0 = m27118b(r0);	 Catch:{ all -> 0x0035 }
        f19404i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19404i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.logverifier.VideoLoggingStateMachineVerifier.a(com.facebook.inject.InjectorLike):com.facebook.video.engine.logverifier.VideoLoggingStateMachineVerifier");
    }

    private static VideoLoggingStateMachineVerifier m27118b(InjectorLike injectorLike) {
        return new VideoLoggingStateMachineVerifier(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    static {
        Map hashMap = new HashMap();
        f19401f = hashMap;
        hashMap.put(BasicVideoState.REQUESTED_PLAY, ImmutableSet.of(VideoAnalyticsEvents.VIDEO_REQUESTED_PLAYING));
        f19401f.put(BasicVideoState.PLAYING, ImmutableSet.of(VideoAnalyticsEvents.VIDEO_START, VideoAnalyticsEvents.VIDEO_UNPAUSED));
        f19401f.put(BasicVideoState.PAUSED, ImmutableSet.of(VideoAnalyticsEvents.VIDEO_PAUSE, VideoAnalyticsEvents.VIDEO_COMPLETE, VideoAnalyticsEvents.VIDEO_CANCELLED_REQUESTED_PLAYING));
        f19401f.put(BasicVideoState.ERROR, ImmutableSet.of(VideoAnalyticsEvents.VIDEO_EXCEPTION));
        f19401f.put(BasicVideoState.SEEKING, ImmutableSet.of(VideoAnalyticsEvents.VIDEO_SEEK));
        Map hashMap2 = new HashMap();
        f19403h = hashMap2;
        hashMap2.put(VideoAnalyticsAttributes.PLAYER_ORIGIN, ImmutableSet.of("newsfeed", "user_timeline", "page_timeline", "permalink", "video_home", "group", "event", "instant_articles", "other"));
    }

    @Inject
    public VideoLoggingStateMachineVerifier(MonotonicClock monotonicClock, AbstractFbErrorReporter abstractFbErrorReporter, QeAccessor qeAccessor) {
        super(monotonicClock, 259200000, 100000);
        this.f19405b = monotonicClock;
        this.f19406c = abstractFbErrorReporter;
        this.f19408e = qeAccessor;
    }

    public final boolean mo3107a() {
        return m27119e();
    }

    private boolean m27119e() {
        return this.f19408e.mo596a(ExperimentsForVideoAbTestModule.db, false);
    }

    public final void mo3108a(HoneyClientEvent honeyClientEvent) {
        Object obj = 1;
        super.mo3108a(honeyClientEvent);
        List arrayList = new ArrayList();
        if (m27119e()) {
            VideoSessionEntry videoSessionEntry;
            String m = honeyClientEvent.m5101m(VideoAnalyticsAttributes.VIDEO_ID.value);
            if (m != null) {
                Object obj2;
                VideoSessionEntry a = m27112a(m);
                if (a.d) {
                    obj2 = null;
                } else {
                    arrayList.add(new Pair("Session Entry is not ok", "Session transition failure"));
                    obj2 = 1;
                }
                VideoStateChecker videoStateChecker = (VideoStateChecker) this.f19407d.get(m);
                if (videoStateChecker == null) {
                    videoStateChecker = new VideoStateChecker(this.f19405b);
                    this.f19407d.put(m, videoStateChecker);
                }
                if (videoStateChecker.a(honeyClientEvent, this.f19408e.mo596a(ExperimentsForVideoAbTestModule.cZ, false), arrayList)) {
                    obj = obj2;
                }
                videoSessionEntry = a;
            } else if (honeyClientEvent.f3111d.equals(VideoAnalyticsEvents.VIDEO_EXCEPTION.value)) {
                obj = null;
                videoSessionEntry = null;
            } else {
                arrayList.add(new Pair("Invalid metadata: " + VideoAnalyticsAttributes.VIDEO_ID, StringFormatUtil.formatStrLocaleSafe("No video ID for %s.\n%s", honeyClientEvent.f3111d, honeyClientEvent.mo700d())));
                videoSessionEntry = null;
            }
            if (obj != null) {
                m27117a(videoSessionEntry, arrayList);
            }
        }
    }

    protected final void mo3106a(VideoSessionEntry videoSessionEntry) {
    }

    private void m27117a(VideoSessionEntry videoSessionEntry, List<Pair<String, String>> list) {
        String str = "";
        if (videoSessionEntry != null) {
            Object c = videoSessionEntry.c();
        } else {
            String str2 = str;
        }
        for (Pair pair : list) {
            this.f19406c.m2340a(f19400a + ", " + ((String) pair.first), StringFormatUtil.formatStrLocaleSafe("%s\n%s", pair.second, c));
        }
    }

    public static boolean m27120f(VideoAnalyticsEvents videoAnalyticsEvents) {
        return ((Set) f19401f.get(BasicVideoState.PLAYING)).contains(videoAnalyticsEvents);
    }

    public static boolean m27121g(VideoAnalyticsEvents videoAnalyticsEvents) {
        return ((Set) f19401f.get(BasicVideoState.PAUSED)).contains(videoAnalyticsEvents);
    }

    public static boolean m27122h(VideoAnalyticsEvents videoAnalyticsEvents) {
        return ((Set) f19401f.get(BasicVideoState.REQUESTED_PLAY)).contains(videoAnalyticsEvents);
    }

    public static boolean m27123i(VideoAnalyticsEvents videoAnalyticsEvents) {
        return ((Set) f19401f.get(BasicVideoState.SEEKING)).contains(videoAnalyticsEvents);
    }

    public static BasicVideoState m27124j(VideoAnalyticsEvents videoAnalyticsEvents) {
        if (m27120f(videoAnalyticsEvents)) {
            return BasicVideoState.PLAYING;
        }
        if (m27121g(videoAnalyticsEvents)) {
            return BasicVideoState.PAUSED;
        }
        if (m27122h(videoAnalyticsEvents)) {
            return BasicVideoState.REQUESTED_PLAY;
        }
        return BasicVideoState.ERROR;
    }
}
