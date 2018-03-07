package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: external_url_owning_profile */
public final class GraphQLNativeTemplateBundle__JsonHelper {
    public static GraphQLNativeTemplateBundle m9163a(JsonParser jsonParser) {
        GraphQLNativeTemplateBundle graphQLNativeTemplateBundle = new GraphQLNativeTemplateBundle();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            if ("nt_bundle_tree".equals(i)) {
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    str = jsonParser.o();
                }
                graphQLNativeTemplateBundle.f4524d = str;
                FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateBundle, "nt_bundle_tree", graphQLNativeTemplateBundle.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLNativeTemplateBundle;
    }

    public static void m9164a(JsonGenerator jsonGenerator, GraphQLNativeTemplateBundle graphQLNativeTemplateBundle, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLNativeTemplateBundle.m9160a() != null) {
            jsonGenerator.a("nt_bundle_tree", graphQLNativeTemplateBundle.m9160a());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
