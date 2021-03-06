package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFeedTopicContentDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: hovercard */
public class GraphQLFeedTopicContent$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedTopicContent.class, new GraphQLFeedTopicContent$Deserializer());
    }

    public Object m7461a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFeedTopicContentDeserializer.m4883a(jsonParser, (short) 205);
        Object graphQLFeedTopicContent = new GraphQLFeedTopicContent();
        ((BaseModel) graphQLFeedTopicContent).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFeedTopicContent instanceof Postprocessable) {
            return ((Postprocessable) graphQLFeedTopicContent).a();
        }
        return graphQLFeedTopicContent;
    }
}
