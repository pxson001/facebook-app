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

/* compiled from: msite_menu_item_action */
public class GraphQLSocialWifiFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m21675a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLSocialWifiFeedUnit graphQLSocialWifiFeedUnit = new GraphQLSocialWifiFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLSocialWifiFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLSocialWifiFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSocialWifiFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSocialWifiFeedUnit, "cache_id", graphQLSocialWifiFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSocialWifiFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSocialWifiFeedUnit, "debug_info", graphQLSocialWifiFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLSocialWifiFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSocialWifiFeedUnit, "fetchTimeMs", graphQLSocialWifiFeedUnit.a_, 2, false);
                } else if ("items".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLSocialWifiFeedUnitItem__JsonHelper.m21684a(FieldAccessQueryTracker.a(jsonParser, "items"));
                            if (r5 != null) {
                                r4.add(r5);
                            }
                        }
                    }
                    if (r4 == null) {
                        r4 = null;
                    } else {
                        r4 = ImmutableList.copyOf(r4);
                    }
                    graphQLSocialWifiFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSocialWifiFeedUnit, "items", graphQLSocialWifiFeedUnit.a_, 3, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSocialWifiFeedUnit.i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSocialWifiFeedUnit, "short_term_cache_key", graphQLSocialWifiFeedUnit.a_, 4, false);
                } else if ("socialWifiItems".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLSocialWifiFeedUnitItem__JsonHelper.m21684a(FieldAccessQueryTracker.a(jsonParser, "socialWifiItems"));
                            if (r5 != null) {
                                r4.add(r5);
                            }
                        }
                    }
                    if (r4 == null) {
                        r4 = null;
                    } else {
                        r4 = ImmutableList.copyOf(r4);
                    }
                    graphQLSocialWifiFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSocialWifiFeedUnit, "socialWifiItems", graphQLSocialWifiFeedUnit.a_, 5, true);
                } else if ("socialWifiTitle".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "socialWifiTitle"));
                    }
                    graphQLSocialWifiFeedUnit.k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSocialWifiFeedUnit, "socialWifiTitle", graphQLSocialWifiFeedUnit.a_, 6, true);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLSocialWifiFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSocialWifiFeedUnit, "title", graphQLSocialWifiFeedUnit.a_, 7, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLSocialWifiFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLSocialWifiFeedUnit, "tracking", graphQLSocialWifiFeedUnit.a_, 8, false);
                }
                jsonParser.f();
            }
        }
        return graphQLSocialWifiFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSocialWifiFeedUnit.class, new GraphQLSocialWifiFeedUnitDeserializer());
    }

    public GraphQLSocialWifiFeedUnitDeserializer() {
        a(GraphQLSocialWifiFeedUnit.class);
    }
}
