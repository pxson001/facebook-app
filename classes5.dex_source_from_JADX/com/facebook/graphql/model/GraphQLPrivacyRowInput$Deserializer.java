package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPrivacyRowInputDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VideoChannel */
public class GraphQLPrivacyRowInput$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyRowInput.class, new GraphQLPrivacyRowInput$Deserializer());
    }

    public Object m21022a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPrivacyRowInputDeserializer.a(jsonParser, (short) 196);
        Object graphQLPrivacyRowInput = new GraphQLPrivacyRowInput();
        ((BaseModel) graphQLPrivacyRowInput).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPrivacyRowInput instanceof Postprocessable) {
            return ((Postprocessable) graphQLPrivacyRowInput).a();
        }
        return graphQLPrivacyRowInput;
    }
}
