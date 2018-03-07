package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFullIndexEducationInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: gyscItems */
public class GraphQLFullIndexEducationInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFullIndexEducationInfo.class, new GraphQLFullIndexEducationInfo$Deserializer());
    }

    public Object m7658a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFullIndexEducationInfoDeserializer.m4970a(jsonParser, (short) 147);
        Object graphQLFullIndexEducationInfo = new GraphQLFullIndexEducationInfo();
        ((BaseModel) graphQLFullIndexEducationInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFullIndexEducationInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLFullIndexEducationInfo).a();
        }
        return graphQLFullIndexEducationInfo;
    }
}
