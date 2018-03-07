package com.facebook.reaction.feed.unitcomponents.partdefinition;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentPersistentState;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel;

/* compiled from: add_ids */
class C2134xb34ae41e extends AbstractDisposableFutureCallback<GraphQLResult<ReactionMoreSubComponentsResultModel>> {
    final /* synthetic */ ReactionPaginatedHScrollUnitComponentPartDefinition f19906a;
    private final ReactionUnitComponentNode f19907b;
    private final E f19908c;
    private final ReactionHScrollComponentPersistentState f19909d;

    protected final void m23809a(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        this.f19909d.f19177g = false;
        if (graphQLResult != null && graphQLResult.e != null && ((ReactionMoreSubComponentsResultModel) graphQLResult.e).a() != null) {
            this.f19908c.mo694a(((ReactionMoreSubComponentsResultModel) graphQLResult.e).a(), this.f19907b);
        }
    }

    public C2134xb34ae41e(ReactionPaginatedHScrollUnitComponentPartDefinition reactionPaginatedHScrollUnitComponentPartDefinition, ReactionUnitComponentNode reactionUnitComponentNode, E e, ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState) {
        this.f19906a = reactionPaginatedHScrollUnitComponentPartDefinition;
        this.f19907b = reactionUnitComponentNode;
        this.f19908c = e;
        this.f19909d = reactionHScrollComponentPersistentState;
    }

    protected final void m23810a(Throwable th) {
        this.f19909d.f19177g = false;
    }
}
