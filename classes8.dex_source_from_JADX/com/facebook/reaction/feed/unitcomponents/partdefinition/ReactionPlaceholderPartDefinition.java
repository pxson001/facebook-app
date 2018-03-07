package com.facebook.reaction.feed.unitcomponents.partdefinition;

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
/* compiled from: activity_instantiated */
public class ReactionPlaceholderPartDefinition extends MultiRowSinglePartDefinition<Object, Void, AnyEnvironment, View> {
    public static final ViewType f19991a = new C21391();
    private static ReactionPlaceholderPartDefinition f19992b;
    private static final Object f19993c = new Object();

    /* compiled from: activity_instantiated */
    final class C21391 extends ViewType {
        C21391() {
        }

        public final View m23883a(Context context) {
            return new View(context);
        }
    }

    private static ReactionPlaceholderPartDefinition m23885b() {
        return new ReactionPlaceholderPartDefinition();
    }

    public final ViewType m23886a() {
        return f19991a;
    }

    public final boolean m23887a(Object obj) {
        return true;
    }

    public static ReactionPlaceholderPartDefinition m23884a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPlaceholderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19993c) {
                ReactionPlaceholderPartDefinition reactionPlaceholderPartDefinition;
                if (a2 != null) {
                    reactionPlaceholderPartDefinition = (ReactionPlaceholderPartDefinition) a2.a(f19993c);
                } else {
                    reactionPlaceholderPartDefinition = f19992b;
                }
                if (reactionPlaceholderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m23885b();
                        if (a2 != null) {
                            a2.a(f19993c, b3);
                        } else {
                            f19992b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPlaceholderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
