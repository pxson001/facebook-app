package com.facebook.video.exoserviceclient;

import com.facebook.exoplayer.ipc.ExoServiceRtmpStreamStats;
import com.facebook.exoplayer.ipc.MediaRenderer;
import com.facebook.exoplayer.ipc.RendererContext;
import com.facebook.exoplayer.ipc.VideoPlayerMediaChunk;
import com.facebook.exoplayer.ipc.VideoPlayerServiceListener.Stub;
import com.facebook.exoplayer.ipc.VideoPlayerSession;
import com.facebook.exoplayer.ipc.VideoPlayerStreamEvaluation;
import com.facebook.exoplayer.ipc.VideoPlayerStreamFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: prepare_time */
public class NonPlayerSessionListener extends Stub {
    private Set<ServiceListener> f9165a = new HashSet();

    /* compiled from: prepare_time */
    public interface ServiceListener {
        void m14068a(int i);

        void m14069a(int i, int i2);

        void m14070a(int i, String str, String str2);

        void m14071a(int i, boolean z);

        void m14072a(String str, ExoServiceRtmpStreamStats exoServiceRtmpStreamStats);

        void m14073b(int i);

        void m14074b(int i, boolean z);
    }

    public final synchronized void m14032a(ServiceListener serviceListener) {
        this.f9165a.add(serviceListener);
    }

    public final void m14031a(VideoPlayerSession videoPlayerSession, boolean z, int i, int i2) {
    }

    public final void m14030a(MediaRenderer mediaRenderer, MediaRenderer mediaRenderer2, RendererContext rendererContext) {
    }

    public final void m14014a(int i, int i2, float f) {
    }

    public final void m14023a(int i, VideoPlayerStreamFormat videoPlayerStreamFormat, int i2, int i3, long j) {
    }

    public final void m14034a(String str, String str2, long j) {
    }

    public final void m14011a() {
    }

    public final void m14036b() {
    }

    public final void m14035a(List<VideoPlayerMediaChunk> list, long j, VideoPlayerStreamFormat[] videoPlayerStreamFormatArr, VideoPlayerStreamEvaluation videoPlayerStreamEvaluation) {
    }

    public final void m14041c() {
    }

    public final void m14025a(int i, String str, String str2) {
        m14018a(11, i, str, str2);
    }

    public final void m14028a(int i, boolean z) {
        m14019a(11, i, z);
    }

    public final void m14013a(int i, int i2) {
        m14015a(11, i, i2);
    }

    public final void m14012a(int i) {
        m14043c(11, i);
    }

    public final void m14040b(int i, boolean z) {
        m14039b(11, i, z);
    }

    public final void m14044d() {
        m14046e(11);
    }

    public final void m14033a(String str, ExoServiceRtmpStreamStats exoServiceRtmpStreamStats) {
        m14024a(11, str, exoServiceRtmpStreamStats);
    }

    public final void m14022a(int i, VideoPlayerSession videoPlayerSession, boolean z, int i2, int i3) {
    }

    public final void m14021a(int i, MediaRenderer mediaRenderer, MediaRenderer mediaRenderer2, RendererContext rendererContext) {
    }

    public final void m14016a(int i, int i2, int i3, float f) {
    }

    public final void m14017a(int i, int i2, VideoPlayerStreamFormat videoPlayerStreamFormat, int i3, int i4, long j) {
    }

    public final void m14026a(int i, String str, String str2, long j) {
    }

    public final void m14037b(int i) {
    }

    public final void m14042c(int i) {
    }

    public final void m14027a(int i, List<VideoPlayerMediaChunk> list, long j, VideoPlayerStreamFormat[] videoPlayerStreamFormatArr, VideoPlayerStreamEvaluation videoPlayerStreamEvaluation) {
    }

    private List<ServiceListener> m14010e() {
        List<ServiceListener> arrayList = new ArrayList();
        synchronized (this) {
            for (ServiceListener add : this.f9165a) {
                arrayList.add(add);
            }
        }
        return arrayList;
    }

    public final void m14045d(int i) {
    }

    public final void m14018a(int i, int i2, String str, String str2) {
        for (ServiceListener a : m14010e()) {
            a.m14070a(i2, str, str2);
        }
    }

    public final void m14019a(int i, int i2, boolean z) {
        for (ServiceListener a : m14010e()) {
            a.m14071a(i2, z);
        }
    }

    public final void m14015a(int i, int i2, int i3) {
        for (ServiceListener a : m14010e()) {
            a.m14069a(i2, i3);
        }
    }

    public final void m14038b(int i, int i2) {
        for (ServiceListener a : m14010e()) {
            a.m14068a(i2);
        }
    }

    public final void m14043c(int i, int i2) {
        for (ServiceListener b : m14010e()) {
            b.m14073b(i2);
        }
    }

    public final void m14039b(int i, int i2, boolean z) {
        for (ServiceListener b : m14010e()) {
            b.m14074b(i2, z);
        }
    }

    public final void m14046e(int i) {
    }

    public final void m14024a(int i, String str, ExoServiceRtmpStreamStats exoServiceRtmpStreamStats) {
        for (ServiceListener a : m14010e()) {
            a.m14072a(str, exoServiceRtmpStreamStats);
        }
    }

    public final void m14020a(int i, long j) {
    }

    public final void m14029a(long j) {
    }
}
