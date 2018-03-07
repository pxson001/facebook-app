package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unknown type =  */
public class GraphQLSportsDataMatchDataSerializer extends JsonSerializer<GraphQLSportsDataMatchData> {
    public final void m21785a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSportsDataMatchData__JsonHelper.m21787a(jsonGenerator, (GraphQLSportsDataMatchData) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSportsDataMatchData.class, new GraphQLSportsDataMatchDataSerializer());
    }
}
