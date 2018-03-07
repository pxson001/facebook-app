package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UnknownFeedUnit */
public class GraphQLSportsDataMatchDataFactSerializer extends JsonSerializer<GraphQLSportsDataMatchDataFact> {
    public final void m21781a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSportsDataMatchDataFact__JsonHelper.m21783a(jsonGenerator, (GraphQLSportsDataMatchDataFact) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSportsDataMatchDataFact.class, new GraphQLSportsDataMatchDataFactSerializer());
    }
}
