package com.facebook.timeline.editfeaturedcontainers.models;

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
/* compiled from: google_sdk */
public class NullStateData implements ListItemCollection<Object> {
    private static NullStateData f10766d;
    private static final Object f10767e = new Object();
    public final List<Object> f10768a = new ArrayList();
    public final CameraRollData f10769b;
    public final SuggestedPhotosData f10770c;

    private static NullStateData m10788b() {
        return new NullStateData();
    }

    @Inject
    public NullStateData() {
        this.f10768a.add(new RecentSectionData());
        List list = this.f10768a;
        CameraRollData cameraRollData = new CameraRollData();
        this.f10769b = cameraRollData;
        list.add(cameraRollData);
        list = this.f10768a;
        SuggestedPhotosData suggestedPhotosData = new SuggestedPhotosData();
        this.f10770c = suggestedPhotosData;
        list.add(suggestedPhotosData);
    }

    public final int m10789a() {
        return this.f10768a.size();
    }

    public final Object m10790a(int i) {
        if (i < this.f10768a.size()) {
            return this.f10768a.get(i);
        }
        throw new IllegalArgumentException("Invalid index: " + i);
    }

    public static NullStateData m10787a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateData b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10767e) {
                NullStateData nullStateData;
                if (a2 != null) {
                    nullStateData = (NullStateData) a2.a(f10767e);
                } else {
                    nullStateData = f10766d;
                }
                if (nullStateData == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m10788b();
                        if (a2 != null) {
                            a2.a(f10767e, b3);
                        } else {
                            f10766d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateData;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
