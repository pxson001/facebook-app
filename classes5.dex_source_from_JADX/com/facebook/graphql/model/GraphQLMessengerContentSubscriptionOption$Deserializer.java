package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLMessengerContentSubscriptionOptionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: fact_time */
public class GraphQLMessengerContentSubscriptionOption$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMessengerContentSubscriptionOption.class, new GraphQLMessengerContentSubscriptionOption$Deserializer());
    }

    public Object m9108a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLMessengerContentSubscriptionOptionDeserializer.m5368a(jsonParser, (short) 527);
        Object graphQLMessengerContentSubscriptionOption = new GraphQLMessengerContentSubscriptionOption();
        ((BaseModel) graphQLMessengerContentSubscriptionOption).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLMessengerContentSubscriptionOption instanceof Postprocessable) {
            return ((Postprocessable) graphQLMessengerContentSubscriptionOption).a();
        }
        return graphQLMessengerContentSubscriptionOption;
    }
}
