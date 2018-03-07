package com.facebook.search.results.environment.videos;

import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideo;

/* compiled from: SYSTEM_VIDEO_FINISHED */
public class SearchResultsVideoStoryKey implements ContextStateKey<String, SearchResultsVideoStoryPersistentState> {
    private static final String f22714a = SearchResultsVideoStoryKey.class.getSimpleName();
    private final String f22715b;
    private final int f22716c;
    private final FeedProps<GraphQLStory> f22717d;
    private final GraphQLVideo f22718e;
    private final AutoplayStateManagerProvider f22719f;

    public SearchResultsVideoStoryKey(FeedProps<GraphQLStory> feedProps, GraphQLVideo graphQLVideo, int i, AutoplayStateManagerProvider autoplayStateManagerProvider) {
        this.f22717d = feedProps;
        this.f22718e = graphQLVideo;
        this.f22715b = f22714a + StoryKeyUtil.a((GraphQLStory) this.f22717d.a) + i;
        this.f22716c = i;
        this.f22719f = autoplayStateManagerProvider;
    }

    public final Object m26271b() {
        return this.f22715b;
    }

    public final Object m26270a() {
        return new SearchResultsVideoStoryPersistentState(this.f22718e.J(), this.f22719f.a(this.f22717d, this.f22718e, Integer.valueOf(this.f22716c - 1)));
    }
}
