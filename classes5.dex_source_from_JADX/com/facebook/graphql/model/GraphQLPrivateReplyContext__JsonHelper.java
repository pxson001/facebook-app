package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLPrivateReplyStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VOTE_NOW */
public final class GraphQLPrivateReplyContext__JsonHelper {
    public static GraphQLPrivateReplyContext m21039a(JsonParser jsonParser) {
        GraphQLPrivateReplyContext graphQLPrivateReplyContext = new GraphQLPrivateReplyContext();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21041a(graphQLPrivateReplyContext, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPrivateReplyContext;
    }

    private static boolean m21041a(GraphQLPrivateReplyContext graphQLPrivateReplyContext, String str, JsonParser jsonParser) {
        if ("has_reply_permission".equals(str)) {
            boolean z;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                z = false;
            } else {
                z = jsonParser.H();
            }
            graphQLPrivateReplyContext.d = z;
            FieldAccessQueryTracker.a(jsonParser, graphQLPrivateReplyContext, "has_reply_permission", graphQLPrivateReplyContext.a_, 0, false);
            return true;
        } else if ("page".equals(str)) {
            graphQLPrivateReplyContext.e = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "page"));
            FieldAccessQueryTracker.a(jsonParser, graphQLPrivateReplyContext, "page", graphQLPrivateReplyContext.B_(), 1, true);
            return true;
        } else if (!"status".equals(str)) {
            return false;
        } else {
            graphQLPrivateReplyContext.f = GraphQLPrivateReplyStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPrivateReplyContext, "status", graphQLPrivateReplyContext.B_(), 2, false);
            return true;
        }
    }

    public static void m21040a(JsonGenerator jsonGenerator, GraphQLPrivateReplyContext graphQLPrivateReplyContext, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("has_reply_permission", graphQLPrivateReplyContext.a());
        if (graphQLPrivateReplyContext.j() != null) {
            jsonGenerator.a("page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLPrivateReplyContext.j(), true);
        }
        if (graphQLPrivateReplyContext.k() != null) {
            jsonGenerator.a("status", graphQLPrivateReplyContext.k().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
