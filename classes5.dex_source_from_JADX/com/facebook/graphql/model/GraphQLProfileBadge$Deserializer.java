package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLProfileBadgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VOIP */
public class GraphQLProfileBadge$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLProfileBadge.class, new GraphQLProfileBadge$Deserializer());
    }

    public Object m21098a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLProfileBadgeDeserializer.m5715a(jsonParser, (short) 89);
        Object graphQLProfileBadge = new GraphQLProfileBadge();
        ((BaseModel) graphQLProfileBadge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLProfileBadge instanceof Postprocessable) {
            return ((Postprocessable) graphQLProfileBadge).a();
        }
        return graphQLProfileBadge;
    }
}
