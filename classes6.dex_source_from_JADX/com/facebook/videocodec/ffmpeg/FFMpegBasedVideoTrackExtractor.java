package com.facebook.videocodec.ffmpeg;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.ffmpeg.FFMpegMediaDemuxer;
import com.facebook.ffmpeg.FFMpegMediaFormat;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: retail_receipts */
public class FFMpegBasedVideoTrackExtractor {
    public static final ImmutableSet<String> f5551a = ImmutableSet.of("video/avc", "video/mp4");
    public static final ImmutableSet<String> f5552b = ImmutableSet.of("audio/3gpp", "audio/amr-wb", "audio/mp4a", "audio/vorbis");
    private final AbstractFbErrorReporter f5553c;

    /* compiled from: retail_receipts */
    public class TrackException extends Exception {
        public TrackException(String str) {
            super(str);
        }
    }

    /* compiled from: retail_receipts */
    public class TrackInfo {
        public final String f5548a;
        public final FFMpegMediaFormat f5549b;
        public final int f5550c;

        public TrackInfo(String str, FFMpegMediaFormat fFMpegMediaFormat, int i) {
            this.f5548a = str;
            this.f5549b = fFMpegMediaFormat;
            this.f5550c = i;
        }
    }

    public static FFMpegBasedVideoTrackExtractor m8227b(InjectorLike injectorLike) {
        return new FFMpegBasedVideoTrackExtractor((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public FFMpegBasedVideoTrackExtractor(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f5553c = abstractFbErrorReporter;
    }

    public final TrackInfo m8229a(FFMpegMediaDemuxer fFMpegMediaDemuxer) {
        List<TrackInfo> a = Lists.a();
        int f = fFMpegMediaDemuxer.f();
        for (int i = 0; i < f; i++) {
            FFMpegMediaFormat a2 = fFMpegMediaDemuxer.a(i);
            String string = a2.getString("mime");
            if (string != null && string.startsWith("video/")) {
                a.add(new TrackInfo(string, a2, i));
            }
        }
        if (a.isEmpty()) {
            throw new TrackException("No video track");
        }
        for (TrackInfo trackInfo : a) {
            if (f5551a.contains(trackInfo.f5548a)) {
                break;
            }
        }
        TrackInfo trackInfo2 = null;
        TrackInfo trackInfo3 = trackInfo2;
        if (trackInfo3 == null) {
            throw new TrackException("Unsupported video format. Contained " + m8228c(a));
        }
        if (a.size() > 1) {
            this.f5553c.a("FFMpegBasedVideoTrackExtractor_multiple_video_tracks", m8228c(a));
        }
        return trackInfo3;
    }

    public final TrackInfo m8230b(FFMpegMediaDemuxer fFMpegMediaDemuxer) {
        List<TrackInfo> a = Lists.a();
        int f = fFMpegMediaDemuxer.f();
        for (int i = 0; i < f; i++) {
            FFMpegMediaFormat a2 = fFMpegMediaDemuxer.a(i);
            String string = a2.getString("mime");
            if (string != null && string.startsWith("audio/")) {
                a.add(new TrackInfo(string, a2, i));
            }
        }
        if (a.isEmpty()) {
            return null;
        }
        for (TrackInfo trackInfo : a) {
            if (f5552b.contains(trackInfo.f5548a)) {
                break;
            }
        }
        TrackInfo trackInfo2 = null;
        TrackInfo trackInfo3 = trackInfo2;
        if (trackInfo3 == null) {
            throw new TrackException("Unsupported audio codec. Contained " + m8228c(a));
        } else if (a.size() <= 1) {
            return trackInfo3;
        } else {
            this.f5553c.a("FFMpegBasedVideoTrackExtractor_multiple_audio_tracks", m8228c(a));
            return trackInfo3;
        }
    }

    private static String m8228c(List<TrackInfo> list) {
        Iterable a = Lists.a();
        for (TrackInfo trackInfo : list) {
            a.add(trackInfo.f5548a);
        }
        return list.size() + " tracks: " + Joiner.on(", ").join(a);
    }
}
