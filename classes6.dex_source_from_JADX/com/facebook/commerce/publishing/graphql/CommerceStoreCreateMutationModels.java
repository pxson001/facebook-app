package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommerceStoreCreateMutationParsers.CommerceStoreCreateMutationParser;
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

/* compiled from: post_as_page_viewer_context */
public class CommerceStoreCreateMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1316583720)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: post_as_page_viewer_context */
    public final class CommerceStoreCreateMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CommerceStoreFieldsModel f7632d;

        /* compiled from: post_as_page_viewer_context */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceStoreCreateMutationModel.class, new Deserializer());
            }

            public Object m10826a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommerceStoreCreateMutationParser.m10831a(jsonParser);
                Object commerceStoreCreateMutationModel = new CommerceStoreCreateMutationModel();
                ((BaseModel) commerceStoreCreateMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commerceStoreCreateMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceStoreCreateMutationModel).a();
                }
                return commerceStoreCreateMutationModel;
            }
        }

        /* compiled from: post_as_page_viewer_context */
        public class Serializer extends JsonSerializer<CommerceStoreCreateMutationModel> {
            public final void m10827a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommerceStoreCreateMutationModel commerceStoreCreateMutationModel = (CommerceStoreCreateMutationModel) obj;
                if (commerceStoreCreateMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceStoreCreateMutationModel.m10829a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceStoreCreateMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commerceStoreCreateMutationModel.w_();
                int u_ = commerceStoreCreateMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("commerce_store");
                    CommerceStoreFieldsParser.m10957a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommerceStoreCreateMutationModel.class, new Serializer());
            }
        }

        public CommerceStoreCreateMutationModel() {
            super(1);
        }

        @Nullable
        private CommerceStoreFieldsModel m10828a() {
            this.f7632d = (CommerceStoreFieldsModel) super.a(this.f7632d, 0, CommerceStoreFieldsModel.class);
            return this.f7632d;
        }

        public final int jK_() {
            return -1227283843;
        }

        public final GraphQLVisitableModel m10830a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10828a() != null) {
                CommerceStoreFieldsModel commerceStoreFieldsModel = (CommerceStoreFieldsModel) graphQLModelMutatingVisitor.b(m10828a());
                if (m10828a() != commerceStoreFieldsModel) {
                    graphQLVisitableModel = (CommerceStoreCreateMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7632d = commerceStoreFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10829a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10828a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
