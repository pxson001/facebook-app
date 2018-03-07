package com.facebook.messaging.business.common.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsParsers.BusinessFAQContentsQueryParser;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsParsers.BusinessFAQContentsQueryParser.CommercePageFaqContentsParser;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsParsers.BusinessFAQContentsQueryParser.CommercePageFaqContentsParser.ContentParser;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsParsers.BusinessGreetingContentsQueryParser;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsParsers.BusinessGreetingContentsQueryParser.PagesGreetingParser;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsParsers.BusinessNuxContentsQueryParser;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsParsers.BusinessNuxContentsQueryParser.CommercePageNuxContentsParser;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsParsers.BusinessNuxContentsQueryParser.CommercePageNuxContentsParser.NuxContentItemsParser;
import com.facebook.messaging.business.common.graphql.BusinessQueryFragmentsParsers.BusinessNuxContentsQueryParser.CommercePageNuxContentsParser.TitleParser;
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

/* compiled from: new AudioTrack Unknown excption */
public class BusinessQueryFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1694603186)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: new AudioTrack Unknown excption */
    public final class BusinessFAQContentsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f8736d;
        @Nullable
        private CommercePageFaqContentsModel f8737e;
        @Nullable
        private String f8738f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 458249868)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: new AudioTrack Unknown excption */
        public final class CommercePageFaqContentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ContentModel> f8735d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: new AudioTrack Unknown excption */
            public final class ContentModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8734d;

                /* compiled from: new AudioTrack Unknown excption */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ContentModel.class, new Deserializer());
                    }

                    public Object m8940a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ContentParser.m9004b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object contentModel = new ContentModel();
                        ((BaseModel) contentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (contentModel instanceof Postprocessable) {
                            return ((Postprocessable) contentModel).a();
                        }
                        return contentModel;
                    }
                }

                /* compiled from: new AudioTrack Unknown excption */
                public class Serializer extends JsonSerializer<ContentModel> {
                    public final void m8941a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ContentModel contentModel = (ContentModel) obj;
                        if (contentModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(contentModel.m8942a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            contentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ContentParser.m9003a(contentModel.w_(), contentModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ContentModel.class, new Serializer());
                    }
                }

                public ContentModel() {
                    super(1);
                }

                @Nullable
                public final String m8944a() {
                    this.f8734d = super.a(this.f8734d, 0);
                    return this.f8734d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m8943a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8942a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8944a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: new AudioTrack Unknown excption */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommercePageFaqContentsModel.class, new Deserializer());
                }

                public Object m8945a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommercePageFaqContentsParser.m9005a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object commercePageFaqContentsModel = new CommercePageFaqContentsModel();
                    ((BaseModel) commercePageFaqContentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (commercePageFaqContentsModel instanceof Postprocessable) {
                        return ((Postprocessable) commercePageFaqContentsModel).a();
                    }
                    return commercePageFaqContentsModel;
                }
            }

            /* compiled from: new AudioTrack Unknown excption */
            public class Serializer extends JsonSerializer<CommercePageFaqContentsModel> {
                public final void m8946a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommercePageFaqContentsModel commercePageFaqContentsModel = (CommercePageFaqContentsModel) obj;
                    if (commercePageFaqContentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commercePageFaqContentsModel.m8947a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commercePageFaqContentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommercePageFaqContentsParser.m9006a(commercePageFaqContentsModel.w_(), commercePageFaqContentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CommercePageFaqContentsModel.class, new Serializer());
                }
            }

            public CommercePageFaqContentsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ContentModel> m8949a() {
                this.f8735d = super.a(this.f8735d, 0, ContentModel.class);
                return (ImmutableList) this.f8735d;
            }

            public final int jK_() {
                return -792654666;
            }

            public final GraphQLVisitableModel m8948a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8949a() != null) {
                    Builder a = ModelHelper.a(m8949a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CommercePageFaqContentsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8735d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8947a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8949a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: new AudioTrack Unknown excption */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessFAQContentsQueryModel.class, new Deserializer());
            }

            public Object m8950a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BusinessFAQContentsQueryParser.m9007a(jsonParser);
                Object businessFAQContentsQueryModel = new BusinessFAQContentsQueryModel();
                ((BaseModel) businessFAQContentsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (businessFAQContentsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) businessFAQContentsQueryModel).a();
                }
                return businessFAQContentsQueryModel;
            }
        }

        /* compiled from: new AudioTrack Unknown excption */
        public class Serializer extends JsonSerializer<BusinessFAQContentsQueryModel> {
            public final void m8951a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BusinessFAQContentsQueryModel businessFAQContentsQueryModel = (BusinessFAQContentsQueryModel) obj;
                if (businessFAQContentsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessFAQContentsQueryModel.m8954a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessFAQContentsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = businessFAQContentsQueryModel.w_();
                int u_ = businessFAQContentsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("commerce_page_faq_contents");
                    CommercePageFaqContentsParser.m9006a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BusinessFAQContentsQueryModel.class, new Serializer());
            }
        }

        public BusinessFAQContentsQueryModel() {
            super(3);
        }

        public final void m8957a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m8958a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m8952k() {
            if (this.b != null && this.f8736d == null) {
                this.f8736d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8736d;
        }

        @Nullable
        public final CommercePageFaqContentsModel m8959j() {
            this.f8737e = (CommercePageFaqContentsModel) super.a(this.f8737e, 1, CommercePageFaqContentsModel.class);
            return this.f8737e;
        }

        @Nullable
        private String m8953l() {
            this.f8738f = super.a(this.f8738f, 2);
            return this.f8738f;
        }

        @Nullable
        public final String m8956a() {
            return m8953l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m8955a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8959j() != null) {
                CommercePageFaqContentsModel commercePageFaqContentsModel = (CommercePageFaqContentsModel) graphQLModelMutatingVisitor.b(m8959j());
                if (m8959j() != commercePageFaqContentsModel) {
                    graphQLVisitableModel = (BusinessFAQContentsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8737e = commercePageFaqContentsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8954a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8952k());
            int a2 = ModelHelper.a(flatBufferBuilder, m8959j());
            int b = flatBufferBuilder.b(m8953l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1659350432)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: new AudioTrack Unknown excption */
    public final class BusinessGreetingContentsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f8742d;
        @Nullable
        private String f8743e;
        @Nullable
        private PagesGreetingModel f8744f;

        /* compiled from: new AudioTrack Unknown excption */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessGreetingContentsQueryModel.class, new Deserializer());
            }

            public Object m8960a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BusinessGreetingContentsQueryParser.m9010a(jsonParser);
                Object businessGreetingContentsQueryModel = new BusinessGreetingContentsQueryModel();
                ((BaseModel) businessGreetingContentsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (businessGreetingContentsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) businessGreetingContentsQueryModel).a();
                }
                return businessGreetingContentsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -312075030)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: new AudioTrack Unknown excption */
        public final class PagesGreetingModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f8739d;
            private boolean f8740e;
            @Nullable
            private String f8741f;

            /* compiled from: new AudioTrack Unknown excption */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PagesGreetingModel.class, new Deserializer());
                }

                public Object m8961a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PagesGreetingParser.m9008a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pagesGreetingModel = new PagesGreetingModel();
                    ((BaseModel) pagesGreetingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pagesGreetingModel instanceof Postprocessable) {
                        return ((Postprocessable) pagesGreetingModel).a();
                    }
                    return pagesGreetingModel;
                }
            }

            /* compiled from: new AudioTrack Unknown excption */
            public class Serializer extends JsonSerializer<PagesGreetingModel> {
                public final void m8962a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PagesGreetingModel pagesGreetingModel = (PagesGreetingModel) obj;
                    if (pagesGreetingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pagesGreetingModel.m8963a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pagesGreetingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PagesGreetingParser.m9009a(pagesGreetingModel.w_(), pagesGreetingModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PagesGreetingModel.class, new Serializer());
                }
            }

            public PagesGreetingModel() {
                super(3);
            }

            public final boolean m8966a() {
                a(0, 0);
                return this.f8739d;
            }

            @Nullable
            public final String m8967j() {
                this.f8741f = super.a(this.f8741f, 2);
                return this.f8741f;
            }

            public final int jK_() {
                return 1072137245;
            }

            public final GraphQLVisitableModel m8964a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m8963a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8967j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f8739d);
                flatBufferBuilder.a(1, this.f8740e);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m8965a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8739d = mutableFlatBuffer.a(i, 0);
                this.f8740e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: new AudioTrack Unknown excption */
        public class Serializer extends JsonSerializer<BusinessGreetingContentsQueryModel> {
            public final void m8968a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BusinessGreetingContentsQueryModel businessGreetingContentsQueryModel = (BusinessGreetingContentsQueryModel) obj;
                if (businessGreetingContentsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessGreetingContentsQueryModel.m8971a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessGreetingContentsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = businessGreetingContentsQueryModel.w_();
                int u_ = businessGreetingContentsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("pages_greeting");
                    PagesGreetingParser.m9009a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BusinessGreetingContentsQueryModel.class, new Serializer());
            }
        }

        public BusinessGreetingContentsQueryModel() {
            super(3);
        }

        public final void m8974a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m8975a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m8969k() {
            if (this.b != null && this.f8742d == null) {
                this.f8742d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8742d;
        }

        @Nullable
        private String m8970l() {
            this.f8743e = super.a(this.f8743e, 1);
            return this.f8743e;
        }

        @Nullable
        public final PagesGreetingModel m8976j() {
            this.f8744f = (PagesGreetingModel) super.a(this.f8744f, 2, PagesGreetingModel.class);
            return this.f8744f;
        }

        @Nullable
        public final String m8973a() {
            return m8970l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m8972a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8976j() != null) {
                PagesGreetingModel pagesGreetingModel = (PagesGreetingModel) graphQLModelMutatingVisitor.b(m8976j());
                if (m8976j() != pagesGreetingModel) {
                    graphQLVisitableModel = (BusinessGreetingContentsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8744f = pagesGreetingModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8971a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8969k());
            int b = flatBufferBuilder.b(m8970l());
            int a2 = ModelHelper.a(flatBufferBuilder, m8976j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2656545)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: new AudioTrack Unknown excption */
    public final class BusinessNuxContentsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f8749d;
        @Nullable
        private CommercePageNuxContentsModel f8750e;
        @Nullable
        private String f8751f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1054280655)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: new AudioTrack Unknown excption */
        public final class CommercePageNuxContentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NuxContentItemsModel> f8747d;
            @Nullable
            private TitleModel f8748e;

            /* compiled from: new AudioTrack Unknown excption */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommercePageNuxContentsModel.class, new Deserializer());
                }

                public Object m8977a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommercePageNuxContentsParser.m9015a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object commercePageNuxContentsModel = new CommercePageNuxContentsModel();
                    ((BaseModel) commercePageNuxContentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (commercePageNuxContentsModel instanceof Postprocessable) {
                        return ((Postprocessable) commercePageNuxContentsModel).a();
                    }
                    return commercePageNuxContentsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: new AudioTrack Unknown excption */
            public final class NuxContentItemsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8745d;

                /* compiled from: new AudioTrack Unknown excption */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NuxContentItemsModel.class, new Deserializer());
                    }

                    public Object m8978a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NuxContentItemsParser.m9012b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nuxContentItemsModel = new NuxContentItemsModel();
                        ((BaseModel) nuxContentItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nuxContentItemsModel instanceof Postprocessable) {
                            return ((Postprocessable) nuxContentItemsModel).a();
                        }
                        return nuxContentItemsModel;
                    }
                }

                /* compiled from: new AudioTrack Unknown excption */
                public class Serializer extends JsonSerializer<NuxContentItemsModel> {
                    public final void m8979a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NuxContentItemsModel nuxContentItemsModel = (NuxContentItemsModel) obj;
                        if (nuxContentItemsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nuxContentItemsModel.m8980a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nuxContentItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NuxContentItemsParser.m9011a(nuxContentItemsModel.w_(), nuxContentItemsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NuxContentItemsModel.class, new Serializer());
                    }
                }

                public NuxContentItemsModel() {
                    super(1);
                }

                @Nullable
                public final String m8982a() {
                    this.f8745d = super.a(this.f8745d, 0);
                    return this.f8745d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m8981a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8980a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8982a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: new AudioTrack Unknown excption */
            public class Serializer extends JsonSerializer<CommercePageNuxContentsModel> {
                public final void m8983a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommercePageNuxContentsModel commercePageNuxContentsModel = (CommercePageNuxContentsModel) obj;
                    if (commercePageNuxContentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commercePageNuxContentsModel.m8989a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commercePageNuxContentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommercePageNuxContentsParser.m9016a(commercePageNuxContentsModel.w_(), commercePageNuxContentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CommercePageNuxContentsModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: new AudioTrack Unknown excption */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8746d;

                /* compiled from: new AudioTrack Unknown excption */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m8984a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TitleParser.m9013a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object titleModel = new TitleModel();
                        ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (titleModel instanceof Postprocessable) {
                            return ((Postprocessable) titleModel).a();
                        }
                        return titleModel;
                    }
                }

                /* compiled from: new AudioTrack Unknown excption */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m8985a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m8986a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TitleParser.m9014a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                public final String m8988a() {
                    this.f8746d = super.a(this.f8746d, 0);
                    return this.f8746d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m8987a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8986a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8988a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public CommercePageNuxContentsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<NuxContentItemsModel> m8991a() {
                this.f8747d = super.a(this.f8747d, 0, NuxContentItemsModel.class);
                return (ImmutableList) this.f8747d;
            }

            @Nullable
            public final TitleModel m8992j() {
                this.f8748e = (TitleModel) super.a(this.f8748e, 1, TitleModel.class);
                return this.f8748e;
            }

            public final int jK_() {
                return 1681979355;
            }

            public final GraphQLVisitableModel m8990a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                TitleModel titleModel;
                h();
                if (m8991a() != null) {
                    Builder a = ModelHelper.a(m8991a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        CommercePageNuxContentsModel commercePageNuxContentsModel = (CommercePageNuxContentsModel) ModelHelper.a(null, this);
                        commercePageNuxContentsModel.f8747d = a.b();
                        graphQLVisitableModel = commercePageNuxContentsModel;
                        if (m8992j() != null) {
                            titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m8992j());
                            if (m8992j() != titleModel) {
                                graphQLVisitableModel = (CommercePageNuxContentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f8748e = titleModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m8992j() != null) {
                    titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m8992j());
                    if (m8992j() != titleModel) {
                        graphQLVisitableModel = (CommercePageNuxContentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8748e = titleModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m8989a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8991a());
                int a2 = ModelHelper.a(flatBufferBuilder, m8992j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: new AudioTrack Unknown excption */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessNuxContentsQueryModel.class, new Deserializer());
            }

            public Object m8993a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BusinessNuxContentsQueryParser.m9017a(jsonParser);
                Object businessNuxContentsQueryModel = new BusinessNuxContentsQueryModel();
                ((BaseModel) businessNuxContentsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (businessNuxContentsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) businessNuxContentsQueryModel).a();
                }
                return businessNuxContentsQueryModel;
            }
        }

        /* compiled from: new AudioTrack Unknown excption */
        public class Serializer extends JsonSerializer<BusinessNuxContentsQueryModel> {
            public final void m8994a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BusinessNuxContentsQueryModel businessNuxContentsQueryModel = (BusinessNuxContentsQueryModel) obj;
                if (businessNuxContentsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessNuxContentsQueryModel.m8997a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessNuxContentsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = businessNuxContentsQueryModel.w_();
                int u_ = businessNuxContentsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("commerce_page_nux_contents");
                    CommercePageNuxContentsParser.m9016a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BusinessNuxContentsQueryModel.class, new Serializer());
            }
        }

        public BusinessNuxContentsQueryModel() {
            super(3);
        }

        public final void m9000a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m9001a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m8995k() {
            if (this.b != null && this.f8749d == null) {
                this.f8749d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8749d;
        }

        @Nullable
        public final CommercePageNuxContentsModel m9002j() {
            this.f8750e = (CommercePageNuxContentsModel) super.a(this.f8750e, 1, CommercePageNuxContentsModel.class);
            return this.f8750e;
        }

        @Nullable
        private String m8996l() {
            this.f8751f = super.a(this.f8751f, 2);
            return this.f8751f;
        }

        @Nullable
        public final String m8999a() {
            return m8996l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m8998a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9002j() != null) {
                CommercePageNuxContentsModel commercePageNuxContentsModel = (CommercePageNuxContentsModel) graphQLModelMutatingVisitor.b(m9002j());
                if (m9002j() != commercePageNuxContentsModel) {
                    graphQLVisitableModel = (BusinessNuxContentsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8750e = commercePageNuxContentsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8997a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8995k());
            int a2 = ModelHelper.a(flatBufferBuilder, m9002j());
            int b = flatBufferBuilder.b(m8996l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
