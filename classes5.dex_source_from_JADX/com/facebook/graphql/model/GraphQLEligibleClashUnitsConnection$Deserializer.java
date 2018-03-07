package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEligibleClashUnitsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ios_feather */
public class GraphQLEligibleClashUnitsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEligibleClashUnitsConnection.class, new GraphQLEligibleClashUnitsConnection$Deserializer());
    }

    public Object m6986a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEligibleClashUnitsConnectionDeserializer.m4729a(jsonParser, (short) 584);
        Object graphQLEligibleClashUnitsConnection = new GraphQLEligibleClashUnitsConnection();
        ((BaseModel) graphQLEligibleClashUnitsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEligibleClashUnitsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLEligibleClashUnitsConnection).a();
        }
        return graphQLEligibleClashUnitsConnection;
    }
}
