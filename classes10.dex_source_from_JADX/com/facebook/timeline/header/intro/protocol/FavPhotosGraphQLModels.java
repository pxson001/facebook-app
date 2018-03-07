package com.facebook.timeline.header.intro.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.header.intro.protocol.FavPhotosGraphQLParsers.FavPhotosQueryParser;
import com.facebook.timeline.header.intro.protocol.FavPhotosGraphQLParsers.FavPhotosQueryParser.ProfileIntroCardParser;
import com.facebook.timeline.header.intro.protocol.FavPhotosGraphQLParsers.FavPhotosQueryParser.ProfileIntroCardParser.FavoritePhotosParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.FavoritePhotoModel;
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

/* compiled from: fetch_group_possible_purposes */
public class FavPhotosGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1066617458)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetch_group_possible_purposes */
    public final class FavPhotosQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ProfileIntroCardModel f11843d;

        /* compiled from: fetch_group_possible_purposes */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FavPhotosQueryModel.class, new Deserializer());
            }

            public Object m11917a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FavPhotosQueryParser.m11940a(jsonParser);
                Object favPhotosQueryModel = new FavPhotosQueryModel();
                ((BaseModel) favPhotosQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (favPhotosQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) favPhotosQueryModel).a();
                }
                return favPhotosQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1373935539)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fetch_group_possible_purposes */
        public final class ProfileIntroCardModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FavoritePhotosModel f11841d;
            private boolean f11842e;

            /* compiled from: fetch_group_possible_purposes */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileIntroCardModel.class, new Deserializer());
                }

                public Object m11918a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileIntroCardParser.m11938a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 813627492)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: fetch_group_possible_purposes */
            public final class FavoritePhotosModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<FavoritePhotoModel> f11840d;

                /* compiled from: fetch_group_possible_purposes */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FavoritePhotosModel.class, new Deserializer());
                    }

                    public Object m11919a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FavoritePhotosParser.m11936a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object favoritePhotosModel = new FavoritePhotosModel();
                        ((BaseModel) favoritePhotosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (favoritePhotosModel instanceof Postprocessable) {
                            return ((Postprocessable) favoritePhotosModel).a();
                        }
                        return favoritePhotosModel;
                    }
                }

                /* compiled from: fetch_group_possible_purposes */
                public class Serializer extends JsonSerializer<FavoritePhotosModel> {
                    public final void m11920a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FavoritePhotosModel favoritePhotosModel = (FavoritePhotosModel) obj;
                        if (favoritePhotosModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(favoritePhotosModel.m11921a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            favoritePhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FavoritePhotosParser.m11937a(favoritePhotosModel.w_(), favoritePhotosModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(FavoritePhotosModel.class, new Serializer());
                    }
                }

                public FavoritePhotosModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<FavoritePhotoModel> m11923a() {
                    this.f11840d = super.a(this.f11840d, 0, FavoritePhotoModel.class);
                    return (ImmutableList) this.f11840d;
                }

                public final int jK_() {
                    return 520734144;
                }

                public final GraphQLVisitableModel m11922a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m11923a() != null) {
                        Builder a = ModelHelper.a(m11923a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (FavoritePhotosModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11840d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m11921a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m11923a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: fetch_group_possible_purposes */
            public class Serializer extends JsonSerializer<ProfileIntroCardModel> {
                public final void m11924a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileIntroCardModel profileIntroCardModel = (ProfileIntroCardModel) obj;
                    if (profileIntroCardModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileIntroCardModel.m11925a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileIntroCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileIntroCardParser.m11939a(profileIntroCardModel.w_(), profileIntroCardModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileIntroCardModel.class, new Serializer());
                }
            }

            public ProfileIntroCardModel() {
                super(2);
            }

            @Nullable
            public final FavoritePhotosModel m11927a() {
                this.f11841d = (FavoritePhotosModel) super.a(this.f11841d, 0, FavoritePhotosModel.class);
                return this.f11841d;
            }

            public final boolean m11929j() {
                a(0, 1);
                return this.f11842e;
            }

            public final int jK_() {
                return 2102913043;
            }

            public final GraphQLVisitableModel m11926a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11927a() != null) {
                    FavoritePhotosModel favoritePhotosModel = (FavoritePhotosModel) graphQLModelMutatingVisitor.b(m11927a());
                    if (m11927a() != favoritePhotosModel) {
                        graphQLVisitableModel = (ProfileIntroCardModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11841d = favoritePhotosModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11925a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11927a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f11842e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m11928a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11842e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: fetch_group_possible_purposes */
        public class Serializer extends JsonSerializer<FavPhotosQueryModel> {
            public final void m11930a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FavPhotosQueryModel favPhotosQueryModel = (FavPhotosQueryModel) obj;
                if (favPhotosQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(favPhotosQueryModel.m11931a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    favPhotosQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = favPhotosQueryModel.w_();
                int u_ = favPhotosQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_intro_card");
                    ProfileIntroCardParser.m11939a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FavPhotosQueryModel.class, new Serializer());
            }
        }

        public FavPhotosQueryModel() {
            super(1);
        }

        public final void m11934a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11935a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final ProfileIntroCardModel m11933a() {
            this.f11843d = (ProfileIntroCardModel) super.a(this.f11843d, 0, ProfileIntroCardModel.class);
            return this.f11843d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m11932a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11933a() != null) {
                ProfileIntroCardModel profileIntroCardModel = (ProfileIntroCardModel) graphQLModelMutatingVisitor.b(m11933a());
                if (m11933a() != profileIntroCardModel) {
                    graphQLVisitableModel = (FavPhotosQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11843d = profileIntroCardModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11931a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11933a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
