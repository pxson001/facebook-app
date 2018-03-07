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
/* compiled from: accountRecoveryValidateCodeParamsKey */
public class ReactionVerticalComponentsGapPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitFragment, Void, AnyEnvironment, View> {
    public static final ViewType f20116a = new C21511();
    private static ReactionVerticalComponentsGapPartDefinition f20117b;
    private static final Object f20118c = new Object();

    /* compiled from: accountRecoveryValidateCodeParamsKey */
    final class C21511 extends ViewType {
        C21511() {
        }

        public final View m24006a(Context context) {
            return LayoutInflater.from(context).inflate(2130906653, null);
        }
    }

    private static ReactionVerticalComponentsGapPartDefinition m24008c() {
        return new ReactionVerticalComponentsGapPartDefinition();
    }

    public final ViewType m24009a() {
        return f20116a;
    }

    public final boolean m24010a(Object obj) {
        return true;
    }

    public static ReactionVerticalComponentsGapPartDefinition m24007a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionVerticalComponentsGapPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20118c) {
                ReactionVerticalComponentsGapPartDefinition reactionVerticalComponentsGapPartDefinition;
                if (a2 != null) {
                    reactionVerticalComponentsGapPartDefinition = (ReactionVerticalComponentsGapPartDefinition) a2.a(f20118c);
                } else {
                    reactionVerticalComponentsGapPartDefinition = f20117b;
                }
                if (reactionVerticalComponentsGapPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m24008c();
                        if (a2 != null) {
                            a2.a(f20118c, c);
                        } else {
                            f20117b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = reactionVerticalComponentsGapPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
