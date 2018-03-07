package com.facebook.messaging.graphql.threads;

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
import com.facebook.graphql.enums.GraphQLPageProductTransactionOrderStatusEnum;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsInterfaces.InvoicesFragment;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser.PageParser;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser.PlatformContextParser;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser.TransactionPaymentParser;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser.TransactionPaymentParser.CredentialResponseParser;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser.TransactionProductsParser;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser.TransactionProductsParser.EdgesParser;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser.TransactionProductsParser.EdgesParser.NodeParser;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser.TransactionProductsParser.EdgesParser.ProductImageParser;
import com.facebook.messaging.graphql.threads.InvoicesFragmentsParsers.InvoicesFragmentParser.TransactionProductsParser.EdgesParser.ProductImageParser.ImageParser;
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

/* compiled from: video_channel_follow */
public class InvoicesFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1739428557)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_channel_follow */
    public final class InvoicesFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, InvoicesFragment {
        @Nullable
        private String f1044d;
        @Nullable
        private String f1045e;
        @Nullable
        private PageModel f1046f;
        @Nullable
        private PlatformContextModel f1047g;
        private int f1048h;
        @Nullable
        private TransactionPaymentModel f1049i;
        @Nullable
        private TransactionProductsModel f1050j;
        @Nullable
        private GraphQLPageProductTransactionOrderStatusEnum f1051k;
        @Nullable
        private String f1052l;
        private int f1053m;
        private int f1054n;

        /* compiled from: video_channel_follow */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InvoicesFragmentModel.class, new Deserializer());
            }

            public Object m1318a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InvoicesFragmentParser.m1418a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object invoicesFragmentModel = new InvoicesFragmentModel();
                ((BaseModel) invoicesFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (invoicesFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) invoicesFragmentModel).a();
                }
                return invoicesFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1185712657)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_channel_follow */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f1016d;
            @Nullable
            private String f1017e;

            /* compiled from: video_channel_follow */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m1319a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m1400a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageModel = new PageModel();
                    ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageModel instanceof Postprocessable) {
                        return ((Postprocessable) pageModel).a();
                    }
                    return pageModel;
                }
            }

            /* compiled from: video_channel_follow */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m1320a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m1323a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m1401a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(2);
            }

            public final void m1326a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1327a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m1321j() {
                this.f1016d = super.a(this.f1016d, 0);
                return this.f1016d;
            }

            @Nullable
            private String m1322k() {
                this.f1017e = super.a(this.f1017e, 1);
                return this.f1017e;
            }

            @Nullable
            public final String m1325a() {
                return m1321j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m1324a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1323a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1321j());
                int b2 = flatBufferBuilder.b(m1322k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_channel_follow */
        public final class PlatformContextModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f1019d;

            /* compiled from: video_channel_follow */
            public final class Builder {
                @Nullable
                public String f1018a;
            }

            /* compiled from: video_channel_follow */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlatformContextModel.class, new Deserializer());
                }

                public Object m1328a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlatformContextParser.m1402a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object platformContextModel = new PlatformContextModel();
                    ((BaseModel) platformContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (platformContextModel instanceof Postprocessable) {
                        return ((Postprocessable) platformContextModel).a();
                    }
                    return platformContextModel;
                }
            }

            /* compiled from: video_channel_follow */
            public class Serializer extends JsonSerializer<PlatformContextModel> {
                public final void m1329a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlatformContextModel platformContextModel = (PlatformContextModel) obj;
                    if (platformContextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(platformContextModel.m1331a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        platformContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlatformContextParser.m1403a(platformContextModel.w_(), platformContextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlatformContextModel.class, new Serializer());
                }
            }

            public PlatformContextModel() {
                super(1);
            }

            public PlatformContextModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m1334b() {
                this.f1019d = super.a(this.f1019d, 0);
                return this.f1019d;
            }

            public static PlatformContextModel m1330a(PlatformContextModel platformContextModel) {
                if (platformContextModel == null) {
                    return null;
                }
                if (platformContextModel instanceof PlatformContextModel) {
                    return platformContextModel;
                }
                Builder builder = new Builder();
                builder.f1018a = platformContextModel.m1334b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f1018a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PlatformContextModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m1333a() {
                return m1334b();
            }

            public final int jK_() {
                return -377623267;
            }

            public final GraphQLVisitableModel m1332a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1331a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1334b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_channel_follow */
        public class Serializer extends JsonSerializer<InvoicesFragmentModel> {
            public final void m1335a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                InvoicesFragmentModel invoicesFragmentModel = (InvoicesFragmentModel) obj;
                if (invoicesFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(invoicesFragmentModel.m1396a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    invoicesFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = invoicesFragmentModel.w_();
                int u_ = invoicesFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("currency");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("page");
                    PageParser.m1401a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("platform_context");
                    PlatformContextParser.m1403a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(u_, 4, 0);
                if (g != 0) {
                    jsonGenerator.a("transaction_discount");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("transaction_payment");
                    TransactionPaymentParser.m1407a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("transaction_products");
                    TransactionProductsParser.m1417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 7) != 0) {
                    jsonGenerator.a("transaction_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 7));
                }
                if (mutableFlatBuffer.g(u_, 8) != 0) {
                    jsonGenerator.a("transaction_status_display");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 8));
                }
                g = mutableFlatBuffer.a(u_, 9, 0);
                if (g != 0) {
                    jsonGenerator.a("transaction_subtotal_cost");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(u_, 10, 0);
                if (g != 0) {
                    jsonGenerator.a("transaction_total_cost");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(InvoicesFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -816589207)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_channel_follow */
        public final class TransactionPaymentModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CredentialResponseModel f1025d;

            /* compiled from: video_channel_follow */
            public final class Builder {
                @Nullable
                public CredentialResponseModel f1020a;
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1122921405)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: video_channel_follow */
            public final class CredentialResponseModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f1023d;
                @Nullable
                private String f1024e;

                /* compiled from: video_channel_follow */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f1021a;
                    @Nullable
                    public String f1022b;
                }

                /* compiled from: video_channel_follow */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CredentialResponseModel.class, new Deserializer());
                    }

                    public Object m1336a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CredentialResponseParser.m1404a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object credentialResponseModel = new CredentialResponseModel();
                        ((BaseModel) credentialResponseModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (credentialResponseModel instanceof Postprocessable) {
                            return ((Postprocessable) credentialResponseModel).a();
                        }
                        return credentialResponseModel;
                    }
                }

                /* compiled from: video_channel_follow */
                public class Serializer extends JsonSerializer<CredentialResponseModel> {
                    public final void m1337a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CredentialResponseModel credentialResponseModel = (CredentialResponseModel) obj;
                        if (credentialResponseModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(credentialResponseModel.m1339a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            credentialResponseModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CredentialResponseParser.m1405a(credentialResponseModel.w_(), credentialResponseModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CredentialResponseModel.class, new Serializer());
                    }
                }

                public CredentialResponseModel() {
                    super(2);
                }

                public CredentialResponseModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final GraphQLObjectType m1340a() {
                    if (this.b != null && this.f1023d == null) {
                        this.f1023d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f1023d;
                }

                @Nullable
                public final String m1342b() {
                    this.f1024e = super.a(this.f1024e, 1);
                    return this.f1024e;
                }

                public static CredentialResponseModel m1338a(CredentialResponseModel credentialResponseModel) {
                    if (credentialResponseModel == null) {
                        return null;
                    }
                    if (credentialResponseModel instanceof CredentialResponseModel) {
                        return credentialResponseModel;
                    }
                    Builder builder = new Builder();
                    builder.f1021a = credentialResponseModel.m1340a();
                    builder.f1022b = credentialResponseModel.m1342b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f1021a);
                    int b = flatBufferBuilder.b(builder.f1022b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new CredentialResponseModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 140359002;
                }

                public final GraphQLVisitableModel m1341a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m1339a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m1340a());
                    int b = flatBufferBuilder.b(m1342b());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: video_channel_follow */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TransactionPaymentModel.class, new Deserializer());
                }

                public Object m1343a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TransactionPaymentParser.m1406a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object transactionPaymentModel = new TransactionPaymentModel();
                    ((BaseModel) transactionPaymentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (transactionPaymentModel instanceof Postprocessable) {
                        return ((Postprocessable) transactionPaymentModel).a();
                    }
                    return transactionPaymentModel;
                }
            }

            /* compiled from: video_channel_follow */
            public class Serializer extends JsonSerializer<TransactionPaymentModel> {
                public final void m1344a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TransactionPaymentModel transactionPaymentModel = (TransactionPaymentModel) obj;
                    if (transactionPaymentModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(transactionPaymentModel.m1347a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        transactionPaymentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TransactionPaymentParser.m1407a(transactionPaymentModel.w_(), transactionPaymentModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TransactionPaymentModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ CredentialResponseModel m1349a() {
                return m1346j();
            }

            public TransactionPaymentModel() {
                super(1);
            }

            public TransactionPaymentModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private CredentialResponseModel m1346j() {
                this.f1025d = (CredentialResponseModel) super.a(this.f1025d, 0, CredentialResponseModel.class);
                return this.f1025d;
            }

            public static TransactionPaymentModel m1345a(TransactionPaymentModel transactionPaymentModel) {
                if (transactionPaymentModel == null) {
                    return null;
                }
                if (transactionPaymentModel instanceof TransactionPaymentModel) {
                    return transactionPaymentModel;
                }
                Builder builder = new Builder();
                builder.f1020a = CredentialResponseModel.m1338a(transactionPaymentModel.m1349a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f1020a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TransactionPaymentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 557483940;
            }

            public final GraphQLVisitableModel m1348a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1346j() != null) {
                    CredentialResponseModel credentialResponseModel = (CredentialResponseModel) graphQLModelMutatingVisitor.b(m1346j());
                    if (m1346j() != credentialResponseModel) {
                        graphQLVisitableModel = (TransactionPaymentModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1025d = credentialResponseModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1347a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1346j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1712029381)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_channel_follow */
        public final class TransactionProductsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f1043d;

            /* compiled from: video_channel_follow */
            public final class Builder {
                @Nullable
                public ImmutableList<EdgesModel> f1026a;
            }

            /* compiled from: video_channel_follow */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TransactionProductsModel.class, new Deserializer());
                }

                public Object m1350a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TransactionProductsParser.m1416a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object transactionProductsModel = new TransactionProductsModel();
                    ((BaseModel) transactionProductsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (transactionProductsModel instanceof Postprocessable) {
                        return ((Postprocessable) transactionProductsModel).a();
                    }
                    return transactionProductsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 89714644)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: video_channel_follow */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1038d;
                @Nullable
                private NodeModel f1039e;
                private int f1040f;
                @Nullable
                private ProductImageModel f1041g;
                private int f1042h;

                /* compiled from: video_channel_follow */
                public final class Builder {
                    @Nullable
                    public String f1027a;
                    @Nullable
                    public NodeModel f1028b;
                    public int f1029c;
                    @Nullable
                    public ProductImageModel f1030d;
                    public int f1031e;
                }

                /* compiled from: video_channel_follow */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m1351a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m1414b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1801334754)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: video_channel_follow */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private String f1033d;

                    /* compiled from: video_channel_follow */
                    public final class Builder {
                        @Nullable
                        public String f1032a;
                    }

                    /* compiled from: video_channel_follow */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m1352a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m1408a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodeModel = new NodeModel();
                            ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodeModel instanceof Postprocessable) {
                                return ((Postprocessable) nodeModel).a();
                            }
                            return nodeModel;
                        }
                    }

                    /* compiled from: video_channel_follow */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m1353a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m1355a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m1409a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(1);
                    }

                    public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final String m1358b() {
                        this.f1033d = super.a(this.f1033d, 0);
                        return this.f1033d;
                    }

                    public static NodeModel m1354a(NodeModel nodeModel) {
                        if (nodeModel == null) {
                            return null;
                        }
                        if (nodeModel instanceof NodeModel) {
                            return nodeModel;
                        }
                        Builder builder = new Builder();
                        builder.f1032a = nodeModel.m1358b();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f1032a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    @Nullable
                    public final String m1357a() {
                        return m1358b();
                    }

                    public final int jK_() {
                        return 175920258;
                    }

                    public final GraphQLVisitableModel m1356a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m1355a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m1358b());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 424995174)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: video_channel_follow */
                public final class ProductImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private ImageModel f1037d;

                    /* compiled from: video_channel_follow */
                    public final class Builder {
                        @Nullable
                        public ImageModel f1034a;
                    }

                    /* compiled from: video_channel_follow */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProductImageModel.class, new Deserializer());
                        }

                        public Object m1359a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProductImageParser.m1412a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object productImageModel = new ProductImageModel();
                            ((BaseModel) productImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (productImageModel instanceof Postprocessable) {
                                return ((Postprocessable) productImageModel).a();
                            }
                            return productImageModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 842551240)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: video_channel_follow */
                    public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f1036d;

                        /* compiled from: video_channel_follow */
                        public final class Builder {
                            @Nullable
                            public String f1035a;
                        }

                        /* compiled from: video_channel_follow */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                            }

                            public Object m1360a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ImageParser.m1410a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object imageModel = new ImageModel();
                                ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (imageModel instanceof Postprocessable) {
                                    return ((Postprocessable) imageModel).a();
                                }
                                return imageModel;
                            }
                        }

                        /* compiled from: video_channel_follow */
                        public class Serializer extends JsonSerializer<ImageModel> {
                            public final void m1361a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ImageModel imageModel = (ImageModel) obj;
                                if (imageModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(imageModel.m1363a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ImageParser.m1411a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ImageModel.class, new Serializer());
                            }
                        }

                        public ImageModel() {
                            super(1);
                        }

                        public ImageModel(MutableFlatBuffer mutableFlatBuffer) {
                            super(1);
                            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }

                        @Nullable
                        public final String m1365a() {
                            this.f1036d = super.a(this.f1036d, 0);
                            return this.f1036d;
                        }

                        public static ImageModel m1362a(ImageModel imageModel) {
                            if (imageModel == null) {
                                return null;
                            }
                            if (imageModel instanceof ImageModel) {
                                return imageModel;
                            }
                            Builder builder = new Builder();
                            builder.f1035a = imageModel.m1365a();
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int b = flatBufferBuilder.b(builder.f1035a);
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new ImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m1364a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m1363a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m1365a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: video_channel_follow */
                    public class Serializer extends JsonSerializer<ProductImageModel> {
                        public final void m1366a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProductImageModel productImageModel = (ProductImageModel) obj;
                            if (productImageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(productImageModel.m1369a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                productImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ProductImageParser.m1413a(productImageModel.w_(), productImageModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(ProductImageModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ ImageModel m1371a() {
                        return m1368j();
                    }

                    public ProductImageModel() {
                        super(1);
                    }

                    public ProductImageModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    private ImageModel m1368j() {
                        this.f1037d = (ImageModel) super.a(this.f1037d, 0, ImageModel.class);
                        return this.f1037d;
                    }

                    public static ProductImageModel m1367a(ProductImageModel productImageModel) {
                        if (productImageModel == null) {
                            return null;
                        }
                        if (productImageModel instanceof ProductImageModel) {
                            return productImageModel;
                        }
                        Builder builder = new Builder();
                        builder.f1034a = ImageModel.m1362a(productImageModel.m1371a());
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, builder.f1034a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new ProductImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 1158348236;
                    }

                    public final GraphQLVisitableModel m1370a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m1368j() != null) {
                            ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m1368j());
                            if (m1368j() != imageModel) {
                                graphQLVisitableModel = (ProductImageModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1037d = imageModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m1369a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m1368j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: video_channel_follow */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m1372a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m1376a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m1415b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ NodeModel m1380b() {
                    return m1374j();
                }

                @Nullable
                public final /* synthetic */ ProductImageModel m1382d() {
                    return m1375k();
                }

                public EdgesModel() {
                    super(5);
                }

                public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(5);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m1378a() {
                    this.f1038d = super.a(this.f1038d, 0);
                    return this.f1038d;
                }

                @Nullable
                private NodeModel m1374j() {
                    this.f1039e = (NodeModel) super.a(this.f1039e, 1, NodeModel.class);
                    return this.f1039e;
                }

                public final int m1381c() {
                    a(0, 2);
                    return this.f1040f;
                }

                @Nullable
                private ProductImageModel m1375k() {
                    this.f1041g = (ProductImageModel) super.a(this.f1041g, 3, ProductImageModel.class);
                    return this.f1041g;
                }

                public final int aA_() {
                    a(0, 4);
                    return this.f1042h;
                }

                public static EdgesModel m1373a(EdgesModel edgesModel) {
                    if (edgesModel == null) {
                        return null;
                    }
                    if (edgesModel instanceof EdgesModel) {
                        return edgesModel;
                    }
                    Builder builder = new Builder();
                    builder.f1027a = edgesModel.m1378a();
                    builder.f1028b = NodeModel.m1354a(edgesModel.m1380b());
                    builder.f1029c = edgesModel.m1381c();
                    builder.f1030d = ProductImageModel.m1367a(edgesModel.m1382d());
                    builder.f1031e = edgesModel.aA_();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f1027a);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f1028b);
                    int a2 = ModelHelper.a(flatBufferBuilder, builder.f1030d);
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.a(2, builder.f1029c, 0);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.a(4, builder.f1031e, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1814235189;
                }

                public final GraphQLVisitableModel m1377a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m1374j() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m1374j());
                        if (m1374j() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1039e = nodeModel;
                        }
                    }
                    if (m1375k() != null) {
                        ProductImageModel productImageModel = (ProductImageModel) graphQLModelMutatingVisitor.b(m1375k());
                        if (m1375k() != productImageModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1041g = productImageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m1376a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m1378a());
                    int a = ModelHelper.a(flatBufferBuilder, m1374j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m1375k());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.a(2, this.f1040f, 0);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.a(4, this.f1042h, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m1379a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1040f = mutableFlatBuffer.a(i, 2, 0);
                    this.f1042h = mutableFlatBuffer.a(i, 4, 0);
                }
            }

            /* compiled from: video_channel_follow */
            public class Serializer extends JsonSerializer<TransactionProductsModel> {
                public final void m1383a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TransactionProductsModel transactionProductsModel = (TransactionProductsModel) obj;
                    if (transactionProductsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(transactionProductsModel.m1385a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        transactionProductsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TransactionProductsParser.m1417a(transactionProductsModel.w_(), transactionProductsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TransactionProductsModel.class, new Serializer());
                }
            }

            public TransactionProductsModel() {
                super(1);
            }

            public TransactionProductsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m1387a() {
                this.f1043d = super.a(this.f1043d, 0, EdgesModel.class);
                return (ImmutableList) this.f1043d;
            }

            public static TransactionProductsModel m1384a(TransactionProductsModel transactionProductsModel) {
                if (transactionProductsModel == null) {
                    return null;
                }
                if (transactionProductsModel instanceof TransactionProductsModel) {
                    return transactionProductsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < transactionProductsModel.m1387a().size(); i++) {
                    builder2.c(EdgesModel.m1373a((EdgesModel) transactionProductsModel.m1387a().get(i)));
                }
                builder.f1026a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f1026a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TransactionProductsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 809092716;
            }

            public final GraphQLVisitableModel m1386a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1387a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m1387a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TransactionProductsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1043d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1385a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1387a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public InvoicesFragmentModel() {
            super(11);
        }

        @Nullable
        private String m1388j() {
            this.f1044d = super.a(this.f1044d, 0);
            return this.f1044d;
        }

        @Nullable
        private String m1389k() {
            this.f1045e = super.a(this.f1045e, 1);
            return this.f1045e;
        }

        @Nullable
        private PageModel m1390l() {
            this.f1046f = (PageModel) super.a(this.f1046f, 2, PageModel.class);
            return this.f1046f;
        }

        @Nullable
        private PlatformContextModel m1391m() {
            this.f1047g = (PlatformContextModel) super.a(this.f1047g, 3, PlatformContextModel.class);
            return this.f1047g;
        }

        @Nullable
        private TransactionPaymentModel m1392n() {
            this.f1049i = (TransactionPaymentModel) super.a(this.f1049i, 5, TransactionPaymentModel.class);
            return this.f1049i;
        }

        @Nullable
        private TransactionProductsModel m1393o() {
            this.f1050j = (TransactionProductsModel) super.a(this.f1050j, 6, TransactionProductsModel.class);
            return this.f1050j;
        }

        @Nullable
        private GraphQLPageProductTransactionOrderStatusEnum m1394p() {
            this.f1051k = (GraphQLPageProductTransactionOrderStatusEnum) super.b(this.f1051k, 7, GraphQLPageProductTransactionOrderStatusEnum.class, GraphQLPageProductTransactionOrderStatusEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1051k;
        }

        @Nullable
        private String m1395q() {
            this.f1052l = super.a(this.f1052l, 8);
            return this.f1052l;
        }

        @Nullable
        public final String m1398a() {
            return m1389k();
        }

        public final int jK_() {
            return -1102680433;
        }

        public final GraphQLVisitableModel m1397a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1390l() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m1390l());
                if (m1390l() != pageModel) {
                    graphQLVisitableModel = (InvoicesFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1046f = pageModel;
                }
            }
            if (m1391m() != null) {
                PlatformContextModel platformContextModel = (PlatformContextModel) graphQLModelMutatingVisitor.b(m1391m());
                if (m1391m() != platformContextModel) {
                    graphQLVisitableModel = (InvoicesFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1047g = platformContextModel;
                }
            }
            if (m1392n() != null) {
                TransactionPaymentModel transactionPaymentModel = (TransactionPaymentModel) graphQLModelMutatingVisitor.b(m1392n());
                if (m1392n() != transactionPaymentModel) {
                    graphQLVisitableModel = (InvoicesFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1049i = transactionPaymentModel;
                }
            }
            if (m1393o() != null) {
                TransactionProductsModel transactionProductsModel = (TransactionProductsModel) graphQLModelMutatingVisitor.b(m1393o());
                if (m1393o() != transactionProductsModel) {
                    graphQLVisitableModel = (InvoicesFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1050j = transactionProductsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1396a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1388j());
            int b2 = flatBufferBuilder.b(m1389k());
            int a = ModelHelper.a(flatBufferBuilder, m1390l());
            int a2 = ModelHelper.a(flatBufferBuilder, m1391m());
            int a3 = ModelHelper.a(flatBufferBuilder, m1392n());
            int a4 = ModelHelper.a(flatBufferBuilder, m1393o());
            int a5 = flatBufferBuilder.a(m1394p());
            int b3 = flatBufferBuilder.b(m1395q());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.a(4, this.f1048h, 0);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, b3);
            flatBufferBuilder.a(9, this.f1053m, 0);
            flatBufferBuilder.a(10, this.f1054n, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1399a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1048h = mutableFlatBuffer.a(i, 4, 0);
            this.f1053m = mutableFlatBuffer.a(i, 9, 0);
            this.f1054n = mutableFlatBuffer.a(i, 10, 0);
        }
    }
}
