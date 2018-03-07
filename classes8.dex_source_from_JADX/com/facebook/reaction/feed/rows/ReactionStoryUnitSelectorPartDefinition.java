package com.facebook.reaction.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.environment.HasReactionCardContainer;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: arg */
public class ReactionStoryUnitSelectorPartDefinition<E extends HasContext & HasReactionCardContainer & HasReactionInteractionTracker> extends BaseMultiRowGroupPartDefinition<ReactionCardNode, Void, E> {
    private static ReactionStoryUnitSelectorPartDefinition f19313c;
    private static final Object f19314d = new Object();
    private final ReactionCollapsableStoryUnitGroupPartDefinition f19315a;
    private final ReactionStoryUnitGroupPartDefinition f19316b;

    private static ReactionStoryUnitSelectorPartDefinition m23314b(InjectorLike injectorLike) {
        return new ReactionStoryUnitSelectorPartDefinition(ReactionCollapsableStoryUnitGroupPartDefinition.m23213a(injectorLike), ReactionStoryUnitGroupPartDefinition.m23309a(injectorLike));
    }

    public final Object m23315a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        if (reactionCardNode.mo1117k().c() == GraphQLReactionUnitCollapseState.NOT_COLLAPSIBLE) {
            baseMultiRowSubParts.a(this.f19316b, reactionCardNode);
        } else {
            baseMultiRowSubParts.a(this.f19315a, reactionCardNode);
        }
        return null;
    }

    public final boolean m23316a(Object obj) {
        ReactionUnitFragment k = ((ReactionCardNode) obj).mo1117k();
        return (Strings.isNullOrEmpty(k.d()) || Strings.isNullOrEmpty(k.n())) ? false : true;
    }

    @Inject
    public ReactionStoryUnitSelectorPartDefinition(ReactionCollapsableStoryUnitGroupPartDefinition reactionCollapsableStoryUnitGroupPartDefinition, ReactionStoryUnitGroupPartDefinition reactionStoryUnitGroupPartDefinition) {
        this.f19315a = reactionCollapsableStoryUnitGroupPartDefinition;
        this.f19316b = reactionStoryUnitGroupPartDefinition;
    }

    public static ReactionStoryUnitSelectorPartDefinition m23313a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionStoryUnitSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19314d) {
                ReactionStoryUnitSelectorPartDefinition reactionStoryUnitSelectorPartDefinition;
                if (a2 != null) {
                    reactionStoryUnitSelectorPartDefinition = (ReactionStoryUnitSelectorPartDefinition) a2.a(f19314d);
                } else {
                    reactionStoryUnitSelectorPartDefinition = f19313c;
                }
                if (reactionStoryUnitSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23314b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19314d, b3);
                        } else {
                            f19313c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionStoryUnitSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
