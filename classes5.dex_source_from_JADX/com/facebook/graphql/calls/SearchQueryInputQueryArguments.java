package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: popular_at_report_wrong_name */
public final class SearchQueryInputQueryArguments extends GraphQlCallInput {

    /* compiled from: popular_at_report_wrong_name */
    public final class FilteredQueryArguments extends GraphQlCallInput {

        /* compiled from: popular_at_report_wrong_name */
        public final class Filters extends GraphQlCallInput {

            /* compiled from: popular_at_report_wrong_name */
            public enum Action implements JsonSerializable {
                ADD("add"),
                REMOVE("remove");
                
                protected final String serverValue;

                private Action(String str) {
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

            public final Filters m4486a(String str) {
                a("name", str);
                return this;
            }

            public final Filters m4487b(String str) {
                a("handle", str);
                return this;
            }

            public final Filters m4485a(Action action) {
                a("action", action);
                return this;
            }

            public final Filters m4488c(String str) {
                a("value", str);
                return this;
            }
        }

        /* compiled from: popular_at_report_wrong_name */
        public enum SupportedExperiences implements JsonSerializable {
            CELEBRITY("CELEBRITY"),
            MIXED_MEDIA("MIXED_MEDIA"),
            CELEBRITY_TOP_MEDIA("CELEBRITY_TOP_MEDIA"),
            SPORTS_NFL("SPORTS_NFL"),
            FILTERS("FILTERS"),
            FAST_FILTERS("FAST_FILTERS"),
            SMART_SUGGESTED_FILTERS("SMART_SUGGESTED_FILTERS"),
            I18N_POST_SEARCH_REDIRECT("I18N_POST_SEARCH_REDIRECT"),
            I18N_POST_SEARCH_EXPANSION("I18N_POST_SEARCH_EXPANSION"),
            I18N_POST_SEARCH_USER_EXPANSION("I18N_POST_SEARCH_USER_EXPANSION"),
            I18N_POST_SEARCH_TAB("I18N_POST_SEARCH_TAB"),
            I18N_POST_SEARCH_TAB_IPAD("I18N_POST_SEARCH_TAB_IPAD"),
            ATTACHED_HEADERS("ATTACHED_HEADERS"),
            PROGRAMMATIC_CONTEXT_CURATED_HEADLINE("PROGRAMMATIC_CONTEXT_CURATED_HEADLINE"),
            FILTERS_AS_SEE_MORE("FILTERS_AS_SEE_MORE"),
            DONT_SPLIT_POST_MODULES("DONT_SPLIT_POST_MODULES"),
            TRENDING_FINITE_SERP("TRENDING_FINITE_SERP"),
            NEW_VIDEO_TAB("NEW_VIDEO_TAB"),
            POST_SETS("POST_SETS"),
            DISAMBIGUATION_TABLE_OF_CONTENTS_POST_MODULE("DISAMBIGUATION_TABLE_OF_CONTENTS_POST_MODULE"),
            DENSE_RESULT_PAGE("DENSE_RESULT_PAGE"),
            DISAMBIGUATION_NON_BLENDER_ENTITY_MODULES("DISAMBIGUATION_NON_BLENDER_ENTITY_MODULES"),
            DISAMBIGUATION_MULTIPLE_POSTS_PER_MODULE("DISAMBIGUATION_MULTIPLE_POSTS_PER_MODULE"),
            INFINITE_DISAMBIGUATION_SERP("INFINITE_DISAMBIGUATION_SERP"),
            DISAMBIGUATION_SEND_EMPTY_MODULES("DISAMBIGUATION_SEND_EMPTY_MODULES"),
            DISAMBIGUATION_HIDE_LOW_QUALITY_ENTITY_MODULES("DISAMBIGUATION_HIDE_LOW_QUALITY_ENTITY_MODULES"),
            SERP_ADD_ENTITY_PIVOT("SERP_ADD_ENTITY_PIVOT");
            
            protected final String serverValue;

