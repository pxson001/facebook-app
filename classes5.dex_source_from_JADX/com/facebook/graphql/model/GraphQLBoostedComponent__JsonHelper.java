package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: is_loan */
public final class GraphQLBoostedComponent__JsonHelper {
    public static GraphQLBoostedComponent m6663a(JsonParser jsonParser) {
        GraphQLBoostedComponent graphQLBoostedComponent = new GraphQLBoostedComponent();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m6665a(graphQLBoostedComponent, i, jsonParser);
            jsonParser.f();
        }
        return graphQLBoostedComponent;
    }

    private static boolean m6665a(GraphQLBoostedComponent graphQLBoostedComponent, String str, JsonParser jsonParser) {
        long j = 0;
        GraphQLAYMTChannel graphQLAYMTChannel = null;
        if ("ad_account".equals(str)) {
            GraphQLAdAccount a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLAdAccount__JsonHelper.m6427a(FieldAccessQueryTracker.a(jsonParser, "ad_account"));
            }
            graphQLBoostedComponent.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponent, "ad_account", graphQLBoostedComponent.a_, 0, true);
            return true;
        } else if ("boosting_status".equals(str)) {
            graphQLBoostedComponent.e = GraphQLBoostedComponentStatus.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponent, "boosting_status", graphQLBoostedComponent.B_(), 2, false);
            return true;
        } else if ("budget".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "budget"));
            }
            graphQLBoostedComponent.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponent, "budget", graphQLBoostedComponent.B_(), 3, true);
            return true;
        } else if ("budget_type".equals(str)) {
            graphQLBoostedComponent.g = GraphQLBoostedComponentBudgetType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponent, "budget_type", graphQLBoostedComponent.B_(), 4, false);
            return true;
        } else if ("feed_unit_preview".equals(str)) {
            FeedUnit a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = FeedUnitDeserializer.m6329a(FieldAccessQueryTracker.a(jsonParser, "feed_unit_preview"));
            }
            graphQLBoostedComponent.h = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponent, "feed_unit_preview", graphQLBoostedComponent.B_(), 5, true);
            return true;
        } else if ("ineligible_message".equals(str)) {
            GraphQLBoostedComponentMessage a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLBoostedComponentMessage__JsonHelper.m6659a(FieldAccessQueryTracker.a(jsonParser, "ineligible_message"));
            }
            graphQLBoostedComponent.i = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponent, "ineligible_message", graphQLBoostedComponent.B_(), 6, true);
            return true;
        } else if ("rejection_reason".equals(str)) {
            GraphQLTextWithEntities a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "rejection_reason"));
            }
            graphQLBoostedComponent.j = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponent, "rejection_reason", graphQLBoostedComponent.B_(), 7, true);
            return true;
        } else if ("spent".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "spent"));
            }
            graphQLBoostedComponent.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponent, "spent", graphQLBoostedComponent.B_(), 8, true);
            return true;
        } else if ("start_time".equals(str)) {
            graphQLBoostedComponent.l = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponent, "start_time", graphQLBoostedComponent.B_(), 9, false);
            return true;
        } else if ("stop_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLBoostedComponent.m = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponent, "stop_time", graphQLBoostedComponent.B_(), 10, false);
            return true;
        } else if ("messages".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLBoostedComponentMessage a5 = GraphQLBoostedComponentMessage__JsonHelper.m6659a(FieldAccessQueryTracker.a(jsonParser, "messages"));
                    if (a5 != null) {
                        arrayList.add(a5);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLBoostedComponent.n = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponent, "messages", graphQLBoostedComponent.B_(), 12, true);
            return true;
        } else if (!"aymt_post_footer_channel".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLAYMTChannel = GraphQLAYMTChannel__JsonHelper.m6353a(FieldAccessQueryTracker.a(jsonParser, "aymt_post_footer_channel"));
            }
            graphQLBoostedComponent.o = graphQLAYMTChannel;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponent, "aymt_post_footer_channel", graphQLBoostedComponent.B_(), 13, true);
            return true;
        }
    }

    public static void m6664a(JsonGenerator jsonGenerator, GraphQLBoostedComponent graphQLBoostedComponent, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLBoostedComponent.a() != null) {
            jsonGenerator.a("ad_account");
            GraphQLAdAccount__JsonHelper.m6428a(jsonGenerator, graphQLBoostedComponent.a(), true);
        }
        if (graphQLBoostedComponent.j() != null) {
            jsonGenerator.a("boosting_status", graphQLBoostedComponent.j().toString());
        }
        if (graphQLBoostedComponent.k() != null) {
            jsonGenerator.a("budget");
            GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLBoostedComponent.k(), true);
        }
        if (graphQLBoostedComponent.l() != null) {
            jsonGenerator.a("budget_type", graphQLBoostedComponent.l().toString());
        }
        if (graphQLBoostedComponent.m() != null) {
            jsonGenerator.a("feed_unit_preview");
            FeedUnitSerializer.m6333a(jsonGenerator, graphQLBoostedComponent.m());
        }
        if (graphQLBoostedComponent.n() != null) {
            jsonGenerator.a("ineligible_message");
            GraphQLBoostedComponentMessage__JsonHelper.m6660a(jsonGenerator, graphQLBoostedComponent.n(), true);
        }
        if (graphQLBoostedComponent.o() != null) {
            jsonGenerator.a("rejection_reason");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLBoostedComponent.o(), true);
        }
        if (graphQLBoostedComponent.p() != null) {
            jsonGenerator.a("spent");
            GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, graphQLBoostedComponent.p(), true);
        }
        jsonGenerator.a("start_time", graphQLBoostedComponent.q());
        jsonGenerator.a("stop_time", graphQLBoostedComponent.r());
        jsonGenerator.a("messages");
        if (graphQLBoostedComponent.s() != null) {
            jsonGenerator.d();
            for (GraphQLBoostedComponentMessage graphQLBoostedComponentMessage : graphQLBoostedComponent.s()) {
                if (graphQLBoostedComponentMessage != null) {
                    GraphQLBoostedComponentMessage__JsonHelper.m6660a(jsonGenerator, graphQLBoostedComponentMessage, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLBoostedComponent.t() != null) {
            jsonGenerator.a("aymt_post_footer_channel");
            GraphQLAYMTChannel__JsonHelper.m6354a(jsonGenerator, graphQLBoostedComponent.t(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
