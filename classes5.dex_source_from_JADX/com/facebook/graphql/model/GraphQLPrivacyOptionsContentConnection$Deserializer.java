package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPrivacyOptionsContentConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VideoTimestampedCommentsEdge */
public class GraphQLPrivacyOptionsContentConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyOptionsContentConnection.class, new GraphQLPrivacyOptionsContentConnection$Deserializer());
    }

    public Object m21005a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPrivacyOptionsContentConnectionDeserializer.m5698a(jsonParser, (short) 148);
        Object graphQLPrivacyOptionsContentConnection = new GraphQLPrivacyOptionsContentConnection();
        ((BaseModel) graphQLPrivacyOptionsContentConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPrivacyOptionsContentConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPrivacyOptionsContentConnection).a();
        }
        return graphQLPrivacyOptionsContentConnection;
    }
}
