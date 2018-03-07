package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: external_page_like */
public class GraphQLNativeTemplateDefaultViewControllerSerializer extends JsonSerializer<GraphQLNativeTemplateDefaultViewController> {
    public final void m9176a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNativeTemplateDefaultViewController graphQLNativeTemplateDefaultViewController = (GraphQLNativeTemplateDefaultViewController) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLNativeTemplateDefaultViewController.m9169a() != null) {
            jsonGenerator.a("analytics_module", graphQLNativeTemplateDefaultViewController.m9169a());
        }
        if (graphQLNativeTemplateDefaultViewController.m9171j() != null) {
            jsonGenerator.a("background_color", graphQLNativeTemplateDefaultViewController.m9171j());
        }
        jsonGenerator.a("can_ptr", graphQLNativeTemplateDefaultViewController.m9172k());
        if (graphQLNativeTemplateDefaultViewController.m9173l() != null) {
            jsonGenerator.a("flexibility", graphQLNativeTemplateDefaultViewController.m9173l());
        }
        if (graphQLNativeTemplateDefaultViewController.m9174m() != null) {
            jsonGenerator.a("native_template_view");
            GraphQLNativeTemplateView__JsonHelper.m9198a(jsonGenerator, graphQLNativeTemplateDefaultViewController.m9174m(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLNativeTemplateDefaultViewController.class, new GraphQLNativeTemplateDefaultViewControllerSerializer());
    }
}
