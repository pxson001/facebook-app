package com.facebook.videocodec.effects.renderers;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: destination intent was null */
public class OverlayRendererProvider extends AbstractAssistedProvider<OverlayRenderer> {
    public final OverlayRenderer m19790a(Uri uri, CallerContext callerContext) {
        return new OverlayRenderer(ImagePipelineMethodAutoProvider.a(this), uri, callerContext);
    }
}
