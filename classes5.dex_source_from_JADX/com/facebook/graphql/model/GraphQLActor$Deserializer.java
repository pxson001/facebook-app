package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLActorDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: latest.facebook.com */
public class GraphQLActor$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLActor.class, new GraphQLActor$Deserializer());
    }

    public Object m6396a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLActorDeserializer.m4518a(jsonParser, (short) 3);
        Object graphQLActor = new GraphQLActor();
        ((BaseModel) graphQLActor).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLActor instanceof Postprocessable) {
            return ((Postprocessable) graphQLActor).a();
        }
        return graphQLActor;
    }
}
