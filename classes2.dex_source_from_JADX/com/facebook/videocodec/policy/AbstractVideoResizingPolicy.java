package com.facebook.videocodec.policy;

import android.graphics.RectF;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.effects.GLRenderer;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: mReentrantLock */
public abstract class AbstractVideoResizingPolicy {
    private static final RectF f15477a = new RectF(0.0f, 0.0f, 1.0f, 1.0f);

    protected abstract VideoResizeConfig mo2853a();

    public final VideoTranscodeParams m22039a(int i, int i2, int i3, RectF rectF, VideoMirroringMode videoMirroringMode) {
        return m22037a(i, i2, i3, 0, -1, rectF, videoMirroringMode, null, null);
    }

    public final VideoTranscodeParams m22040a(VideoMetadata videoMetadata, int i, RectF rectF, VideoMirroringMode videoMirroringMode, VideoTranscodeProfileLevelParams videoTranscodeProfileLevelParams, List<GLRenderer> list) {
        boolean z = i == 0 || i == 90 || i == 180 || i == 270;
        Preconditions.checkArgument(z, "OutputRotationDegreesClockwise Must be one of 0, 90, 180, 270");
        return m22037a(videoMetadata.b, videoMetadata.c, videoMetadata.d, i, videoMetadata.e, rectF, videoMirroringMode, videoTranscodeProfileLevelParams, list);
    }

    private VideoTranscodeParams m22037a(int i, int i2, int i3, int i4, int i5, RectF rectF, VideoMirroringMode videoMirroringMode, VideoTranscodeProfileLevelParams videoTranscodeProfileLevelParams, List<GLRenderer> list) {
        int i6;
        VideoResizeConfig a = mo2853a();
        if (i5 <= 0 || a.b < i5) {
            i6 = a.b;
        } else {
            i6 = i5;
        }
        if (i <= 0 || i2 <= 0) {
            return new VideoTranscodeParams(640, 480, i3, 640, 480, 0, i4, f15477a, videoMirroringMode, i6, Math.round(a.c), a.d, videoTranscodeProfileLevelParams, list);
        }
        int i7;
        int i8;
        int i9;
        int i10 = (i3 == 90 || i3 == 270) ? i2 : i;
        if (i3 == 90 || i3 == 270) {
            i7 = i;
        } else {
            i7 = i2;
        }
        int width = (int) (((float) i10) * rectF.width());
        int height = (int) (((float) i7) * rectF.height());
        if (width > height && width > a.a) {
            i8 = a.a;
            i9 = (height * i8) / width;
        } else if (height <= width || height <= a.a) {
            i9 = height;
            i8 = width;
        } else {
            i9 = a.a;
            i8 = (width * i9) / height;
        }
        int i11 = i8 % 16;
        if (i11 != 0) {
            i11 = (16 - i11) + i8;
            i9 = (int) (((float) i9) * (((float) i11) / ((float) i8)));
            i8 = i11;
        }
        i11 = i9 % 16;
        if (i11 != 0) {
            i9 += 16 - i11;
        }
        RectF rectF2 = new RectF(rectF.left, rectF.top, (((float) i8) / ((((float) i8) / ((float) width)) * ((float) i10))) + rectF.left, (((float) i9) / (((float) i7) * (((float) i9) / ((float) height)))) + rectF.top);
        i10 = 0;
        if (i9 > i8) {
            i10 = 90;
            i11 = i8;
            width = i9;
        } else {
            i11 = i9;
            width = i8;
        }
        return new VideoTranscodeParams(i, i2, i3, width, i11, i10, i4, rectF2, videoMirroringMode, i6, Math.round(a.c), a.d, videoTranscodeProfileLevelParams, list);
    }
}
