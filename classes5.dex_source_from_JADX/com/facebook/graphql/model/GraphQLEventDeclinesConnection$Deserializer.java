package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventDeclinesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: inline_actions */
public class GraphQLEventDeclinesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventDeclinesConnection.class, new GraphQLEventDeclinesConnection$Deserializer());
    }

    public Object m7165a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventDeclinesConnectionDeserializer.m4786a(jsonParser, (short) 310);
        Object graphQLEventDeclinesConnection = new GraphQLEventDeclinesConnection();
        ((BaseModel) graphQLEventDeclinesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEventDeclinesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLEventDeclinesConnection).a();
        }
        return graphQLEventDeclinesConnection;
    }
}
