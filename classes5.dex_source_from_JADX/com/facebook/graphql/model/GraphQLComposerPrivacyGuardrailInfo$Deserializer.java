package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLComposerPrivacyGuardrailInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: isStaleData */
public class GraphQLComposerPrivacyGuardrailInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLComposerPrivacyGuardrailInfo.class, new GraphQLComposerPrivacyGuardrailInfo$Deserializer());
    }

    public Object m6841a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLComposerPrivacyGuardrailInfoDeserializer.m4672a(jsonParser, (short) 459);
        Object graphQLComposerPrivacyGuardrailInfo = new GraphQLComposerPrivacyGuardrailInfo();
        ((BaseModel) graphQLComposerPrivacyGuardrailInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLComposerPrivacyGuardrailInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLComposerPrivacyGuardrailInfo).a();
        }
        return graphQLComposerPrivacyGuardrailInfo;
    }
}
