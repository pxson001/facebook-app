package com.facebook.photos.albums.protocols;

import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLParsers.NewsFeedDefaultsCompleteFeedbackParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAlbumsConnectionDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultPageInfoFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: invitable_entries_token_query */
public class AlbumListQueryParsers {

    /* compiled from: invitable_entries_token_query */
    public final class AlbumListCanUploadOnlyQueryParser {
        public static MutableFlatBuffer m19373a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("albums")) {
                        iArr[1] = GraphQLAlbumsConnectionDeserializer.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: invitable_entries_token_query */
    public final class AlbumListQueryParser {
        public static MutableFlatBuffer m19374a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("albums")) {
                        iArr[1] = GraphQLAlbumsConnectionDeserializer.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: invitable_entries_token_query */
    public final class FBFamilyNonUserMemberAlbumsQueryParser {

        /* compiled from: invitable_entries_token_query */
        public final class FamilyNonUserMembersParser {

            /* compiled from: invitable_entries_token_query */
            public final class EdgesParser {

                /* compiled from: invitable_entries_token_query */
                public final class NodeParser {

                    /* compiled from: invitable_entries_token_query */
                    public final class FamilyTaggedMediasetParser {

                        /* compiled from: invitable_entries_token_query */
                        public final class MediaParser {

                            /* compiled from: invitable_entries_token_query */
                            public final class MediaEdgesParser {

                                /* compiled from: invitable_entries_token_query */
                                public final class MediaEdgesNodeParser {

                                    /* compiled from: invitable_entries_token_query */
                                    public final class ImageParser {
                                        public static int m19375a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                            int[] iArr = new int[3];
                                            boolean[] zArr = new boolean[2];
                                            int[] iArr2 = new int[2];
                                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                                String i = jsonParser.i();
                                                jsonParser.c();
                                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                    if (i.equals("height")) {
                                                        zArr[0] = true;
                                                        iArr2[0] = jsonParser.E();
                                                    } else if (i.equals("uri")) {
                                                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                                    } else if (i.equals("width")) {
                                                        zArr[1] = true;
                                                        iArr2[1] = jsonParser.E();
                                                    } else {
                                                        jsonParser.f();
                                                    }
                                                }
                                            }
                                            flatBufferBuilder.c(3);
                                            if (zArr[0]) {
                                                flatBufferBuilder.a(0, iArr2[0], 0);
                                            }
                                            flatBufferBuilder.b(1, iArr[1]);
                                            if (zArr[1]) {
                                                flatBufferBuilder.a(2, iArr2[1], 0);
                                            }
                                            return flatBufferBuilder.d();
                                        }

                                        public static void m19376a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                            jsonGenerator.f();
                                            int a = mutableFlatBuffer.a(i, 0, 0);
                                            if (a != 0) {
                                                jsonGenerator.a("height");
                                                jsonGenerator.b(a);
                                            }
                                            if (mutableFlatBuffer.g(i, 1) != 0) {
                                                jsonGenerator.a("uri");
                                                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                                            }
                                            a = mutableFlatBuffer.a(i, 2, 0);
                                            if (a != 0) {
                                                jsonGenerator.a("width");
                                                jsonGenerator.b(a);
                                            }
                                            jsonGenerator.g();
                                        }
                                    }

                                    public static int m19377a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                        int[] iArr = new int[3];
                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                            String i = jsonParser.i();
                                            jsonParser.c();
                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                if (i.equals("__type__")) {
                                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                                } else if (i.equals("id")) {
                                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                                } else if (i.equals("image")) {
                                                    iArr[2] = ImageParser.m19375a(jsonParser, flatBufferBuilder);
                                                } else {
                                                    jsonParser.f();
                                                }
                                            }
                                        }
                                        flatBufferBuilder.c(3);
                                        flatBufferBuilder.b(0, iArr[0]);
                                        flatBufferBuilder.b(1, iArr[1]);
                                        flatBufferBuilder.b(2, iArr[2]);
                                        return flatBufferBuilder.d();
                                    }

                                    public static void m19378a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        jsonGenerator.f();
                                        if (mutableFlatBuffer.g(i, 0) != 0) {
                                            jsonGenerator.a("__type__");
                                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                                        }
                                        if (mutableFlatBuffer.g(i, 1) != 0) {
                                            jsonGenerator.a("id");
                                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                                        }
                                        int g = mutableFlatBuffer.g(i, 2);
                                        if (g != 0) {
                                            jsonGenerator.a("image");
                                            ImageParser.m19376a(mutableFlatBuffer, g, jsonGenerator);
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                public static int m19379b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                    int[] iArr = new int[1];
                                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                                        String i = jsonParser.i();
                                        jsonParser.c();
                                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                            if (i.equals("node")) {
                                                iArr[0] = MediaEdgesNodeParser.m19377a(jsonParser, flatBufferBuilder);
                                            } else {
                                                jsonParser.f();
                                            }
                                        }
                                    }
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, iArr[0]);
                                    return flatBufferBuilder.d();
                                }

