package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BudgetRecommendationsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BudgetRecommendationsParser;
import com.facebook.adinterfaces.protocol.FetchBudgetRecommendationsQueryParsers.FetchBudgetRecommendationsQueryParser;
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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: WEAK_VIDEO_CONNECTION */
public class FetchBudgetRecommendationsQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 332533845)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: WEAK_VIDEO_CONNECTION */
    public final class FetchBudgetRecommendationsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private BudgetRecommendationsModel f22363d;

        /* compiled from: WEAK_VIDEO_CONNECTION */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchBudgetRecommendationsQueryModel.class, new Deserializer());
            }

            public Object m24152a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchBudgetRecommendationsQueryParser.m24159a(jsonParser);
                Object fetchBudgetRecommendationsQueryModel = new FetchBudgetRecommendationsQueryModel();
                ((BaseModel) fetchBudgetRecommendationsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchBudgetRecommendationsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchBudgetRecommendationsQueryModel).a();
                }
                return fetchBudgetRecommendationsQueryModel;
            }
        }

        /* compiled from: WEAK_VIDEO_CONNECTION */
        public class Serializer extends JsonSerializer<FetchBudgetRecommendationsQueryModel> {
            public final void m24153a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchBudgetRecommendationsQueryModel fetchBudgetRecommendationsQueryModel = (FetchBudgetRecommendationsQueryModel) obj;
                if (fetchBudgetRecommendationsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchBudgetRecommendationsQueryModel.m24154a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchBudgetRecommendationsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchBudgetRecommendationsQueryModel.w_();
                int u_ = fetchBudgetRecommendationsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("admin_info");
                    BudgetRecommendationsParser.m23839a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchBudgetRecommendationsQueryModel.class, new Serializer());
            }
        }

        public FetchBudgetRecommendationsQueryModel() {
            super(1);
        }

        public final void m24157a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m24158a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final BudgetRecommendationsModel m24155a() {
            this.f22363d = (BudgetRecommendationsModel) super.a(this.f22363d, 0, BudgetRecommendationsModel.class);
            return this.f22363d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m24156a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24155a() != null) {
                BudgetRecommendationsModel budgetRecommendationsModel = (BudgetRecommendationsModel) graphQLModelMutatingVisitor.b(m24155a());
                if (m24155a() != budgetRecommendationsModel) {
                    graphQLVisitableModel = (FetchBudgetRecommendationsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22363d = budgetRecommendationsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24154a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24155a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
