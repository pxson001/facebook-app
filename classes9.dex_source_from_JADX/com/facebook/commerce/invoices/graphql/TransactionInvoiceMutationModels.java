package com.facebook.commerce.invoices.graphql;

import com.facebook.commerce.invoices.graphql.TransactionInvoiceMutationParsers.TransactionInvoiceMutationParser;
import com.facebook.commerce.invoices.graphql.TransactionInvoiceMutationParsers.TransactionInvoiceMutationParser.InvoiceParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPageProductTransactionOrderStatusEnum;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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

/* compiled from: quoted-printable */
public class TransactionInvoiceMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1083447021)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: quoted-printable */
    public final class TransactionInvoiceMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private InvoiceModel f5894d;

        /* compiled from: quoted-printable */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TransactionInvoiceMutationModel.class, new Deserializer());
            }

            public Object m6133a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TransactionInvoiceMutationParser.m6147a(jsonParser);
                Object transactionInvoiceMutationModel = new TransactionInvoiceMutationModel();
                ((BaseModel) transactionInvoiceMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (transactionInvoiceMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) transactionInvoiceMutationModel).a();
                }
                return transactionInvoiceMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1124995294)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: quoted-printable */
        public final class InvoiceModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f5892d;
            @Nullable
            private GraphQLPageProductTransactionOrderStatusEnum f5893e;

            /* compiled from: quoted-printable */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InvoiceModel.class, new Deserializer());
                }

                public Object m6134a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InvoiceParser.m6145a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object invoiceModel = new InvoiceModel();
                    ((BaseModel) invoiceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (invoiceModel instanceof Postprocessable) {
                        return ((Postprocessable) invoiceModel).a();
                    }
                    return invoiceModel;
                }
            }

            /* compiled from: quoted-printable */
            public class Serializer extends JsonSerializer<InvoiceModel> {
                public final void m6135a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InvoiceModel invoiceModel = (InvoiceModel) obj;
                    if (invoiceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(invoiceModel.m6138a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        invoiceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InvoiceParser.m6146a(invoiceModel.w_(), invoiceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(InvoiceModel.class, new Serializer());
                }
            }

            public InvoiceModel() {
                super(2);
            }

            @Nullable
            private String m6136j() {
                this.f5892d = super.a(this.f5892d, 0);
                return this.f5892d;
            }

            @Nullable
            private GraphQLPageProductTransactionOrderStatusEnum m6137k() {
                this.f5893e = (GraphQLPageProductTransactionOrderStatusEnum) super.b(this.f5893e, 1, GraphQLPageProductTransactionOrderStatusEnum.class, GraphQLPageProductTransactionOrderStatusEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5893e;
            }

            @Nullable
            public final String m6140a() {
                return m6136j();
            }

            public final int jK_() {
                return -1102680433;
            }

            public final GraphQLVisitableModel m6139a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m6138a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m6136j());
                int a = flatBufferBuilder.a(m6137k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: quoted-printable */
        public class Serializer extends JsonSerializer<TransactionInvoiceMutationModel> {
            public final void m6141a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TransactionInvoiceMutationModel transactionInvoiceMutationModel = (TransactionInvoiceMutationModel) obj;
                if (transactionInvoiceMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(transactionInvoiceMutationModel.m6143a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    transactionInvoiceMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = transactionInvoiceMutationModel.w_();
                int u_ = transactionInvoiceMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("invoice");
                    InvoiceParser.m6146a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TransactionInvoiceMutationModel.class, new Serializer());
            }
        }

        public TransactionInvoiceMutationModel() {
            super(1);
        }

        @Nullable
        private InvoiceModel m6142a() {
            this.f5894d = (InvoiceModel) super.a(this.f5894d, 0, InvoiceModel.class);
            return this.f5894d;
        }

        public final int jK_() {
            return 1167911552;
        }

        public final GraphQLVisitableModel m6144a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6142a() != null) {
                InvoiceModel invoiceModel = (InvoiceModel) graphQLModelMutatingVisitor.b(m6142a());
                if (m6142a() != invoiceModel) {
                    graphQLVisitableModel = (TransactionInvoiceMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5894d = invoiceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6143a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6142a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
