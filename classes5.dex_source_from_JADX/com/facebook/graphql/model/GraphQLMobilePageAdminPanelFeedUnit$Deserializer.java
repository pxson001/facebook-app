package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLMobilePageAdminPanelFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: faceweb */
public class GraphQLMobilePageAdminPanelFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMobilePageAdminPanelFeedUnit.class, new GraphQLMobilePageAdminPanelFeedUnit$Deserializer());
    }

    public Object m9115a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLMobilePageAdminPanelFeedUnitDeserializer.m5371a(jsonParser, (short) 117);
        Object graphQLMobilePageAdminPanelFeedUnit = new GraphQLMobilePageAdminPanelFeedUnit();
        ((BaseModel) graphQLMobilePageAdminPanelFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLMobilePageAdminPanelFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLMobilePageAdminPanelFeedUnit).a();
        }
        return graphQLMobilePageAdminPanelFeedUnit;
    }
}
