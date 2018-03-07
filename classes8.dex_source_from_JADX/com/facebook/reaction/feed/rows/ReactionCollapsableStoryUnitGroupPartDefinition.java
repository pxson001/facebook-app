package com.facebook.reaction.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
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
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitKey;
import com.facebook.reaction.feed.persistentstate.ReactionCollapsableUnitPersistentState;
import com.facebook.reaction.feed.rows.attachments.ReactionAttachmentsGroupPartDefinition;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: article_info */
public class ReactionCollapsableStoryUnitGroupPartDefinition<E extends HasContext & HasReactionCardContainer & HasReactionInteractionTracker & HasPersistentState> extends BaseMultiRowGroupPartDefinition<ReactionCardNode, Void, E> {
    private static ReactionCollapsableStoryUnitGroupPartDefinition f19198f;
    private static final Object f19199g = new Object();
    private final ReactionAttachmentsGroupPartDefinition<E> f19200a;
    private final ReactionStoryBottomWithMarginPartDefinition f19201b;
    private final ReactionStoryFooterSelectorPartDefinition f19202c;
    private final ReactionCollapsableStoryIconHeaderPartDefinition f19203d;
    private final ReactionStoryTopWithMarginPartDefinition f19204e;

    private static ReactionCollapsableStoryUnitGroupPartDefinition m23214b(InjectorLike injectorLike) {
        return new ReactionCollapsableStoryUnitGroupPartDefinition(ReactionAttachmentsGroupPartDefinition.m23337a(injectorLike), ReactionStoryBottomWithMarginPartDefinition.m23292a(injectorLike), ReactionStoryFooterSelectorPartDefinition.m23296a(injectorLike), ReactionCollapsableStoryIconHeaderPartDefinition.m23206a(injectorLike), ReactionStoryTopWithMarginPartDefinition.m23305a(injectorLike));
    }

    public final Object m23215a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        baseMultiRowSubParts.a(this.f19204e, null);
        baseMultiRowSubParts.a(this.f19203d, reactionCardNode);
        ReactionCollapsableUnitPersistentState reactionCollapsableUnitPersistentState = (ReactionCollapsableUnitPersistentState) ((HasPersistentState) hasContext).a(new ReactionCollapsableUnitKey(reactionCardNode.mo1117k().d()), reactionCardNode);
        if (!reactionCollapsableUnitPersistentState.f19161b) {
            reactionCollapsableUnitPersistentState.m23182a(reactionCardNode.mo1117k().c() == GraphQLReactionUnitCollapseState.COLLAPSED);
        }
        if (!reactionCollapsableUnitPersistentState.f19160a) {
            baseMultiRowSubParts.a(this.f19200a, reactionCardNode);
            baseMultiRowSubParts.a(this.f19202c, reactionCardNode);
        }
        baseMultiRowSubParts.a(this.f19201b, null);
        return null;
    }

    public final boolean m23216a(Object obj) {
        ReactionUnitFragment k = ((ReactionCardNode) obj).mo1117k();
        return (Strings.isNullOrEmpty(k.d()) || Strings.isNullOrEmpty(k.n())) ? false : true;
    }

    @Inject
    public ReactionCollapsableStoryUnitGroupPartDefinition(ReactionAttachmentsGroupPartDefinition reactionAttachmentsGroupPartDefinition, ReactionStoryBottomWithMarginPartDefinition reactionStoryBottomWithMarginPartDefinition, ReactionStoryFooterSelectorPartDefinition reactionStoryFooterSelectorPartDefinition, ReactionCollapsableStoryIconHeaderPartDefinition reactionCollapsableStoryIconHeaderPartDefinition, ReactionStoryTopWithMarginPartDefinition reactionStoryTopWithMarginPartDefinition) {
        this.f19200a = reactionAttachmentsGroupPartDefinition;
        this.f19201b = reactionStoryBottomWithMarginPartDefinition;
        this.f19202c = reactionStoryFooterSelectorPartDefinition;
        this.f19203d = reactionCollapsableStoryIconHeaderPartDefinition;
        this.f19204e = reactionStoryTopWithMarginPartDefinition;
    }

    public static ReactionCollapsableStoryUnitGroupPartDefinition m23213a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCollapsableStoryUnitGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19199g) {
                ReactionCollapsableStoryUnitGroupPartDefinition reactionCollapsableStoryUnitGroupPartDefinition;
                if (a2 != null) {
                    reactionCollapsableStoryUnitGroupPartDefinition = (ReactionCollapsableStoryUnitGroupPartDefinition) a2.a(f19199g);
                } else {
                    reactionCollapsableStoryUnitGroupPartDefinition = f19198f;
                }
                if (reactionCollapsableStoryUnitGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23214b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19199g, b3);
                        } else {
                            f19198f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCollapsableStoryUnitGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
