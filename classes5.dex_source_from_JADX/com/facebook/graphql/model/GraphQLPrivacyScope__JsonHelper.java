package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Vect2 */
public final class GraphQLPrivacyScope__JsonHelper {
    public static GraphQLPrivacyScope m21033a(JsonParser jsonParser) {
        GraphQLPrivacyScope graphQLPrivacyScope = new GraphQLPrivacyScope();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            boolean z;
            if ("can_viewer_edit".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLPrivacyScope.d = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyScope, "can_viewer_edit", graphQLPrivacyScope.a_, 0, false);
            } else if ("description".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPrivacyScope.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyScope, "description", graphQLPrivacyScope.a_, 1, false);
            } else if ("education_info".equals(i)) {
                GraphQLPrivacyEducationInfo graphQLPrivacyEducationInfo;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPrivacyEducationInfo = null;
                } else {
                    graphQLPrivacyEducationInfo = GraphQLPrivacyEducationInfo__JsonHelper.m20987a(FieldAccessQueryTracker.a(jsonParser, "education_info"));
                }
                graphQLPrivacyScope.f = graphQLPrivacyEducationInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyScope, "education_info", graphQLPrivacyScope.a_, 2, true);
            } else if ("icon".equals(i)) {
                GraphQLIcon graphQLIcon;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLIcon = null;
                } else {
                    graphQLIcon = GraphQLIcon__JsonHelper.m8613a(FieldAccessQueryTracker.a(jsonParser, "icon"));
                }
                graphQLPrivacyScope.g = graphQLIcon;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyScope, "icon", graphQLPrivacyScope.a_, 3, true);
            } else if ("icon_image".equals(i)) {
                GraphQLImage graphQLImage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLImage = null;
                } else {
                    graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "icon_image"));
                }
                graphQLPrivacyScope.h = graphQLImage;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyScope, "icon_image", graphQLPrivacyScope.a_, 4, true);
            } else if ("label".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPrivacyScope.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyScope, "label", graphQLPrivacyScope.a_, 5, false);
            } else if ("legacy_graph_api_privacy_json".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPrivacyScope.j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyScope, "legacy_graph_api_privacy_json", graphQLPrivacyScope.a_, 6, false);
            } else if ("privacy_options".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLPrivacyOptionsContentConnection__JsonHelper.m21009a(FieldAccessQueryTracker.a(jsonParser, "privacy_options"));
                }
                graphQLPrivacyScope.k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyScope, "privacy_options", graphQLPrivacyScope.a_, 7, true);
            } else if ("selectedPrivacyOption".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLPrivacyOptionsContentConnection__JsonHelper.m21009a(FieldAccessQueryTracker.a(jsonParser, "selectedPrivacyOption"));
                }
                graphQLPrivacyScope.l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyScope, "selectedPrivacyOption", graphQLPrivacyScope.a_, 8, true);
            } else if ("show_tag_expansion_options".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLPrivacyScope.m = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyScope, "show_tag_expansion_options", graphQLPrivacyScope.a_, 9, false);
            } else if ("type".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPrivacyScope.n = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLPrivacyScope, "type", graphQLPrivacyScope.a_, 10, false);
            }
            jsonParser.f();
        }
        return graphQLPrivacyScope;
    }

    public static void m21034a(JsonGenerator jsonGenerator, GraphQLPrivacyScope graphQLPrivacyScope, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("can_viewer_edit", graphQLPrivacyScope.a());
        if (graphQLPrivacyScope.j() != null) {
            jsonGenerator.a("description", graphQLPrivacyScope.j());
        }
        if (graphQLPrivacyScope.k() != null) {
            jsonGenerator.a("education_info");
            GraphQLPrivacyEducationInfo__JsonHelper.m20988a(jsonGenerator, graphQLPrivacyScope.k(), true);
        }
        if (graphQLPrivacyScope.l() != null) {
            jsonGenerator.a("icon");
            GraphQLIcon__JsonHelper.m8614a(jsonGenerator, graphQLPrivacyScope.l(), true);
        }
        if (graphQLPrivacyScope.m() != null) {
            jsonGenerator.a("icon_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLPrivacyScope.m(), true);
        }
        if (graphQLPrivacyScope.n() != null) {
            jsonGenerator.a("label", graphQLPrivacyScope.n());
        }
        if (graphQLPrivacyScope.o() != null) {
            jsonGenerator.a("legacy_graph_api_privacy_json", graphQLPrivacyScope.o());
        }
        if (graphQLPrivacyScope.p() != null) {
            jsonGenerator.a("privacy_options");
            GraphQLPrivacyOptionsContentConnection__JsonHelper.m21010a(jsonGenerator, graphQLPrivacyScope.p(), true);
        }
        if (graphQLPrivacyScope.q() != null) {
            jsonGenerator.a("selectedPrivacyOption");
            GraphQLPrivacyOptionsContentConnection__JsonHelper.m21010a(jsonGenerator, graphQLPrivacyScope.q(), true);
        }
        jsonGenerator.a("show_tag_expansion_options", graphQLPrivacyScope.r());
        if (graphQLPrivacyScope.s() != null) {
            jsonGenerator.a("type", graphQLPrivacyScope.s());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
