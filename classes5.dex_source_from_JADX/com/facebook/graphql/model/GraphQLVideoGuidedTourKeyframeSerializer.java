package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ThirdPartyDeviceManagementRequired */
public class GraphQLVideoGuidedTourKeyframeSerializer extends JsonSerializer<GraphQLVideoGuidedTourKeyframe> {
    public final void m22461a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoGuidedTourKeyframe__JsonHelper.m22463a(jsonGenerator, (GraphQLVideoGuidedTourKeyframe) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLVideoGuidedTourKeyframe.class, new GraphQLVideoGuidedTourKeyframeSerializer());
    }
}
