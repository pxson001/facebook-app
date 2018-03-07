package com.facebook.timeline.favmediapicker.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsParsers.FavoriteMediaUserParser;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsParsers.FavoriteMediaUserParser.ProfileIntroCardParser;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsParsers.SuggestedMediaParser;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsParsers.SuggestedMediasetParser;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsParsers.SuggestedMediasetParser.MediaListParser;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsParsers.SuggestedMediasetParser.TitleParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: friendsnearby */
public class FetchFavoriteMediaPickerSuggestionsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -115788962)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: friendsnearby */
    public final class FavoriteMediaUserModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ProfileIntroCardModel f11022d;

        /* compiled from: friendsnearby */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FavoriteMediaUserModel.class, new Deserializer());
            }

            public Object m11153a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FavoriteMediaUserParser.m11194a(jsonParser);
                Object favoriteMediaUserModel = new FavoriteMediaUserModel();
                ((BaseModel) favoriteMediaUserModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (favoriteMediaUserModel instanceof Postprocessable) {
                    return ((Postprocessable) favoriteMediaUserModel).a();
                }
                return favoriteMediaUserModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 971511293)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: friendsnearby */
        public final class ProfileIntroCardModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<SuggestedMediasetModel> f11021d;

            /* compiled from: friendsnearby */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileIntroCardModel.class, new Deserializer());
                }

                public Object m11154a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileIntroCardParser.m11192a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileIntroCardModel = new ProfileIntroCardModel();
                    ((BaseModel) profileIntroCardModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileIntroCardModel instanceof Postprocessable) {
                        return ((Postprocessable) profileIntroCardModel).a();
                    }
                    return profileIntroCardModel;
                }
            }

            /* compiled from: friendsnearby */
            public class Serializer extends JsonSerializer<ProfileIntroCardModel> {
                public final void m11155a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileIntroCardModel profileIntroCardModel = (ProfileIntroCardModel) obj;
                    if (profileIntroCardModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileIntroCardModel.m11156a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileIntroCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileIntroCardParser.m11193a(profileIntroCardModel.w_(), profileIntroCardModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileIntroCardModel.class, new Serializer());
                }
            }

            public ProfileIntroCardModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<SuggestedMediasetModel> m11158a() {
                this.f11021d = super.a(this.f11021d, 0, SuggestedMediasetModel.class);
                return (ImmutableList) this.f11021d;
            }

            public final int jK_() {
                return 2102913043;
            }

            public final GraphQLVisitableModel m11157a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11158a() != null) {
                    Builder a = ModelHelper.a(m11158a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ProfileIntroCardModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11021d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11156a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11158a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: friendsnearby */
        public class Serializer extends JsonSerializer<FavoriteMediaUserModel> {
            public final void m11159a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FavoriteMediaUserModel favoriteMediaUserModel = (FavoriteMediaUserModel) obj;
                if (favoriteMediaUserModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(favoriteMediaUserModel.m11160a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    favoriteMediaUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = favoriteMediaUserModel.w_();
                int u_ = favoriteMediaUserModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_intro_card");
                    ProfileIntroCardParser.m11193a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FavoriteMediaUserModel.class, new Serializer());
            }
        }

        public FavoriteMediaUserModel() {
            super(1);
        }

        public final void m11163a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11164a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final ProfileIntroCardModel m11162a() {
            this.f11022d = (ProfileIntroCardModel) super.a(this.f11022d, 0, ProfileIntroCardModel.class);
            return this.f11022d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m11161a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11162a() != null) {
                ProfileIntroCardModel profileIntroCardModel = (ProfileIntroCardModel) graphQLModelMutatingVisitor.b(m11162a());
                if (m11162a() != profileIntroCardModel) {
                    graphQLVisitableModel = (FavoriteMediaUserModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11022d = profileIntroCardModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11160a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11162a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1516699231)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: friendsnearby */
    public final class SuggestedMediaModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f11023d;
        @Nullable
        private String f11024e;
        @Nullable
        private DefaultImageFieldsModel f11025f;

        /* compiled from: friendsnearby */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SuggestedMediaModel.class, new Deserializer());
            }

            public Object m11165a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SuggestedMediaParser.m11195b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object suggestedMediaModel = new SuggestedMediaModel();
                ((BaseModel) suggestedMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (suggestedMediaModel instanceof Postprocessable) {
                    return ((Postprocessable) suggestedMediaModel).a();
                }
                return suggestedMediaModel;
            }
        }

        /* compiled from: friendsnearby */
        public class Serializer extends JsonSerializer<SuggestedMediaModel> {
            public final void m11166a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SuggestedMediaModel suggestedMediaModel = (SuggestedMediaModel) obj;
                if (suggestedMediaModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(suggestedMediaModel.m11168a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    suggestedMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SuggestedMediaParser.m11196b(suggestedMediaModel.w_(), suggestedMediaModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SuggestedMediaModel.class, new Serializer());
            }
        }

        public SuggestedMediaModel() {
            super(3);
        }

        @Nullable
        private GraphQLObjectType m11167l() {
            if (this.b != null && this.f11023d == null) {
                this.f11023d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f11023d;
        }

        @Nullable
        public final String m11171j() {
            this.f11024e = super.a(this.f11024e, 1);
            return this.f11024e;
        }

        @Nullable
        public final DefaultImageFieldsModel m11172k() {
            this.f11025f = (DefaultImageFieldsModel) super.a(this.f11025f, 2, DefaultImageFieldsModel.class);
            return this.f11025f;
        }

        @Nullable
        public final String m11170a() {
            return m11171j();
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m11169a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11172k() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m11172k());
                if (m11172k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SuggestedMediaModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11025f = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11168a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11167l());
            int b = flatBufferBuilder.b(m11171j());
            int a2 = ModelHelper.a(flatBufferBuilder, m11172k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -623093976)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: friendsnearby */
    public final class SuggestedMediasetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f11028d;
        @Nullable
        private String f11029e;
        @Nullable
        private MediaListModel f11030f;
        @Nullable
        private TitleModel f11031g;

        /* compiled from: friendsnearby */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SuggestedMediasetModel.class, new Deserializer());
            }

            public Object m11173a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SuggestedMediasetParser.m11201b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object suggestedMediasetModel = new SuggestedMediasetModel();
                ((BaseModel) suggestedMediasetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (suggestedMediasetModel instanceof Postprocessable) {
                    return ((Postprocessable) suggestedMediasetModel).a();
                }
                return suggestedMediasetModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1136564602)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: friendsnearby */
        public final class MediaListModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<SuggestedMediaModel> f11026d;

            /* compiled from: friendsnearby */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaListModel.class, new Deserializer());
                }

                public Object m11174a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaListParser.m11197a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaListModel = new MediaListModel();
                    ((BaseModel) mediaListModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaListModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaListModel).a();
                    }
                    return mediaListModel;
                }
            }

            /* compiled from: friendsnearby */
            public class Serializer extends JsonSerializer<MediaListModel> {
                public final void m11175a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaListModel mediaListModel = (MediaListModel) obj;
                    if (mediaListModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaListModel.m11176a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaListModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaListParser.m11198a(mediaListModel.w_(), mediaListModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaListModel.class, new Serializer());
                }
            }

            public MediaListModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<SuggestedMediaModel> m11178a() {
                this.f11026d = super.a(this.f11026d, 0, SuggestedMediaModel.class);
                return (ImmutableList) this.f11026d;
            }

            public final int jK_() {
                return 747633668;
            }

            public final GraphQLVisitableModel m11177a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11178a() != null) {
                    Builder a = ModelHelper.a(m11178a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MediaListModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11026d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11176a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11178a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: friendsnearby */
        public class Serializer extends JsonSerializer<SuggestedMediasetModel> {
            public final void m11179a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SuggestedMediasetModel suggestedMediasetModel = (SuggestedMediasetModel) obj;
                if (suggestedMediasetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(suggestedMediasetModel.m11186a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    suggestedMediasetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SuggestedMediasetParser.m11202b(suggestedMediasetModel.w_(), suggestedMediasetModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SuggestedMediasetModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: friendsnearby */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11027d;

            /* compiled from: friendsnearby */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m11180a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m11199a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object titleModel = new TitleModel();
                    ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (titleModel instanceof Postprocessable) {
                        return ((Postprocessable) titleModel).a();
                    }
                    return titleModel;
                }
            }

            /* compiled from: friendsnearby */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m11181a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m11182a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m11200a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m11184a() {
                this.f11027d = super.a(this.f11027d, 0);
                return this.f11027d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m11183a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m11182a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11184a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public SuggestedMediasetModel() {
            super(4);
        }

        @Nullable
        private GraphQLObjectType m11185m() {
            if (this.b != null && this.f11028d == null) {
                this.f11028d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f11028d;
        }

        @Nullable
        public final String m11189j() {
            this.f11029e = super.a(this.f11029e, 1);
            return this.f11029e;
        }

        @Nullable
        public final MediaListModel m11190k() {
            this.f11030f = (MediaListModel) super.a(this.f11030f, 2, MediaListModel.class);
            return this.f11030f;
        }

        @Nullable
        public final TitleModel m11191l() {
            this.f11031g = (TitleModel) super.a(this.f11031g, 3, TitleModel.class);
            return this.f11031g;
        }

        @Nullable
        public final String m11188a() {
            return m11189j();
        }

        public final int jK_() {
            return -836141570;
        }

        public final GraphQLVisitableModel m11187a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11190k() != null) {
                MediaListModel mediaListModel = (MediaListModel) graphQLModelMutatingVisitor.b(m11190k());
                if (m11190k() != mediaListModel) {
                    graphQLVisitableModel = (SuggestedMediasetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11030f = mediaListModel;
                }
            }
            if (m11191l() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m11191l());
                if (m11191l() != titleModel) {
                    graphQLVisitableModel = (SuggestedMediasetModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11031g = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11186a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11185m());
            int b = flatBufferBuilder.b(m11189j());
            int a2 = ModelHelper.a(flatBufferBuilder, m11190k());
            int a3 = ModelHelper.a(flatBufferBuilder, m11191l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
