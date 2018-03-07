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
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;

@ContextScoped
/* compiled from: add_credit_card */
public class ReactionPaginatedVScrollGenericComponentsGapPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitFragment, Void, AnyEnvironment, View> {
    public static final ViewType f19910a = new C21351();
    private static ReactionPaginatedVScrollGenericComponentsGapPartDefinition f19911b;
    private static final Object f19912c = new Object();

    /* compiled from: add_credit_card */
    final class C21351 extends ViewType {
        C21351() {
        }

        public final View m23811a(Context context) {
            return LayoutInflater.from(context).inflate(2130906702, null);
        }
    }

    private static ReactionPaginatedVScrollGenericComponentsGapPartDefinition m23813c() {
        return new ReactionPaginatedVScrollGenericComponentsGapPartDefinition();
    }

    public final ViewType m23814a() {
        return f19910a;
    }

    public final boolean m23815a(Object obj) {
        return true;
    }

    public static ReactionPaginatedVScrollGenericComponentsGapPartDefinition m23812a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPaginatedVScrollGenericComponentsGapPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19912c) {
                ReactionPaginatedVScrollGenericComponentsGapPartDefinition reactionPaginatedVScrollGenericComponentsGapPartDefinition;
                if (a2 != null) {
                    reactionPaginatedVScrollGenericComponentsGapPartDefinition = (ReactionPaginatedVScrollGenericComponentsGapPartDefinition) a2.a(f19912c);
                } else {
                    reactionPaginatedVScrollGenericComponentsGapPartDefinition = f19911b;
                }
                if (reactionPaginatedVScrollGenericComponentsGapPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m23813c();
                        if (a2 != null) {
                            a2.a(f19912c, c);
                        } else {
                            f19911b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = reactionPaginatedVScrollGenericComponentsGapPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
