package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: View  */
public class GraphQLPrivacyOptionsComposerEdgeSerializer extends JsonSerializer<GraphQLPrivacyOptionsComposerEdge> {
    public final void m21002a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyOptionsComposerEdge__JsonHelper.a(jsonGenerator, (GraphQLPrivacyOptionsComposerEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyOptionsComposerEdge.class, new GraphQLPrivacyOptionsComposerEdgeSerializer());
    }
}
