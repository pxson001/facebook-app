package com.facebook.common.ui.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
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
/* compiled from: rtc_group_calling_button */
public class SoftInputDetector {
    private static final Rect f6446a = new Rect();
    private static SoftInputDetector f6447h;
    private static final Object f6448i = new Object();
    private final int f6449b;
    private int f6450c;
    private boolean f6451d;
    public int f6452e;
    public boolean f6453f;
    private int f6454g;

    private static SoftInputDetector m11175b(InjectorLike injectorLike) {
        return new SoftInputDetector(ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public SoftInputDetector(Resources resources) {
        this.f6454g = resources.getConfiguration().orientation;
        this.f6449b = resources.getDimensionPixelSize(2131427587);
        m11174a(resources);
    }

    public static SoftInputDetector m11173a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SoftInputDetector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f6448i) {
                SoftInputDetector softInputDetector;
                if (a2 != null) {
                    softInputDetector = (SoftInputDetector) a2.mo818a(f6448i);
                } else {
                    softInputDetector = f6447h;
                }
                if (softInputDetector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m11175b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f6448i, b3);
                        } else {
                            f6447h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = softInputDetector;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void m11176a(View view, int i) {
        boolean z = true;
        Resources resources = view.getResources();
        int i2 = resources.getConfiguration().orientation;
        if (i2 != this.f6454g) {
            this.f6454g = i2;
            m11174a(resources);
        }
        i2 = MeasureSpec.getSize(i);
        if (i2 != this.f6450c || this.f6451d) {
            view.getWindowVisibleDisplayFrame(f6446a);
            if (f6446a.bottom > 0) {
                this.f6450c = i2;
                this.f6451d = i2 > f6446a.height();
                i2 = resources.getDisplayMetrics().heightPixels - f6446a.bottom;
                if (i2 <= this.f6449b) {
                    z = false;
                }
                this.f6453f = z;
                if (this.f6453f) {
                    this.f6452e = i2;
                    return;
                }
                return;
            }
            this.f6453f = false;
        }
    }

    private void m11174a(Resources resources) {
        this.f6452e = resources.getDimensionPixelSize(2131427590);
    }
}
