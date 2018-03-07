package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLOverlayCallToActionInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: estimated_reach */
public class GraphQLOverlayCallToActionInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLOverlayCallToActionInfo.class, new GraphQLOverlayCallToActionInfo$Deserializer());
    }

    public Object m9423a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLOverlayCallToActionInfoDeserializer.m5474a(jsonParser, (short) 503);
        Object graphQLOverlayCallToActionInfo = new GraphQLOverlayCallToActionInfo();
        ((BaseModel) graphQLOverlayCallToActionInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLOverlayCallToActionInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLOverlayCallToActionInfo).a();
        }
        return graphQLOverlayCallToActionInfo;
    }
}
