package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: save_suggested_locales_failed */
public final class GraphQLTextWithEntities__JsonHelper {
    public static GraphQLTextWithEntities m3246a(JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = new GraphQLTextWithEntities();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m3248a(graphQLTextWithEntities, i, jsonParser);
            jsonParser.f();
        }
        return graphQLTextWithEntities;
    }

    private static boolean m3248a(GraphQLTextWithEntities graphQLTextWithEntities, String str, JsonParser jsonParser) {
        String str2 = null;
        Collection arrayList;
        List copyOf;
        if ("aggregated_ranges".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLAggregatedEntitiesAtRange a = GraphQLAggregatedEntitiesAtRange__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "aggregated_ranges"));
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
            graphQLTextWithEntities.d = copyOf;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLTextWithEntities, "aggregated_ranges", graphQLTextWithEntities.a_, 0, true);
            return true;
        } else if ("image_ranges".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLImageAtRange a2 = GraphQLImageAtRange__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "image_ranges"));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLTextWithEntities.e = copyOf;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLTextWithEntities, "image_ranges", graphQLTextWithEntities.B_(), 1, true);
            return true;
        } else if ("inline_style_ranges".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLInlineStyleAtRange a3 = GraphQLInlineStyleAtRange__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "inline_style_ranges"));
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLTextWithEntities.f = copyOf;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLTextWithEntities, "inline_style_ranges", graphQLTextWithEntities.B_(), 2, true);
            return true;
        } else if ("ranges".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLEntityAtRange a4 = GraphQLEntityAtRange__JsonHelper.a(FieldAccessQueryTracker.m2235a(jsonParser, "ranges"));
                    if (a4 != null) {
                        arrayList.add(a4);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLTextWithEntities.g = copyOf;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLTextWithEntities, "ranges", graphQLTextWithEntities.B_(), 3, true);
            return true;
        } else if ("text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTextWithEntities.h = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLTextWithEntities, "text", graphQLTextWithEntities.B_(), 4, false);
            return true;
        } else if (!"__typename".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTextWithEntities.i = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLTextWithEntities, "__typename", graphQLTextWithEntities.B_(), 5, false);
            return true;
        }
    }

    public static void m3247a(JsonGenerator jsonGenerator, GraphQLTextWithEntities graphQLTextWithEntities, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("aggregated_ranges");
        if (graphQLTextWithEntities.c() != null) {
            jsonGenerator.d();
            for (GraphQLAggregatedEntitiesAtRange graphQLAggregatedEntitiesAtRange : graphQLTextWithEntities.c()) {
                if (graphQLAggregatedEntitiesAtRange != null) {
                    GraphQLAggregatedEntitiesAtRange__JsonHelper.a(jsonGenerator, graphQLAggregatedEntitiesAtRange, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("image_ranges");
        if (graphQLTextWithEntities.d() != null) {
            jsonGenerator.d();
            for (GraphQLImageAtRange graphQLImageAtRange : graphQLTextWithEntities.d()) {
                if (graphQLImageAtRange != null) {
                    GraphQLImageAtRange__JsonHelper.a(jsonGenerator, graphQLImageAtRange, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("inline_style_ranges");
        if (graphQLTextWithEntities.j() != null) {
            jsonGenerator.d();
            for (GraphQLInlineStyleAtRange graphQLInlineStyleAtRange : graphQLTextWithEntities.j()) {
                if (graphQLInlineStyleAtRange != null) {
                    GraphQLInlineStyleAtRange__JsonHelper.a(jsonGenerator, graphQLInlineStyleAtRange, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("ranges");
        if (graphQLTextWithEntities.b() != null) {
            jsonGenerator.d();
            for (GraphQLEntityAtRange graphQLEntityAtRange : graphQLTextWithEntities.b()) {
                if (graphQLEntityAtRange != null) {
                    GraphQLEntityAtRange__JsonHelper.a(jsonGenerator, graphQLEntityAtRange, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLTextWithEntities.a() != null) {
            jsonGenerator.a("text", graphQLTextWithEntities.a());
        }
        if (graphQLTextWithEntities.k() != null) {
            jsonGenerator.a("__typename", graphQLTextWithEntities.k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
