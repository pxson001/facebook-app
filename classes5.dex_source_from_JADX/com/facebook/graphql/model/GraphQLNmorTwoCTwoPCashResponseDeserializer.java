package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offset_y */
public class GraphQLNmorTwoCTwoPCashResponseDeserializer extends FbJsonDeserializer {
    public Object m9272a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLNmorTwoCTwoPCashResponse graphQLNmorTwoCTwoPCashResponse = new GraphQLNmorTwoCTwoPCashResponse();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLNmorTwoCTwoPCashResponse = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("id".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLNmorTwoCTwoPCashResponse.f4560d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNmorTwoCTwoPCashResponse, "id", graphQLNmorTwoCTwoPCashResponse.a_, 0, false);
                } else if ("instructions_url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLNmorTwoCTwoPCashResponse.f4561e = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNmorTwoCTwoPCashResponse, "instructions_url", graphQLNmorTwoCTwoPCashResponse.a_, 1, false);
                } else if ("url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLNmorTwoCTwoPCashResponse.f4562f = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNmorTwoCTwoPCashResponse, "url", graphQLNmorTwoCTwoPCashResponse.a_, 2, false);
                }
                jsonParser.f();
            }
        }
        return graphQLNmorTwoCTwoPCashResponse;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNmorTwoCTwoPCashResponse.class, new GraphQLNmorTwoCTwoPCashResponseDeserializer());
    }

    public GraphQLNmorTwoCTwoPCashResponseDeserializer() {
        a(GraphQLNmorTwoCTwoPCashResponse.class);
    }
}
