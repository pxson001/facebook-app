package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTimelineSectionsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNDO_BUTTON */
public class GraphQLTimelineSectionsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineSectionsConnection.class, new GraphQLTimelineSectionsConnection$Deserializer());
    }

    public Object m22219a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTimelineSectionsConnectionDeserializer.m6093a(jsonParser, (short) 464);
        Object graphQLTimelineSectionsConnection = new GraphQLTimelineSectionsConnection();
        ((BaseModel) graphQLTimelineSectionsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTimelineSectionsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLTimelineSectionsConnection).a();
        }
        return graphQLTimelineSectionsConnection;
    }
}
