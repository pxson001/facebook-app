package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: interceptDeclineButtonLabel */
public final class GraphQLEntityCardContextItem__JsonHelper {
    public static GraphQLEntityCardContextItem m7083a(JsonParser jsonParser) {
        GraphQLEntityCardContextItem graphQLEntityCardContextItem = new GraphQLEntityCardContextItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7085a(graphQLEntityCardContextItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEntityCardContextItem;
    }

    private static boolean m7085a(GraphQLEntityCardContextItem graphQLEntityCardContextItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("fallback_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEntityCardContextItem.f3533d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItem, "fallback_url", graphQLEntityCardContextItem.a_, 0, false);
            return true;
        } else if ("icon".equals(str)) {
            GraphQLEntityCardContextItemIcon a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLEntityCardContextItemIcon__JsonHelper.m7068a(FieldAccessQueryTracker.a(jsonParser, "icon"));
            }
            graphQLEntityCardContextItem.f3534e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItem, "icon", graphQLEntityCardContextItem.B_(), 1, true);
            return true;
        } else if ("item_links".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLEntityCardContextItemLink a2 = GraphQLEntityCardContextItemLink__JsonHelper.m7080a(FieldAccessQueryTracker.a(jsonParser, "item_links"));
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
            graphQLEntityCardContextItem.f3535f = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItem, "item_links", graphQLEntityCardContextItem.B_(), 2, true);
            return true;
        } else if ("item_type".equals(str)) {
            graphQLEntityCardContextItem.f3536g = GraphQLEntityCardContextItemType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItem, "item_type", graphQLEntityCardContextItem.B_(), 3, false);
            return true;
        } else if ("logging_param".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEntityCardContextItem.f3537h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItem, "logging_param", graphQLEntityCardContextItem.B_(), 4, false);
            return true;
        } else if ("subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "subtitle"));
            }
            graphQLEntityCardContextItem.f3538i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItem, "subtitle", graphQLEntityCardContextItem.B_(), 5, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLEntityCardContextItem.f3539j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItem, "title", graphQLEntityCardContextItem.B_(), 6, true);
            return true;
        } else if (!"title_color".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEntityCardContextItem.f3540k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEntityCardContextItem, "title_color", graphQLEntityCardContextItem.B_(), 7, false);
            return true;
        }
    }

    public static void m7084a(JsonGenerator jsonGenerator, GraphQLEntityCardContextItem graphQLEntityCardContextItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEntityCardContextItem.m7051a() != null) {
            jsonGenerator.a("fallback_url", graphQLEntityCardContextItem.m7051a());
        }
        if (graphQLEntityCardContextItem.m7052j() != null) {
            jsonGenerator.a("icon");
            GraphQLEntityCardContextItemIcon__JsonHelper.m7069a(jsonGenerator, graphQLEntityCardContextItem.m7052j(), true);
        }
        jsonGenerator.a("item_links");
        if (graphQLEntityCardContextItem.m7053k() != null) {
            jsonGenerator.d();
            for (GraphQLEntityCardContextItemLink graphQLEntityCardContextItemLink : graphQLEntityCardContextItem.m7053k()) {
                if (graphQLEntityCardContextItemLink != null) {
                    GraphQLEntityCardContextItemLink__JsonHelper.m7081a(jsonGenerator, graphQLEntityCardContextItemLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEntityCardContextItem.m7054l() != null) {
            jsonGenerator.a("item_type", graphQLEntityCardContextItem.m7054l().toString());
        }
        if (graphQLEntityCardContextItem.m7055m() != null) {
            jsonGenerator.a("logging_param", graphQLEntityCardContextItem.m7055m());
        }
        if (graphQLEntityCardContextItem.m7056n() != null) {
            jsonGenerator.a("subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEntityCardContextItem.m7056n(), true);
        }
        if (graphQLEntityCardContextItem.m7057o() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEntityCardContextItem.m7057o(), true);
        }
        if (graphQLEntityCardContextItem.m7058p() != null) {
            jsonGenerator.a("title_color", graphQLEntityCardContextItem.m7058p());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
