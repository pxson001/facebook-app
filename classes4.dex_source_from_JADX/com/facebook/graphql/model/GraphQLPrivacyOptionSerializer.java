package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: signaling */
public class GraphQLPrivacyOptionSerializer extends JsonSerializer<GraphQLPrivacyOption> {
    public final void m2382a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyOption__JsonHelper.m2256a(jsonGenerator, (GraphQLPrivacyOption) obj, true);
    }

    static {
        FbSerializerProvider.m277a(GraphQLPrivacyOption.class, new GraphQLPrivacyOptionSerializer());
    }
}
