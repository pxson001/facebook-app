package com.facebook.picassolike.fresco;

import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.inject.InjectorLike;

/* compiled from: friend_request_cancel */
public class FrescoImpl {
    private static final CallerContext f14584a = CallerContext.b(FrescoImpl.class, "fresco_impl");

    public static FrescoImpl m22172a(InjectorLike injectorLike) {
        return new FrescoImpl();
    }

    public final void m22174a(View view, String str) {
        FbDraweeView fbDraweeView = (FbDraweeView) view;
        fbDraweeView.a(Uri.parse(str), f14584a);
        ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).a(ScaleType.b);
    }

    public final void m22173a(int i, View view) {
        FbDraweeView fbDraweeView = (FbDraweeView) view;
        ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).b(i);
        fbDraweeView.a(null, f14584a);
    }
}
