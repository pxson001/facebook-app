package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: paid_reach */
public class GraphQLExternalMusicAlbumDeserializer extends FbJsonDeserializer {
    public Object m7423a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLExternalMusicAlbum graphQLExternalMusicAlbum = new GraphQLExternalMusicAlbum();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLExternalMusicAlbum = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("album_release_date".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLExternalMusicAlbum.f3736d = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLExternalMusicAlbum, "album_release_date", graphQLExternalMusicAlbum.a_, 0, false);
                } else if ("application_name".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLExternalMusicAlbum.f3737e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLExternalMusicAlbum, "application_name", graphQLExternalMusicAlbum.a_, 1, false);
                } else if ("artist_names".equals(i)) {
                    List list;
                    Collection collection = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        collection = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            Object o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                            if (o != null) {
                                collection.add(o);
                            }
                        }
                    }
                    if (collection == null) {
                        list = null;
                    } else {
                        list = ImmutableList.copyOf(collection);
                    }
                    graphQLExternalMusicAlbum.f3738f = list;
                    FieldAccessQueryTracker.a(jsonParser, graphQLExternalMusicAlbum, "artist_names", graphQLExternalMusicAlbum.a_, 2, false);
                } else if ("copy_right".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLExternalMusicAlbum.f3739g = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLExternalMusicAlbum, "copy_right", graphQLExternalMusicAlbum.a_, 3, false);
                } else if ("cover_url".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLExternalMusicAlbum.f3740h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLExternalMusicAlbum, "cover_url", graphQLExternalMusicAlbum.a_, 4, false);
                } else if ("global_share".equals(i)) {
                    GraphQLExternalUrl graphQLExternalUrl;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLExternalUrl = null;
                    } else {
                        graphQLExternalUrl = GraphQLExternalUrl__JsonHelper.m7429a(FieldAccessQueryTracker.a(jsonParser, "global_share"));
                    }
                    graphQLExternalMusicAlbum.f3741i = graphQLExternalUrl;
                    FieldAccessQueryTracker.a(jsonParser, graphQLExternalMusicAlbum, "global_share", graphQLExternalMusicAlbum.a_, 5, true);
                } else if ("id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLExternalMusicAlbum.f3742j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLExternalMusicAlbum, "id", graphQLExternalMusicAlbum.a_, 6, false);
                } else if ("music_title".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLExternalMusicAlbum.f3743k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLExternalMusicAlbum, "music_title", graphQLExternalMusicAlbum.a_, 7, false);
                } else if ("owner".equals(i)) {
                    GraphQLActor graphQLActor;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLActor = null;
                    } else {
                        graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "owner"));
                    }
                    graphQLExternalMusicAlbum.f3744l = graphQLActor;
                    FieldAccessQueryTracker.a(jsonParser, graphQLExternalMusicAlbum, "owner", graphQLExternalMusicAlbum.a_, 8, true);
                } else if ("url".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLExternalMusicAlbum.f3745m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLExternalMusicAlbum, "url", graphQLExternalMusicAlbum.a_, 9, false);
                }
                jsonParser.f();
            }
        }
        return graphQLExternalMusicAlbum;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLExternalMusicAlbum.class, new GraphQLExternalMusicAlbumDeserializer());
    }

    public GraphQLExternalMusicAlbumDeserializer() {
        a(GraphQLExternalMusicAlbum.class);
    }
}
