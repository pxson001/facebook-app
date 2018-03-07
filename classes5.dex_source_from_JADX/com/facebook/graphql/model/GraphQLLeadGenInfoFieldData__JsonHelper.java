package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputDomain;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: feed_promotion_privacy_notice */
public final class GraphQLLeadGenInfoFieldData__JsonHelper {
    public static GraphQLLeadGenInfoFieldData m8852a(JsonParser jsonParser) {
        GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData = new GraphQLLeadGenInfoFieldData();
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
            if ("customized_tokens".equals(i)) {
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
                graphQLLeadGenInfoFieldData.f4369d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenInfoFieldData, "customized_tokens", graphQLLeadGenInfoFieldData.a_, 0, false);
            } else if ("field_key".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenInfoFieldData.f4370e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenInfoFieldData, "field_key", graphQLLeadGenInfoFieldData.a_, 1, false);
            } else if ("input_domain".equals(i)) {
                graphQLLeadGenInfoFieldData.f4371f = GraphQLLeadGenInfoFieldInputDomain.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenInfoFieldData, "input_domain", graphQLLeadGenInfoFieldData.a_, 2, false);
            } else if ("input_type".equals(i)) {
                graphQLLeadGenInfoFieldData.f4372g = GraphQLLeadGenInfoFieldInputType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenInfoFieldData, "input_type", graphQLLeadGenInfoFieldData.a_, 3, false);
            } else if ("is_custom_type".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLLeadGenInfoFieldData.f4373h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenInfoFieldData, "is_custom_type", graphQLLeadGenInfoFieldData.a_, 4, false);
            } else if ("is_editable".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLLeadGenInfoFieldData.f4374i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenInfoFieldData, "is_editable", graphQLLeadGenInfoFieldData.a_, 5, false);
            } else if ("is_required".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLLeadGenInfoFieldData.f4375j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenInfoFieldData, "is_required", graphQLLeadGenInfoFieldData.a_, 6, false);
            } else if ("name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenInfoFieldData.f4376k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenInfoFieldData, "name", graphQLLeadGenInfoFieldData.a_, 7, false);
            } else if ("place_holder".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLeadGenInfoFieldData.f4377l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenInfoFieldData, "place_holder", graphQLLeadGenInfoFieldData.a_, 8, false);
            } else if ("values".equals(i)) {
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
                graphQLLeadGenInfoFieldData.f4378m = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLLeadGenInfoFieldData, "values", graphQLLeadGenInfoFieldData.a_, 9, false);
            }
            jsonParser.f();
        }
        return graphQLLeadGenInfoFieldData;
    }

    public static void m8853a(JsonGenerator jsonGenerator, GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("customized_tokens");
        if (graphQLLeadGenInfoFieldData.m8839a() != null) {
            jsonGenerator.d();
            for (String str : graphQLLeadGenInfoFieldData.m8839a()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLLeadGenInfoFieldData.m8841j() != null) {
            jsonGenerator.a("field_key", graphQLLeadGenInfoFieldData.m8841j());
        }
        if (graphQLLeadGenInfoFieldData.m8842k() != null) {
            jsonGenerator.a("input_domain", graphQLLeadGenInfoFieldData.m8842k().toString());
        }
        if (graphQLLeadGenInfoFieldData.m8843l() != null) {
            jsonGenerator.a("input_type", graphQLLeadGenInfoFieldData.m8843l().toString());
        }
        jsonGenerator.a("is_custom_type", graphQLLeadGenInfoFieldData.m8844m());
        jsonGenerator.a("is_editable", graphQLLeadGenInfoFieldData.m8845n());
        jsonGenerator.a("is_required", graphQLLeadGenInfoFieldData.m8846o());
        if (graphQLLeadGenInfoFieldData.m8847p() != null) {
            jsonGenerator.a("name", graphQLLeadGenInfoFieldData.m8847p());
        }
        if (graphQLLeadGenInfoFieldData.m8848q() != null) {
            jsonGenerator.a("place_holder", graphQLLeadGenInfoFieldData.m8848q());
        }
        jsonGenerator.a("values");
        if (graphQLLeadGenInfoFieldData.m8849r() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLLeadGenInfoFieldData.m8849r()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
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
