package com.facebook.videocodec.prober;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.ffmpeg.FFMpegMediaDemuxer;
import com.facebook.ffmpeg.FFMpegMediaDemuxerProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.ffmpeg.FFMpegBasedVideoTrackExtractor;
import com.facebook.videocodec.ffmpeg.FFMpegBasedVideoTrackExtractor.TrackInfo;
import java.io.File;
import javax.inject.Inject;

/* compiled from: android.telephony.extra.MMS_DATA */
public class VideoProber {
    private static final Class<?> f20422a = VideoProber.class;
    private final AbstractFbErrorReporter f20423b;
    private final FFMpegBasedVideoTrackExtractor f20424c;
    private final FFMpegMediaDemuxerProvider f20425d;

    public static VideoProber m19997b(InjectorLike injectorLike) {
        return new VideoProber((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FFMpegBasedVideoTrackExtractor.b(injectorLike), FFMpegMediaDemuxerProvider.b(injectorLike));
    }

    @Inject
    public VideoProber(AbstractFbErrorReporter abstractFbErrorReporter, FFMpegBasedVideoTrackExtractor fFMpegBasedVideoTrackExtractor, FFMpegMediaDemuxerProvider fFMpegMediaDemuxerProvider) {
        this.f20423b = abstractFbErrorReporter;
        this.f20424c = fFMpegBasedVideoTrackExtractor;
        this.f20425d = fFMpegMediaDemuxerProvider;
    }

    public final VideoProbeResult m19998a(File file) {
        FFMpegMediaDemuxer fFMpegMediaDemuxer = null;
        try {
            fFMpegMediaDemuxer = this.f20425d.a(file.getPath()).a();
            TrackInfo b = this.f20424c.b(fFMpegMediaDemuxer);
            VideoProbeResult videoProbeResult = b != null ? new VideoProbeResult(b.a) : new VideoProbeResult();
            if (fFMpegMediaDemuxer != null) {
                fFMpegMediaDemuxer.g();
            }
            return videoProbeResult;
        } catch (Throwable th) {
            if (fFMpegMediaDemuxer != null) {
                fFMpegMediaDemuxer.g();
            }
        }
    }
}
