package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.crowdsourcing.protocol.graphql.FeatherQueriesParsers.FeatherQuestionsQueryParser;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsModels.PlaceQuestionFieldsModel;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsParsers.PlaceQuestionFieldsParser;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: taggable_object_image_scale */
public class FeatherQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -84158499)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: taggable_object_image_scale */
    public final class FeatherQuestionsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private List<PlaceQuestionFieldsModel> f2332d;
        @Nullable
        private String f2333e;

        /* compiled from: taggable_object_image_scale */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeatherQuestionsQueryModel.class, new Deserializer());
            }

            public Object m2377a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeatherQuestionsQueryParser.m2385a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object featherQuestionsQueryModel = new FeatherQuestionsQueryModel();
                ((BaseModel) featherQuestionsQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (featherQuestionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) featherQuestionsQueryModel).a();
                }
                return featherQuestionsQueryModel;
            }
        }

        /* compiled from: taggable_object_image_scale */
        public class Serializer extends JsonSerializer<FeatherQuestionsQueryModel> {
            public final void m2378a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeatherQuestionsQueryModel featherQuestionsQueryModel = (FeatherQuestionsQueryModel) obj;
                if (featherQuestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(featherQuestionsQueryModel.m2379a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    featherQuestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = featherQuestionsQueryModel.w_();
                int u_ = featherQuestionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("crowdsourcing_questions");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        PlaceQuestionFieldsParser.m2484b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("display_name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeatherQuestionsQueryModel.class, new Serializer());
            }
        }

        public FeatherQuestionsQueryModel() {
            super(2);
        }

        public final void m2382a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2383a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<PlaceQuestionFieldsModel> m2381a() {
            this.f2332d = super.a(this.f2332d, 0, PlaceQuestionFieldsModel.class);
            return (ImmutableList) this.f2332d;
        }

        @Nullable
        public final String m2384j() {
            this.f2333e = super.a(this.f2333e, 1);
            return this.f2333e;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m2380a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2381a() != null) {
                Builder a = ModelHelper.a(m2381a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FeatherQuestionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2332d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2379a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2381a());
            int b = flatBufferBuilder.b(m2384j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
