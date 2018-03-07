package com.facebook.search.results.environment.videos;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.search.results.model.SearchResultsProps;

/* compiled from: SimplepickerLaunchSequence */
public interface HasSearchResultsVideoStoryPersistentState extends AnyEnvironment {
    SearchResultsVideoStoryPersistentState mo1254a(FeedProps<GraphQLStory> feedProps, int i);

    SearchResultsVideoStoryPersistentState mo1257d(SearchResultsProps searchResultsProps);
}
