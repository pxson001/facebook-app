package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLBrowserPrefetchType;
import com.facebook.graphql.enums.GraphQLFeedbackReadLikelihood;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: home_team */
public final class GraphQLFeedbackContext__JsonHelper {
    public static GraphQLFeedbackContext m7479a(JsonParser jsonParser) {
        GraphQLFeedbackContext graphQLFeedbackContext = new GraphQLFeedbackContext();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7481a(graphQLFeedbackContext, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFeedbackContext;
    }

    private static boolean m7481a(GraphQLFeedbackContext graphQLFeedbackContext, String str, JsonParser jsonParser) {
        List list = null;
        if ("feedback_target".equals(str)) {
            GraphQLFeedback a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback_target"));
            }
            graphQLFeedbackContext.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackContext, "feedback_target", graphQLFeedbackContext.a_, 0, true);
            return true;
        } else if ("full_relevant_comments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLComment__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "full_relevant_comments"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                list = ImmutableList.copyOf(r1);
            }
            graphQLFeedbackContext.e = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackContext, "full_relevant_comments", graphQLFeedbackContext.B_(), 1, true);
            return true;
        } else if ("inapp_browser_prefetch_type".equals(str)) {
            graphQLFeedbackContext.f = GraphQLBrowserPrefetchType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackContext, "inapp_browser_prefetch_type", graphQLFeedbackContext.B_(), 2, false);
            return true;
        } else if ("inapp_browser_prefetch_vpv_duration_threshold".equals(str)) {
            graphQLFeedbackContext.g = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackContext, "inapp_browser_prefetch_vpv_duration_threshold", graphQLFeedbackContext.B_(), 3, false);
            return true;
        } else if ("interesting_comments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLComment__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "interesting_comments"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                list = ImmutableList.copyOf(r1);
            }
            graphQLFeedbackContext.h = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackContext, "interesting_comments", graphQLFeedbackContext.B_(), 5, true);
            return true;
        } else if ("read_likelihood".equals(str)) {
            graphQLFeedbackContext.i = GraphQLFeedbackReadLikelihood.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackContext, "read_likelihood", graphQLFeedbackContext.B_(), 6, false);
            return true;
        } else if ("relevant_comments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLComment__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "relevant_comments"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                list = ImmutableList.copyOf(r1);
            }
            graphQLFeedbackContext.j = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackContext, "relevant_comments", graphQLFeedbackContext.B_(), 7, true);
            return true;
        } else if ("inapp_browser_prefetch_vpv_duration_threshold_wifi".equals(str)) {
            graphQLFeedbackContext.k = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackContext, "inapp_browser_prefetch_vpv_duration_threshold_wifi", graphQLFeedbackContext.B_(), 8, false);
            return true;
        } else if ("relevant_reactors".equals(str)) {
            GraphQLRelevantReactorsConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLRelevantReactorsConnection__JsonHelper.m21388a(FieldAccessQueryTracker.a(jsonParser, "relevant_reactors"));
            }
            graphQLFeedbackContext.l = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackContext, "relevant_reactors", graphQLFeedbackContext.B_(), 9, true);
            return true;
        } else if (!"feedback_to_prefetch".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLFeedback a3 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback_to_prefetch"));
                    if (a3 != null) {
                        r1.add(a3);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                list = ImmutableList.copyOf(r1);
            }
            graphQLFeedbackContext.m = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackContext, "feedback_to_prefetch", graphQLFeedbackContext.B_(), 10, true);
            return true;
        }
    }

    public static void m7480a(JsonGenerator jsonGenerator, GraphQLFeedbackContext graphQLFeedbackContext, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFeedbackContext.a() != null) {
            jsonGenerator.a("feedback_target");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLFeedbackContext.a(), true);
        }
        jsonGenerator.a("full_relevant_comments");
        if (graphQLFeedbackContext.j() != null) {
            jsonGenerator.d();
            for (GraphQLComment graphQLComment : graphQLFeedbackContext.j()) {
                if (graphQLComment != null) {
                    GraphQLComment__JsonHelper.a(jsonGenerator, graphQLComment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLFeedbackContext.k() != null) {
            jsonGenerator.a("inapp_browser_prefetch_type", graphQLFeedbackContext.k().toString());
        }
        jsonGenerator.a("inapp_browser_prefetch_vpv_duration_threshold", graphQLFeedbackContext.l());
        jsonGenerator.a("interesting_comments");
        if (graphQLFeedbackContext.m() != null) {
            jsonGenerator.d();
            for (GraphQLComment graphQLComment2 : graphQLFeedbackContext.m()) {
                if (graphQLComment2 != null) {
                    GraphQLComment__JsonHelper.a(jsonGenerator, graphQLComment2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLFeedbackContext.n() != null) {
            jsonGenerator.a("read_likelihood", graphQLFeedbackContext.n().toString());
        }
        jsonGenerator.a("relevant_comments");
        if (graphQLFeedbackContext.o() != null) {
            jsonGenerator.d();
            for (GraphQLComment graphQLComment22 : graphQLFeedbackContext.o()) {
                if (graphQLComment22 != null) {
                    GraphQLComment__JsonHelper.a(jsonGenerator, graphQLComment22, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("inapp_browser_prefetch_vpv_duration_threshold_wifi", graphQLFeedbackContext.p());
        if (graphQLFeedbackContext.q() != null) {
            jsonGenerator.a("relevant_reactors");
            GraphQLRelevantReactorsConnection__JsonHelper.m21389a(jsonGenerator, graphQLFeedbackContext.q(), true);
        }
        jsonGenerator.a("feedback_to_prefetch");
        if (graphQLFeedbackContext.r() != null) {
            jsonGenerator.d();
            for (GraphQLFeedback graphQLFeedback : graphQLFeedbackContext.r()) {
                if (graphQLFeedback != null) {
                    GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLFeedback, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
