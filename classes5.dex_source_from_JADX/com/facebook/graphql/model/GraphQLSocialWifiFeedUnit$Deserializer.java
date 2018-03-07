package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSocialWifiFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UserEducationExperiencesEdge */
public class GraphQLSocialWifiFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSocialWifiFeedUnit.class, new GraphQLSocialWifiFeedUnit$Deserializer());
    }

    public Object m21673a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSocialWifiFeedUnitDeserializer.m5896a(jsonParser, (short) 126);
        Object graphQLSocialWifiFeedUnit = new GraphQLSocialWifiFeedUnit();
        ((BaseModel) graphQLSocialWifiFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSocialWifiFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLSocialWifiFeedUnit).a();
        }
        return graphQLSocialWifiFeedUnit;
    }
}
