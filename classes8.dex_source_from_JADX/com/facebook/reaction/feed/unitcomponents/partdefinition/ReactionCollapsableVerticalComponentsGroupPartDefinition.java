package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.enums.GraphQLReactionUnitCollapseState;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitKey;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitPersistentState;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: all_participants */
public class ReactionCollapsableVerticalComponentsGroupPartDefinition<E extends HasPersistentState> extends BaseMultiRowGroupPartDefinition<ReactionUnitFragment, Void, E> {
    private static ReactionCollapsableVerticalComponentsGroupPartDefinition f19593e;
    private static final Object f19594f = new Object();
    private final ReactionVerticalComponentsWithoutHeaderGroupPartDefinition f19595a;
    private final ReactionVerticalComponentsGapPartDefinition f19596b;
    private final ReactionCollapsableIconMessageUnitComponentSelector f19597c;
    private final ReactionUnitValidator f19598d;

    private static ReactionCollapsableVerticalComponentsGroupPartDefinition m23527b(InjectorLike injectorLike) {
        return new ReactionCollapsableVerticalComponentsGroupPartDefinition(ReactionVerticalComponentsWithoutHeaderGroupPartDefinition.m24024a(injectorLike), ReactionVerticalComponentsGapPartDefinition.m24007a(injectorLike), ReactionCollapsableIconMessageUnitComponentSelector.m23513a(injectorLike), ReactionUnitValidator.m22908b(injectorLike));
    }

    public final Object m23528a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        boolean z = false;
        GraphQLReactionUnitComponentStyle a = ((ReactionUnitComponentModel) reactionUnitFragment.s().get(0)).a();
        ReactionUnitComponentNode b = m23526b(reactionUnitFragment);
        if (ReactionVerticalComponentsNoBottomGapGroupPartDefinition.m24016a(a)) {
            baseMultiRowSubParts.a(this.f19596b, reactionUnitFragment);
        }
        baseMultiRowSubParts.a(this.f19597c, b);
        ReactionCollapsableUnitPersistentState reactionCollapsableUnitPersistentState = (ReactionCollapsableUnitPersistentState) hasPersistentState.a(new ReactionCollapsableUnitKey(reactionUnitFragment.d()), b);
        if (!reactionCollapsableUnitPersistentState.f19161b) {
            if (reactionUnitFragment.c() == GraphQLReactionUnitCollapseState.COLLAPSED) {
                z = true;
            }
            reactionCollapsableUnitPersistentState.m23182a(z);
        }
        if (!reactionCollapsableUnitPersistentState.f19160a) {
            baseMultiRowSubParts.a(this.f19595a, reactionUnitFragment);
        }
        baseMultiRowSubParts.a(this.f19596b, reactionUnitFragment);
        return null;
    }

    public final boolean m23529a(Object obj) {
        ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) obj;
        return "SUCCESS".equals(this.f19598d.m22916a((Object) reactionUnitFragment)) && ReactionCollapsableIconMessageUnitComponentSelector.m23514a(m23526b(reactionUnitFragment));
    }

    @Inject
    public ReactionCollapsableVerticalComponentsGroupPartDefinition(ReactionVerticalComponentsWithoutHeaderGroupPartDefinition reactionVerticalComponentsWithoutHeaderGroupPartDefinition, ReactionVerticalComponentsGapPartDefinition reactionVerticalComponentsGapPartDefinition, ReactionCollapsableIconMessageUnitComponentSelector reactionCollapsableIconMessageUnitComponentSelector, ReactionUnitValidator reactionUnitValidator) {
        this.f19595a = reactionVerticalComponentsWithoutHeaderGroupPartDefinition;
        this.f19596b = reactionVerticalComponentsGapPartDefinition;
        this.f19597c = reactionCollapsableIconMessageUnitComponentSelector;
        this.f19598d = reactionUnitValidator;
    }

    public static ReactionCollapsableVerticalComponentsGroupPartDefinition m23525a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCollapsableVerticalComponentsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19594f) {
                ReactionCollapsableVerticalComponentsGroupPartDefinition reactionCollapsableVerticalComponentsGroupPartDefinition;
                if (a2 != null) {
                    reactionCollapsableVerticalComponentsGroupPartDefinition = (ReactionCollapsableVerticalComponentsGroupPartDefinition) a2.a(f19594f);
                } else {
                    reactionCollapsableVerticalComponentsGroupPartDefinition = f19593e;
                }
                if (reactionCollapsableVerticalComponentsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23527b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19594f, b3);
                        } else {
                            f19593e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCollapsableVerticalComponentsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static ReactionUnitComponentNode m23526b(ReactionUnitFragment reactionUnitFragment) {
        return new ReactionUnitComponentNode((ReactionUnitComponentModel) reactionUnitFragment.s().get(0), reactionUnitFragment.d(), reactionUnitFragment.n(), reactionUnitFragment.j());
    }
}
