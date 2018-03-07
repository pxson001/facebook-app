package com.facebook.messaging.graphql.threads.business;

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
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsInterfaces.AgentItemReceiptBubble;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsInterfaces.AgentItemReceiptBubble.Payment;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsParsers.AgentItemReceiptBubbleParser;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsParsers.AgentItemReceiptBubbleParser.ItemParser;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsParsers.AgentItemReceiptBubbleParser.PaymentParser;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsParsers.BusinessIsPageLinkedQueryParser;
import com.facebook.messaging.graphql.threads.business.AgentThreadFragmentsParsers.BusinessIsPageLinkedQueryParser.MessengerCommerceParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: video texture */
public class AgentThreadFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -559204690)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video texture */
    public final class AgentItemReceiptBubbleModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, AgentItemReceiptBubble {
        @Nullable
        private String f1724d;
        @Nullable
        private ItemModel f1725e;
        @Nullable
        private PaymentModel f1726f;

        /* compiled from: video texture */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AgentItemReceiptBubbleModel.class, new Deserializer());
            }

            public Object m2977a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AgentItemReceiptBubbleParser.m3017a(jsonParser);
                Object agentItemReceiptBubbleModel = new AgentItemReceiptBubbleModel();
                ((BaseModel) agentItemReceiptBubbleModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (agentItemReceiptBubbleModel instanceof Postprocessable) {
                    return ((Postprocessable) agentItemReceiptBubbleModel).a();
                }
                return agentItemReceiptBubbleModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 58502942)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video texture */
        public final class ItemModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f1721d;
            @Nullable
            private String f1722e;

            /* compiled from: video texture */
            public final class Builder {
                @Nullable
                public String f1719a;
                @Nullable
                public String f1720b;
            }

            /* compiled from: video texture */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ItemModel.class, new Deserializer());
                }

                public Object m2978a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ItemParser.m3013a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object itemModel = new ItemModel();
                    ((BaseModel) itemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (itemModel instanceof Postprocessable) {
                        return ((Postprocessable) itemModel).a();
                    }
                    return itemModel;
                }
            }

            /* compiled from: video texture */
            public class Serializer extends JsonSerializer<ItemModel> {
                public final void m2979a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ItemModel itemModel = (ItemModel) obj;
                    if (itemModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(itemModel.m2981a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        itemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ItemParser.m3014a(itemModel.w_(), itemModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ItemModel.class, new Serializer());
                }
            }

            public ItemModel() {
                super(2);
            }

            public ItemModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m2984b() {
                this.f1721d = super.a(this.f1721d, 0);
                return this.f1721d;
            }

            @Nullable
            public final String m2985c() {
                this.f1722e = super.a(this.f1722e, 1);
                return this.f1722e;
            }

            public static ItemModel m2980a(ItemModel itemModel) {
                if (itemModel == null) {
                    return null;
                }
                if (itemModel instanceof ItemModel) {
                    return itemModel;
                }
                Builder builder = new Builder();
                builder.f1719a = itemModel.m2984b();
                builder.f1720b = itemModel.m2985c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f1719a);
                int b2 = flatBufferBuilder.b(builder.f1720b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ItemModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m2983a() {
                return m2985c();
            }

            public final int jK_() {
                return 1851543484;
            }

            public final GraphQLVisitableModel m2982a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2981a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2984b());
                int b2 = flatBufferBuilder.b(m2985c());
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
        /* compiled from: video texture */
        public final class PaymentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, Payment {
            @Nullable
            private String f1723d;

            /* compiled from: video texture */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PaymentModel.class, new Deserializer());
                }

                public Object m2986a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PaymentParser.m3015a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object paymentModel = new PaymentModel();
                    ((BaseModel) paymentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (paymentModel instanceof Postprocessable) {
                        return ((Postprocessable) paymentModel).a();
                    }
                    return paymentModel;
                }
            }

            /* compiled from: video texture */
            public class Serializer extends JsonSerializer<PaymentModel> {
                public final void m2987a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PaymentModel paymentModel = (PaymentModel) obj;
                    if (paymentModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(paymentModel.m2988a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        paymentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PaymentParser.m3016a(paymentModel.w_(), paymentModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PaymentModel.class, new Serializer());
                }
            }

            public PaymentModel() {
                super(1);
            }

            @Nullable
            public final String mo129b() {
                this.f1723d = super.a(this.f1723d, 0);
                return this.f1723d;
            }

            @Nullable
            public final String m2990a() {
                return mo129b();
            }

            public final int jK_() {
                return -1658635464;
            }

            public final GraphQLVisitableModel m2989a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2988a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo129b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video texture */
        public class Serializer extends JsonSerializer<AgentItemReceiptBubbleModel> {
            public final void m2992a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AgentItemReceiptBubbleModel agentItemReceiptBubbleModel = (AgentItemReceiptBubbleModel) obj;
                if (agentItemReceiptBubbleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(agentItemReceiptBubbleModel.m2996a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    agentItemReceiptBubbleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = agentItemReceiptBubbleModel.w_();
                int u_ = agentItemReceiptBubbleModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("item");
                    ItemParser.m3014a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("payment");
                    PaymentParser.m3016a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AgentItemReceiptBubbleModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ Payment bL() {
            return m2995l();
        }

        public AgentItemReceiptBubbleModel() {
            super(3);
        }

        @Nullable
        private String m2993j() {
            this.f1724d = super.a(this.f1724d, 0);
            return this.f1724d;
        }

        @Nullable
        private ItemModel m2994k() {
            this.f1725e = (ItemModel) super.a(this.f1725e, 1, ItemModel.class);
            return this.f1725e;
        }

        @Nullable
        private PaymentModel m2995l() {
            this.f1726f = (PaymentModel) super.a(this.f1726f, 2, PaymentModel.class);
            return this.f1726f;
        }

        @Nullable
        public final String m2998a() {
            return m2993j();
        }

        public final int jK_() {
            return 112625536;
        }

        public final GraphQLVisitableModel m2997a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2994k() != null) {
                ItemModel itemModel = (ItemModel) graphQLModelMutatingVisitor.b(m2994k());
                if (m2994k() != itemModel) {
                    graphQLVisitableModel = (AgentItemReceiptBubbleModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1725e = itemModel;
                }
            }
            if (m2995l() != null) {
                PaymentModel paymentModel = (PaymentModel) graphQLModelMutatingVisitor.b(m2995l());
                if (m2995l() != paymentModel) {
                    graphQLVisitableModel = (AgentItemReceiptBubbleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1726f = paymentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2996a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2993j());
            int a = ModelHelper.a(flatBufferBuilder, m2994k());
            int a2 = ModelHelper.a(flatBufferBuilder, m2995l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 927339043)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video texture */
    public final class BusinessIsPageLinkedQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f1728d;
        @Nullable
        private MessengerCommerceModel f1729e;

        /* compiled from: video texture */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessIsPageLinkedQueryModel.class, new Deserializer());
            }

            public Object m2999a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BusinessIsPageLinkedQueryParser.m3020a(jsonParser);
                Object businessIsPageLinkedQueryModel = new BusinessIsPageLinkedQueryModel();
                ((BaseModel) businessIsPageLinkedQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (businessIsPageLinkedQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) businessIsPageLinkedQueryModel).a();
                }
                return businessIsPageLinkedQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -781555273)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video texture */
        public final class MessengerCommerceModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f1727d;

            /* compiled from: video texture */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerCommerceModel.class, new Deserializer());
                }

                public Object m3000a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerCommerceParser.m3018a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerCommerceModel = new MessengerCommerceModel();
                    ((BaseModel) messengerCommerceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerCommerceModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerCommerceModel).a();
                    }
                    return messengerCommerceModel;
                }
            }

            /* compiled from: video texture */
            public class Serializer extends JsonSerializer<MessengerCommerceModel> {
                public final void m3001a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerCommerceModel messengerCommerceModel = (MessengerCommerceModel) obj;
                    if (messengerCommerceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerCommerceModel.m3002a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerCommerceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerCommerceParser.m3019a(messengerCommerceModel.w_(), messengerCommerceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessengerCommerceModel.class, new Serializer());
                }
            }

            public MessengerCommerceModel() {
                super(1);
            }

            public final boolean m3005a() {
                a(0, 0);
                return this.f1727d;
            }

            public final int jK_() {
                return -1387886866;
            }

            public final GraphQLVisitableModel m3003a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3002a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f1727d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3004a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1727d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: video texture */
        public class Serializer extends JsonSerializer<BusinessIsPageLinkedQueryModel> {
            public final void m3006a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BusinessIsPageLinkedQueryModel businessIsPageLinkedQueryModel = (BusinessIsPageLinkedQueryModel) obj;
                if (businessIsPageLinkedQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessIsPageLinkedQueryModel.m3008a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessIsPageLinkedQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = businessIsPageLinkedQueryModel.w_();
                int u_ = businessIsPageLinkedQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("messenger_commerce");
                    MessengerCommerceParser.m3019a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BusinessIsPageLinkedQueryModel.class, new Serializer());
            }
        }

        public BusinessIsPageLinkedQueryModel() {
            super(2);
        }

        public final void m3011a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m3012a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m3007j() {
            if (this.b != null && this.f1728d == null) {
                this.f1728d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1728d;
        }

        @Nullable
        public final MessengerCommerceModel m3010a() {
            this.f1729e = (MessengerCommerceModel) super.a(this.f1729e, 1, MessengerCommerceModel.class);
            return this.f1729e;
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m3009a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3010a() != null) {
                MessengerCommerceModel messengerCommerceModel = (MessengerCommerceModel) graphQLModelMutatingVisitor.b(m3010a());
                if (m3010a() != messengerCommerceModel) {
                    graphQLVisitableModel = (BusinessIsPageLinkedQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1729e = messengerCommerceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3008a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3007j());
            int a2 = ModelHelper.a(flatBufferBuilder, m3010a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
