package com.facebook.videocodec.policy;

import android.graphics.RectF;
import com.facebook.videocodec.effects.GLRenderer;
import com.google.common.base.Objects;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: resumable_upload */
public class VideoTranscodeParams {
    public final int f5574a;
    public final int f5575b;
    public final int f5576c;
    public final int f5577d;
    public final int f5578e;
    public final int f5579f;
    public final int f5580g;
    public final RectF f5581h;
    public final VideoMirroringMode f5582i;
    public final int f5583j;
    public final int f5584k;
    public final int f5585l;
    public final VideoTranscodeProfileLevelParams f5586m;
    public List<GLRenderer> f5587n;

    public VideoTranscodeParams(int i, int i2, int i3, int i4, int i5, int i6, int i7, RectF rectF, VideoMirroringMode videoMirroringMode, int i8, int i9, int i10, VideoTranscodeProfileLevelParams videoTranscodeProfileLevelParams, List<GLRenderer> list) {
        this.f5574a = i;
        this.f5575b = i2;
        this.f5576c = i3;
        this.f5577d = i4;
        this.f5578e = i5;
        this.f5579f = i6;
        this.f5580g = i7;
        this.f5581h = rectF;
        this.f5582i = videoMirroringMode;
        this.f5583j = i8;
        this.f5584k = i9;
        this.f5585l = i10;
        this.f5586m = videoTranscodeProfileLevelParams;
        this.f5587n = list;
    }

    public String toString() {
        return Objects.toStringHelper(VideoTranscodeParams.class).add("sourceWidth", this.f5574a).add("sourceHeight", this.f5575b).add("sourceRotationDegreesClockwise", this.f5576c).add("targetWidht", this.f5577d).add("targetHeight", this.f5578e).add("targetRotationDegreesClockwise", this.f5579f).add("outputRotationDegreesClockwise", this.f5580g).add("cropRectangle", this.f5581h).add("videoMirroringMode", this.f5582i).add("bitRate", this.f5583j).add("frameRate", this.f5584k).add("iframeinterval", this.f5585l).toString();
    }

    public final int m8252a() {
        return (this.f5579f + this.f5580g) % 360;
    }
}
