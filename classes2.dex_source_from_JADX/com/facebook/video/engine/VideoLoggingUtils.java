package com.facebook.video.engine;

import android.net.Uri;
import android.os.Build;
import android.support.v4.util.LruCache;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.ExperimentsForAnalyticsClientModule;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondReporter;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.util.AnalyticsConnectionUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.app.module.String_VideoLoggingLevelMethodAutoProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.StallTimeCalculation;
import com.facebook.video.analytics.VideoAnalytics.ChromecastCastButtonClickType;
import com.facebook.video.analytics.VideoAnalytics.ChromecastVideoAnalyticsAttributes;
import com.facebook.video.analytics.VideoAnalytics.ChromecastVideoAnalyticsEvents;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.ExternalLogType;
import com.facebook.video.analytics.VideoAnalytics.HeadingIndicatorEventAttributes;
import com.facebook.video.analytics.VideoAnalytics.HeadingIndicatorEvents;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalytics.SphericalVideoAttributes;
import com.facebook.video.analytics.VideoAnalytics.SphericalVideoContentClickEvents;
import com.facebook.video.analytics.VideoAnalytics.SphericalVideoEvents;
import com.facebook.video.analytics.VideoAnalytics.StreamRepresentationEventSource;
import com.facebook.video.analytics.VideoAnalytics.StreamingFormat;
import com.facebook.video.analytics.VideoAnalytics.SurfaceTexturePoolAttributes;
import com.facebook.video.analytics.VideoAnalytics.SurfaceTexturePoolEvents;
import com.facebook.video.analytics.VideoAnalytics.VideoAlbumAttributes;
import com.facebook.video.analytics.VideoAnalytics.VideoAlbumOriginType;
import com.facebook.video.analytics.VideoAnalytics.VideoAnalyticsAttributes;
import com.facebook.video.analytics.VideoAnalytics.VideoAnalyticsEvents;
import com.facebook.video.analytics.VideoAnalytics.VideoChainingAnalyticsEvents;
import com.facebook.video.analytics.VideoAnalytics.VideoPlayerServiceAnalyticsEvents;
import com.facebook.video.analytics.VideoAnalytics.VideoRequestedPlayingState;
import com.facebook.video.analytics.VideoChannelSessionManager;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoLoggingPropertyBag;
import com.facebook.video.analytics.VideoPlaybackAnalyticsParams;
import com.facebook.video.engine.logverifier.VideoLoggingEventMatchingVerifier;
import com.facebook.video.engine.logverifier.VideoLoggingFullVerifier;
import com.facebook.video.engine.logverifier.VideoLoggingStateMachineVerifier;
import com.facebook.video.server.VideoServer;
import com.facebook.video.server.VideoServerMethodAutoProvider;
import com.facebook.video.videohome.sessionmanager.session.VideoHomeSession;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.android.exoplayer.chunk.Format;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package ' */
public class VideoLoggingUtils {
    private static volatile VideoLoggingUtils f19359B;
    private static final Class<?> f19360a = VideoLoggingUtils.class;
    private static final Set<String> f19361x = ImmutableSet.of(VideoAnalyticsEvents.VIDEO_DISPLAYED.value, VideoAnalyticsEvents.VIDEO_REQUESTED_PLAYING.value, VideoAnalyticsEvents.VIDEO_CANCELLED_REQUESTED_PLAYING.value, VideoAnalyticsEvents.VIDEO_START.value, VideoAnalyticsEvents.VIDEO_UNPAUSED.value, VideoAnalyticsEvents.VIDEO_PAUSE.value, VideoAnalyticsEvents.VIDEO_COMPLETE.value, VideoAnalyticsEvents.VIDEO_EXCEPTION.value);
    public boolean f19362A = false;
    private final AnalyticsLogger f19363b;
    private final Lazy<NavigationLogger> f19364c;
    private final AbstractFbErrorReporter f19365d;
    private final AnalyticsConnectionUtils f19366e;
    private final ImmediateActiveSecondReporter f19367f;
    private final Provider<VideoDashConfig> f19368g;
    private final VideoLoggingEventMatchingVerifier f19369h;
    private final VideoLoggingFullVerifier f19370i;
    private final VideoChannelSessionManager f19371j;
    public final SoftReportSender f19372k;
    private final VideoLoggingStateMachineVerifier f19373l;
    private final VideoServer f19374m;
    private final FbDataConnectionManager f19375n;
    private final VideoHomeSession f19376o;
    private final QeAccessor f19377p;
    private final GatekeeperStoreImpl f19378q;
    public final VideoLoggingPropertyBag f19379r;
    private final String f19380s = "video";
    private final String f19381t = "too_many_events";
    private final LruCache<String, String> f19382u;
    public final LruCache<String, VideoDisplayedInfo> f19383v;
    public final LruCache<String, AtomicInteger> f19384w;
    private VerboseLoggingParam f19385y;
    private VideoDashConfig f19386z;

    /* compiled from: isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package ' */
    public enum VerboseLoggingParam {
        NONE,
        ONLY_CORE_ANALYTICS_EVENTS,
        ALL
    }

