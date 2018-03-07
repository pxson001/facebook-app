package com.facebook.video.engine;

import android.net.Uri;
import android.view.View;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.api.VideoMetadata;
import com.facebook.video.downloadmanager.DownloadManager;
import com.facebook.video.downloadmanager.VideoDownloadRecord;
import com.facebook.video.engine.VideoPlayer.VideoSourceType;
import com.facebook.video.engine.texview.VideoSurfaceTarget;
import com.facebook.video.events.VideoDownloadStatus.DownloadStatus;
import com.facebook.video.server.VideoServer;
import com.facebook.video.subtitles.controller.Subtitles;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@VisibleForTesting
/* compiled from: percentile_99 */
public class VideoPlayerManager$VideoManagerPlayer implements VideoPlayer {
    public final WeakReference<VideoPlayerManager> f5293a;
    public final VideoPlayerManager$VideoManagerPlayerListener f5294b;
    public final int f5295c;
    public VideoPlayer f5296d;
    private PlayerOrigin f5297e;
    private PlayerType f5298f;
    private WeakReference<VideoSurfaceTarget> f5299g;

    public VideoPlayerManager$VideoManagerPlayer(WeakReference<VideoPlayerManager> weakReference, VideoPlayer videoPlayer, VideoPlayerManager$VideoManagerPlayerListener videoPlayerManager$VideoManagerPlayerListener, int i) {
        Preconditions.checkNotNull(weakReference);
        Preconditions.checkNotNull(videoPlayer);
        this.f5293a = weakReference;
        this.f5296d = videoPlayer;
        this.f5294b = videoPlayerManager$VideoManagerPlayerListener;
        this.f5295c = i;
    }

    public final TypedEventBus mo513q() {
        return this.f5296d.mo513q();
    }

    public final String mo496r() {
        return this.f5296d.mo496r();
    }

    public final int mo514s() {
        return this.f5296d.mo514s();
    }

    public final void mo503e(EventTriggerType eventTriggerType) {
        this.f5296d.mo503e(eventTriggerType);
    }

    public final long mo515t() {
        return this.f5296d.mo515t();
    }

    public final VideoMetadata mo512p() {
        if (this.f5296d == null) {
            return null;
        }
        return this.f5296d.mo512p();
    }

    public final int mo508l() {
        return this.f5296d.mo508l();
    }

    public final int m5813c() {
        return this.f5295c;
    }

    public final void m5836u() {
        if (this.f5294b != null) {
            this.f5294b.mo465d();
        }
        m5794x();
    }

    public final void mo478a(VideoPlayerParams videoPlayerParams) {
        if (((VideoPlayerManager) this.f5293a.get()).s.a(ExperimentsForVideoAbTestModule.cW, false)) {
            DownloadManager downloadManager = (DownloadManager) ((VideoPlayerManager) this.f5293a.get()).W.get();
            if (downloadManager.f(videoPlayerParams.f4833b)) {
                VideoPlayerParamsBuilder a = new VideoPlayerParamsBuilder().m5262a(videoPlayerParams);
                List<VideoDataSource> list = a.f4851a;
                List arrayList = new ArrayList();
                for (VideoDataSource videoDataSource : list) {
                    Uri d = VideoServer.d(videoDataSource.f4816b);
                    if (d == null) {
                        d = videoDataSource.f4816b;
                    }
                    String str = null;
                    VideoDownloadRecord a2 = downloadManager.c.a(videoPlayerParams.f4833b);
                    if (a2 != null) {
                        Uri i = FacebookUriUtil.i(d);
                        Uri i2 = FacebookUriUtil.i(a2.b);
                        i.equals(i2);
                        if ((a2.f == DownloadStatus.DOWNLOAD_COMPLETED || a2.f == DownloadStatus.DOWNLOAD_IN_PROGRESS) && i.equals(i2)) {
                            str = a2.e;
                        }
                    }
                    String str2 = str;
                    if (str2 != null) {
                        String str3 = videoPlayerParams.f4833b;
                        VideoDataSourceBuilder videoDataSourceBuilder = new VideoDataSourceBuilder();
                        videoDataSourceBuilder.f4824a = Uri.fromFile(new File(str2));
                        videoDataSourceBuilder.f4829f = StreamSourceType.FROM_LOCAL_STORAGE;
                        arrayList.add(videoDataSourceBuilder.m5254i());
                    } else {
                        str2 = videoPlayerParams.f4833b;
                        d.toString();
                        arrayList.add(videoDataSource);
                    }
                }
                arrayList.addAll(arrayList);
                a.m5264a(arrayList);
                videoPlayerParams = a.m5271m();
            } else {
                String str4 = videoPlayerParams.f4833b;
            }
        }
        this.f5296d.mo478a(videoPlayerParams);
    }

    public final void mo483a(Subtitles subtitles) {
        this.f5296d.mo483a(subtitles);
    }

    public final void mo491d() {
        this.f5296d.mo491d();
    }

