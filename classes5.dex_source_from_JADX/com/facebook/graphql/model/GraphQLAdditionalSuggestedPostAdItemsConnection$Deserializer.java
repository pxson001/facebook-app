package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAdditionalSuggestedPostAdItemsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: landing_page_redirect_instruction */
public class GraphQLAdditionalSuggestedPostAdItemsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAdditionalSuggestedPostAdItemsConnection.class, new GraphQLAdditionalSuggestedPostAdItemsConnection$Deserializer());
    }

    public Object m6449a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLAdditionalSuggestedPostAdItemsConnectionDeserializer.m4529a(jsonParser, (short) 382);
        Object graphQLAdditionalSuggestedPostAdItemsConnection = new GraphQLAdditionalSuggestedPostAdItemsConnection();
        ((BaseModel) graphQLAdditionalSuggestedPostAdItemsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLAdditionalSuggestedPostAdItemsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLAdditionalSuggestedPostAdItemsConnection).a();
        }
        return graphQLAdditionalSuggestedPostAdItemsConnection;
    }
}