                                public static void m19380b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    jsonGenerator.f();
                                    int g = mutableFlatBuffer.g(i, 0);
                                    if (g != 0) {
                                        jsonGenerator.a("node");
                                        MediaEdgesNodeParser.m19378a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            public static int m19381a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[2];
                                boolean[] zArr = new boolean[1];
                                int[] iArr2 = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("count")) {
                                            zArr[0] = true;
                                            iArr2[0] = jsonParser.E();
                                        } else if (i.equals("edges")) {
                                            int i2 = 0;
                                            ArrayList arrayList = new ArrayList();
                                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                                    arrayList.add(Integer.valueOf(MediaEdgesParser.m19379b(jsonParser, flatBufferBuilder)));
                                                }
                                            }
                                            if (!arrayList.isEmpty()) {
                                                int[] iArr3 = new int[arrayList.size()];
                                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                                    iArr3[i3] = ((Integer) arrayList.get(i3)).intValue();
                                                }
                                                i2 = flatBufferBuilder.a(iArr3, true);
                                            }
                                            iArr[1] = i2;
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(2);
                                if (zArr[0]) {
                                    flatBufferBuilder.a(0, iArr2[0], 0);
                                }
                                flatBufferBuilder.b(1, iArr[1]);
                                return flatBufferBuilder.d();
                            }

                            public static void m19382a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                int a = mutableFlatBuffer.a(i, 0, 0);
                                if (a != 0) {
                                    jsonGenerator.a("count");
                                    jsonGenerator.b(a);
                                }
                                a = mutableFlatBuffer.g(i, 1);
                                if (a != 0) {
                                    jsonGenerator.a("edges");
                                    jsonGenerator.d();
                                    for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                                        MediaEdgesParser.m19380b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                                    }
                                    jsonGenerator.e();
                                }
                                jsonGenerator.g();
                            }
                        }

                        /* compiled from: invitable_entries_token_query */
                        public final class TitleParser {
                            public static int m19383a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("text")) {
                                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, iArr[0]);
                                return flatBufferBuilder.d();
                            }

                            public static void m19384a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                                jsonGenerator.f();
                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                    jsonGenerator.a("text");
                                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m19385a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[2];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("media")) {
                                        iArr[0] = MediaParser.m19381a(jsonParser, flatBufferBuilder);
                                    } else if (i.equals("title")) {
                                        iArr[1] = TitleParser.m19383a(jsonParser, flatBufferBuilder);
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, iArr[0]);
                            flatBufferBuilder.b(1, iArr[1]);
                            return flatBufferBuilder.d();
                        }

                        public static void m19386a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("media");
                                MediaParser.m19382a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                            }
                            g = mutableFlatBuffer.g(i, 1);
                            if (g != 0) {
                                jsonGenerator.a("title");
                                TitleParser.m19384a(mutableFlatBuffer, g, jsonGenerator);
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m19387a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[3];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("family_tagged_mediaset")) {
                                    iArr[0] = FamilyTaggedMediasetParser.m19385a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("id")) {
                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("name")) {
                                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, iArr[0]);
                        flatBufferBuilder.b(1, iArr[1]);
                        flatBufferBuilder.b(2, iArr[2]);
                        return flatBufferBuilder.d();
                    }

                    public static void m19388a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        int g = mutableFlatBuffer.g(i, 0);
                        if (g != 0) {
                            jsonGenerator.a("family_tagged_mediaset");
                            FamilyTaggedMediasetParser.m19386a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                        }
                        if (mutableFlatBuffer.g(i, 2) != 0) {
                            jsonGenerator.a("name");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m19389b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = NodeParser.m19387a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m19390b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        NodeParser.m19388a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m19391a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(EdgesParser.m19389b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr2 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr2, true);
                            }
                            iArr[0] = i2;
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m19392a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m19390b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m19393a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("family_non_user_members")) {
                        iArr[0] = FamilyNonUserMembersParser.m19391a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: invitable_entries_token_query */
    public final class GroupAlbumListQueryParser {
        public static MutableFlatBuffer m19394a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("group_albums")) {
                        iArr[0] = GraphQLAlbumsConnectionDeserializer.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: invitable_entries_token_query */
    public final class PageAlbumListQueryParser {
        public static MutableFlatBuffer m19395a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("page_albums")) {
                        iArr[1] = PageAlbumsFragmentParser.m19398a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: invitable_entries_token_query */
    public final class PageAlbumsFragmentParser {

        /* compiled from: invitable_entries_token_query */
        public final class EdgesParser {
            public static int m19396b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("node")) {
                            iArr[0] = SimpleAlbumFieldsParser.m19410a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m19397b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("node");
                    SimpleAlbumFieldsParser.m19411a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static int m19398a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("edges")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(EdgesParser.m19396b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr2 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr2, true);
                        }
                        iArr[0] = i2;
                    } else if (i.equals("page_info")) {
                        iArr[1] = DefaultPageInfoFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            return flatBufferBuilder.d();
        }

        public static void m19399a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("edges");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    EdgesParser.m19397b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("page_info");
                DefaultPageInfoFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: invitable_entries_token_query */
    public final class SimpleAlbumFieldsParser {

        /* compiled from: invitable_entries_token_query */
        public final class AlbumCoverPhotoParser {
            public static int m19400a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("imageThumbnail")) {
                            iArr[0] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m19401a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("imageThumbnail");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: invitable_entries_token_query */
        public final class MediaOwnerObjectParser {
            public static int m19402a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                return flatBufferBuilder.d();
            }

            public static void m19403a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: invitable_entries_token_query */
        public final class OwnerParser {
            public static int m19404a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                return flatBufferBuilder.d();
            }

            public static void m19405a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: invitable_entries_token_query */
        public final class PrivacyScopeParser {

            /* compiled from: invitable_entries_token_query */
            public final class IconImageParser {
                public static int m19406a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("name")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("uri")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    return flatBufferBuilder.d();
                }

                public static void m19407a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m19408a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("icon_image")) {
                            iArr[0] = IconImageParser.m19406a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("label")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("legacy_graph_api_privacy_json")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static void m19409a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("icon_image");
                    IconImageParser.m19407a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("label");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("legacy_graph_api_privacy_json");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        public static int m19410a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[14];
            boolean[] zArr = new boolean[5];
            boolean[] zArr2 = new boolean[3];
            long[] jArr = new long[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("album_cover_photo")) {
                        iArr[0] = AlbumCoverPhotoParser.m19400a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("album_type")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLPhotosAlbumAPIType.fromString(jsonParser.o()));
                    } else if (i.equals("can_edit_caption")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_upload")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("can_viewer_delete")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("created_time")) {
                        zArr[3] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("feedback")) {
                        iArr[6] = NewsFeedDefaultsCompleteFeedbackParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("media_owner_object")) {
                        iArr[8] = MediaOwnerObjectParser.m19402a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[9] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("modified_time")) {
                        zArr[4] = true;
                        jArr[1] = jsonParser.F();
                    } else if (i.equals("owner")) {
                        iArr[11] = OwnerParser.m19404a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("privacy_scope")) {
                        iArr[12] = PrivacyScopeParser.m19408a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[13] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(14);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(3, zArr2[1]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(4, zArr2[2]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(5, jArr[0], 0);
            }
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            if (zArr[4]) {
                flatBufferBuilder.a(10, jArr[1], 0);
            }
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            return flatBufferBuilder.d();
        }

        public static void m19411a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("album_cover_photo");
                AlbumCoverPhotoParser.m19401a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("album_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            boolean a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("can_edit_caption");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 3);
            if (a) {
                jsonGenerator.a("can_upload");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 4);
            if (a) {
                jsonGenerator.a("can_viewer_delete");
                jsonGenerator.a(a);
            }
            long a2 = mutableFlatBuffer.a(i, 5, 0);
            if (a2 != 0) {
                jsonGenerator.a("created_time");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("feedback");
                NewsFeedDefaultsCompleteFeedbackParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("media_owner_object");
                MediaOwnerObjectParser.m19403a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a2 = mutableFlatBuffer.a(i, 10, 0);
            if (a2 != 0) {
                jsonGenerator.a("modified_time");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("owner");
                OwnerParser.m19405a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 12);
            if (g != 0) {
                jsonGenerator.a("privacy_scope");
                PrivacyScopeParser.m19409a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }
}
