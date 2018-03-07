package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommerceStoreUpdateMutationParsers.CommerceStoreUpdateMutationParser;
import com.facebook.commerce.publishing.graphql.FetchCommerceStoreQueryModels.CommerceStoreFieldsModel;
import com.facebook.commerce.publishing.graphql.FetchCommerceStoreQueryParsers.CommerceStoreFieldsParser;
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

/* compiled from: poke */
public class CommerceStoreUpdateMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1316583720)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: poke */
    public final class CommerceStoreUpdateMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CommerceStoreFieldsModel f7634d;

        /* compiled from: poke */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceStoreUpdateMutationModel.class, new Deserializer());
            }

            public Object m10840a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommerceStoreUpdateMutationParser.m10845a(jsonParser);
                Object commerceStoreUpdateMutationModel = new CommerceStoreUpdateMutationModel();
                ((BaseModel) commerceStoreUpdateMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commerceStoreUpdateMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceStoreUpdateMutationModel).a();
                }
                return commerceStoreUpdateMutationModel;
            }
        }

        /* compiled from: poke */
        public class Serializer extends JsonSerializer<CommerceStoreUpdateMutationModel> {
            public final void m10841a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommerceStoreUpdateMutationModel commerceStoreUpdateMutationModel = (CommerceStoreUpdateMutationModel) obj;
                if (commerceStoreUpdateMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceStoreUpdateMutationModel.m10843a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceStoreUpdateMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commerceStoreUpdateMutationModel.w_();
                int u_ = commerceStoreUpdateMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("commerce_store");
                    CommerceStoreFieldsParser.m10957a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommerceStoreUpdateMutationModel.class, new Serializer());
            }
        }

        public CommerceStoreUpdateMutationModel() {
            super(1);
        }

        @Nullable
        private CommerceStoreFieldsModel m10842a() {
            this.f7634d = (CommerceStoreFieldsModel) super.a(this.f7634d, 0, CommerceStoreFieldsModel.class);
            return this.f7634d;
        }

        public final int jK_() {
            return 1473655550;
        }

        public final GraphQLVisitableModel m10844a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10842a() != null) {
                CommerceStoreFieldsModel commerceStoreFieldsModel = (CommerceStoreFieldsModel) graphQLModelMutatingVisitor.b(m10842a());
                if (m10842a() != commerceStoreFieldsModel) {
                    graphQLVisitableModel = (CommerceStoreUpdateMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7634d = commerceStoreFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10843a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10842a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
