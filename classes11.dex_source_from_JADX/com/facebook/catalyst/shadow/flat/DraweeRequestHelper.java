package com.facebook.catalyst.shadow.flat;

import android.graphics.drawable.Drawable;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: mDialog must exist when we call updateProperties */
public final class DraweeRequestHelper {
    public static GenericDraweeHierarchyBuilder f5652a;
    public static AbstractDraweeControllerBuilder f5653b;
    public final DraweeController f5654c;
    public int f5655d;

    public DraweeRequestHelper(ImageRequest imageRequest, ControllerListener controllerListener) {
        AbstractDraweeController i = f5653b.c(imageRequest).b(RCTImageView.f5784h).a(controllerListener).i();
        i.a(f5652a.u());
        this.f5654c = i;
    }

    final GenericDraweeHierarchy m6967b() {
        return (GenericDraweeHierarchy) this.f5654c.d();
    }

    public final Drawable m6968c() {
        return m6967b().a();
    }
}
