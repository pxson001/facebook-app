package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_creation_v1 */
public class GraphQLEligibleClashUnitsEdgeSerializer extends JsonSerializer<GraphQLEligibleClashUnitsEdge> {
    public final void m6998a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEligibleClashUnitsEdge__JsonHelper.m7000a(jsonGenerator, (GraphQLEligibleClashUnitsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEligibleClashUnitsEdge.class, new GraphQLEligibleClashUnitsEdgeSerializer());
    }
}
