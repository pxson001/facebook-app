package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommerceProductDeleteMutationParsers.CommerceProductDeleteMutationParser;
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
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: post_privacy_upsell_dialog_controller */
public class CommerceProductDeleteMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1347248415)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: post_privacy_upsell_dialog_controller */
    public final class CommerceProductDeleteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<String> f7570d;

        /* compiled from: post_privacy_upsell_dialog_controller */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceProductDeleteMutationModel.class, new Deserializer());
            }

            public Object m10715a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommerceProductDeleteMutationParser.m10720a(jsonParser);
                Object commerceProductDeleteMutationModel = new CommerceProductDeleteMutationModel();
                ((BaseModel) commerceProductDeleteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commerceProductDeleteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceProductDeleteMutationModel).a();
                }
                return commerceProductDeleteMutationModel;
            }
        }

        /* compiled from: post_privacy_upsell_dialog_controller */
        public class Serializer extends JsonSerializer<CommerceProductDeleteMutationModel> {
            public final void m10716a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommerceProductDeleteMutationModel commerceProductDeleteMutationModel = (CommerceProductDeleteMutationModel) obj;
                if (commerceProductDeleteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceProductDeleteMutationModel.m10718a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceProductDeleteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commerceProductDeleteMutationModel.w_();
                int u_ = commerceProductDeleteMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("deleted_product_item_ids");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 0), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommerceProductDeleteMutationModel.class, new Serializer());
            }
        }

        public CommerceProductDeleteMutationModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<String> m10717a() {
            this.f7570d = super.a(this.f7570d, 0);
            return (ImmutableList) this.f7570d;
        }

        public final int jK_() {
            return 2020957489;
        }

        public final GraphQLVisitableModel m10719a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10718a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m10717a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, c);
            i();
            return flatBufferBuilder.d();
        }
    }
}
