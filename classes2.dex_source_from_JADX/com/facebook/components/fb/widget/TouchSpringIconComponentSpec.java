package com.facebook.components.fb.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.Size;
import com.facebook.components.SizeSpec;
import com.facebook.components.annotations.MountSpec;
import com.facebook.components.reference.Reference;
import com.facebook.components.utils.MeasureUtils;
import com.facebook.components.utils.MeasureUtils.MeasureException;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.springs.Spring;
import com.facebook.widget.springbutton.SpringFactory;
import javax.inject.Inject;

@MountSpec
@ContextScoped
/* compiled from: ig_pff_invalidation */
public class TouchSpringIconComponentSpec<E extends HasPersistentState> {
    private static TouchSpringIconComponentSpec f20573b;
    private static final Object f20574c = new Object();
    public final SpringFactory f20575a;

    private static TouchSpringIconComponentSpec m28318b(InjectorLike injectorLike) {
        return new TouchSpringIconComponentSpec(SpringFactory.m28319a(injectorLike));
    }

    @Inject
    public TouchSpringIconComponentSpec(SpringFactory springFactory) {
        this.f20575a = springFactory;
    }

    public static TouchSpringIconComponentSpec m28315a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TouchSpringIconComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20574c) {
                TouchSpringIconComponentSpec touchSpringIconComponentSpec;
                if (a2 != null) {
                    touchSpringIconComponentSpec = (TouchSpringIconComponentSpec) a2.mo818a(f20574c);
                } else {
                    touchSpringIconComponentSpec = f20573b;
                }
                if (touchSpringIconComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28318b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20574c, b3);
                        } else {
                            f20573b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = touchSpringIconComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected static void m28317a(ComponentContext componentContext, int i, int i2, Size size, Reference<Drawable> reference) {
        if (reference == null) {
            size.f22987a = 0;
            size.f22988b = 0;
            return;
        }
        Drawable drawable = (Drawable) Reference.m30531a(componentContext, (Reference) reference);
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                size.f22987a = 0;
                size.f22988b = 0;
                return;
            }
            int i3 = intrinsicWidth * 2;
            int i4 = intrinsicHeight * 2;
            if (SizeSpec.m30704a(i) == 0 && SizeSpec.m30704a(i2) == 0) {
                size.f22987a = i3;
                size.f22988b = i4;
                Reference.m30532a(componentContext, drawable, reference);
                return;
            }
            try {
                MeasureUtils.m31106a(i, i2, ((float) intrinsicWidth) / ((float) intrinsicHeight), size);
            } catch (MeasureException e) {
                size.f22987a = i3;
                size.f22988b = i4;
            }
            Reference.m30532a(componentContext, drawable, reference);
        } finally {
            Reference.m30532a(componentContext, drawable, reference);
        }
    }

    protected static TouchSpringIconDrawable m28316a(ComponentContext componentContext, TouchSpringIconDrawable touchSpringIconDrawable, Reference<Drawable> reference, Spring spring) {
        if (touchSpringIconDrawable == null) {
            touchSpringIconDrawable = new TouchSpringIconDrawable();
        }
        touchSpringIconDrawable.a((Drawable) Reference.m30531a(componentContext, (Reference) reference), spring);
        return touchSpringIconDrawable;
    }
}
