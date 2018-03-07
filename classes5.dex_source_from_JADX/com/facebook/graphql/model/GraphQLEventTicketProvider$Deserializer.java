package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventTicketProviderDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: image_unblock_for_dialtone */
public class GraphQLEventTicketProvider$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventTicketProvider.class, new GraphQLEventTicketProvider$Deserializer());
    }

    public Object m7293a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventTicketProviderDeserializer.m4831a(jsonParser, (short) 568);
        Object graphQLEventTicketProvider = new GraphQLEventTicketProvider();
        ((BaseModel) graphQLEventTicketProvider).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEventTicketProvider instanceof Postprocessable) {
            return ((Postprocessable) graphQLEventTicketProvider).a();
        }
        return graphQLEventTicketProvider;
    }
}
