package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: encoding_tags */
public class GraphQLPageMenuInfoSerializer extends JsonSerializer<GraphQLPageMenuInfo> {
    public final void m9499a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageMenuInfo__JsonHelper.m9501a(jsonGenerator, (GraphQLPageMenuInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPageMenuInfo.class, new GraphQLPageMenuInfoSerializer());
    }
}
