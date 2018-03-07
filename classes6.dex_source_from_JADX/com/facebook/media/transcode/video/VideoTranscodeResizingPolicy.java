package com.facebook.media.transcode.video;

import com.facebook.videocodec.policy.AbstractVideoResizingPolicy;
import com.facebook.videocodec.policy.VideoResizeConfig;

/* compiled from: keyword_mode */
public class VideoTranscodeResizingPolicy extends AbstractVideoResizingPolicy {
    private VideoResizeConfig f11880a;

    private VideoTranscodeResizingPolicy(int i, int i2, int i3, int i4) {
        this.f11880a = new VideoResizeConfig(i, i2, (float) i3, i4);
    }

    public static VideoTranscodeResizingPolicy m18832b() {
        return new VideoTranscodeResizingPolicy(640, 655360, 30, 10);
    }

    public static VideoTranscodeResizingPolicy m18831a(int i) {
        return new VideoTranscodeResizingPolicy(640, i, 30, 10);
    }

    protected final VideoResizeConfig m18833a() {
        return this.f11880a;
    }
}
