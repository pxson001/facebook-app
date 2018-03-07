package com.facebook.feed.autoplay;

import android.net.Uri;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.util.TriState;
import com.facebook.common.util.UriUtil;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.feed.feature.ExperimentsForFeedFeatureModule;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.video.util.VideoUtils;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentStyleInfo;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import com.facebook.video.server.VideoServer;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker.APSettingCheckerParams;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import com.facebook.video.videohome.plugins.VideoHomeNonPlayingOverlayPlugin;
import com.facebook.video.videohome.plugins.VideoHomeNonPlayingOverlayPlugin.1;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: photo_count */
public class AutoplayStateManager {
    private static final String f4914a = AutoplayStateManager.class.getName();
    private boolean f4915A;
    private GraphQLVideoBroadcastStatus f4916B;
    private WeakReference<InteractionListener> f4917C;
    public final QeAccessor f4918b;
    private final AbstractFbErrorReporter f4919c;
    private final VideoAutoPlaySettingsChecker f4920d;
    private final VideoServer f4921e;
    public final DeviceConditionHelper f4922f;
    private final Provider<TriState> f4923g;
    public final GraphQLStoryAttachmentStyle f4924h;
    public final GraphQLStoryAttachmentStyle f4925i;
    public final boolean f4926j;
    private final boolean f4927k;
    private final FbDataConnectionManager f4928l;
    public final VideoLivePlaybackConfig f4929m;
    public final VideoHomeConfig f4930n;
    private final Set<AutoPlayFailureReason> f4931o = new HashSet();
    private boolean f4932p = false;
    public boolean f4933q = false;
    private boolean f4934r = false;
    private boolean f4935s = false;
    private boolean f4936t = false;
    private boolean f4937u = false;
    public boolean f4938v = false;
    public boolean f4939w = false;
    private Uri f4940x;
    private int f4941y;
    private int f4942z;

    @Inject
    public AutoplayStateManager(QeAccessor qeAccessor, @Nullable @Assisted FeedProps<GraphQLStory> feedProps, @Assisted GraphQLVideo graphQLVideo, @Assisted Integer num, FbErrorReporter fbErrorReporter, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoServer videoServer, DeviceConditionHelper deviceConditionHelper, QuickExperimentController quickExperimentController, Provider<TriState> provider, FbDataConnectionManager fbDataConnectionManager, VideoLivePlaybackConfig videoLivePlaybackConfig, VideoHomeConfig videoHomeConfig) {
        this.f4918b = qeAccessor;
        this.f4919c = fbErrorReporter;
        this.f4920d = videoAutoPlaySettingsChecker;
        this.f4921e = videoServer;
        this.f4922f = deviceConditionHelper;
        this.f4923g = provider;
        GraphQLStory graphQLStory = feedProps == null ? null : (GraphQLStory) feedProps.a();
        if (graphQLStory != null) {
            GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
            ImmutableList w = o.w();
            this.f4924h = w.isEmpty() ? null : (GraphQLStoryAttachmentStyle) w.get(0);
            this.f4927k = StoryProps.p(feedProps);
            GraphQLStoryAttachmentStyleInfo a = GraphQLStoryAttachmentUtil.a(o);
            this.f4926j = a == null ? false : a.x();
        } else {
            this.f4924h = GraphQLStoryAttachmentStyle.VIDEO_AUTOPLAY;
            this.f4927k = false;
            this.f4926j = true;
        }
        this.f4925i = m5307a(graphQLStory, num.intValue());
        m5312a(graphQLVideo);
        this.f4937u = graphQLVideo.ai();
        this.f4928l = fbDataConnectionManager;
        this.f4929m = videoLivePlaybackConfig;
        this.f4930n = videoHomeConfig;
    }

    public final void m5311a() {
        this.f4933q = true;
        this.f4934r = false;
    }

    public final void m5314a(boolean z, boolean z2) {
        if (z) {
            this.f4932p = true;
        }
        this.f4933q = false;
        if (!z) {
            this.f4934r = z2;
        }
        1 r = m5310r();
        if (r != null) {
            VideoHomeNonPlayingOverlayPlugin.d(r.a);
        }
    }

    public final void m5312a(GraphQLVideo graphQLVideo) {
        this.f4940x = UriUtil.a(graphQLVideo.aE());
        this.f4941y = graphQLVideo.o();
        this.f4942z = graphQLVideo.s();
        this.f4915A = graphQLVideo.aj();
        this.f4916B = graphQLVideo.t();
    }

    public final void m5318c() {
        this.f4935s = true;
    }

    public final void m5319d() {
        this.f4934r = false;
    }

    public final void m5320e() {
        this.f4934r = true;
    }

    public final void m5321f() {
        this.f4932p = true;
        1 r = m5310r();
        if (r != null) {
            VideoHomeNonPlayingOverlayPlugin.d(r.a);
        }
    }

    public final void m5322g() {
        if (((TriState) this.f4923g.get()).equals(TriState.YES)) {
            m5323h();
        }
    }

    public final void m5323h() {
        this.f4932p = false;
    }

    public final void m5324i() {
        this.f4936t = true;
    }

    public final void m5317b(boolean z) {
        this.f4938v = z;
    }

    public final boolean m5325j() {
        this.f4931o.clear();
        return m5315a(this.f4931o);
    }

    public final boolean m5316a(Set<AutoPlayFailureReason> set, boolean z) {
        if (this.f4938v) {
            return true;
        }
        if (this.f4932p) {
            set.add(AutoPlayFailureReason.DISABLED_BY_ALREADY_SEEN);
        }
        if (m5309q()) {
            set.add(AutoPlayFailureReason.DISABLED_BY_CACHE_NOT_READY);
        }
        if (this.f4937u) {
            if (this.f4920d.r.d) {
                if (set != null) {
                    set.add(AutoPlayFailureReason.DISABLED_BY_360_AUTOPLAY_SENSOR_REQUIREMENT);
                }
            }
            if (set != null) {
                boolean isEmpty = set.isEmpty();
            }
        }
        if (!m5308b(set, z) || this.f4933q || this.f4934r || this.f4936t) {
            return false;
        }
        return true;
    }

