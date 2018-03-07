package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Unexpected JSON values; expected at most  */
public final class GraphQLStatelessLargeImagePLAsEdge__JsonHelper {
    public static GraphQLStatelessLargeImagePLAsEdge m21830a(JsonParser jsonParser) {
        GraphQLStatelessLargeImagePLAsEdge graphQLStatelessLargeImagePLAsEdge = new GraphQLStatelessLargeImagePLAsEdge();
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
                graphQLStatelessLargeImagePLAsEdge.f13075d = graphQLPYMLWithLargeImageFeedUnitItem;
                FieldAccessQueryTracker.a(jsonParser, graphQLStatelessLargeImagePLAsEdge, "node", graphQLStatelessLargeImagePLAsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLStatelessLargeImagePLAsEdge;
    }

    public static void m21831a(JsonGenerator jsonGenerator, GraphQLStatelessLargeImagePLAsEdge graphQLStatelessLargeImagePLAsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLStatelessLargeImagePLAsEdge.m21826a() != null) {
            jsonGenerator.a("node");
            GraphQLPYMLWithLargeImageFeedUnitItem__JsonHelper.m9445a(jsonGenerator, graphQLStatelessLargeImagePLAsEdge.m21826a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
