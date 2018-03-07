package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventWatchersConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: imagePortrait */
public class GraphQLEventWatchersConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventWatchersConnection.class, new GraphQLEventWatchersConnection$Deserializer());
    }

    public Object m7328a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventWatchersConnectionDeserializer.m4846a(jsonParser, (short) 299);
        Object graphQLEventWatchersConnection = new GraphQLEventWatchersConnection();
        ((BaseModel) graphQLEventWatchersConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEventWatchersConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLEventWatchersConnection).a();
        }
        return graphQLEventWatchersConnection;
    }
}
