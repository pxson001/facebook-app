package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLInteractorsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: feedback_typers */
public class GraphQLInteractorsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInteractorsConnection.class, new GraphQLInteractorsConnection$Deserializer());
    }

    public Object m8741a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLInteractorsConnectionDeserializer.m5272a(jsonParser, (short) 500);
        Object graphQLInteractorsConnection = new GraphQLInteractorsConnection();
        ((BaseModel) graphQLInteractorsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLInteractorsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLInteractorsConnection).a();
        }
        return graphQLInteractorsConnection;
    }
}
