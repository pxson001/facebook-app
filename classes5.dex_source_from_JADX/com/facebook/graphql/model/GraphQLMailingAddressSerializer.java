package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fb_left_nav */
public class GraphQLMailingAddressSerializer extends JsonSerializer<GraphQLMailingAddress> {
    public final void m8983a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMailingAddress graphQLMailingAddress = (GraphQLMailingAddress) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLMailingAddress.m8973j() != null) {
            jsonGenerator.a("address");
            GraphQLStreetAddress__JsonHelper.m21937a(jsonGenerator, graphQLMailingAddress.m8973j(), true);
        }
        if (graphQLMailingAddress.m8974k() != null) {
            jsonGenerator.a("city");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLMailingAddress.m8974k(), true);
        }
        if (graphQLMailingAddress.m8975l() != null) {
            jsonGenerator.a("id", graphQLMailingAddress.m8975l());
        }
        jsonGenerator.a("is_default", graphQLMailingAddress.m8976m());
        jsonGenerator.a("is_messenger_eligible", graphQLMailingAddress.m8977n());
        if (graphQLMailingAddress.m8978o() != null) {
            jsonGenerator.a("label", graphQLMailingAddress.m8978o());
        }
        if (graphQLMailingAddress.m8979p() != null) {
            jsonGenerator.a("url", graphQLMailingAddress.m8979p());
        }
        if (graphQLMailingAddress.m8980q() != null) {
            jsonGenerator.a("city_name", graphQLMailingAddress.m8980q());
        }
        if (graphQLMailingAddress.m8981r() != null) {
            jsonGenerator.a("region_name", graphQLMailingAddress.m8981r());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLMailingAddress.class, new GraphQLMailingAddressSerializer());
    }
}
