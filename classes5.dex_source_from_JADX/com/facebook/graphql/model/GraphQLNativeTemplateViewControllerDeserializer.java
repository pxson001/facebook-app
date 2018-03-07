package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: og_action_type_id */
public class GraphQLNativeTemplateViewControllerDeserializer extends FbJsonDeserializer {
    public Object m9193a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLNativeTemplateViewController graphQLNativeTemplateViewController = new GraphQLNativeTemplateViewController();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLNativeTemplateViewController = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    GraphQLObjectType graphQLObjectType;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLObjectType = null;
                    } else {
                        graphQLObjectType = GraphQLObjectType.a(jsonParser);
                    }
                    graphQLNativeTemplateViewController.f4531d = graphQLObjectType;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateViewController, "__type__", graphQLNativeTemplateViewController.a_, 0, false);
                } else if ("analytics_module".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLNativeTemplateViewController.f4532e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateViewController, "analytics_module", graphQLNativeTemplateViewController.a_, 1, false);
                } else if ("background_color".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLNativeTemplateViewController.f4533f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateViewController, "background_color", graphQLNativeTemplateViewController.a_, 2, false);
                } else if ("can_ptr".equals(i)) {
                    boolean z;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        z = false;
                    } else {
                        z = jsonParser.H();
                    }
                    graphQLNativeTemplateViewController.f4534g = z;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateViewController, "can_ptr", graphQLNativeTemplateViewController.a_, 3, false);
                } else if ("flexibility".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLNativeTemplateViewController.f4535h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateViewController, "flexibility", graphQLNativeTemplateViewController.a_, 4, false);
                } else if ("native_template_view".equals(i)) {
                    GraphQLNativeTemplateView graphQLNativeTemplateView;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLNativeTemplateView = null;
                    } else {
                        graphQLNativeTemplateView = GraphQLNativeTemplateView__JsonHelper.m9197a(FieldAccessQueryTracker.a(jsonParser, "native_template_view"));
                    }
                    graphQLNativeTemplateViewController.f4536i = graphQLNativeTemplateView;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNativeTemplateViewController, "native_template_view", graphQLNativeTemplateViewController.a_, 5, true);
                }
                jsonParser.f();
            }
        }
        return graphQLNativeTemplateViewController;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNativeTemplateViewController.class, new GraphQLNativeTemplateViewControllerDeserializer());
    }

    public GraphQLNativeTemplateViewControllerDeserializer() {
        a(GraphQLNativeTemplateViewController.class);
    }
}
