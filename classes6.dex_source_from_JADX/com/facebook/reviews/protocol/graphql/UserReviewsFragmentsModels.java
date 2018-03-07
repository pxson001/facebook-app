package com.facebook.reviews.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultAddressFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewBasicFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewBasicFieldsModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewWithFeedbackModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.PlaceToReviewParser;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.PlaceToReviewParser.ProfilePhotoParser;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.PlaceToReviewParser.ProfilePhotoParser.ImageParser;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.PlaceToReviewParser.ViewerStarRatingParser;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.PlacesToReviewParser;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.PlacesToReviewParser.PlaceReviewSuggestionsParser;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.PlacesToReviewParser.PlaceReviewSuggestionsParser.PageInfoParser;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.UpdatedPageReviewParser;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.UpdatedPageReviewParser.ReviewStoryParser;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.UserReviewsParser;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.UserReviewsParser.AuthoredReviewsParser;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.UserReviewsParser.AuthoredReviewsParser.EdgesParser;
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

/* compiled from: setInitialStickerData */
public class UserReviewsFragmentsModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1913182819)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: setInitialStickerData */
    public final class PlaceToReviewModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private DefaultAddressFieldsModel f4726d;
        @Nullable
        private String f4727e;
        @Nullable
        private String f4728f;
        @Nullable
        private ProfilePhotoModel f4729g;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f4730h;
        @Nullable
        private ReviewBasicFieldsModel f4731i;
        @Nullable
        private ViewerStarRatingModel f4732j;

        /* compiled from: setInitialStickerData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceToReviewModel.class, new Deserializer());
            }

            public Object m7401a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlaceToReviewParser.m7515b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object placeToReviewModel = new PlaceToReviewModel();
                ((BaseModel) placeToReviewModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (placeToReviewModel instanceof Postprocessable) {
                    return ((Postprocessable) placeToReviewModel).a();
                }
                return placeToReviewModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1630136940)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setInitialStickerData */
        public final class ProfilePhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ImageModel f4723d;

            /* compiled from: setInitialStickerData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePhotoModel.class, new Deserializer());
                }

                public Object m7402a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePhotoParser.m7511a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilePhotoModel = new ProfilePhotoModel();
                    ((BaseModel) profilePhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilePhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) profilePhotoModel).a();
                    }
                    return profilePhotoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setInitialStickerData */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f4722d;

                /* compiled from: setInitialStickerData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                    }

                    public Object m7403a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageParser.m7509a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object imageModel = new ImageModel();
                        ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (imageModel instanceof Postprocessable) {
                            return ((Postprocessable) imageModel).a();
                        }
                        return imageModel;
                    }
                }

                /* compiled from: setInitialStickerData */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m7404a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageModel imageModel = (ImageModel) obj;
                        if (imageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageModel.m7405a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageParser.m7510a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImageModel.class, new Serializer());
                    }
                }

                public ImageModel() {
                    super(1);
                }

                @Nullable
                public final String m7407a() {
                    this.f4722d = super.a(this.f4722d, 0);
                    return this.f4722d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m7406a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m7405a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m7407a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: setInitialStickerData */
            public class Serializer extends JsonSerializer<ProfilePhotoModel> {
                public final void m7408a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePhotoModel profilePhotoModel = (ProfilePhotoModel) obj;
                    if (profilePhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePhotoModel.m7410a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePhotoParser.m7512a(profilePhotoModel.w_(), profilePhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfilePhotoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ImageModel m7412a() {
                return m7409j();
            }

            public ProfilePhotoModel() {
                super(1);
            }

            @Nullable
            private ImageModel m7409j() {
                this.f4723d = (ImageModel) super.a(this.f4723d, 0, ImageModel.class);
                return this.f4723d;
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m7411a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7409j() != null) {
                    ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m7409j());
                    if (m7409j() != imageModel) {
                        graphQLVisitableModel = (ProfilePhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4723d = imageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7410a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7409j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: setInitialStickerData */
        public class Serializer extends JsonSerializer<PlaceToReviewModel> {
            public final void m7413a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlaceToReviewModel placeToReviewModel = (PlaceToReviewModel) obj;
                if (placeToReviewModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeToReviewModel.m7425a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeToReviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlaceToReviewParser.m7516b(placeToReviewModel.w_(), placeToReviewModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlaceToReviewModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -963013398)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setInitialStickerData */
        public final class ViewerStarRatingModel extends BaseModel implements GraphQLVisitableModel {
            private int f4724d;
            private double f4725e;

            /* compiled from: setInitialStickerData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerStarRatingModel.class, new Deserializer());
                }

                public Object m7414a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerStarRatingParser.m7513a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerStarRatingModel = new ViewerStarRatingModel();
                    ((BaseModel) viewerStarRatingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerStarRatingModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerStarRatingModel).a();
                    }
                    return viewerStarRatingModel;
                }
            }

            /* compiled from: setInitialStickerData */
            public class Serializer extends JsonSerializer<ViewerStarRatingModel> {
                public final void m7415a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerStarRatingModel viewerStarRatingModel = (ViewerStarRatingModel) obj;
                    if (viewerStarRatingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerStarRatingModel.m7417a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerStarRatingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerStarRatingParser.m7514a(viewerStarRatingModel.w_(), viewerStarRatingModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ViewerStarRatingModel.class, new Serializer());
                }
            }

            public ViewerStarRatingModel() {
                super(2);
            }

            public final double m7416a() {
                a(0, 1);
                return this.f4725e;
            }

            public final int jK_() {
                return -1854235203;
            }

            public final GraphQLVisitableModel m7418a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7417a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f4724d, 0);
                flatBufferBuilder.a(1, this.f4725e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7419a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f4724d = mutableFlatBuffer.a(i, 0, 0);
                this.f4725e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        @Nullable
        public final /* synthetic */ DefaultAddressFieldsModel m7430b() {
            return m7420j();
        }

        @Nullable
        public final /* synthetic */ ViewerStarRatingModel bQ_() {
            return m7424n();
        }

        @Nullable
        public final /* synthetic */ ReviewBasicFields bR_() {
            return m7423m();
        }

        @Nullable
        public final /* synthetic */ ProfilePhotoModel bS_() {
            return m7421k();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields m7433g() {
            return m7422l();
        }

        public PlaceToReviewModel() {
            super(7);
        }

        public final void m7428a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7429a(String str, Object obj, boolean z) {
        }

        @Nullable
        private DefaultAddressFieldsModel m7420j() {
            this.f4726d = (DefaultAddressFieldsModel) super.a(this.f4726d, 0, DefaultAddressFieldsModel.class);
            return this.f4726d;
        }

        @Nullable
        public final String m7431c() {
            this.f4727e = super.a(this.f4727e, 1);
            return this.f4727e;
        }

        @Nullable
        public final String m7432d() {
            this.f4728f = super.a(this.f4728f, 2);
            return this.f4728f;
        }

        @Nullable
        private ProfilePhotoModel m7421k() {
            this.f4729g = (ProfilePhotoModel) super.a(this.f4729g, 3, ProfilePhotoModel.class);
            return this.f4729g;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m7422l() {
            this.f4730h = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f4730h, 4, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f4730h;
        }

        @Nullable
        private ReviewBasicFieldsModel m7423m() {
            this.f4731i = (ReviewBasicFieldsModel) super.a(this.f4731i, 5, ReviewBasicFieldsModel.class);
            return this.f4731i;
        }

        @Nullable
        private ViewerStarRatingModel m7424n() {
            this.f4732j = (ViewerStarRatingModel) super.a(this.f4732j, 6, ViewerStarRatingModel.class);
            return this.f4732j;
        }

        @Nullable
        public final String m7427a() {
            return m7431c();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m7426a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7420j() != null) {
                DefaultAddressFieldsModel defaultAddressFieldsModel = (DefaultAddressFieldsModel) graphQLModelMutatingVisitor.b(m7420j());
                if (m7420j() != defaultAddressFieldsModel) {
                    graphQLVisitableModel = (PlaceToReviewModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4726d = defaultAddressFieldsModel;
                }
            }
            if (m7421k() != null) {
                ProfilePhotoModel profilePhotoModel = (ProfilePhotoModel) graphQLModelMutatingVisitor.b(m7421k());
                if (m7421k() != profilePhotoModel) {
                    graphQLVisitableModel = (PlaceToReviewModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4729g = profilePhotoModel;
                }
            }
            if (m7422l() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m7422l());
                if (m7422l() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (PlaceToReviewModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4730h = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m7423m() != null) {
                ReviewBasicFieldsModel reviewBasicFieldsModel = (ReviewBasicFieldsModel) graphQLModelMutatingVisitor.b(m7423m());
                if (m7423m() != reviewBasicFieldsModel) {
                    graphQLVisitableModel = (PlaceToReviewModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4731i = reviewBasicFieldsModel;
                }
            }
            if (m7424n() != null) {
                ViewerStarRatingModel viewerStarRatingModel = (ViewerStarRatingModel) graphQLModelMutatingVisitor.b(m7424n());
                if (m7424n() != viewerStarRatingModel) {
                    graphQLVisitableModel = (PlaceToReviewModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4732j = viewerStarRatingModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7425a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7420j());
            int b = flatBufferBuilder.b(m7431c());
            int b2 = flatBufferBuilder.b(m7432d());
            int a2 = ModelHelper.a(flatBufferBuilder, m7421k());
            int a3 = ModelHelper.a(flatBufferBuilder, m7422l());
            int a4 = ModelHelper.a(flatBufferBuilder, m7423m());
            int a5 = ModelHelper.a(flatBufferBuilder, m7424n());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2018910301)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: setInitialStickerData */
    public final class PlacesToReviewModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PlaceReviewSuggestionsModel f4737d;

        /* compiled from: setInitialStickerData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlacesToReviewModel.class, new Deserializer());
            }

            public Object m7434a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PlacesToReviewParser.m7521a(jsonParser);
                Object placesToReviewModel = new PlacesToReviewModel();
                ((BaseModel) placesToReviewModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (placesToReviewModel instanceof Postprocessable) {
                    return ((Postprocessable) placesToReviewModel).a();
                }
                return placesToReviewModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1783138832)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: setInitialStickerData */
        public final class PlaceReviewSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PlaceToReviewModel> f4735d;
            @Nullable
            private PageInfoModel f4736e;

            /* compiled from: setInitialStickerData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceReviewSuggestionsModel.class, new Deserializer());
                }

                public Object m7435a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceReviewSuggestionsParser.m7519a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeReviewSuggestionsModel = new PlaceReviewSuggestionsModel();
                    ((BaseModel) placeReviewSuggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeReviewSuggestionsModel instanceof Postprocessable) {
                        return ((Postprocessable) placeReviewSuggestionsModel).a();
                    }
                    return placeReviewSuggestionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2005169142)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setInitialStickerData */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f4733d;
                private boolean f4734e;

                /* compiled from: setInitialStickerData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m7436a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInfoParser.m7517a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: setInitialStickerData */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m7437a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m7438a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInfoParser.m7518a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(2);
                }

                @Nullable
                public final String m7440a() {
                    this.f4733d = super.a(this.f4733d, 0);
                    return this.f4733d;
                }

                public final boolean m7442b() {
                    a(0, 1);
                    return this.f4734e;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m7439a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m7438a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m7440a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f4734e);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m7441a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f4734e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: setInitialStickerData */
            public class Serializer extends JsonSerializer<PlaceReviewSuggestionsModel> {
                public final void m7443a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceReviewSuggestionsModel placeReviewSuggestionsModel = (PlaceReviewSuggestionsModel) obj;
                    if (placeReviewSuggestionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeReviewSuggestionsModel.m7445a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeReviewSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceReviewSuggestionsParser.m7520a(placeReviewSuggestionsModel.w_(), placeReviewSuggestionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PlaceReviewSuggestionsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PageInfoModel m7448b() {
                return m7444j();
            }

            public PlaceReviewSuggestionsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<PlaceToReviewModel> m7447a() {
                this.f4735d = super.a(this.f4735d, 0, PlaceToReviewModel.class);
                return (ImmutableList) this.f4735d;
            }

            @Nullable
            private PageInfoModel m7444j() {
                this.f4736e = (PageInfoModel) super.a(this.f4736e, 1, PageInfoModel.class);
                return this.f4736e;
            }

            public final int jK_() {
                return -23152306;
            }

            public final GraphQLVisitableModel m7446a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m7447a() != null) {
                    Builder a = ModelHelper.a(m7447a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PlaceReviewSuggestionsModel placeReviewSuggestionsModel = (PlaceReviewSuggestionsModel) ModelHelper.a(null, this);
                        placeReviewSuggestionsModel.f4735d = a.b();
                        graphQLVisitableModel = placeReviewSuggestionsModel;
                        if (m7444j() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m7444j());
                            if (m7444j() != pageInfoModel) {
                                graphQLVisitableModel = (PlaceReviewSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f4736e = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m7444j() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m7444j());
                    if (m7444j() != pageInfoModel) {
                        graphQLVisitableModel = (PlaceReviewSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4736e = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m7445a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7447a());
                int a2 = ModelHelper.a(flatBufferBuilder, m7444j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: setInitialStickerData */
        public class Serializer extends JsonSerializer<PlacesToReviewModel> {
            public final void m7449a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PlacesToReviewModel placesToReviewModel = (PlacesToReviewModel) obj;
                if (placesToReviewModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placesToReviewModel.m7451a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placesToReviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = placesToReviewModel.w_();
                int u_ = placesToReviewModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("place_review_suggestions");
                    PlaceReviewSuggestionsParser.m7520a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PlacesToReviewModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PlaceReviewSuggestionsModel m7453a() {
            return m7450j();
        }

        public PlacesToReviewModel() {
            super(1);
        }

        public final void m7454a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7455a(String str, Object obj, boolean z) {
        }

        @Nullable
        private PlaceReviewSuggestionsModel m7450j() {
            this.f4737d = (PlaceReviewSuggestionsModel) super.a(this.f4737d, 0, PlaceReviewSuggestionsModel.class);
            return this.f4737d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m7452a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7450j() != null) {
                PlaceReviewSuggestionsModel placeReviewSuggestionsModel = (PlaceReviewSuggestionsModel) graphQLModelMutatingVisitor.b(m7450j());
                if (m7450j() != placeReviewSuggestionsModel) {
                    graphQLVisitableModel = (PlacesToReviewModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4737d = placeReviewSuggestionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7451a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7450j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1659992557)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: setInitialStickerData */
    public final class UpdatedPageReviewModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ReviewStoryModel f4739d;

        /* compiled from: setInitialStickerData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UpdatedPageReviewModel.class, new Deserializer());
            }

            public Object m7456a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UpdatedPageReviewParser.m7524a(jsonParser);
                Object updatedPageReviewModel = new UpdatedPageReviewModel();
                ((BaseModel) updatedPageReviewModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (updatedPageReviewModel instanceof Postprocessable) {
                    return ((Postprocessable) updatedPageReviewModel).a();
                }
                return updatedPageReviewModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1557230990)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: setInitialStickerData */
        public final class ReviewStoryModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLStory f4738d;

            /* compiled from: setInitialStickerData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReviewStoryModel.class, new Deserializer());
                }

                public Object m7457a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReviewStoryParser.m7522a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reviewStoryModel = new ReviewStoryModel();
                    ((BaseModel) reviewStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reviewStoryModel instanceof Postprocessable) {
                        return ((Postprocessable) reviewStoryModel).a();
                    }
                    return reviewStoryModel;
                }
            }

            /* compiled from: setInitialStickerData */
            public class Serializer extends JsonSerializer<ReviewStoryModel> {
                public final void m7458a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReviewStoryModel reviewStoryModel = (ReviewStoryModel) obj;
                    if (reviewStoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reviewStoryModel.m7459a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reviewStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReviewStoryParser.m7523a(reviewStoryModel.w_(), reviewStoryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReviewStoryModel.class, new Serializer());
                }
            }

            public ReviewStoryModel() {
                super(1);
            }

            @Nullable
            public final GraphQLStory m7460a() {
                this.f4738d = (GraphQLStory) super.a(this.f4738d, 0, GraphQLStory.class);
                return this.f4738d;
            }

            public final int jK_() {
                return -131209055;
            }

            public final GraphQLVisitableModel m7461a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7460a() != null) {
                    GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m7460a());
                    if (m7460a() != graphQLStory) {
                        graphQLVisitableModel = (ReviewStoryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4738d = graphQLStory;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7459a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7460a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: setInitialStickerData */
        public class Serializer extends JsonSerializer<UpdatedPageReviewModel> {
            public final void m7462a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UpdatedPageReviewModel updatedPageReviewModel = (UpdatedPageReviewModel) obj;
                if (updatedPageReviewModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(updatedPageReviewModel.m7464a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    updatedPageReviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = updatedPageReviewModel.w_();
                int u_ = updatedPageReviewModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("review_story");
                    ReviewStoryParser.m7523a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UpdatedPageReviewModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ReviewStoryModel m7466a() {
            return m7463j();
        }

        public UpdatedPageReviewModel() {
            super(1);
        }

        public final void m7467a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7468a(String str, Object obj, boolean z) {
        }

        @Nullable
        private ReviewStoryModel m7463j() {
            this.f4739d = (ReviewStoryModel) super.a(this.f4739d, 0, ReviewStoryModel.class);
            return this.f4739d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m7465a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7463j() != null) {
                ReviewStoryModel reviewStoryModel = (ReviewStoryModel) graphQLModelMutatingVisitor.b(m7463j());
                if (m7463j() != reviewStoryModel) {
                    graphQLVisitableModel = (UpdatedPageReviewModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4739d = reviewStoryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7464a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7463j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2016126681)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: setInitialStickerData */
    public final class UserReviewsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AuthoredReviewsModel f4750d;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -619701358)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: setInitialStickerData */
        public final class AuthoredReviewsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f4748d;
            @Nullable
            private PageInfoModel f4749e;

            /* compiled from: setInitialStickerData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AuthoredReviewsModel.class, new Deserializer());
                }

                public Object m7469a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AuthoredReviewsParser.m7531a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object authoredReviewsModel = new AuthoredReviewsModel();
                    ((BaseModel) authoredReviewsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (authoredReviewsModel instanceof Postprocessable) {
                        return ((Postprocessable) authoredReviewsModel).a();
                    }
                    return authoredReviewsModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1621386063)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: setInitialStickerData */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ReviewStoryModel f4744d;
                @Nullable
                private ReviewWithFeedbackModel f4745e;

                /* compiled from: setInitialStickerData */
                public final class Builder {
                    @Nullable
                    public ReviewStoryModel f4740a;
                    @Nullable
                    public ReviewWithFeedbackModel f4741b;

                    public static Builder m7470a(EdgesModel edgesModel) {
                        Builder builder = new Builder();
                        builder.f4740a = edgesModel.m7486j();
                        builder.f4741b = edgesModel.m7487k();
                        return builder;
                    }

                    public final EdgesModel m7471a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f4740a);
                        int a2 = ModelHelper.a(flatBufferBuilder, this.f4741b);
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: setInitialStickerData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m7472a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m7527b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                @FragmentModelWithBridge
                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1557230990)
                @JsonSerialize(using = Serializer.class)
                /* compiled from: setInitialStickerData */
                public final class ReviewStoryModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GraphQLStory f4743d;

                    /* compiled from: setInitialStickerData */
                    public final class Builder {
                        @Nullable
                        public GraphQLStory f4742a;

                        public final ReviewStoryModel m7473a() {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int a = ModelHelper.a(flatBufferBuilder, this.f4742a);
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            ReviewStoryModel reviewStoryModel = new ReviewStoryModel(new MutableFlatBuffer(wrap, null, null, true, null));
                            if (this.f4742a != null) {
                                reviewStoryModel.m7478a().aN = this.f4742a.U_();
                            }
                            return reviewStoryModel;
                        }
                    }

                    /* compiled from: setInitialStickerData */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ReviewStoryModel.class, new Deserializer());
                        }

                        public Object m7474a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.ReviewStoryParser.m7525a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object reviewStoryModel = new ReviewStoryModel();
                            ((BaseModel) reviewStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (reviewStoryModel instanceof Postprocessable) {
                                return ((Postprocessable) reviewStoryModel).a();
                            }
                            return reviewStoryModel;
                        }
                    }

                    /* compiled from: setInitialStickerData */
                    public class Serializer extends JsonSerializer<ReviewStoryModel> {
                        public final void m7475a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ReviewStoryModel reviewStoryModel = (ReviewStoryModel) obj;
                            if (reviewStoryModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(reviewStoryModel.m7477a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                reviewStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.ReviewStoryParser.m7526a(reviewStoryModel.w_(), reviewStoryModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(ReviewStoryModel.class, new Serializer());
                        }
                    }

                    public ReviewStoryModel() {
                        super(1);
                    }

                    public ReviewStoryModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final GraphQLStory m7478a() {
                        this.f4743d = (GraphQLStory) super.a(this.f4743d, 0, GraphQLStory.class);
                        return this.f4743d;
                    }

                    public static ReviewStoryModel m7476a(ReviewStoryModel reviewStoryModel) {
                        if (reviewStoryModel == null) {
                            return null;
                        }
                        if (reviewStoryModel instanceof ReviewStoryModel) {
                            return reviewStoryModel;
                        }
                        Builder builder = new Builder();
                        builder.f4742a = reviewStoryModel.m7478a();
                        return builder.m7473a();
                    }

                    public final int jK_() {
                        return -131209055;
                    }

                    public final GraphQLVisitableModel m7479a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m7478a() != null) {
                            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m7478a());
                            if (m7478a() != graphQLStory) {
                                graphQLVisitableModel = (ReviewStoryModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4743d = graphQLStory;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m7477a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m7478a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: setInitialStickerData */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m7480a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m7482a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m7528b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ReviewStoryModel m7484a() {
                    return m7486j();
                }

                @Nullable
                public final /* synthetic */ ReviewWithFeedback m7485b() {
                    return m7487k();
                }

                public EdgesModel() {
                    super(2);
                }

                public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final ReviewStoryModel m7486j() {
                    this.f4744d = (ReviewStoryModel) super.a(this.f4744d, 0, ReviewStoryModel.class);
                    return this.f4744d;
                }

                @Nullable
                public final ReviewWithFeedbackModel m7487k() {
                    this.f4745e = (ReviewWithFeedbackModel) super.a(this.f4745e, 1, ReviewWithFeedbackModel.class);
                    return this.f4745e;
                }

                public static EdgesModel m7481a(EdgesModel edgesModel) {
                    if (edgesModel == null) {
                        return null;
                    }
                    if (edgesModel instanceof EdgesModel) {
                        return edgesModel;
                    }
                    Builder builder = new Builder();
                    builder.f4740a = ReviewStoryModel.m7476a(edgesModel.m7484a());
                    builder.f4741b = ReviewWithFeedbackModel.m7261a(edgesModel.m7485b());
                    return builder.m7471a();
                }

                public final int jK_() {
                    return -1250101160;
                }

                public final GraphQLVisitableModel m7483a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m7486j() != null) {
                        ReviewStoryModel reviewStoryModel = (ReviewStoryModel) graphQLModelMutatingVisitor.b(m7486j());
                        if (m7486j() != reviewStoryModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4744d = reviewStoryModel;
                        }
                    }
                    if (m7487k() != null) {
                        ReviewWithFeedbackModel reviewWithFeedbackModel = (ReviewWithFeedbackModel) graphQLModelMutatingVisitor.b(m7487k());
                        if (m7487k() != reviewWithFeedbackModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4745e = reviewWithFeedbackModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m7482a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m7486j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m7487k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2005169142)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setInitialStickerData */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f4746d;
                private boolean f4747e;

                /* compiled from: setInitialStickerData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m7488a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AuthoredReviewsParser.PageInfoParser.m7529a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: setInitialStickerData */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m7489a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m7490a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AuthoredReviewsParser.PageInfoParser.m7530a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(2);
                }

                @Nullable
                public final String m7492a() {
                    this.f4746d = super.a(this.f4746d, 0);
                    return this.f4746d;
                }

                public final boolean m7494b() {
                    a(0, 1);
                    return this.f4747e;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m7491a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m7490a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m7492a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f4747e);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m7493a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f4747e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: setInitialStickerData */
            public class Serializer extends JsonSerializer<AuthoredReviewsModel> {
                public final void m7495a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AuthoredReviewsModel authoredReviewsModel = (AuthoredReviewsModel) obj;
                    if (authoredReviewsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(authoredReviewsModel.m7497a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        authoredReviewsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AuthoredReviewsParser.m7532a(authoredReviewsModel.w_(), authoredReviewsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AuthoredReviewsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PageInfoModel m7500b() {
                return m7496j();
            }

            public AuthoredReviewsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m7499a() {
                this.f4748d = super.a(this.f4748d, 0, EdgesModel.class);
                return (ImmutableList) this.f4748d;
            }

            @Nullable
            private PageInfoModel m7496j() {
                this.f4749e = (PageInfoModel) super.a(this.f4749e, 1, PageInfoModel.class);
                return this.f4749e;
            }

            public final int jK_() {
                return -1129813703;
            }

            public final GraphQLVisitableModel m7498a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m7499a() != null) {
                    Builder a = ModelHelper.a(m7499a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        AuthoredReviewsModel authoredReviewsModel = (AuthoredReviewsModel) ModelHelper.a(null, this);
                        authoredReviewsModel.f4748d = a.b();
                        graphQLVisitableModel = authoredReviewsModel;
                        if (m7496j() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m7496j());
                            if (m7496j() != pageInfoModel) {
                                graphQLVisitableModel = (AuthoredReviewsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f4749e = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m7496j() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m7496j());
                    if (m7496j() != pageInfoModel) {
                        graphQLVisitableModel = (AuthoredReviewsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4749e = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m7497a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7499a());
                int a2 = ModelHelper.a(flatBufferBuilder, m7496j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: setInitialStickerData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UserReviewsModel.class, new Deserializer());
            }

            public Object m7501a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UserReviewsParser.m7534a(jsonParser);
                Object userReviewsModel = new UserReviewsModel();
                ((BaseModel) userReviewsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (userReviewsModel instanceof Postprocessable) {
                    return ((Postprocessable) userReviewsModel).a();
                }
                return userReviewsModel;
            }
        }

        /* compiled from: setInitialStickerData */
        public class Serializer extends JsonSerializer<UserReviewsModel> {
            public final void m7502a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UserReviewsModel userReviewsModel = (UserReviewsModel) obj;
                if (userReviewsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(userReviewsModel.m7504a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    userReviewsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = userReviewsModel.w_();
                int u_ = userReviewsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("authored_reviews");
                    AuthoredReviewsParser.m7532a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UserReviewsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AuthoredReviewsModel m7506a() {
            return m7503j();
        }

        public UserReviewsModel() {
            super(1);
        }

        public final void m7507a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7508a(String str, Object obj, boolean z) {
        }

        @Nullable
        private AuthoredReviewsModel m7503j() {
            this.f4750d = (AuthoredReviewsModel) super.a(this.f4750d, 0, AuthoredReviewsModel.class);
            return this.f4750d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m7505a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7503j() != null) {
                AuthoredReviewsModel authoredReviewsModel = (AuthoredReviewsModel) graphQLModelMutatingVisitor.b(m7503j());
                if (m7503j() != authoredReviewsModel) {
                    graphQLVisitableModel = (UserReviewsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4750d = authoredReviewsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7504a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7503j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
