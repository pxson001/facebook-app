package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: expressed_as_place */
public class GraphQLNativeTemplateViewControllerSerializer extends JsonSerializer<GraphQLNativeTemplateViewController> {
    public final void m9194a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNativeTemplateViewController graphQLNativeTemplateViewController = (GraphQLNativeTemplateViewController) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLNativeTemplateViewController.m9185a() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLNativeTemplateViewController.m9185a().e());
            jsonGenerator.g();
        }
        if (graphQLNativeTemplateViewController.m9188j() != null) {
            jsonGenerator.a("analytics_module", graphQLNativeTemplateViewController.m9188j());
        }
        if (graphQLNativeTemplateViewController.m9189k() != null) {
            jsonGenerator.a("background_color", graphQLNativeTemplateViewController.m9189k());
        }
        jsonGenerator.a("can_ptr", graphQLNativeTemplateViewController.m9190l());
        if (graphQLNativeTemplateViewController.m9191m() != null) {
            jsonGenerator.a("flexibility", graphQLNativeTemplateViewController.m9191m());
        }
        if (graphQLNativeTemplateViewController.m9192n() != null) {
            jsonGenerator.a("native_template_view");
            GraphQLNativeTemplateView__JsonHelper.m9198a(jsonGenerator, graphQLNativeTemplateViewController.m9192n(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLNativeTemplateViewController.class, new GraphQLNativeTemplateViewControllerSerializer());
    }
}
