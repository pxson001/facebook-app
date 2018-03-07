package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommerceProductEditMutationParsers.CommerceProductEditMutationFieldsParser;
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

/* compiled from: post_life_event_photo */
public class CommerceProductEditMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2045007606)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: post_life_event_photo */
    public final class CommerceProductEditMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AdminCommerceProductItemModel f7571d;

        /* compiled from: post_life_event_photo */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceProductEditMutationFieldsModel.class, new Deserializer());
            }

            public Object m10722a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommerceProductEditMutationFieldsParser.m10727a(jsonParser);
                Object commerceProductEditMutationFieldsModel = new CommerceProductEditMutationFieldsModel();
                ((BaseModel) commerceProductEditMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commerceProductEditMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceProductEditMutationFieldsModel).a();
                }
                return commerceProductEditMutationFieldsModel;
            }
        }

        /* compiled from: post_life_event_photo */
        public class Serializer extends JsonSerializer<CommerceProductEditMutationFieldsModel> {
            public final void m10723a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommerceProductEditMutationFieldsModel commerceProductEditMutationFieldsModel = (CommerceProductEditMutationFieldsModel) obj;
                if (commerceProductEditMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceProductEditMutationFieldsModel.m10724a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceProductEditMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commerceProductEditMutationFieldsModel.w_();
                int u_ = commerceProductEditMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("product_item");
                    AdminCommerceProductItemParser.m10817a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommerceProductEditMutationFieldsModel.class, new Serializer());
            }
        }

        public CommerceProductEditMutationFieldsModel() {
            super(1);
        }

        @Nullable
        public final AdminCommerceProductItemModel m10725a() {
            this.f7571d = (AdminCommerceProductItemModel) super.a(this.f7571d, 0, AdminCommerceProductItemModel.class);
            return this.f7571d;
        }

        public final int jK_() {
            return 500687261;
        }

        public final GraphQLVisitableModel m10726a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10725a() != null) {
                AdminCommerceProductItemModel adminCommerceProductItemModel = (AdminCommerceProductItemModel) graphQLModelMutatingVisitor.b(m10725a());
                if (m10725a() != adminCommerceProductItemModel) {
                    graphQLVisitableModel = (CommerceProductEditMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7571d = adminCommerceProductItemModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10724a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10725a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
