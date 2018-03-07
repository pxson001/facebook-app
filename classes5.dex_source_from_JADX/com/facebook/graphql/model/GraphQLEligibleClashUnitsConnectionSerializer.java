package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_entity_card_edit_action_button */
public class GraphQLEligibleClashUnitsConnectionSerializer extends JsonSerializer<GraphQLEligibleClashUnitsConnection> {
    public final void m6989a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEligibleClashUnitsConnection__JsonHelper.m6991a(jsonGenerator, (GraphQLEligibleClashUnitsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEligibleClashUnitsConnection.class, new GraphQLEligibleClashUnitsConnectionSerializer());
    }
}
