package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTopicCustomizationStoryDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UFIFeedbackQuery */
public class GraphQLTopicCustomizationStory$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTopicCustomizationStory.class, new GraphQLTopicCustomizationStory$Deserializer());
    }

    public Object m22259a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTopicCustomizationStoryDeserializer.m6111a(jsonParser, (short) 531);
        Object graphQLTopicCustomizationStory = new GraphQLTopicCustomizationStory();
        ((BaseModel) graphQLTopicCustomizationStory).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTopicCustomizationStory instanceof Postprocessable) {
            return ((Postprocessable) graphQLTopicCustomizationStory).a();
        }
        return graphQLTopicCustomizationStory;
    }
}
