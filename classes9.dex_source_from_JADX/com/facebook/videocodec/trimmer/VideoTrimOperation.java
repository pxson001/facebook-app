package com.facebook.videocodec.trimmer;

import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.ffmpeg.FFMpegAVStream;
import com.facebook.ffmpeg.FFMpegBufferInfo;
import com.facebook.ffmpeg.FFMpegMediaDemuxer;
import com.facebook.ffmpeg.FFMpegMediaDemuxerProvider;
import com.facebook.ffmpeg.FFMpegMediaMuxer;
import com.facebook.ffmpeg.FFMpegMediaMuxerProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.extract.DefaultVideoMetadataExtractor;
import com.facebook.videocodec.ffmpeg.FFMpegBasedVideoTrackExtractor;
import com.facebook.videocodec.ffmpeg.FFMpegBasedVideoTrackExtractor.TrackInfo;
import com.facebook.videocodec.ffmpeg.FFMpegVideoMetadataExtractor;
import java.nio.ByteBuffer;
import javax.inject.Inject;

/* compiled from: android.provider.Telephony.WAP_PUSH_DELIVER */
public class VideoTrimOperation {
    private static final Class<?> f20426a = VideoTrimOperation.class;
    private final VideoMetadataExtractor f20427b;
    private final FFMpegBasedVideoTrackExtractor f20428c;
    private final AbstractFbErrorReporter f20429d;
    private final FFMpegMediaDemuxerProvider f20430e;
    private final FFMpegMediaMuxerProvider f20431f;
    private final Lazy<FFMpegVideoMetadataExtractor> f20432g;

    public static VideoTrimOperation m19999b(InjectorLike injectorLike) {
        return new VideoTrimOperation((VideoMetadataExtractor) DefaultVideoMetadataExtractor.b(injectorLike), FFMpegBasedVideoTrackExtractor.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FFMpegMediaDemuxerProvider.b(injectorLike), FFMpegMediaMuxerProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 11727));
    }

    @Inject
    VideoTrimOperation(VideoMetadataExtractor videoMetadataExtractor, FFMpegBasedVideoTrackExtractor fFMpegBasedVideoTrackExtractor, FbErrorReporter fbErrorReporter, FFMpegMediaDemuxerProvider fFMpegMediaDemuxerProvider, FFMpegMediaMuxerProvider fFMpegMediaMuxerProvider, Lazy<FFMpegVideoMetadataExtractor> lazy) {
        this.f20427b = videoMetadataExtractor;
        this.f20428c = fFMpegBasedVideoTrackExtractor;
        this.f20429d = fbErrorReporter;
        this.f20430e = fFMpegMediaDemuxerProvider;
        this.f20431f = fFMpegMediaMuxerProvider;
        this.f20432g = lazy;
    }

    final void m20000a(VideoTrimmerParams videoTrimmerParams) {
        Throwable th;
        FFMpegMediaDemuxer fFMpegMediaDemuxer = null;
        FFMpegMediaMuxer fFMpegMediaMuxer = null;
        FFMpegMediaDemuxer a;
        try {
            TrackInfo a2;
            TrackInfo b;
            VideoMetadata a3;
            long j;
            long d;
            ByteBuffer allocateDirect;
            FFMpegMediaMuxer a4;
            a = this.f20430e.a(videoTrimmerParams.f20439a.getPath()).a();
            try {
                a2 = this.f20428c.a(a);
                b = this.f20428c.b(a);
                if (videoTrimmerParams.f20444f) {
                    a3 = ((FFMpegVideoMetadataExtractor) this.f20432g.get()).a(Uri.fromFile(videoTrimmerParams.f20439a));
                } else {
                    a3 = this.f20427b.a(Uri.fromFile(videoTrimmerParams.f20439a));
                }
                long j2 = (long) (videoTrimmerParams.f20441c * 1000);
                long j3 = (long) (videoTrimmerParams.f20442d * 1000);
                if (j2 < 0) {
                    j2 = 0;
                }
                if (j3 < 0) {
                    j = a3.a * 1000;
                } else {
                    j = j3;
                }
                a.b(a2.c);
                if (b != null) {
                    a.b(b.c);
                }
                a.a(a2.c, j2, 0);
                d = a.d();
                allocateDirect = ByteBuffer.allocateDirect(1048576);
                a4 = this.f20431f.a(videoTrimmerParams.f20440b.getPath()).a();
            } catch (Throwable th2) {
                th = th2;
                if (videoTrimmerParams.f20443e != null) {
                    videoTrimmerParams.f20443e.a();
                }
                if (a != null) {
                    a.g();
                }
                if (fFMpegMediaMuxer != null) {
                    fFMpegMediaMuxer.c();
                }
                throw th;
            }
            try {
                FFMpegAVStream a5 = a4.a(a2.b);
                FFMpegAVStream fFMpegAVStream = null;
                if (b != null) {
                    fFMpegAVStream = a4.a(b.b);
                }
                a4.b();
                a5.a(a3.d);
                FFMpegBufferInfo fFMpegBufferInfo = new FFMpegBufferInfo();
                ByteBuffer byteBuffer = a2.b.getByteBuffer("csd-0");
                if (byteBuffer != null) {
                    fFMpegBufferInfo.a(0, byteBuffer.capacity(), 0, 2);
                    a5.a(fFMpegBufferInfo, byteBuffer);
                }
                if (b != null) {
                    byteBuffer = b.b.getByteBuffer("csd-0");
                    if (byteBuffer != null) {
                        fFMpegBufferInfo.a(0, byteBuffer.capacity(), 0, 2);
                        fFMpegAVStream.a(fFMpegBufferInfo, byteBuffer);
                    }
                }
                long j4 = j - d;
                do {
                    long d2 = a.d();
                    int e = a.e();
                    int c = a.c();
                    if (d2 > j) {
                        break;
                    }
                    int a6 = a.a(allocateDirect, 0);
                    if (a6 == -1) {
                        break;
                    }
                    Long.valueOf(d2);
                    Integer.valueOf(e);
                    Integer.valueOf(a6);
                    Integer.valueOf(c);
                    if (e == a2.c) {
                        fFMpegBufferInfo.a(0, a6, d2 - d, c);
                        a5.a(fFMpegBufferInfo, allocateDirect);
                    } else if (b != null && e == b.c) {
                        fFMpegBufferInfo.a(0, a6, d2 - d, c);
                        fFMpegAVStream.a(fFMpegBufferInfo, allocateDirect);
                    }
                    if (videoTrimmerParams.f20443e != null) {
                        videoTrimmerParams.f20443e.a(((double) d2) / ((double) j4));
                    }
                } while (a.b());
                if (videoTrimmerParams.f20443e != null) {
                    videoTrimmerParams.f20443e.a();
                }
                if (a != null) {
                    a.g();
                }
                if (a4 != null) {
                    a4.c();
                }
            } catch (Throwable th3) {
                th = th3;
                fFMpegMediaMuxer = a4;
                if (videoTrimmerParams.f20443e != null) {
                    videoTrimmerParams.f20443e.a();
                }
                if (a != null) {
                    a.g();
                }
                if (fFMpegMediaMuxer != null) {
                    fFMpegMediaMuxer.c();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            a = null;
            if (videoTrimmerParams.f20443e != null) {
                videoTrimmerParams.f20443e.a();
            }
            if (a != null) {
                a.g();
            }
            if (fFMpegMediaMuxer != null) {
                fFMpegMediaMuxer.c();
            }
            throw th;
        }
    }
}
