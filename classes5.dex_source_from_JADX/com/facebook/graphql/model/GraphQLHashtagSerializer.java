package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: foreground_time_ms */
public class GraphQLHashtagSerializer extends JsonSerializer<GraphQLHashtag> {
    public final void m8603a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLHashtag graphQLHashtag = (GraphQLHashtag) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        jsonGenerator.a("android_urls");
        if (graphQLHashtag.m8576j() != null) {
            jsonGenerator.d();
            for (String str : graphQLHashtag.m8576j()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLHashtag.m8577k() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLHashtag.m8577k(), true);
        }
        if (graphQLHashtag.m8578l() != null) {
            jsonGenerator.a("hashtag_feed");
            GraphQLHashtagFeedConnection__JsonHelper.m8602a(jsonGenerator, graphQLHashtag.m8578l(), true);
        }
        if (graphQLHashtag.m8579m() != null) {
            jsonGenerator.a("id", graphQLHashtag.m8579m());
        }
        if (graphQLHashtag.m8580n() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLHashtag.m8580n(), true);
        }
        if (graphQLHashtag.m8581o() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLHashtag.m8581o(), true);
        }
        if (graphQLHashtag.m8582p() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLHashtag.m8582p(), true);
        }
        if (graphQLHashtag.m8583q() != null) {
            jsonGenerator.a("name", graphQLHashtag.m8583q());
        }
        jsonGenerator.a("name_search_tokens");
        if (graphQLHashtag.m8584r() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLHashtag.m8584r()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLHashtag.m8585s() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLHashtag.m8585s(), true);
        }
        if (graphQLHashtag.m8586t() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLHashtag.m8586t(), true);
        }
        if (graphQLHashtag.m8587u() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLHashtag.m8587u(), true);
        }
        if (graphQLHashtag.m8588v() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLHashtag.m8588v(), true);
        }
        if (graphQLHashtag.m8589w() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLHashtag.m8589w(), true);
        }
        if (graphQLHashtag.m8590x() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLHashtag.m8590x(), true);
        }
        if (graphQLHashtag.m8591y() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLHashtag.m8591y(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLHashtag.m8592z());
        if (graphQLHashtag.m8562A() != null) {
            jsonGenerator.a("related_article_title", graphQLHashtag.m8562A());
        }
        if (graphQLHashtag.m8563B() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLHashtag.m8563B(), true);
        }
        if (graphQLHashtag.m8564C() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLHashtag.m8564C(), true);
        }
        if (graphQLHashtag.m8565D() != null) {
            jsonGenerator.a("tag", graphQLHashtag.m8565D());
        }
        if (graphQLHashtag.m8566E() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLHashtag.m8566E(), true);
        }
        if (graphQLHashtag.m8567F() != null) {
            jsonGenerator.a("top_headline_object");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLHashtag.m8567F(), true);
        }
        if (graphQLHashtag.m8568G() != null) {
            jsonGenerator.a("topic_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLHashtag.m8568G(), true);
        }
        if (graphQLHashtag.m8569H() != null) {
            jsonGenerator.a("trending_topic_data");
            GraphQLTrendingTopicData__JsonHelper.m22302a(jsonGenerator, graphQLHashtag.m8569H(), true);
        }
        if (graphQLHashtag.m8570I() != null) {
            jsonGenerator.a("trending_topic_name", graphQLHashtag.m8570I());
        }
        if (graphQLHashtag.m8571J() != null) {
            jsonGenerator.a("url", graphQLHashtag.m8571J());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLHashtag.class, new GraphQLHashtagSerializer());
    }
}
