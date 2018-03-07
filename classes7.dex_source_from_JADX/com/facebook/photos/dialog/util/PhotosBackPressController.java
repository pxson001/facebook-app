package com.facebook.photos.dialog.util;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.concurrent.CopyOnWriteArrayList;

@ContextScoped
/* compiled from: links_edit_click */
public class PhotosBackPressController {
    private static PhotosBackPressController f10135b;
    private static final Object f10136c = new Object();
    public final CopyOnWriteArrayList<PhotosBackPressListener> f10137a = new CopyOnWriteArrayList();

    /* compiled from: links_edit_click */
    public interface PhotosBackPressListener {
        boolean m12011a();
    }

    private static PhotosBackPressController m12013b() {
        return new PhotosBackPressController();
    }

    public final void m12014a(PhotosBackPressListener photosBackPressListener) {
        this.f10137a.add(photosBackPressListener);
    }

    public final void m12015b(PhotosBackPressListener photosBackPressListener) {
        this.f10137a.remove(photosBackPressListener);
    }

    public static PhotosBackPressController m12012a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosBackPressController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10136c) {
                PhotosBackPressController photosBackPressController;
                if (a2 != null) {
                    photosBackPressController = (PhotosBackPressController) a2.a(f10136c);
                } else {
                    photosBackPressController = f10135b;
                }
                if (photosBackPressController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m12013b();
                        if (a2 != null) {
                            a2.a(f10136c, b3);
                        } else {
                            f10135b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosBackPressController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
