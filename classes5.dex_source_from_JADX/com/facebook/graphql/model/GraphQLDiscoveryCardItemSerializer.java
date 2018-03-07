package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_place_picker_context_menu_report_dup */
public class GraphQLDiscoveryCardItemSerializer extends JsonSerializer<GraphQLDiscoveryCardItem> {
    public final void m6949a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLDiscoveryCardItem graphQLDiscoveryCardItem = (GraphQLDiscoveryCardItem) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLDiscoveryCardItem.m6947j() != null) {
            jsonGenerator.a("id", graphQLDiscoveryCardItem.m6947j());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLDiscoveryCardItem.class, new GraphQLDiscoveryCardItemSerializer());
    }
}
