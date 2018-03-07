package com.facebook.events.feed.ui;

import android.content.res.Resources;
import com.facebook.api.feed.FeedFetchContext;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel.EventPinnedStoriesModel.EdgesModel;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel.EventStoriesModel;
import com.facebook.feed.server.FeedUnitPreRenderProcessor;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.TokenCachingStrategy.ApplicationId */
public class EventPermalinkStoriesExtractor {
    private final Clock f17446a;
    private final FeedUnitPreRenderProcessor f17447b;
    private final Resources f17448c;

    public static EventPermalinkStoriesExtractor m17796b(InjectorLike injectorLike) {
        return new EventPermalinkStoriesExtractor((Clock) SystemClockMethodAutoProvider.a(injectorLike), FeedUnitPreRenderProcessor.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EventPermalinkStoriesExtractor(Clock clock, FeedUnitPreRenderProcessor feedUnitPreRenderProcessor, Resources resources) {
        this.f17446a = clock;
        this.f17447b = feedUnitPreRenderProcessor;
        this.f17448c = resources;
    }

    @Nullable
    public final GraphQLFeedUnitEdge m17797a(EventPinnedPostAndRecentStoryFragmentModel eventPinnedPostAndRecentStoryFragmentModel) {
        if (eventPinnedPostAndRecentStoryFragmentModel.m17739k() == null || eventPinnedPostAndRecentStoryFragmentModel.m17739k().m17718a().isEmpty()) {
            return null;
        }
        EdgesModel edgesModel = (EdgesModel) eventPinnedPostAndRecentStoryFragmentModel.m17739k().m17718a().get(0);
        Builder a = m17794a(this.f17446a.a(), edgesModel.m17712j());
        GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
        builder.i = this.f17448c.getString(2131241911);
        a.z = builder.a();
        GraphQLStory a2 = a.a();
        m17795a(a2);
        GraphQLFeedUnitEdge.Builder builder2 = new GraphQLFeedUnitEdge.Builder();
        builder2.i = a2;
        builder2 = builder2;
        builder2.f = a2.c();
        GraphQLFeedUnitEdge.Builder builder3 = builder2;
        builder3.k = edgesModel.m17713k();
        builder3 = builder3;
        builder3.e = edgesModel.m17711a();
        return builder3.a();
    }

    @Nullable
    public final GraphQLFeedUnitEdge m17798b(EventPinnedPostAndRecentStoryFragmentModel eventPinnedPostAndRecentStoryFragmentModel) {
        if (eventPinnedPostAndRecentStoryFragmentModel.m17740l() == null || eventPinnedPostAndRecentStoryFragmentModel.m17740l().m17731a().isEmpty()) {
            return null;
        }
        EventStoriesModel.EdgesModel edgesModel = (EventStoriesModel.EdgesModel) eventPinnedPostAndRecentStoryFragmentModel.m17740l().m17731a().get(0);
        GraphQLStory a = m17794a(this.f17446a.a(), edgesModel.m17725j()).a();
        m17795a(a);
        GraphQLFeedUnitEdge.Builder builder = new GraphQLFeedUnitEdge.Builder();
        builder.i = a;
        builder = builder;
        builder.f = a.c();
        GraphQLFeedUnitEdge.Builder builder2 = builder;
        builder2.k = edgesModel.m17726k();
        builder2 = builder2;
        builder2.e = edgesModel.m17724a();
        return builder2.a();
    }

    private static Builder m17794a(long j, GraphQLStory graphQLStory) {
        Builder a = Builder.a(graphQLStory);
        a.F = j;
        return a;
    }

    private void m17795a(GraphQLStory graphQLStory) {
        PropertyHelper.a(graphQLStory, null);
        if (graphQLStory.aJ() != null) {
            this.f17447b.a(graphQLStory, new FeedFetchContext(graphQLStory.aJ().b(), null));
        }
    }
}
