package com.facebook.videocodec.codecs;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.facebook.videocodec.codecs.Constants.MediaCodecType;

@TargetApi(16)
/* compiled from: review_step_closed */
public class MediaFormatBuilderForVideoEncoder {
    private MediaCodecType f5511a;
    private int f5512b;
    private int f5513c;
    private int f5514d;
    public int f5515e = 384000;
    public int f5516f = 15;
    public int f5517g;
    public boolean f5518h = false;
    public int f5519i = 1;
    public int f5520j = 256;

    public MediaFormatBuilderForVideoEncoder(MediaCodecType mediaCodecType, int i, int i2, int i3) {
        this.f5511a = mediaCodecType;
        this.f5512b = i;
        this.f5513c = i2;
        this.f5514d = i3;
    }

    public final MediaFormat m8189a() {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.f5511a.value, this.f5512b, this.f5513c);
        createVideoFormat.setInteger("color-format", this.f5514d);
        if (this.f5515e > 0) {
            createVideoFormat.setInteger("bitrate", this.f5515e);
        }
        if (this.f5516f > 0) {
            createVideoFormat.setInteger("frame-rate", this.f5516f);
        }
        if (this.f5517g > 0) {
            createVideoFormat.setInteger("i-frame-interval", this.f5517g);
        }
        if (this.f5518h) {
            createVideoFormat.setInteger("profile", this.f5519i);
            createVideoFormat.setInteger("level", this.f5520j);
        }
        return createVideoFormat;
    }
}
