package com.facebook.photos.photoset.ui.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;

@ContextScoped
/* compiled from: closed_reason */
public class AlbumPermalinkTitleBarSupplier implements FbTitleBarSupplier {
    private static AlbumPermalinkTitleBarSupplier f17821b;
    private static final Object f17822c = new Object();
    public FbTitleBar f17823a;

    private static AlbumPermalinkTitleBarSupplier m21789b() {
        return new AlbumPermalinkTitleBarSupplier();
    }

    public /* synthetic */ Object get() {
        return this.f17823a;
    }

    public static AlbumPermalinkTitleBarSupplier m21788a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AlbumPermalinkTitleBarSupplier b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17822c) {
                AlbumPermalinkTitleBarSupplier albumPermalinkTitleBarSupplier;
                if (a2 != null) {
                    albumPermalinkTitleBarSupplier = (AlbumPermalinkTitleBarSupplier) a2.a(f17822c);
                } else {
                    albumPermalinkTitleBarSupplier = f17821b;
                }
                if (albumPermalinkTitleBarSupplier == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m21789b();
                        if (a2 != null) {
                            a2.a(f17822c, b3);
                        } else {
                            f17821b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = albumPermalinkTitleBarSupplier;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
