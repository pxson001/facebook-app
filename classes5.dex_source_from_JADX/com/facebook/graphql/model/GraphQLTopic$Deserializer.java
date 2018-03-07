package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTopicDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UFILastFeedbackQuery */
public class GraphQLTopic$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTopic.class, new GraphQLTopic$Deserializer());
    }

    public Object m22257a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTopicDeserializer.m6114a(jsonParser, (short) 193);
        Object graphQLTopic = new GraphQLTopic();
        ((BaseModel) graphQLTopic).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTopic instanceof Postprocessable) {
            return ((Postprocessable) graphQLTopic).a();
        }
        return graphQLTopic;
    }
}
