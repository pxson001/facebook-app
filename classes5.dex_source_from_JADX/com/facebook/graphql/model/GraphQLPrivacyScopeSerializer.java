package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Video */
public class GraphQLPrivacyScopeSerializer extends JsonSerializer<GraphQLPrivacyScope> {
    public final void m21032a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, (GraphQLPrivacyScope) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyScope.class, new GraphQLPrivacyScopeSerializer());
    }
}
