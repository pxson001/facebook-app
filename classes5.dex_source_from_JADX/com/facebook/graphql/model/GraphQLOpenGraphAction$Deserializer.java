package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLOpenGraphActionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: event_buy_ticket_url */
public class GraphQLOpenGraphAction$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLOpenGraphAction.class, new GraphQLOpenGraphAction$Deserializer());
    }

    public Object m9391a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLOpenGraphActionDeserializer.m5458a(jsonParser, (short) 75);
        Object graphQLOpenGraphAction = new GraphQLOpenGraphAction();
        ((BaseModel) graphQLOpenGraphAction).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLOpenGraphAction instanceof Postprocessable) {
            return ((Postprocessable) graphQLOpenGraphAction).a();
        }
        return graphQLOpenGraphAction;
    }
}
