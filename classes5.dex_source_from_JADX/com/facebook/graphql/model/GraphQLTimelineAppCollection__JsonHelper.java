package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: UNIVERSITY_STATUS */
public final class GraphQLTimelineAppCollection__JsonHelper {
    public static GraphQLTimelineAppCollection m22160a(JsonParser jsonParser) {
        GraphQLTimelineAppCollection graphQLTimelineAppCollection = new GraphQLTimelineAppCollection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m22162a(graphQLTimelineAppCollection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLTimelineAppCollection;
    }

    private static boolean m22162a(GraphQLTimelineAppCollection graphQLTimelineAppCollection, String str, JsonParser jsonParser) {
        String str2 = null;
        GraphQLTimelineAppCollectionMembershipStateInfo a;
        if ("add_item_action_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTimelineAppCollectionMembershipStateInfo__JsonHelper.m22157a(FieldAccessQueryTracker.a(jsonParser, "add_item_action_info"));
            }
            graphQLTimelineAppCollection.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "add_item_action_info", graphQLTimelineAppCollection.a_, 0, true);
            return true;
        } else if ("added_item_state_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTimelineAppCollectionMembershipStateInfo__JsonHelper.m22157a(FieldAccessQueryTracker.a(jsonParser, "added_item_state_info"));
            }
            graphQLTimelineAppCollection.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "added_item_state_info", graphQLTimelineAppCollection.B_(), 1, true);
            return true;
        } else if ("app_section".equals(str)) {
            GraphQLTimelineAppSection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLTimelineAppSection__JsonHelper.m22179a(FieldAccessQueryTracker.a(jsonParser, "app_section"));
            }
            graphQLTimelineAppCollection.f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "app_section", graphQLTimelineAppCollection.B_(), 2, true);
            return true;
        } else if ("application".equals(str)) {
            GraphQLApplication a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLApplication__JsonHelper.m6587a(FieldAccessQueryTracker.a(jsonParser, "application"));
            }
            graphQLTimelineAppCollection.g = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "application", graphQLTimelineAppCollection.B_(), 3, true);
            return true;
        } else if ("curation_nux_message".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppCollection.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "curation_nux_message", graphQLTimelineAppCollection.B_(), 4, false);
            return true;
        } else if ("curation_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppCollection.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "curation_url", graphQLTimelineAppCollection.B_(), 5, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppCollection.j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "id", graphQLTimelineAppCollection.B_(), 7, false);
            return true;
        } else if ("mediaset".equals(str)) {
            GraphQLMediaSet a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLMediaSet__JsonHelper.m9076a(FieldAccessQueryTracker.a(jsonParser, "mediaset"));
            }
            graphQLTimelineAppCollection.k = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "mediaset", graphQLTimelineAppCollection.B_(), 8, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppCollection.l = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "name", graphQLTimelineAppCollection.B_(), 9, false);
            return true;
        } else if ("new_item_default_privacy".equals(str)) {
            GraphQLPrivacyOption a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLPrivacyOption__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "new_item_default_privacy"));
            }
            graphQLTimelineAppCollection.m = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "new_item_default_privacy", graphQLTimelineAppCollection.B_(), 10, true);
            return true;
        } else if ("rating_title".equals(str)) {
            GraphQLTextWithEntities a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "rating_title"));
            }
            graphQLTimelineAppCollection.n = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "rating_title", graphQLTimelineAppCollection.B_(), 11, true);
            return true;
        } else if ("remove_item_action_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTimelineAppCollectionMembershipStateInfo__JsonHelper.m22157a(FieldAccessQueryTracker.a(jsonParser, "remove_item_action_info"));
            }
            graphQLTimelineAppCollection.o = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "remove_item_action_info", graphQLTimelineAppCollection.B_(), 12, true);
            return true;
        } else if ("saved_dashboard_section".equals(str)) {
            GraphQLSavedDashboardSection a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLSavedDashboardSection__JsonHelper.m21557a(FieldAccessQueryTracker.a(jsonParser, "saved_dashboard_section"));
            }
            graphQLTimelineAppCollection.p = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "saved_dashboard_section", graphQLTimelineAppCollection.B_(), 14, true);
            return true;
        } else if ("style_list".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLTimelineAppCollectionStyle fromString = GraphQLTimelineAppCollectionStyle.fromString(jsonParser.o());
                    if (fromString != null) {
                        arrayList.add(fromString);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLTimelineAppCollection.q = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "style_list", graphQLTimelineAppCollection.B_(), 15, false);
            return true;
        } else if ("supports_suggestions".equals(str)) {
            graphQLTimelineAppCollection.r = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "supports_suggestions", graphQLTimelineAppCollection.B_(), 16, false);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppCollection.s = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "tracking", graphQLTimelineAppCollection.B_(), 17, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppCollection.t = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "url", graphQLTimelineAppCollection.B_(), 18, false);
            return true;
        } else if (!"view_collection_prompt".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTimelineAppCollection.u = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollection, "view_collection_prompt", graphQLTimelineAppCollection.B_(), 19, false);
            return true;
        }
    }

    public static void m22161a(JsonGenerator jsonGenerator, GraphQLTimelineAppCollection graphQLTimelineAppCollection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTimelineAppCollection.j() != null) {
            jsonGenerator.a("add_item_action_info");
            GraphQLTimelineAppCollectionMembershipStateInfo__JsonHelper.m22158a(jsonGenerator, graphQLTimelineAppCollection.j(), true);
        }
        if (graphQLTimelineAppCollection.k() != null) {
            jsonGenerator.a("added_item_state_info");
            GraphQLTimelineAppCollectionMembershipStateInfo__JsonHelper.m22158a(jsonGenerator, graphQLTimelineAppCollection.k(), true);
        }
        if (graphQLTimelineAppCollection.l() != null) {
            jsonGenerator.a("app_section");
            GraphQLTimelineAppSection__JsonHelper.m22180a(jsonGenerator, graphQLTimelineAppCollection.l(), true);
        }
        if (graphQLTimelineAppCollection.m() != null) {
            jsonGenerator.a("application");
            GraphQLApplication__JsonHelper.m6588a(jsonGenerator, graphQLTimelineAppCollection.m(), true);
        }
        if (graphQLTimelineAppCollection.n() != null) {
            jsonGenerator.a("curation_nux_message", graphQLTimelineAppCollection.n());
        }
        if (graphQLTimelineAppCollection.o() != null) {
            jsonGenerator.a("curation_url", graphQLTimelineAppCollection.o());
        }
        if (graphQLTimelineAppCollection.b() != null) {
            jsonGenerator.a("id", graphQLTimelineAppCollection.b());
        }
        if (graphQLTimelineAppCollection.p() != null) {
            jsonGenerator.a("mediaset");
            GraphQLMediaSet__JsonHelper.m9077a(jsonGenerator, graphQLTimelineAppCollection.p(), true);
        }
        if (graphQLTimelineAppCollection.c() != null) {
            jsonGenerator.a("name", graphQLTimelineAppCollection.c());
        }
        if (graphQLTimelineAppCollection.q() != null) {
            jsonGenerator.a("new_item_default_privacy");
            GraphQLPrivacyOption__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollection.q(), true);
        }
        if (graphQLTimelineAppCollection.r() != null) {
            jsonGenerator.a("rating_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollection.r(), true);
        }
        if (graphQLTimelineAppCollection.s() != null) {
            jsonGenerator.a("remove_item_action_info");
            GraphQLTimelineAppCollectionMembershipStateInfo__JsonHelper.m22158a(jsonGenerator, graphQLTimelineAppCollection.s(), true);
        }
        if (graphQLTimelineAppCollection.t() != null) {
            jsonGenerator.a("saved_dashboard_section");
            GraphQLSavedDashboardSection__JsonHelper.m21558a(jsonGenerator, graphQLTimelineAppCollection.t(), true);
        }
        jsonGenerator.a("style_list");
        if (graphQLTimelineAppCollection.u() != null) {
            jsonGenerator.d();
            for (GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle : graphQLTimelineAppCollection.u()) {
                if (graphQLTimelineAppCollectionStyle != null) {
                    jsonGenerator.b(graphQLTimelineAppCollectionStyle.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("supports_suggestions", graphQLTimelineAppCollection.v());
        if (graphQLTimelineAppCollection.w() != null) {
            jsonGenerator.a("tracking", graphQLTimelineAppCollection.w());
        }
        if (graphQLTimelineAppCollection.x() != null) {
            jsonGenerator.a("url", graphQLTimelineAppCollection.x());
        }
        if (graphQLTimelineAppCollection.y() != null) {
            jsonGenerator.a("view_collection_prompt", graphQLTimelineAppCollection.y());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
