package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_event_draft */
public final class GraphQLBylineFragment__JsonHelper {
    public static GraphQLBylineFragment m6711a(JsonParser jsonParser) {
        GraphQLBylineFragment graphQLBylineFragment = new GraphQLBylineFragment();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("concise_text".equals(i)) {
                GraphQLTextWithEntities graphQLTextWithEntities;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = null;
                } else {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "concise_text"));
                }
                graphQLBylineFragment.d = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLBylineFragment, "concise_text", graphQLBylineFragment.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLBylineFragment;
    }

    public static void m6712a(JsonGenerator jsonGenerator, GraphQLBylineFragment graphQLBylineFragment, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLBylineFragment.a() != null) {
            jsonGenerator.a("concise_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLBylineFragment.a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
