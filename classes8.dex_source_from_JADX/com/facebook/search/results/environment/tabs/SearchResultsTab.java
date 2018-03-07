package com.facebook.search.results.environment.tabs;

import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.logging.api.SearchResultsAnalytics;
import com.google.common.collect.ImmutableList;

/* compiled from: ScrollView */
public enum SearchResultsTab {
    TOP(GraphQLGraphSearchResultsDisplayStyle.BLENDED),
    TOP_REACTION(GraphQLGraphSearchResultsDisplayStyle.BLENDED),
    TOP_ENTITIES(GraphQLGraphSearchResultsDisplayStyle.BLENDED_ENTITIES),
    LATEST(GraphQLGraphSearchResultsDisplayStyle.LATEST),
    MARKETPLACE(GraphQLGraphSearchResultsDisplayStyle.SALE_POST),
    VIDEOS(GraphQLGraphSearchResultsDisplayStyle.VIDEOS),
    BLENDED_VIDEOS(GraphQLGraphSearchResultsDisplayStyle.BLENDED_VIDEOS),
    VIDEO_CHANNELS(GraphQLGraphSearchResultsDisplayStyle.VIDEO_PUBLISHERS),
    PEOPLE(GraphQLGraphSearchResultsDisplayStyle.USERS),
    PHOTOS(GraphQLGraphSearchResultsDisplayStyle.PHOTOS),
    POSTS(GraphQLGraphSearchResultsDisplayStyle.STORIES),
    PAGES(GraphQLGraphSearchResultsDisplayStyle.PAGES),
    PLACES(GraphQLGraphSearchResultsDisplayStyle.PLACES),
    GROUPS(GraphQLGraphSearchResultsDisplayStyle.GROUPS),
    APPS(GraphQLGraphSearchResultsDisplayStyle.APPS),
    EVENTS(GraphQLGraphSearchResultsDisplayStyle.EVENTS);
    
    public static final ImmutableList<SearchResultsTab> I18N_TABS = null;
    public static final ImmutableList<SearchResultsTab> I18N_TOP_ENTITIES_TABS = null;
    public static final ImmutableList<SearchResultsTab> SECONDARY_TABS = null;
    public static final ImmutableList<SearchResultsTab> VIDEO_HOME_TABS = null;
    public static final ImmutableList<SearchResultsTab> WORK_TABS = null;
    private final GraphQLGraphSearchResultsDisplayStyle displayStyle;

    static {
        SECONDARY_TABS = ImmutableList.of(LATEST, PEOPLE, PHOTOS, VIDEOS, MARKETPLACE, PAGES, PLACES, GROUPS, APPS, EVENTS);
        VIDEO_HOME_TABS = ImmutableList.of(BLENDED_VIDEOS, VIDEO_CHANNELS);
        WORK_TABS = ImmutableList.of(TOP, LATEST, PEOPLE, PHOTOS, GROUPS, EVENTS);
        I18N_TABS = ImmutableList.of(TOP, PEOPLE, PHOTOS, PAGES, GROUPS, EVENTS);
        I18N_TOP_ENTITIES_TABS = ImmutableList.of(TOP_ENTITIES, PEOPLE, PAGES, GROUPS, EVENTS, POSTS, PHOTOS);
    }

    private SearchResultsTab(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        this.displayStyle = graphQLGraphSearchResultsDisplayStyle;
    }

    public final String toString() {
        return SearchResultsAnalytics.a(this.displayStyle);
    }
}
