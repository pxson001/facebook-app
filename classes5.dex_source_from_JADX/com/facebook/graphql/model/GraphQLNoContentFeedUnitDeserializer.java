package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offset_x */
public class GraphQLNoContentFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m9276a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLNoContentFeedUnit graphQLNoContentFeedUnit = new GraphQLNoContentFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLNoContentFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                int i2;
                if ("__type__".equals(i)) {
                    graphQLNoContentFeedUnit.d = GraphQLObjectType.a(jsonParser);
                    i2 = 1;
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLNoContentFeedUnit.e = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNoContentFeedUnit, "fetchTimeMs", graphQLNoContentFeedUnit.a_, 0, false);
                    i2 = 1;
                }
                jsonParser.f();
            }
        }
        return graphQLNoContentFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNoContentFeedUnit.class, new GraphQLNoContentFeedUnitDeserializer());
    }

    public GraphQLNoContentFeedUnitDeserializer() {
        a(GraphQLNoContentFeedUnit.class);
    }
}
