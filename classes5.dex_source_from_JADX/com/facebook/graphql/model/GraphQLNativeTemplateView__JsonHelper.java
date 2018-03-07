package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: expiring_requests_script */
public final class GraphQLNativeTemplateView__JsonHelper {
    public static GraphQLNativeTemplateView m9197a(JsonParser jsonParser) {
        GraphQLNativeTemplateView graphQLNativeTemplateView = new GraphQLNativeTemplateView();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            if ("native_template_bundles".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLNativeTemplateBundle a = GraphQLNativeTemplateBundle__JsonHelper.m9163a(FieldAccessQueryTracker.a(jsonParser, "native_template_bundles"));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    list = ImmutableList.copyOf(arrayList);
                }
                graphQLNativeTemplateView.f4530d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateView, "native_template_bundles", graphQLNativeTemplateView.a_, 4, true);
            }
            jsonParser.f();
        }
        return graphQLNativeTemplateView;
    }

    public static void m9198a(JsonGenerator jsonGenerator, GraphQLNativeTemplateView graphQLNativeTemplateView, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("native_template_bundles");
        if (graphQLNativeTemplateView.m9181a() != null) {
            jsonGenerator.d();
            for (GraphQLNativeTemplateBundle graphQLNativeTemplateBundle : graphQLNativeTemplateView.m9181a()) {
                if (graphQLNativeTemplateBundle != null) {
                    GraphQLNativeTemplateBundle__JsonHelper.m9164a(jsonGenerator, graphQLNativeTemplateBundle, true);
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
