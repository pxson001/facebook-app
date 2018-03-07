package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: og_hide_object_attachment */
public class GraphQLNativeTemplateDefaultViewControllerDeserializer extends FbJsonDeserializer {
    public Object m9175a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLNativeTemplateDefaultViewController graphQLNativeTemplateDefaultViewController = new GraphQLNativeTemplateDefaultViewController();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLNativeTemplateDefaultViewController = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("analytics_module".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLNativeTemplateDefaultViewController.f4525d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateDefaultViewController, "analytics_module", graphQLNativeTemplateDefaultViewController.a_, 0, false);
                } else if ("background_color".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLNativeTemplateDefaultViewController.f4526e = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateDefaultViewController, "background_color", graphQLNativeTemplateDefaultViewController.a_, 1, false);
                } else if ("can_ptr".equals(i)) {
                    boolean z;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        z = false;
                    } else {
                        z = jsonParser.H();
                    }
                    graphQLNativeTemplateDefaultViewController.f4527f = z;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateDefaultViewController, "can_ptr", graphQLNativeTemplateDefaultViewController.a_, 2, false);
                } else if ("flexibility".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLNativeTemplateDefaultViewController.f4528g = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateDefaultViewController, "flexibility", graphQLNativeTemplateDefaultViewController.a_, 3, false);
                } else if ("native_template_view".equals(i)) {
                    GraphQLNativeTemplateView graphQLNativeTemplateView;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLNativeTemplateView = null;
                    } else {
                        graphQLNativeTemplateView = GraphQLNativeTemplateView__JsonHelper.m9197a(FieldAccessQueryTracker.a(jsonParser, "native_template_view"));
                    }
                    graphQLNativeTemplateDefaultViewController.f4529h = graphQLNativeTemplateView;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateDefaultViewController, "native_template_view", graphQLNativeTemplateDefaultViewController.a_, 4, true);
                }
                jsonParser.f();
            }
        }
        return graphQLNativeTemplateDefaultViewController;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNativeTemplateDefaultViewController.class, new GraphQLNativeTemplateDefaultViewControllerDeserializer());
    }

    public GraphQLNativeTemplateDefaultViewControllerDeserializer() {
        a(GraphQLNativeTemplateDefaultViewController.class);
    }
}
