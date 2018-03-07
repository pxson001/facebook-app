package com.facebook.video.videohome.environment;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.analytics.vpvlogging.VpvEventHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.video.analytics.VideoAnalytics.VideoHomeAnalyticsAttributes;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager.SessionStatusListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: start_immediately */
public class VideoHomeHScrollLoggingController {
    private static volatile VideoHomeHScrollLoggingController f2870f;
    private final Map<String, VideoHomeHScrollLoggingData> f2871a = new HashMap();
    private final VpvEventHelper f2872b;
    public final Clock f2873c;
    private final VideoHomeSessionManager f2874d;
    private final SessionStatusListener f2875e;

    /* compiled from: start_immediately */
    class C02671 implements SessionStatusListener {
        final /* synthetic */ VideoHomeHScrollLoggingController f2865a;

        C02671(VideoHomeHScrollLoggingController videoHomeHScrollLoggingController) {
            this.f2865a = videoHomeHScrollLoggingController;
        }

        public final void m2770a() {
            this.f2865a.m2779b();
        }

        public final void kM_() {
        }

        public final void kN_() {
        }

        public final void m2771e() {
        }
    }

    /* compiled from: start_immediately */
    class VideoHomeHScrollLoggingData {
        public final FeedProps<GraphQLStory> f2866a;
        public final String f2867b;
        public long f2868c;
        final /* synthetic */ VideoHomeHScrollLoggingController f2869d;

        public VideoHomeHScrollLoggingData(VideoHomeHScrollLoggingController videoHomeHScrollLoggingController, FeedProps<GraphQLStory> feedProps, String str) {
            this.f2869d = videoHomeHScrollLoggingController;
            this.f2866a = feedProps;
            this.f2867b = str;
            this.f2868c = videoHomeHScrollLoggingController.f2873c.a();
        }

        public final void m2772a() {
            this.f2868c = this.f2869d.f2873c.a();
        }
    }

    public static com.facebook.video.videohome.environment.VideoHomeHScrollLoggingController m2773a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2870f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.videohome.environment.VideoHomeHScrollLoggingController.class;
        monitor-enter(r1);
        r0 = f2870f;	 Catch:{ all -> 0x003a }
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
        r0 = m2775b(r0);	 Catch:{ all -> 0x0035 }
        f2870f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2870f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.videohome.environment.VideoHomeHScrollLoggingController.a(com.facebook.inject.InjectorLike):com.facebook.video.videohome.environment.VideoHomeHScrollLoggingController");
    }

    private static VideoHomeHScrollLoggingController m2775b(InjectorLike injectorLike) {
        return new VideoHomeHScrollLoggingController((Clock) SystemClockMethodAutoProvider.a(injectorLike), VpvEventHelper.b(injectorLike), VideoHomeSessionManager.a(injectorLike));
    }

    @Inject
    public VideoHomeHScrollLoggingController(Clock clock, VpvEventHelper vpvEventHelper, VideoHomeSessionManager videoHomeSessionManager) {
        this.f2873c = clock;
        this.f2872b = vpvEventHelper;
        this.f2874d = videoHomeSessionManager;
        this.f2875e = new C02671(this);
        this.f2874d.a(this.f2875e);
    }

    public final synchronized void m2778a(ReactionUnitComponentNode reactionUnitComponentNode, GraphQLStory graphQLStory, String str) {
        Preconditions.checkNotNull(graphQLStory);
        m2777a(reactionUnitComponentNode);
        this.f2871a.put(reactionUnitComponentNode.k(), new VideoHomeHScrollLoggingData(this, FeedProps.c(graphQLStory), str));
    }

    public final synchronized void m2777a(ReactionUnitComponentNode reactionUnitComponentNode) {
        VideoHomeHScrollLoggingData videoHomeHScrollLoggingData = (VideoHomeHScrollLoggingData) this.f2871a.remove(reactionUnitComponentNode.k());
        if (videoHomeHScrollLoggingData != null) {
            m2774a(videoHomeHScrollLoggingData);
        }
    }

    public final synchronized void m2776a() {
        for (String str : this.f2871a.keySet()) {
            VideoHomeHScrollLoggingData videoHomeHScrollLoggingData = (VideoHomeHScrollLoggingData) this.f2871a.get(str);
            if (videoHomeHScrollLoggingData != null) {
                m2774a(videoHomeHScrollLoggingData);
            }
        }
        this.f2871a.clear();
    }

    public final synchronized void m2779b() {
        for (VideoHomeHScrollLoggingData a : this.f2871a.values()) {
            a.m2772a();
        }
    }

    private void m2774a(VideoHomeHScrollLoggingData videoHomeHScrollLoggingData) {
        long a = this.f2873c.a() - videoHomeHScrollLoggingData.f2868c;
        if (a > 100 && this.f2874d.g()) {
            String str;
            Builder builder = ImmutableMap.builder();
            builder.b(VideoHomeAnalyticsAttributes.REACTION_COMPONENT_TRACKING_FIELD.value, videoHomeHScrollLoggingData.f2867b);
            GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) videoHomeHScrollLoggingData.f2866a.a);
            if (o == null || o.r() == null || !o.r().aq()) {
                str = null;
            } else {
                str = o.r().br().toString();
            }
            String str2 = str;
            if (str2 != null) {
                builder.b(VideoHomeAnalyticsAttributes.BROADCAST_STATUS_FIELD.value, str2);
            }
            this.f2872b.a(TrackableFeedProps.a(videoHomeHScrollLoggingData.f2866a), a, "video_home", (FeedUnit) videoHomeHScrollLoggingData.f2866a.a, -1, null, builder.b());
        }
    }
}
