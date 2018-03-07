package com.facebook.reaction.feed.unitcomponents.partdefinition;

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
/* compiled from: adjustViewBounds */
public class ReactionInfoRowDividerPartDefinition<P> extends MultiRowSinglePartDefinition<P, Void, AnyEnvironment, View> {
    public static final ViewType f19857a = new C21321();
    private static ReactionInfoRowDividerPartDefinition f19858b;
    private static final Object f19859c = new Object();

    /* compiled from: adjustViewBounds */
    final class C21321 extends ViewType {
        C21321() {
        }

        public final View m23762a(Context context) {
            return LayoutInflater.from(context).inflate(2130906642, null);
        }
    }

    private static ReactionInfoRowDividerPartDefinition m23764b() {
        return new ReactionInfoRowDividerPartDefinition();
    }

    public final boolean m23766a(P p) {
        return true;
    }

    public final ViewType m23765a() {
        return f19857a;
    }

    public static ReactionInfoRowDividerPartDefinition m23763a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionInfoRowDividerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19859c) {
                ReactionInfoRowDividerPartDefinition reactionInfoRowDividerPartDefinition;
                if (a2 != null) {
                    reactionInfoRowDividerPartDefinition = (ReactionInfoRowDividerPartDefinition) a2.a(f19859c);
                } else {
                    reactionInfoRowDividerPartDefinition = f19858b;
                }
                if (reactionInfoRowDividerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m23764b();
                        if (a2 != null) {
                            a2.a(f19859c, b3);
                        } else {
                            f19858b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionInfoRowDividerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
