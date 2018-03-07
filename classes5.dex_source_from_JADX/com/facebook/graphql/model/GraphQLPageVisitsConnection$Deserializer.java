package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPageVisitsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: email_invite_join_dialogue */
public class GraphQLPageVisitsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageVisitsConnection.class, new GraphQLPageVisitsConnection$Deserializer());
    }

    public Object m9547a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPageVisitsConnectionDeserializer.m5534a(jsonParser, (short) 160);
        Object graphQLPageVisitsConnection = new GraphQLPageVisitsConnection();
        ((BaseModel) graphQLPageVisitsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPageVisitsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPageVisitsConnection).a();
        }
        return graphQLPageVisitsConnection;
    }
}
