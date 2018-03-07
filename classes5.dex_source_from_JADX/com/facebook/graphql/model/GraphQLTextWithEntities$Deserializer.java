package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTextWithEntitiesDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNLINK */
public class GraphQLTextWithEntities$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTextWithEntities.class, new GraphQLTextWithEntities$Deserializer());
    }

    public Object m22106a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTextWithEntitiesDeserializer.m6057a(jsonParser, (short) 133);
        Object graphQLTextWithEntities = new GraphQLTextWithEntities();
        ((BaseModel) graphQLTextWithEntities).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTextWithEntities instanceof Postprocessable) {
            return ((Postprocessable) graphQLTextWithEntities).a();
        }
        return graphQLTextWithEntities;
    }
}
