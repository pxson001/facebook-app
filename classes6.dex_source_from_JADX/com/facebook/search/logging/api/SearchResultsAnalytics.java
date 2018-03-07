package com.facebook.search.logging.api;

import com.facebook.common.build.BuildConstants;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: event_track_rsvp */
public class SearchResultsAnalytics {
    private static final ImmutableMap<GraphQLGraphSearchResultsDisplayStyle, String> f15874a = new Builder().b(GraphQLGraphSearchResultsDisplayStyle.BLENDED, "blended").b(GraphQLGraphSearchResultsDisplayStyle.BLENDED_ENTITIES, "blended_entities").b(GraphQLGraphSearchResultsDisplayStyle.STORIES, "posts").b(GraphQLGraphSearchResultsDisplayStyle.LATEST, "latest").b(GraphQLGraphSearchResultsDisplayStyle.USERS, "user").b(GraphQLGraphSearchResultsDisplayStyle.PHOTOS, "photo").b(GraphQLGraphSearchResultsDisplayStyle.PAGES, "page").b(GraphQLGraphSearchResultsDisplayStyle.PLACES, "place").b(GraphQLGraphSearchResultsDisplayStyle.GROUPS, "group").b(GraphQLGraphSearchResultsDisplayStyle.APPS, "app").b(GraphQLGraphSearchResultsDisplayStyle.EVENTS, "event").b(GraphQLGraphSearchResultsDisplayStyle.VIDEO_PUBLISHERS, "video_publishers").b(GraphQLGraphSearchResultsDisplayStyle.BLENDED_VIDEOS, "blended_videos").b(GraphQLGraphSearchResultsDisplayStyle.VIDEOS, "videos").b(GraphQLGraphSearchResultsDisplayStyle.VIDEOS_LIVE, "videos").b(GraphQLGraphSearchResultsDisplayStyle.VIDEOS_WEB, "videos").b(GraphQLGraphSearchResultsDisplayStyle.SALE_POST, "marketplace").b(GraphQLGraphSearchResultsDisplayStyle.TRENDING_FINITE_SERP_SEE_MORE, "posts").b();
    private static final ImmutableMap<GraphQLGraphSearchResultsDisplayStyle, String> f15875b = new Builder().b(GraphQLGraphSearchResultsDisplayStyle.BLENDED, "graph_search_results_page_blended").b(GraphQLGraphSearchResultsDisplayStyle.BLENDED_ENTITIES, "graph_search_results_page_blended_entities").b(GraphQLGraphSearchResultsDisplayStyle.USERS, "graph_search_results_page_user").b(GraphQLGraphSearchResultsDisplayStyle.PHOTOS, "graph_search_results_page_pandora_photo").b(GraphQLGraphSearchResultsDisplayStyle.PAGES, "graph_search_results_page_page").b(GraphQLGraphSearchResultsDisplayStyle.PLACES, "graph_search_results_page_place").b(GraphQLGraphSearchResultsDisplayStyle.GROUPS, "graph_search_results_page_group").b(GraphQLGraphSearchResultsDisplayStyle.APPS, "graph_search_results_page_app").b(GraphQLGraphSearchResultsDisplayStyle.EVENTS, "graph_search_results_page_event").b(GraphQLGraphSearchResultsDisplayStyle.VIDEO_PUBLISHERS, "graph_search_results_page_video_channels").b();

    /* compiled from: event_track_rsvp */
    public enum ActionSource {
        BACK_BUTTON("back_button");
        
        private final String name;

        private ActionSource(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    /* compiled from: event_track_rsvp */
    public enum ExitAction {
        BACK_BUTTON("end_back_button"),
        UP_BUTTON("up_button"),
        CLEAR_BUTTON("clear_button"),
        EDIT_TEXT("edit_text");
        
        private final String name;

        private ExitAction(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    /* compiled from: event_track_rsvp */
    public enum InlineActionName {
        OPEN_CHANNEL_FEED("open_channel_feed"),
        MESSAGE_SELLER("message_seller");
        
        private final String value;

        private InlineActionName(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }

    /* compiled from: event_track_rsvp */
    public enum InlineActionType {
        NAVIGATION("navigation"),
        MUTATION("mutation");
        
        private final String value;

        private InlineActionType(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }

    /* compiled from: event_track_rsvp */
    public enum PageType {
        HEAD("head");
        
        private final String name;

        private PageType(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    /* compiled from: event_track_rsvp */
    public enum ResultsState {
        EMPTY,
        ONLY_TOP_MODULE,
        ONLY_RESULTS,
        TOP_MODULE_AND_RESULTS
    }

    /* compiled from: event_track_rsvp */
    public enum StoryAction {
        LIKED("liked"),
        UNLIKED("unliked"),
        REACTED("reacted"),
        UNREACTED("unreacted"),
        OPEN_LINK("open_link"),
        OPEN_LINK_BY_IMAGE("open_link_by_image"),
        SHARE("share"),
        SAVE("save"),
        UNSAVE("unsave");
        
        private final String value;

        private StoryAction(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }

    public static String m23540a() {
        return SafeUUIDGenerator.a().toString();
    }

    @Nullable
    public static String m23541a(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        String str = graphQLGraphSearchResultsDisplayStyle != null ? (String) f15874a.get(graphQLGraphSearchResultsDisplayStyle) : null;
        if (str != null || !BuildConstants.i) {
            return str;
        }
        throw new IllegalArgumentException("Missing filter type for display style: " + graphQLGraphSearchResultsDisplayStyle);
    }

    @Nullable
    public static String m23543a(ImmutableList<GraphQLGraphSearchResultsDisplayStyle> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) f15875b.get((GraphQLGraphSearchResultsDisplayStyle) immutableList.get(i));
            if (str != null) {
                return str;
            }
        }
        return null;
    }

    @Nullable
    public static String m23542a(@Nullable GraphQLObjectType graphQLObjectType) {
        return graphQLObjectType != null ? graphQLObjectType.toString().toLowerCase(Locale.US) : null;
    }
}
