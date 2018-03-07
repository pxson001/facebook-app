package com.facebook.videocodec.resizer;

import android.graphics.RectF;
import com.facebook.videocodec.base.VideoOperationProgressListener;
import com.facebook.videocodec.effects.GLRenderer;
import com.facebook.videocodec.policy.AbstractVideoResizingPolicy;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.facebook.videocodec.policy.VideoTranscodeProfileLevelParams;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.List;

/* compiled from: response_option_numeric_value */
public class VideoResizerParamsBuilder {
    public File f5684a;
    public File f5685b;
    public AbstractVideoResizingPolicy f5686c;
    public RectF f5687d = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public VideoMirroringMode f5688e = VideoMirroringMode.NONE;
    public int f5689f = -1;
    public int f5690g = -2;
    public VideoOperationProgressListener f5691h;
    public boolean f5692i = false;
    public boolean f5693j = false;
    public boolean f5694k = false;
    public VideoTranscodeProfileLevelParams f5695l = null;
    public int f5696m = 0;
    public List<GLRenderer> f5697n = null;

    VideoResizerParamsBuilder() {
    }

    public final VideoResizerParamsBuilder m8288a(File file) {
        this.f5684a = file;
        return this;
    }

    public final VideoResizerParamsBuilder m8292b(File file) {
        this.f5685b = file;
        return this;
    }

    public final VideoResizerParamsBuilder m8290a(boolean z) {
        this.f5692i = z;
        return this;
    }

    public final VideoResizerParamsBuilder m8286a(AbstractVideoResizingPolicy abstractVideoResizingPolicy) {
        this.f5686c = abstractVideoResizingPolicy;
        return this;
    }

    public final VideoResizerParamsBuilder m8284a(RectF rectF) {
        this.f5687d = rectF;
        return this;
    }

    public final VideoResizerParamsBuilder m8287a(VideoMirroringMode videoMirroringMode) {
        this.f5688e = videoMirroringMode;
        return this;
    }

    public final VideoResizerParamsBuilder m8283a(int i) {
        this.f5689f = i;
        return this;
    }

    public final VideoResizerParamsBuilder m8291b(int i) {
        this.f5690g = i;
        return this;
    }

    public final VideoResizerParamsBuilder m8293c(int i) {
        boolean z = i == 0 || i == 90 || i == 180 || i == 270;
        Preconditions.checkArgument(z, "OutputRotationDegreesClockwise Must be one of 0, 90, 180, 270");
        this.f5696m = i;
        return this;
    }

    public final VideoResizerParamsBuilder m8285a(VideoOperationProgressListener videoOperationProgressListener) {
        this.f5691h = videoOperationProgressListener;
        return this;
    }

    public final VideoResizerParamsBuilder m8289a(List<GLRenderer> list) {
        this.f5697n = list;
        return this;
    }

    public final VideoResizerParams m8294o() {
        return new VideoResizerParams(this);
    }
}
