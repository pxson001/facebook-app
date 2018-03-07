package com.facebook.pages.common.contactinbox.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPageLeadGenInfoState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxLeadUpdateMutationsParsers.PagesContactInboxLeadUpdateStateMutationParser;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxLeadUpdateMutationsParsers.PagesContactInboxLeadUpdateStateMutationParser.PageContactUsLeadParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: startX */
public class PagesContactInboxLeadUpdateMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -240875211)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: startX */
    public final class PagesContactInboxLeadUpdateStateMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageContactUsLeadModel f1448d;

        /* compiled from: startX */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PagesContactInboxLeadUpdateStateMutationModel.class, new Deserializer());
            }

            public Object m2112a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PagesContactInboxLeadUpdateStateMutationParser.m2126a(jsonParser);
                Object pagesContactInboxLeadUpdateStateMutationModel = new PagesContactInboxLeadUpdateStateMutationModel();
                ((BaseModel) pagesContactInboxLeadUpdateStateMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pagesContactInboxLeadUpdateStateMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) pagesContactInboxLeadUpdateStateMutationModel).a();
                }
                return pagesContactInboxLeadUpdateStateMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1059414297)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: startX */
        public final class PageContactUsLeadModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f1446d;
            @Nullable
            private GraphQLPageLeadGenInfoState f1447e;

            /* compiled from: startX */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageContactUsLeadModel.class, new Deserializer());
                }

                public Object m2113a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageContactUsLeadParser.m2124a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageContactUsLeadModel = new PageContactUsLeadModel();
                    ((BaseModel) pageContactUsLeadModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageContactUsLeadModel instanceof Postprocessable) {
                        return ((Postprocessable) pageContactUsLeadModel).a();
                    }
                    return pageContactUsLeadModel;
                }
            }

            /* compiled from: startX */
            public class Serializer extends JsonSerializer<PageContactUsLeadModel> {
                public final void m2114a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageContactUsLeadModel pageContactUsLeadModel = (PageContactUsLeadModel) obj;
                    if (pageContactUsLeadModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageContactUsLeadModel.m2116a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageContactUsLeadModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageContactUsLeadParser.m2125a(pageContactUsLeadModel.w_(), pageContactUsLeadModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageContactUsLeadModel.class, new Serializer());
                }
            }

            public PageContactUsLeadModel() {
                super(2);
            }

            @Nullable
            private String m2115k() {
                this.f1446d = super.a(this.f1446d, 0);
                return this.f1446d;
            }

            @Nullable
            public final GraphQLPageLeadGenInfoState m2119j() {
                this.f1447e = (GraphQLPageLeadGenInfoState) super.b(this.f1447e, 1, GraphQLPageLeadGenInfoState.class, GraphQLPageLeadGenInfoState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1447e;
            }

            @Nullable
            public final String m2118a() {
                return m2115k();
            }

            public final int jK_() {
                return 1222248683;
            }

            public final GraphQLVisitableModel m2117a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2116a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2115k());
                int a = flatBufferBuilder.a(m2119j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: startX */
        public class Serializer extends JsonSerializer<PagesContactInboxLeadUpdateStateMutationModel> {
            public final void m2120a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PagesContactInboxLeadUpdateStateMutationModel pagesContactInboxLeadUpdateStateMutationModel = (PagesContactInboxLeadUpdateStateMutationModel) obj;
                if (pagesContactInboxLeadUpdateStateMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pagesContactInboxLeadUpdateStateMutationModel.m2121a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pagesContactInboxLeadUpdateStateMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pagesContactInboxLeadUpdateStateMutationModel.w_();
                int u_ = pagesContactInboxLeadUpdateStateMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page_contact_us_lead");
                    PageContactUsLeadParser.m2125a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PagesContactInboxLeadUpdateStateMutationModel.class, new Serializer());
            }
        }

        public PagesContactInboxLeadUpdateStateMutationModel() {
            super(1);
        }

        @Nullable
        public final PageContactUsLeadModel m2123a() {
            this.f1448d = (PageContactUsLeadModel) super.a(this.f1448d, 0, PageContactUsLeadModel.class);
            return this.f1448d;
        }

        public final int jK_() {
            return 1663731889;
        }

        public final GraphQLVisitableModel m2122a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2123a() != null) {
                PageContactUsLeadModel pageContactUsLeadModel = (PageContactUsLeadModel) graphQLModelMutatingVisitor.b(m2123a());
                if (m2123a() != pageContactUsLeadModel) {
                    graphQLVisitableModel = (PagesContactInboxLeadUpdateStateMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1448d = pageContactUsLeadModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2121a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2123a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
