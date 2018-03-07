package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventHostsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: initial_view_roll_degrees */
public class GraphQLEventHostsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventHostsConnection.class, new GraphQLEventHostsConnection$Deserializer());
    }

    public Object m7187a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventHostsConnectionDeserializer.m4798a(jsonParser, (short) 303);
        Object graphQLEventHostsConnection = new GraphQLEventHostsConnection();
        ((BaseModel) graphQLEventHostsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEventHostsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLEventHostsConnection).a();
        }
        return graphQLEventHostsConnection;
    }
}
