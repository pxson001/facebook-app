package com.facebook.photos.photoset.controllers;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Preconditions;

@ContextScoped
/* compiled from: collapse */
public class FbPhotoPickerController {
    private static FbPhotoPickerController f17780c;
    private static final Object f17781d = new Object();
    public boolean f17782a = false;
    public boolean f17783b = false;

    private static FbPhotoPickerController m21758c() {
        return new FbPhotoPickerController();
    }

    public final void m21759a(Intent intent) {
        boolean z = false;
        if (intent != null) {
            this.f17782a = intent.getBooleanExtra("pick_hc_pic", false);
            this.f17783b = intent.getBooleanExtra("pick_pic_lite", false);
            if (!(this.f17782a && this.f17783b)) {
                z = true;
            }
            Preconditions.checkArgument(z, "Cannot have both modes at the same time");
        }
    }

    public static FbPhotoPickerController m21757a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FbPhotoPickerController c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17781d) {
                FbPhotoPickerController fbPhotoPickerController;
                if (a2 != null) {
                    fbPhotoPickerController = (FbPhotoPickerController) a2.a(f17781d);
                } else {
                    fbPhotoPickerController = f17780c;
                }
                if (fbPhotoPickerController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m21758c();
                        if (a2 != null) {
                            a2.a(f17781d, c);
                        } else {
                            f17780c = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = fbPhotoPickerController;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