    public final boolean m5315a(Set<AutoPlayFailureReason> set) {
        return m5316a((Set) set, false);
    }

    public final boolean m5326k() {
        this.f4931o.clear();
        return m5308b(this.f4931o, false);
    }

    private boolean m5308b(Set<AutoPlayFailureReason> set, boolean z) {
        boolean z2 = false;
        if (!(this.f4924h == GraphQLStoryAttachmentStyle.VIDEO_AUTOPLAY || this.f4924h == GraphQLStoryAttachmentStyle.VIDEO_DIRECT_RESPONSE_AUTOPLAY || this.f4924h == GraphQLStoryAttachmentStyle.VIDEO_CINEMAGRAPH || this.f4924h == GraphQLStoryAttachmentStyle.ALBUM || this.f4924h == GraphQLStoryAttachmentStyle.MULTI_SHARE_NON_LINK_VIDEO || this.f4924h == GraphQLStoryAttachmentStyle.INSTANT_ARTICLE_VIDEO)) {
            Object obj = ((this.f4924h == GraphQLStoryAttachmentStyle.MULTI_SHARE || this.f4924h == GraphQLStoryAttachmentStyle.MULTI_SHARE_NO_END_CARD) && this.f4925i != null && (this.f4925i == GraphQLStoryAttachmentStyle.VIDEO_AUTOPLAY || this.f4925i == GraphQLStoryAttachmentStyle.VIDEO_DIRECT_RESPONSE_AUTOPLAY)) ? 1 : null;
            if (obj == null && this.f4924h != GraphQLStoryAttachmentStyle.ANIMATED_IMAGE_AUTOPLAY) {
                if (this.f4924h == GraphQLStoryAttachmentStyle.ANIMATED_IMAGE_VIDEO_AUTOPLAY) {
                    if (!this.f4918b.a(ExperimentsForFeedFeatureModule.a, false)) {
                        z2 = true;
                    }
                } else if (!(this.f4930n.g && this.f4926j && this.f4922f.b())) {
                    z2 = true;
                }
            }
        }
        if (z2 && !z) {
            set.add(AutoPlayFailureReason.DISABLED_BY_SERVER);
        }
        ConnectionQuality connectionQuality;
        long j;
        if (this.f4916B == GraphQLVideoBroadcastStatus.LIVE) {
            ConnectionQuality connectionQuality2;
            if (this.f4939w) {
                connectionQuality2 = this.f4929m.j;
            } else {
                connectionQuality2 = this.f4929m.i;
            }
            connectionQuality = connectionQuality2;
            if (this.f4939w) {
                j = this.f4930n.i;
            } else {
                j = this.f4929m.Z;
            }
            this.f4920d.a(set, new APSettingCheckerParams(connectionQuality, Long.valueOf(j).longValue()));
        } else if (VideoUtils.m5398a(this.f4915A, this.f4916B)) {
            set.add(AutoPlayFailureReason.DISABLED_BY_VOD_NOT_READY);
        } else {
            connectionQuality = ConnectionQuality.MODERATE;
            if (this.f4939w) {
                j = this.f4930n.j;
            } else {
                j = this.f4929m.Z;
            }
            this.f4920d.a(set, new APSettingCheckerParams(connectionQuality, Long.valueOf(j).longValue()));
        }
        return set.isEmpty();
    }

    @Nullable
    private static GraphQLStoryAttachmentStyle m5307a(@Nullable GraphQLStory graphQLStory, int i) {
        if (i < 0 || graphQLStory == null || StoryAttachmentHelper.i(graphQLStory) == null || StoryAttachmentHelper.i(graphQLStory).get(i) == null || ((GraphQLStoryAttachment) StoryAttachmentHelper.i(graphQLStory).get(i)).w() == null) {
            return null;
        }
        return (GraphQLStoryAttachmentStyle) ((GraphQLStoryAttachment) StoryAttachmentHelper.i(graphQLStory).get(i)).w().get(0);
    }

    private boolean m5309q() {
        if (this.f4927k || !this.f4935s || !this.f4922f.b()) {
            return false;
        }
        int i;
        int a = this.f4918b.a(ExperimentsForVideoAbTestModule.a, -1);
        int a2 = this.f4918b.a(ExperimentsForVideoAbTestModule.b, -1);
        if (a2 < 0 || this.f4941y <= 0 || this.f4942z <= 0) {
            i = a;
        } else {
            i = this.f4941y + (a2 * (this.f4942z / 8));
        }
        if (i < 0) {
            return false;
        }
        long j = -1;
        try {
            j = this.f4921e.h(this.f4940x);
        } catch (Throwable e) {
            this.f4919c.a(f4914a, "Error checking video cache for autoplay", e);
        }
        if (j < 0 || j >= ((long) i)) {
            return false;
        }
        a2 = i - ((int) j);
        a = this.f4918b.a(ExperimentsForVideoAbTestModule.c, -1);
        if (a > 0) {
            a = (int) ((this.f4928l.e() * ((double) a)) / 8.0d);
        } else {
            a = 0;
        }
        if (a < a2) {
            return true;
        }
        return false;
    }

    public final void m5313a(@Nullable 1 1) {
        this.f4917C = new WeakReference(1);
    }

    @Nullable
    private 1 m5310r() {
        return this.f4917C == null ? null : (1) this.f4917C.get();
    }
}
