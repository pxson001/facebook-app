package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: largePortraitImage */
public class GraphQLAdGeoLocationSerializer extends JsonSerializer<GraphQLAdGeoLocation> {
    public final void m6448a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAdGeoLocation graphQLAdGeoLocation = (GraphQLAdGeoLocation) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLAdGeoLocation.m6433a() != null) {
            jsonGenerator.a("address", graphQLAdGeoLocation.m6433a());
        }
        if (graphQLAdGeoLocation.m6435j() != null) {
            jsonGenerator.a("country_code", graphQLAdGeoLocation.m6435j());
        }
        if (graphQLAdGeoLocation.m6436k() != null) {
            jsonGenerator.a("display_name", graphQLAdGeoLocation.m6436k());
        }
        if (graphQLAdGeoLocation.m6437l() != null) {
            jsonGenerator.a("distance_unit", graphQLAdGeoLocation.m6437l());
        }
        if (graphQLAdGeoLocation.m6438m() != null) {
            jsonGenerator.a("key", graphQLAdGeoLocation.m6438m());
        }
        jsonGenerator.a("latitude", graphQLAdGeoLocation.m6439n());
        if (graphQLAdGeoLocation.m6440o() != null) {
            jsonGenerator.a("location_type", graphQLAdGeoLocation.m6440o().toString());
        }
        jsonGenerator.a("longitude", graphQLAdGeoLocation.m6441p());
        if (graphQLAdGeoLocation.m6442q() != null) {
            jsonGenerator.a("name", graphQLAdGeoLocation.m6442q());
        }
        jsonGenerator.a("radius", graphQLAdGeoLocation.m6443r());
        if (graphQLAdGeoLocation.m6444s() != null) {
            jsonGenerator.a("region_key", graphQLAdGeoLocation.m6444s());
        }
        jsonGenerator.a("supports_city", graphQLAdGeoLocation.m6445t());
        jsonGenerator.a("supports_region", graphQLAdGeoLocation.m6446u());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLAdGeoLocation.class, new GraphQLAdGeoLocationSerializer());
    }
}
