package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: end_time_in_sec */
public class GraphQLPageInfoSerializer extends JsonSerializer<GraphQLPageInfo> {
    public final void m9489a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageInfo__JsonHelper.a(jsonGenerator, (GraphQLPageInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPageInfo.class, new GraphQLPageInfoSerializer());
    }
}
