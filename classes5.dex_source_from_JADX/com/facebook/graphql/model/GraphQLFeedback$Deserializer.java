package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFeedbackDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: home_team_object */
public class GraphQLFeedback$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedback.class, new GraphQLFeedback$Deserializer());
    }

    public Object m7473a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFeedbackDeserializer.m4893a(jsonParser, (short) 43);
        Object graphQLFeedback = new GraphQLFeedback();
        ((BaseModel) graphQLFeedback).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFeedback instanceof Postprocessable) {
            return ((Postprocessable) graphQLFeedback).a();
        }
        return graphQLFeedback;
    }
}
