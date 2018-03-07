package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEWER_ADDED */
public class GraphQLReactionPostPivotComponentSerializer extends JsonSerializer<GraphQLReactionPostPivotComponent> {
    public final void m21321a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLReactionPostPivotComponent graphQLReactionPostPivotComponent = (GraphQLReactionPostPivotComponent) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLReactionPostPivotComponent.m21316a() != null) {
            jsonGenerator.a("component_logical_path", graphQLReactionPostPivotComponent.m21316a());
        }
        if (graphQLReactionPostPivotComponent.m21317j() != null) {
            jsonGenerator.a("component_style", graphQLReactionPostPivotComponent.m21317j().toString());
        }
        if (graphQLReactionPostPivotComponent.m21318k() != null) {
            jsonGenerator.a("component_tracking_data", graphQLReactionPostPivotComponent.m21318k());
        }
        if (graphQLReactionPostPivotComponent.m21319l() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLReactionPostPivotComponent.m21319l(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLReactionPostPivotComponent.class, new GraphQLReactionPostPivotComponentSerializer());
    }
}
