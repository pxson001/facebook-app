package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTimelineAppSectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNIVERSAL_FEEDBACK */
public class GraphQLTimelineAppSection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineAppSection.class, new GraphQLTimelineAppSection$Deserializer());
    }

    public Object m22175a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTimelineAppSectionDeserializer.m6081a(jsonParser, (short) 105);
        Object graphQLTimelineAppSection = new GraphQLTimelineAppSection();
        ((BaseModel) graphQLTimelineAppSection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTimelineAppSection instanceof Postprocessable) {
            return ((Postprocessable) graphQLTimelineAppSection).a();
        }
        return graphQLTimelineAppSection;
    }
}
