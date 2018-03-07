package com.facebook.feedplugins.links;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: fetch_sticker_packs */
public class DefaultLinkedViewAdapter implements LinkedViewAdapter {
    private static DefaultLinkedViewAdapter f23936a;
    private static final Object f23937b = new Object();

    private static DefaultLinkedViewAdapter m32315a() {
        return new DefaultLinkedViewAdapter();
    }

    public final View mo3509a(View view) {
        return view;
    }

    public static DefaultLinkedViewAdapter m32316a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultLinkedViewAdapter a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f23937b) {
                DefaultLinkedViewAdapter defaultLinkedViewAdapter;
                if (a3 != null) {
                    defaultLinkedViewAdapter = (DefaultLinkedViewAdapter) a3.mo818a(f23937b);
                } else {
                    defaultLinkedViewAdapter = f23936a;
                }
                if (defaultLinkedViewAdapter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m32315a();
                        if (a3 != null) {
                            a3.mo822a(f23937b, a2);
                        } else {
                            f23936a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = defaultLinkedViewAdapter;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
