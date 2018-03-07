package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGreetingCardSlidesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: friends_who_visited */
public class GraphQLGreetingCardSlidesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGreetingCardSlidesConnection.class, new GraphQLGreetingCardSlidesConnection$Deserializer());
    }

    public Object m8353a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGreetingCardSlidesConnectionDeserializer.m5134a(jsonParser, (short) 221);
        Object graphQLGreetingCardSlidesConnection = new GraphQLGreetingCardSlidesConnection();
        ((BaseModel) graphQLGreetingCardSlidesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGreetingCardSlidesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLGreetingCardSlidesConnection).a();
        }
        return graphQLGreetingCardSlidesConnection;
    }
}
