package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: item_details */
public class GraphQLAppListSerializer extends JsonSerializer<GraphQLAppList> {
    public final void m6568a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAppList graphQLAppList = (GraphQLAppList) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLAppList.m6565j() != null) {
            jsonGenerator.a("id", graphQLAppList.m6565j());
        }
        if (graphQLAppList.m6566k() != null) {
            jsonGenerator.a("url", graphQLAppList.m6566k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLAppList.class, new GraphQLAppListSerializer());
    }
}
