package com.facebook.videocodec.resizer;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.debug.tracer.Tracer;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.base.VideoOperationProgressListener;
import com.facebook.videocodec.codecs.CodecBuffer;
import com.facebook.videocodec.codecs.MediaBaseCodecBuffer;
import com.facebook.videocodec.extract.VideoTrackExtractor;
import com.facebook.videocodec.extract.VideoTrackExtractor.TrackInfo;
import com.facebook.videocodec.muxers.CodecMuxer;
import com.facebook.videocodec.policy.VideoTranscodeParams;
import com.google.common.base.Preconditions;
import java.io.File;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(16)
/* compiled from: result_count */
public class VideoResizeOperation {
    private static final Class<?> f5642a = VideoResizeOperation.class;
    private final Context f5643b;
    private final VideoMetadataExtractor f5644c;
    private final VideoTrackExtractor f5645d;
    private final VideoTranscodeHandlerFactory f5646e;
    private final CodecMuxer f5647f;
    private final DefaultAndroidThreadUtil f5648g;
    private final AbstractFbErrorReporter f5649h;

    /* compiled from: result_count */
    class MuxerBuffer implements CodecBuffer {
        private final ByteBuffer f5640a = ByteBuffer.allocateDirect(1048576);
        private final BufferInfo f5641b = new BufferInfo();

        public final ByteBuffer mo363a() {
            return this.f5640a;
        }

        public final BufferInfo mo365b() {
            return this.f5641b;
        }

        public final void mo364a(int i, int i2, long j, int i3) {
            this.f5641b.set(i, i2, j, i3);
        }
    }

    @Inject
    public VideoResizeOperation(Context context, VideoMetadataExtractor videoMetadataExtractor, VideoTrackExtractor videoTrackExtractor, CodecMuxer codecMuxer, VideoTranscodeHandlerFactory videoTranscodeHandlerFactory, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f5643b = context;
        this.f5644c = videoMetadataExtractor;
        this.f5645d = videoTrackExtractor;
        this.f5647f = codecMuxer;
        this.f5646e = videoTranscodeHandlerFactory;
        this.f5648g = defaultAndroidThreadUtil;
        this.f5649h = abstractFbErrorReporter;
    }

    final VideoResizeResult m8274a(VideoResizerParams videoResizerParams) {
        TracerDetour.a("resizeVideoOnCurrentThread", 201429579);
        try {
            Preconditions.checkState(!this.f5648g.c());
            Preconditions.checkState(m8273a(), "Video Resizing is not supported for this OS version");
            Preconditions.checkArgument(videoResizerParams.f5670a.exists(), "Input file does not exist: " + videoResizerParams.f5670a.getPath());
            long length = videoResizerParams.f5670a.length();
            Uri fromFile = Uri.fromFile(videoResizerParams.f5670a);
            VideoMetadata a = this.f5644c.a(fromFile);
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(this.f5643b, fromFile, null);
            TrackInfo trackInfo = null;
            if (!videoResizerParams.f5676g) {
                trackInfo = this.f5645d.m8208a(mediaExtractor);
            }
            TrackInfo trackInfo2 = null;
            if (!videoResizerParams.f5675f) {
                trackInfo2 = this.f5645d.m8209a(mediaExtractor, fromFile);
            }
            try {
                VideoTranscodeParams a2 = videoResizerParams.f5672c.a(a, videoResizerParams.f5680k, videoResizerParams.f5673d, videoResizerParams.f5674e, videoResizerParams.f5682m, videoResizerParams.f5683n);
                VideoTranscoder videoTranscoder = null;
                if (!videoResizerParams.f5676g) {
                    videoTranscoder = this.f5646e.m8297a();
                }
                if (videoTranscoder != null) {
                    try {
                        videoTranscoder.mo380a(a2);
                        videoTranscoder.mo378a(trackInfo.f5534b);
                    } catch (Throwable th) {
                        if (videoTranscoder != null) {
                            videoTranscoder.mo386c();
                        }
                    }
                }
                m8271a(videoResizerParams.f5671b);
                m8270a(mediaExtractor, videoTranscoder, a, trackInfo, trackInfo2, videoResizerParams.f5677h, (long) (videoResizerParams.f5678i * 1000), (long) (videoResizerParams.f5679j * 1000), videoResizerParams.f5681l);
                if (videoTranscoder != null) {
                    videoTranscoder.mo386c();
                }
                if (videoResizerParams.f5671b.exists()) {
                    VideoResizeResult a3 = VideoResizeResult.m8275a(videoResizerParams.f5671b, length, videoResizerParams.f5671b.length(), a.f5481b, a.f5482c, a.f5484e, -1, a.f5480a, a2);
                    if (videoResizerParams.f5681l != null) {
                        videoResizerParams.f5681l.mo1160a();
                    }
                    TracerDetour.a(-1041300273);
                    Tracer.c("VideoResizer Thread");
                    return a3;
                }
                throw new VideoResizeException("No output file created");
            } finally {
                mediaExtractor.release();
            }
        } catch (Throwable th2) {
            try {
                if (videoResizerParams.f5681l != null) {
                    videoResizerParams.f5681l.mo1160a();
                }
            } catch (Throwable th3) {
                TracerDetour.a(-1064713623);
                Tracer.c("VideoResizer Thread");
            }
        }
    }

