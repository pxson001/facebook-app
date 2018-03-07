package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: event_category_info */
public final class GraphQLNotificationStoriesEdge__JsonHelper {
    public static GraphQLNotificationStoriesEdge m9389a(JsonParser jsonParser) {
        GraphQLNotificationStoriesEdge graphQLNotificationStoriesEdge = new GraphQLNotificationStoriesEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("cursor".equals(i)) {
                String o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLNotificationStoriesEdge.f4659d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesEdge, "cursor", graphQLNotificationStoriesEdge.a_, 0, false);
            } else if ("highlight_state".equals(i)) {
                graphQLNotificationStoriesEdge.f4660e = GraphQLNotifHighlightState.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesEdge, "highlight_state", graphQLNotificationStoriesEdge.a_, 1, false);
            } else if ("importance_reason_text".equals(i)) {
                GraphQLTextWithEntities graphQLTextWithEntities;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = null;
                } else {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "importance_reason_text"));
                }
                graphQLNotificationStoriesEdge.f4661f = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesEdge, "importance_reason_text", graphQLNotificationStoriesEdge.a_, 2, true);
            } else if ("importance_score".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLNotificationStoriesEdge.f4662g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesEdge, "importance_score", graphQLNotificationStoriesEdge.a_, 3, false);
            } else if ("importance_type".equals(i)) {
                graphQLNotificationStoriesEdge.f4663h = GraphQLNotifImportanceType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesEdge, "importance_type", graphQLNotificationStoriesEdge.a_, 4, false);
            } else if ("local_seen_state_session_number".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLNotificationStoriesEdge.f4664i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesEdge, "local_seen_state_session_number", graphQLNotificationStoriesEdge.a_, 5, false);
            } else if ("node".equals(i)) {
                GraphQLStory graphQLStory;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLStory = null;
                } else {
                    graphQLStory = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLNotificationStoriesEdge.f4665j = graphQLStory;
                FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesEdge, "node", graphQLNotificationStoriesEdge.a_, 7, true);
            } else if ("notif_option_rows".equals(i)) {
                List list;
                Collection collection = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    collection = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLNotifOptionRow a = GraphQLNotifOptionRow__JsonHelper.m9358a(FieldAccessQueryTracker.a(jsonParser, "notif_option_rows"));
                        if (a != null) {
                            collection.add(a);
                        }
                    }
                }
                if (collection == null) {
                    list = null;
                } else {
                    list = ImmutableList.copyOf(collection);
                }
                graphQLNotificationStoriesEdge.f4666k = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesEdge, "notif_option_rows", graphQLNotificationStoriesEdge.a_, 8, true);
            } else if ("reaction_unit".equals(i)) {
                GraphQLReactionUnit graphQLReactionUnit;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLReactionUnit = null;
                } else {
                    graphQLReactionUnit = GraphQLReactionUnit__JsonHelper.m21341a(FieldAccessQueryTracker.a(jsonParser, "reaction_unit"));
                }
                graphQLNotificationStoriesEdge.f4667l = graphQLReactionUnit;
                FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesEdge, "reaction_unit", graphQLNotificationStoriesEdge.a_, 9, true);
            } else if ("local_num_impressions".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLNotificationStoriesEdge.f4668m = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesEdge, "local_num_impressions", graphQLNotificationStoriesEdge.a_, 10, false);
            } else if ("local_is_rich_notif_collapsed".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLNotificationStoriesEdge.f4669n = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesEdge, "local_is_rich_notif_collapsed", graphQLNotificationStoriesEdge.a_, 11, false);
            }
            jsonParser.f();
        }
        return graphQLNotificationStoriesEdge;
    }

    public static void m9390a(JsonGenerator jsonGenerator, GraphQLNotificationStoriesEdge graphQLNotificationStoriesEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLNotificationStoriesEdge.m9375a() != null) {
            jsonGenerator.a("cursor", graphQLNotificationStoriesEdge.m9375a());
        }
        if (graphQLNotificationStoriesEdge.m9377j() != null) {
            jsonGenerator.a("highlight_state", graphQLNotificationStoriesEdge.m9377j().toString());
        }
        if (graphQLNotificationStoriesEdge.m9378k() != null) {
            jsonGenerator.a("importance_reason_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNotificationStoriesEdge.m9378k(), true);
        }
        jsonGenerator.a("importance_score", graphQLNotificationStoriesEdge.m9379l());
        if (graphQLNotificationStoriesEdge.m9380m() != null) {
            jsonGenerator.a("importance_type", graphQLNotificationStoriesEdge.m9380m().toString());
        }
        jsonGenerator.a("local_seen_state_session_number", graphQLNotificationStoriesEdge.m9381n());
        if (graphQLNotificationStoriesEdge.m9382o() != null) {
            jsonGenerator.a("node");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLNotificationStoriesEdge.m9382o(), true);
        }
        jsonGenerator.a("notif_option_rows");
        if (graphQLNotificationStoriesEdge.m9383p() != null) {
            jsonGenerator.d();
            for (GraphQLNotifOptionRow graphQLNotifOptionRow : graphQLNotificationStoriesEdge.m9383p()) {
                if (graphQLNotifOptionRow != null) {
                    GraphQLNotifOptionRow__JsonHelper.m9359a(jsonGenerator, graphQLNotifOptionRow, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLNotificationStoriesEdge.m9384q() != null) {
            jsonGenerator.a("reaction_unit");
            GraphQLReactionUnit__JsonHelper.m21342a(jsonGenerator, graphQLNotificationStoriesEdge.m9384q(), true);
        }
        jsonGenerator.a("local_num_impressions", graphQLNotificationStoriesEdge.m9385r());
        jsonGenerator.a("local_is_rich_notif_collapsed", graphQLNotificationStoriesEdge.m9386s());
        if (z) {
            jsonGenerator.g();
        }
    }
}
