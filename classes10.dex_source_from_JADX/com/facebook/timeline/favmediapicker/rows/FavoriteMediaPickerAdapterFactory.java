package com.facebook.timeline.favmediapicker.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.favmediapicker.models.FavoriteMediaPickerData;
import com.facebook.timeline.favmediapicker.rows.parts.FavoriteMediaPickerRootGroupPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_sharing_location_connection */
public class FavoriteMediaPickerAdapterFactory {
    private static FavoriteMediaPickerAdapterFactory f11032d;
    private static final Object f11033e = new Object();
    public final MultiRowAdapterBuilder f11034a;
    public final Lazy<FavoriteMediaPickerRootGroupPartDefinition> f11035b;
    public final FavoriteMediaPickerData f11036c;

    private static FavoriteMediaPickerAdapterFactory m11204b(InjectorLike injectorLike) {
        return new FavoriteMediaPickerAdapterFactory(MultiRowAdapterBuilder.b(injectorLike), IdBasedLazy.a(injectorLike, 11226), FavoriteMediaPickerData.m11147a(injectorLike));
    }

    @Inject
    public FavoriteMediaPickerAdapterFactory(MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<FavoriteMediaPickerRootGroupPartDefinition> lazy, FavoriteMediaPickerData favoriteMediaPickerData) {
        this.f11034a = multiRowAdapterBuilder;
        this.f11035b = lazy;
        this.f11036c = favoriteMediaPickerData;
    }

    public static FavoriteMediaPickerAdapterFactory m11203a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FavoriteMediaPickerAdapterFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11033e) {
                FavoriteMediaPickerAdapterFactory favoriteMediaPickerAdapterFactory;
                if (a2 != null) {
                    favoriteMediaPickerAdapterFactory = (FavoriteMediaPickerAdapterFactory) a2.a(f11033e);
                } else {
                    favoriteMediaPickerAdapterFactory = f11032d;
                }
                if (favoriteMediaPickerAdapterFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11204b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11033e, b3);
                        } else {
                            f11032d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = favoriteMediaPickerAdapterFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
