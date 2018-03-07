package com.facebook.videocodec.resizer;

/* compiled from: result_parsing_time */
public class SegmentTranscodeSettings {
    public final boolean f5635a;
    public final boolean f5636b;
    public final boolean f5637c;
    public final int f5638d;
    public final int f5639e;

    public SegmentTranscodeSettings(boolean z, boolean z2, boolean z3, int i, int i2) {
        this.f5635a = z;
        this.f5636b = z2;
        this.f5637c = z3;
        this.f5638d = i;
        this.f5639e = i2;
    }

    public final VideoResizerParamsBuilder m8265a(VideoResizerParamsBuilder videoResizerParamsBuilder) {
        videoResizerParamsBuilder.f5693j = this.f5636b;
        VideoResizerParamsBuilder videoResizerParamsBuilder2 = videoResizerParamsBuilder;
        videoResizerParamsBuilder2.f5692i = this.f5635a;
        videoResizerParamsBuilder2 = videoResizerParamsBuilder2;
        videoResizerParamsBuilder2.f5689f = this.f5638d;
        videoResizerParamsBuilder2 = videoResizerParamsBuilder2;
        videoResizerParamsBuilder2.f5690g = this.f5639e;
        videoResizerParamsBuilder2 = videoResizerParamsBuilder2;
        videoResizerParamsBuilder2.f5694k = this.f5637c;
        return videoResizerParamsBuilder2;
    }
}