            private SupportedExperiences(String str) {
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

        /* compiled from: popular_at_report_wrong_name */
        public enum SupportedRoles implements JsonSerializable {
            TEST_SPLITTABLE("TEST_SPLITTABLE"),
            TEST_NON_SPLITTABLE("TEST_NON_SPLITTABLE"),
            TRENDING_TOPIC_MODULE("TRENDING_TOPIC_MODULE"),
            NEWS_SOCIAL("NEWS_SOCIAL"),
            NEWS_PUBLISHERS("NEWS_PUBLISHERS"),
            NEWS_TOP_VIDEO("NEWS_TOP_VIDEO"),
            MAIN_MODULE("MAIN_MODULE"),
            NEWS_HEADLINE("NEWS_HEADLINE"),
            PXS_PIVOTS("PXS_PIVOTS"),
            PUBLIC_MEDIA("PUBLIC_MEDIA"),
            FEED_MEDIA("FEED_MEDIA"),
            COVER_MEDIA("COVER_MEDIA"),
            FEATURED_POST("FEATURED_POST"),
            POST_SEARCH_SECTION_HEADER("POST_SEARCH_SECTION_HEADER"),
            FOR_SALE_PRODUCTS("FOR_SALE_PRODUCTS"),
            MUTUALLY_LIKED_POSTS("MUTUALLY_LIKED_POSTS"),
            MUTUALLY_COMMENTED_POSTS("MUTUALLY_COMMENTED_POSTS"),
            CENTRAL("CENTRAL"),
            OPTIONAL("OPTIONAL"),
            NONE("NONE"),
            LIVE_CONVERSATION_MODULE("LIVE_CONVERSATION_MODULE"),
            NEWS_KEY_VOICES("NEWS_KEY_VOICES"),
            NEWS_EYEWITNESSES("NEWS_EYEWITNESSES"),
            SPORT_MODULE("SPORT_MODULE"),
            NEWS_MODULE("NEWS_MODULE"),
            NEWS_CONTEXT("NEWS_CONTEXT"),
            GAMETIME_FAN_FAVORITE("GAMETIME_FAN_FAVORITE"),
            TOP_MAIN_MODULE("TOP_MAIN_MODULE"),
            TOP_VITAL("TOP_VITAL"),
            GRAMMAR("GRAMMAR"),
            PREFILLED_COMPOSER("PREFILLED_COMPOSER"),
            SPORTS_DATA_PHOTO("SPORTS_DATA_PHOTO"),
            PUBLIC_POSTS("PUBLIC_POSTS"),
            FEED_POSTS("FEED_POSTS"),
            NEWS_PIVOT("NEWS_PIVOT"),
            SPORT_ENTRY("SPORT_ENTRY"),
            GLOBAL_SHARE_METADATA("GLOBAL_SHARE_METADATA"),
            GLOBAL_SHARE_POSTS("GLOBAL_SHARE_POSTS"),
            TOPIC_METADATA("TOPIC_METADATA"),
            RELATED_TOPICS("RELATED_TOPICS"),
            EMOTIONAL_ANALYSIS("EMOTIONAL_ANALYSIS"),
            COMMON_PHRASES("COMMON_PHRASES"),
            COMMON_QUOTES("COMMON_QUOTES"),
            PROMOTED_ENTITY_MEDIA("PROMOTED_ENTITY_MEDIA"),
            SEARCH_SUGGESTIONS_MODULE("SEARCH_SUGGESTIONS_MODULE"),
            SECTION_HEADER("SECTION_HEADER"),
            EMPTY_CARD("EMPTY_CARD"),
            SPORT_VIDEO("SPORT_VIDEO"),
            SPORT_LINKS("SPORT_LINKS"),
            SPORT_REDIRECT("SPORT_REDIRECT"),
            VIDEOS_WEB("VIDEOS_WEB"),
            VIDEOS_LIVE("VIDEOS_LIVE"),
            VIDEOS_MIXED("VIDEOS_MIXED"),
            VIDEO_PUBLISHERS("VIDEO_PUBLISHERS"),
            TOP_VIDEOS("TOP_VIDEOS"),
            FEED_VIDEOS("FEED_VIDEOS"),
            POST_CONTEXT("POST_CONTEXT"),
            RELATED_SHARES("RELATED_SHARES"),
            PROMOTED_ENTITY_RELATED_SEARCHES("PROMOTED_ENTITY_RELATED_SEARCHES"),
            SEE_MORE_PIVOT("SEE_MORE_PIVOT"),
            WIKIPEDIA_CARD("WIKIPEDIA_CARD"),
            RELATED_ENTITIES("RELATED_ENTITIES"),
            RELATED_SHARES_WITH_POSTS("RELATED_SHARES_WITH_POSTS"),
            REACTION_UNIT("REACTION_UNIT"),
            VIDEOS("VIDEOS"),
            DEBATE_FEELS("DEBATE_FEELS"),
            DEBATE_ISSUES("DEBATE_ISSUES"),
            MY_POSTS("MY_POSTS"),
            POSTS_ABOUT("POSTS_ABOUT"),
            TOP_POSTS_BY("TOP_POSTS_BY"),
            PHOTOS_WITH_MY_FRIENDS("PHOTOS_WITH_MY_FRIENDS"),
            MUTUALLY_LIKED_COMMENTED_POSTS("MUTUALLY_LIKED_COMMENTED_POSTS"),
            BIRTHDAY("BIRTHDAY"),
            TIME("TIME"),
            ELECTIONS("ELECTIONS"),
            CURRENCY("CURRENCY"),
            WEATHER("WEATHER"),
            INSTAGRAM_PHOTOS_MODULE("INSTAGRAM_PHOTOS_MODULE"),
            DEFINITION("DEFINITION"),
            SENTIMENT("SENTIMENT"),
            COMMERCE_B2C("COMMERCE_B2C"),
            COMMERCE_C2C("COMMERCE_C2C"),
            COMMERCE_COMBINED("COMMERCE_COMBINED"),
            MUTUALITY_MODULE("MUTUALITY_MODULE"),
            SAFETY_CHECK("SAFETY_CHECK"),
            PROGRAMMATIC_NEWS_CONTEXT("PROGRAMMATIC_NEWS_CONTEXT"),
            EXTERNAL_ACCOUNTS_MODULE("EXTERNAL_ACCOUNTS_MODULE"),
            LINKEDIN_RESUME("LINKEDIN_RESUME"),
            TOPIC_MEDIA("TOPIC_MEDIA"),
            MEDIA_SOCIAL("MEDIA_SOCIAL"),
            MEDIA_COMBINED("MEDIA_COMBINED"),
            MEDIA_WEB("MEDIA_WEB"),
            SIMILAR_PEOPLE_MODULE("SIMILAR_PEOPLE_MODULE"),
            NAVIGATIONAL_LINKS("NAVIGATIONAL_LINKS"),
            MUSIC_LINKS("MUSIC_LINKS"),
            PLACES_SET_SEARCH("PLACES_SET_SEARCH"),
            PLACES_IN("PLACES_IN"),
            PLACES_NEARBY("PLACES_NEARBY"),
            GRAMMAR_QUERY_ENTITY_MODULE("GRAMMAR_QUERY_ENTITY_MODULE"),
            VOTING_ACTIONS("VOTING_ACTIONS"),
            TIMELINE_HEADER("TIMELINE_HEADER"),
            TIMELINE_HEADER_CARD("TIMELINE_HEADER_CARD"),
            SERP_HEADER("SERP_HEADER"),
            POSTS_SET_CELEBRITIES("POSTS_SET_CELEBRITIES"),
            POSTS_SET_CELEBRITIES_MENTION("POSTS_SET_CELEBRITIES_MENTION"),
            POSTS_SET_VITAL_AUTHORS("POSTS_SET_VITAL_AUTHORS"),
            POSTS_SET_RELATED_AUTHORS("POSTS_SET_RELATED_AUTHORS"),
            POSTS_SET_REVIEWS("POSTS_SET_REVIEWS"),
            POSTS_SET_REVIEWS_PEOPLE("POSTS_SET_REVIEWS_PEOPLE"),
            POSTS_SET_EXPERIENTIAL("POSTS_SET_EXPERIENTIAL"),
            POSTS_SET_HOW_TO("POSTS_SET_HOW_TO"),
            POSTS_SET_RECIPES("POSTS_SET_RECIPES"),
            POSTS_SET_MINUTIAE("POSTS_SET_MINUTIAE"),
            POSTS_SET_FEATURED("POSTS_SET_FEATURED"),
            POSTS_SET_GOVERNMENT("POSTS_SET_GOVERNMENT"),
            POSTS_SET_TOPIC_1("POSTS_SET_TOPIC_1"),
            POSTS_SET_TOPIC_2("POSTS_SET_TOPIC_2"),
            POSTS_SET_TOPIC_3("POSTS_SET_TOPIC_3"),
            POSTS_SET_RECENT_TOP("POSTS_SET_RECENT_TOP"),
            POSTS_SET_COMMENTARY("POSTS_SET_COMMENTARY"),
            POSTS_SET_ENGAGEMENT("POSTS_SET_ENGAGEMENT"),
            POSTS_SET_LOCATION("POSTS_SET_LOCATION"),
            POSTS_SET_CONTENTS("POSTS_SET_CONTENTS"),
            POSTS_SET_BEHIND_THE_SCENE("POSTS_SET_BEHIND_THE_SCENE"),
            POST_SET("POST_SET"),
            PUBLIC_POST_SEE_MORE("PUBLIC_POST_SEE_MORE"),
            EMPTY_ENTITY("EMPTY_ENTITY"),
            ENTITY_PIVOTS("ENTITY_PIVOTS"),
            ENTITY_USER("ENTITY_USER"),
            ENTITY_PAGES("ENTITY_PAGES"),
            ENTITY_EVENTS("ENTITY_EVENTS"),
            ENTITY_PLACES("ENTITY_PLACES"),
            ENTITY_GROUPS("ENTITY_GROUPS"),
            ENTITY_APPS("ENTITY_APPS"),
            POSTS("POSTS"),
            POSTS_CONTENTS("POSTS_CONTENTS"),
            VIDEO_MODULE("VIDEO_MODULE");
            
            protected final String serverValue;

            private SupportedRoles(String str) {
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
}
