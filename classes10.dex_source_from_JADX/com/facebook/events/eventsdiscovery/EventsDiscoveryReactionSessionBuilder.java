package com.facebook.events.eventsdiscovery;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionSuggestedEventsQueryModel;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Inject;

/* compiled from: com.facebook.events.feed.ui.environment */
public class EventsDiscoveryReactionSessionBuilder {
    private final ReactionSessionManager f17325a;
    private final ReactionUtil f17326b;

    public static EventsDiscoveryReactionSessionBuilder m17618b(InjectorLike injectorLike) {
        return new EventsDiscoveryReactionSessionBuilder(ReactionSessionManager.a(injectorLike), ReactionUtil.a(injectorLike));
    }

    @Inject
    public EventsDiscoveryReactionSessionBuilder(ReactionSessionManager reactionSessionManager, ReactionUtil reactionUtil) {
        this.f17325a = reactionSessionManager;
        this.f17326b = reactionUtil;
    }

    public final ReactionSession m17619a(Surface surface) {
        String uuid = SafeUUIDGenerator.a().toString();
        ReactionSession a = this.f17325a.a(uuid, surface);
        this.f17325a.c(uuid);
        return a;
    }

    public static EventsDiscoveryReactionSessionBuilder m17617a(InjectorLike injectorLike) {
        return m17618b(injectorLike);
    }

    public final void m17620a(Surface surface, AbstractDisposableFutureCallback<GraphQLResult<ReactionSuggestedEventsQueryModel>> abstractDisposableFutureCallback, ObjectNode objectNode, String str) {
        this.f17326b.a(abstractDisposableFutureCallback, 5, null, surface, objectNode, str);
    }

    public final void m17621a(Surface surface, AbstractDisposableFutureCallback<GraphQLResult<ReactionSuggestedEventsQueryModel>> abstractDisposableFutureCallback, ObjectNode objectNode, String str, boolean z, String str2) {
        if (z) {
            this.f17326b.a(abstractDisposableFutureCallback, 5, str2, surface, objectNode, str);
        }
    }
}
