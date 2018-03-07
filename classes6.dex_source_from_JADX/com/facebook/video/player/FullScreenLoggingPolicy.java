package com.facebook.video.player;

import android.net.Uri;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.FlattenedVideoPlaybackAnalyticsParams;
import com.facebook.video.analytics.FullScreenStartedPlayingInfo;
import com.facebook.video.analytics.StallTimeCalculation;
import com.facebook.video.analytics.SuggestedVideoInfo;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.analytics.VideoAnalytics.StreamingFormat;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo;
import com.facebook.video.analytics.VideoDataSourceInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.analytics.VideoPlaybackAnalyticsParams;
import com.facebook.video.analytics.VideoPlayerInfo;
import com.facebook.video.analytics.VideoTimeSpentInfo;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;

/* compiled from: composer_post */
public class FullScreenLoggingPolicy {
    public final VideoLoggingUtils f18996a;
    public final VideoTimeSpentInfo f18997b;
    public final VideoFeedStoryInfo f18998c;
    private final SuggestedVideoInfo f18999d;
    public final FullScreenStartedPlayingInfo f19000e;
    private final VideoDataSourceInfo f19001f;
    public final VideoAnalyticsRequiredInfo f19002g;
    public final VideoPlayerInfo f19003h;
    private final VideoPlaybackAnalyticsParams f19004i = new FlattenedVideoPlaybackAnalyticsParams(this.f18998c.d, false, false, "");
    public boolean f19005j;
    private StallTimeCalculation f19006k;
    private boolean f19007l;

    public FullScreenLoggingPolicy(VideoLoggingUtils videoLoggingUtils, VideoTimeSpentInfo videoTimeSpentInfo, VideoFeedStoryInfo videoFeedStoryInfo, SuggestedVideoInfo suggestedVideoInfo, FullScreenStartedPlayingInfo fullScreenStartedPlayingInfo, VideoDataSourceInfo videoDataSourceInfo, VideoAnalyticsRequiredInfo videoAnalyticsRequiredInfo, VideoPlayerInfo videoPlayerInfo) {
        this.f18996a = videoLoggingUtils;
        this.f18997b = videoTimeSpentInfo;
        this.f18998c = videoFeedStoryInfo;
        this.f18999d = suggestedVideoInfo;
        this.f19000e = fullScreenStartedPlayingInfo;
        this.f19001f = videoDataSourceInfo;
        this.f19002g = videoAnalyticsRequiredInfo;
        this.f19003h = videoPlayerInfo;
    }

    public final void m27700a(EventTriggerType eventTriggerType, int i, VideoPlayerParams videoPlayerParams) {
        this.f19006k.b();
        if (m27690b(eventTriggerType)) {
            String str;
            VideoLoggingUtils videoLoggingUtils = this.f18996a;
            ArrayNode a = this.f18998c.a();
            String str2 = this.f19003h.b().value;
            String str3 = eventTriggerType.value;
            String str4 = this.f19001f.a().value;
            String a2 = this.f19002g.a();
            PlayerOrigin a3 = this.f19003h.a();
            String b = this.f18999d.b();
            String str5 = this.f18998c.b().value;
            String c = m27691c();
            ChannelEligibility c2 = this.f18998c.c();
            boolean d = this.f18998c.d();
            if (videoPlayerParams != null) {
                str = videoPlayerParams.d;
            } else {
                str = null;
            }
            videoLoggingUtils.a(a, str2, str3, i, str4, a2, a3, b, str5, c, c2, d, str, videoPlayerParams);
        }
    }

    public final void m27699a(EventTriggerType eventTriggerType, int i) {
        this.f19006k.c();
        if (m27690b(eventTriggerType)) {
            this.f18996a.a(this.f18998c.a(), this.f19003h.b().value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, i, this.f19001f.a().value, this.f19002g.a(), this.f19003h.a(), this.f18999d.b(), this.f18998c.b().value, m27691c(), this.f18998c.d(), m27692d(), this.f19004i);
        } else {
            m27701a(eventTriggerType, i, false);
        }
        this.f19006k.a();
    }

    public final void m27705b(EventTriggerType eventTriggerType, int i) {
        this.f19006k.c();
        this.f19000e.b();
        if (m27690b(eventTriggerType)) {
            this.f18996a.b(this.f18998c.a(), this.f19003h.b().value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, i, this.f19001f.a().value, this.f19002g.a(), this.f19003h.a(), this.f18999d.b(), this.f18998c.b().value, m27691c(), this.f18998c.c(), this.f18998c.d(), m27692d(), this.f19004i);
            this.f19006k.a();
        }
    }

