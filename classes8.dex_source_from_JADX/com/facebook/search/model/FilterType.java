package com.facebook.search.model;

import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Locale;

/* compiled from: TYPED */
public enum FilterType {
    Search,
    People,
    Page,
    Group,
    Event,
    Photos,
    Places,
    App,
    VideosBlended;
    
    private static final ImmutableList<FilterType> CORE_SEARCH_FILTERS = null;
    private static final ImmutableMap<GraphQLGraphSearchResultsDisplayStyle, FilterType> DISPLAY_STYLE_TO_FILTER_TYPE = null;

    static {
        DISPLAY_STYLE_TO_FILTER_TYPE = new Builder().b(GraphQLGraphSearchResultsDisplayStyle.USERS, People).b(GraphQLGraphSearchResultsDisplayStyle.BLENDED, Search).b(GraphQLGraphSearchResultsDisplayStyle.BLENDED_ENTITIES, Search).b(GraphQLGraphSearchResultsDisplayStyle.STORIES, Search).b(GraphQLGraphSearchResultsDisplayStyle.PAGES, Page).b(GraphQLGraphSearchResultsDisplayStyle.GROUPS, Group).b(GraphQLGraphSearchResultsDisplayStyle.EVENTS, Event).b(GraphQLGraphSearchResultsDisplayStyle.PHOTOS, Photos).b(GraphQLGraphSearchResultsDisplayStyle.PLACES, Places).b(GraphQLGraphSearchResultsDisplayStyle.APPS, App).b(GraphQLGraphSearchResultsDisplayStyle.BLENDED_VIDEOS, VideosBlended).b(GraphQLGraphSearchResultsDisplayStyle.VIDEO_PUBLISHERS, VideosBlended).b();
        CORE_SEARCH_FILTERS = ImmutableList.of(Search, People, Page, Group, Event, App);
    }

    public final String toString() {
        return name().toLowerCase(Locale.US);
    }

    public static FilterType getCoreFilterTypeAt(int i) {
        if (i < 0 || i >= getCoreFilterTypeLength()) {
            return null;
        }
        return (FilterType) CORE_SEARCH_FILTERS.get(i);
    }

    public static int getCoreFilterTypeLength() {
        return CORE_SEARCH_FILTERS.size();
    }

    public static int getPositionOfCoreDisplayStyle(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        return getPositionOfCoreFilterType((FilterType) DISPLAY_STYLE_TO_FILTER_TYPE.get(graphQLGraphSearchResultsDisplayStyle));
    }

    public static FilterType from(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        FilterType filterType = (FilterType) DISPLAY_STYLE_TO_FILTER_TYPE.get(graphQLGraphSearchResultsDisplayStyle);
        return filterType != null ? filterType : Search;
    }

    public static int getPositionOfCoreFilterType(FilterType filterType) {
        return CORE_SEARCH_FILTERS.indexOf(filterType);
    }
}
