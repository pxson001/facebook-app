package com.facebook.video.scrubber;

import android.graphics.RectF;
import com.facebook.gl.ProgramFactory;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.effects.GLRenderer;
import com.facebook.videocodec.policy.VideoMirroringMode;
import java.util.List;

/* compiled from: displayed */
public class CodecOutputSurfaceProvider extends AbstractAssistedProvider<CodecOutputSurface> {
    public final CodecOutputSurface m19654a(VideoMetadata videoMetadata, RectF rectF, VideoMirroringMode videoMirroringMode, List<GLRenderer> list) {
        return new CodecOutputSurface(videoMetadata, rectF, videoMirroringMode, list, PlatformBitmapFactoryMethodAutoProvider.a(this), ProgramFactory.b(this));
    }
}
