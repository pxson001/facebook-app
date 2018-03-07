package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fbapp_discovery_landing_page */
public class GraphQLLocalContextAttachmentStyleInfoSerializer extends JsonSerializer<GraphQLLocalContextAttachmentStyleInfo> {
    public final void m8958a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLocalContextAttachmentStyleInfo graphQLLocalContextAttachmentStyleInfo = (GraphQLLocalContextAttachmentStyleInfo) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLLocalContextAttachmentStyleInfo.m8954a() != null) {
            jsonGenerator.a("category_name", graphQLLocalContextAttachmentStyleInfo.m8954a());
        }
        jsonGenerator.a("place_open_status_formats");
        if (graphQLLocalContextAttachmentStyleInfo.m8955j() != null) {
            jsonGenerator.d();
            for (GraphQLPlaceOpenStatusFormat graphQLPlaceOpenStatusFormat : graphQLLocalContextAttachmentStyleInfo.m8955j()) {
                if (graphQLPlaceOpenStatusFormat != null) {
                    GraphQLPlaceOpenStatusFormat__JsonHelper.m20887a(jsonGenerator, graphQLPlaceOpenStatusFormat, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLLocalContextAttachmentStyleInfo.m8956k() != null) {
            jsonGenerator.a("time_zone", graphQLLocalContextAttachmentStyleInfo.m8956k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLLocalContextAttachmentStyleInfo.class, new GraphQLLocalContextAttachmentStyleInfoSerializer());
    }
}
