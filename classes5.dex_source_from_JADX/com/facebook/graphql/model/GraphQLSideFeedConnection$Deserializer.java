package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSideFeedConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VERTEX_ADD_A_CATEGORY */
public class GraphQLSideFeedConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSideFeedConnection.class, new GraphQLSideFeedConnection$Deserializer());
    }

    public Object m21633a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSideFeedConnectionDeserializer.m5881a(jsonParser, (short) 496);
        Object graphQLSideFeedConnection = new GraphQLSideFeedConnection();
        ((BaseModel) graphQLSideFeedConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSideFeedConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLSideFeedConnection).a();
        }
        return graphQLSideFeedConnection;
    }
}
