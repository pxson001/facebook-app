package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPageLikersConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: end_of_privacy_grace_period */
public class GraphQLPageLikersConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageLikersConnection.class, new GraphQLPageLikersConnection$Deserializer());
    }

    public Object m9490a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPageLikersConnectionDeserializer.m5510a(jsonParser, (short) 192);
        Object graphQLPageLikersConnection = new GraphQLPageLikersConnection();
        ((BaseModel) graphQLPageLikersConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPageLikersConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPageLikersConnection).a();
        }
        return graphQLPageLikersConnection;
    }
}
