package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_PUBLISHERS */
public class GraphQLRedSpaceActivitySerializer extends JsonSerializer<GraphQLRedSpaceActivity> {
    public final void m21368a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLRedSpaceActivity graphQLRedSpaceActivity = (GraphQLRedSpaceActivity) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLRedSpaceActivity.m21357a() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLRedSpaceActivity.m21357a().e());
            jsonGenerator.g();
        }
        if (graphQLRedSpaceActivity.m21359j() != null) {
            jsonGenerator.a("activity_type", graphQLRedSpaceActivity.m21359j().toString());
        }
        if (graphQLRedSpaceActivity.m21360k() != null) {
            jsonGenerator.a("icon");
            GraphQLIcon__JsonHelper.m8614a(jsonGenerator, graphQLRedSpaceActivity.m21360k(), true);
        }
        if (graphQLRedSpaceActivity.m21361l() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLRedSpaceActivity.m21361l(), true);
        }
        if (graphQLRedSpaceActivity.m21362m() != null) {
            jsonGenerator.a("color", graphQLRedSpaceActivity.m21362m());
        }
        if (graphQLRedSpaceActivity.m21363n() != null) {
            jsonGenerator.a("title", graphQLRedSpaceActivity.m21363n());
        }
        if (graphQLRedSpaceActivity.m21364o() != null) {
            jsonGenerator.a("city_hub");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLRedSpaceActivity.m21364o(), true);
        }
        if (graphQLRedSpaceActivity.m21365p() != null) {
            jsonGenerator.a("name", graphQLRedSpaceActivity.m21365p());
        }
        if (graphQLRedSpaceActivity.m21366q() != null) {
            jsonGenerator.a("timezone_info");
            GraphQLTimezoneInfo__JsonHelper.m22239a(jsonGenerator, graphQLRedSpaceActivity.m21366q(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLRedSpaceActivity.class, new GraphQLRedSpaceActivitySerializer());
    }
}
