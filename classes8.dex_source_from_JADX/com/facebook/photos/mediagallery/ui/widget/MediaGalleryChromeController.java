package com.facebook.photos.mediagallery.ui.widget;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.widget.images.zoomableimageview.ZoomableImageViewListener;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: single_photo_ipb */
public class MediaGalleryChromeController {
    private static MediaGalleryChromeController f2635b;
    private static final Object f2636c = new Object();
    @Nullable
    public ZoomableImageViewListener f2637a;

    private static MediaGalleryChromeController m2721b() {
        return new MediaGalleryChromeController();
    }

    public static MediaGalleryChromeController m2720a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaGalleryChromeController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2636c) {
                MediaGalleryChromeController mediaGalleryChromeController;
                if (a2 != null) {
                    mediaGalleryChromeController = (MediaGalleryChromeController) a2.a(f2636c);
                } else {
                    mediaGalleryChromeController = f2635b;
                }
                if (mediaGalleryChromeController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m2721b();
                        if (a2 != null) {
                            a2.a(f2636c, b3);
                        } else {
                            f2635b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaGalleryChromeController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
