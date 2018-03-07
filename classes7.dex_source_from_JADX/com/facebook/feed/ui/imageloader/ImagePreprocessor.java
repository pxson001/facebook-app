package com.facebook.feed.ui.imageloader;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: There is no currently selected route.  The media router has not yet been fully initialized. */
public interface ImagePreprocessor {
    @Nullable
    ListenableFuture<?> mo1549a(ImageRequest imageRequest, CallerContext callerContext);
}
