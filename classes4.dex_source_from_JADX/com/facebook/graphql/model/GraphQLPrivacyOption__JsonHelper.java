package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: sms-takeover/sms_anonymous_chat_head */
public final class GraphQLPrivacyOption__JsonHelper {
    public static GraphQLPrivacyOption m2255a(JsonParser jsonParser) {
        GraphQLPrivacyOption graphQLPrivacyOption = new GraphQLPrivacyOption();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m2257a(graphQLPrivacyOption, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPrivacyOption;
    }

    private static boolean m2257a(GraphQLPrivacyOption graphQLPrivacyOption, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("current_tag_expansion".equals(str)) {
            graphQLPrivacyOption.d = GraphQLPrivacyOptionTagExpansionType.fromString(jsonParser.o());
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOption, "current_tag_expansion", graphQLPrivacyOption.a_, 0, false);
            return true;
        } else if ("excluded_members".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLPrivacyAudienceMember__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "excluded_members"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPrivacyOption.e = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOption, "excluded_members", graphQLPrivacyOption.B_(), 1, true);
            return true;
        } else if ("explanation".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPrivacyOption.f = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOption, "explanation", graphQLPrivacyOption.B_(), 2, false);
            return true;
        } else if ("icon_image".equals(str)) {
            GraphQLImage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "icon_image"));
            }
            graphQLPrivacyOption.g = a;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOption, "icon_image", graphQLPrivacyOption.B_(), 4, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPrivacyOption.h = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOption, "id", graphQLPrivacyOption.B_(), 5, false);
            return true;
        } else if ("included_members".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLPrivacyAudienceMember__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "included_members"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPrivacyOption.i = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOption, "included_members", graphQLPrivacyOption.B_(), 6, true);
            return true;
        } else if ("legacy_graph_api_privacy_json".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPrivacyOption.j = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOption, "legacy_graph_api_privacy_json", graphQLPrivacyOption.B_(), 7, false);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPrivacyOption.k = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOption, "name", graphQLPrivacyOption.B_(), 8, false);
            return true;
        } else if ("privacy_row_input".equals(str)) {
            GraphQLPrivacyRowInput a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLPrivacyRowInput__JsonHelper.m2258a(FieldAccessQueryTracker.m2235a(jsonParser, "privacy_row_input"));
            }
            graphQLPrivacyOption.l = a2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOption, "privacy_row_input", graphQLPrivacyOption.B_(), 9, true);
            return true;
        } else if ("tag_expansion_options".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLPrivacyOptionTagExpansionType fromString = GraphQLPrivacyOptionTagExpansionType.fromString(jsonParser.o());
                    if (fromString != null) {
                        r1.add(fromString);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPrivacyOption.m = r0;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOption, "tag_expansion_options", graphQLPrivacyOption.B_(), 10, false);
            return true;
        } else if ("type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPrivacyOption.n = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOption, "type", graphQLPrivacyOption.B_(), 11, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPrivacyOption.o = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyOption, "url", graphQLPrivacyOption.B_(), 12, false);
            return true;
        }
    }

    public static void m2256a(JsonGenerator jsonGenerator, GraphQLPrivacyOption graphQLPrivacyOption, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPrivacyOption.E_() != null) {
            jsonGenerator.a("current_tag_expansion", graphQLPrivacyOption.E_().toString());
        }
        jsonGenerator.a("excluded_members");
        if (graphQLPrivacyOption.g() != null) {
            jsonGenerator.d();
            for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember : graphQLPrivacyOption.g()) {
                if (graphQLPrivacyAudienceMember != null) {
                    GraphQLPrivacyAudienceMember__JsonHelper.a(jsonGenerator, graphQLPrivacyAudienceMember, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPrivacyOption.j() != null) {
            jsonGenerator.a("explanation", graphQLPrivacyOption.j());
        }
        if (graphQLPrivacyOption.l() != null) {
            jsonGenerator.a("icon_image");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLPrivacyOption.l(), true);
        }
        if (graphQLPrivacyOption.m() != null) {
            jsonGenerator.a("id", graphQLPrivacyOption.m());
        }
        jsonGenerator.a("included_members");
        if (graphQLPrivacyOption.F_() != null) {
            jsonGenerator.d();
            for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember2 : graphQLPrivacyOption.F_()) {
                if (graphQLPrivacyAudienceMember2 != null) {
                    GraphQLPrivacyAudienceMember__JsonHelper.a(jsonGenerator, graphQLPrivacyAudienceMember2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPrivacyOption.c() != null) {
            jsonGenerator.a("legacy_graph_api_privacy_json", graphQLPrivacyOption.c());
        }
        if (graphQLPrivacyOption.d() != null) {
            jsonGenerator.a("name", graphQLPrivacyOption.d());
        }
        if (graphQLPrivacyOption.n() != null) {
            jsonGenerator.a("privacy_row_input");
            GraphQLPrivacyRowInput__JsonHelper.m2259a(jsonGenerator, graphQLPrivacyOption.n(), true);
        }
        jsonGenerator.a("tag_expansion_options");
        if (graphQLPrivacyOption.G_() != null) {
            jsonGenerator.d();
            for (GraphQLPrivacyOptionTagExpansionType graphQLPrivacyOptionTagExpansionType : graphQLPrivacyOption.G_()) {
                if (graphQLPrivacyOptionTagExpansionType != null) {
                    jsonGenerator.b(graphQLPrivacyOptionTagExpansionType.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPrivacyOption.k() != null) {
            jsonGenerator.a("type", graphQLPrivacyOption.k());
        }
        if (graphQLPrivacyOption.o() != null) {
            jsonGenerator.a("url", graphQLPrivacyOption.o());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
