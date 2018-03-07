package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPrivacyOptionsComposerConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: View Hierarchy json attached. */
public class GraphQLPrivacyOptionsComposerConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyOptionsComposerConnection.class, new GraphQLPrivacyOptionsComposerConnection$Deserializer());
    }

    public Object m20995a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPrivacyOptionsComposerConnectionDeserializer.m5692a(jsonParser, (short) 461);
        Object graphQLPrivacyOptionsComposerConnection = new GraphQLPrivacyOptionsComposerConnection();
        ((BaseModel) graphQLPrivacyOptionsComposerConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPrivacyOptionsComposerConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPrivacyOptionsComposerConnection).a();
        }
        return graphQLPrivacyOptionsComposerConnection;
    }
}
