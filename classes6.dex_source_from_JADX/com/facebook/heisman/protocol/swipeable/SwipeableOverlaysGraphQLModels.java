package com.facebook.heisman.protocol.swipeable;

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
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLParsers.ImageOverlayWithSwipeableOverlaysParser;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLParsers.ImageOverlayWithSwipeableOverlaysParser.AssociatedPagesParser;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLParsers.ImageOverlayWithSwipeableOverlaysParser.AssociatedPagesParser.ProfilePictureOverlaysParser;
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

/* compiled from: mLastFetchTime */
public class SwipeableOverlaysGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1505588769)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mLastFetchTime */
    public final class ImageOverlayWithSwipeableOverlaysModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f11040d;
        @Nullable
        private List<AssociatedPagesModel> f11041e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2059780032)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mLastFetchTime */
        public final class AssociatedPagesModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f11038d;
            @Nullable
            private ProfilePictureOverlaysModel f11039e;

            /* compiled from: mLastFetchTime */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AssociatedPagesModel.class, new Deserializer());
                }

                public Object m17744a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AssociatedPagesParser.m17766b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object associatedPagesModel = new AssociatedPagesModel();
                    ((BaseModel) associatedPagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (associatedPagesModel instanceof Postprocessable) {
                        return ((Postprocessable) associatedPagesModel).a();
                    }
                    return associatedPagesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 139467847)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: mLastFetchTime */
            public final class ProfilePictureOverlaysModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<ImageOverlayFieldsModel> f11037d;

                /* compiled from: mLastFetchTime */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProfilePictureOverlaysModel.class, new Deserializer());
                    }

                    public Object m17745a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfilePictureOverlaysParser.m17764a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object profilePictureOverlaysModel = new ProfilePictureOverlaysModel();
                        ((BaseModel) profilePictureOverlaysModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (profilePictureOverlaysModel instanceof Postprocessable) {
                            return ((Postprocessable) profilePictureOverlaysModel).a();
                        }
                        return profilePictureOverlaysModel;
                    }
                }

                /* compiled from: mLastFetchTime */
                public class Serializer extends JsonSerializer<ProfilePictureOverlaysModel> {
                    public final void m17746a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProfilePictureOverlaysModel profilePictureOverlaysModel = (ProfilePictureOverlaysModel) obj;
                        if (profilePictureOverlaysModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(profilePictureOverlaysModel.m17747a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            profilePictureOverlaysModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfilePictureOverlaysParser.m17765a(profilePictureOverlaysModel.w_(), profilePictureOverlaysModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ProfilePictureOverlaysModel.class, new Serializer());
                    }
                }

                public ProfilePictureOverlaysModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<ImageOverlayFieldsModel> m17749a() {
                    this.f11037d = super.a(this.f11037d, 0, ImageOverlayFieldsModel.class);
                    return (ImmutableList) this.f11037d;
                }

                public final int jK_() {
                    return -2035491803;
                }

                public final GraphQLVisitableModel m17748a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17749a() != null) {
                        Builder a = ModelHelper.a(m17749a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (ProfilePictureOverlaysModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11037d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17747a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m17749a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: mLastFetchTime */
            public class Serializer extends JsonSerializer<AssociatedPagesModel> {
                public final void m17750a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AssociatedPagesModel associatedPagesModel = (AssociatedPagesModel) obj;
                    if (associatedPagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(associatedPagesModel.m17753a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        associatedPagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AssociatedPagesParser.m17767b(associatedPagesModel.w_(), associatedPagesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AssociatedPagesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ProfilePictureOverlaysModel m17755a() {
                return m17752k();
            }

            public AssociatedPagesModel() {
                super(2);
            }

            public final void m17756a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17757a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m17751j() {
                if (this.b != null && this.f11038d == null) {
                    this.f11038d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f11038d;
            }

            @Nullable
            private ProfilePictureOverlaysModel m17752k() {
                this.f11039e = (ProfilePictureOverlaysModel) super.a(this.f11039e, 1, ProfilePictureOverlaysModel.class);
                return this.f11039e;
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m17754a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17752k() != null) {
                    ProfilePictureOverlaysModel profilePictureOverlaysModel = (ProfilePictureOverlaysModel) graphQLModelMutatingVisitor.b(m17752k());
                    if (m17752k() != profilePictureOverlaysModel) {
                        graphQLVisitableModel = (AssociatedPagesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11039e = profilePictureOverlaysModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17753a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17751j());
                int a2 = ModelHelper.a(flatBufferBuilder, m17752k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mLastFetchTime */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ImageOverlayWithSwipeableOverlaysModel.class, new Deserializer());
            }

            public Object m17758a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ImageOverlayWithSwipeableOverlaysParser.m17768a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object imageOverlayWithSwipeableOverlaysModel = new ImageOverlayWithSwipeableOverlaysModel();
                ((BaseModel) imageOverlayWithSwipeableOverlaysModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (imageOverlayWithSwipeableOverlaysModel instanceof Postprocessable) {
                    return ((Postprocessable) imageOverlayWithSwipeableOverlaysModel).a();
                }
                return imageOverlayWithSwipeableOverlaysModel;
            }
        }

        /* compiled from: mLastFetchTime */
        public class Serializer extends JsonSerializer<ImageOverlayWithSwipeableOverlaysModel> {
            public final void m17759a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ImageOverlayWithSwipeableOverlaysModel imageOverlayWithSwipeableOverlaysModel = (ImageOverlayWithSwipeableOverlaysModel) obj;
                if (imageOverlayWithSwipeableOverlaysModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(imageOverlayWithSwipeableOverlaysModel.m17761a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    imageOverlayWithSwipeableOverlaysModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = imageOverlayWithSwipeableOverlaysModel.w_();
                int u_ = imageOverlayWithSwipeableOverlaysModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("associated_pages");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        AssociatedPagesParser.m17767b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ImageOverlayWithSwipeableOverlaysModel.class, new Serializer());
            }
        }

        public ImageOverlayWithSwipeableOverlaysModel() {
            super(2);
        }

        @Nullable
        private GraphQLObjectType m17760j() {
            if (this.b != null && this.f11040d == null) {
                this.f11040d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f11040d;
        }

        @Nonnull
        public final ImmutableList<AssociatedPagesModel> m17763a() {
            this.f11041e = super.a(this.f11041e, 1, AssociatedPagesModel.class);
            return (ImmutableList) this.f11041e;
        }

        public final int jK_() {
            return -328705387;
        }

        public final GraphQLVisitableModel m17762a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17763a() != null) {
                Builder a = ModelHelper.a(m17763a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ImageOverlayWithSwipeableOverlaysModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11041e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17761a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17760j());
            int a2 = ModelHelper.a(flatBufferBuilder, m17763a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
