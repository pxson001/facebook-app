package com.facebook.feedplugins.goodwill;

import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackDataPoint;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.HasFeedUnit;

/* compiled from: graph_search_results_paged */
public class FriendversaryDataCardAttachmentDataPointProps implements HasFeedProps<GraphQLStory>, HasFeedUnit {
    public final float f12236a;
    public final GraphQLGoodwillThrowbackDataPoint f12237b;
    public final FeedProps<GraphQLStoryAttachment> f12238c;
    public final Position f12239d;
    public final FeedProps<GraphQLStory> f12240e = AttachmentProps.e(this.f12238c);

    public FriendversaryDataCardAttachmentDataPointProps(GraphQLGoodwillThrowbackDataPoint graphQLGoodwillThrowbackDataPoint, FeedProps<GraphQLStoryAttachment> feedProps, Position position, float f) {
        this.f12237b = graphQLGoodwillThrowbackDataPoint;
        this.f12238c = feedProps;
        this.f12239d = position;
        this.f12236a = f;
    }

    public final FeedUnit m14207c() {
        return this.f12240e == null ? null : (GraphQLStory) this.f12240e.a;
    }

    public final FeedProps<GraphQLStory> m14208f() {
        return this.f12240e;
    }
}
