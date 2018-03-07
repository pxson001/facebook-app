package com.facebook.timeline.favmediapicker.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: friends_sharing */
public class FavoriteMediaPickerDeclarations implements FeedRowSupportDeclaration {
    private static FavoriteMediaPickerDeclarations f11037a;
    private static final Object f11038b = new Object();

    private static FavoriteMediaPickerDeclarations m11205a() {
        return new FavoriteMediaPickerDeclarations();
    }

    public final void m11207a(ListItemRowController listItemRowController) {
    }

    public static FavoriteMediaPickerDeclarations m11206a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FavoriteMediaPickerDeclarations a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f11038b) {
                FavoriteMediaPickerDeclarations favoriteMediaPickerDeclarations;
                if (a3 != null) {
                    favoriteMediaPickerDeclarations = (FavoriteMediaPickerDeclarations) a3.a(f11038b);
                } else {
                    favoriteMediaPickerDeclarations = f11037a;
                }
                if (favoriteMediaPickerDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m11205a();
                        if (a3 != null) {
                            a3.a(f11038b, a2);
                        } else {
                            f11037a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = favoriteMediaPickerDeclarations;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
