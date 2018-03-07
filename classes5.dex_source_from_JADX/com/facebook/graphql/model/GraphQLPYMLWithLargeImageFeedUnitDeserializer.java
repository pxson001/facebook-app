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

/* compiled from: of  */
public class GraphQLPYMLWithLargeImageFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m9439a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit = new GraphQLPYMLWithLargeImageFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLPYMLWithLargeImageFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLPYMLWithLargeImageFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPYMLWithLargeImageFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "cache_id", graphQLPYMLWithLargeImageFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPYMLWithLargeImageFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "debug_info", graphQLPYMLWithLargeImageFeedUnit.a_, 1, false);
                } else if ("feed_unit_pagination_identifier".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPYMLWithLargeImageFeedUnit.g = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "feed_unit_pagination_identifier", graphQLPYMLWithLargeImageFeedUnit.a_, 2, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLPYMLWithLargeImageFeedUnit.h = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "fetchTimeMs", graphQLPYMLWithLargeImageFeedUnit.a_, 3, false);
                } else if ("items".equals(i)) {
                    List list;
                    Collection collection = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        collection = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            GraphQLPYMLWithLargeImageFeedUnitItem a = GraphQLPYMLWithLargeImageFeedUnitItem__JsonHelper.m9444a(FieldAccessQueryTracker.a(jsonParser, "items"));
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
                    graphQLPYMLWithLargeImageFeedUnit.i = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "items", graphQLPYMLWithLargeImageFeedUnit.a_, 4, true);
                } else if ("pymlWithLargeImageFeedUnitPaginationIdentifier".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPYMLWithLargeImageFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "pymlWithLargeImageFeedUnitPaginationIdentifier", graphQLPYMLWithLargeImageFeedUnit.a_, 5, false);
                } else if ("pymlWithLargeImageItems".equals(i)) {
                    GraphQLPYMLWithLargeImageFeedUnitsConnection graphQLPYMLWithLargeImageFeedUnitsConnection;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLPYMLWithLargeImageFeedUnitsConnection = null;
                    } else {
                        graphQLPYMLWithLargeImageFeedUnitsConnection = GraphQLPYMLWithLargeImageFeedUnitsConnection__JsonHelper.m9452a(FieldAccessQueryTracker.a(jsonParser, "pymlWithLargeImageItems"));
                    }
                    graphQLPYMLWithLargeImageFeedUnit.k = graphQLPYMLWithLargeImageFeedUnitsConnection;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "pymlWithLargeImageItems", graphQLPYMLWithLargeImageFeedUnit.a_, 6, true);
                } else if ("pymlWithLargeImageTitle".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "pymlWithLargeImageTitle"));
                    }
                    graphQLPYMLWithLargeImageFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "pymlWithLargeImageTitle", graphQLPYMLWithLargeImageFeedUnit.a_, 7, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPYMLWithLargeImageFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "short_term_cache_key", graphQLPYMLWithLargeImageFeedUnit.a_, 8, false);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLPYMLWithLargeImageFeedUnit.n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "title", graphQLPYMLWithLargeImageFeedUnit.a_, 9, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPYMLWithLargeImageFeedUnit.o = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "tracking", graphQLPYMLWithLargeImageFeedUnit.a_, 10, false);
                } else if ("local_last_negative_feedback_action_type".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPYMLWithLargeImageFeedUnit.p = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "local_last_negative_feedback_action_type", graphQLPYMLWithLargeImageFeedUnit.a_, 11, false);
                } else if ("local_story_visibility".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPYMLWithLargeImageFeedUnit.q = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "local_story_visibility", graphQLPYMLWithLargeImageFeedUnit.a_, 12, false);
                } else if ("local_story_visible_height".equals(i)) {
                    int i2;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        i2 = 0;
                    } else {
                        i2 = jsonParser.E();
                    }
                    graphQLPYMLWithLargeImageFeedUnit.r = i2;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPYMLWithLargeImageFeedUnit, "local_story_visible_height", graphQLPYMLWithLargeImageFeedUnit.a_, 13, false);
                }
                jsonParser.f();
            }
        }
        return graphQLPYMLWithLargeImageFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPYMLWithLargeImageFeedUnit.class, new GraphQLPYMLWithLargeImageFeedUnitDeserializer());
    }

    public GraphQLPYMLWithLargeImageFeedUnitDeserializer() {
        a(GraphQLPYMLWithLargeImageFeedUnit.class);
    }
}
