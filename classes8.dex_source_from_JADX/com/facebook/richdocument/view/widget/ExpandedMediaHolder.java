package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.view.transition.state.MediaStateMachine;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import java.lang.ref.WeakReference;

@ContextScoped
/* compiled from: open_local_search_tap */
public class ExpandedMediaHolder implements MediaStateMachine {
    private static ExpandedMediaHolder f7162b;
    private static final Object f7163c = new Object();
    private WeakReference<View> f7164a;

    private static ExpandedMediaHolder m7439b() {
        return new ExpandedMediaHolder();
    }

    public final View m7440a() {
        return this.f7164a == null ? null : (View) this.f7164a.get();
    }

    public final void m7441a(View view) {
        if (view == null) {
            this.f7164a = null;
        } else {
            this.f7164a = new WeakReference(view);
        }
    }

    public final boolean mo447a(Event event) {
        View a = m7440a();
        if (a instanceof MediaStateMachine) {
            return ((MediaStateMachine) a).mo447a(event);
        }
        return false;
    }

    public static ExpandedMediaHolder m7438a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ExpandedMediaHolder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7163c) {
                ExpandedMediaHolder expandedMediaHolder;
                if (a2 != null) {
                    expandedMediaHolder = (ExpandedMediaHolder) a2.a(f7163c);
                } else {
                    expandedMediaHolder = f7162b;
                }
                if (expandedMediaHolder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m7439b();
                        if (a2 != null) {
                            a2.a(f7163c, b3);
                        } else {
                            f7162b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = expandedMediaHolder;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
