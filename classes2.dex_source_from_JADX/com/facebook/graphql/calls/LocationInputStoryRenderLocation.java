package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: review_composer_entry_point_tap_target */
public enum LocationInputStoryRenderLocation implements JsonSerializable {
    HOMEPAGE_STREAM("homepage_stream"),
    SUMMARY("summary"),
    ACTIVITY_LOG("activity_log"),
    TIMELINE("timeline"),
    GROUP("group"),
    GROUPS_LANDING("groups_landing"),
    PERMALINK("permalink"),
    FEED_MOBILE("feed_mobile"),
    HOME_BUBBLE("home_bubble"),
    COVER_FEED("cover_feed"),
    FEED_IMMERSIVE("feed_immersive"),
    PERMALINK_IMMERSIVE("permalink_immersive"),
    TIMELINE_IMMERSIVE("timeline_immersive"),
    GROUP_IMMERSIVE("group_immersive"),
    COVER_IMMERSIVE("cover_immersive"),
    SNAPTU_FEED("snaptu_feed"),
    SNAPTU_TIMELINE("snaptu_timeline"),
    SIDE_FEED("side_feed"),
    APP_FEED("app_feed"),
    REACTION_OVERLAY("reaction_overlay"),
    VIDEO_CHANNEL("video_channel"),
    VIDEO_HOME("video_home"),
    VIDEO_HOME_FEED("video_home_feed"),
    APPENDABLE_PROMPT("appendable_prompt"),
    GAMETIME_HIGHLIGHTS("gametime_highlights"),
    REVIEWS_FEED("reviews_feed"),
    LOCAL_SEARCH_RESULTS_PAGE("local_search_results_page"),
    PLACE_FEED("place_feed"),
    NATIVE_TEMPLATES("native_templates"),
    SEARCH_RESULTS_PAGE("search_results_page"),
    FUNDRAISER_PAGE("fundraiser_page");
    
    protected final String serverValue;

    private LocationInputStoryRenderLocation(String str) {
        this.serverValue = str;
    }

    public final String toString() {
        return this.serverValue;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1123b(this.serverValue);
    }

    public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
    }
}
