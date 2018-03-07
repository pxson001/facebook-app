package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: ViewServer */
public final class GraphQLPrivacyAudienceMember__JsonHelper {
    public static GraphQLPrivacyAudienceMember m20981a(JsonParser jsonParser) {
        GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember = new GraphQLPrivacyAudienceMember();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("__type__".equals(i)) {
                GraphQLObjectType graphQLObjectType;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLObjectType = null;
                } else {
                    graphQLObjectType = GraphQLObjectType.a(jsonParser);
                }
                graphQLPrivacyAudienceMember.d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyAudienceMember, "__type__", graphQLPrivacyAudienceMember.a_, 0, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPrivacyAudienceMember.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyAudienceMember, "id", graphQLPrivacyAudienceMember.a_, 1, false);
            } else if ("name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPrivacyAudienceMember.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyAudienceMember, "name", graphQLPrivacyAudienceMember.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLPrivacyAudienceMember;
    }

    public static void m20982a(JsonGenerator jsonGenerator, GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPrivacyAudienceMember.b() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLPrivacyAudienceMember.b().e());
            jsonGenerator.g();
        }
        if (graphQLPrivacyAudienceMember.c() != null) {
            jsonGenerator.a("id", graphQLPrivacyAudienceMember.c());
        }
        if (graphQLPrivacyAudienceMember.d() != null) {
            jsonGenerator.a("name", graphQLPrivacyAudienceMember.d());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
