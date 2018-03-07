package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: jackson-dataformat-smile */
public final class GraphQLAndroidAppConfig__JsonHelper {
    public static GraphQLAndroidAppConfig m6540a(JsonParser jsonParser) {
        GraphQLAndroidAppConfig graphQLAndroidAppConfig = new GraphQLAndroidAppConfig();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("can_deeplink".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLAndroidAppConfig.d = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLAndroidAppConfig, "can_deeplink", graphQLAndroidAppConfig.a_, 0, false);
            } else if ("class_name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAndroidAppConfig.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAndroidAppConfig, "class_name", graphQLAndroidAppConfig.a_, 1, false);
            } else if ("key_hashes".equals(i)) {
                List list;
                Collection collection = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    collection = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        Object o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
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
                graphQLAndroidAppConfig.f = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLAndroidAppConfig, "key_hashes", graphQLAndroidAppConfig.a_, 2, false);
            } else if ("package_name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLAndroidAppConfig.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAndroidAppConfig, "package_name", graphQLAndroidAppConfig.a_, 3, false);
            }
            jsonParser.f();
        }
        return graphQLAndroidAppConfig;
    }

    public static void m6541a(JsonGenerator jsonGenerator, GraphQLAndroidAppConfig graphQLAndroidAppConfig, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("can_deeplink", graphQLAndroidAppConfig.a());
        if (graphQLAndroidAppConfig.j() != null) {
            jsonGenerator.a("class_name", graphQLAndroidAppConfig.j());
        }
        jsonGenerator.a("key_hashes");
        if (graphQLAndroidAppConfig.k() != null) {
            jsonGenerator.d();
            for (String str : graphQLAndroidAppConfig.k()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLAndroidAppConfig.l() != null) {
            jsonGenerator.a("package_name", graphQLAndroidAppConfig.l());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
