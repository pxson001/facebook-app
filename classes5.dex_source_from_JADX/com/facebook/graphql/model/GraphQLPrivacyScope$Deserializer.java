package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPrivacyScopeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Video Call */
public class GraphQLPrivacyScope$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyScope.class, new GraphQLPrivacyScope$Deserializer());
    }

    public Object m21029a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPrivacyScopeDeserializer.m5706a(jsonParser, (short) 142);
        Object graphQLPrivacyScope = new GraphQLPrivacyScope();
        ((BaseModel) graphQLPrivacyScope).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPrivacyScope instanceof Postprocessable) {
            return ((Postprocessable) graphQLPrivacyScope).a();
        }
        return graphQLPrivacyScope;
    }
}
