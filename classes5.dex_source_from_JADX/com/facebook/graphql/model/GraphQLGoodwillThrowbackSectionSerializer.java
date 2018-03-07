package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getPhoneSignalScanningTime */
public class GraphQLGoodwillThrowbackSectionSerializer extends JsonSerializer<GraphQLGoodwillThrowbackSection> {
    public final void m8115a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackSection__JsonHelper.m8117a(jsonGenerator, (GraphQLGoodwillThrowbackSection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackSection.class, new GraphQLGoodwillThrowbackSectionSerializer());
    }
}
