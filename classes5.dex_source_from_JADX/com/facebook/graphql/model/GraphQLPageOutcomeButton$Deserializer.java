package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPageOutcomeButtonDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: enabled_favorite_icon */
public class GraphQLPageOutcomeButton$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageOutcomeButton.class, new GraphQLPageOutcomeButton$Deserializer());
    }

    public Object m9502a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPageOutcomeButtonDeserializer.m5516a(jsonParser, (short) 540);
        Object graphQLPageOutcomeButton = new GraphQLPageOutcomeButton();
        ((BaseModel) graphQLPageOutcomeButton).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPageOutcomeButton instanceof Postprocessable) {
            return ((Postprocessable) graphQLPageOutcomeButton).a();
        }
        return graphQLPageOutcomeButton;
    }
}
