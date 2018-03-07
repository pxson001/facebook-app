package com.facebook.search.results.environment.videos;

import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsProps;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: SYSTEM_VIDEO_PLAY */
public class HasSearchResultsVideoStoryPersistentStateImpl implements HasSearchResultsVideoStoryPersistentState {
    private final HasPersistentState f22712a;
    private final AutoplayStateManagerProvider f22713b;

    @Inject
    public HasSearchResultsVideoStoryPersistentStateImpl(@Assisted HasPersistentState hasPersistentState, AutoplayStateManagerProvider autoplayStateManagerProvider) {
        this.f22712a = hasPersistentState;
        this.f22713b = autoplayStateManagerProvider;
    }

    public final SearchResultsVideoStoryPersistentState mo1257d(SearchResultsProps searchResultsProps) {
        return mo1254a(((FeedProps) searchResultsProps.f23388a).b, searchResultsProps.f23389b);
    }

    public final SearchResultsVideoStoryPersistentState mo1254a(FeedProps<GraphQLStory> feedProps, int i) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        return (SearchResultsVideoStoryPersistentState) this.f22712a.a(new SearchResultsVideoStoryKey(feedProps, (GraphQLVideo) Preconditions.checkNotNull(GraphQLMediaConversionHelper.b(((GraphQLStoryAttachment) Preconditions.checkNotNull(StoryAttachmentHelper.o(graphQLStory))).r())), i, this.f22713b), graphQLStory);
    }
}
