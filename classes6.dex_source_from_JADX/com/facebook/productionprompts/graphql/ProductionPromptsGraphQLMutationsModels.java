package com.facebook.productionprompts.graphql;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.productionprompts.graphql.ProductionPromptsGraphQLMutationsParsers.ProductionPromptCoreMutationFieldsParser;
import com.facebook.productionprompts.graphql.ProductionPromptsGraphQLMutationsParsers.ProductionPromptCoreMutationFieldsParser.ProductionPromptParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: start_times */
public class ProductionPromptsGraphQLMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -711736317)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: start_times */
    public final class ProductionPromptCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProductionPromptModel f4228d;

        /* compiled from: start_times */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProductionPromptCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m6251a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProductionPromptCoreMutationFieldsParser.m6267a(jsonParser);
                Object productionPromptCoreMutationFieldsModel = new ProductionPromptCoreMutationFieldsModel();
                ((BaseModel) productionPromptCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (productionPromptCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) productionPromptCoreMutationFieldsModel).a();
                }
                return productionPromptCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: start_times */
        public final class ProductionPromptModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f4227d;

            /* compiled from: start_times */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProductionPromptModel.class, new Deserializer());
                }

                public Object m6252a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProductionPromptParser.m6265a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object productionPromptModel = new ProductionPromptModel();
                    ((BaseModel) productionPromptModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (productionPromptModel instanceof Postprocessable) {
                        return ((Postprocessable) productionPromptModel).a();
                    }
                    return productionPromptModel;
                }
            }

            /* compiled from: start_times */
            public class Serializer extends JsonSerializer<ProductionPromptModel> {
                public final void m6253a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProductionPromptModel productionPromptModel = (ProductionPromptModel) obj;
                    if (productionPromptModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(productionPromptModel.m6256a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        productionPromptModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProductionPromptParser.m6266a(productionPromptModel.w_(), productionPromptModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProductionPromptModel.class, new Serializer());
                }
            }

            public ProductionPromptModel() {
                super(1);
            }

            public final void m6259a(String str, ConsistencyTuple consistencyTuple) {
                if ("id".equals(str)) {
                    consistencyTuple.a = m6255j();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 0;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m6260a(String str, Object obj, boolean z) {
                if ("id".equals(str)) {
                    m6254a((String) obj);
                }
            }

            @Nullable
            private String m6255j() {
                this.f4227d = super.a(this.f4227d, 0);
                return this.f4227d;
            }

            private void m6254a(@Nullable String str) {
                this.f4227d = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 0, str);
                }
            }

            @Nullable
            public final String m6258a() {
                return m6255j();
            }

            public final int jK_() {
                return -1976808547;
            }

            public final GraphQLVisitableModel m6257a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6256a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6255j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: start_times */
        public class Serializer extends JsonSerializer<ProductionPromptCoreMutationFieldsModel> {
            public final void m6261a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProductionPromptCoreMutationFieldsModel productionPromptCoreMutationFieldsModel = (ProductionPromptCoreMutationFieldsModel) obj;
                if (productionPromptCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(productionPromptCoreMutationFieldsModel.m6263a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    productionPromptCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = productionPromptCoreMutationFieldsModel.w_();
                int u_ = productionPromptCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("production_prompt");
                    ProductionPromptParser.m6266a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProductionPromptCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public ProductionPromptCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private ProductionPromptModel m6262a() {
            this.f4228d = (ProductionPromptModel) super.a(this.f4228d, 0, ProductionPromptModel.class);
            return this.f4228d;
        }

        public final int jK_() {
            return -660120032;
        }

        public final GraphQLVisitableModel m6264a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6262a() != null) {
                ProductionPromptModel productionPromptModel = (ProductionPromptModel) graphQLModelMutatingVisitor.b(m6262a());
                if (m6262a() != productionPromptModel) {
                    graphQLVisitableModel = (ProductionPromptCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4228d = productionPromptModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6263a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6262a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
