package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPagePostPromotionInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: enable_ranked_replies */
public class GraphQLPagePostPromotionInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPagePostPromotionInfo.class, new GraphQLPagePostPromotionInfo$Deserializer());
    }

    public Object m9509a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPagePostPromotionInfoDeserializer.m5519a(jsonParser, (short) 249);
        Object graphQLPagePostPromotionInfo = new GraphQLPagePostPromotionInfo();
        ((BaseModel) graphQLPagePostPromotionInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPagePostPromotionInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLPagePostPromotionInfo).a();
        }
        return graphQLPagePostPromotionInfo;
    }
}
