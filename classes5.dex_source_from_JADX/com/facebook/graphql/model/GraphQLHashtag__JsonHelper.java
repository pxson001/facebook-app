package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: force_update_menu */
public final class GraphQLHashtag__JsonHelper {
    public static boolean m8604a(GraphQLHashtag graphQLHashtag, String str, JsonParser jsonParser) {
        String str2 = null;
        Collection arrayList;
        Object o;
        List copyOf;
        if ("android_urls".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    if (o != null) {
                        arrayList.add(o);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLHashtag.f4249d = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "android_urls", graphQLHashtag.a_, 0, false);
            return true;
        } else if ("feedAwesomizerProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
            }
            graphQLHashtag.f4250e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "feedAwesomizerProfilePicture", graphQLHashtag.B_(), 1, true);
            return true;
        } else if ("hashtag_feed".equals(str)) {
            GraphQLHashtagFeedConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLHashtagFeedConnection__JsonHelper.m8601a(FieldAccessQueryTracker.a(jsonParser, "hashtag_feed"));
            }
            graphQLHashtag.f4251f = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "hashtag_feed", graphQLHashtag.B_(), 2, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLHashtag.f4252g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "id", graphQLHashtag.B_(), 3, false);
            return true;
        } else if ("image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
            }
            graphQLHashtag.f4253h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "image", graphQLHashtag.B_(), 4, true);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLHashtag.f4254i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "imageHighOrig", graphQLHashtag.B_(), 5, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLHashtag.f4255j = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "inline_activities", graphQLHashtag.B_(), 6, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLHashtag.f4256k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "name", graphQLHashtag.B_(), 7, false);
            return true;
        } else if ("name_search_tokens".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    if (o != null) {
                        arrayList.add(o);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLHashtag.f4257l = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "name_search_tokens", graphQLHashtag.B_(), 8, false);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLHashtag.f4258m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "profileImageLarge", graphQLHashtag.B_(), 9, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLHashtag.f4259n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "profileImageSmall", graphQLHashtag.B_(), 10, true);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
            }
            graphQLHashtag.f4260o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "profilePicture50", graphQLHashtag.B_(), 11, true);
            return true;
        } else if ("profilePictureHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
            }
            graphQLHashtag.f4261p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "profilePictureHighRes", graphQLHashtag.B_(), 12, true);
            return true;
        } else if ("profilePictureLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
            }
            graphQLHashtag.f4262q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "profilePictureLarge", graphQLHashtag.B_(), 13, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
            }
            graphQLHashtag.f4263r = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "profile_photo", graphQLHashtag.B_(), 14, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLHashtag.f4264s = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "profile_picture", graphQLHashtag.B_(), 15, true);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLHashtag.f4265t = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "profile_picture_is_silhouette", graphQLHashtag.B_(), 16, false);
            return true;
        } else if ("related_article_title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLHashtag.f4266u = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "related_article_title", graphQLHashtag.B_(), 17, false);
            return true;
        } else if ("social_context".equals(str)) {
            GraphQLTextWithEntities a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLHashtag.f4267v = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "social_context", graphQLHashtag.B_(), 18, true);
            return true;
        } else if ("streaming_profile_picture".equals(str)) {
            GraphQLStreamingImage a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
            }
            graphQLHashtag.f4268w = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "streaming_profile_picture", graphQLHashtag.B_(), 19, true);
            return true;
        } else if ("tag".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLHashtag.f4269x = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "tag", graphQLHashtag.B_(), 20, false);
            return true;
        } else if ("taggable_object_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
            }
            graphQLHashtag.f4270y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "taggable_object_profile_picture", graphQLHashtag.B_(), 21, true);
            return true;
        } else if ("top_headline_object".equals(str)) {
            GraphQLNode a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "top_headline_object"));
            }
            graphQLHashtag.f4271z = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "top_headline_object", graphQLHashtag.B_(), 22, true);
            return true;
        } else if ("topic_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "topic_image"));
            }
            graphQLHashtag.f4245A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "topic_image", graphQLHashtag.B_(), 23, true);
            return true;
        } else if ("trending_topic_data".equals(str)) {
            GraphQLTrendingTopicData a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLTrendingTopicData__JsonHelper.m22301a(FieldAccessQueryTracker.a(jsonParser, "trending_topic_data"));
            }
            graphQLHashtag.f4246B = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "trending_topic_data", graphQLHashtag.B_(), 24, true);
            return true;
        } else if ("trending_topic_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLHashtag.f4247C = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "trending_topic_name", graphQLHashtag.B_(), 25, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLHashtag.f4248D = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLHashtag, "url", graphQLHashtag.B_(), 26, false);
            return true;
        }
    }
}
