package com.facebook.pages.common.surface.tabs.tabbar.graphql;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.common.surface.tabs.tabbar.graphql.PageServicesSectionMutationParsers.PageServicesSectionMutationFragmentParser;
import com.facebook.pages.common.surface.tabs.tabbar.graphql.PageServicesSectionMutationParsers.PageServicesSectionMutationFragmentParser.ServicesCardParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: requested_permissions */
public class PageServicesSectionMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 706417166)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: requested_permissions */
    public final class PageServicesSectionMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ServicesCardModel f2541d;

        /* compiled from: requested_permissions */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageServicesSectionMutationFragmentModel.class, new Deserializer());
            }

            public Object m3473a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageServicesSectionMutationFragmentParser.m3487a(jsonParser);
                Object pageServicesSectionMutationFragmentModel = new PageServicesSectionMutationFragmentModel();
                ((BaseModel) pageServicesSectionMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageServicesSectionMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) pageServicesSectionMutationFragmentModel).a();
                }
                return pageServicesSectionMutationFragmentModel;
            }
        }

        /* compiled from: requested_permissions */
        public class Serializer extends JsonSerializer<PageServicesSectionMutationFragmentModel> {
            public final void m3474a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageServicesSectionMutationFragmentModel pageServicesSectionMutationFragmentModel = (PageServicesSectionMutationFragmentModel) obj;
                if (pageServicesSectionMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageServicesSectionMutationFragmentModel.m3483a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageServicesSectionMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageServicesSectionMutationFragmentModel.w_();
                int u_ = pageServicesSectionMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("services_card");
                    ServicesCardParser.m3486a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageServicesSectionMutationFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -40337895)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: requested_permissions */
        public final class ServicesCardModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f2539d;
            @Nullable
            private String f2540e;

            /* compiled from: requested_permissions */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ServicesCardModel.class, new Deserializer());
                }

                public Object m3475a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ServicesCardParser.m3485a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object servicesCardModel = new ServicesCardModel();
                    ((BaseModel) servicesCardModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (servicesCardModel instanceof Postprocessable) {
                        return ((Postprocessable) servicesCardModel).a();
                    }
                    return servicesCardModel;
                }
            }

            /* compiled from: requested_permissions */
            public class Serializer extends JsonSerializer<ServicesCardModel> {
                public final void m3476a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ServicesCardModel servicesCardModel = (ServicesCardModel) obj;
                    if (servicesCardModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(servicesCardModel.m3479a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        servicesCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ServicesCardParser.m3486a(servicesCardModel.w_(), servicesCardModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ServicesCardModel.class, new Serializer());
                }
            }

            public ServicesCardModel() {
                super(2);
            }

            @Nullable
            private String m3477j() {
                this.f2539d = super.a(this.f2539d, 0);
                return this.f2539d;
            }

            @Nullable
            private String m3478k() {
                this.f2540e = super.a(this.f2540e, 1);
                return this.f2540e;
            }

            @Nullable
            public final String m3481a() {
                return m3478k();
            }

            public final int jK_() {
                return -1544864547;
            }

            public final GraphQLVisitableModel m3480a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3479a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m3477j());
                int b2 = flatBufferBuilder.b(m3478k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public PageServicesSectionMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private ServicesCardModel m3482a() {
            this.f2541d = (ServicesCardModel) super.a(this.f2541d, 0, ServicesCardModel.class);
            return this.f2541d;
        }

        public final int jK_() {
            return 1010631925;
        }

        public final GraphQLVisitableModel m3484a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3482a() != null) {
                ServicesCardModel servicesCardModel = (ServicesCardModel) graphQLModelMutatingVisitor.b(m3482a());
                if (m3482a() != servicesCardModel) {
                    graphQLVisitableModel = (PageServicesSectionMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2541d = servicesCardModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3483a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3482a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
