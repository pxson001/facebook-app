package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPrivacyAudienceMemberDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ViewUtils */
public class GraphQLPrivacyAudienceMember$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyAudienceMember.class, new GraphQLPrivacyAudienceMember$Deserializer());
    }

    public Object m20977a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPrivacyAudienceMemberDeserializer.a(jsonParser, (short) 197);
        Object graphQLPrivacyAudienceMember = new GraphQLPrivacyAudienceMember();
        ((BaseModel) graphQLPrivacyAudienceMember).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPrivacyAudienceMember instanceof Postprocessable) {
            return ((Postprocessable) graphQLPrivacyAudienceMember).a();
        }
        return graphQLPrivacyAudienceMember;
    }
}
