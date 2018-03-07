package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLMobilePageAdminPanelFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: faceweb */
public final class GraphQLMobilePageAdminPanelFeedUnit$Serializer extends JsonSerializer<GraphQLMobilePageAdminPanelFeedUnit> {
    public final void m9116a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMobilePageAdminPanelFeedUnit graphQLMobilePageAdminPanelFeedUnit = (GraphQLMobilePageAdminPanelFeedUnit) obj;
        GraphQLMobilePageAdminPanelFeedUnitDeserializer.m5372a(graphQLMobilePageAdminPanelFeedUnit.w_(), graphQLMobilePageAdminPanelFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLMobilePageAdminPanelFeedUnit.class, new GraphQLMobilePageAdminPanelFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLMobilePageAdminPanelFeedUnit.class, new GraphQLMobilePageAdminPanelFeedUnit$Serializer());
    }
}
