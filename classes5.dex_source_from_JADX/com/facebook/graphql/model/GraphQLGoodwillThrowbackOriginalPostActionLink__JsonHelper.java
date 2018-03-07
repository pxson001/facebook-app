package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: getTotalTcpBytesSent */
public final class GraphQLGoodwillThrowbackOriginalPostActionLink__JsonHelper {
    public static GraphQLGoodwillThrowbackOriginalPostActionLink m8060a(JsonParser jsonParser) {
        GraphQLGoodwillThrowbackOriginalPostActionLink graphQLGoodwillThrowbackOriginalPostActionLink = new GraphQLGoodwillThrowbackOriginalPostActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("title".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLGoodwillThrowbackOriginalPostActionLink.f4027d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackOriginalPostActionLink, "title", graphQLGoodwillThrowbackOriginalPostActionLink.a_, 0, false);
            } else if ("url".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLGoodwillThrowbackOriginalPostActionLink.f4028e = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackOriginalPostActionLink, "url", graphQLGoodwillThrowbackOriginalPostActionLink.a_, 1, false);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGoodwillThrowbackOriginalPostActionLink;
    }
}
