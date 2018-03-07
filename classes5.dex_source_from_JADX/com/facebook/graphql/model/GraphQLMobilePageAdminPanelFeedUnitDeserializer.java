package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: oh_hide_attachment */
public class GraphQLMobilePageAdminPanelFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m9117a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLMobilePageAdminPanelFeedUnit graphQLMobilePageAdminPanelFeedUnit = new GraphQLMobilePageAdminPanelFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLMobilePageAdminPanelFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLMobilePageAdminPanelFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLMobilePageAdminPanelFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnit, "cache_id", graphQLMobilePageAdminPanelFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLMobilePageAdminPanelFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnit, "debug_info", graphQLMobilePageAdminPanelFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLMobilePageAdminPanelFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnit, "fetchTimeMs", graphQLMobilePageAdminPanelFeedUnit.a_, 2, false);
                } else if ("hideable_token".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLMobilePageAdminPanelFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnit, "hideable_token", graphQLMobilePageAdminPanelFeedUnit.a_, 3, false);
                } else if ("items".equals(i)) {
                    List list;
                    Collection collection = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        collection = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            GraphQLMobilePageAdminPanelFeedUnitItem a = GraphQLMobilePageAdminPanelFeedUnitItem__JsonHelper.m9130a(FieldAccessQueryTracker.a(jsonParser, "items"));
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
                    graphQLMobilePageAdminPanelFeedUnit.i = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnit, "items", graphQLMobilePageAdminPanelFeedUnit.a_, 4, true);
                } else if ("negative_feedback_actions".equals(i)) {
                    GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLNegativeFeedbackActionsConnection = null;
                    } else {
                        graphQLNegativeFeedbackActionsConnection = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
                    }
                    graphQLMobilePageAdminPanelFeedUnit.j = graphQLNegativeFeedbackActionsConnection;
                    FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnit, "negative_feedback_actions", graphQLMobilePageAdminPanelFeedUnit.a_, 5, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLMobilePageAdminPanelFeedUnit.k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnit, "short_term_cache_key", graphQLMobilePageAdminPanelFeedUnit.a_, 6, false);
                } else if ("title".equals(i)) {
                    GraphQLTextWithEntities graphQLTextWithEntities;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLTextWithEntities = null;
                    } else {
                        graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLMobilePageAdminPanelFeedUnit.l = graphQLTextWithEntities;
                    FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnit, "title", graphQLMobilePageAdminPanelFeedUnit.a_, 7, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLMobilePageAdminPanelFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnit, "tracking", graphQLMobilePageAdminPanelFeedUnit.a_, 8, false);
                }
                jsonParser.f();
            }
        }
        return graphQLMobilePageAdminPanelFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMobilePageAdminPanelFeedUnit.class, new GraphQLMobilePageAdminPanelFeedUnitDeserializer());
    }

    public GraphQLMobilePageAdminPanelFeedUnitDeserializer() {
        a(GraphQLMobilePageAdminPanelFeedUnit.class);
    }
}
