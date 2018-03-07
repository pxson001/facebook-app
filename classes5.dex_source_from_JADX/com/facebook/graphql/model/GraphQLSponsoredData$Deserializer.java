package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSponsoredDataDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Unrecognized field " */
public class GraphQLSponsoredData$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSponsoredData.class, new GraphQLSponsoredData$Deserializer());
    }

    public Object m21752a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSponsoredDataDeserializer.m5922a(jsonParser, (short) 166);
        Object graphQLSponsoredData = new GraphQLSponsoredData();
        ((BaseModel) graphQLSponsoredData).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSponsoredData instanceof Postprocessable) {
            return ((Postprocessable) graphQLSponsoredData).a();
        }
        return graphQLSponsoredData;
    }
}
