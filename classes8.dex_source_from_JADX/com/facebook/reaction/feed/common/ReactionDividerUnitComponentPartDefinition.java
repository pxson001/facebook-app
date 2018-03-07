package com.facebook.reaction.feed.common;

import android.content.Context;
import android.view.LayoutInflater;
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
/* compiled from: bellerophon_select */
public class ReactionDividerUnitComponentPartDefinition<P> extends MultiRowSinglePartDefinition<P, Void, AnyEnvironment, View> {
    public static final ViewType f18971a = new C20821();
    private static ReactionDividerUnitComponentPartDefinition f18972b;
    private static final Object f18973c = new Object();

    /* compiled from: bellerophon_select */
    final class C20821 extends ViewType {
        C20821() {
        }

        public final View m22996a(Context context) {
            return LayoutInflater.from(context).inflate(2130906661, null);
        }
    }

    private static ReactionDividerUnitComponentPartDefinition m22998b() {
        return new ReactionDividerUnitComponentPartDefinition();
    }

    public final boolean m23000a(P p) {
        return true;
    }

    public final ViewType m22999a() {
        return f18971a;
    }

    public static ReactionDividerUnitComponentPartDefinition m22997a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionDividerUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18973c) {
                ReactionDividerUnitComponentPartDefinition reactionDividerUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionDividerUnitComponentPartDefinition = (ReactionDividerUnitComponentPartDefinition) a2.a(f18973c);
                } else {
                    reactionDividerUnitComponentPartDefinition = f18972b;
                }
                if (reactionDividerUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m22998b();
                        if (a2 != null) {
                            a2.a(f18973c, b3);
                        } else {
                            f18972b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionDividerUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
