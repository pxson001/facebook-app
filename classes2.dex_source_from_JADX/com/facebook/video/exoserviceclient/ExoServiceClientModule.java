package com.facebook.video.exoserviceclient;

import android.content.Context;
import android.os.Bundle;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.exoplayer.ExperimentationSetting;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: preparing */
public class ExoServiceClientModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static ExoServiceClient m14008a(Context context, VideoDashConfig videoDashConfig, VideoExoplayerConfig videoExoplayerConfig, QeAccessor qeAccessor, MonotonicClock monotonicClock, Lazy<FbErrorReporter> lazy, VideoLivePlaybackConfig videoLivePlaybackConfig, FbBroadcastManager fbBroadcastManager, FbNetworkManager fbNetworkManager, Lazy<FbDataConnectionManager> lazy2) {
        Map hashMap = new HashMap();
        hashMap.put(ExperimentationSetting.a, Integer.toString(videoDashConfig.f6856A));
        hashMap.put(ExperimentationSetting.b, Integer.toString(videoDashConfig.f6899z));
        hashMap.put(ExperimentationSetting.c, Integer.toString(videoDashConfig.f6857B));
        hashMap.put(ExperimentationSetting.d, Integer.toString(videoLivePlaybackConfig.f9130h));
        hashMap.put(ExperimentationSetting.e, Integer.toString(videoLivePlaybackConfig.f9134l ? 1 : 0));
        hashMap.put(ExperimentationSetting.f, Integer.toString(videoLivePlaybackConfig.f9135m ? 1 : 0));
        hashMap.put(ExperimentationSetting.g, Integer.toString(videoLivePlaybackConfig.f9139q ? 1 : 0));
        hashMap.put(ExperimentationSetting.h, Integer.toString(videoLivePlaybackConfig.f9105I ? 1 : 0));
        hashMap.put(ExperimentationSetting.j, Integer.toString(videoLivePlaybackConfig.ab));
        hashMap.put(ExperimentationSetting.k, Integer.toString(videoLivePlaybackConfig.ac));
        hashMap.put(ExperimentationSetting.l, Integer.toString(videoLivePlaybackConfig.ad ? 1 : 0));
        hashMap.put(ExperimentationSetting.r, Integer.toString(videoLivePlaybackConfig.f9106J));
        hashMap.put(ExperimentationSetting.t, Integer.toString(videoLivePlaybackConfig.f9107K));
        hashMap.put(ExperimentationSetting.i, Long.toString(videoLivePlaybackConfig.f9115S));
        hashMap.put(ExperimentationSetting.u, Integer.toString(videoLivePlaybackConfig.f9118V ? 1 : 0));
        hashMap.put(ExperimentationSetting.v, Integer.toString(videoLivePlaybackConfig.f9119W));
        hashMap.put(ExperimentationSetting.m, Integer.toString(videoExoplayerConfig.f6926m));
        hashMap.put(ExperimentationSetting.n, Integer.toString(videoExoplayerConfig.f6927n));
        hashMap.put(ExperimentationSetting.o, Integer.toString(videoExoplayerConfig.f6928o));
        hashMap.put(ExperimentationSetting.p, Integer.toString(videoExoplayerConfig.f6929p));
        hashMap.put(ExperimentationSetting.q, Integer.toString(videoDashConfig.f6866K));
        hashMap.put(ExperimentationSetting.s, Integer.toString(videoDashConfig.f6867L));
        hashMap.put(ExperimentationSetting.w, Float.toString(videoDashConfig.f6868M));
        hashMap.put(ExperimentationSetting.x, Float.toString(videoDashConfig.f6869N));
        hashMap.put(ExperimentationSetting.y, videoDashConfig.f6870O ? "1" : "0");
        hashMap.put(ExperimentationSetting.z, Integer.toString(videoExoplayerConfig.f6909I ? 1 : 0));
        hashMap.put(ExperimentationSetting.A, Integer.toString(videoLivePlaybackConfig.f9126d ? 1 : 0));
        hashMap.put(ExperimentationSetting.B, Integer.toString(videoExoplayerConfig.f6910J ? 1 : 0));
        hashMap.put(ExperimentationSetting.C, Integer.toString(videoLivePlaybackConfig.f9129g ? 1 : 0));
        hashMap.put(ExperimentationSetting.D, Integer.toString(videoLivePlaybackConfig.f9127e ? 1 : 0));
        hashMap.put(ExperimentationSetting.E, Integer.toString(qeAccessor.mo596a(ExperimentsForVideoAbTestModule.ch, true) ? 1 : 0));
        hashMap.put(ExperimentationSetting.F, Integer.toString(videoLivePlaybackConfig.f9147y ? 1 : 0));
        hashMap.put(ExperimentationSetting.G, Integer.toString(videoLivePlaybackConfig.f9148z));
        hashMap.put(ExperimentationSetting.I, Integer.toString(videoLivePlaybackConfig.f9097A));
        hashMap.put(ExperimentationSetting.J, Integer.toString(videoLivePlaybackConfig.f9098B));
        hashMap.put(ExperimentationSetting.K, Integer.toString(videoLivePlaybackConfig.f9099C));
        hashMap.put(ExperimentationSetting.H, Integer.toString(qeAccessor.mo572a(ExperimentsForVideoAbTestModule.ca, 0)));
        hashMap.put(ExperimentationSetting.O, Integer.toString(videoLivePlaybackConfig.f9120X));
        hashMap.put(ExperimentationSetting.P, Integer.toString(videoExoplayerConfig.f6912L));
        hashMap.put(ExperimentationSetting.T, Integer.toString(videoLivePlaybackConfig.f9144v ? 1 : 0));
        hashMap.put(ExperimentationSetting.M, Integer.toString(videoLivePlaybackConfig.f9145w ? 1 : 0));
        hashMap.put(ExperimentationSetting.L, Integer.toString(videoLivePlaybackConfig.f9101E ? 1 : 0));
        hashMap.put(ExperimentationSetting.N, Integer.toString(videoLivePlaybackConfig.f9102F ? 1 : 0));
        hashMap.put(ExperimentationSetting.U, Integer.toString(videoLivePlaybackConfig.f9103G ? 1 : 0));
        hashMap.put("video.exo_service_rtmp_should_report_buffered_position", Integer.toString(videoLivePlaybackConfig.f9104H ? 1 : 0));
        if (videoLivePlaybackConfig.f9108L > 0) {
            hashMap.put("video.live.min_buffer_ms", Integer.toString(videoLivePlaybackConfig.f9108L));
        }
        if (videoLivePlaybackConfig.f9109M > 0) {
            hashMap.put("video.live.min_rebuffer_ms", Integer.toString(videoLivePlaybackConfig.f9109M));
        }
        hashMap.put("rtmp_report_absolute_timestamps", Integer.toString(videoLivePlaybackConfig.f9110N ? 1 : 0));
        Bundle bundle = new Bundle();
        qeAccessor.mo590a(Liveness.Cached, ExperimentsForVideoAbTestModule.cy);
        m14009a(hashMap, bundle, ExperimentationSetting.Q, ExperimentsForVideoAbTestModule.cy, false, qeAccessor);
        m14009a(hashMap, bundle, ExperimentationSetting.R, ExperimentsForVideoAbTestModule.cx, false, qeAccessor);
        m14009a(hashMap, bundle, ExperimentationSetting.S, ExperimentsForVideoAbTestModule.cw, false, qeAccessor);
        ExoServiceClient exoServiceClient = new ExoServiceClient(context, qeAccessor.mo575a(ExperimentsForVideoAbTestModule.ah, 104857600), hashMap, monotonicClock, videoExoplayerConfig.f6909I, new NonPlayerSessionListener(), lazy, fbBroadcastManager, fbNetworkManager, videoLivePlaybackConfig.f9113Q, lazy2, new Builder().m609b(ConnectionQuality.EXCELLENT, Integer.valueOf(videoLivePlaybackConfig.f9116T)).m609b(ConnectionQuality.GOOD, Integer.valueOf(1)).m609b(ConnectionQuality.MODERATE, Integer.valueOf(0)).m609b(ConnectionQuality.POOR, Integer.valueOf(0)).m609b(ConnectionQuality.UNKNOWN, Integer.valueOf(0)).m610b(), videoLivePlaybackConfig.f9117U);
        if (videoExoplayerConfig.m11521b()) {
            exoServiceClient.m14056a(bundle);
        }
        return exoServiceClient;
    }

    private static void m14009a(Map<String, String> map, Bundle bundle, String str, short s, boolean z, QeAccessor qeAccessor) {
        boolean a = qeAccessor.mo593a(Liveness.Cached, ExposureLogging.Off, s, z);
        map.put(str, Integer.toString(a ? 1 : 0));
        bundle.putBoolean(str, a);
    }
}
