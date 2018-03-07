package com.facebook.reaction.feed.unitcomponents.partdefinition;

import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.parts.ViewGroupRenderer;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEvents;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentPersistentState;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.collect.ImmutableList;

/* compiled from: ajax/payment/token_proxy.php?tpe= */
class ReactionHScrollUnitComponentPartDefinition$3 extends SimpleCallbacks<E> {
    final /* synthetic */ ImmutableList f19759a;
    final /* synthetic */ ReactionUnitComponentNode f19760b;
    final /* synthetic */ CanHandleHScrollPageChangedEvents f19761c;
    final /* synthetic */ ReactionHScrollComponentKey f19762d;
    final /* synthetic */ ReactionHScrollUnitComponentPartDefinition f19763e;

    ReactionHScrollUnitComponentPartDefinition$3(ReactionHScrollUnitComponentPartDefinition reactionHScrollUnitComponentPartDefinition, ImmutableList immutableList, ReactionUnitComponentNode reactionUnitComponentNode, CanHandleHScrollPageChangedEvents canHandleHScrollPageChangedEvents, ReactionHScrollComponentKey reactionHScrollComponentKey) {
        this.f19763e = reactionHScrollUnitComponentPartDefinition;
        this.f19759a = immutableList;
        this.f19760b = reactionUnitComponentNode;
        this.f19761c = canHandleHScrollPageChangedEvents;
        this.f19762d = reactionHScrollComponentKey;
    }

    public final void m23669a(PageSubParts<E> pageSubParts) {
        ViewType viewType = this.f19759a.size() > 1 ? ReactionHScrollUnitComponentPartDefinition.a : ReactionHScrollUnitComponentPartDefinition.b;
        int size = this.f19759a.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitComponentFields reactionUnitComponentFields = (ReactionUnitComponentFields) this.f19759a.get(i);
            ReactionUnitComponentNode reactionUnitComponentNode = new ReactionUnitComponentNode(reactionUnitComponentFields, this.f19760b.f18863c, this.f19760b.f18864d, this.f19760b.f18861a);
            MultiRowPartWithIsNeeded a = this.f19763e.e.m22892a(reactionUnitComponentFields.a());
            if (a instanceof MultiRowGroupPartDefinition) {
                pageSubParts.a(ViewGroupRenderer.a((MultiRowGroupPartDefinition) a, viewType, ((HasContext) this.f19761c).getContext(), this.f19763e.g), reactionUnitComponentNode);
            } else if (a instanceof MultiRowSinglePartDefinition) {
                pageSubParts.a(ViewGroupRenderer.a((MultiRowSinglePartDefinition) a, viewType, ((HasContext) this.f19761c).getContext(), this.f19763e.g), reactionUnitComponentNode);
            }
        }
    }

    public final void m23670c(int i) {
        ((ReactionHScrollComponentPersistentState) ((HasPersistentState) this.f19761c).a(this.f19762d, this.f19760b)).f19176f = i;
        ((HasReactionInteractionTracker) this.f19761c).kE_().mo980a(this.f19760b.f18863c, this.f19760b.f18864d);
        this.f19761c.mo698b(i, (ReactionUnitComponentFields) this.f19759a.get(i), this.f19760b);
    }
}
