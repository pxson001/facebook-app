package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommerceProductCreateMutationParsers.CommerceProductCreateMutationFieldsParser;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsParsers.AdminCommerceProductItemParser;
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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: post_search_enabled_override */
public class CommerceProductCreateMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2045007606)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: post_search_enabled_override */
    public final class CommerceProductCreateMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AdminCommerceProductItemModel f7569d;

        /* compiled from: post_search_enabled_override */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceProductCreateMutationFieldsModel.class, new Deserializer());
            }

            public Object m10708a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommerceProductCreateMutationFieldsParser.m10713a(jsonParser);
                Object commerceProductCreateMutationFieldsModel = new CommerceProductCreateMutationFieldsModel();
                ((BaseModel) commerceProductCreateMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commerceProductCreateMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceProductCreateMutationFieldsModel).a();
                }
                return commerceProductCreateMutationFieldsModel;
            }
        }

        /* compiled from: post_search_enabled_override */
        public class Serializer extends JsonSerializer<CommerceProductCreateMutationFieldsModel> {
            public final void m10709a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommerceProductCreateMutationFieldsModel commerceProductCreateMutationFieldsModel = (CommerceProductCreateMutationFieldsModel) obj;
                if (commerceProductCreateMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceProductCreateMutationFieldsModel.m10710a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceProductCreateMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commerceProductCreateMutationFieldsModel.w_();
                int u_ = commerceProductCreateMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("product_item");
                    AdminCommerceProductItemParser.m10817a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommerceProductCreateMutationFieldsModel.class, new Serializer());
            }
        }

        public CommerceProductCreateMutationFieldsModel() {
            super(1);
        }

        @Nullable
        public final AdminCommerceProductItemModel m10711a() {
            this.f7569d = (AdminCommerceProductItemModel) super.a(this.f7569d, 0, AdminCommerceProductItemModel.class);
            return this.f7569d;
        }

        public final int jK_() {
            return -670782198;
        }

        public final GraphQLVisitableModel m10712a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10711a() != null) {
                AdminCommerceProductItemModel adminCommerceProductItemModel = (AdminCommerceProductItemModel) graphQLModelMutatingVisitor.b(m10711a());
                if (m10711a() != adminCommerceProductItemModel) {
                    graphQLVisitableModel = (CommerceProductCreateMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7569d = adminCommerceProductItemModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10710a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10711a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
