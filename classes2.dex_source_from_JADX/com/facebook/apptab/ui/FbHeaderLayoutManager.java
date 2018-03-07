package com.facebook.apptab.ui;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;

@ContextScoped
/* compiled from: string_ */
public class FbHeaderLayoutManager {
    private static FbHeaderLayoutManager f3983b;
    private static final Object f3984c = new Object();
    private WeakReference<View> f3985a;

    private static FbHeaderLayoutManager m6587a() {
        return new FbHeaderLayoutManager();
    }

    public final void m6590a(View view) {
        this.f3985a = new WeakReference(view);
    }

    public final int m6589a(int i) {
        boolean z = true;
        int size = MeasureSpec.getSize(i);
        Preconditions.checkState(MeasureSpec.getMode(i) == Integer.MIN_VALUE, "Parent is not laying us out with wrap_content so we can't infer the correct height to request without drawing over the title bar!");
        View view = (View) this.f3985a.get();
        if (view == null) {
            z = false;
        }
        Preconditions.checkState(z, "Header is now null.  Was it garbage collected?");
        return view.getVisibility() == 8 ? i : MeasureSpec.makeMeasureSpec(size - view.getMeasuredHeight(), Integer.MIN_VALUE);
    }

    public static FbHeaderLayoutManager m6588a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FbHeaderLayoutManager a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f3984c) {
                FbHeaderLayoutManager fbHeaderLayoutManager;
                if (a3 != null) {
                    fbHeaderLayoutManager = (FbHeaderLayoutManager) a3.mo818a(f3984c);
                } else {
                    fbHeaderLayoutManager = f3983b;
                }
                if (fbHeaderLayoutManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m6587a();
                        if (a3 != null) {
                            a3.mo822a(f3984c, a2);
                        } else {
                            f3983b = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = fbHeaderLayoutManager;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
