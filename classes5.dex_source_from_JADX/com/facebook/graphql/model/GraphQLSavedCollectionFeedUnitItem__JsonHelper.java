package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VERTICAL_COMPONENT_LIST_INNER_CARD */
public final class GraphQLSavedCollectionFeedUnitItem__JsonHelper {
    public static GraphQLSavedCollectionFeedUnitItem m21548a(JsonParser jsonParser) {
        GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem = new GraphQLSavedCollectionFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21550a(graphQLSavedCollectionFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLSavedCollectionFeedUnitItem;
    }

    private static boolean m21550a(GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("action_links".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStoryActionLink a = GraphQLStoryActionLink__JsonHelper.m21847a(FieldAccessQueryTracker.a(jsonParser, "action_links"));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLSavedCollectionFeedUnitItem.f12980d = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnitItem, "action_links", graphQLSavedCollectionFeedUnitItem.a_, 0, true);
            return true;
        } else if ("context".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "context"));
            }
            graphQLSavedCollectionFeedUnitItem.f12981e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnitItem, "context", graphQLSavedCollectionFeedUnitItem.B_(), 1, true);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSavedCollectionFeedUnitItem.f12982f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnitItem, "hideable_token", graphQLSavedCollectionFeedUnitItem.B_(), 2, false);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLProfile a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLSavedCollectionFeedUnitItem.f12983g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnitItem, "profile", graphQLSavedCollectionFeedUnitItem.B_(), 3, true);
            return true;
        } else if ("subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "subtitle"));
            }
            graphQLSavedCollectionFeedUnitItem.f12984h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnitItem, "subtitle", graphQLSavedCollectionFeedUnitItem.B_(), 4, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLSavedCollectionFeedUnitItem.f12985i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnitItem, "title", graphQLSavedCollectionFeedUnitItem.B_(), 5, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSavedCollectionFeedUnitItem.f12986j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSavedCollectionFeedUnitItem, "tracking", graphQLSavedCollectionFeedUnitItem.B_(), 6, false);
            return true;
        }
    }

    public static void m21549a(JsonGenerator jsonGenerator, GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("action_links");
        if (graphQLSavedCollectionFeedUnitItem.m21539j() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLSavedCollectionFeedUnitItem.m21539j()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSavedCollectionFeedUnitItem.m21541l() != null) {
            jsonGenerator.a("context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSavedCollectionFeedUnitItem.m21541l(), true);
        }
        if (graphQLSavedCollectionFeedUnitItem.m21542m() != null) {
            jsonGenerator.a("hideable_token", graphQLSavedCollectionFeedUnitItem.m21542m());
        }
        if (graphQLSavedCollectionFeedUnitItem.m21543n() != null) {
            jsonGenerator.a("profile");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLSavedCollectionFeedUnitItem.m21543n(), true);
        }
        if (graphQLSavedCollectionFeedUnitItem.m21544o() != null) {
            jsonGenerator.a("subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSavedCollectionFeedUnitItem.m21544o(), true);
        }
        if (graphQLSavedCollectionFeedUnitItem.m21545p() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSavedCollectionFeedUnitItem.m21545p(), true);
        }
        if (graphQLSavedCollectionFeedUnitItem.m21540k() != null) {
            jsonGenerator.a("tracking", graphQLSavedCollectionFeedUnitItem.m21540k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
