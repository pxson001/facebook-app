package com.facebook.timeline.data;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: feather_overlay_dismiss */
public class TimelineHeaderRenderState {
    private static TimelineHeaderRenderState f14576f;
    private static final Object f14577g = new Object();
    public boolean f14578a = false;
    public boolean f14579b = false;
    public boolean f14580c = false;
    public PhotoLoadState f14581d = PhotoLoadState.PHOTO_NOT_LOADED;
    public PhotoLoadState f14582e = PhotoLoadState.PHOTO_NOT_LOADED;

    private static TimelineHeaderRenderState m18471o() {
        return new TimelineHeaderRenderState();
    }

    public final boolean m18472e() {
        return this.f14580c;
    }

    public static TimelineHeaderRenderState m18470a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineHeaderRenderState o;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14577g) {
                TimelineHeaderRenderState timelineHeaderRenderState;
                if (a2 != null) {
                    timelineHeaderRenderState = (TimelineHeaderRenderState) a2.a(f14577g);
                } else {
                    timelineHeaderRenderState = f14576f;
                }
                if (timelineHeaderRenderState == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        o = m18471o();
                        if (a2 != null) {
                            a2.a(f14577g, o);
                        } else {
                            f14576f = o;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    o = timelineHeaderRenderState;
                }
            }
            return o;
        } finally {
            a.c(b);
        }
    }

    public final boolean m18473h() {
        return this.f14579b || PhotoLoadState.isFailLoadState(this.f14582e) || PhotoLoadState.isFailLoadState(this.f14581d);
    }

    public final boolean m18474i() {
        return this.f14578a && PhotoLoadState.isPhotoLoaded(this.f14582e);
    }

    public final boolean m18475j() {
        return this.f14578a && PhotoLoadState.isPhotoLoaded(this.f14581d);
    }

    public final boolean m18476k() {
        return m18475j() && PhotoLoadState.isPhotoLoaded(this.f14582e);
    }

    public final boolean m18477l() {
        return this.f14578a && PhotoLoadState.isFinalPhotoLoadState(this.f14582e) && PhotoLoadState.isFinalPhotoLoadState(this.f14581d);
    }
}
