package com.facebook.feedplugins.graphqlstory.inlinecomments;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.HasFeedUnit;

/* compiled from: groups/discover/categories */
public class InlineCommentData implements HasFeedProps<GraphQLStory>, HasFeedUnit {
    public final FeedProps<GraphQLStory> f21610a;
    public final GraphQLComment f21611b;
    public final AttachmentDisplayInfo f21612c;

    public InlineCommentData(FeedProps<GraphQLStory> feedProps, GraphQLComment graphQLComment, AttachmentDisplayInfo attachmentDisplayInfo) {
        this.f21610a = feedProps;
        this.f21611b = graphQLComment;
        this.f21612c = attachmentDisplayInfo;
    }

    public final FeedUnit mo2540c() {
        return (FeedUnit) this.f21610a.f13444a;
    }

    public final FeedProps<GraphQLStory> mo2637f() {
        return this.f21610a;
    }
}
