package com.facebook.videocodec.codecs;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Surface;
import com.facebook.videocodec.base.CodecNotSupportedException;
import com.facebook.videocodec.base.VideoCodecOpenGlColorFormat;
import com.facebook.videocodec.codecs.Constants.MediaCodecInputType;
import com.facebook.videocodec.codecs.Constants.MediaCodecProcessingType;
import com.facebook.videocodec.codecs.Constants.MediaCodecType;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
@TargetApi(16)
/* compiled from: review_with_feedback */
public class MediaCodecFactory {
    private static final Class<?> f5495a = MediaCodecFactory.class;
    private static final ImmutableSet<String> f5496b = ImmutableSet.of("OMX.ittiam.video.encoder.avc", "OMX.Exynos.avc.enc");
    public static final ImmutableMap<String, Integer> f5497c = ImmutableMap.builder().b("OMX.qcom.video.encoder.avc", Integer.valueOf(21)).b();
    public static final ImmutableSet<String> f5498d = ImmutableSet.builder().c("OMX.qcom.video.decoder.avc").b();
    public static final ImmutableSet<String> f5499e = ImmutableSet.of("OMX.ittiam.video.decoder.avc", "OMX.Exynos.AVC.Decoder");
    public static final ImmutableSet<String> f5500f = ImmutableSet.of("GT-S6812i", "GT-I8552", "GT-I8552B", "GT-I8262B");
    private static final ImmutableList<String> f5501g = ImmutableList.of("OMX.SEC.AVC.Encoder", "OMX.SEC.avc.enc");
    private static volatile MediaCodecFactory f5502h;

    /* compiled from: review_with_feedback */
    public class C03341 implements Function<VideoEncoderInfo, String> {
        final /* synthetic */ MediaCodecFactory f5494a;

        public C03341(MediaCodecFactory mediaCodecFactory) {
            this.f5494a = mediaCodecFactory;
        }

        public Object apply(Object obj) {
            return ((VideoEncoderInfo) obj).f5524a;
        }
    }

