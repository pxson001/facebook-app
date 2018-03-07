package com.facebook.search.results.rows.events;

import com.facebook.feed.rows.core.events.KeyedEvent;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.model.GraphQLStory;
import com.google.common.base.Preconditions;

/* compiled from: RapidReportingTagsQuery */
public class SearchResultsStoryReactionUpdatedEvent implements KeyedEvent<Void> {
    public final FeedProps<GraphQLStory> f23592a;
    public final String f23593b;
    public final FeedbackReaction f23594c;

    public SearchResultsStoryReactionUpdatedEvent(FeedProps<GraphQLStory> feedProps, String str, FeedbackReaction feedbackReaction) {
        this.f23592a = (FeedProps) Preconditions.checkNotNull(feedProps);
        this.f23593b = str;
        this.f23594c = feedbackReaction;
    }

    public final Object m27255c() {
        return null;
    }
}
