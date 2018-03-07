package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAudienceInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_privacy_locked */
public class GraphQLAudienceInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAudienceInfo.class, new GraphQLAudienceInfo$Deserializer());
    }

    public Object m6619a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLAudienceInfoDeserializer.m4598a(jsonParser, (short) 458);
        Object graphQLAudienceInfo = new GraphQLAudienceInfo();
        ((BaseModel) graphQLAudienceInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLAudienceInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLAudienceInfo).a();
        }
        return graphQLAudienceInfo;
    }
}
