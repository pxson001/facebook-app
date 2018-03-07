package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventMaybesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: index value outside legal index range [0.. */
public class GraphQLEventMaybesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventMaybesConnection.class, new GraphQLEventMaybesConnection$Deserializer());
    }

    public Object m7220a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventMaybesConnectionDeserializer.m4811a(jsonParser, (short) 307);
        Object graphQLEventMaybesConnection = new GraphQLEventMaybesConnection();
        ((BaseModel) graphQLEventMaybesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEventMaybesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLEventMaybesConnection).a();
        }
        return graphQLEventMaybesConnection;
    }
}
