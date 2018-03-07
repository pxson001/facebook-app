package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: entry_picker */
public final class GraphQLPYMLWithLargeImageFeedUnitsEdge__JsonHelper {
    public static GraphQLPYMLWithLargeImageFeedUnitsEdge m9458a(JsonParser jsonParser) {
        GraphQLPYMLWithLargeImageFeedUnitsEdge graphQLPYMLWithLargeImageFeedUnitsEdge = new GraphQLPYMLWithLargeImageFeedUnitsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLPYMLWithLargeImageFeedUnitItem graphQLPYMLWithLargeImageFeedUnitItem;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPYMLWithLargeImageFeedUnitItem = null;
                } else {
                    graphQLPYMLWithLargeImageFeedUnitItem = GraphQLPYMLWithLargeImageFeedUnitItem__JsonHelper.m9444a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLPYMLWithLargeImageFeedUnitsEdge.d = graphQLPYMLWithLargeImageFeedUnitItem;
                FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnitsEdge, "node", graphQLPYMLWithLargeImageFeedUnitsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPYMLWithLargeImageFeedUnitsEdge;
    }

    public static void m9459a(JsonGenerator jsonGenerator, GraphQLPYMLWithLargeImageFeedUnitsEdge graphQLPYMLWithLargeImageFeedUnitsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPYMLWithLargeImageFeedUnitsEdge.a() != null) {
            jsonGenerator.a("node");
            GraphQLPYMLWithLargeImageFeedUnitItem__JsonHelper.m9445a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitsEdge.a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
