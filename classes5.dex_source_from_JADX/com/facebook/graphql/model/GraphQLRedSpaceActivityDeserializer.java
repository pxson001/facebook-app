package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLRedSpaceActivityType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: native_event */
public class GraphQLRedSpaceActivityDeserializer extends FbJsonDeserializer {
    public Object m21367a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLRedSpaceActivity graphQLRedSpaceActivity = new GraphQLRedSpaceActivity();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLRedSpaceActivity = null;
        } else {
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
                    graphQLRedSpaceActivity.f12901d = graphQLObjectType;
                    FieldAccessQueryTracker.a(jsonParser, graphQLRedSpaceActivity, "__type__", graphQLRedSpaceActivity.a_, 0, false);
                } else if ("activity_type".equals(i)) {
                    graphQLRedSpaceActivity.f12902e = GraphQLRedSpaceActivityType.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLRedSpaceActivity, "activity_type", graphQLRedSpaceActivity.a_, 1, false);
                } else if ("icon".equals(i)) {
                    GraphQLIcon graphQLIcon;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLIcon = null;
                    } else {
                        graphQLIcon = GraphQLIcon__JsonHelper.m8613a(FieldAccessQueryTracker.a(jsonParser, "icon"));
                    }
                    graphQLRedSpaceActivity.f12903f = graphQLIcon;
                    FieldAccessQueryTracker.a(jsonParser, graphQLRedSpaceActivity, "icon", graphQLRedSpaceActivity.a_, 2, true);
                } else if ("message".equals(i)) {
                    GraphQLTextWithEntities graphQLTextWithEntities;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLTextWithEntities = null;
                    } else {
                        graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
                    }
                    graphQLRedSpaceActivity.f12904g = graphQLTextWithEntities;
                    FieldAccessQueryTracker.a(jsonParser, graphQLRedSpaceActivity, "message", graphQLRedSpaceActivity.a_, 3, true);
                } else if ("color".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLRedSpaceActivity.f12905h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLRedSpaceActivity, "color", graphQLRedSpaceActivity.a_, 4, false);
                } else if ("title".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLRedSpaceActivity.f12906i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLRedSpaceActivity, "title", graphQLRedSpaceActivity.a_, 5, false);
                } else if ("city_hub".equals(i)) {
                    GraphQLPage graphQLPage;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLPage = null;
                    } else {
                        graphQLPage = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "city_hub"));
                    }
                    graphQLRedSpaceActivity.f12907j = graphQLPage;
                    FieldAccessQueryTracker.a(jsonParser, graphQLRedSpaceActivity, "city_hub", graphQLRedSpaceActivity.a_, 6, true);
                } else if ("name".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLRedSpaceActivity.f12908k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLRedSpaceActivity, "name", graphQLRedSpaceActivity.a_, 7, false);
                } else if ("timezone_info".equals(i)) {
                    GraphQLTimezoneInfo graphQLTimezoneInfo;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLTimezoneInfo = null;
                    } else {
                        graphQLTimezoneInfo = GraphQLTimezoneInfo__JsonHelper.m22238a(FieldAccessQueryTracker.a(jsonParser, "timezone_info"));
                    }
                    graphQLRedSpaceActivity.f12909l = graphQLTimezoneInfo;
                    FieldAccessQueryTracker.a(jsonParser, graphQLRedSpaceActivity, "timezone_info", graphQLRedSpaceActivity.a_, 8, true);
                }
                jsonParser.f();
            }
        }
        return graphQLRedSpaceActivity;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLRedSpaceActivity.class, new GraphQLRedSpaceActivityDeserializer());
    }

    public GraphQLRedSpaceActivityDeserializer() {
        a(GraphQLRedSpaceActivity.class);
    }
}
