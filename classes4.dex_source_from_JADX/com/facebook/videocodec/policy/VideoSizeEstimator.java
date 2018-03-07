package com.facebook.videocodec.policy;

import android.graphics.RectF;
import com.facebook.videocodec.base.VideoMetadata;
import com.google.common.base.Preconditions;
import javax.inject.Provider;

/* compiled from: mFbid */
public class VideoSizeEstimator {
    public static final RectF f8713a = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private final AbstractVideoResizingPolicy f8714b;
    public final Provider<Boolean> f8715c;

    public VideoSizeEstimator(VideoResizingPolicy videoResizingPolicy, Provider<Boolean> provider) {
        this.f8714b = videoResizingPolicy;
        this.f8715c = provider;
    }

    public final Estimate m8996a(VideoMetadata videoMetadata, int i, int i2) {
        int i3;
        int i4;
        Preconditions.checkNotNull(videoMetadata);
        if (((Boolean) this.f8715c.get()).booleanValue()) {
            VideoTranscodeParams a = this.f8714b.a(videoMetadata, 0, f8713a, VideoMirroringMode.NONE, null, null);
            i3 = a.d;
            i4 = a.e;
        } else {
            i3 = videoMetadata.b;
            i4 = videoMetadata.c;
        }
        return m8994a(videoMetadata, i, i2, i3, i4, m8992a(videoMetadata));
    }

    public static Estimate m8994a(VideoMetadata videoMetadata, int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        if (i == -1) {
            i = 0;
        }
        if (i2 == -2) {
            i2 = (int) videoMetadata.a;
        }
        int i7 = i2 - i;
        if (videoMetadata.g > 0) {
            i6 = videoMetadata.g;
        }
        return new Estimate(i3, i4, ((i6 + i5) / 8) * (i7 / 1000), i7, i5, i6);
    }

    public final int m8995a(VideoMetadata videoMetadata, int i) {
        if (i < 0) {
            return -1;
        }
        return i / (((videoMetadata.g > 0 ? videoMetadata.g : 0) + m8992a(videoMetadata)) / 8);
    }

    private int m8992a(VideoMetadata videoMetadata) {
        VideoTranscodeParams videoTranscodeParams = null;
        boolean booleanValue = ((Boolean) this.f8715c.get()).booleanValue();
        if (booleanValue) {
            videoTranscodeParams = this.f8714b.a(videoMetadata, 0, f8713a, VideoMirroringMode.NONE, null, null);
        }
        return m8993a(videoMetadata, videoTranscodeParams, booleanValue);
    }

    public static int m8993a(VideoMetadata videoMetadata, VideoTranscodeParams videoTranscodeParams, boolean z) {
        if (z) {
            return videoTranscodeParams.j;
        }
        int i = videoMetadata.e;
        if (i >= 0) {
            return i;
        }
        if (videoMetadata.f > 0 && videoMetadata.a > 0) {
            return (int) (((videoMetadata.f * 8) / videoMetadata.a) * 1000);
        }
        if (videoMetadata.b <= 0 || videoMetadata.c <= 0) {
            return 3686400;
        }
        return (videoMetadata.b * videoMetadata.c) * 6;
    }
}
