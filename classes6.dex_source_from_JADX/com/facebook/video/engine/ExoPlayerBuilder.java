package com.facebook.video.engine;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_VideoPerformanceExecutorMethodAutoProvider;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.util.StringUtil;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.http.common.CachedNetworkInfoCollector;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.server.VideoServer;
import com.facebook.video.server.VideoServerMethodAutoProvider;
import com.facebook.video.view.exo.ExoPlayerDashStreamRendererBuilder;
import com.facebook.video.view.exo.ExoPlayerHLSStreamRendererBuilder;
import com.facebook.video.view.exo.ExoPlayerProgressiveDownloadRendererBuilder;
import com.facebook.video.view.exo.ExoPlayerStreamRendererBuilder;
import com.facebook.video.view.exo.ExoStreamRendererEventListener;
import com.facebook.video.view.exo.PlaybackPreferences;
import com.google.android.exoplayer.chunk.ChunkSampleSource.EventListener;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: composite_page_nodes */
public class ExoPlayerBuilder {
    private Context f18789a;
    private VideoServer f18790b;
    private DefaultAndroidThreadUtil f18791c;
    private Provider<VideoExoplayerConfig> f18792d;
    private final QeAccessor f18793e;
    private final VideoDashConfig f18794f;
    private final DeviceConditionHelper f18795g;
    private final BandwidthMeter f18796h;
    private final FbDataConnectionManager f18797i;
    private final ListeningExecutorService f18798j;
    private final NetworkInfoCollector f18799k;

    public static ExoPlayerBuilder m27508b(InjectorLike injectorLike) {
        return new ExoPlayerBuilder((Context) injectorLike.getInstance(Context.class), VideoServerMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), IdBasedProvider.a(injectorLike, 3637), VideoDashConfig.a(injectorLike), ListeningExecutorService_VideoPerformanceExecutorMethodAutoProvider.a(injectorLike), DeviceConditionHelper.a(injectorLike), FbDataConnectionManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (NetworkInfoCollector) CachedNetworkInfoCollector.a(injectorLike));
    }

    @Inject
    public ExoPlayerBuilder(Context context, VideoServer videoServer, AndroidThreadUtil androidThreadUtil, Provider<VideoExoplayerConfig> provider, VideoDashConfig videoDashConfig, ListeningExecutorService listeningExecutorService, DeviceConditionHelper deviceConditionHelper, FbDataConnectionManager fbDataConnectionManager, QeAccessor qeAccessor, NetworkInfoCollector networkInfoCollector) {
        this.f18789a = context;
        this.f18790b = videoServer;
        this.f18791c = androidThreadUtil;
        this.f18792d = provider;
        this.f18794f = videoDashConfig;
        this.f18798j = listeningExecutorService;
        this.f18795g = deviceConditionHelper;
        this.f18796h = videoServer.o;
        this.f18797i = fbDataConnectionManager;
        this.f18793e = qeAccessor;
        this.f18799k = networkInfoCollector;
    }

    public final ExoPlayerStreamRendererBuilder m27509a(Uri uri, Uri uri2, String str, PlaybackPreferences playbackPreferences, ExoStreamRendererEventListener exoStreamRendererEventListener, EventListener eventListener, boolean z) {
        Uri d = VideoServer.d(uri);
        if (d == null) {
            d = uri;
        }
        String lastPathSegment = d.getLastPathSegment();
        Handler handler = new Handler(Looper.getMainLooper());
        Object obj = ((uri2 == null || !uri2.toString().endsWith(".mpd")) && StringUtil.a(str)) ? null : 1;
        if (obj != null && this.f18794f.a(this.f18795g)) {
            boolean z2 = z && this.f18794f.a(this.f18795g, playbackPreferences.f()) >= 0;
            return new ExoPlayerDashStreamRendererBuilder(uri, uri2, str, playbackPreferences, this.f18789a, handler, exoStreamRendererEventListener, exoStreamRendererEventListener, new TypedEventBus(), this.f18791c, this.f18790b, this.f18794f, eventListener, this.f18796h, z2, this.f18795g, this.f18797i, this.f18798j, this.f18799k);
        } else if (lastPathSegment.endsWith(".m3u8") || lastPathSegment.endsWith(".m3u")) {
            return new ExoPlayerHLSStreamRendererBuilder(uri, this.f18789a, handler, this.f18793e.a(ExperimentsForVideoAbTestModule.cs, false), this.f18790b, exoStreamRendererEventListener, exoStreamRendererEventListener, ((VideoExoplayerConfig) this.f18792d.get()).k, ((VideoExoplayerConfig) this.f18792d.get()).l);
        } else {
            return new ExoPlayerProgressiveDownloadRendererBuilder(uri, this.f18789a, handler, exoStreamRendererEventListener, exoStreamRendererEventListener, new TypedEventBus(), this.f18791c, this.f18790b, ((VideoExoplayerConfig) this.f18792d.get()).b, ((VideoExoplayerConfig) this.f18792d.get()).m, ((VideoExoplayerConfig) this.f18792d.get()).n);
        }
    }
}
