package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLImportantReactorsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: flight_gate_label */
public class GraphQLImportantReactorsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLImportantReactorsConnection.class, new GraphQLImportantReactorsConnection$Deserializer());
    }

    public Object m8635a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLImportantReactorsConnectionDeserializer.m5232a(jsonParser, (short) 554);
        Object graphQLImportantReactorsConnection = new GraphQLImportantReactorsConnection();
        ((BaseModel) graphQLImportantReactorsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLImportantReactorsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLImportantReactorsConnection).a();
        }
        return graphQLImportantReactorsConnection;
    }
}
