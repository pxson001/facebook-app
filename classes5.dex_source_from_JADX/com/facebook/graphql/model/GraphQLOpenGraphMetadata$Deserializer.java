package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLOpenGraphMetadataDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: event_action_history */
public class GraphQLOpenGraphMetadata$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLOpenGraphMetadata.class, new GraphQLOpenGraphMetadata$Deserializer());
    }

    public Object m9398a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLOpenGraphMetadataDeserializer.m5463a(jsonParser, (short) 204);
        Object graphQLOpenGraphMetadata = new GraphQLOpenGraphMetadata();
        ((BaseModel) graphQLOpenGraphMetadata).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLOpenGraphMetadata instanceof Postprocessable) {
            return ((Postprocessable) graphQLOpenGraphMetadata).a();
        }
        return graphQLOpenGraphMetadata;
    }
}
