package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: isv */
public class HScrollRecycledViewPool extends RecycledViewPool {
    private static HScrollRecycledViewPool f18744a;
    private static final Object f18745b = new Object();

    private static HScrollRecycledViewPool m26351c() {
        return new HScrollRecycledViewPool();
    }

    public static HScrollRecycledViewPool m26350a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HScrollRecycledViewPool c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18745b) {
                HScrollRecycledViewPool hScrollRecycledViewPool;
                if (a2 != null) {
                    hScrollRecycledViewPool = (HScrollRecycledViewPool) a2.mo818a(f18745b);
                } else {
                    hScrollRecycledViewPool = f18744a;
                }
                if (hScrollRecycledViewPool == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        c = m26351c();
                        if (a2 != null) {
                            a2.mo822a(f18745b, c);
                        } else {
                            f18744a = c;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    c = hScrollRecycledViewPool;
                }
            }
            return c;
        } finally {
            a.m1505c(b);
        }
    }
}
