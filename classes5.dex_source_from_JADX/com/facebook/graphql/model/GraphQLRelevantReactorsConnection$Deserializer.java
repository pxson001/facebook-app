package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLRelevantReactorsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIDEO_LIST */
public class GraphQLRelevantReactorsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLRelevantReactorsConnection.class, new GraphQLRelevantReactorsConnection$Deserializer());
    }

    public Object m21384a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLRelevantReactorsConnectionDeserializer.m5805a(jsonParser, (short) 542);
        Object graphQLRelevantReactorsConnection = new GraphQLRelevantReactorsConnection();
        ((BaseModel) graphQLRelevantReactorsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLRelevantReactorsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLRelevantReactorsConnection).a();
        }
        return graphQLRelevantReactorsConnection;
    }
}
