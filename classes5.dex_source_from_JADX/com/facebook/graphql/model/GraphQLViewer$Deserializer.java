package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLViewerDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TemporalEventInfo */
public class GraphQLViewer$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLViewer.class, new GraphQLViewer$Deserializer());
    }

    public Object m22486a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLViewerDeserializer.m6200a(jsonParser, (short) 4);
        Object graphQLViewer = new GraphQLViewer();
        ((BaseModel) graphQLViewer).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLViewer instanceof Postprocessable) {
            return ((Postprocessable) graphQLViewer).a();
        }
        return graphQLViewer;
    }
}
