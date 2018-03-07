package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLReactionUnitCollapseState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accountRecoverySendCodeParamsKey */
public class ReactionVerticalComponentsSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitFragment, Void, AnyEnvironment> {
    private static ReactionVerticalComponentsSelectorPartDefinition f20131c;
    private static final Object f20132d = new Object();
    private final ReactionCollapsableVerticalComponentsGroupPartDefinition f20133a;
    private final ReactionVerticalComponentsGroupPartDefinition f20134b;

    private static ReactionVerticalComponentsSelectorPartDefinition m24021b(InjectorLike injectorLike) {
        return new ReactionVerticalComponentsSelectorPartDefinition(ReactionCollapsableVerticalComponentsGroupPartDefinition.m23525a(injectorLike), ReactionVerticalComponentsGroupPartDefinition.m24011a(injectorLike));
    }

    public final Object m24022a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) obj;
        if (reactionUnitFragment.c() == GraphQLReactionUnitCollapseState.NOT_COLLAPSIBLE) {
            baseMultiRowSubParts.a(this.f20134b, reactionUnitFragment);
        } else {
            baseMultiRowSubParts.a(this.f20133a, reactionUnitFragment);
        }
        return null;
    }

    @Inject
    public ReactionVerticalComponentsSelectorPartDefinition(ReactionCollapsableVerticalComponentsGroupPartDefinition reactionCollapsableVerticalComponentsGroupPartDefinition, ReactionVerticalComponentsGroupPartDefinition reactionVerticalComponentsGroupPartDefinition) {
        this.f20133a = reactionCollapsableVerticalComponentsGroupPartDefinition;
        this.f20134b = reactionVerticalComponentsGroupPartDefinition;
    }

    public final boolean m24023a(Object obj) {
        return true;
    }

    public static ReactionVerticalComponentsSelectorPartDefinition m24020a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionVerticalComponentsSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20132d) {
                ReactionVerticalComponentsSelectorPartDefinition reactionVerticalComponentsSelectorPartDefinition;
                if (a2 != null) {
                    reactionVerticalComponentsSelectorPartDefinition = (ReactionVerticalComponentsSelectorPartDefinition) a2.a(f20132d);
                } else {
                    reactionVerticalComponentsSelectorPartDefinition = f20131c;
                }
                if (reactionVerticalComponentsSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24021b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20132d, b3);
                        } else {
                            f20131c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionVerticalComponentsSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
