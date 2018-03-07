package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPrivacyOptionsContentEdgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VideoGuidedTourKeyframe */
public class GraphQLPrivacyOptionsContentEdge$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyOptionsContentEdge.class, new GraphQLPrivacyOptionsContentEdge$Deserializer());
    }

    public Object m21013a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPrivacyOptionsContentEdgeDeserializer.m5701a(jsonParser, (short) 149);
        Object graphQLPrivacyOptionsContentEdge = new GraphQLPrivacyOptionsContentEdge();
        ((BaseModel) graphQLPrivacyOptionsContentEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPrivacyOptionsContentEdge instanceof Postprocessable) {
            return ((Postprocessable) graphQLPrivacyOptionsContentEdge).a();
        }
        return graphQLPrivacyOptionsContentEdge;
    }
}
