package com.facebook.events.permalink.adapters;

import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel.BoostableStoryModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.annotation.Nullable;

/* compiled from: buzz_on_deltas_enabled */
public interface EventPermalinkAdapter<T extends ScrollingViewProxy> {
    void mo822a(int i, int i2, int i3);

    void mo823a(FeedUnitCollection feedUnitCollection);

    void mo824a(BoostableStoryModel boostableStoryModel);

    void mo825a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel);

    void mo826a(GraphQLStory graphQLStory);

    void mo827a(T t);

    void mo828a(boolean z, boolean z2);

    void mo829b();

    void mo830b(GraphQLStory graphQLStory);

    void mo831b(T t);

    void mo832c();

    @Nullable
    GraphQLStory mo833d();

    void mo834e();

    void mo835f();

    void mo836g();

    boolean isEmpty();

    void notifyDataSetChanged();
}
