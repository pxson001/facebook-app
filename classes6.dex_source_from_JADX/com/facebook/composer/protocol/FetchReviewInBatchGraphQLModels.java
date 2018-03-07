package com.facebook.composer.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.protocol.FetchReviewInBatchGraphQLParsers.FetchReviewInBatchParser;
import com.facebook.composer.protocol.FetchReviewInBatchGraphQLParsers.FetchReviewInBatchParser.PhotosParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultFeedbackFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewBasicFieldsModel.ValueModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewCreationFieldsModel.CreatorModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewCreationFieldsModel.StoryModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewWithFeedbackModel.ReviewerContextModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.SelectedPrivacyOptionFieldsModel;
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

/* compiled from: placeSuggestionMutationParams */
public class FetchReviewInBatchGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 251669256)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: placeSuggestionMutationParams */
    public final class FetchReviewInBatchModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ReviewWithFeedback {
        @Nullable
        private GraphQLObjectType f7913d;
        private long f7914e;
        @Nullable
        private CreatorModel f7915f;
        @Nullable
        private DefaultFeedbackFieldsModel f7916g;
        @Nullable
        private String f7917h;
        private int f7918i;
        @Nullable
        private List<PhotosModel> f7919j;
        @Nullable
        private SelectedPrivacyOptionFieldsModel f7920k;
        @Nullable
        private ReviewerContextModel f7921l;
        @Nullable
        private StoryModel f7922m;
        @Nullable
        private ValueModel f7923n;

        /* compiled from: placeSuggestionMutationParams */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchReviewInBatchModel.class, new Deserializer());
            }

            public Object m11453a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchReviewInBatchParser.m11485a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchReviewInBatchModel = new FetchReviewInBatchModel();
                ((BaseModel) fetchReviewInBatchModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchReviewInBatchModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchReviewInBatchModel).a();
                }
                return fetchReviewInBatchModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1810715828)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: placeSuggestionMutationParams */
        public final class PhotosModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f7911d;
            @Nullable
            private DefaultImageFieldsModel f7912e;

            /* compiled from: placeSuggestionMutationParams */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotosModel.class, new Deserializer());
                }

                public Object m11454a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotosParser.m11483b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photosModel = new PhotosModel();
                    ((BaseModel) photosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photosModel instanceof Postprocessable) {
                        return ((Postprocessable) photosModel).a();
                    }
                    return photosModel;
                }
            }

            /* compiled from: placeSuggestionMutationParams */
            public class Serializer extends JsonSerializer<PhotosModel> {
                public final void m11455a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotosModel photosModel = (PhotosModel) obj;
                    if (photosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photosModel.m11458a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotosParser.m11484b(photosModel.w_(), photosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotosModel.class, new Serializer());
                }
            }

            public PhotosModel() {
                super(2);
            }

            @Nullable
            private String m11456j() {
                this.f7911d = super.a(this.f7911d, 0);
                return this.f7911d;
            }

            @Nullable
            private DefaultImageFieldsModel m11457k() {
                this.f7912e = (DefaultImageFieldsModel) super.a(this.f7912e, 1, DefaultImageFieldsModel.class);
                return this.f7912e;
            }

            @Nullable
            public final String m11460a() {
                return m11456j();
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m11459a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11457k() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m11457k());
                    if (m11457k() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PhotosModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7912e = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11458a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11456j());
                int a = ModelHelper.a(flatBufferBuilder, m11457k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: placeSuggestionMutationParams */
        public class Serializer extends JsonSerializer<FetchReviewInBatchModel> {
            public final void m11461a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchReviewInBatchModel fetchReviewInBatchModel = (FetchReviewInBatchModel) obj;
                if (fetchReviewInBatchModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchReviewInBatchModel.m11470a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchReviewInBatchModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchReviewInBatchParser.m11486a(fetchReviewInBatchModel.w_(), fetchReviewInBatchModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchReviewInBatchModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultFeedbackFields bO_() {
            return m11464n();
        }

        @Nullable
        public final /* synthetic */ CreatorModel bP_() {
            return m11463m();
        }

        @Nullable
        public final /* synthetic */ SelectedPrivacyOptionFieldsModel mo329c() {
            return m11466p();
        }

        @Nullable
        public final /* synthetic */ ValueModel mo330d() {
            return m11469s();
        }

        @Nullable
        public final /* synthetic */ ReviewerContextModel mo332j() {
            return m11467q();
        }

        @Nullable
        public final /* synthetic */ StoryModel mo333k() {
            return m11468r();
        }

        public FetchReviewInBatchModel() {
            super(11);
        }

        public final void m11474a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11475a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m11462l() {
            if (this.b != null && this.f7913d == null) {
                this.f7913d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f7913d;
        }

        public final long mo331g() {
            a(0, 1);
            return this.f7914e;
        }

        @Nullable
        private CreatorModel m11463m() {
            this.f7915f = (CreatorModel) super.a(this.f7915f, 2, CreatorModel.class);
            return this.f7915f;
        }

        @Nullable
        private DefaultFeedbackFieldsModel m11464n() {
            this.f7916g = (DefaultFeedbackFieldsModel) super.a(this.f7916g, 3, DefaultFeedbackFieldsModel.class);
            return this.f7916g;
        }

        @Nullable
        public final String bN_() {
            this.f7917h = super.a(this.f7917h, 4);
            return this.f7917h;
        }

        public final int mo326b() {
            a(0, 5);
            return this.f7918i;
        }

        @Nonnull
        private ImmutableList<PhotosModel> m11465o() {
            this.f7919j = super.a(this.f7919j, 6, PhotosModel.class);
            return (ImmutableList) this.f7919j;
        }

        @Nullable
        private SelectedPrivacyOptionFieldsModel m11466p() {
            this.f7920k = (SelectedPrivacyOptionFieldsModel) super.a(this.f7920k, 7, SelectedPrivacyOptionFieldsModel.class);
            return this.f7920k;
        }

        @Nullable
        private ReviewerContextModel m11467q() {
            this.f7921l = (ReviewerContextModel) super.a(this.f7921l, 8, ReviewerContextModel.class);
            return this.f7921l;
        }

        @Nullable
        private StoryModel m11468r() {
            this.f7922m = (StoryModel) super.a(this.f7922m, 9, StoryModel.class);
            return this.f7922m;
        }

        @Nullable
        private ValueModel m11469s() {
            this.f7923n = (ValueModel) super.a(this.f7923n, 10, ValueModel.class);
            return this.f7923n;
        }

        @Nullable
        public final String m11472a() {
            return bN_();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m11471a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11463m() != null) {
                CreatorModel creatorModel = (CreatorModel) graphQLModelMutatingVisitor.b(m11463m());
                if (m11463m() != creatorModel) {
                    graphQLVisitableModel = (FetchReviewInBatchModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7915f = creatorModel;
                }
            }
            if (m11464n() != null) {
                DefaultFeedbackFieldsModel defaultFeedbackFieldsModel = (DefaultFeedbackFieldsModel) graphQLModelMutatingVisitor.b(m11464n());
                if (m11464n() != defaultFeedbackFieldsModel) {
                    graphQLVisitableModel = (FetchReviewInBatchModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7916g = defaultFeedbackFieldsModel;
                }
            }
            if (m11465o() != null) {
                Builder a = ModelHelper.a(m11465o(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FetchReviewInBatchModel fetchReviewInBatchModel = (FetchReviewInBatchModel) ModelHelper.a(graphQLVisitableModel, this);
                    fetchReviewInBatchModel.f7919j = a.b();
                    graphQLVisitableModel = fetchReviewInBatchModel;
                }
            }
            if (m11466p() != null) {
                SelectedPrivacyOptionFieldsModel selectedPrivacyOptionFieldsModel = (SelectedPrivacyOptionFieldsModel) graphQLModelMutatingVisitor.b(m11466p());
                if (m11466p() != selectedPrivacyOptionFieldsModel) {
                    graphQLVisitableModel = (FetchReviewInBatchModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7920k = selectedPrivacyOptionFieldsModel;
                }
            }
            if (m11467q() != null) {
                ReviewerContextModel reviewerContextModel = (ReviewerContextModel) graphQLModelMutatingVisitor.b(m11467q());
                if (m11467q() != reviewerContextModel) {
                    graphQLVisitableModel = (FetchReviewInBatchModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7921l = reviewerContextModel;
                }
            }
            if (m11468r() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m11468r());
                if (m11468r() != storyModel) {
                    graphQLVisitableModel = (FetchReviewInBatchModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7922m = storyModel;
                }
            }
            if (m11469s() != null) {
                ValueModel valueModel = (ValueModel) graphQLModelMutatingVisitor.b(m11469s());
                if (m11469s() != valueModel) {
                    graphQLVisitableModel = (FetchReviewInBatchModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f7923n = valueModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11470a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11462l());
            int a2 = ModelHelper.a(flatBufferBuilder, m11463m());
            int a3 = ModelHelper.a(flatBufferBuilder, m11464n());
            int b = flatBufferBuilder.b(bN_());
            int a4 = ModelHelper.a(flatBufferBuilder, m11465o());
            int a5 = ModelHelper.a(flatBufferBuilder, m11466p());
            int a6 = ModelHelper.a(flatBufferBuilder, m11467q());
            int a7 = ModelHelper.a(flatBufferBuilder, m11468r());
            int a8 = ModelHelper.a(flatBufferBuilder, m11469s());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f7914e, 0);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.a(5, this.f7918i, 0);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.b(10, a8);
            i();
            return flatBufferBuilder.d();
        }

        public final void m11473a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f7914e = mutableFlatBuffer.a(i, 1, 0);
            this.f7918i = mutableFlatBuffer.a(i, 5, 0);
        }
    }
}
