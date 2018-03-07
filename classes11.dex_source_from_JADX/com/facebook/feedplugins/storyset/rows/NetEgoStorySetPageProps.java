package com.facebook.feedplugins.storyset.rows;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: best guess is null */
public class NetEgoStorySetPageProps<T extends ScrollableItemListFeedUnit> {
    public final FeedProps<T> f9563a;
    @Nullable
    public final FeedProps<GraphQLStory> f9564b;
    public final int f9565c;
    public final int f9566d;
    public final boolean f9567e;

    public NetEgoStorySetPageProps(FeedProps<T> feedProps, int i, int i2, boolean z) {
        this.f9565c = i;
        this.f9563a = feedProps;
        this.f9566d = i2;
        this.f9567e = z;
        ImmutableList a = ScrollableItemListFeedUnitImpl.a((ScrollableItemListFeedUnit) this.f9563a.a);
        FeedProps a2 = (this.f9565c < 0 || this.f9565c >= a.size()) ? null : this.f9563a.a((Flattenable) a.get(this.f9565c));
        this.f9564b = a2;
    }
}
