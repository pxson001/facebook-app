package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPrivacyOptionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ViewGroupFragmentHost */
public class GraphQLPrivacyOption$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyOption.class, new GraphQLPrivacyOption$Deserializer());
    }

    public Object m20992a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPrivacyOptionDeserializer.a(jsonParser, (short) 88);
        Object graphQLPrivacyOption = new GraphQLPrivacyOption();
        ((BaseModel) graphQLPrivacyOption).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPrivacyOption instanceof Postprocessable) {
            return ((Postprocessable) graphQLPrivacyOption).a();
        }
        return graphQLPrivacyOption;
    }
}
