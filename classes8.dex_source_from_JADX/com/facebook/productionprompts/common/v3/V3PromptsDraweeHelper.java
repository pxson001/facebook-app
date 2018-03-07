package com.facebook.productionprompts.common.v3;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.GenericDraweeHierarchyBuilderMethodAutoProvider;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: request_composer_session_id */
public class V3PromptsDraweeHelper {
    public static final CallerContext f4526a = CallerContext.a(V3PromptsDraweeHelper.class);
    public final GenericDraweeHierarchyBuilder f4527b;
    public final FbDraweeControllerBuilder f4528c;
    public final ResizeOptions f4529d;
    public final Resources f4530e;

    public static V3PromptsDraweeHelper m4380b(InjectorLike injectorLike) {
        return new V3PromptsDraweeHelper(GenericDraweeHierarchyBuilderMethodAutoProvider.b(injectorLike), FbDraweeControllerBuilder.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public V3PromptsDraweeHelper(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, FbDraweeControllerBuilder fbDraweeControllerBuilder, Resources resources) {
        this.f4527b = genericDraweeHierarchyBuilder;
        this.f4528c = fbDraweeControllerBuilder;
        this.f4530e = resources;
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430425);
        this.f4529d = new ResizeOptions(dimensionPixelSize, dimensionPixelSize);
    }

    public final DraweeHolder m4381a(Uri uri, Context context) {
        this.f4528c.p();
        GenericDraweeHierarchyBuilder e = this.f4527b.e(ScaleType.c);
        e.d = 0;
        e = e;
        e.u = new RoundingParams().a((float) this.f4530e.getDimensionPixelSize(2131430429));
        DraweeHierarchy u = e.u();
        this.f4528c.p();
        FbDraweeControllerBuilder a = this.f4528c.a(f4526a);
        ImageRequestBuilder a2 = ImageRequestBuilder.a(uri);
        a2.c = true;
        a2 = a2;
        a2.d = this.f4529d;
        DraweeController s = ((FbDraweeControllerBuilder) a.c(a2.m())).s();
        DraweeHolder a3 = DraweeHolder.a(u, context);
        a3.a(s);
        return a3;
    }
}
