package com.facebook.video.videohome.logging;

import android.util.LruCache;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.search.abtest.VideoSearchExperimentHelper;
import com.facebook.video.analytics.VideoAnalytics.BadgeFetchReason;
import com.facebook.video.analytics.VideoAnalytics.CacheStatus;
import com.facebook.video.analytics.VideoAnalytics.ClickTarget;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PrefetchReason;
import com.facebook.video.analytics.VideoAnalytics.TTIType;
import com.facebook.video.analytics.VideoAnalytics.VideoAnalyticsAttributes;
import com.facebook.video.analytics.VideoAnalytics.VideoHomeAnalyticsAttributes;
import com.facebook.video.analytics.VideoAnalytics.VideoHomeAnalyticsEvents;
import com.facebook.video.analytics.VideoAnalytics.VideoSearchExperienceType;
import com.facebook.video.videohome.sessionmanager.session.VideoHomeSession;
import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: No Content-Range header */
public class VideoHomeLoggingUtils {
    private static final String f421a = VideoHomeLoggingUtils.class.getSimpleName();
    private static volatile VideoHomeLoggingUtils f422k;
    private final AnalyticsLogger f423b;
    private final VideoHomeSession f424c;
    public final JewelCounters f425d;
    private final VideoSearchExperimentHelper f426e;
    private final LruCache<String, Boolean> f427f = new LruCache(100);
    public long f428g;
    private long f429h;
    public long f430i;
    private boolean f431j;

