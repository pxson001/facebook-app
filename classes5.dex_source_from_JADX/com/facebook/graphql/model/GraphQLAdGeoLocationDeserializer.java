package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLAdGeoLocationType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_recommendation_page */
public class GraphQLAdGeoLocationDeserializer extends FbJsonDeserializer {
    public Object m6447a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLAdGeoLocation graphQLAdGeoLocation = new GraphQLAdGeoLocation();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLAdGeoLocation = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("address".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLAdGeoLocation.f3293d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "address", graphQLAdGeoLocation.a_, 0, false);
                } else if ("country_code".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLAdGeoLocation.f3294e = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "country_code", graphQLAdGeoLocation.a_, 1, false);
                } else if ("display_name".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLAdGeoLocation.f3295f = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "display_name", graphQLAdGeoLocation.a_, 2, false);
                } else if ("distance_unit".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLAdGeoLocation.f3296g = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "distance_unit", graphQLAdGeoLocation.a_, 3, false);
                } else if ("key".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLAdGeoLocation.f3297h = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "key", graphQLAdGeoLocation.a_, 4, false);
                } else if ("latitude".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = 0.0d;
                    } else {
                        r4 = jsonParser.G();
                    }
                    graphQLAdGeoLocation.f3298i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "latitude", graphQLAdGeoLocation.a_, 5, false);
                } else if ("location_type".equals(i)) {
                    graphQLAdGeoLocation.f3299j = GraphQLAdGeoLocationType.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "location_type", graphQLAdGeoLocation.a_, 6, false);
                } else if ("longitude".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = 0.0d;
                    } else {
                        r4 = jsonParser.G();
                    }
                    graphQLAdGeoLocation.f3300k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "longitude", graphQLAdGeoLocation.a_, 7, false);
                } else if ("name".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLAdGeoLocation.f3301l = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "name", graphQLAdGeoLocation.a_, 8, false);
                } else if ("radius".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = 0.0d;
                    } else {
                        r4 = jsonParser.G();
                    }
                    graphQLAdGeoLocation.f3302m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "radius", graphQLAdGeoLocation.a_, 9, false);
                } else if ("region_key".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLAdGeoLocation.f3303n = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "region_key", graphQLAdGeoLocation.a_, 10, false);
                } else if ("supports_city".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = false;
                    } else {
                        r4 = jsonParser.H();
                    }
                    graphQLAdGeoLocation.f3304o = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "supports_city", graphQLAdGeoLocation.a_, 11, false);
                } else if ("supports_region".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = false;
                    } else {
                        r4 = jsonParser.H();
                    }
                    graphQLAdGeoLocation.f3305p = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdGeoLocation, "supports_region", graphQLAdGeoLocation.a_, 12, false);
                }
                jsonParser.f();
            }
        }
        return graphQLAdGeoLocation;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAdGeoLocation.class, new GraphQLAdGeoLocationDeserializer());
    }

    public GraphQLAdGeoLocationDeserializer() {
        a(GraphQLAdGeoLocation.class);
    }
}
