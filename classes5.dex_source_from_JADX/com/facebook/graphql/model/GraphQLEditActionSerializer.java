package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_page_edit_button */
public class GraphQLEditActionSerializer extends JsonSerializer<GraphQLEditAction> {
    public final void m6959a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEditAction__JsonHelper.m6961a(jsonGenerator, (GraphQLEditAction) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEditAction.class, new GraphQLEditActionSerializer());
    }
}
