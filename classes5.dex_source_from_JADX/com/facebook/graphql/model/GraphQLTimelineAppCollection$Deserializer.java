package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTimelineAppCollectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNKNOWN_REPORT_PLACE */
public class GraphQLTimelineAppCollection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineAppCollection.class, new GraphQLTimelineAppCollection$Deserializer());
    }

    public Object m22116a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTimelineAppCollectionDeserializer.m6067a(jsonParser, (short) 102);
        Object graphQLTimelineAppCollection = new GraphQLTimelineAppCollection();
        ((BaseModel) graphQLTimelineAppCollection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTimelineAppCollection instanceof Postprocessable) {
            return ((Postprocessable) graphQLTimelineAppCollection).a();
        }
        return graphQLTimelineAppCollection;
    }
}
