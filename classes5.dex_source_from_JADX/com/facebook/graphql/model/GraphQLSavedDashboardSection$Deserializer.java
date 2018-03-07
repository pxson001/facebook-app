package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSavedDashboardSectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VERTICAL_COMPONENTS_LIST */
public class GraphQLSavedDashboardSection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSavedDashboardSection.class, new GraphQLSavedDashboardSection$Deserializer());
    }

    public Object m21553a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSavedDashboardSectionDeserializer.m5860a(jsonParser, (short) 162);
        Object graphQLSavedDashboardSection = new GraphQLSavedDashboardSection();
        ((BaseModel) graphQLSavedDashboardSection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSavedDashboardSection instanceof Postprocessable) {
            return ((Postprocessable) graphQLSavedDashboardSection).a();
        }
        return graphQLSavedDashboardSection;
    }
}
