package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
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
import com.facebook.reaction.feed.persistentstate.ReactionExpandableComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionExpandableComponentPersistentState;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: alert dialog cancel button */
public class ReactionExpandableUnitComponentGroupPartDefinition<E extends HasContext & HasInvalidate & HasPersistentState> extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, E> {
    private static ReactionExpandableUnitComponentGroupPartDefinition f19652c;
    private static final Object f19653d = new Object();
    private final ReactionExpandableUnitComponentCollapsedPartDefinition f19654a;
    private final ReactionExpandableUnitComponentExpandedPartDefinition f19655b;

    private static ReactionExpandableUnitComponentGroupPartDefinition m23580b(InjectorLike injectorLike) {
        return new ReactionExpandableUnitComponentGroupPartDefinition(ReactionExpandableUnitComponentCollapsedPartDefinition.m23568a(injectorLike), ReactionExpandableUnitComponentExpandedPartDefinition.m23573a(injectorLike));
    }

    public final Object m23581a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionExpandableComponentPersistentState reactionExpandableComponentPersistentState = (ReactionExpandableComponentPersistentState) ((HasPersistentState) ((HasContext) anyEnvironment)).a(new ReactionExpandableComponentKey(reactionUnitComponentNode.f18863c), reactionUnitComponentNode);
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        if (reactionUnitComponentFields instanceof ReactionUnitComponentModel) {
            boolean z;
            if (((ReactionUnitComponentModel) reactionUnitComponentFields).dm().cF().size() > 1) {
                z = true;
            } else {
                z = false;
            }
            reactionExpandableComponentPersistentState.f19168b = z;
        }
        if (reactionExpandableComponentPersistentState.f19167a) {
            baseMultiRowSubParts.a(this.f19655b, reactionUnitComponentNode);
        } else {
            baseMultiRowSubParts.a(this.f19654a, reactionUnitComponentNode);
        }
        return null;
    }

    public final boolean m23582a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return ReactionExpandableUnitComponentCollapsedPartDefinition.m23569a(reactionUnitComponentNode) && ReactionExpandableUnitComponentExpandedPartDefinition.m23575a(reactionUnitComponentNode);
    }

    @Inject
    public ReactionExpandableUnitComponentGroupPartDefinition(ReactionExpandableUnitComponentCollapsedPartDefinition reactionExpandableUnitComponentCollapsedPartDefinition, ReactionExpandableUnitComponentExpandedPartDefinition reactionExpandableUnitComponentExpandedPartDefinition) {
        this.f19654a = reactionExpandableUnitComponentCollapsedPartDefinition;
        this.f19655b = reactionExpandableUnitComponentExpandedPartDefinition;
    }

    public static ReactionExpandableUnitComponentGroupPartDefinition m23579a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionExpandableUnitComponentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19653d) {
                ReactionExpandableUnitComponentGroupPartDefinition reactionExpandableUnitComponentGroupPartDefinition;
                if (a2 != null) {
                    reactionExpandableUnitComponentGroupPartDefinition = (ReactionExpandableUnitComponentGroupPartDefinition) a2.a(f19653d);
                } else {
                    reactionExpandableUnitComponentGroupPartDefinition = f19652c;
                }
                if (reactionExpandableUnitComponentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23580b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19653d, b3);
                        } else {
                            f19652c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionExpandableUnitComponentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
