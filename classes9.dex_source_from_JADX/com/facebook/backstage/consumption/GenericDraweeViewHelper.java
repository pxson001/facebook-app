package com.facebook.backstage.consumption;

import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/* compiled from: salamander_payload */
public class GenericDraweeViewHelper {
    public static GenericDraweeHierarchy m4530a(Resources resources) {
        AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(resources.getDrawable(2130844043), 1000);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = autoRotateDrawable;
        return genericDraweeHierarchyBuilder.u();
    }

    public static PipelineDraweeController m4529a(Uri uri, FbDraweeControllerBuilder fbDraweeControllerBuilder, @Nullable ResizeOptions resizeOptions) {
        ImageRequestBuilder a = ImageRequestBuilder.a(uri);
        a.d = resizeOptions;
        return ((FbDraweeControllerBuilder) fbDraweeControllerBuilder.c(a.m())).a(CallerContext.a(BackstageFragment.class)).s();
    }
}
