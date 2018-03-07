package com.facebook.feed.rows.sections.common;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: message_sender */
public class EmptyPartDefinition extends MultiRowSinglePartDefinition<Object, Void, AnyEnvironment, View> {
    public static final ViewType f10393a = new C06271();
    private static EmptyPartDefinition f10394b;
    private static final Object f10395c = new Object();

    /* compiled from: message_sender */
    final class C06271 extends ViewType {
        C06271() {
        }

        public final View m16565a(Context context) {
            return new View(context);
        }
    }

    private static EmptyPartDefinition m16567b() {
        return new EmptyPartDefinition();
    }

    public final ViewType m16568a() {
        return f10393a;
    }

    public final boolean m16569a(Object obj) {
        return true;
    }

    public static EmptyPartDefinition m16566a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EmptyPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10395c) {
                EmptyPartDefinition emptyPartDefinition;
                if (a2 != null) {
                    emptyPartDefinition = (EmptyPartDefinition) a2.a(f10395c);
                } else {
                    emptyPartDefinition = f10394b;
                }
                if (emptyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m16567b();
                        if (a2 != null) {
                            a2.a(f10395c, b3);
                        } else {
                            f10394b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = emptyPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
