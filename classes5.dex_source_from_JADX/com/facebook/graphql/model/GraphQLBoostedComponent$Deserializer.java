package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLBoostedComponentDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_on_sale */
public class GraphQLBoostedComponent$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBoostedComponent.class, new GraphQLBoostedComponent$Deserializer());
    }

    public Object m6635a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLBoostedComponentDeserializer.m4612a(jsonParser, (short) 259);
        Object graphQLBoostedComponent = new GraphQLBoostedComponent();
        ((BaseModel) graphQLBoostedComponent).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLBoostedComponent instanceof Postprocessable) {
            return ((Postprocessable) graphQLBoostedComponent).a();
        }
        return graphQLBoostedComponent;
    }
}
