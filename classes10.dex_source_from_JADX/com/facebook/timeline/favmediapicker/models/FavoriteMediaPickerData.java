package com.facebook.timeline.favmediapicker.models;

import android.content.Context;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: from_other_app */
public class FavoriteMediaPickerData implements ListItemCollection<Object> {
    private static FavoriteMediaPickerData f11017c;
    private static final Object f11018d = new Object();
    public final List<Object> f11019a = new ArrayList();
    public final CameraRollData f11020b;

    private static FavoriteMediaPickerData m11148b() {
        return new FavoriteMediaPickerData();
    }

    @Inject
    public FavoriteMediaPickerData() {
        List list = this.f11019a;
        CameraRollData cameraRollData = new CameraRollData();
        this.f11020b = cameraRollData;
        list.add(cameraRollData);
        this.f11019a.add(new SuggestedForYouLabel());
    }

    public final int m11149a() {
        return this.f11019a.size();
    }

    public final Object m11150a(int i) {
        if (i < this.f11019a.size()) {
            return this.f11019a.get(i);
        }
        throw new IllegalArgumentException("Invalid index: " + i);
    }

    public static FavoriteMediaPickerData m11147a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FavoriteMediaPickerData b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11018d) {
                FavoriteMediaPickerData favoriteMediaPickerData;
                if (a2 != null) {
                    favoriteMediaPickerData = (FavoriteMediaPickerData) a2.a(f11018d);
                } else {
                    favoriteMediaPickerData = f11017c;
                }
                if (favoriteMediaPickerData == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m11148b();
                        if (a2 != null) {
                            a2.a(f11018d, b3);
                        } else {
                            f11017c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = favoriteMediaPickerData;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
