package com.facebook.feedplugins.attachments.video;

import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideo;

/* compiled from: photo_status */
public class InlineVideoStoryKey implements ContextStateKey<String, InlineVideoPersistentState> {
    private final String f4903a;
    private final FeedProps<? extends FeedUnit> f4904b;
    private final GraphQLVideo f4905c;
    private final AutoplayStateManagerProvider f4906d;

    public InlineVideoStoryKey(FeedProps<? extends FeedUnit> feedProps, GraphQLVideo graphQLVideo, AutoplayStateManagerProvider autoplayStateManagerProvider) {
        FeedUnit feedUnit = (FeedUnit) feedProps.a;
        this.f4903a = getClass() + (feedUnit instanceof GraphQLStory ? StoryKeyUtil.a((GraphQLStory) feedUnit) : feedUnit.g());
        this.f4904b = feedProps;
        this.f4905c = graphQLVideo;
        this.f4906d = autoplayStateManagerProvider;
    }

    public final Object m5296b() {
        return this.f4903a;
    }

    public final Object m5295a() {
        InlineVideoPersistentState inlineVideoPersistentState = new InlineVideoPersistentState();
        inlineVideoPersistentState.f4912f = this.f4906d.a(((FeedUnit) this.f4904b.a) instanceof GraphQLStory ? this.f4904b : null, this.f4905c, Integer.valueOf(-1));
        return inlineVideoPersistentState;
    }
}
