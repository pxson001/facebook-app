package com.facebook.photos.data;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.data.service.PhotosServiceHandler;
import com.facebook.photos.data.service.PhotosServiceMemoryCacheFilter;

/* compiled from: images_urls */
public class BlueServiceHandler_PhotosServiceQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    private static BlueServiceHandler f12871a;
    private static final Object f12872b = new Object();

    private static BlueServiceHandler m20259b(InjectorLike injectorLike) {
        return PhotosDataModule.m20260a(PhotosServiceMemoryCacheFilter.m20343a(injectorLike), PhotosServiceHandler.m20336a(injectorLike));
    }

    public Object get() {
        return PhotosDataModule.m20260a(PhotosServiceMemoryCacheFilter.m20343a(this), PhotosServiceHandler.m20336a((InjectorLike) this));
    }

    public static BlueServiceHandler m20258a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BlueServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12872b) {
                BlueServiceHandler blueServiceHandler;
                if (a2 != null) {
                    blueServiceHandler = (BlueServiceHandler) a2.a(f12872b);
                } else {
                    blueServiceHandler = f12871a;
                }
                if (blueServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20259b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12872b, b3);
                        } else {
                            f12871a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = blueServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
