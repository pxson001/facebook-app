package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_prefilled */
public class GraphQLAudienceInfoSerializer extends JsonSerializer<GraphQLAudienceInfo> {
    public final void m6622a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAudienceInfo__JsonHelper.a(jsonGenerator, (GraphQLAudienceInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAudienceInfo.class, new GraphQLAudienceInfoSerializer());
    }
}
