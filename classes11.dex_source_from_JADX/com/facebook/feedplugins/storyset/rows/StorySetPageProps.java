package com.facebook.feedplugins.storyset.rows;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.StorySetHelper;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: auth_success */
public class StorySetPageProps {
    public final FeedProps<GraphQLStorySet> f9732a;
    @Nullable
    public final FeedProps<GraphQLStory> f9733b;
    public final int f9734c;
    public final int f9735d;
    public final boolean f9736e;

    public StorySetPageProps(FeedProps<GraphQLStorySet> feedProps, int i, int i2, boolean z) {
        this.f9734c = i;
        this.f9732a = feedProps;
        this.f9735d = i2;
        this.f9736e = z;
        ImmutableList b = StorySetHelper.b((GraphQLStorySet) this.f9732a.a);
        this.f9733b = this.f9734c < b.size() ? this.f9732a.a((Flattenable) b.get(this.f9734c)) : null;
    }
}
