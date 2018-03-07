package com.facebook.friendsharing.souvenirs.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RECENT_SEARCHS */
public class SouvenirLocalImageRequest {
    private static SouvenirLocalImageRequest f24211c;
    private static final Object f24212d = new Object();
    public final int f24213a;
    public final int f24214b;

    private static SouvenirLocalImageRequest m26453b(InjectorLike injectorLike) {
        return new SouvenirLocalImageRequest(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SouvenirLocalImageRequest(Resources resources) {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.f24213a = Math.max(128, Math.min(displayMetrics.widthPixels, 4096));
        this.f24214b = Math.max(128, Math.min(displayMetrics.heightPixels, 4096));
    }

    public static SouvenirLocalImageRequest m26452a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SouvenirLocalImageRequest b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24212d) {
                SouvenirLocalImageRequest souvenirLocalImageRequest;
                if (a2 != null) {
                    souvenirLocalImageRequest = (SouvenirLocalImageRequest) a2.a(f24212d);
                } else {
                    souvenirLocalImageRequest = f24211c;
                }
                if (souvenirLocalImageRequest == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26453b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24212d, b3);
                        } else {
                            f24211c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = souvenirLocalImageRequest;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
