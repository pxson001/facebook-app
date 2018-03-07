package com.facebook.feedplugins.researchpoll;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;

/* compiled from: cache_expired */
public class ResearchPollStoryKey implements ContextStateKey<String, ResearchPollPersistentState> {
    private final String f9093a;

    public ResearchPollStoryKey(GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit) {
        this.f9093a = graphQLResearchPollFeedUnit.D();
    }

    public final Object m9785b() {
        return this.f9093a;
    }

    public final Object m9784a() {
        return new ResearchPollPersistentState();
    }
}
