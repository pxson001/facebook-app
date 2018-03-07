package com.facebook.commerce.invoices.graphql;

import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryParsers.TransactionInvoiceQueryParser;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryParsers.TransactionInvoiceQueryParser.PageParser;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryParsers.TransactionInvoiceQueryParser.PlatformContextParser;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryParsers.TransactionInvoiceQueryParser.ReceiptImageParser;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryParsers.TransactionInvoiceQueryParser.ReceiptImageParser.ImageParser;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryParsers.TransactionItemProductFieldsParser;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryParsers.TransactionItemProductFieldsParser.EdgesParser;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryParsers.TransactionItemProductFieldsParser.EdgesParser.NodeParser;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryParsers.TransactionItemProductFieldsParser.EdgesParser.ProductImageParser;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryParsers.TransactionPaymentOptionFieldsParser;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryParsers.TransactionShippingOptionFieldsParser;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceQueryParsers.TransactionShippingOptionFieldsParser.ShippingPriceAndCurrencyParser;
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
import com.facebook.graphql.enums.GraphQLPageProductTransactionPaymentTypeEnum;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: quickcam/ */
public class TransactionInvoiceQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 278843621)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: quickcam/ */
    public final class TransactionInvoiceQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f5900d;
        @Nullable
        private String f5901e;
        @Nullable
        private String f5902f;
        @Nullable
        private String f5903g;
        @Nullable
        private PageModel f5904h;
        @Nullable
        private PlatformContextModel f5905i;
        @Nullable
        private ReceiptImageModel f5906j;
        @Nullable
        private TransactionPaymentOptionFieldsModel f5907k;
        @Nullable
        private TransactionShippingOptionFieldsModel f5908l;
        private int f5909m;
        @Nullable
        private String f5910n;
        @Nullable
        private TransactionItemProductFieldsModel f5911o;
        @Nullable
        private GraphQLPageProductTransactionOrderStatusEnum f5912p;
        @Nullable
        private String f5913q;
        private int f5914r;
        private int f5915s;

        /* compiled from: quickcam/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TransactionInvoiceQueryModel.class, new Deserializer());
            }

            public Object m6149a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TransactionInvoiceQueryParser.m6262a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object transactionInvoiceQueryModel = new TransactionInvoiceQueryModel();
                ((BaseModel) transactionInvoiceQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (transactionInvoiceQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) transactionInvoiceQueryModel).a();
                }
                return transactionInvoiceQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1185712657)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: quickcam/ */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f5895d;
            @Nullable
            private String f5896e;

            /* compiled from: quickcam/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m6150a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m6254a(jsonParser, flatBufferBuilder));
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

            /* compiled from: quickcam/ */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m6151a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m6154a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m6255a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(2);
            }

            public final void m6157a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m6158a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m6152j() {
                this.f5895d = super.a(this.f5895d, 0);
                return this.f5895d;
            }

            @Nullable
            private String m6153k() {
                this.f5896e = super.a(this.f5896e, 1);
                return this.f5896e;
            }

            @Nullable
            public final String m6156a() {
                return m6152j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m6155a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6154a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6152j());
                int b2 = flatBufferBuilder.b(m6153k());
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
        /* compiled from: quickcam/ */
        public final class PlatformContextModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f5897d;

            /* compiled from: quickcam/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlatformContextModel.class, new Deserializer());
                }

                public Object m6159a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlatformContextParser.m6256a(jsonParser, flatBufferBuilder));
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

            /* compiled from: quickcam/ */
            public class Serializer extends JsonSerializer<PlatformContextModel> {
                public final void m6160a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlatformContextModel platformContextModel = (PlatformContextModel) obj;
                    if (platformContextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(platformContextModel.m6162a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        platformContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlatformContextParser.m6257a(platformContextModel.w_(), platformContextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlatformContextModel.class, new Serializer());
                }
            }

            public PlatformContextModel() {
                super(1);
            }

            @Nullable
            private String m6161j() {
                this.f5897d = super.a(this.f5897d, 0);
                return this.f5897d;
            }

            @Nullable
            public final String m6164a() {
                return m6161j();
            }

            public final int jK_() {
                return -377623267;
            }

            public final GraphQLVisitableModel m6163a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6162a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6161j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1186446242)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: quickcam/ */
        public final class ReceiptImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ImageModel f5899d;

            /* compiled from: quickcam/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReceiptImageModel.class, new Deserializer());
                }

                public Object m6165a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReceiptImageParser.m6260a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object receiptImageModel = new ReceiptImageModel();
                    ((BaseModel) receiptImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (receiptImageModel instanceof Postprocessable) {
                        return ((Postprocessable) receiptImageModel).a();
                    }
                    return receiptImageModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: quickcam/ */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f5898d;

                /* compiled from: quickcam/ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                    }

                    public Object m6166a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageParser.m6258a(jsonParser, flatBufferBuilder));
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

                /* compiled from: quickcam/ */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m6167a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageModel imageModel = (ImageModel) obj;
                        if (imageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageModel.m6168a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageParser.m6259a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImageModel.class, new Serializer());
                    }
                }

                public ImageModel() {
                    super(1);
                }

                @Nullable
                public final String m6170a() {
                    this.f5898d = super.a(this.f5898d, 0);
                    return this.f5898d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m6169a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6168a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6170a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: quickcam/ */
            public class Serializer extends JsonSerializer<ReceiptImageModel> {
                public final void m6171a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReceiptImageModel receiptImageModel = (ReceiptImageModel) obj;
                    if (receiptImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(receiptImageModel.m6173a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        receiptImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReceiptImageParser.m6261a(receiptImageModel.w_(), receiptImageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReceiptImageModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ImageModel m6174a() {
                return m6172j();
            }

            public ReceiptImageModel() {
                super(1);
            }

            @Nullable
            private ImageModel m6172j() {
                this.f5899d = (ImageModel) super.a(this.f5899d, 0, ImageModel.class);
                return this.f5899d;
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m6175a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6172j() != null) {
                    ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m6172j());
                    if (m6172j() != imageModel) {
                        graphQLVisitableModel = (ReceiptImageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5899d = imageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6173a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6172j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: quickcam/ */
        public class Serializer extends JsonSerializer<TransactionInvoiceQueryModel> {
            public final void m6176a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TransactionInvoiceQueryModel transactionInvoiceQueryModel = (TransactionInvoiceQueryModel) obj;
                if (transactionInvoiceQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(transactionInvoiceQueryModel.m6184a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    transactionInvoiceQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TransactionInvoiceQueryParser.m6263a(transactionInvoiceQueryModel.w_(), transactionInvoiceQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TransactionInvoiceQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ TransactionPaymentOptionFieldsModel m6193g() {
            return m6181s();
        }

        @Nullable
        public final /* synthetic */ TransactionItemProductFieldsModel m6194j() {
            return m6183u();
        }

        @Nullable
        public final /* synthetic */ TransactionShippingOptionFieldsModel lN_() {
            return m6182t();
        }

        @Nullable
        public final /* synthetic */ ReceiptImageModel lO_() {
            return m6180r();
        }

        public TransactionInvoiceQueryModel() {
            super(16);
        }

        public final void m6188a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6189a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m6177o() {
            if (this.b != null && this.f5900d == null) {
                this.f5900d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f5900d;
        }

        @Nullable
        public final String m6190b() {
            this.f5901e = super.a(this.f5901e, 1);
            return this.f5901e;
        }

        @Nullable
        public final String m6191c() {
            this.f5902f = super.a(this.f5902f, 2);
            return this.f5902f;
        }

        @Nullable
        public final String m6192d() {
            this.f5903g = super.a(this.f5903g, 3);
            return this.f5903g;
        }

        @Nullable
        private PageModel m6178p() {
            this.f5904h = (PageModel) super.a(this.f5904h, 4, PageModel.class);
            return this.f5904h;
        }

        @Nullable
        private PlatformContextModel m6179q() {
            this.f5905i = (PlatformContextModel) super.a(this.f5905i, 5, PlatformContextModel.class);
            return this.f5905i;
        }

        @Nullable
        private ReceiptImageModel m6180r() {
            this.f5906j = (ReceiptImageModel) super.a(this.f5906j, 6, ReceiptImageModel.class);
            return this.f5906j;
        }

        @Nullable
        private TransactionPaymentOptionFieldsModel m6181s() {
            this.f5907k = (TransactionPaymentOptionFieldsModel) super.a(this.f5907k, 7, TransactionPaymentOptionFieldsModel.class);
            return this.f5907k;
        }

        @Nullable
        private TransactionShippingOptionFieldsModel m6182t() {
            this.f5908l = (TransactionShippingOptionFieldsModel) super.a(this.f5908l, 8, TransactionShippingOptionFieldsModel.class);
            return this.f5908l;
        }

        @Nullable
        public final String lM_() {
            this.f5910n = super.a(this.f5910n, 10);
            return this.f5910n;
        }

        @Nullable
        private TransactionItemProductFieldsModel m6183u() {
            this.f5911o = (TransactionItemProductFieldsModel) super.a(this.f5911o, 11, TransactionItemProductFieldsModel.class);
            return this.f5911o;
        }

        @Nullable
        public final GraphQLPageProductTransactionOrderStatusEnum m6195k() {
            this.f5912p = (GraphQLPageProductTransactionOrderStatusEnum) super.b(this.f5912p, 12, GraphQLPageProductTransactionOrderStatusEnum.class, GraphQLPageProductTransactionOrderStatusEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5912p;
        }

        @Nullable
        public final String m6196l() {
            this.f5913q = super.a(this.f5913q, 13);
            return this.f5913q;
        }

        public final int m6197m() {
            a(1, 6);
            return this.f5914r;
        }

        public final int m6198n() {
            a(1, 7);
            return this.f5915s;
        }

        @Nullable
        public final String m6186a() {
            return m6192d();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m6185a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6178p() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m6178p());
                if (m6178p() != pageModel) {
                    graphQLVisitableModel = (TransactionInvoiceQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5904h = pageModel;
                }
            }
            if (m6179q() != null) {
                PlatformContextModel platformContextModel = (PlatformContextModel) graphQLModelMutatingVisitor.b(m6179q());
                if (m6179q() != platformContextModel) {
                    graphQLVisitableModel = (TransactionInvoiceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5905i = platformContextModel;
                }
            }
            if (m6180r() != null) {
                ReceiptImageModel receiptImageModel = (ReceiptImageModel) graphQLModelMutatingVisitor.b(m6180r());
                if (m6180r() != receiptImageModel) {
                    graphQLVisitableModel = (TransactionInvoiceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5906j = receiptImageModel;
                }
            }
            if (m6181s() != null) {
                TransactionPaymentOptionFieldsModel transactionPaymentOptionFieldsModel = (TransactionPaymentOptionFieldsModel) graphQLModelMutatingVisitor.b(m6181s());
                if (m6181s() != transactionPaymentOptionFieldsModel) {
                    graphQLVisitableModel = (TransactionInvoiceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5907k = transactionPaymentOptionFieldsModel;
                }
            }
            if (m6182t() != null) {
                TransactionShippingOptionFieldsModel transactionShippingOptionFieldsModel = (TransactionShippingOptionFieldsModel) graphQLModelMutatingVisitor.b(m6182t());
                if (m6182t() != transactionShippingOptionFieldsModel) {
                    graphQLVisitableModel = (TransactionInvoiceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5908l = transactionShippingOptionFieldsModel;
                }
            }
            if (m6183u() != null) {
                TransactionItemProductFieldsModel transactionItemProductFieldsModel = (TransactionItemProductFieldsModel) graphQLModelMutatingVisitor.b(m6183u());
                if (m6183u() != transactionItemProductFieldsModel) {
                    graphQLVisitableModel = (TransactionInvoiceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5911o = transactionItemProductFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6184a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6177o());
            int b = flatBufferBuilder.b(m6190b());
            int b2 = flatBufferBuilder.b(m6191c());
            int b3 = flatBufferBuilder.b(m6192d());
            int a2 = ModelHelper.a(flatBufferBuilder, m6178p());
            int a3 = ModelHelper.a(flatBufferBuilder, m6179q());
            int a4 = ModelHelper.a(flatBufferBuilder, m6180r());
            int a5 = ModelHelper.a(flatBufferBuilder, m6181s());
            int a6 = ModelHelper.a(flatBufferBuilder, m6182t());
            int b4 = flatBufferBuilder.b(lM_());
            int a7 = ModelHelper.a(flatBufferBuilder, m6183u());
            int a8 = flatBufferBuilder.a(m6195k());
            int b5 = flatBufferBuilder.b(m6196l());
            flatBufferBuilder.c(16);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.a(9, this.f5909m, 0);
            flatBufferBuilder.b(10, b4);
            flatBufferBuilder.b(11, a7);
            flatBufferBuilder.b(12, a8);
            flatBufferBuilder.b(13, b5);
            flatBufferBuilder.a(14, this.f5914r, 0);
            flatBufferBuilder.a(15, this.f5915s, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6187a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5909m = mutableFlatBuffer.a(i, 9, 0);
            this.f5914r = mutableFlatBuffer.a(i, 14, 0);
            this.f5915s = mutableFlatBuffer.a(i, 15, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 246613238)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: quickcam/ */
    public final class TransactionItemProductFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f5924d;

        /* compiled from: quickcam/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TransactionItemProductFieldsModel.class, new Deserializer());
            }

            public Object m6199a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TransactionItemProductFieldsParser.m6272a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object transactionItemProductFieldsModel = new TransactionItemProductFieldsModel();
                ((BaseModel) transactionItemProductFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (transactionItemProductFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) transactionItemProductFieldsModel).a();
                }
                return transactionItemProductFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1465755956)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: quickcam/ */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f5919d;
            @Nullable
            private NodeModel f5920e;
            private int f5921f;
            @Nullable
            private ProductImageModel f5922g;
            private int f5923h;

            /* compiled from: quickcam/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m6200a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m6270b(jsonParser, flatBufferBuilder));
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
            /* compiled from: quickcam/ */
            public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f5916d;

                /* compiled from: quickcam/ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                    }

                    public Object m6201a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodeParser.m6264a(jsonParser, flatBufferBuilder));
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

                /* compiled from: quickcam/ */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m6202a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeModel nodeModel = (NodeModel) obj;
                        if (nodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeModel.m6204a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodeParser.m6265a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodeModel.class, new Serializer());
                    }
                }

                public NodeModel() {
                    super(1);
                }

                @Nullable
                private String m6203j() {
                    this.f5916d = super.a(this.f5916d, 0);
                    return this.f5916d;
                }

                @Nullable
                public final String m6206a() {
                    return m6203j();
                }

                public final int jK_() {
                    return 175920258;
                }

                public final GraphQLVisitableModel m6205a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6204a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6203j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1131863994)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: quickcam/ */
            public final class ProductImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ImageModel f5918d;

                /* compiled from: quickcam/ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProductImageModel.class, new Deserializer());
                    }

                    public Object m6207a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProductImageParser.m6268a(jsonParser, flatBufferBuilder));
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
                /* compiled from: quickcam/ */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f5917d;

                    /* compiled from: quickcam/ */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m6208a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProductImageParser.ImageParser.m6266a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: quickcam/ */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m6209a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m6210a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ProductImageParser.ImageParser.m6267a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m6212a() {
                        this.f5917d = super.a(this.f5917d, 0);
                        return this.f5917d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m6211a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6210a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m6212a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: quickcam/ */
                public class Serializer extends JsonSerializer<ProductImageModel> {
                    public final void m6213a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProductImageModel productImageModel = (ProductImageModel) obj;
                        if (productImageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(productImageModel.m6215a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            productImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProductImageParser.m6269a(productImageModel.w_(), productImageModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ProductImageModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ImageModel m6216a() {
                    return m6214j();
                }

                public ProductImageModel() {
                    super(1);
                }

                @Nullable
                private ImageModel m6214j() {
                    this.f5918d = (ImageModel) super.a(this.f5918d, 0, ImageModel.class);
                    return this.f5918d;
                }

                public final int jK_() {
                    return 1158348236;
                }

                public final GraphQLVisitableModel m6217a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6214j() != null) {
                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m6214j());
                        if (m6214j() != imageModel) {
                            graphQLVisitableModel = (ProductImageModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5918d = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6215a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6214j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: quickcam/ */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m6218a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m6221a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m6271b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ProductImageModel m6225b() {
                return m6220k();
            }

            public EdgesModel() {
                super(5);
            }

            @Nullable
            public final String m6223a() {
                this.f5919d = super.a(this.f5919d, 0);
                return this.f5919d;
            }

            @Nullable
            private NodeModel m6219j() {
                this.f5920e = (NodeModel) super.a(this.f5920e, 1, NodeModel.class);
                return this.f5920e;
            }

            @Nullable
            private ProductImageModel m6220k() {
                this.f5922g = (ProductImageModel) super.a(this.f5922g, 3, ProductImageModel.class);
                return this.f5922g;
            }

            public final int m6226c() {
                a(0, 4);
                return this.f5923h;
            }

            public final int jK_() {
                return -1814235189;
            }

            public final GraphQLVisitableModel m6222a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6219j() != null) {
                    NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m6219j());
                    if (m6219j() != nodeModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5920e = nodeModel;
                    }
                }
                if (m6220k() != null) {
                    ProductImageModel productImageModel = (ProductImageModel) graphQLModelMutatingVisitor.b(m6220k());
                    if (m6220k() != productImageModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5922g = productImageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6221a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6223a());
                int a = ModelHelper.a(flatBufferBuilder, m6219j());
                int a2 = ModelHelper.a(flatBufferBuilder, m6220k());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.a(2, this.f5921f, 0);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.a(4, this.f5923h, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m6224a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5921f = mutableFlatBuffer.a(i, 2, 0);
                this.f5923h = mutableFlatBuffer.a(i, 4, 0);
            }
        }

        /* compiled from: quickcam/ */
        public class Serializer extends JsonSerializer<TransactionItemProductFieldsModel> {
            public final void m6227a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TransactionItemProductFieldsModel transactionItemProductFieldsModel = (TransactionItemProductFieldsModel) obj;
                if (transactionItemProductFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(transactionItemProductFieldsModel.m6228a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    transactionItemProductFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TransactionItemProductFieldsParser.m6273a(transactionItemProductFieldsModel.w_(), transactionItemProductFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TransactionItemProductFieldsModel.class, new Serializer());
            }
        }

        public TransactionItemProductFieldsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m6230a() {
            this.f5924d = super.a(this.f5924d, 0, EdgesModel.class);
            return (ImmutableList) this.f5924d;
        }

        public final int jK_() {
            return 809092716;
        }

        public final GraphQLVisitableModel m6229a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6230a() != null) {
                Builder a = ModelHelper.a(m6230a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TransactionItemProductFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5924d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6228a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6230a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1591376434)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: quickcam/ */
    public final class TransactionPaymentOptionFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f5925d;
        @Nullable
        private String f5926e;
        @Nullable
        private String f5927f;
        @Nullable
        private GraphQLPageProductTransactionPaymentTypeEnum f5928g;

        /* compiled from: quickcam/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TransactionPaymentOptionFieldsModel.class, new Deserializer());
            }

            public Object m6231a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TransactionPaymentOptionFieldsParser.m6274a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object transactionPaymentOptionFieldsModel = new TransactionPaymentOptionFieldsModel();
                ((BaseModel) transactionPaymentOptionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (transactionPaymentOptionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) transactionPaymentOptionFieldsModel).a();
                }
                return transactionPaymentOptionFieldsModel;
            }
        }

        /* compiled from: quickcam/ */
        public class Serializer extends JsonSerializer<TransactionPaymentOptionFieldsModel> {
            public final void m6232a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TransactionPaymentOptionFieldsModel transactionPaymentOptionFieldsModel = (TransactionPaymentOptionFieldsModel) obj;
                if (transactionPaymentOptionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(transactionPaymentOptionFieldsModel.m6235a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    transactionPaymentOptionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TransactionPaymentOptionFieldsParser.m6275a(transactionPaymentOptionFieldsModel.w_(), transactionPaymentOptionFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(TransactionPaymentOptionFieldsModel.class, new Serializer());
            }
        }

        public TransactionPaymentOptionFieldsModel() {
            super(4);
        }

        @Nullable
        public final String m6238b() {
            this.f5925d = super.a(this.f5925d, 0);
            return this.f5925d;
        }

        @Nullable
        private String m6233j() {
            this.f5926e = super.a(this.f5926e, 1);
            return this.f5926e;
        }

        @Nullable
        public final String m6239c() {
            this.f5927f = super.a(this.f5927f, 2);
            return this.f5927f;
        }

        @Nullable
        private GraphQLPageProductTransactionPaymentTypeEnum m6234k() {
            this.f5928g = (GraphQLPageProductTransactionPaymentTypeEnum) super.b(this.f5928g, 3, GraphQLPageProductTransactionPaymentTypeEnum.class, GraphQLPageProductTransactionPaymentTypeEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5928g;
        }

        @Nullable
        public final String m6237a() {
            return m6233j();
        }

        public final int jK_() {
            return -1345707011;
        }

        public final GraphQLVisitableModel m6236a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6235a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6238b());
            int b2 = flatBufferBuilder.b(m6233j());
            int b3 = flatBufferBuilder.b(m6239c());
            int a = flatBufferBuilder.a(m6234k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1979799013)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: quickcam/ */
    public final class TransactionShippingOptionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f5931d;
        @Nullable
        private ShippingPriceAndCurrencyModel f5932e;

        /* compiled from: quickcam/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TransactionShippingOptionFieldsModel.class, new Deserializer());
            }

            public Object m6240a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TransactionShippingOptionFieldsParser.m6278a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object transactionShippingOptionFieldsModel = new TransactionShippingOptionFieldsModel();
                ((BaseModel) transactionShippingOptionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (transactionShippingOptionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) transactionShippingOptionFieldsModel).a();
                }
                return transactionShippingOptionFieldsModel;
            }
        }

        /* compiled from: quickcam/ */
        public class Serializer extends JsonSerializer<TransactionShippingOptionFieldsModel> {
            public final void m6241a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TransactionShippingOptionFieldsModel transactionShippingOptionFieldsModel = (TransactionShippingOptionFieldsModel) obj;
                if (transactionShippingOptionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(transactionShippingOptionFieldsModel.m6250a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    transactionShippingOptionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TransactionShippingOptionFieldsParser.m6279a(transactionShippingOptionFieldsModel.w_(), transactionShippingOptionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TransactionShippingOptionFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1377760999)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: quickcam/ */
        public final class ShippingPriceAndCurrencyModel extends BaseModel implements GraphQLVisitableModel {
            private int f5929d;
            @Nullable
            private String f5930e;

            /* compiled from: quickcam/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ShippingPriceAndCurrencyModel.class, new Deserializer());
                }

                public Object m6242a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ShippingPriceAndCurrencyParser.m6276a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object shippingPriceAndCurrencyModel = new ShippingPriceAndCurrencyModel();
                    ((BaseModel) shippingPriceAndCurrencyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (shippingPriceAndCurrencyModel instanceof Postprocessable) {
                        return ((Postprocessable) shippingPriceAndCurrencyModel).a();
                    }
                    return shippingPriceAndCurrencyModel;
                }
            }

            /* compiled from: quickcam/ */
            public class Serializer extends JsonSerializer<ShippingPriceAndCurrencyModel> {
                public final void m6243a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ShippingPriceAndCurrencyModel shippingPriceAndCurrencyModel = (ShippingPriceAndCurrencyModel) obj;
                    if (shippingPriceAndCurrencyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(shippingPriceAndCurrencyModel.m6246a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        shippingPriceAndCurrencyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ShippingPriceAndCurrencyParser.m6277a(shippingPriceAndCurrencyModel.w_(), shippingPriceAndCurrencyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ShippingPriceAndCurrencyModel.class, new Serializer());
                }
            }

            public ShippingPriceAndCurrencyModel() {
                super(2);
            }

            public final int m6245a() {
                a(0, 0);
                return this.f5929d;
            }

            @Nullable
            private String m6244j() {
                this.f5930e = super.a(this.f5930e, 1);
                return this.f5930e;
            }

            public final int jK_() {
                return -1840781335;
            }

            public final GraphQLVisitableModel m6247a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6246a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6244j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f5929d, 0);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m6248a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5929d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @Nullable
        public final /* synthetic */ ShippingPriceAndCurrencyModel m6253b() {
            return m6249j();
        }

        public TransactionShippingOptionFieldsModel() {
            super(2);
        }

        @Nullable
        public final String m6252a() {
            this.f5931d = super.a(this.f5931d, 0);
            return this.f5931d;
        }

        @Nullable
        private ShippingPriceAndCurrencyModel m6249j() {
            this.f5932e = (ShippingPriceAndCurrencyModel) super.a(this.f5932e, 1, ShippingPriceAndCurrencyModel.class);
            return this.f5932e;
        }

        public final int jK_() {
            return -1613137375;
        }

        public final GraphQLVisitableModel m6251a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6249j() != null) {
                ShippingPriceAndCurrencyModel shippingPriceAndCurrencyModel = (ShippingPriceAndCurrencyModel) graphQLModelMutatingVisitor.b(m6249j());
                if (m6249j() != shippingPriceAndCurrencyModel) {
                    graphQLVisitableModel = (TransactionShippingOptionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5932e = shippingPriceAndCurrencyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6250a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6252a());
            int a = ModelHelper.a(flatBufferBuilder, m6249j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