    private void m8271a(File file) {
        this.f5647f.mo373a(file.getPath());
    }

    private static boolean m8273a() {
        return VERSION.SDK_INT >= 16;
    }

    private void m8270a(MediaExtractor mediaExtractor, VideoTranscoder videoTranscoder, VideoMetadata videoMetadata, TrackInfo trackInfo, @Nullable TrackInfo trackInfo2, boolean z, long j, long j2, VideoOperationProgressListener videoOperationProgressListener) {
        Throwable th;
        Object obj;
        Object obj2 = null;
        try {
            long j3;
            long sampleTime;
            Object obj3;
            Object obj4;
            int readSampleData;
            if (VERSION.SDK_INT < 18) {
                if (trackInfo != null) {
                    this.f5647f.mo375b(videoTranscoder.mo387d());
                    this.f5647f.mo370a(videoTranscoder.mo388e());
                }
                if (trackInfo2 != null) {
                    this.f5647f.mo371a(trackInfo2.f5534b);
                }
                this.f5647f.mo369a();
                obj2 = 1;
            }
            if (j < 0) {
                j = 0;
            }
            if (j2 < 0) {
                j3 = videoMetadata.f5480a * 1000;
            } else {
                j3 = j2;
            }
            if (trackInfo != null) {
                mediaExtractor.selectTrack(trackInfo.f5535c);
            }
            if (trackInfo2 != null) {
                mediaExtractor.selectTrack(trackInfo2.f5535c);
            }
            if (z) {
                mediaExtractor.seekTo(j3, 0);
                sampleTime = mediaExtractor.getSampleTime() - 1;
            } else {
                sampleTime = j3;
            }
            mediaExtractor.seekTo(j, 0);
            long sampleTime2 = mediaExtractor.getSampleTime();
            if (trackInfo2 != null) {
                mediaExtractor.unselectTrack(trackInfo2.f5535c);
            }
            if (trackInfo != null) {
                long j4 = sampleTime - sampleTime2;
                Object obj5 = null;
                boolean z2 = false;
                Object obj6 = null;
                obj3 = obj2;
                obj4 = 1;
                while (true) {
                    if (obj6 != null && z2 && obj5 != null) {
                        break;
                    }
                    Object obj7;
                    boolean z3;
                    CodecBuffer c;
                    Object obj8;
                    if (obj6 == null) {
                        try {
                            MediaBaseCodecBuffer a = videoTranscoder.mo377a(10000);
                            if (a != null) {
                                readSampleData = mediaExtractor.readSampleData(a.mo363a(), 0);
                                long sampleTime3 = mediaExtractor.getSampleTime();
                                if (readSampleData <= 0 || sampleTime3 > sampleTime) {
                                    a.mo364a(0, 0, 0, 4);
                                    videoTranscoder.mo379a(a);
                                    obj7 = obj4;
                                    int i = 1;
                                    if (z2) {
                                        z3 = z2;
                                    } else {
                                        videoTranscoder.mo383b(10000);
                                        z3 = videoTranscoder.mo381a();
                                    }
                                    if (obj5 == null) {
                                        c = videoTranscoder.mo385c(10000);
                                        obj2 = obj3;
                                        while (c != null) {
                                            if (c.m8168d() && c.m8169e()) {
                                                this.f5647f.mo375b(videoTranscoder.mo387d());
                                                if (trackInfo2 != null) {
                                                    this.f5647f.mo371a(trackInfo2.f5534b);
                                                }
                                                this.f5647f.mo370a(videoTranscoder.mo388e());
                                                this.f5647f.mo369a();
                                                obj2 = 1;
                                            } else if (c.m8168d()) {
                                                if ((c.mo365b().flags & 4) == 0) {
                                                    obj5 = 1;
                                                    z2 = z3;
                                                    obj6 = obj8;
                                                    obj3 = obj2;
                                                    obj4 = obj7;
                                                    break;
                                                }
                                                this.f5647f.mo376b(c);
                                                if (videoOperationProgressListener != null) {
                                                    videoOperationProgressListener.mo1161a(((double) c.mo365b().presentationTimeUs) / ((double) j4));
                                                }
                                            }
                                            videoTranscoder.mo384b((MediaBaseCodecBuffer) c);
                                            c = videoTranscoder.mo385c(10000);
                                        }
                                        obj4 = obj7;
                                        z2 = z3;
                                        obj6 = obj8;
                                        obj3 = obj2;
                                    } else {
                                        obj4 = obj7;
                                        z2 = z3;
                                        obj6 = obj8;
                                    }
                                } else {
                                    a.mo364a(0, readSampleData, sampleTime3 - sampleTime2, mediaExtractor.getSampleFlags());
                                    videoTranscoder.mo379a(a);
                                    mediaExtractor.advance();
                                    if (obj4 != null) {
                                        Long.valueOf(sampleTime3);
                                        obj4 = null;
                                    }
                                    obj7 = obj4;
                                    obj8 = obj6;
                                    if (z2) {
                                        z3 = z2;
                                    } else {
                                        videoTranscoder.mo383b(10000);
                                        z3 = videoTranscoder.mo381a();
                                    }
                                    if (obj5 == null) {
                                        obj4 = obj7;
                                        z2 = z3;
                                        obj6 = obj8;
                                    } else {
                                        c = videoTranscoder.mo385c(10000);
                                        obj2 = obj3;
                                        while (c != null) {
                                            if (c.m8168d()) {
                                            }
                                            if (c.m8168d()) {
                                                if ((c.mo365b().flags & 4) == 0) {
                                                    obj5 = 1;
                                                    z2 = z3;
                                                    obj6 = obj8;
                                                    obj3 = obj2;
                                                    obj4 = obj7;
                                                    break;
                                                }
                                                this.f5647f.mo376b(c);
                                                if (videoOperationProgressListener != null) {
                                                    videoOperationProgressListener.mo1161a(((double) c.mo365b().presentationTimeUs) / ((double) j4));
                                                }
                                            }
                                            videoTranscoder.mo384b((MediaBaseCodecBuffer) c);
                                            c = videoTranscoder.mo385c(10000);
                                        }
                                        obj4 = obj7;
                                        z2 = z3;
                                        obj6 = obj8;
                                        obj3 = obj2;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            obj2 = obj3;
                        }
                    }
                    obj7 = obj4;
                    obj8 = obj6;
                    if (z2) {
                        videoTranscoder.mo383b(10000);
                        z3 = videoTranscoder.mo381a();
                    } else {
                        z3 = z2;
                    }
                    if (obj5 == null) {
                        c = videoTranscoder.mo385c(10000);
                        obj2 = obj3;
                        while (c != null) {
                            if (c.m8168d()) {
                            }
                            if (c.m8168d()) {
                                if ((c.mo365b().flags & 4) == 0) {
                                    obj5 = 1;
                                    z2 = z3;
                                    obj6 = obj8;
                                    obj3 = obj2;
                                    obj4 = obj7;
                                    break;
                                }
                                this.f5647f.mo376b(c);
                                if (videoOperationProgressListener != null) {
                                    videoOperationProgressListener.mo1161a(((double) c.mo365b().presentationTimeUs) / ((double) j4));
                                }
                            }
                            videoTranscoder.mo384b((MediaBaseCodecBuffer) c);
                            c = videoTranscoder.mo385c(10000);
                        }
                        obj4 = obj7;
                        z2 = z3;
                        obj6 = obj8;
                        obj3 = obj2;
                    } else {
                        obj4 = obj7;
                        z2 = z3;
                        obj6 = obj8;
                    }
                }
                videoTranscoder.mo382b();
                obj = obj3;
            } else {
                obj = obj2;
            }
            if (trackInfo2 != null) {
                try {
                    mediaExtractor.selectTrack(trackInfo2.f5535c);
                    mediaExtractor.seekTo(sampleTime2, 2);
                    if (trackInfo != null) {
                        mediaExtractor.unselectTrack(trackInfo.f5535c);
                    }
                    CodecBuffer muxerBuffer = new MuxerBuffer();
                    ByteBuffer byteBuffer = trackInfo2.f5534b.getByteBuffer("csd-0");
                    if (obj == null) {
                        this.f5647f.mo371a(trackInfo2.f5534b);
                        this.f5647f.mo369a();
                        obj3 = 1;
                    } else {
                        obj3 = obj;
                    }
                    if (byteBuffer != null) {
                        muxerBuffer.mo364a(0, byteBuffer.limit(), 0, 2);
                        m8272a(byteBuffer, muxerBuffer.mo363a());
                        this.f5647f.mo372a(muxerBuffer);
                    }
                    obj4 = null;
                    while (obj4 == null) {
                        readSampleData = mediaExtractor.readSampleData(muxerBuffer.mo363a(), 0);
                        long sampleTime4 = mediaExtractor.getSampleTime();
                        if (readSampleData <= 0 || sampleTime4 > sampleTime) {
                            obj4 = 1;
                        } else {
                            if (sampleTime4 >= sampleTime2) {
                                muxerBuffer.mo364a(0, readSampleData, sampleTime4 - sampleTime2, mediaExtractor.getSampleFlags());
                                this.f5647f.mo372a(muxerBuffer);
                            }
                            mediaExtractor.advance();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj2 = obj;
                    if (obj2 != null) {
                        this.f5647f.mo374b();
                    }
                    throw th;
                }
            }
            obj3 = obj;
            if (obj3 != null) {
                this.f5647f.mo374b();
            }
        } catch (Throwable th4) {
            th = th4;
            if (obj2 != null) {
                this.f5647f.mo374b();
            }
            throw th;
        }
    }

    private static void m8272a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byteBuffer2.position(0);
        byteBuffer.position(0);
        byteBuffer2.limit(byteBuffer.limit());
        byteBuffer2.put(byteBuffer);
    }
}
