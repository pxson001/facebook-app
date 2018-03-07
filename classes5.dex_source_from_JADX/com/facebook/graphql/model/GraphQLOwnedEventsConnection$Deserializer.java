package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLOwnedEventsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: error_text */
public class GraphQLOwnedEventsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLOwnedEventsConnection.class, new GraphQLOwnedEventsConnection$Deserializer());
    }

    public Object m9431a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLOwnedEventsConnectionDeserializer.m5477a(jsonParser, (short) 316);
        Object graphQLOwnedEventsConnection = new GraphQLOwnedEventsConnection();
        ((BaseModel) graphQLOwnedEventsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLOwnedEventsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLOwnedEventsConnection).a();
        }
        return graphQLOwnedEventsConnection;
    }
}
