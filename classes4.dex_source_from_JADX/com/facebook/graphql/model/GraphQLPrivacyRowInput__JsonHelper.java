package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLPrivacyBaseState;
import com.facebook.graphql.enums.GraphQLPrivacyTagExpansionState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: small_img_size */
public final class GraphQLPrivacyRowInput__JsonHelper {
    public static GraphQLPrivacyRowInput m2258a(JsonParser jsonParser) {
        GraphQLPrivacyRowInput graphQLPrivacyRowInput = new GraphQLPrivacyRowInput();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            Collection collection;
            Object o;
            List list;
            if ("allow".equals(i)) {
                collection = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    collection = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                        if (o != null) {
                            collection.add(o);
                        }
                    }
                }
                if (collection == null) {
                    list = null;
                } else {
                    list = ImmutableList.copyOf(collection);
                }
                graphQLPrivacyRowInput.d = list;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyRowInput, "allow", graphQLPrivacyRowInput.a_, 0, false);
            } else if ("base_state".equals(i)) {
                graphQLPrivacyRowInput.e = GraphQLPrivacyBaseState.fromString(jsonParser.o());
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyRowInput, "base_state", graphQLPrivacyRowInput.a_, 1, false);
            } else if ("deny".equals(i)) {
                collection = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    collection = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                        if (o != null) {
                            collection.add(o);
                        }
                    }
                }
                if (collection == null) {
                    list = null;
                } else {
                    list = ImmutableList.copyOf(collection);
                }
                graphQLPrivacyRowInput.f = list;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyRowInput, "deny", graphQLPrivacyRowInput.a_, 2, false);
            } else if ("tag_expansion_state".equals(i)) {
                graphQLPrivacyRowInput.g = GraphQLPrivacyTagExpansionState.fromString(jsonParser.o());
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLPrivacyRowInput, "tag_expansion_state", graphQLPrivacyRowInput.a_, 3, false);
            }
            jsonParser.f();
        }
        return graphQLPrivacyRowInput;
    }

    public static void m2259a(JsonGenerator jsonGenerator, GraphQLPrivacyRowInput graphQLPrivacyRowInput, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("allow");
        if (graphQLPrivacyRowInput.a() != null) {
            jsonGenerator.d();
            for (String str : graphQLPrivacyRowInput.a()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPrivacyRowInput.j() != null) {
            jsonGenerator.a("base_state", graphQLPrivacyRowInput.j().toString());
        }
        jsonGenerator.a("deny");
        if (graphQLPrivacyRowInput.k() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLPrivacyRowInput.k()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPrivacyRowInput.l() != null) {
            jsonGenerator.a("tag_expansion_state", graphQLPrivacyRowInput.l().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
