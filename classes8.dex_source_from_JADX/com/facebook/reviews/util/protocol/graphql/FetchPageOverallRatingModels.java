package com.facebook.reviews.util.protocol.graphql;

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
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsModels.PageOverallStarRatingModel;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsParsers.PageOverallStarRatingParser;
import com.facebook.reviews.util.protocol.graphql.FetchPageOverallRatingParsers.FetchPageOverallRatingParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: profile_video_android_preview_closed */
public class FetchPageOverallRatingModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2102284011)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile_video_android_preview_closed */
    public final class FetchPageOverallRatingModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PageOverallStarRatingModel f5010d;

        /* compiled from: profile_video_android_preview_closed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPageOverallRatingModel.class, new Deserializer());
            }

            public Object m4953a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPageOverallRatingParser.m4960a(jsonParser);
                Object fetchPageOverallRatingModel = new FetchPageOverallRatingModel();
                ((BaseModel) fetchPageOverallRatingModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPageOverallRatingModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPageOverallRatingModel).a();
                }
                return fetchPageOverallRatingModel;
            }
        }

        /* compiled from: profile_video_android_preview_closed */
        public class Serializer extends JsonSerializer<FetchPageOverallRatingModel> {
            public final void m4954a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPageOverallRatingModel fetchPageOverallRatingModel = (FetchPageOverallRatingModel) obj;
                if (fetchPageOverallRatingModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPageOverallRatingModel.m4955a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPageOverallRatingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPageOverallRatingModel.w_();
                int u_ = fetchPageOverallRatingModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("overall_star_rating");
                    PageOverallStarRatingParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPageOverallRatingModel.class, new Serializer());
            }
        }

        public FetchPageOverallRatingModel() {
            super(1);
        }

        public final void m4958a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m4959a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final PageOverallStarRatingModel m4957a() {
            this.f5010d = (PageOverallStarRatingModel) super.a(this.f5010d, 0, PageOverallStarRatingModel.class);
            return this.f5010d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m4956a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4957a() != null) {
                PageOverallStarRatingModel pageOverallStarRatingModel = (PageOverallStarRatingModel) graphQLModelMutatingVisitor.b(m4957a());
                if (m4957a() != pageOverallStarRatingModel) {
                    graphQLVisitableModel = (FetchPageOverallRatingModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5010d = pageOverallStarRatingModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4955a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4957a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
