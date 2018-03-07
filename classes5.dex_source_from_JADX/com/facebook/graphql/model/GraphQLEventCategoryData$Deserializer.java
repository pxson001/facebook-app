package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventCategoryDataDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: install_messenger_learn_more_button */
public class GraphQLEventCategoryData$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventCategoryData.class, new GraphQLEventCategoryData$Deserializer());
    }

    public Object m7118a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventCategoryDataDeserializer.m4774a(jsonParser, (short) 298);
        Object graphQLEventCategoryData = new GraphQLEventCategoryData();
        ((BaseModel) graphQLEventCategoryData).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEventCategoryData instanceof Postprocessable) {
            return ((Postprocessable) graphQLEventCategoryData).a();
        }
        return graphQLEventCategoryData;
    }
}
