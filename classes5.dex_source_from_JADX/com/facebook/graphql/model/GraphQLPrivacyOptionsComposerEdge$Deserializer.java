package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPrivacyOptionsComposerEdgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: View Hierarchy Debug Info */
public class GraphQLPrivacyOptionsComposerEdge$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyOptionsComposerEdge.class, new GraphQLPrivacyOptionsComposerEdge$Deserializer());
    }

    public Object m20999a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPrivacyOptionsComposerEdgeDeserializer.m5695a(jsonParser, (short) 460);
        Object graphQLPrivacyOptionsComposerEdge = new GraphQLPrivacyOptionsComposerEdge();
        ((BaseModel) graphQLPrivacyOptionsComposerEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPrivacyOptionsComposerEdge instanceof Postprocessable) {
            return ((Postprocessable) graphQLPrivacyOptionsComposerEdge).a();
        }
        return graphQLPrivacyOptionsComposerEdge;
    }
}
