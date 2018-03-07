package com.facebook.reviews.util.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewBasicFieldsModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewBasicFieldsParser;
import com.facebook.reviews.util.protocol.graphql.FetchSingleViewerReviewGraphQLParsers.FetchSingleViewerReviewGraphQLParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: profile_video_android_deep_link_flow_canceled */
public class FetchSingleViewerReviewGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -306962731)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: profile_video_android_deep_link_flow_canceled */
    public final class FetchSingleViewerReviewGraphQLModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ReviewBasicFieldsModel f5014d;

        /* compiled from: profile_video_android_deep_link_flow_canceled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchSingleViewerReviewGraphQLModel.class, new Deserializer());
            }

            public Object m4964a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchSingleViewerReviewGraphQLParser.m4971a(jsonParser);
                Object fetchSingleViewerReviewGraphQLModel = new FetchSingleViewerReviewGraphQLModel();
                ((BaseModel) fetchSingleViewerReviewGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchSingleViewerReviewGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchSingleViewerReviewGraphQLModel).a();
                }
                return fetchSingleViewerReviewGraphQLModel;
            }
        }

        /* compiled from: profile_video_android_deep_link_flow_canceled */
        public class Serializer extends JsonSerializer<FetchSingleViewerReviewGraphQLModel> {
            public final void m4965a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchSingleViewerReviewGraphQLModel fetchSingleViewerReviewGraphQLModel = (FetchSingleViewerReviewGraphQLModel) obj;
                if (fetchSingleViewerReviewGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchSingleViewerReviewGraphQLModel.m4966a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchSingleViewerReviewGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchSingleViewerReviewGraphQLModel.w_();
                int u_ = fetchSingleViewerReviewGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer_recommendation");
                    ReviewBasicFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchSingleViewerReviewGraphQLModel.class, new Serializer());
            }
        }

        public FetchSingleViewerReviewGraphQLModel() {
            super(1);
        }

        public final void m4969a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m4970a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final ReviewBasicFieldsModel m4968a() {
            this.f5014d = (ReviewBasicFieldsModel) super.a(this.f5014d, 0, ReviewBasicFieldsModel.class);
            return this.f5014d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m4967a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4968a() != null) {
                ReviewBasicFieldsModel reviewBasicFieldsModel = (ReviewBasicFieldsModel) graphQLModelMutatingVisitor.b(m4968a());
                if (m4968a() != reviewBasicFieldsModel) {
                    graphQLVisitableModel = (FetchSingleViewerReviewGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5014d = reviewBasicFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4966a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4968a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
