package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friend_msite */
public class GraphQLGroupMallHoistedStoriesActionLinkSerializer extends JsonSerializer<GraphQLGroupMallHoistedStoriesActionLink> {
    public final void m8446a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupMallHoistedStoriesActionLink graphQLGroupMallHoistedStoriesActionLink = (GraphQLGroupMallHoistedStoriesActionLink) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        jsonGenerator.a("hoisted_story_ids");
        if (graphQLGroupMallHoistedStoriesActionLink.m8442a() != null) {
            jsonGenerator.d();
            for (String str : graphQLGroupMallHoistedStoriesActionLink.m8442a()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGroupMallHoistedStoriesActionLink.m8443j() != null) {
            jsonGenerator.a("title", graphQLGroupMallHoistedStoriesActionLink.m8443j());
        }
        if (graphQLGroupMallHoistedStoriesActionLink.m8444k() != null) {
            jsonGenerator.a("url", graphQLGroupMallHoistedStoriesActionLink.m8444k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGroupMallHoistedStoriesActionLink.class, new GraphQLGroupMallHoistedStoriesActionLinkSerializer());
    }
}
