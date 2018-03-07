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

/* compiled from: restarted_operation_source */
public class VideoResizerParams {
    public final File f5670a;
    public final File f5671b;
    public final AbstractVideoResizingPolicy f5672c;
    public final RectF f5673d;
    public final VideoMirroringMode f5674e;
    public final boolean f5675f;
    public final boolean f5676g;
    public final boolean f5677h;
    public final int f5678i;
    public final int f5679j;
    public final int f5680k;
    public final VideoOperationProgressListener f5681l;
    public final VideoTranscodeProfileLevelParams f5682m;
    public final List<GLRenderer> f5683n;

    VideoResizerParams(VideoResizerParamsBuilder videoResizerParamsBuilder) {
        this.f5670a = (File) Preconditions.checkNotNull(videoResizerParamsBuilder.f5684a);
        this.f5671b = (File) Preconditions.checkNotNull(videoResizerParamsBuilder.f5685b);
        this.f5672c = (AbstractVideoResizingPolicy) Preconditions.checkNotNull(videoResizerParamsBuilder.f5686c);
        this.f5673d = videoResizerParamsBuilder.f5687d;
        this.f5674e = videoResizerParamsBuilder.f5688e;
        this.f5678i = videoResizerParamsBuilder.f5689f;
        this.f5679j = videoResizerParamsBuilder.f5690g;
        this.f5681l = videoResizerParamsBuilder.f5691h;
        this.f5675f = videoResizerParamsBuilder.f5692i;
        this.f5676g = videoResizerParamsBuilder.f5693j;
        this.f5677h = videoResizerParamsBuilder.f5694k;
        this.f5682m = videoResizerParamsBuilder.f5695l;
        this.f5680k = videoResizerParamsBuilder.f5696m;
        this.f5683n = videoResizerParamsBuilder.f5697n;
    }

    public static VideoResizerParamsBuilder newBuilder() {
        return new VideoResizerParamsBuilder();
    }
}
