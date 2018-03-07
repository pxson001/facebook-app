package com.facebook.reviews.util.protocol.graphql;

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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultFeedbackFieldsModel;
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
import com.facebook.reviews.util.protocol.graphql.FetchUserReviewsParsers.FetchSingleReviewQueryParser;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviewsParsers.FetchSingleReviewQueryParser.RepresentedProfileParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: profile_picture_scale */
public class FetchUserReviewsModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 732202440)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: profile_picture_scale */
    public final class FetchSingleReviewQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ReviewWithFeedback {
        @Nullable
        private GraphQLObjectType f5024d;
        private long f5025e;
        @Nullable
        private CreatorModel f5026f;
        @Nullable
        private DefaultFeedbackFieldsModel f5027g;
        @Nullable
        private String f5028h;
        private int f5029i;
        @Nullable
        private SelectedPrivacyOptionFieldsModel f5030j;
        @Nullable
        private RepresentedProfileModel f5031k;
        @Nullable
        private ReviewerContextModel f5032l;
        @Nullable
        private StoryModel f5033m;
        @Nullable
        private ValueModel f5034n;

        /* compiled from: profile_picture_scale */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchSingleReviewQueryModel.class, new Deserializer());
            }

            public Object m4982a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchSingleReviewQueryParser.m5017a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchSingleReviewQueryModel = new FetchSingleReviewQueryModel();
                ((BaseModel) fetchSingleReviewQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchSingleReviewQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchSingleReviewQueryModel).a();
                }
                return fetchSingleReviewQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile_picture_scale */
        public final class RepresentedProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f5021d;
            @Nullable
            private String f5022e;
            @Nullable
            private String f5023f;

            /* compiled from: profile_picture_scale */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RepresentedProfileModel.class, new Deserializer());
                }

                public Object m4983a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RepresentedProfileParser.m5015a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object representedProfileModel = new RepresentedProfileModel();
                    ((BaseModel) representedProfileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (representedProfileModel instanceof Postprocessable) {
                        return ((Postprocessable) representedProfileModel).a();
                    }
                    return representedProfileModel;
                }
            }

            /* compiled from: profile_picture_scale */
            public class Serializer extends JsonSerializer<RepresentedProfileModel> {
                public final void m4984a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) obj;
                    if (representedProfileModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(representedProfileModel.m4986a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        representedProfileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RepresentedProfileParser.m5016a(representedProfileModel.w_(), representedProfileModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RepresentedProfileModel.class, new Serializer());
                }
            }

            public RepresentedProfileModel() {
                super(3);
            }

            public final void m4989a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m4990a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m4985j() {
                if (this.b != null && this.f5021d == null) {
                    this.f5021d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f5021d;
            }

            @Nullable
            public final String m4991b() {
                this.f5022e = super.a(this.f5022e, 1);
                return this.f5022e;
            }

            @Nullable
            public final String m4992c() {
                this.f5023f = super.a(this.f5023f, 2);
                return this.f5023f;
            }

            @Nullable
            public final String m4988a() {
                return m4991b();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m4987a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m4986a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m4985j());
                int b = flatBufferBuilder.b(m4991b());
                int b2 = flatBufferBuilder.b(m4992c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: profile_picture_scale */
        public class Serializer extends JsonSerializer<FetchSingleReviewQueryModel> {
            public final void m4993a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchSingleReviewQueryModel fetchSingleReviewQueryModel = (FetchSingleReviewQueryModel) obj;
                if (fetchSingleReviewQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchSingleReviewQueryModel.m5002a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchSingleReviewQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchSingleReviewQueryParser.m5018a(fetchSingleReviewQueryModel.w_(), fetchSingleReviewQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchSingleReviewQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultFeedbackFields bO_() {
            return m4996o();
        }

        @Nullable
        public final /* synthetic */ CreatorModel bP_() {
            return m4995n();
        }

        @Nullable
        public final /* synthetic */ SelectedPrivacyOptionFieldsModel m5009c() {
            return m4997p();
        }

        @Nullable
        public final /* synthetic */ ValueModel m5010d() {
            return m5001t();
        }

        @Nullable
        public final /* synthetic */ ReviewerContextModel m5012j() {
            return m4999r();
        }

        @Nullable
        public final /* synthetic */ StoryModel m5013k() {
            return m5000s();
        }

        @Nullable
        public final /* synthetic */ RepresentedProfileModel m5014l() {
            return m4998q();
        }

        public FetchSingleReviewQueryModel() {
            super(11);
        }

        public final void m5006a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m5007a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m4994m() {
            if (this.b != null && this.f5024d == null) {
                this.f5024d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f5024d;
        }

        public final long m5011g() {
            a(0, 1);
            return this.f5025e;
        }

        @Nullable
        private CreatorModel m4995n() {
            this.f5026f = (CreatorModel) super.a(this.f5026f, 2, CreatorModel.class);
            return this.f5026f;
        }

        @Nullable
        private DefaultFeedbackFieldsModel m4996o() {
            this.f5027g = (DefaultFeedbackFieldsModel) super.a(this.f5027g, 3, DefaultFeedbackFieldsModel.class);
            return this.f5027g;
        }

        @Nullable
        public final String bN_() {
            this.f5028h = super.a(this.f5028h, 4);
            return this.f5028h;
        }

        public final int m5008b() {
            a(0, 5);
            return this.f5029i;
        }

        @Nullable
        private SelectedPrivacyOptionFieldsModel m4997p() {
            this.f5030j = (SelectedPrivacyOptionFieldsModel) super.a(this.f5030j, 6, SelectedPrivacyOptionFieldsModel.class);
            return this.f5030j;
        }

        @Nullable
        private RepresentedProfileModel m4998q() {
            this.f5031k = (RepresentedProfileModel) super.a(this.f5031k, 7, RepresentedProfileModel.class);
            return this.f5031k;
        }

        @Nullable
        private ReviewerContextModel m4999r() {
            this.f5032l = (ReviewerContextModel) super.a(this.f5032l, 8, ReviewerContextModel.class);
            return this.f5032l;
        }

        @Nullable
        private StoryModel m5000s() {
            this.f5033m = (StoryModel) super.a(this.f5033m, 9, StoryModel.class);
            return this.f5033m;
        }

        @Nullable
        private ValueModel m5001t() {
            this.f5034n = (ValueModel) super.a(this.f5034n, 10, ValueModel.class);
            return this.f5034n;
        }

        @Nullable
        public final String m5004a() {
            return bN_();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m5003a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4995n() != null) {
                CreatorModel creatorModel = (CreatorModel) graphQLModelMutatingVisitor.b(m4995n());
                if (m4995n() != creatorModel) {
                    graphQLVisitableModel = (FetchSingleReviewQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5026f = creatorModel;
                }
            }
            if (m4996o() != null) {
                DefaultFeedbackFieldsModel defaultFeedbackFieldsModel = (DefaultFeedbackFieldsModel) graphQLModelMutatingVisitor.b(m4996o());
                if (m4996o() != defaultFeedbackFieldsModel) {
                    graphQLVisitableModel = (FetchSingleReviewQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5027g = defaultFeedbackFieldsModel;
                }
            }
            if (m4997p() != null) {
                SelectedPrivacyOptionFieldsModel selectedPrivacyOptionFieldsModel = (SelectedPrivacyOptionFieldsModel) graphQLModelMutatingVisitor.b(m4997p());
                if (m4997p() != selectedPrivacyOptionFieldsModel) {
                    graphQLVisitableModel = (FetchSingleReviewQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5030j = selectedPrivacyOptionFieldsModel;
                }
            }
            if (m4998q() != null) {
                RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) graphQLModelMutatingVisitor.b(m4998q());
                if (m4998q() != representedProfileModel) {
                    graphQLVisitableModel = (FetchSingleReviewQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5031k = representedProfileModel;
                }
            }
            if (m4999r() != null) {
                ReviewerContextModel reviewerContextModel = (ReviewerContextModel) graphQLModelMutatingVisitor.b(m4999r());
                if (m4999r() != reviewerContextModel) {
                    graphQLVisitableModel = (FetchSingleReviewQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5032l = reviewerContextModel;
                }
            }
            if (m5000s() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m5000s());
                if (m5000s() != storyModel) {
                    graphQLVisitableModel = (FetchSingleReviewQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5033m = storyModel;
                }
            }
            if (m5001t() != null) {
                ValueModel valueModel = (ValueModel) graphQLModelMutatingVisitor.b(m5001t());
                if (m5001t() != valueModel) {
                    graphQLVisitableModel = (FetchSingleReviewQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5034n = valueModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5002a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4994m());
            int a2 = ModelHelper.a(flatBufferBuilder, m4995n());
            int a3 = ModelHelper.a(flatBufferBuilder, m4996o());
            int b = flatBufferBuilder.b(bN_());
            int a4 = ModelHelper.a(flatBufferBuilder, m4997p());
            int a5 = ModelHelper.a(flatBufferBuilder, m4998q());
            int a6 = ModelHelper.a(flatBufferBuilder, m4999r());
            int a7 = ModelHelper.a(flatBufferBuilder, m5000s());
            int a8 = ModelHelper.a(flatBufferBuilder, m5001t());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f5025e, 0);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.a(5, this.f5029i, 0);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.b(10, a8);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5005a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5025e = mutableFlatBuffer.a(i, 1, 0);
            this.f5029i = mutableFlatBuffer.a(i, 5, 0);
        }
    }
}
