package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLAttributionSource;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_required */
public final class GraphQLAttributionEntry__JsonHelper {
    public static GraphQLAttributionEntry m6616a(JsonParser jsonParser) {
        GraphQLAttributionEntry graphQLAttributionEntry = new GraphQLAttributionEntry();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6618a(graphQLAttributionEntry, i, jsonParser);
            jsonParser.f();
        }
        return graphQLAttributionEntry;
    }

    private static boolean m6618a(GraphQLAttributionEntry graphQLAttributionEntry, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("attribution".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "attribution"));
            }
            graphQLAttributionEntry.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLAttributionEntry, "attribution", graphQLAttributionEntry.a_, 0, true);
            return true;
        } else if ("icon".equals(str)) {
            GraphQLEntityCardContextItemIcon a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLEntityCardContextItemIcon__JsonHelper.m7068a(FieldAccessQueryTracker.a(jsonParser, "icon"));
            }
            graphQLAttributionEntry.e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLAttributionEntry, "icon", graphQLAttributionEntry.B_(), 1, true);
            return true;
        } else if ("icon_uri".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLAttributionEntry.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLAttributionEntry, "icon_uri", graphQLAttributionEntry.B_(), 2, false);
            return true;
        } else if (!"source".equals(str)) {
            return false;
        } else {
            graphQLAttributionEntry.g = GraphQLAttributionSource.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLAttributionEntry, "source", graphQLAttributionEntry.B_(), 3, false);
            return true;
        }
    }

    public static void m6617a(JsonGenerator jsonGenerator, GraphQLAttributionEntry graphQLAttributionEntry, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLAttributionEntry.a() != null) {
            jsonGenerator.a("attribution");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLAttributionEntry.a(), true);
        }
        if (graphQLAttributionEntry.j() != null) {
            jsonGenerator.a("icon");
            GraphQLEntityCardContextItemIcon__JsonHelper.m7069a(jsonGenerator, graphQLAttributionEntry.j(), true);
        }
        if (graphQLAttributionEntry.k() != null) {
            jsonGenerator.a("icon_uri", graphQLAttributionEntry.k());
        }
        if (graphQLAttributionEntry.l() != null) {
            jsonGenerator.a("source", graphQLAttributionEntry.l().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
