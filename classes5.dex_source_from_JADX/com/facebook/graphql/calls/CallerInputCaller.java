package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: referenced_sticker */
public enum CallerInputCaller implements JsonSerializable {
    INTERNAL("INTERNAL"),
    WWW_FEED_PIVOTS("WWW_FEED_PIVOTS"),
    WWW_FEED_SNOWLIFT("WWW_FEED_SNOWLIFT"),
    MISC_PHOTO_SET("MISC_PHOTO_SET"),
    MOBILE("MOBILE"),
    SEARCH("SEARCH"),
    WWW_FEED_RHC("WWW_FEED_RHC"),
    WWW_PERMALINK("WWW_PERMALINK"),
    MY_VIDEO_CHANNELS_ENT_QUERY("MY_VIDEO_CHANNELS_ENT_QUERY"),
    TOP_FOLLOWED_VIDEO_CHANNELS_ENT_QUERY("TOP_FOLLOWED_VIDEO_CHANNELS_ENT_QUERY"),
    BADGE("BADGE"),
    PAGINATION("PAGINATION"),
    SUBTITLE("SUBTITLE"),
    CHANNEL_VIEW_FROM_UNKNOWN("CHANNEL_VIEW_FROM_UNKNOWN"),
    CHANNEL_VIEW_FROM_NEWSFEED("CHANNEL_VIEW_FROM_NEWSFEED"),
    CHANNEL_VIEW_FROM_SEARCH("CHANNEL_VIEW_FROM_SEARCH"),
    CHANNEL_VIEW_FROM_NEWSFEED_PIVOT("CHANNEL_VIEW_FROM_NEWSFEED_PIVOT"),
    NEWSFEED_PIVOT_INLINE("NEWSFEED_PIVOT_INLINE"),
    CHANNEL_VIEW_FROM_PAGE_CALL_TO_ACTION("CHANNEL_VIEW_FROM_PAGE_CALL_TO_ACTION"),
    CHANNEL_VIEW_FROM_PAGE_TIMELINE("CHANNEL_VIEW_FROM_PAGE_TIMELINE"),
    CHANNEL_VIEW_FROM_PAGE_TIMELINE_FEATURED("CHANNEL_VIEW_FROM_PAGE_TIMELINE_FEATURED"),
    CHANNEL_VIEW_FROM_PAGE_VIDEO_TAB("CHANNEL_VIEW_FROM_PAGE_VIDEO_TAB"),
    CHANNEL_VIEW_FROM_USER_TIMELINE("CHANNEL_VIEW_FROM_USER_TIMELINE"),
    CHANNEL_VIEW_FROM_USER_VIDEO_TAB("CHANNEL_VIEW_FROM_USER_VIDEO_TAB"),
    CHANNEL_VIEW_FROM_GROUP_TIMELINE("CHANNEL_VIEW_FROM_GROUP_TIMELINE"),
    CHANNEL_VIEW_FROM_GROUP_VIDEO_TAB("CHANNEL_VIEW_FROM_GROUP_VIDEO_TAB"),
    CHANNEL_VIEW_FROM_SAVED_STORY("CHANNEL_VIEW_FROM_SAVED_STORY"),
    SAVED_STORY_INLINE("SAVED_STORY_INLINE"),
    CHANNEL_VIEW_FROM_SHARED_WITH_YOU_STORY("CHANNEL_VIEW_FROM_SHARED_WITH_YOU_STORY"),
    SHARED_WITH_YOU_STORY_INLINE("SHARED_WITH_YOU_STORY_INLINE"),
    CHANNEL_VIEW_FROM_LATEST_FROM_YOUR_CHANNELS_STORY("CHANNEL_VIEW_FROM_LATEST_FROM_YOUR_CHANNELS_STORY"),
    LATEST_FROM_YOUR_CHANNELS_STORY_INLINE("LATEST_FROM_YOUR_CHANNELS_STORY_INLINE"),
    CHANNEL_VIEW_FROM_CHANNEL_PIVOT("CHANNEL_VIEW_FROM_CHANNEL_PIVOT"),
    CHANNEL_PIVOT_INLINE("CHANNEL_PIVOT_INLINE"),
    CHANNEL_VIEW_FROM_CHANNEL_RECOMMENDED_CHANNEL_STORY("CHANNEL_VIEW_FROM_CHANNEL_RECOMMENDED_CHANNEL_STORY"),
    RECOMMENDED_CHANNEL_STORY_INLINE("RECOMMENDED_CHANNEL_STORY_INLINE"),
    CHANNEL_VIEW_FROM_VIDEO_HOME("CHANNEL_VIEW_FROM_VIDEO_HOME"),
    VIDEO_HOME_INLINE("VIDEO_HOME_INLINE"),
    CHANNEL_VIEW_FROM_CASTING("CHANNEL_VIEW_FROM_CASTING"),
    VIDEO_HOME_FEED("VIDEO_HOME_FEED"),
    FEED_SURVEY_SWIPE("FEED_SURVEY_SWIPE"),
    FEED_PIVOTS_INLINE("FEED_PIVOTS_INLINE"),
    CHANNEL_VIEW_FROM_FEED_PIVOTS("CHANNEL_VIEW_FROM_FEED_PIVOTS"),
    VIDEO_SETS_CACHE_REFRESH("VIDEO_SETS_CACHE_REFRESH"),
    VIDEO_SETS_CACHE_CHECK("VIDEO_SETS_CACHE_CHECK"),
    DUMMY_STORY_RECOMMENDED_VIDEOS("DUMMY_STORY_RECOMMENDED_VIDEOS"),
    DUMMY_STORY_FRIENDS_ENJOYING("DUMMY_STORY_FRIENDS_ENJOYING"),
    LIVE_VIDEOS_SET("LIVE_VIDEOS_SET"),
    DUMMY_STORY_FRIENDS_ENJOYING_NOW("DUMMY_STORY_FRIENDS_ENJOYING_NOW"),
    DUMMY_STORY_DUMMY_ACTION("DUMMY_STORY_DUMMY_ACTION"),
    OCULUS_VIDEO("OCULUS_VIDEO"),
    TRENDING_DEMOGRAPHICS_LIVE("TRENDING_DEMOGRAPHICS_LIVE"),
    LIVE_MAP("LIVE_MAP"),
    UNCONNECTED_LIVE_VIDEO("UNCONNECTED_LIVE_VIDEO");
    
    protected final String serverValue;

    private CallerInputCaller(String str) {
        this.serverValue = str;
    }

    public final String toString() {
        return this.serverValue;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.b(this.serverValue);
    }

    public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
    }
}
