package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WIG_STORE */
public final class GraphQLPhotoTagsEdge__JsonHelper {
    public static GraphQLPhotoTagsEdge m20762a(JsonParser jsonParser) {
        GraphQLPhotoTagsEdge graphQLPhotoTagsEdge = new GraphQLPhotoTagsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPhotoTag graphQLPhotoTag = null;
            int i2;
            if ("cursor".equals(i)) {
                String o;
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    o = jsonParser.o();
                }
                graphQLPhotoTagsEdge.f12566d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotoTagsEdge, "cursor", graphQLPhotoTagsEdge.a_, 0, false);
                i2 = 1;
            } else if ("node".equals(i)) {
                GraphQLProfile a;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLPhotoTagsEdge.f12567e = a;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotoTagsEdge, "node", graphQLPhotoTagsEdge.a_, 1, true);
                i2 = 1;
            } else if ("tag".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPhotoTag = GraphQLPhotoTag__JsonHelper.m20744a(FieldAccessQueryTracker.a(jsonParser, "tag"));
                }
                graphQLPhotoTagsEdge.f12568f = graphQLPhotoTag;
                FieldAccessQueryTracker.a(jsonParser, graphQLPhotoTagsEdge, "tag", graphQLPhotoTagsEdge.a_, 2, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLPhotoTagsEdge;
    }

    public static void m20763a(JsonGenerator jsonGenerator, GraphQLPhotoTagsEdge graphQLPhotoTagsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPhotoTagsEdge.m20757a() != null) {
            jsonGenerator.a("cursor", graphQLPhotoTagsEdge.m20757a());
        }
        if (graphQLPhotoTagsEdge.m20758j() != null) {
            jsonGenerator.a("node");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLPhotoTagsEdge.m20758j(), true);
        }
        if (graphQLPhotoTagsEdge.m20759k() != null) {
            jsonGenerator.a("tag");
            GraphQLPhotoTag__JsonHelper.m20745a(jsonGenerator, graphQLPhotoTagsEdge.m20759k(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
