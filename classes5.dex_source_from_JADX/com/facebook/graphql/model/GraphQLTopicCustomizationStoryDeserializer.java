package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: minutiae */
public class GraphQLTopicCustomizationStoryDeserializer extends FbJsonDeserializer {
    public Object m22261a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLTopicCustomizationStory graphQLTopicCustomizationStory = new GraphQLTopicCustomizationStory();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLTopicCustomizationStory = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLTopicCustomizationStory__JsonHelper.m22263a(graphQLTopicCustomizationStory, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLTopicCustomizationStory;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTopicCustomizationStory.class, new GraphQLTopicCustomizationStoryDeserializer());
    }

    public GraphQLTopicCustomizationStoryDeserializer() {
        a(GraphQLTopicCustomizationStory.class);
    }
}
