package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTagExpansionEducationInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNSUPPORTED_CATEGORY */
public class GraphQLTagExpansionEducationInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTagExpansionEducationInfo.class, new GraphQLTagExpansionEducationInfo$Deserializer());
    }

    public Object m22032a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTagExpansionEducationInfoDeserializer.m6027a(jsonParser, (short) 146);
        Object graphQLTagExpansionEducationInfo = new GraphQLTagExpansionEducationInfo();
        ((BaseModel) graphQLTagExpansionEducationInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTagExpansionEducationInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLTagExpansionEducationInfo).a();
        }
        return graphQLTagExpansionEducationInfo;
    }
}
