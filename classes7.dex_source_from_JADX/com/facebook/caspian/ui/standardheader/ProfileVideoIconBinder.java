package com.facebook.caspian.ui.standardheader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.widget.LazyView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: crowdsourcedName */
public class ProfileVideoIconBinder {
    private static ProfileVideoIconBinder f16531h;
    private static final Object f16532i = new Object();
    public final Resources f16533a;
    @Nullable
    public Drawable f16534b;
    @Nullable
    public AutoRotateDrawable f16535c;
    @Nullable
    public GenericDraweeHierarchy f16536d;
    @Nullable
    public GenericDraweeHierarchy f16537e;
    private final int f16538f = this.f16533a.getDimensionPixelSize(2131427570);
    private final int f16539g = this.f16533a.getDimensionPixelSize(2131427571);

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: crowdsourcedName */
    public @interface IconStyle {
    }

    private static ProfileVideoIconBinder m20598b(InjectorLike injectorLike) {
        return new ProfileVideoIconBinder(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ProfileVideoIconBinder(Resources resources) {
        this.f16533a = resources;
    }

    public final void m20599a(LazyView<FbDraweeView> lazyView, int i) {
        if (i == 0) {
            lazyView.c();
            return;
        }
        ((FbDraweeView) lazyView.a()).setVisibility(0);
        FbDraweeView fbDraweeView;
        GenericDraweeHierarchyBuilder a;
        switch (i) {
            case 1:
                fbDraweeView = (FbDraweeView) lazyView.a();
                if (this.f16536d == null) {
                    a = GenericDraweeHierarchyBuilder.a(this.f16533a);
                    if (this.f16534b == null) {
                        this.f16534b = this.f16533a.getDrawable(2130842786);
                    }
                    a.f = this.f16534b;
                    this.f16536d = a.u();
                }
                fbDraweeView.setHierarchy(this.f16536d);
                ((FbDraweeView) lazyView.a()).setPadding(0, this.f16539g, 0, 0);
                ((FbDraweeView) lazyView.a()).setContentDescription(this.f16533a.getString(2131230850));
                return;
            case 2:
                fbDraweeView = (FbDraweeView) lazyView.a();
                if (this.f16537e == null) {
                    a = GenericDraweeHierarchyBuilder.a(this.f16533a);
                    if (this.f16535c == null) {
                        this.f16535c = new AutoRotateDrawable(this.f16533a.getDrawable(2130840153), 1000);
                    }
                    this.f16537e = a.a(this.f16535c, ScaleType.c).u();
                }
                fbDraweeView.setHierarchy(this.f16537e);
                ((FbDraweeView) lazyView.a()).setPadding(0, this.f16538f, 0, 0);
                ((FbDraweeView) lazyView.a()).setContentDescription(this.f16533a.getString(2131230851));
                return;
            default:
                return;
        }
    }

    public static ProfileVideoIconBinder m20597a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProfileVideoIconBinder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f16532i) {
                ProfileVideoIconBinder profileVideoIconBinder;
                if (a2 != null) {
                    profileVideoIconBinder = (ProfileVideoIconBinder) a2.a(f16532i);
                } else {
                    profileVideoIconBinder = f16531h;
                }
                if (profileVideoIconBinder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20598b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f16532i, b3);
                        } else {
                            f16531h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = profileVideoIconBinder;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
