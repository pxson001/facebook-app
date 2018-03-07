package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPageAdminInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: entity_with_image */
public class GraphQLPageAdminInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageAdminInfo.class, new GraphQLPageAdminInfo$Deserializer());
    }

    public Object m9463a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPageAdminInfoDeserializer.m5493a(jsonParser, (short) 250);
        Object graphQLPageAdminInfo = new GraphQLPageAdminInfo();
        ((BaseModel) graphQLPageAdminInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPageAdminInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLPageAdminInfo).a();
        }
        return graphQLPageAdminInfo;
    }
}
