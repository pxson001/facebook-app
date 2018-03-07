package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSeenByConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VERTEX_EDIT_BUTTON */
public class GraphQLSeenByConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSeenByConnection.class, new GraphQLSeenByConnection$Deserializer());
    }

    public Object m21629a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSeenByConnectionDeserializer.m5878a(jsonParser, (short) 275);
        Object graphQLSeenByConnection = new GraphQLSeenByConnection();
        ((BaseModel) graphQLSeenByConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSeenByConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLSeenByConnection).a();
        }
        return graphQLSeenByConnection;
    }
}
