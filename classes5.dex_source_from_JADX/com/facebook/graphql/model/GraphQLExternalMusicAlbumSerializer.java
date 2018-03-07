package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: icon_url */
public class GraphQLExternalMusicAlbumSerializer extends JsonSerializer<GraphQLExternalMusicAlbum> {
    public final void m7424a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLExternalMusicAlbum graphQLExternalMusicAlbum = (GraphQLExternalMusicAlbum) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        jsonGenerator.a("album_release_date", graphQLExternalMusicAlbum.m7413j());
        if (graphQLExternalMusicAlbum.m7414k() != null) {
            jsonGenerator.a("application_name", graphQLExternalMusicAlbum.m7414k());
        }
        jsonGenerator.a("artist_names");
        if (graphQLExternalMusicAlbum.m7415l() != null) {
            jsonGenerator.d();
            for (String str : graphQLExternalMusicAlbum.m7415l()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLExternalMusicAlbum.m7416m() != null) {
            jsonGenerator.a("copy_right", graphQLExternalMusicAlbum.m7416m());
        }
        if (graphQLExternalMusicAlbum.m7417n() != null) {
            jsonGenerator.a("cover_url", graphQLExternalMusicAlbum.m7417n());
        }
        if (graphQLExternalMusicAlbum.m7418o() != null) {
            jsonGenerator.a("global_share");
            GraphQLExternalUrl__JsonHelper.m7430a(jsonGenerator, graphQLExternalMusicAlbum.m7418o(), true);
        }
        if (graphQLExternalMusicAlbum.m7419p() != null) {
            jsonGenerator.a("id", graphQLExternalMusicAlbum.m7419p());
        }
        if (graphQLExternalMusicAlbum.m7420q() != null) {
            jsonGenerator.a("music_title", graphQLExternalMusicAlbum.m7420q());
        }
        if (graphQLExternalMusicAlbum.m7421r() != null) {
            jsonGenerator.a("owner");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLExternalMusicAlbum.m7421r(), true);
        }
        if (graphQLExternalMusicAlbum.m7422s() != null) {
            jsonGenerator.a("url", graphQLExternalMusicAlbum.m7422s());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLExternalMusicAlbum.class, new GraphQLExternalMusicAlbumSerializer());
    }
}
