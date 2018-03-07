package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStatelessLargeImagePLAsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Unknown */
public class GraphQLStatelessLargeImagePLAsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStatelessLargeImagePLAsConnection.class, new GraphQLStatelessLargeImagePLAsConnection$Deserializer());
    }

    public Object m21817a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStatelessLargeImagePLAsConnectionDeserializer.m5940a(jsonParser, (short) 380);
        Object graphQLStatelessLargeImagePLAsConnection = new GraphQLStatelessLargeImagePLAsConnection();
        ((BaseModel) graphQLStatelessLargeImagePLAsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStatelessLargeImagePLAsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLStatelessLargeImagePLAsConnection).a();
        }
        return graphQLStatelessLargeImagePLAsConnection;
    }
}
