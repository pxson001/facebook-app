package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getUserTime */
public class GraphQLGoodwillThrowbackMissedMemoriesStorySerializer extends JsonSerializer<GraphQLGoodwillThrowbackMissedMemoriesStory> {
    public final void m8050a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackMissedMemoriesStory graphQLGoodwillThrowbackMissedMemoriesStory = (GraphQLGoodwillThrowbackMissedMemoriesStory) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillThrowbackMissedMemoriesStory.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGoodwillThrowbackMissedMemoriesStory.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("fetchTimeMs", graphQLGoodwillThrowbackMissedMemoriesStory.T_());
        jsonGenerator.a("photo_attachments");
        if (graphQLGoodwillThrowbackMissedMemoriesStory.m8040a() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLGoodwillThrowbackMissedMemoriesStory.m8040a()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("photo_stories");
        if (graphQLGoodwillThrowbackMissedMemoriesStory.m8043b() != null) {
            jsonGenerator.d();
            for (GraphQLStory graphQLStory : graphQLGoodwillThrowbackMissedMemoriesStory.m8043b()) {
                if (graphQLStory != null) {
                    GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLStory, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillThrowbackMissedMemoriesStory.m8048k() != null) {
            jsonGenerator.a("section_header");
            GraphQLGoodwillThrowbackSection__JsonHelper.m8117a(jsonGenerator, graphQLGoodwillThrowbackMissedMemoriesStory.m8048k(), true);
        }
        if (graphQLGoodwillThrowbackMissedMemoriesStory.m8044c() != null) {
            jsonGenerator.a("render_style", graphQLGoodwillThrowbackMissedMemoriesStory.m8044c());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackMissedMemoriesStory.class, new GraphQLGoodwillThrowbackMissedMemoriesStorySerializer());
    }
}
