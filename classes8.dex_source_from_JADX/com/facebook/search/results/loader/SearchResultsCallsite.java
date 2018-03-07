package com.facebook.search.results.loader;

import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: SEARCH_NULL_STATE_CLICK */
public enum SearchResultsCallsite {
    USER_SEARCH("android:user_search"),
    VIDEO_SEARCH("android:video_search"),
    COMMERCE_SEARCH("browse:commerce:global_android");
    
    private static final ImmutableMap<GraphQLGraphSearchResultsDisplayStyle, SearchResultsCallsite> sDisplayStyleToCallSiteMap = null;
    private final String name;

    static {
        sDisplayStyleToCallSiteMap = new Builder().b(GraphQLGraphSearchResultsDisplayStyle.USERS, USER_SEARCH).b(GraphQLGraphSearchResultsDisplayStyle.BLENDED_VIDEOS, VIDEO_SEARCH).b(GraphQLGraphSearchResultsDisplayStyle.VIDEO_PUBLISHERS, VIDEO_SEARCH).b(GraphQLGraphSearchResultsDisplayStyle.VIDEOS, VIDEO_SEARCH).b(GraphQLGraphSearchResultsDisplayStyle.VIDEOS_WEB, VIDEO_SEARCH).b(GraphQLGraphSearchResultsDisplayStyle.VIDEOS_LIVE, VIDEO_SEARCH).b();
    }

    private SearchResultsCallsite(String str) {
        this.name = str;
    }

    public static SearchResultsCallsite fromDisplayStyle(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        SearchResultsCallsite searchResultsCallsite = (SearchResultsCallsite) sDisplayStyleToCallSiteMap.get(graphQLGraphSearchResultsDisplayStyle);
        if (searchResultsCallsite != null) {
            return searchResultsCallsite;
        }
        throw new IllegalArgumentException("Unregistered callsite for display style " + graphQLGraphSearchResultsDisplayStyle);
    }

    public final String toString() {
        return this.name;
    }
}
