package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventViewerCapabilityDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: imageSmallSquare */
public class GraphQLEventViewerCapability$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventViewerCapability.class, new GraphQLEventViewerCapability$Deserializer());
    }

    public Object m7322a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventViewerCapabilityDeserializer.m4843a(jsonParser, (short) 305);
        Object graphQLEventViewerCapability = new GraphQLEventViewerCapability();
        ((BaseModel) graphQLEventViewerCapability).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEventViewerCapability instanceof Postprocessable) {
            return ((Postprocessable) graphQLEventViewerCapability).a();
        }
        return graphQLEventViewerCapability;
    }
}
