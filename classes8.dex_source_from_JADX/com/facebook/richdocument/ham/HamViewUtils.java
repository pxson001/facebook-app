package com.facebook.richdocument.ham;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: placeholderColor */
public class HamViewUtils {
    private static HamViewUtils f5312b;
    private static final Object f5313c = new Object();
    private final HamDimensions f5314a;

    private static HamViewUtils m5279b(InjectorLike injectorLike) {
        return new HamViewUtils(HamDimensions.m5268a(injectorLike));
    }

    @Inject
    public HamViewUtils(HamDimensions hamDimensions) {
        this.f5314a = hamDimensions;
    }

    public final void m5281a(View view, int i, int i2, int i3, int i4) {
        view.setPadding(this.f5314a.m5276b(i), this.f5314a.m5276b(i2), this.f5314a.m5276b(i3), this.f5314a.m5276b(i4));
    }

    public final void m5282b(View view, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT > 17) {
            view.setPaddingRelative(this.f5314a.m5276b(i), this.f5314a.m5276b(i2), this.f5314a.m5276b(i3), this.f5314a.m5276b(i4));
        } else {
            m5281a(view, i, i2, i3, i4);
        }
    }

    public final void m5280a(@Nullable final View view, final int i, final int i2) {
        if (view != null) {
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                view.post(new Runnable(this) {
                    final /* synthetic */ HamViewUtils f5305d;

                    public void run() {
                        this.f5305d.m5280a(view, i, i2);
                    }
                });
                return;
            }
            if (i != 0) {
                layoutParams.width = this.f5314a.m5276b(i);
            }
            if (i2 != 0) {
                layoutParams.height = this.f5314a.m5276b(i2);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static HamViewUtils m5278a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HamViewUtils b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5313c) {
                HamViewUtils hamViewUtils;
                if (a2 != null) {
                    hamViewUtils = (HamViewUtils) a2.a(f5313c);
                } else {
                    hamViewUtils = f5312b;
                }
                if (hamViewUtils == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5279b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5313c, b3);
                        } else {
                            f5312b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = hamViewUtils;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m5283c(View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() == null) {
            final View view2 = view;
            final int i5 = i;
            final int i6 = i2;
            final int i7 = i3;
            final int i8 = i4;
            view.post(new Runnable(this) {
                final /* synthetic */ HamViewUtils f5311f;

                public void run() {
                    this.f5311f.m5283c(view2, i5, i6, i7, i8);
                }
            });
        } else if (view.getLayoutParams() instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(this.f5314a.m5276b(i), this.f5314a.m5276b(i2), this.f5314a.m5276b(i3), this.f5314a.m5276b(i4));
            if (VERSION.SDK_INT >= 17) {
                marginLayoutParams.setMarginStart(this.f5314a.m5276b(i));
                marginLayoutParams.setMarginEnd(this.f5314a.m5276b(i3));
            }
        }
    }
}