    public static com.facebook.videocodec.codecs.MediaCodecFactory m8170a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f5502h;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.videocodec.codecs.MediaCodecFactory.class;
        monitor-enter(r1);
        r0 = f5502h;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m8178f();	 Catch:{ all -> 0x0034 }
        f5502h = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f5502h;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.videocodec.codecs.MediaCodecFactory.a(com.facebook.inject.InjectorLike):com.facebook.videocodec.codecs.MediaCodecFactory");
    }

    private static MediaCodecFactory m8178f() {
        return new MediaCodecFactory();
    }

    public static boolean m8174a(String str) {
        return str.equals(MediaCodecType.CODEC_VIDEO_H264.value) || str.equals(MediaCodecType.CODEC_VIDEO_H263.value) || str.equals(MediaCodecType.CODEC_VIDEO_MPEG4.value) || str.equals(MediaCodecType.CODEC_VIDEO_VP8.value);
    }

    public final MediaCodecWrapper m8180a(String str, MediaFormat mediaFormat, MediaCodecInputType mediaCodecInputType) {
        if (str.equals(MediaCodecType.CODEC_VIDEO_H264.value)) {
            return m8172a(MediaCodec.createEncoderByType(str), mediaFormat, mediaCodecInputType);
        }
        throw CodecNotSupportedException.m8157a(str);
    }

    public final MediaCodecWrapper m8179a(String str, MediaFormat mediaFormat, @Nullable Surface surface) {
        if (m8174a(str)) {
            return m8171a(MediaCodec.createDecoderByType(str), mediaFormat, surface);
        }
        throw CodecNotSupportedException.m8157a(str);
    }

    @TargetApi(18)
    public static MediaCodecWrapper m8172a(MediaCodec mediaCodec, MediaFormat mediaFormat, MediaCodecInputType mediaCodecInputType) {
        Surface createInputSurface;
        boolean z = mediaCodecInputType != MediaCodecInputType.SURFACE || VERSION.SDK_INT >= 18;
        Preconditions.checkArgument(z);
        mediaCodec.configure(mediaFormat, null, null, 1);
        if (mediaCodecInputType == MediaCodecInputType.SURFACE) {
            createInputSurface = mediaCodec.createInputSurface();
        } else {
            createInputSurface = null;
        }
        return new MediaCodecWrapper(MediaCodecProcessingType.ENCODER, mediaCodec, createInputSurface, false);
    }

    public static MediaCodecWrapper m8171a(MediaCodec mediaCodec, MediaFormat mediaFormat, @Nullable Surface surface) {
        boolean z = false;
        mediaCodec.configure(mediaFormat, surface, null, 0);
        if (surface != null) {
            z = true;
        }
        return new MediaCodecWrapper(MediaCodecProcessingType.DECODER, mediaCodec, null, z);
    }

    public final VideoEncoderInfo m8181a() {
        VideoEncoderInfo a;
        Preconditions.checkState(VERSION.SDK_INT < 18);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String name = codecInfoAt.getName();
                if (f5497c.containsKey(name)) {
                    a = m8173a(name, ((Integer) f5497c.get(name)).intValue());
                    break;
                }
            }
        }
        a = null;
        VideoEncoderInfo videoEncoderInfo = a;
        if (videoEncoderInfo == null) {
            videoEncoderInfo = m8175c();
            if (videoEncoderInfo == null) {
                throw CodecNotSupportedException.m8157a(MediaCodecType.CODEC_VIDEO_H264.value);
            }
        }
        return videoEncoderInfo;
    }

    private VideoEncoderInfo m8175c() {
        Iterable<VideoEncoderInfo> d = m8176d();
        String join = Joiner.on(", ").join(Iterables.a(d, new C03341(this)));
        Integer.valueOf(d.size());
        if (d.isEmpty()) {
            return null;
        }
        LinkedHashMultimap u = LinkedHashMultimap.u();
        for (VideoEncoderInfo videoEncoderInfo : d) {
            u.a(videoEncoderInfo.f5524a, videoEncoderInfo);
        }
        int size = f5501g.size();
        for (int i = 0; i < size; i++) {
            for (VideoEncoderInfo videoEncoderInfo2 : u.c((String) f5501g.get(i))) {
                if (videoEncoderInfo2 != null) {
                    return videoEncoderInfo2;
                }
            }
        }
        return (VideoEncoderInfo) Iterables.a(d, null);
    }

    private List<VideoEncoderInfo> m8176d() {
        List<VideoEncoderInfo> a = Lists.a();
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder() && Arrays.asList(codecInfoAt.getSupportedTypes()).contains("video/avc")) {
                String name = codecInfoAt.getName();
                if (!f5496b.contains(name)) {
                    for (int i2 : codecInfoAt.getCapabilitiesForType("video/avc").colorFormats) {
                        if (!"OMX.SEC.avc.enc".equals(name) || i2 != 19) {
                            switch (i2) {
                                case 19:
                                case 21:
                                case 2130706688:
                                    a.add(m8173a(name, i2));
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    public final VideoDecoderInfo m8182b(String str) {
        VideoDecoderInfo videoDecoderInfo;
        Preconditions.checkState(VERSION.SDK_INT < 18);
        Preconditions.checkState(m8174a(str));
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            String name;
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder() && Arrays.asList(codecInfoAt.getSupportedTypes()).contains(str)) {
                name = codecInfoAt.getName();
                if (f5498d.contains(name)) {
                    videoDecoderInfo = new VideoDecoderInfo(name, false, m8177e());
                    break;
                }
            }
        }
        videoDecoderInfo = null;
        VideoDecoderInfo videoDecoderInfo2 = videoDecoderInfo;
        if (videoDecoderInfo2 == null) {
            boolean z = false;
            codecCount = MediaCodecList.getCodecCount();
            for (int i2 = 0; i2 < codecCount; i2++) {
                codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                if (!codecInfoAt.isEncoder() && Arrays.asList(codecInfoAt.getSupportedTypes()).contains(str)) {
                    name = codecInfoAt.getName();
                    if (!f5499e.contains(name)) {
                        if ("OMX.MTK.VIDEO.DECODER.AVC".equals(name)) {
                            z = true;
                        }
                        videoDecoderInfo = new VideoDecoderInfo(name, z, m8177e());
                        videoDecoderInfo2 = videoDecoderInfo;
                        if (videoDecoderInfo2 == null) {
                            throw CodecNotSupportedException.m8157a(str);
                        }
                    }
                }
            }
            videoDecoderInfo = null;
            videoDecoderInfo2 = videoDecoderInfo;
            if (videoDecoderInfo2 == null) {
                throw CodecNotSupportedException.m8157a(str);
            }
        }
        return videoDecoderInfo2;
    }

    public static VideoEncoderInfo m8173a(String str, int i) {
        int i2 = 0;
        if (str.contains("qcom")) {
            i2 = 2048;
        }
        return new VideoEncoderInfo(str, i, i2);
    }

    public static VideoCodecOpenGlColorFormat m8177e() {
        if (VERSION.SDK_INT >= 18) {
            return null;
        }
        if (Objects.equal(Build.MODEL, "GT-I9500")) {
            return VideoCodecOpenGlColorFormat.BGRA;
        }
        return VideoCodecOpenGlColorFormat.RGBA;
    }
}