    public static com.facebook.video.engine.VideoLoggingUtils m27031a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19359B;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.engine.VideoLoggingUtils.class;
        monitor-enter(r1);
        r0 = f19359B;	 Catch:{ all -> 0x003a }
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
        r0 = m27042b(r0);	 Catch:{ all -> 0x0035 }
        f19359B = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19359B;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.VideoLoggingUtils.a(com.facebook.inject.InjectorLike):com.facebook.video.engine.VideoLoggingUtils");
    }

    private static VideoLoggingUtils m27042b(InjectorLike injectorLike) {
        return new VideoLoggingUtils(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 137), FbErrorReporterImpl.m2317a(injectorLike), AnalyticsConnectionUtils.m12210a(injectorLike), ImmediateActiveSecondReporter.m21688a(injectorLike), VideoLoggingEventMatchingVerifier.m27099a(injectorLike), VideoLoggingFullVerifier.m27104a(injectorLike), VideoChannelSessionManager.a(injectorLike), DefaultAndroidThreadUtil.m1645a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), XConfigReader.m2681a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 3635), VideoLoggingStateMachineVerifier.m27116a(injectorLike), String_VideoLoggingLevelMethodAutoProvider.m27128a(injectorLike), VideoServerMethodAutoProvider.m26993a(injectorLike), FbDataConnectionManager.m3787a(injectorLike), VideoHomeSession.m27130a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), VideoLoggingPropertyBag.a(injectorLike));
    }

    private static void m27035a(HoneyClientEvent honeyClientEvent, int i) {
        Object obj;
        if (i == -1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            honeyClientEvent.m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f));
        }
    }

    @Inject
    public VideoLoggingUtils(AnalyticsLogger analyticsLogger, Lazy<NavigationLogger> lazy, FbErrorReporter fbErrorReporter, AnalyticsConnectionUtils analyticsConnectionUtils, ImmediateActiveSecondReporter immediateActiveSecondReporter, VideoLoggingEventMatchingVerifier videoLoggingEventMatchingVerifier, VideoLoggingFullVerifier videoLoggingFullVerifier, VideoChannelSessionManager videoChannelSessionManager, AndroidThreadUtil androidThreadUtil, MonotonicClock monotonicClock, XConfigReader xConfigReader, Provider<VideoDashConfig> provider, VideoLoggingStateMachineVerifier videoLoggingStateMachineVerifier, String str, VideoServer videoServer, FbDataConnectionManager fbDataConnectionManager, VideoHomeSession videoHomeSession, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, VideoLoggingPropertyBag videoLoggingPropertyBag) {
        this.f19363b = analyticsLogger;
        this.f19364c = lazy;
        this.f19365d = fbErrorReporter;
        this.f19366e = analyticsConnectionUtils;
        this.f19367f = immediateActiveSecondReporter;
        this.f19368g = provider;
        this.f19369h = videoLoggingEventMatchingVerifier;
        this.f19370i = videoLoggingFullVerifier;
        this.f19371j = videoChannelSessionManager;
        this.f19373l = videoLoggingStateMachineVerifier;
        this.f19372k = new SoftReportSender(androidThreadUtil, monotonicClock, this.f19365d, 10, 100, xConfigReader);
        this.f19382u = new LruCache(200);
        this.f19383v = new LruCache(200);
        this.f19384w = new LruCache(200);
        this.f19374m = videoServer;
        this.f19375n = fbDataConnectionManager;
        this.f19376o = videoHomeSession;
        this.f19377p = qeAccessor;
        this.f19378q = gatekeeperStore;
        this.f19379r = videoLoggingPropertyBag;
        m27078a(str);
    }

    public final void m27078a(String str) {
        try {
            this.f19385y = VerboseLoggingParam.valueOf(str);
        } catch (IllegalArgumentException e) {
            this.f19385y = VerboseLoggingParam.NONE;
        }
    }

    public final void m27077a(Boolean bool) {
        try {
            this.f19362A = bool.booleanValue();
        } catch (Throwable e) {
            BLog.b(f19360a, "Illelegal argument in setVideoPlayerVerboseLogging", e);
        }
    }

    private void m27034a(HoneyClientEvent honeyClientEvent) {
        double parseDouble;
        double parseDouble2;
        String str = honeyClientEvent.f3111d;
        if (VideoAnalyticsEvents.VIDEO_PAUSE.value.equals(str) || VideoAnalyticsEvents.VIDEO_COMPLETE.value.equals(str)) {
            parseDouble = Double.parseDouble(honeyClientEvent.m5101m(VideoAnalyticsAttributes.LAST_START_POSITION_PARAM.value));
            parseDouble2 = Double.parseDouble(honeyClientEvent.m5101m(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value));
        } else if (VideoAnalyticsEvents.VIDEO_SEEK.value.equals(str)) {
            parseDouble2 = Double.parseDouble(honeyClientEvent.m5101m(VideoAnalyticsAttributes.SEEK_SOURCE_POSITION_PARAM.value));
            parseDouble = parseDouble2;
        } else {
            return;
        }
        double a = (double) (this.f19367f.m21694a() / 1000);
        this.f19367f.m21696a("video", (long) (a - (parseDouble2 - parseDouble)), (long) a);
    }

    public final boolean m27082a() {
        return this.f19362A;
    }

    private String m27033a(String str, String str2, String str3) {
        if (m27046e(str2)) {
            return str2;
        }
        if (m27046e(str)) {
            return str;
        }
        if (this.f19365d != null) {
            this.f19365d.m2340a(VideoAnalyticsAttributes.VIDEO_EXCEPTION_TAG.value, StringFormatUtil.a("from %s", new Object[]{str3}));
        }
        return null;
    }

    private String m27044c(String str, String str2) {
        return m27033a(null, str, str2);
    }

    private static boolean m27046e(String str) {
        if (str == null) {
            return false;
        }
        if (EventTriggerType.BY_AUTOPLAY.value.equals(str) || EventTriggerType.BY_USER.value.equals(str)) {
            return true;
        }
        return false;
    }

    private boolean m27040a(String str, int i, boolean z) {
        boolean z2 = true;
        if (!Strings.isNullOrEmpty(str)) {
            synchronized (this.f19382u) {
                if (this.f19382u.m4432a((Object) str) != null) {
                    z2 = false;
                }
                if (z) {
                    this.f19382u.m4433a((Object) str, (Object) str);
                }
            }
            return z2;
        } else if (i == 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean m27083a(String str, int i) {
        return m27040a(str, i, false);
    }

    public final VideoLoggingUtils m27058a(JsonNode jsonNode, String str, String str2, int i, String str3, String str4, PlayerOrigin playerOrigin, @Nullable String str5, String str6, String str7, ChannelEligibility channelEligibility, boolean z, String str8, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        HoneyClientEvent g = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_REQUESTED_PLAYING.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str2).m5090b(VideoAnalyticsAttributes.STREAM_TYPE.value, str3).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str4).m5090b(VideoAnalyticsAttributes.VIDEO_ENCODE.value, str8).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.PREVIOUS_VIDEO_ID.value, str5).m5090b(VideoAnalyticsAttributes.REQUESTED_STATE.value, (m27040a(str4, i, false) ? VideoRequestedPlayingState.STARTED : VideoRequestedPlayingState.UNPAUSED).value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, m27033a(str2, str6, "logVideoStartRequested")).m5090b(VideoAnalyticsAttributes.API_CONFIG.value, str7).m5090b(VideoAnalyticsAttributes.CHANNEL_ELIGIBILITY.value, channelEligibility.eligibility).m5094g("video");
        m27037a(g, videoPlaybackAnalyticsParams);
        this.f19366e.m12218a(g);
        m27035a(g, i);
        return m27030a(g, str4, jsonNode, z);
    }

    public final VideoLoggingUtils m27064a(JsonNode jsonNode, String str, String str2, String str3, int i, String str4, String str5, PlayerOrigin playerOrigin, @Nullable String str6, String str7, String str8, boolean z, StallTimeCalculation stallTimeCalculation, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        HoneyClientEvent g = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_CANCELLED_REQUESTED_PLAYING.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.STREAMING_FORMAT.value, str2).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str3).m5090b(VideoAnalyticsAttributes.STREAM_TYPE.value, str4).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str5).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.PREVIOUS_VIDEO_ID.value, str6).m5090b(VideoAnalyticsAttributes.REQUESTED_STATE.value, (m27040a(str5, i, false) ? VideoRequestedPlayingState.STARTED : VideoRequestedPlayingState.UNPAUSED).value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, m27033a(str3, str7, "logVideoStartCancelled")).m5090b(VideoAnalyticsAttributes.API_CONFIG.value, str8).m5094g("video");
        m27037a(g, videoPlaybackAnalyticsParams);
        m27036a(g, stallTimeCalculation);
        this.f19366e.m12218a(g);
        this.f19369h.m27102b(str5);
        return m27030a(g, str5, jsonNode, z);
    }

    public final VideoLoggingUtils m27063a(JsonNode jsonNode, String str, String str2, String str3, int i, String str4, String str5, PlayerOrigin playerOrigin, String str6, String str7, String str8, ChannelEligibility channelEligibility, boolean z, StallTimeCalculation stallTimeCalculation, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        return this.f19369h.m27103c(str5) ? this : m27091b(jsonNode, str, str2, str3, i, str4, str5, playerOrigin, str6, str7, str8, channelEligibility, z, stallTimeCalculation, videoPlaybackAnalyticsParams);
    }

    public final VideoLoggingUtils m27091b(JsonNode jsonNode, String str, String str2, String str3, int i, String str4, String str5, PlayerOrigin playerOrigin, @Nullable String str6, String str7, String str8, ChannelEligibility channelEligibility, boolean z, StallTimeCalculation stallTimeCalculation, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        if (m27040a(str5, i, true)) {
            return m27043c(jsonNode, str, str2, str3, i, str4, str5, playerOrigin, str6, str7, str8, channelEligibility, z, stallTimeCalculation, videoPlaybackAnalyticsParams);
        }
        return m27032a(jsonNode, str, str2, str3, i, str5, playerOrigin, str7, str8, channelEligibility, z, stallTimeCalculation, videoPlaybackAnalyticsParams);
    }

    private VideoLoggingUtils m27043c(JsonNode jsonNode, String str, String str2, String str3, int i, String str4, String str5, PlayerOrigin playerOrigin, @Nullable String str6, String str7, String str8, ChannelEligibility channelEligibility, boolean z, StallTimeCalculation stallTimeCalculation, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        String a = m27033a(str3, str7, "logVideoStartEvent");
        HoneyClientEvent g = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_START.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.STREAMING_FORMAT.value, str2).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str3).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5090b(VideoAnalyticsAttributes.STREAM_TYPE.value, str4).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str5).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.PREVIOUS_VIDEO_ID.value, str6).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, a).m5090b(VideoAnalyticsAttributes.CHANNEL_ELIGIBILITY.value, channelEligibility.eligibility).m5090b(VideoAnalyticsAttributes.API_CONFIG.value, str8).m5094g("video");
        m27037a(g, videoPlaybackAnalyticsParams);
        m27039a(str5, g);
        m27036a(g, stallTimeCalculation);
        this.f19366e.m12218a(g);
        this.f19369h.m27101a(str5, str3, str, a);
        return m27030a(g, str5, jsonNode, z);
    }

    private void m27039a(String str, HoneyClientEvent honeyClientEvent) {
        if (str != null) {
            VideoDisplayedInfo videoDisplayedInfo = (VideoDisplayedInfo) this.f19383v.m4432a((Object) str);
            if (videoDisplayedInfo != null && videoDisplayedInfo.e != TriState.UNSET) {
                honeyClientEvent.m5086a(VideoAnalyticsAttributes.VR_CAST_BUTTON_DISPLAYED.value, (Object) videoDisplayedInfo.e);
            }
        }
    }

    private static void m27038a(@Nullable ExternalLogType externalLogType, @Nullable String str, HoneyClientEvent honeyClientEvent) {
        if (externalLogType != null && !StringUtil.m3589a(externalLogType.value) && !StringUtil.m3589a((CharSequence) str)) {
            honeyClientEvent.m5090b(VideoAnalyticsAttributes.EXTERNAL_LOG_TYPE.value, externalLogType.value).m5090b(VideoAnalyticsAttributes.EXTERNAL_LOG_ID.value, str);
        }
    }

    private static void m27036a(HoneyClientEvent honeyClientEvent, StallTimeCalculation stallTimeCalculation) {
        if (stallTimeCalculation != null) {
            honeyClientEvent.m5082a(VideoAnalyticsAttributes.STALL_TIME.value, (double) (((float) stallTimeCalculation.g()) / 1000.0f));
            honeyClientEvent.m5083a(VideoAnalyticsAttributes.STALL_COUNT.value, stallTimeCalculation.f());
            honeyClientEvent.m5084a(VideoAnalyticsAttributes.FIRST_STALL_START_POSITION.value, stallTimeCalculation.h());
            honeyClientEvent.m5082a(VideoAnalyticsAttributes.FIRST_STALL_TIME.value, (double) (((float) stallTimeCalculation.i()) / 1000.0f));
            honeyClientEvent.m5087a(VideoAnalyticsAttributes.IS_STALLING.value, stallTimeCalculation.k());
            long j = stallTimeCalculation.j();
            if (j > 0) {
                honeyClientEvent.m5082a(VideoAnalyticsAttributes.TIME_UNTIL_INTERRUPT.value, (double) (((float) j) / 1000.0f));
            }
        }
    }

    private static void m27037a(HoneyClientEvent honeyClientEvent, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        if (videoPlaybackAnalyticsParams != null) {
            honeyClientEvent.m5087a(VideoAnalyticsAttributes.IS_LIVE_STREAM.value, videoPlaybackAnalyticsParams.a());
            honeyClientEvent.m5087a(VideoAnalyticsAttributes.IS_BROADCAST.value, videoPlaybackAnalyticsParams.b());
            if (videoPlaybackAnalyticsParams.c() != null && !videoPlaybackAnalyticsParams.c().equals("")) {
                honeyClientEvent.m5090b(VideoAnalyticsAttributes.PROJECTION.value, videoPlaybackAnalyticsParams.c());
            }
        }
    }

    public final VideoLoggingUtils m27066a(JsonNode jsonNode, String str, String str2, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_REPLAYED.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str2);
        b.f3099c = "video";
        b = b;
        this.f19366e.m12218a(b);
        return m27030a(b, str2, jsonNode, z);
    }

    public final VideoLoggingUtils m27069a(String str, JsonNode jsonNode, int i, boolean z) {
        HoneyClientEvent a = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_ENTERED_HD.value).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f));
        a.f3099c = "video";
        a = a;
        this.f19366e.m12218a(a);
        return m27030a(a, str, jsonNode, z);
    }

    public final VideoLoggingUtils m27094b(String str, JsonNode jsonNode, int i, boolean z) {
        HoneyClientEvent a = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_EXITED_HD.value).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f));
        a.f3099c = "video";
        a = a;
        this.f19366e.m12218a(a);
        return m27030a(a, str, jsonNode, z);
    }

    public final VideoLoggingUtils m27061a(JsonNode jsonNode, String str, String str2, String str3, int i, int i2, String str4, PlayerOrigin playerOrigin, String str5, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_PLAYER_PAUSE.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.STREAMING_FORMAT.value, str2).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str3).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5082a(VideoAnalyticsAttributes.LAST_START_POSITION_PARAM.value, (double) (((float) i2) / 1000.0f)).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str4).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, m27033a(str3, str5, "logVideoPlayerPauseEvent"));
        this.f19366e.m12218a(b);
        return m27030a(b, str4, jsonNode, z);
    }

    public final VideoLoggingUtils m27060a(JsonNode jsonNode, String str, String str2, String str3, int i, int i2, String str4, PlayerOrigin playerOrigin, String str5, String str6, boolean z, StallTimeCalculation stallTimeCalculation, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        return !this.f19369h.m27103c(str4) ? this : m27089b(jsonNode, str, str2, str3, i, i2, str4, playerOrigin, str5, str6, z, stallTimeCalculation, videoPlaybackAnalyticsParams);
    }

    public final VideoLoggingUtils m27089b(JsonNode jsonNode, String str, String str2, String str3, int i, int i2, String str4, PlayerOrigin playerOrigin, String str5, String str6, boolean z, StallTimeCalculation stallTimeCalculation, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        if (str3 != null && str3 == EventTriggerType.BY_DEBUG_SILENT.value) {
            return this;
        }
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_PAUSE.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.STREAMING_FORMAT.value, str2).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str3).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5082a(VideoAnalyticsAttributes.LAST_START_POSITION_PARAM.value, (double) (((float) i2) / 1000.0f)).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str4).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, m27033a(str3, str5, "logVideoPausedEvent")).m5090b(VideoAnalyticsAttributes.API_CONFIG.value, str6);
        m27037a(b, videoPlaybackAnalyticsParams);
        m27036a(b, stallTimeCalculation);
        this.f19366e.m12218a(b);
        this.f19369h.m27100a(str4);
        return m27030a(b, str4, jsonNode, z);
    }

    public final VideoLoggingUtils m27062a(JsonNode jsonNode, String str, String str2, String str3, int i, String str4, PlayerOrigin playerOrigin, String str5, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_PLAYER_UNPAUSE.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.STREAMING_FORMAT.value, str2).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str3).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str4).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, m27033a(str3, str5, "logVideoPlayerUnPausedEvent"));
        this.f19366e.m12218a(b);
        return m27030a(b, str4, jsonNode, z);
    }

    private VideoLoggingUtils m27032a(JsonNode jsonNode, String str, String str2, String str3, int i, String str4, PlayerOrigin playerOrigin, String str5, String str6, ChannelEligibility channelEligibility, boolean z, @Nullable StallTimeCalculation stallTimeCalculation, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_UNPAUSED.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.STREAMING_FORMAT.value, str2).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str3).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str4).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, m27033a(str3, str5, "logVideoUnPausedEvent")).m5090b(VideoAnalyticsAttributes.CHANNEL_ELIGIBILITY.value, channelEligibility.eligibility).m5090b(VideoAnalyticsAttributes.API_CONFIG.value, str6);
        m27036a(b, stallTimeCalculation);
        m27037a(b, videoPlaybackAnalyticsParams);
        this.f19366e.m12218a(b);
        this.f19369h.m27101a(str4, str3, str, str5);
        return m27030a(b, str4, jsonNode, z);
    }

    public final VideoLoggingUtils m27055a(JsonNode jsonNode, String str, String str2, int i, int i2, String str3, PlayerOrigin playerOrigin, String str4, String str5, boolean z, @Nullable StallTimeCalculation stallTimeCalculation, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        if (!this.f19369h.m27103c(str3)) {
            return this;
        }
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_COMPLETE.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.STREAMING_FORMAT.value, str2).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5082a(VideoAnalyticsAttributes.LAST_START_POSITION_PARAM.value, (double) (((float) i2) / 1000.0f)).m5094g("video").m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str3).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, m27033a(null, str4, "logVideoCompleteEvent")).m5090b(VideoAnalyticsAttributes.API_CONFIG.value, str5);
        m27037a(b, videoPlaybackAnalyticsParams);
        m27036a(b, stallTimeCalculation);
        this.f19366e.m12218a(b);
        this.f19369h.m27100a(str3);
        return m27030a(b, str3, jsonNode, z);
    }

    public final VideoLoggingUtils m27056a(JsonNode jsonNode, String str, String str2, int i, int i2, String str3, PlayerOrigin playerOrigin, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_SEEK.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5082a(VideoAnalyticsAttributes.SEEK_SOURCE_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i2) / 1000.0f)).m5090b(VideoAnalyticsAttributes.STREAM_TYPE.value, str2).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str3).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, EventTriggerType.BY_USER.value);
        this.f19366e.m12218a(b);
        return m27030a(b, str3, jsonNode, z);
    }

    public final VideoLoggingUtils m27050a(VideoDisplayedInfo videoDisplayedInfo, JsonNode jsonNode, String str, PlayerOrigin playerOrigin, boolean z, ChannelEligibility channelEligibility, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        HoneyClientEvent a = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_DISPLAYED.value).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.CHANNEL_ELIGIBILITY.value, channelEligibility.eligibility).m5088a(videoDisplayedInfo.c());
        m27037a(a, videoPlaybackAnalyticsParams);
        this.f19366e.m12218a(a);
        if (!(str == null || videoDisplayedInfo == null)) {
            this.f19383v.m4433a((Object) str, (Object) videoDisplayedInfo);
        }
        return m27030a(a, str, jsonNode, z);
    }

    public final VideoLoggingUtils m27057a(JsonNode jsonNode, String str, String str2, int i, String str3, PlayerOrigin playerOrigin, boolean z, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_MUTED.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str2).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str3).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin);
        m27037a(b, videoPlaybackAnalyticsParams);
        this.f19366e.m12218a(b);
        return m27030a(b, str3, jsonNode, z);
    }

    public final VideoLoggingUtils m27088b(JsonNode jsonNode, String str, String str2, int i, String str3, PlayerOrigin playerOrigin, boolean z, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_UNMUTED.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str2).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str3).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin);
        m27037a(b, videoPlaybackAnalyticsParams);
        this.f19366e.m12218a(b);
        return m27030a(b, str3, jsonNode, z);
    }

    public final VideoLoggingUtils m27054a(JsonNode jsonNode, String str, String str2, int i, int i2, String str3, PlayerOrigin playerOrigin, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_VOLUME_DECREASE.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str2).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5083a(VideoAnalyticsAttributes.CURRENT_VOLUME.value, i2).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str3).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin);
        m27037a(b, videoPlaybackAnalyticsParams);
        this.f19366e.m12218a(b);
        return m27030a(b, str3, jsonNode, false);
    }

    public final VideoLoggingUtils m27087b(JsonNode jsonNode, String str, String str2, int i, int i2, String str3, PlayerOrigin playerOrigin, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams) {
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_VOLUME_INCREASE.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str2).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5083a(VideoAnalyticsAttributes.CURRENT_VOLUME.value, i2).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str3).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin);
        m27037a(b, videoPlaybackAnalyticsParams);
        this.f19366e.m12218a(b);
        return m27030a(b, str3, jsonNode, false);
    }

    public final VideoLoggingUtils m27065a(JsonNode jsonNode, String str, String str2, String str3, PlayerOrigin playerOrigin, String str4, int i, int i2, boolean z, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams, @Nullable ExternalLogType externalLogType, @Nullable String str5) {
        if ((!str.equals(PlayerType.INLINE_PLAYER.value) ? 1 : null) != null) {
            ((NavigationLogger) this.f19364c.get()).m5511a("video", true);
        } else {
            ((NavigationLogger) this.f19364c.get()).m5519c("video");
        }
        if (!m27046e(str4)) {
            this.f19365d.m2340a(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, StringFormatUtil.a("Invalid player format change reason (%s)", new Object[]{str4}));
        }
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_PLAYER_FORMAT_CHANGED.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.PREVIOUS_PLAYER_TYPE.value, str2).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5082a(VideoAnalyticsAttributes.LAST_START_POSITION_PARAM.value, (double) (((float) i2) / 1000.0f)).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str3).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, str4);
        m27037a(b, videoPlaybackAnalyticsParams);
        m27039a(str3, b);
        m27038a(externalLogType, str5, b);
        this.f19366e.m12218a(b);
        return m27030a(b, str3, jsonNode, z);
    }

    public final VideoLoggingUtils m27051a(JsonNode jsonNode, String str, int i, PlayerOrigin playerOrigin) {
        return m27030a(new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_FULL_SCREEN_ONPAUSE.value).m5083a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, i).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin), str, jsonNode, false);
    }

    public final VideoLoggingUtils m27085b(JsonNode jsonNode, String str, int i, PlayerOrigin playerOrigin) {
        return m27030a(new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_FULL_SCREEN_ONRESUME.value).m5083a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, i).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin), str, jsonNode, false);
    }

    public final VideoLoggingUtils m27092b(JsonNode jsonNode, String str, String str2, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent(VideoChainingAnalyticsEvents.VIDEO_CHAINING_IMPRESSION.value).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str);
        if (str2 != null) {
            b.m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str2);
        }
        this.f19366e.m12218a(b);
        return m27030a(b, str, jsonNode, z);
    }

    public final VideoLoggingUtils m27090b(JsonNode jsonNode, String str, String str2, String str3, int i, int i2, String str4, PlayerOrigin playerOrigin, String str5, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_PLAYER_STOP.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.STREAMING_FORMAT.value, str2).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str3).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5082a(VideoAnalyticsAttributes.LAST_START_POSITION_PARAM.value, (double) (((float) i2) / 1000.0f)).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str4).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, m27033a(str3, str5, "logVideoPlayerStopEvent"));
        this.f19366e.m12218a(b);
        return m27030a(b, str4, jsonNode, z);
    }

    public final VideoLoggingUtils m27052a(JsonNode jsonNode, String str, int i, PlayerOrigin playerOrigin, boolean z, boolean z2) {
        return m27030a(new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_WATCH_AND_BROWSE_DISMISS_VIDEO_PLAYER.value).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str).m5083a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, i).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5087a(VideoAnalyticsAttributes.VIDEO_IS_PLAYING.value, z).m5087a(VideoAnalyticsAttributes.VIDEO_IS_PLAY_COMPLETED.value, z2), str, jsonNode, true);
    }

    public final void m27079a(String str, String str2, String str3, Uri uri, String str4, PlayerOrigin playerOrigin, String str5, VideoPlaybackAnalyticsParams videoPlaybackAnalyticsParams, Exception exception) {
        m27080a(str, str2, str3, Lists.m1300a(VideoDataSource.newBuilder().a(uri).i()), str4, playerOrigin, str5, exception);
    }

    public final void m27080a(String str, String str2, String str3, List<VideoDataSource> list, String str4, PlayerOrigin playerOrigin, String str5, Exception exception) {
        if (exception == null) {
            BLog.b(f19360a, "%s: %s", new Object[]{VideoAnalyticsAttributes.VIDEO_EXCEPTION_TAG.value, str});
        } else {
            BLog.b(f19360a, exception, "%s: %s", new Object[]{VideoAnalyticsAttributes.VIDEO_EXCEPTION_TAG.value, str});
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (VideoDataSource videoDataSource : list) {
            stringBuilder.append(videoDataSource.b);
        }
        HoneyClientEvent b = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_EXCEPTION.value).m5090b(VideoAnalyticsAttributes.VIDEO_EXCEPTION_TAG.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str2).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str3).m5090b(VideoAnalyticsAttributes.URL.value, stringBuilder.toString()).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, m27033a(null, str4, "logVideoException")).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PRODUCT.value, Build.PRODUCT).m5090b(VideoAnalyticsAttributes.DEVICE.value, Build.DEVICE).m5090b(VideoAnalyticsAttributes.BOARD.value, Build.BOARD).m5090b(VideoAnalyticsAttributes.MANUFACTURER.value, Build.MANUFACTURER).m5090b(VideoAnalyticsAttributes.BRAND.value, Build.BRAND).m5090b(VideoAnalyticsAttributes.MODEL.value, Build.MODEL).m5090b(VideoAnalyticsAttributes.API_CONFIG.value, str5);
        this.f19366e.m12218a(b);
        m27041b(b);
        this.f19372k.m27137a(str3, str2 + "." + b.m5101m(VideoAnalyticsAttributes.API_CONFIG.value), str, exception);
    }

    private VideoLoggingUtils m27030a(HoneyClientEvent honeyClientEvent, String str, JsonNode jsonNode, boolean z) {
        Object obj;
        Preconditions.checkNotNull(honeyClientEvent);
        if (str == null || !str.startsWith("GIF:")) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return this;
        }
        if (jsonNode != null) {
            honeyClientEvent.m5085a(VideoAnalyticsAttributes.TRACKING_PARAM.value, jsonNode);
        } else {
            this.f19365d.m2340a(VideoAnalyticsAttributes.VIDEO_EXCEPTION_TAG.value, StringFormatUtil.a("Missing tracking codes: %s", new Object[]{honeyClientEvent.mo700d()}));
        }
        honeyClientEvent.mo699b(z);
        if (str != null) {
            VideoDisplayedInfo videoDisplayedInfo = (VideoDisplayedInfo) this.f19383v.m4432a((Object) str);
            if (videoDisplayedInfo != null) {
                honeyClientEvent.m5088a(videoDisplayedInfo.c());
            }
        }
        if (str != null) {
            if (((AtomicInteger) this.f19384w.m4432a((Object) str)) == null) {
                this.f19384w.m4433a((Object) str, new AtomicInteger(0));
            }
            honeyClientEvent.m5083a(VideoAnalyticsAttributes.SEQUENCE_NUMBER.value, ((AtomicInteger) this.f19384w.m4432a((Object) str)).getAndIncrement());
        }
        if (str != null) {
            Map a = this.f19379r.a(str);
            if (a != null) {
                honeyClientEvent.m5088a(a);
            }
        }
        this.f19370i.mo3108a(honeyClientEvent);
        this.f19373l.mo3108a(honeyClientEvent);
        return m27041b(honeyClientEvent);
    }

    public final VideoLoggingUtils m27049a(VideoAlbumOriginType videoAlbumOriginType) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_ALBUM_PERMALINK_ENTER.value);
        honeyClientEvent.f3099c = "video";
        honeyClientEvent = honeyClientEvent.m5090b(VideoAlbumAttributes.ALBUM_ORIGIN.value, videoAlbumOriginType.value);
        this.f19366e.m12218a(honeyClientEvent);
        return m27030a(honeyClientEvent, null, null, false);
    }

    public final VideoLoggingUtils m27053a(JsonNode jsonNode, String str, int i, String str2, PlayerOrigin playerOrigin, boolean z, boolean z2) {
        String str3;
        if (z2) {
            str3 = ChromecastVideoAnalyticsEvents.CHROMECAST_CAST_VISIBLE.value;
        } else {
            str3 = ChromecastVideoAnalyticsEvents.CHROMECAST_CAST_DISABLED.value;
        }
        HoneyClientEvent b = new HoneyClientEvent(str3).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str2).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin);
        this.f19366e.m12218a(b);
        return m27030a(b, str2, jsonNode, z);
    }

    public final void m27081a(boolean z, PlayerType playerType) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(ChromecastVideoAnalyticsEvents.CHROMECAST_CAST_CHECKED.value);
        honeyClientEvent.m5086a(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, (Object) playerType);
        honeyClientEvent.m5087a(ChromecastVideoAnalyticsAttributes.CAST_BUTTON_VISIBILITY.value, z);
        this.f19366e.m12218a(honeyClientEvent);
        m27041b(honeyClientEvent);
    }

    public final VideoLoggingUtils m27086b(JsonNode jsonNode, String str, int i, String str2, PlayerOrigin playerOrigin, boolean z, boolean z2) {
        HoneyClientEvent b = new HoneyClientEvent(ChromecastVideoAnalyticsEvents.CHROMECAST_CAST_CLICKED.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str2).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin);
        if (z2) {
            b.m5090b(ChromecastVideoAnalyticsAttributes.CAST_BUTTON_CLICK_TYPE.value, ChromecastCastButtonClickType.SHOW_CAST_MENU.value);
        } else {
            b.m5090b(ChromecastVideoAnalyticsAttributes.CAST_BUTTON_CLICK_TYPE.value, ChromecastCastButtonClickType.ATTEMPT_TO_CONNECT.value);
        }
        this.f19366e.m12218a(b);
        return m27030a(b, str2, jsonNode, z);
    }

    public final VideoLoggingUtils m27059a(JsonNode jsonNode, String str, String str2, PlayerOrigin playerOrigin, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent(ChromecastVideoAnalyticsEvents.CHROMECAST_CAST_CONNECTED.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str2).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin);
        this.f19366e.m12218a(b);
        return m27030a(b, str2, jsonNode, z);
    }

    public final VideoLoggingUtils m27074a(String str, String str2, JsonNode jsonNode, String str3, PlayerOrigin playerOrigin, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent(ChromecastVideoAnalyticsEvents.CHROMECAST_CAST_DISCONNECTED.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str3).m5090b(ChromecastVideoAnalyticsAttributes.DISCONNECT_REASON_CODE.value, str2);
        if (playerOrigin != null) {
            b.m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin);
        }
        this.f19366e.m12218a(b);
        return m27030a(b, str3, jsonNode, z);
    }

    public final VideoLoggingUtils m27070a(String str, String str2) {
        HoneyClientEvent b = new HoneyClientEvent(ChromecastVideoAnalyticsEvents.CHROMECAST_CAST_RECONNECTED.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str2);
        this.f19366e.m12218a(b);
        return m27030a(b, str2, null, false);
    }

    public final VideoLoggingUtils m27071a(String str, String str2, int i) {
        HoneyClientEvent a = new HoneyClientEvent(VideoAnalyticsEvents.VIDEO_VR_CAST_CLICK.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str2).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f));
        this.f19366e.m12218a(a);
        return m27030a(a, str2, null, false);
    }

    public final VideoLoggingUtils m27073a(String str, String str2, PlayerOrigin playerOrigin, String str3, String str4) {
        String str5 = VideoAnalyticsEvents.VIDEO_SURFACE_UPDATED.value;
        HoneyClientEvent b = new HoneyClientEvent(str5).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str2).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.API_CONFIG.value, str4).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, m27044c(str3, str5));
        this.f19366e.m12218a(b);
        return m27041b(b);
    }

    public final VideoLoggingUtils m27076a(String str, String str2, String str3, PlayerOrigin playerOrigin, String str4, String str5) {
        String str6 = VideoAnalyticsEvents.VIDEO_NO_SURFACE_UPDATE.value;
        HoneyClientEvent b = new HoneyClientEvent(str6).m5090b(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str2).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str3).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.API_CONFIG.value, str5).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, m27044c(str4, str6));
        this.f19366e.m12218a(b);
        return m27041b(b);
    }

    public final VideoLoggingUtils m27075a(String str, String str2, String str3, int i, int i2, PlayerOrigin playerOrigin, String str4, Format format, StreamRepresentationEventSource streamRepresentationEventSource) {
        return !this.f19369h.m27103c(str3) ? this : m27096b(str, str2, str3, i, i2, playerOrigin, str4, format, streamRepresentationEventSource);
    }

    public final VideoLoggingUtils m27096b(String str, String str2, String str3, int i, int i2, PlayerOrigin playerOrigin, String str4, Format format, StreamRepresentationEventSource streamRepresentationEventSource) {
        if (this.f19386z == null) {
            this.f19386z = (VideoDashConfig) this.f19368g.get();
        }
        if (!this.f19386z.f6858C || !str2.equals(StreamingFormat.DASH.value)) {
            return this;
        }
        String str5 = VideoAnalyticsEvents.VIDEO_REPRESENTATION_ENDED.value;
        HoneyClientEvent a = new HoneyClientEvent(str5).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.STREAMING_FORMAT.value, str2).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str3).m5090b(VideoAnalyticsAttributes.PLAYER_ORIGIN.value, playerOrigin.origin).m5090b(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value, playerOrigin.subOrigin).m5090b(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value, m27044c(str4, str5)).m5082a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, (double) (((float) i) / 1000.0f)).m5082a(VideoAnalyticsAttributes.LAST_START_POSITION_PARAM.value, (double) (((float) i2) / 1000.0f)).m5084a(VideoAnalyticsAttributes.VIDEO_BANDWIDTH_ESTIMATE.value, this.f19374m.m27016c().a()).m5084a(VideoAnalyticsAttributes.FB_BANDWIDTH_ESTIMATE.value, (long) (this.f19375n.m3803e() * 1000.0d));
        if (format != null) {
            a.m5090b(VideoAnalyticsAttributes.STREAM_REPRESENTATION_ID.value, format.a).m5083a(VideoAnalyticsAttributes.STREAM_VIDEO_WIDTH.value, format.d).m5083a(VideoAnalyticsAttributes.STREAM_VIDEO_HEIGHT.value, format.e).m5083a(VideoAnalyticsAttributes.STREAM_BITRATE.value, format.c).m5090b(VideoAnalyticsAttributes.STREAM_MIME_TYPE.value, format.b).m5090b(VideoAnalyticsAttributes.STREAM_REPRESENTATION_EVENT_SOURCE.value, streamRepresentationEventSource.value);
        }
        this.f19366e.m12218a(a);
        return m27041b(a);
    }

    public final VideoLoggingUtils m27068a(String str, long j, int i, int i2, int i3, int i4, float f, int i5) {
        return m27041b(new HoneyClientEvent(SphericalVideoEvents.SPHERICAL_VIDEO_VIEWPORT_CHANGE.value).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str).m5083a(SphericalVideoAttributes.SPHERICAL_VIEWPORT_YAW_ANGLE.value, i).m5083a(SphericalVideoAttributes.SPHERICAL_VIEWPORT_ROLL_ANGLE.value, i3).m5083a(SphericalVideoAttributes.SPHERICAL_VIEWPORT_PITCH_ANGLE.value, i2).m5084a(SphericalVideoAttributes.SPHERICAL_LAST_DRAG_TIMESTAMP.value, j).m5083a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, i4).m5083a(SphericalVideoAttributes.SPHERICAL_FIELD_OF_VIEW_VERTICAL.value, i5).m5082a(SphericalVideoAttributes.SPHERICAL_VIDEO_ASPECT_RATIO.value, (double) f));
    }

    public final VideoLoggingUtils m27084b() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(VideoPlayerServiceAnalyticsEvents.VIDEO_PLAYER_SERVICE_UNAVAILABLE.value);
        this.f19366e.m12218a(honeyClientEvent);
        return m27030a(honeyClientEvent, null, null, false);
    }

    public final VideoLoggingUtils m27095b(String str, String str2) {
        HoneyClientEvent b = new HoneyClientEvent(VideoPlayerServiceAnalyticsEvents.VIDEO_PLAYER_SERVICE_DISCONNECTED.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str2);
        this.f19366e.m12218a(b);
        return m27030a(b, str2, null, false);
    }

    public final VideoLoggingUtils m27072a(String str, String str2, long j) {
        HoneyClientEvent a = new HoneyClientEvent(VideoPlayerServiceAnalyticsEvents.VIDEO_PLAYER_SERVICE_RECONNECTED.value).m5090b(VideoAnalyticsAttributes.VIDEO_PLAYER_TYPE.value, str).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str2).m5084a(VideoAnalyticsAttributes.STALL_TIME.value, j);
        this.f19366e.m12218a(a);
        return m27030a(a, str2, null, false);
    }

    public final VideoLoggingUtils m27048a(SurfaceTexturePoolEvents surfaceTexturePoolEvents, int i, boolean z) {
        return m27041b(new HoneyClientEvent(surfaceTexturePoolEvents.value).m5083a(SurfaceTexturePoolAttributes.POOL_COUNT.value, i).m5087a(SurfaceTexturePoolAttributes.IS_360_VIDEO.value, z));
    }

    public final VideoLoggingUtils m27047a(int i, MemoryTrimType memoryTrimType) {
        return m27041b(new HoneyClientEvent(SurfaceTexturePoolEvents.SURFACE_TEXTURE_POOL_TRIMMED.value).m5083a(SurfaceTexturePoolAttributes.POOL_COUNT.value, i).m5086a(SurfaceTexturePoolAttributes.TRIM_TYPE.value, (Object) memoryTrimType));
    }

    public final VideoLoggingUtils m27067a(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, String str2) {
        return m27041b(new HoneyClientEvent(HeadingIndicatorEvents.SPHERICAL_VIDEO_HEADING_INDICATOR_CLICK.value).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str).m5083a(HeadingIndicatorEventAttributes.PITCH_ANGLE.value, i2).m5083a(HeadingIndicatorEventAttributes.YAW_ANGLE.value, i).m5083a(HeadingIndicatorEventAttributes.TARGET_PITCH_ANGLE.value, i5).m5083a(HeadingIndicatorEventAttributes.TARGET_YAW_ANGLE.value, i4).m5083a(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value, i7).m5083a(HeadingIndicatorEventAttributes.FIELD_OF_VIEW_VERTICAL.value, i3).m5083a(HeadingIndicatorEventAttributes.TARGET_FIELD_OF_VIEW_VERTICAL.value, i6).m5090b(HeadingIndicatorEventAttributes.PLAYING_SURFACE.value, str2));
    }

    public final VideoLoggingUtils m27093b(String str) {
        return m27041b(new HoneyClientEvent(SphericalVideoContentClickEvents.HEADING_RESET.value).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str));
    }

    public final VideoLoggingUtils m27097c(String str) {
        return m27041b(new HoneyClientEvent(SphericalVideoContentClickEvents.VIEWPORT_ROTATED.value).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str));
    }

    public final VideoLoggingUtils m27098d(String str) {
        return m27041b(new HoneyClientEvent(SphericalVideoContentClickEvents.VIEWPORT_ZOOMED.value).m5090b(VideoAnalyticsAttributes.VIDEO_ID.value, str));
    }

    private VideoLoggingUtils m27041b(HoneyClientEvent honeyClientEvent) {
        Preconditions.checkNotNull(honeyClientEvent);
        honeyClientEvent.m5094g("video");
        this.f19371j.a(honeyClientEvent);
        this.f19376o.m27132a(honeyClientEvent);
        if (this.f19377p.mo596a(ExperimentsForAnalyticsClientModule.d, false)) {
            honeyClientEvent.m5092c(true);
        }
        if (this.f19378q.m2189a(VideoAbTestGatekeepers.f18920h, false)) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(honeyClientEvent.m5101m(VideoAnalyticsAttributes.SEQUENCE_NUMBER.value));
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            String m = honeyClientEvent.m5101m(VideoAnalyticsAttributes.VIDEO_ID.value);
            if (parseInt > 1000 && !Strings.isNullOrEmpty(m)) {
                this.f19365d.m2340a("too_many_events", StringFormatUtil.a("Too many events for same video: (%s)", new Object[]{honeyClientEvent.mo700d()}));
            }
        }
        this.f19363b.mo528a(honeyClientEvent);
        m27034a(honeyClientEvent);
        m27045c(honeyClientEvent);
        return this;
    }

    private void m27045c(HoneyClientEvent honeyClientEvent) {
        if (this.f19385y == VerboseLoggingParam.NONE) {
            return;
        }
        if (this.f19385y != VerboseLoggingParam.ONLY_CORE_ANALYTICS_EVENTS || f19361x.contains(honeyClientEvent.f3111d)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VideoLoggingUtils: VIDEO EVENT \n");
            stringBuilder.append("VideoLoggingUtils: ____________________________\n");
            stringBuilder.append("VideoLoggingUtils: " + honeyClientEvent.f3111d + "(" + honeyClientEvent.m5101m("video_id") + ")\n");
            stringBuilder.append("VideoLoggingUtils: ----------------------------\n");
            stringBuilder.append("VideoLoggingUtils:      Time:        " + honeyClientEvent.m5101m("video_time_position") + "(Cur) | " + honeyClientEvent.m5101m("video_last_start_time_position") + "(LST) | " + honeyClientEvent.m5101m("video_seek_source_time_position") + "(Source)\n");
            stringBuilder.append("VideoLoggingUtils:      Play_Reason: " + honeyClientEvent.m5101m("video_play_reason") + "\n");
            stringBuilder.append("VideoLoggingUtils:      Player:      " + honeyClientEvent.m5101m("player") + "\n");
            stringBuilder.append("VideoLoggingUtils:      Channel_Session: " + honeyClientEvent.m5101m("video_chaining_session_id") + "\n");
            stringBuilder.append("VideoLoggingUtils:      Channel_Depth: " + honeyClientEvent.m5101m("video_chaining_depth_level") + "\n");
            stringBuilder.append("VideoLoggingUtils:      Player_Orig: " + honeyClientEvent.m5101m("player_origin") + "\n");
            stringBuilder.append("VideoLoggingUtils:      Player_Suborig: " + honeyClientEvent.m5101m("player_suborigin") + "\n");
            stringBuilder.append("VideoLoggingUtils:      All:         " + honeyClientEvent.mo700d() + "\n");
        }
    }
}
