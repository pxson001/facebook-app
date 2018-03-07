package com.facebook.reaction.feed.unitcomponents.partdefinition;

import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.parts.ViewGroupRenderer;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanAddReactionComponents;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEvents;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentPersistentState;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.collect.ImmutableList;

/* compiled from: add_ids */
class ReactionPaginatedHScrollUnitComponentPartDefinition$3 extends SimpleCallbacks<E> {
    final /* synthetic */ ImmutableList f19899a;
    final /* synthetic */ ReactionUnitComponentNode f19900b;
    final /* synthetic */ CanAddReactionComponents f19901c;
    final /* synthetic */ ReactionHScrollComponentKey f19902d;
    final /* synthetic */ ReactionHScrollComponentPersistentState f19903e;
    final /* synthetic */ DefaultPageInfoFields f19904f;
    final /* synthetic */ ReactionPaginatedHScrollUnitComponentPartDefinition f19905g;

    ReactionPaginatedHScrollUnitComponentPartDefinition$3(ReactionPaginatedHScrollUnitComponentPartDefinition reactionPaginatedHScrollUnitComponentPartDefinition, ImmutableList immutableList, ReactionUnitComponentNode reactionUnitComponentNode, CanAddReactionComponents canAddReactionComponents, ReactionHScrollComponentKey reactionHScrollComponentKey, ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState, DefaultPageInfoFields defaultPageInfoFields) {
        this.f19905g = reactionPaginatedHScrollUnitComponentPartDefinition;
        this.f19899a = immutableList;
        this.f19900b = reactionUnitComponentNode;
        this.f19901c = canAddReactionComponents;
        this.f19902d = reactionHScrollComponentKey;
        this.f19903e = reactionHScrollComponentPersistentState;
        this.f19904f = defaultPageInfoFields;
    }

    public final void m23807a(PageSubParts<E> pageSubParts) {
        int size = this.f19899a.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            ReactionUnitComponentFields reactionUnitComponentFields = (ReactionUnitComponentFields) this.f19899a.get(i);
            ReactionUnitComponentNode reactionUnitComponentNode = new ReactionUnitComponentNode(reactionUnitComponentFields, this.f19900b.f18863c, this.f19900b.f18864d, this.f19900b.f18861a);
            MultiRowPartWithIsNeeded a = this.f19905g.g.m22892a(reactionUnitComponentFields.a());
            if (a.a(reactionUnitComponentNode)) {
                if (a instanceof MultiRowGroupPartDefinition) {
                    pageSubParts.a(ViewGroupRenderer.a((MultiRowGroupPartDefinition) a, ReactionPaginatedHScrollUnitComponentPartDefinition.b(reactionUnitComponentFields), ((HasContext) this.f19901c).getContext(), this.f19905g.d), reactionUnitComponentNode);
                    obj2 = 1;
                } else if (a instanceof MultiRowSinglePartDefinition) {
                    pageSubParts.a(ViewGroupRenderer.a((MultiRowSinglePartDefinition) a, ReactionPaginatedHScrollUnitComponentPartDefinition.b(reactionUnitComponentFields), ((HasContext) this.f19901c).getContext(), this.f19905g.d), reactionUnitComponentNode);
                    int i2 = 1;
                }
                i++;
                obj = obj2;
            }
            obj2 = obj;
            i++;
            obj = obj2;
        }
        if (obj == null) {
            ReactionPaginatedHScrollUnitComponentPartDefinition.a(this.f19905g, this.f19901c);
        }
    }

    public final void m23808c(int i) {
        ((ReactionHScrollComponentPersistentState) ((HasPersistentState) this.f19901c).a(this.f19902d, this.f19900b)).f19176f = i;
        ((HasReactionInteractionTracker) this.f19901c).kE_().mo980a(this.f19900b.f18863c, this.f19900b.f18864d);
        if (((HasReactionSession) this.f19901c).mo704p().f18660c == Surface.ANDROID_EVENT_DISCOVER_DASHBOARD) {
            ((HasReactionInteractionTracker) this.f19901c).kE_().m18939a(this.f19900b.f18863c, this.f19900b.f18864d, i, ((ReactionUnitComponentFields) this.f19899a.get(i)).V());
        }
        ((CanHandleHScrollPageChangedEvents) this.f19901c).mo698b(i, (ReactionUnitComponentFields) this.f19899a.get(i), this.f19900b);
        ReactionPaginatedHScrollUnitComponentPartDefinition.a(this.f19905g, this.f19900b, this.f19901c, this.f19903e, this.f19904f);
    }
}
