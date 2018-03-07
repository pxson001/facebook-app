package com.facebook.search.results.rows.events;

import com.facebook.feed.rows.core.events.KeyedEvent;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.google.common.base.Preconditions;

/* compiled from: RapidReportingWithReasonMutation */
public class SearchResultsStoryLikeEvent implements KeyedEvent<Void> {
    public final FeedProps<GraphQLStory> f23590a;
    public final boolean f23591b;

    public SearchResultsStoryLikeEvent(FeedProps<GraphQLStory> feedProps, boolean z) {
        this.f23590a = (FeedProps) Preconditions.checkNotNull(feedProps);
        this.f23591b = z;
    }

    public final Object m27254c() {
        return null;
    }
}
