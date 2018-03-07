package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: imageLow */
public class GraphQLEventsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventsConnection.class, new GraphQLEventsConnection$Deserializer());
    }

    public Object m7347a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventsConnectionDeserializer.m4853a(jsonParser, (short) 312);
        Object graphQLEventsConnection = new GraphQLEventsConnection();
        ((BaseModel) graphQLEventsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEventsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLEventsConnection).a();
        }
        return graphQLEventsConnection;
    }
}
