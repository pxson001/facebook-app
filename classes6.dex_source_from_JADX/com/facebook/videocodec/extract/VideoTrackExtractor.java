package com.facebook.videocodec.extract;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.ffmpeg.FFMpegMediaDemuxerProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.base.CodecNotSupportedException;
import com.facebook.videocodec.codecs.MediaCodecFactory;
import com.facebook.videocodec.ffmpeg.FFMpegBasedVideoTrackExtractor;
import com.facebook.videocodec.ffmpeg.FFMpegBasedVideoTrackExtractor.TrackException;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@TargetApi(16)
/* compiled from: retail_shipment_tracking_event */
public class VideoTrackExtractor {
    private static final Class<?> f5536a = VideoTrackExtractor.class;
    private static final ImmutableSet<String> f5537b = ImmutableSet.of("audio/3gpp", "audio/amr-wb", "audio/mp4a-latm", "audio/vorbis");
    private static volatile VideoTrackExtractor f5538g;
    private final MediaCodecFactory f5539c;
    private final AbstractFbErrorReporter f5540d;
    private final FFMpegBasedVideoTrackExtractor f5541e;
    private final FFMpegMediaDemuxerProvider f5542f;

    /* compiled from: retail_shipment_tracking_event */
    public class TrackInfo {
        public final String f5533a;
        public final MediaFormat f5534b;
        public final int f5535c;

        public TrackInfo(String str, MediaFormat mediaFormat, int i) {
            this.f5533a = str;
            this.f5534b = mediaFormat;
            this.f5535c = i;
        }
    }

    public static com.facebook.videocodec.extract.VideoTrackExtractor m8204a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5538g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.videocodec.extract.VideoTrackExtractor.class;
        monitor-enter(r1);
        r0 = f5538g;	 Catch:{ all -> 0x003a }
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
        r0 = m8206b(r0);	 Catch:{ all -> 0x0035 }
        f5538g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5538g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.videocodec.extract.VideoTrackExtractor.a(com.facebook.inject.InjectorLike):com.facebook.videocodec.extract.VideoTrackExtractor");
    }

    private static VideoTrackExtractor m8206b(InjectorLike injectorLike) {
        return new VideoTrackExtractor(MediaCodecFactory.m8170a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FFMpegBasedVideoTrackExtractor.m8227b(injectorLike), FFMpegMediaDemuxerProvider.b(injectorLike));
    }

    @Inject
    public VideoTrackExtractor(MediaCodecFactory mediaCodecFactory, AbstractFbErrorReporter abstractFbErrorReporter, FFMpegBasedVideoTrackExtractor fFMpegBasedVideoTrackExtractor, FFMpegMediaDemuxerProvider fFMpegMediaDemuxerProvider) {
        this.f5539c = mediaCodecFactory;
        this.f5540d = abstractFbErrorReporter;
        this.f5541e = fFMpegBasedVideoTrackExtractor;
        this.f5542f = fFMpegMediaDemuxerProvider;
    }

    public final TrackInfo m8208a(MediaExtractor mediaExtractor) {
        List<TrackInfo> a = Lists.a();
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            String string = trackFormat.getString("mime");
            if (string.startsWith("video/")) {
                a.add(new TrackInfo(string, trackFormat, i));
            }
        }
        if (a.isEmpty()) {
            throw new NoVideoTrackException();
        }
        for (TrackInfo trackInfo : a) {
            if (MediaCodecFactory.m8174a(trackInfo.f5533a)) {
                break;
            }
        }
        TrackInfo trackInfo2 = null;
        TrackInfo trackInfo3 = trackInfo2;
        if (trackInfo3 == null) {
            throw new CodecNotSupportedException("Unsupported video codec. Contained " + m8207c(a));
        }
        if (a.size() > 1) {
            this.f5540d.a("VideoTrackExtractor_multiple_video_tracks", m8207c(a));
        }
        return trackInfo3;
    }

    public final TrackInfo m8209a(MediaExtractor mediaExtractor, Uri uri) {
        List a = Lists.a();
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            String string = trackFormat.getString("mime");
            if (string.equals("audio/unknown")) {
                try {
                    string = this.f5541e.m8230b(this.f5542f.a(uri.getPath()).a()).f5548a;
                    trackFormat.setString("mime", string);
                } catch (TrackException e) {
                    throw new CodecNotSupportedException(e.getMessage());
                }
            }
            if (string.startsWith("audio/")) {
                a.add(new TrackInfo(string, trackFormat, i));
            }
        }
        if (a.isEmpty()) {
            return null;
        }
        TrackInfo b = m8205b(a);
        if (b == null) {
            throw new CodecNotSupportedException("Unsupported audio codec. Contained " + m8207c(a));
        } else if (a.size() <= 1) {
            return b;
        } else {
            this.f5540d.a("VideoTrackExtractor_multiple_audio_tracks", m8207c(a));
            return b;
        }
    }

    private static TrackInfo m8205b(List<TrackInfo> list) {
        for (TrackInfo trackInfo : list) {
            if (f5537b.contains(trackInfo.f5533a)) {
                return trackInfo;
            }
        }
        return null;
    }

    private static String m8207c(List<TrackInfo> list) {
        Iterable a = Lists.a();
        for (TrackInfo trackInfo : list) {
            a.add(trackInfo.f5533a);
        }
        return list.size() + " tracks: " + Joiner.on(", ").join(a);
    }
}