    private boolean m27690b(EventTriggerType eventTriggerType) {
        Object obj;
        FullScreenStartedPlayingInfo fullScreenStartedPlayingInfo = this.f19000e;
        if (fullScreenStartedPlayingInfo.b == this.f18997b.b && fullScreenStartedPlayingInfo.c != fullScreenStartedPlayingInfo.b) {
            Object obj2;
            if (eventTriggerType == EventTriggerType.BY_DIALOG || eventTriggerType == EventTriggerType.BY_FLYOUT) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                obj = null;
                if (obj == null || this.f19000e.e) {
                    return true;
                }
                return false;
            }
        }
        obj = 1;
        if (obj == null) {
        }
        return true;
    }

    public final void m27707c(EventTriggerType eventTriggerType, int i) {
        if (!this.f19005j) {
            this.f19000e.b();
            this.f18996a.a(this.f18998c.a(), this.f19003h.b().value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, i, this.f19001f.a().value, this.f19002g.a(), this.f19003h.a(), this.f18999d.b(), this.f18998c.b().value, m27691c(), this.f18998c.c(), this.f18998c.d(), null, this.f19004i);
            this.f19000e.a();
        }
    }

    public final void m27701a(EventTriggerType eventTriggerType, int i, boolean z) {
        if (i < this.f18997b.a()) {
            i = this.f18997b.a();
        }
        this.f18997b.c(i);
        if (z) {
            this.f18996a.a(this.f18998c.a(), this.f19003h.b().value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, this.f18997b.b(), this.f18997b.a(), this.f19002g.a(), this.f19003h.a(), this.f18998c.b().value, m27691c(), this.f18998c.d(), m27692d(), this.f19004i);
        } else {
            this.f18996a.b(this.f18998c.a(), this.f19003h.b().value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, this.f18997b.b(), this.f18997b.a(), this.f19002g.a(), this.f19003h.a(), this.f18998c.b().value, m27691c(), this.f18998c.d(), m27692d(), this.f19004i);
        }
        this.f19006k.a();
        this.f18997b.d(this.f18997b.b());
    }

    public final void m27693a(int i) {
        this.f18997b.c(i);
        this.f19006k.c();
        this.f18996a.a(this.f18998c.a(), this.f19003h.b().value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, this.f18997b.b(), this.f18997b.a(), this.f19002g.a(), this.f19003h.a(), this.f18998c.b().value, m27691c(), this.f18998c.d(), m27692d(), this.f19004i);
        this.f19006k.a();
        this.f18997b.e(0);
        FullScreenStartedPlayingInfo fullScreenStartedPlayingInfo = this.f19000e;
        fullScreenStartedPlayingInfo.b = 0;
        fullScreenStartedPlayingInfo.c = 0;
    }

    public final void m27703a(FullScreenParams fullScreenParams) {
        this.f18996a.a(this.f18998c.a, PlayerType.FULL_SCREEN_PLAYER.value, fullScreenParams.m27723s().b().value, this.f19002g.a(), this.f19003h.a(), this.f18998c.b().value, fullScreenParams.m27714e(), fullScreenParams.m27718m(), this.f18998c.d(), this.f19004i, null, null);
    }

    public final void m27706b(FullScreenParams fullScreenParams) {
        VideoTimeSpentInfo videoTimeSpentInfo = this.f18997b;
        int e = fullScreenParams.m27714e();
        int m = fullScreenParams.m27718m();
        videoTimeSpentInfo.c = e;
        videoTimeSpentInfo.b = m;
        videoTimeSpentInfo.d = -1;
        VideoFeedStoryInfo videoFeedStoryInfo = this.f18998c;
        ArrayNode i = fullScreenParams.m27716i();
        EventTriggerType eventTriggerType = fullScreenParams.f19019l.b;
        ChannelEligibility channelEligibility = fullScreenParams.f19019l.c;
        boolean l = fullScreenParams.m27717l();
        videoFeedStoryInfo.a = i;
        videoFeedStoryInfo.b = eventTriggerType;
        videoFeedStoryInfo.c = channelEligibility;
        videoFeedStoryInfo.d = l;
        this.f18999d.a = false;
        FullScreenStartedPlayingInfo fullScreenStartedPlayingInfo = this.f19000e;
        fullScreenStartedPlayingInfo.b = fullScreenParams.m27718m();
        fullScreenStartedPlayingInfo.c = -1;
        this.f19001f.a = StreamSourceType.FROM_STREAM;
        this.f19003h.b = fullScreenParams.f19018k.b;
        this.f18999d.b = null;
        this.f19002g.a = fullScreenParams.m27719o();
    }

    public final void m27695a(int i, EventTriggerType eventTriggerType) {
        if (!this.f19005j) {
            this.f19007l = this.f18996a.a(this.f19002g.a(), i);
            if (m27690b(eventTriggerType)) {
                this.f19006k.a();
                this.f19006k.b();
                this.f18996a.a(this.f18998c.a(), this.f19003h.b().value, eventTriggerType.value, i, this.f19001f.a().value, this.f19002g.a(), this.f19003h.a(), this.f18999d.b(), this.f18998c.b().value, m27691c(), this.f18998c.c(), this.f18998c.d(), null, this.f19004i);
            }
        }
    }

    public final void m27708c(FullScreenParams fullScreenParams) {
        m27695a(fullScreenParams.m27714e(), EventTriggerType.BY_USER);
    }

    public final void m27698a(EventTriggerType eventTriggerType) {
        if (!this.f19005j) {
            this.f19006k.c();
            this.f18996a.a(this.f18998c.a(), this.f19003h.b().value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, this.f18997b.b(), this.f19001f.a().value, this.f19002g.a(), this.f19003h.a(), this.f18999d.b(), this.f18998c.b().value, m27691c(), this.f18998c.c(), this.f18998c.d(), this.f19006k, this.f19004i);
            this.f19006k.a();
        }
    }

    public final void m27704b() {
        this.f18996a.a(this.f18998c.a, PlayerType.INLINE_PLAYER.value, PlayerType.FULL_SCREEN_PLAYER.value, this.f19002g.a, this.f19003h.b, this.f18998c.b.value, this.f18997b.c, this.f18997b.b, this.f18998c.d, this.f19004i, null, null);
        this.f19000e.a();
    }

    public final void m27702a(EventTriggerType eventTriggerType, boolean z, boolean z2, int i) {
        Object obj = (z || (this.f19000e.e() && z2)) ? 1 : null;
        if (obj != null) {
            if (i < this.f18997b.a()) {
                i = this.f18997b.a();
            }
            this.f18997b.c(i);
            this.f18996a.b(this.f18998c.a(), this.f19003h.b().value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, this.f18997b.b(), this.f18997b.a(), this.f19002g.a(), this.f19003h.a(), this.f18998c.b().value, m27691c(), this.f18998c.d(), m27692d(), this.f19004i);
            this.f19006k.a();
            this.f18997b.d(i);
            this.f19000e.a();
        }
    }

    public final void m27694a(int i, int i2, boolean z) {
        if (i < this.f18997b.a()) {
            i = this.f18997b.a();
        }
        this.f18997b.c(i);
        if (z) {
            this.f18996a.b(this.f18998c.a(), this.f19003h.b().value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, EventTriggerType.BY_ANDROID.value, this.f18997b.b(), this.f18997b.a(), this.f19002g.a(), this.f19003h.a(), this.f18998c.b().value, m27691c(), this.f18998c.d(), m27692d(), this.f19004i);
        }
        this.f19006k.a();
        this.f18996a.a(this.f18998c.a(), this.f19002g.a(), i2, this.f19003h.a());
        this.f18997b.d(i);
        this.f19000e.a();
    }

    public final void m27696a(Uri uri, int i, int i2) {
        this.f18996a.a(StringFormatUtil.a("FullScreen VideoView error = %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), this.f19003h.a.value, this.f19002g.a, uri, this.f18998c.b.value, this.f19003h.b, m27691c(), this.f19004i, null);
    }

    private String m27691c() {
        return this.f19005j ? "new_api_player" : "old_api_psr";
    }

    public final void m27697a(StallTimeCalculation stallTimeCalculation) {
        this.f19006k = (StallTimeCalculation) Preconditions.checkNotNull(stallTimeCalculation);
    }

    private StallTimeCalculation m27692d() {
        return this.f19005j ? this.f19006k : null;
    }
}
