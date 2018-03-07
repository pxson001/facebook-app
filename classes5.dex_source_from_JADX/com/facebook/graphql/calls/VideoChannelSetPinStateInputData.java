package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: places_editor_review_and_suggest_module_v2 */
public final class VideoChannelSetPinStateInputData extends GraphQlMutationCallInput {

    /* compiled from: places_editor_review_and_suggest_module_v2 */
    public enum ChannelType implements JsonSerializable {
        A_PLACE_FOR_EURO_LIVE("A_PLACE_FOR_EURO_LIVE"),
        ALL_FROM_YOUR_SUBSCRIPTIONS("ALL_FROM_YOUR_SUBSCRIPTIONS"),
        BEST_FROM_YOUR_CHANNELS("BEST_FROM_YOUR_CHANNELS"),
        CONNECTED_ACTIVE_LIVE_VIDEOS("CONNECTED_ACTIVE_LIVE_VIDEOS"),
        CONNECTED_LIVE_VIDEOS("CONNECTED_LIVE_VIDEOS"),
        CREATOR_SPACE_PUBLISHER_OWNED("CREATOR_SPACE_PUBLISHER_OWNED"),
        CURRENT_LIVE_STREAMS("CURRENT_LIVE_STREAMS"),
        DEMOGRAPHIC_POPULAR("DEMOGRAPHIC_POPULAR"),
        DIGRAPH_MFCF("DIGRAPH_MFCF"),
        ENGAGED_BY_YOUR_FRIENDS("ENGAGED_BY_YOUR_FRIENDS"),
        FB_CURATED("FB_CURATED"),
        FEATURED_LIVE_STREAMS("FEATURED_LIVE_STREAMS"),
        GROUP("GROUP"),
        LATEST_FROM_YOUR_CHANNELS("LATEST_FROM_YOUR_CHANNELS"),
        LIVE_BROADCAST("LIVE_BROADCAST"),
        LIVE_MOMENTS("LIVE_MOMENTS"),
        TOPICAL_LIVE_VIDEOS("TOPICAL_LIVE_VIDEOS"),
        NEW_FROM_YOUR_SUBSCRIPTIONS("NEW_FROM_YOUR_SUBSCRIPTIONS"),
        PAGE("PAGE"),
        POPULAR_LIVE_IN_THE_WORLD("POPULAR_LIVE_IN_THE_WORLD"),
        VH_COMBINED_SINGLE_LIVE_FEED("VH_COMBINED_SINGLE_LIVE_FEED"),
        PUBLISHER_LIVE_VIDEO_STREAMS("PUBLISHER_LIVE_VIDEO_STREAMS"),
        PUBLISHER_RECENT_LIVE_VIDEO_STREAMS("PUBLISHER_RECENT_LIVE_VIDEO_STREAMS"),
        PUBLISHER_HIGHLIGHTED_VIDEO_STREAMS("PUBLISHER_HIGHLIGHTED_VIDEO_STREAMS"),
        RECENT_LIVE_STREAMS("RECENT_LIVE_STREAMS"),
        RECOMMENDED_ACTIVE_LIVE_VIDEOS("RECOMMENDED_ACTIVE_LIVE_VIDEOS"),
        RELATED_VIDEOS("RELATED_VIDEOS"),
        SAVED_VIDEOS("SAVED_VIDEOS"),
        SEARCH("SEARCH"),
        SHARED_BY_ME("SHARED_BY_ME"),
        SHARED_WITH_YOU("SHARED_WITH_YOU"),
        SOCIALLY_RECOMMENDED_VIDEOS("SOCIALLY_RECOMMENDED_VIDEOS"),
        SUBSCRIBED_ACTIVE_LIVE_VIDEOS("SUBSCRIBED_ACTIVE_LIVE_VIDEOS"),
        SUBSCRIBED_LIVE_VIDEOS("SUBSCRIBED_LIVE_VIDEOS"),
        SUBSCRIBED_NON_ACTIVE_LIVE_VIDEOS("SUBSCRIBED_NON_ACTIVE_LIVE_VIDEOS"),
        TEST_VIDEOS_FROM_TEST_BROADCASTERS("TEST_VIDEOS_FROM_TEST_BROADCASTERS"),
        TOP_PARTNERS_VIDEOS("TOP_PARTNERS_VIDEOS"),
        TOP_VIDEOS("TOP_VIDEOS"),
        TOPIC_FEED("TOPIC_FEED"),
        TOPICAL("TOPICAL"),
        TOPICAL_LIVE("TOPICAL_LIVE"),
        TRENDING_VIDEOS("TRENDING_VIDEOS"),
        TRENDING_DEMOGRAPHICS_POPULAR_LIVE("TRENDING_DEMOGRAPHICS_POPULAR_LIVE"),
        UPLOADED_BY_YOUR_FRIENDS("UPLOADED_BY_YOUR_FRIENDS"),
        USER("USER"),
        VIDEO_ADS_FOR_COMMERCIAL_BREAK("VIDEO_ADS_FOR_COMMERCIAL_BREAK"),
        VIDEO_HOME_FEED("VIDEO_HOME_FEED"),
        VIDEO_HOME_HIGHLIGHTED("VIDEO_HOME_HIGHLIGHTED"),
        VIDEO_HOME_GENERIC_FEED("VIDEO_HOME_GENERIC_FEED"),
        VIDEO_HOME_PINNED_TOPICS("VIDEO_HOME_PINNED_TOPICS"),
        VIDEO_HOME_PINNED_TOPICS_LIVE("VIDEO_HOME_PINNED_TOPICS_LIVE"),
        VIDEO_LIST("VIDEO_LIST"),
        WATCHED_RECOMMENDATIONS("WATCHED_RECOMMENDATIONS"),
        WATCHED_VIDEOS("WATCHED_VIDEOS"),
        WATCHED_VIDEOS_EXPERIMENTAL("WATCHED_VIDEOS_EXPERIMENTAL"),
        WEAKLYENGAGED_BY_YOUR_FRIENDS("WEAKLYENGAGED_BY_YOUR_FRIENDS");
        
        protected final String serverValue;

        private ChannelType(String str) {
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

    /* compiled from: places_editor_review_and_suggest_module_v2 */
    public enum PinState implements JsonSerializable {
        UNPINNED("UNPINNED"),
        PINNED("PINNED");
        
        protected final String serverValue;

        private PinState(String str) {
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

    /* compiled from: places_editor_review_and_suggest_module_v2 */
    public enum Surface implements JsonSerializable {
        VIDEO_CHANNEL_HEADER("VIDEO_CHANNEL_HEADER"),
        INTERN("INTERN"),
        RECOMMENDED_VIDEO_CHANNEL("RECOMMENDED_VIDEO_CHANNEL"),
        FAN_STATUS_CHANGE_OBSERVER("FAN_STATUS_CHANGE_OBSERVER"),
        VIDEO_OVERLAY("VIDEO_OVERLAY"),
        IN_LIVE_EXPERIENCE("IN_LIVE_EXPERIENCE"),
        VIDEO_HOME_GUIDE("VIDEO_HOME_GUIDE"),
        CHEVRON("CHEVRON"),
        TOPICS_UPSELL_UNIT("TOPICS_UPSELL_UNIT"),
        UNKNOWN("UNKNOWN");
        
        protected final String serverValue;

        private Surface(String str) {
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
}
