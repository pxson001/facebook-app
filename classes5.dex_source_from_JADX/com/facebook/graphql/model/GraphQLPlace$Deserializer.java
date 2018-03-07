package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPlaceDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WEB_SEARCH */
public class GraphQLPlace$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlace.class, new GraphQLPlace$Deserializer());
    }

    public Object m20834a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPlaceDeserializer.m5639a(jsonParser, (short) 158);
        Object graphQLPlace = new GraphQLPlace();
        ((BaseModel) graphQLPlace).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPlace instanceof Postprocessable) {
            return ((Postprocessable) graphQLPlace).a();
        }
        return graphQLPlace;
    }
}
