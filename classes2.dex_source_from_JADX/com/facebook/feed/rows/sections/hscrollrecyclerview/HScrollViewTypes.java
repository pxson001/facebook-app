package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.recyclablepager.PagerViewType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: is_work_user */
public class HScrollViewTypes {
    private static HScrollViewTypes f18746e;
    private static final Object f18747f = new Object();
    public final List<PagerViewType> f18748a = new ArrayList();
    public final HashMap<Class, Integer> f18749b = new HashMap();
    private final HashMap<Class, Integer> f18750c = new HashMap();
    public final HScrollRecycledViewPool f18751d;

    private static HScrollViewTypes m26353b(InjectorLike injectorLike) {
        return new HScrollViewTypes(HScrollRecycledViewPool.m26350a(injectorLike));
    }

    @Inject
    public HScrollViewTypes(HScrollRecycledViewPool hScrollRecycledViewPool) {
        this.f18751d = hScrollRecycledViewPool;
    }

    public final PagerViewType m26355a(int i) {
        return (PagerViewType) this.f18748a.get(i);
    }

    public final void m26356b(PagerViewType pagerViewType) {
        this.f18750c.put(pagerViewType.a(), Integer.valueOf(m26354d(pagerViewType) + 1));
    }

    public final boolean m26357c(PagerViewType pagerViewType) {
        return m26354d(pagerViewType) < 2;
    }

    private int m26354d(PagerViewType pagerViewType) {
        Class a = pagerViewType.a();
        return this.f18750c.containsKey(a) ? ((Integer) this.f18750c.get(a)).intValue() : 0;
    }

    public static HScrollViewTypes m26352a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HScrollViewTypes b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18747f) {
                HScrollViewTypes hScrollViewTypes;
                if (a2 != null) {
                    hScrollViewTypes = (HScrollViewTypes) a2.mo818a(f18747f);
                } else {
                    hScrollViewTypes = f18746e;
                }
                if (hScrollViewTypes == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26353b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18747f, b3);
                        } else {
                            f18746e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = hScrollViewTypes;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