    public static com.facebook.video.videohome.logging.VideoHomeLoggingUtils m391a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f422k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.videohome.logging.VideoHomeLoggingUtils.class;
        monitor-enter(r1);
        r0 = f422k;	 Catch:{ all -> 0x003a }
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
        r0 = m394b(r0);	 Catch:{ all -> 0x0035 }
        f422k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f422k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.videohome.logging.VideoHomeLoggingUtils.a(com.facebook.inject.InjectorLike):com.facebook.video.videohome.logging.VideoHomeLoggingUtils");
    }

    private static VideoHomeLoggingUtils m394b(InjectorLike injectorLike) {
        return new VideoHomeLoggingUtils(AnalyticsLoggerMethodAutoProvider.a(injectorLike), VideoHomeSession.a(injectorLike), JewelCounters.a(injectorLike), VideoSearchExperimentHelper.b(injectorLike));
    }

    @Inject
    public VideoHomeLoggingUtils(AnalyticsLogger analyticsLogger, VideoHomeSession videoHomeSession, JewelCounters jewelCounters, VideoSearchExperimentHelper videoSearchExperimentHelper) {
        this.f423b = analyticsLogger;
        this.f424c = videoHomeSession;
        this.f425d = jewelCounters;
        this.f426e = videoSearchExperimentHelper;
    }

    public final void m396a(long j, String str, CacheStatus cacheStatus) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(VideoHomeAnalyticsEvents.VIDEO_HOME_SESSION_START.value);
        honeyClientEvent.b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, PlayerOrigin.VIDEO_HOME.origin);
        honeyClientEvent.a(VideoHomeAnalyticsAttributes.BADGE_COUNT.value, this.f425d.a(Jewel.VIDEO_HOME));
        honeyClientEvent.b(VideoHomeAnalyticsAttributes.DATA_PREFETCH_STATUS.value, cacheStatus.value);
        honeyClientEvent.b(VideoHomeAnalyticsAttributes.VIDEO_SEARCH_EXPERIENCE.value, this.f426e.a() ? VideoSearchExperienceType.KEYWORDS.value : VideoSearchExperienceType.DISABLED.value);
        honeyClientEvent.b(VideoHomeAnalyticsAttributes.ENTRY_POINT_TYPE.value, str);
        if (!(this.f431j || this.f430i == 0)) {
            honeyClientEvent.b(VideoHomeAnalyticsAttributes.TIME_SINCE_START.value, Long.toString(TimeUnit.MILLISECONDS.toSeconds(j - this.f430i)));
            this.f431j = true;
        }
        if (!(this.f428g == 0 || this.f428g == this.f429h)) {
            honeyClientEvent.b(VideoHomeAnalyticsAttributes.TIME_SINCE_PREFETCH.value, Long.toString(TimeUnit.MILLISECONDS.toSeconds(j - this.f428g)));
            this.f429h = this.f428g;
        }
        m392a(honeyClientEvent);
    }

    public final void m407c(long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(VideoHomeAnalyticsEvents.VIDEO_HOME_SESSION_END.value);
        honeyClientEvent.b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, PlayerOrigin.VIDEO_HOME.origin);
        honeyClientEvent.a(VideoHomeAnalyticsAttributes.SESSION_DURATION.value, j);
        m392a(honeyClientEvent);
        this.f427f.evictAll();
    }

    public final void m408d(long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(VideoHomeAnalyticsEvents.VIDEO_HOME_BACKGROUNDED.value);
        honeyClientEvent.a(VideoHomeAnalyticsAttributes.SESSION_DURATION.value, j);
        m392a(honeyClientEvent);
    }

    public final void m395a() {
        m392a(new HoneyClientEvent(VideoHomeAnalyticsEvents.VIDEO_HOME_FOREGROUNDED.value));
    }

    public final void m403a(PrefetchReason prefetchReason, PlayerOrigin playerOrigin) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(VideoHomeAnalyticsEvents.VIDEO_HOME_DATA_PREFETCH.value);
        honeyClientEvent.b(VideoHomeAnalyticsAttributes.FETCH_REASON.value, prefetchReason.value);
        honeyClientEvent.b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin);
        m392a(honeyClientEvent);
    }

    public final void m397a(BadgeFetchReason badgeFetchReason) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(VideoHomeAnalyticsEvents.VIDEO_HOME_BADGE_FETCHED.value);
        honeyClientEvent.b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, PlayerOrigin.VIDEO_HOME.origin);
        honeyClientEvent.b(VideoHomeAnalyticsAttributes.FETCH_REASON.value, badgeFetchReason.value);
        m392a(honeyClientEvent);
    }

    public final void m402a(PlayerOrigin playerOrigin, TTIType tTIType, CacheStatus cacheStatus, long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(VideoHomeAnalyticsEvents.VIDEO_HOME_TTI.value);
        honeyClientEvent.b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin);
        honeyClientEvent.b(VideoHomeAnalyticsAttributes.TTI_TYPE.value, tTIType.value);
        honeyClientEvent.b(VideoHomeAnalyticsAttributes.DATA_PREFETCH_STATUS.value, cacheStatus.value);
        honeyClientEvent.a(VideoHomeAnalyticsAttributes.TTI_PERF_S.value, (double) (((float) j) / 1000.0f));
        m392a(honeyClientEvent);
    }

    public final void m398a(PlayerOrigin playerOrigin) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(VideoHomeAnalyticsEvents.VIDEO_HOME_PULL_TO_REFRESH.value);
        honeyClientEvent.b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin);
        m392a(honeyClientEvent);
    }

    public final void m399a(PlayerOrigin playerOrigin, ClickTarget clickTarget) {
        HoneyClientEvent b = m393b(playerOrigin, clickTarget);
        b.b(VideoHomeAnalyticsAttributes.EVENT_TARGET.value, "button");
        m392a(b);
    }

    public final void m400a(PlayerOrigin playerOrigin, ClickTarget clickTarget, VideoHomeChannelLoggingData videoHomeChannelLoggingData) {
        HoneyClientEvent b = m393b(playerOrigin, clickTarget);
        b.b(VideoHomeAnalyticsAttributes.EVENT_TARGET.value, "button");
        b.b(VideoHomeAnalyticsAttributes.CHANNEL_ID.value, videoHomeChannelLoggingData.a);
        b.b(VideoHomeAnalyticsAttributes.TARGET_ID.value, videoHomeChannelLoggingData.a);
        b.a(VideoHomeAnalyticsAttributes.UNIT_POSITION.value, videoHomeChannelLoggingData.c);
        b.b(VideoHomeAnalyticsAttributes.REACTION_UNIT_TYPE.value, videoHomeChannelLoggingData.b);
        m392a(b);
    }

    public final void m401a(PlayerOrigin playerOrigin, ClickTarget clickTarget, VideoHomeStoryLoggingData videoHomeStoryLoggingData) {
        Preconditions.checkArgument(videoHomeStoryLoggingData != null);
        HoneyClientEvent b = m393b(playerOrigin, clickTarget);
        b.b(VideoHomeAnalyticsAttributes.EVENT_TARGET.value, "story");
        b.b(VideoHomeAnalyticsAttributes.TARGET_ID.value, videoHomeStoryLoggingData.a);
        b.a(VideoHomeAnalyticsAttributes.TRACKING.value, videoHomeStoryLoggingData.b);
        b.b(VideoHomeAnalyticsAttributes.REACTION_UNIT_TYPE.value, videoHomeStoryLoggingData.c);
        b.a(VideoHomeAnalyticsAttributes.UNIT_POSITION.value, videoHomeStoryLoggingData.d);
        m392a(b);
    }

    public final void m406b(PlayerOrigin playerOrigin, ClickTarget clickTarget, VideoHomeChannelLoggingData videoHomeChannelLoggingData) {
        HoneyClientEvent b = m393b(playerOrigin, clickTarget);
        b.b(VideoHomeAnalyticsAttributes.EVENT_TARGET.value, "channel");
        b.b(VideoHomeAnalyticsAttributes.TARGET_ID.value, videoHomeChannelLoggingData.a);
        b.b(VideoHomeAnalyticsAttributes.CHANNEL_ID.value, videoHomeChannelLoggingData.a);
        b.b(VideoHomeAnalyticsAttributes.REACTION_UNIT_TYPE.value, videoHomeChannelLoggingData.b);
        b.a(VideoHomeAnalyticsAttributes.UNIT_POSITION.value, videoHomeChannelLoggingData.c);
        m392a(b);
    }

    private static HoneyClientEvent m393b(PlayerOrigin playerOrigin, ClickTarget clickTarget) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(VideoHomeAnalyticsEvents.VIDEO_HOME_CLICK.value);
        honeyClientEvent.b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin);
        honeyClientEvent.b(VideoHomeAnalyticsAttributes.CLICK_TARGET.value, clickTarget.value);
        return honeyClientEvent;
    }

    public final void m405a(String str, String str2, String str3) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(VideoHomeAnalyticsEvents.VIDEO_HOME_DUPLICATE.value);
        honeyClientEvent.b(VideoHomeAnalyticsAttributes.EVENT_TARGET.value, "video");
        honeyClientEvent.b(VideoHomeAnalyticsAttributes.TARGET_ID.value, str);
        honeyClientEvent.b(VideoHomeAnalyticsAttributes.DUPLICATE_STORY_ID.value, str2);
        honeyClientEvent.b(VideoHomeAnalyticsAttributes.EVENT_TARGET_INFO.value, str3);
        honeyClientEvent.b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, PlayerOrigin.VIDEO_HOME.origin);
        m392a(honeyClientEvent);
    }

    public final void m404a(VideoHomeStoryLoggingData videoHomeStoryLoggingData, boolean z) {
        if (this.f427f.get(videoHomeStoryLoggingData.a) == null) {
            if (z) {
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent(VideoHomeAnalyticsEvents.VIDEO_HOME_END_SCREEN_DISPLAYED.value);
                honeyClientEvent.b(VideoHomeAnalyticsAttributes.TARGET_ID.value, videoHomeStoryLoggingData.a);
                honeyClientEvent.a(VideoHomeAnalyticsAttributes.TRACKING.value, videoHomeStoryLoggingData.b);
                honeyClientEvent.b(VideoHomeAnalyticsAttributes.REACTION_UNIT_TYPE.value, videoHomeStoryLoggingData.c);
                honeyClientEvent.b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, PlayerOrigin.VIDEO_HOME.origin);
                honeyClientEvent.a(VideoHomeAnalyticsAttributes.UNIT_POSITION.value, videoHomeStoryLoggingData.d);
                m392a(honeyClientEvent);
            }
            this.f427f.put(videoHomeStoryLoggingData.a, Boolean.valueOf(true));
        }
    }

    private void m392a(HoneyClientEvent honeyClientEvent) {
        Preconditions.checkNotNull(honeyClientEvent);
        honeyClientEvent.c = "video_home";
        this.f424c.a(honeyClientEvent);
        if (this.f424c.i()) {
            honeyClientEvent.b(VideoHomeAnalyticsAttributes.SESSION_ID.value, this.f424c.d);
        }
        this.f423b.a(honeyClientEvent);
        honeyClientEvent.d();
    }
}
