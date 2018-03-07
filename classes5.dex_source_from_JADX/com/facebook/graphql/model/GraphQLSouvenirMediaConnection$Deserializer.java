package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSouvenirMediaConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UriSerializer.serialize */
public class GraphQLSouvenirMediaConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSouvenirMediaConnection.class, new GraphQLSouvenirMediaConnection$Deserializer());
    }

    public Object m21702a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSouvenirMediaConnectionDeserializer.m5907a(jsonParser, (short) 227);
        Object graphQLSouvenirMediaConnection = new GraphQLSouvenirMediaConnection();
        ((BaseModel) graphQLSouvenirMediaConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSouvenirMediaConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLSouvenirMediaConnection).a();
        }
        return graphQLSouvenirMediaConnection;
    }
}