    public final void mo481a(VideoSurfaceTarget videoSurfaceTarget) {
        Preconditions.checkNotNull(this.f5296d);
        this.f5296d.mo481a(videoSurfaceTarget);
        m5794x();
        this.f5299g = new WeakReference(videoSurfaceTarget);
        ((VideoPlayerManager) this.f5293a.get()).e.add(this.f5299g);
    }

    public final void mo474a(EventTriggerType eventTriggerType) {
        mo476a(eventTriggerType, PlayPosition.f5359a);
    }

    public final void mo502d(EventTriggerType eventTriggerType) {
        this.f5296d.mo502d(eventTriggerType);
    }

    public final void mo476a(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        Preconditions.checkNotNull(this.f5296d);
        ((VideoPlayerManager) this.f5293a.get()).a(this, eventTriggerType, playPosition);
    }

    public final void mo489b(EventTriggerType eventTriggerType) {
        ((VideoPlayerManager) this.f5293a.get()).a(this, eventTriggerType);
    }

    public final void mo490c(EventTriggerType eventTriggerType) {
        ((VideoPlayerManager) this.f5293a.get()).b(this, eventTriggerType);
    }

    public final void mo473a(int i, EventTriggerType eventTriggerType) {
        ((VideoPlayerManager) this.f5293a.get()).a(this, eventTriggerType, i);
    }

    public final void mo485a(boolean z, EventTriggerType eventTriggerType) {
        if (this.f5296d != null) {
            this.f5296d.mo485a(z, eventTriggerType);
        }
    }

    public final void mo471a(float f) {
        if (this.f5296d != null) {
            this.f5296d.mo471a(f);
        }
    }

    public final void mo479a(VideoResolution videoResolution, EventTriggerType eventTriggerType) {
        if (this.f5296d != null) {
            this.f5296d.mo479a(videoResolution, eventTriggerType);
        }
    }

    public final void mo477a(VideoSourceType videoSourceType, String str, EventTriggerType eventTriggerType) {
        if (this.f5296d != null) {
            this.f5296d.mo477a(videoSourceType, str, eventTriggerType);
        }
    }

    public final VideoResolution mo492e() {
        if (this.f5296d == null) {
            return null;
        }
        return this.f5296d.mo492e();
    }

    public final void mo500a(PlayerOrigin playerOrigin) {
        this.f5297e = playerOrigin;
        if (this.f5296d != null) {
            this.f5296d.mo500a(this.f5297e);
        }
    }

    public final PlayerOrigin mo504g() {
        return this.f5297e;
    }

    public final void mo501a(PlayerType playerType) {
        this.f5298f = playerType;
        if (this.f5296d != null) {
            this.f5296d.mo501a(playerType);
        }
    }

    public final void mo499a(ChannelEligibility channelEligibility) {
        this.f5296d.mo499a(channelEligibility);
    }

    public final Subtitles mo511o() {
        if (this.f5296d == null) {
            return null;
        }
        return this.f5296d.mo511o();
    }

    public final void mo493f() {
        new Object[1][0] = Integer.valueOf(this.f5295c);
        if (this.f5293a.get() != null) {
            VideoPlayerManager.j((VideoPlayerManager) this.f5293a.get(), this);
        }
        if (this.f5293a.get() != null) {
            ((VideoPlayerManager) this.f5293a.get()).a(this);
        }
        if (this.f5296d != null) {
            this.f5296d.mo493f();
            this.f5296d = null;
        }
    }

    public final boolean mo505h() {
        if (this.f5296d == null) {
            return false;
        }
        return this.f5296d.mo505h();
    }

    public final boolean mo506i() {
        if (this.f5296d == null) {
            return false;
        }
        return this.f5296d.mo506i();
    }

    public final boolean mo486a() {
        if (this.f5296d == null) {
            return false;
        }
        return this.f5296d.mo486a();
    }

    public final boolean mo507j() {
        if (this.f5296d == null) {
            return false;
        }
        return this.f5296d.mo507j();
    }

    public final View mo495k() {
        Preconditions.checkNotNull(this.f5296d);
        return this.f5296d.mo495k();
    }

    public final void mo510n() {
        if (this.f5296d != null) {
            this.f5296d.mo510n();
        }
    }

    public final int mo487b() {
        return this.f5296d.mo487b();
    }

    public final int mo509m() {
        return this.f5296d.mo509m();
    }

    private void m5794x() {
        if (this.f5299g != null && this.f5293a.get() != null) {
            ((VideoPlayerManager) this.f5293a.get()).e.remove(this.f5299g);
            this.f5299g = null;
        }
    }

    public final void m5812b(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        Preconditions.checkNotNull(this.f5296d);
        this.f5296d.mo476a(eventTriggerType, playPosition);
    }

    public final void m5820f(EventTriggerType eventTriggerType) {
        if (this.f5296d != null) {
            this.f5296d.mo489b(eventTriggerType);
        }
    }

    public final void m5822g(EventTriggerType eventTriggerType) {
        Preconditions.checkNotNull(this.f5296d);
        this.f5296d.mo490c(eventTriggerType);
    }

    public final void m5799a(EventTriggerType eventTriggerType, int i) {
        Preconditions.checkNotNull(this.f5296d);
        this.f5296d.mo473a(i, eventTriggerType);
    }
}
