package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: facecast_camera_zoom_level */
public class GraphQLMobilePageAdminPanelFeedUnitSerializer extends JsonSerializer<GraphQLMobilePageAdminPanelFeedUnit> {
    public final void m9133a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMobilePageAdminPanelFeedUnit graphQLMobilePageAdminPanelFeedUnit = (GraphQLMobilePageAdminPanelFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLMobilePageAdminPanelFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLMobilePageAdminPanelFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLMobilePageAdminPanelFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLMobilePageAdminPanelFeedUnit.g());
        }
        if (graphQLMobilePageAdminPanelFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLMobilePageAdminPanelFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLMobilePageAdminPanelFeedUnit.T_());
        if (graphQLMobilePageAdminPanelFeedUnit.o() != null) {
            jsonGenerator.a("hideable_token", graphQLMobilePageAdminPanelFeedUnit.o());
        }
        jsonGenerator.a("items");
        if (graphQLMobilePageAdminPanelFeedUnit.p() != null) {
            jsonGenerator.d();
            for (GraphQLMobilePageAdminPanelFeedUnitItem graphQLMobilePageAdminPanelFeedUnitItem : graphQLMobilePageAdminPanelFeedUnit.p()) {
                if (graphQLMobilePageAdminPanelFeedUnitItem != null) {
                    GraphQLMobilePageAdminPanelFeedUnitItem__JsonHelper.m9131a(jsonGenerator, graphQLMobilePageAdminPanelFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLMobilePageAdminPanelFeedUnit.q() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLMobilePageAdminPanelFeedUnit.q(), true);
        }
        if (graphQLMobilePageAdminPanelFeedUnit.r() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLMobilePageAdminPanelFeedUnit.r());
        }
        if (graphQLMobilePageAdminPanelFeedUnit.s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLMobilePageAdminPanelFeedUnit.s(), true);
        }
        if (graphQLMobilePageAdminPanelFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLMobilePageAdminPanelFeedUnit.k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLMobilePageAdminPanelFeedUnit.class, new GraphQLMobilePageAdminPanelFeedUnitSerializer());
    }
}
