package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_SERVICES */
public class GraphQLQuestionOptionVotersConnectionSerializer extends JsonSerializer<GraphQLQuestionOptionVotersConnection> {
    public final void m21179a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuestionOptionVotersConnection__JsonHelper.m21181a(jsonGenerator, (GraphQLQuestionOptionVotersConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQuestionOptionVotersConnection.class, new GraphQLQuestionOptionVotersConnectionSerializer());
    }
}
