package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: launching_video_recorder */
public final class GraphQLAYMTNativeMobileAction__JsonHelper {
    public static GraphQLAYMTNativeMobileAction m6365a(JsonParser jsonParser) {
        GraphQLAYMTNativeMobileAction graphQLAYMTNativeMobileAction = new GraphQLAYMTNativeMobileAction();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6367a(graphQLAYMTNativeMobileAction, i, jsonParser);
            jsonParser.f();
        }
        return graphQLAYMTNativeMobileAction;
    }

    private static boolean m6367a(GraphQLAYMTNativeMobileAction graphQLAYMTNativeMobileAction, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            GraphQLObjectType a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLObjectType.a(jsonParser);
            }
            graphQLAYMTNativeMobileAction.f3258d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLAYMTNativeMobileAction, "__type__", graphQLAYMTNativeMobileAction.a_, 0, false);
            return true;
        } else if ("display_text".equals(str)) {
            GraphQLTextWithEntities a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "display_text"));
            }
            graphQLAYMTNativeMobileAction.f3259e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLAYMTNativeMobileAction, "display_text", graphQLAYMTNativeMobileAction.B_(), 1, true);
            return true;
        } else if (!"uri".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLAYMTNativeMobileAction.f3260f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLAYMTNativeMobileAction, "uri", graphQLAYMTNativeMobileAction.B_(), 2, false);
            return true;
        }
    }

    public static void m6366a(JsonGenerator jsonGenerator, GraphQLAYMTNativeMobileAction graphQLAYMTNativeMobileAction, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLAYMTNativeMobileAction.m6359a() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLAYMTNativeMobileAction.m6359a().e());
            jsonGenerator.g();
        }
        if (graphQLAYMTNativeMobileAction.m6361j() != null) {
            jsonGenerator.a("display_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLAYMTNativeMobileAction.m6361j(), true);
        }
        if (graphQLAYMTNativeMobileAction.m6362k() != null) {
            jsonGenerator.a("uri", graphQLAYMTNativeMobileAction.m6362k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
