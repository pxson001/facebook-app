package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_list_title */
public class GraphQLAdsInterestDeserializer extends FbJsonDeserializer {
    public Object m6495a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLAdsInterest graphQLAdsInterest = new GraphQLAdsInterest();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLAdsInterest = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("id".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLAdsInterest.f3311d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdsInterest, "id", graphQLAdsInterest.a_, 0, false);
                } else if ("name".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLAdsInterest.f3312e = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdsInterest, "name", graphQLAdsInterest.a_, 1, false);
                } else if ("url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLAdsInterest.f3313f = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLAdsInterest, "url", graphQLAdsInterest.a_, 2, false);
                }
                jsonParser.f();
            }
        }
        return graphQLAdsInterest;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAdsInterest.class, new GraphQLAdsInterestDeserializer());
    }

    public GraphQLAdsInterestDeserializer() {
        a(GraphQLAdsInterest.class);
    }
}
