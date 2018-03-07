package com.facebook.localcontent.protocol.graphql;

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
import com.facebook.localcontent.protocol.graphql.PopularProductFragmentsModels.PageProductModel;
import com.facebook.localcontent.protocol.graphql.PopularProductFragmentsParsers.PageProductParser;
import com.facebook.localcontent.protocol.graphql.PopularProductMutationsParsers.PageProductLikeMutationFieldsParser;
import com.facebook.localcontent.protocol.graphql.PopularProductMutationsParsers.PageProductUnlikeMutationFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: keywords_photos(%s) */
public class PopularProductMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1624758536)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: keywords_photos(%s) */
    public final class PageProductLikeMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageProductModel f11811d;

        /* compiled from: keywords_photos(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageProductLikeMutationFieldsModel.class, new Deserializer());
            }

            public Object m18697a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageProductLikeMutationFieldsParser.m18707a(jsonParser);
                Object pageProductLikeMutationFieldsModel = new PageProductLikeMutationFieldsModel();
                ((BaseModel) pageProductLikeMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageProductLikeMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) pageProductLikeMutationFieldsModel).a();
                }
                return pageProductLikeMutationFieldsModel;
            }
        }

        /* compiled from: keywords_photos(%s) */
        public class Serializer extends JsonSerializer<PageProductLikeMutationFieldsModel> {
            public final void m18698a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageProductLikeMutationFieldsModel pageProductLikeMutationFieldsModel = (PageProductLikeMutationFieldsModel) obj;
                if (pageProductLikeMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageProductLikeMutationFieldsModel.m18700a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageProductLikeMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageProductLikeMutationFieldsModel.w_();
                int u_ = pageProductLikeMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page_product");
                    PageProductParser.m18694a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageProductLikeMutationFieldsModel.class, new Serializer());
            }
        }

        public PageProductLikeMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private PageProductModel m18699a() {
            this.f11811d = (PageProductModel) super.a(this.f11811d, 0, PageProductModel.class);
            return this.f11811d;
        }

        public final int jK_() {
            return 2086229526;
        }

        public final GraphQLVisitableModel m18701a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18699a() != null) {
                PageProductModel pageProductModel = (PageProductModel) graphQLModelMutatingVisitor.b(m18699a());
                if (m18699a() != pageProductModel) {
                    graphQLVisitableModel = (PageProductLikeMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11811d = pageProductModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18700a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18699a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1624758536)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: keywords_photos(%s) */
    public final class PageProductUnlikeMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageProductModel f11812d;

        /* compiled from: keywords_photos(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageProductUnlikeMutationFieldsModel.class, new Deserializer());
            }

            public Object m18702a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageProductUnlikeMutationFieldsParser.m18708a(jsonParser);
                Object pageProductUnlikeMutationFieldsModel = new PageProductUnlikeMutationFieldsModel();
                ((BaseModel) pageProductUnlikeMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageProductUnlikeMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) pageProductUnlikeMutationFieldsModel).a();
                }
                return pageProductUnlikeMutationFieldsModel;
            }
        }

        /* compiled from: keywords_photos(%s) */
        public class Serializer extends JsonSerializer<PageProductUnlikeMutationFieldsModel> {
            public final void m18703a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageProductUnlikeMutationFieldsModel pageProductUnlikeMutationFieldsModel = (PageProductUnlikeMutationFieldsModel) obj;
                if (pageProductUnlikeMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageProductUnlikeMutationFieldsModel.m18705a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageProductUnlikeMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageProductUnlikeMutationFieldsModel.w_();
                int u_ = pageProductUnlikeMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page_product");
                    PageProductParser.m18694a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageProductUnlikeMutationFieldsModel.class, new Serializer());
            }
        }

        public PageProductUnlikeMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private PageProductModel m18704a() {
            this.f11812d = (PageProductModel) super.a(this.f11812d, 0, PageProductModel.class);
            return this.f11812d;
        }

        public final int jK_() {
            return -1612906787;
        }

        public final GraphQLVisitableModel m18706a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18704a() != null) {
                PageProductModel pageProductModel = (PageProductModel) graphQLModelMutatingVisitor.b(m18704a());
                if (m18704a() != pageProductModel) {
                    graphQLVisitableModel = (PageProductUnlikeMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11812d = pageProductModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18705a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18704a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
