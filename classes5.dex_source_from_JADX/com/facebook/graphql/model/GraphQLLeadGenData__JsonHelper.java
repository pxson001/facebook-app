package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: feed_topics */
public final class GraphQLLeadGenData__JsonHelper {
    public static GraphQLLeadGenData m8820a(JsonParser jsonParser) {
        GraphQLLeadGenData graphQLLeadGenData = new GraphQLLeadGenData();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8822a(graphQLLeadGenData, i, jsonParser);
            jsonParser.f();
        }
        return graphQLLeadGenData;
    }

    private static boolean m8822a(GraphQLLeadGenData graphQLLeadGenData, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("context_page".equals(str)) {
            GraphQLLeadGenContextPage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLLeadGenContextPage__JsonHelper.m8814a(FieldAccessQueryTracker.a(jsonParser, "context_page"));
            }
            graphQLLeadGenData.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenData, "context_page", graphQLLeadGenData.a_, 0, true);
            return true;
        } else if ("follow_up_title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLLeadGenData.e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenData, "follow_up_title", graphQLLeadGenData.B_(), 1, false);
            return true;
        } else if ("info_fields_data".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLLeadGenInfoFieldData a2 = GraphQLLeadGenInfoFieldData__JsonHelper.m8852a(FieldAccessQueryTracker.a(jsonParser, "info_fields_data"));
                    if (a2 != null) {
                        r1.add(a2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLLeadGenData.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenData, "info_fields_data", graphQLLeadGenData.B_(), 2, true);
            return true;
        } else if ("legal_content".equals(str)) {
            GraphQLLeadGenLegalContent a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLLeadGenLegalContent__JsonHelper.m8881a(FieldAccessQueryTracker.a(jsonParser, "legal_content"));
            }
            graphQLLeadGenData.g = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenData, "legal_content", graphQLLeadGenData.B_(), 3, true);
            return true;
        } else if ("need_split_flow".equals(str)) {
            graphQLLeadGenData.h = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenData, "need_split_flow", graphQLLeadGenData.B_(), 4, false);
            return true;
        } else if ("pages".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLLeadGenPage a4 = GraphQLLeadGenPage__JsonHelper.m8892a(FieldAccessQueryTracker.a(jsonParser, "pages"));
                    if (a4 != null) {
                        r1.add(a4);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLLeadGenData.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenData, "pages", graphQLLeadGenData.B_(), 5, true);
            return true;
        } else if ("policy_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLLeadGenData.j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenData, "policy_url", graphQLLeadGenData.B_(), 6, false);
            return true;
        } else if ("split_flow_request_method".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLLeadGenData.k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenData, "split_flow_request_method", graphQLLeadGenData.B_(), 7, false);
            return true;
        } else if (!"split_flow_use_post".equals(str)) {
            return false;
        } else {
            graphQLLeadGenData.l = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenData, "split_flow_use_post", graphQLLeadGenData.B_(), 8, false);
            return true;
        }
    }

    public static void m8821a(JsonGenerator jsonGenerator, GraphQLLeadGenData graphQLLeadGenData, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLLeadGenData.a() != null) {
            jsonGenerator.a("context_page");
            GraphQLLeadGenContextPage__JsonHelper.m8815a(jsonGenerator, graphQLLeadGenData.a(), true);
        }
        if (graphQLLeadGenData.j() != null) {
            jsonGenerator.a("follow_up_title", graphQLLeadGenData.j());
        }
        jsonGenerator.a("info_fields_data");
        if (graphQLLeadGenData.k() != null) {
            jsonGenerator.d();
            for (GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData : graphQLLeadGenData.k()) {
                if (graphQLLeadGenInfoFieldData != null) {
                    GraphQLLeadGenInfoFieldData__JsonHelper.m8853a(jsonGenerator, graphQLLeadGenInfoFieldData, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLLeadGenData.l() != null) {
            jsonGenerator.a("legal_content");
            GraphQLLeadGenLegalContent__JsonHelper.m8882a(jsonGenerator, graphQLLeadGenData.l(), true);
        }
        jsonGenerator.a("need_split_flow", graphQLLeadGenData.m());
        jsonGenerator.a("pages");
        if (graphQLLeadGenData.n() != null) {
            jsonGenerator.d();
            for (GraphQLLeadGenPage graphQLLeadGenPage : graphQLLeadGenData.n()) {
                if (graphQLLeadGenPage != null) {
                    GraphQLLeadGenPage__JsonHelper.m8893a(jsonGenerator, graphQLLeadGenPage, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLLeadGenData.o() != null) {
            jsonGenerator.a("policy_url", graphQLLeadGenData.o());
        }
        if (graphQLLeadGenData.p() != null) {
            jsonGenerator.a("split_flow_request_method", graphQLLeadGenData.p());
        }
        jsonGenerator.a("split_flow_use_post", graphQLLeadGenData.q());
        if (z) {
            jsonGenerator.g();
        }
    }
}
