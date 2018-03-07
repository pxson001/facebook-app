package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLReshareEducationInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIDEO_CHANNEL_FEED_UNIT_CARD */
public class GraphQLReshareEducationInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLReshareEducationInfo.class, new GraphQLReshareEducationInfo$Deserializer());
    }

    public Object m21492a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLReshareEducationInfoDeserializer.m5837a(jsonParser, (short) 145);
        Object graphQLReshareEducationInfo = new GraphQLReshareEducationInfo();
        ((BaseModel) graphQLReshareEducationInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLReshareEducationInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLReshareEducationInfo).a();
        }
        return graphQLReshareEducationInfo;
    }
}
