package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unresolved error while connecting client. Stopping auto-manage. */
public class GraphQLSouvenirSerializer extends JsonSerializer<GraphQLSouvenir> {
    public final void m21750a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSouvenir graphQLSouvenir = (GraphQLSouvenir) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLSouvenir.m21693j() != null) {
            jsonGenerator.a("container_post");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLSouvenir.m21693j(), true);
        }
        if (graphQLSouvenir.m21694k() != null) {
            jsonGenerator.a("formatting_string", graphQLSouvenir.m21694k());
        }
        if (graphQLSouvenir.m21695l() != null) {
            jsonGenerator.a("id", graphQLSouvenir.m21695l());
        }
        if (graphQLSouvenir.m21696m() != null) {
            jsonGenerator.a("media_elements");
            GraphQLSouvenirMediaConnection__JsonHelper.m21707a(jsonGenerator, graphQLSouvenir.m21696m(), true);
        }
        if (graphQLSouvenir.m21697n() != null) {
            jsonGenerator.a("souvenir_cover_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLSouvenir.m21697n(), true);
        }
        if (graphQLSouvenir.m21698o() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSouvenir.m21698o(), true);
        }
        if (graphQLSouvenir.m21699p() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSouvenir.m21699p(), true);
        }
        if (graphQLSouvenir.m21700q() != null) {
            jsonGenerator.a("url", graphQLSouvenir.m21700q());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLSouvenir.class, new GraphQLSouvenirSerializer());
    }
}
