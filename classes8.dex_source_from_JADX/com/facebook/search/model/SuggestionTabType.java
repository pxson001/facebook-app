package com.facebook.search.model;

import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.google.common.collect.ImmutableList;
import java.util.Locale;

/* compiled from: TIMELINE_ABOUT_FRIENDS_APP */
public enum SuggestionTabType {
    GLOBAL,
    SCOPED;
    
    private static final ImmutableList<SuggestionTabType> DEFAULT_TABS = null;
    private static final ImmutableList<SuggestionTabType> FLIPPED_TABS = null;

    static {
        DEFAULT_TABS = ImmutableList.of(GLOBAL, SCOPED);
        FLIPPED_TABS = ImmutableList.of(SCOPED, GLOBAL);
    }

    public final String toString() {
        return name().toLowerCase(Locale.US);
    }

    public static ImmutableList<SuggestionTabType> getTabs(GraphSearchQuery graphSearchQuery) {
        if (graphSearchQuery.h == ScopedEntityType.VIDEO || graphSearchQuery.h == ScopedEntityType.MARKETPLACE) {
            return FLIPPED_TABS;
        }
        return DEFAULT_TABS;
    }
}
