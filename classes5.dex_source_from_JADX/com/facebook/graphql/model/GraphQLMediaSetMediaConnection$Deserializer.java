package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLMediaSetMediaConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: family_request */
public class GraphQLMediaSetMediaConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMediaSetMediaConnection.class, new GraphQLMediaSetMediaConnection$Deserializer());
    }

    public Object m9069a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLMediaSetMediaConnectionDeserializer.m5359a(jsonParser, (short) 218);
        Object graphQLMediaSetMediaConnection = new GraphQLMediaSetMediaConnection();
        ((BaseModel) graphQLMediaSetMediaConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLMediaSetMediaConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLMediaSetMediaConnection).a();
        }
        return graphQLMediaSetMediaConnection;
    }
}
