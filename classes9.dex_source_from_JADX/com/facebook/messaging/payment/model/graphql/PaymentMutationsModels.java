package com.facebook.messaging.payment.model.graphql;

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
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLParsers.PaymentPlatformContextParser;
import com.facebook.messaging.payment.model.graphql.PaymentMutationsParsers.CreateCommerceCartP2pPlatformContextCoreMutationParser;
import com.facebook.messaging.payment.model.graphql.PaymentMutationsParsers.CreateP2pPlatformContextCoreMutationParser;
import com.facebook.messaging.payment.model.graphql.PaymentMutationsParsers.CreateP2pPlatformContextCoreMutationParser.GroupCommerceProductItemParser;
import com.facebook.messaging.payment.model.graphql.PaymentMutationsParsers.CreateP2pPlatformContextCoreMutationParser.P2pPlatformContextParser;
import com.facebook.messaging.payment.model.graphql.PaymentMutationsParsers.P2pPlatformContextSetShippingAddressMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: headerSubtitle */
public class PaymentMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1846390582)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: headerSubtitle */
    public final class CreateCommerceCartP2pPlatformContextCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PaymentPlatformContextModel f13473d;

        /* compiled from: headerSubtitle */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CreateCommerceCartP2pPlatformContextCoreMutationModel.class, new Deserializer());
            }

            public Object m14037a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CreateCommerceCartP2pPlatformContextCoreMutationParser.m14065a(jsonParser);
                Object createCommerceCartP2pPlatformContextCoreMutationModel = new CreateCommerceCartP2pPlatformContextCoreMutationModel();
                ((BaseModel) createCommerceCartP2pPlatformContextCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (createCommerceCartP2pPlatformContextCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) createCommerceCartP2pPlatformContextCoreMutationModel).a();
                }
                return createCommerceCartP2pPlatformContextCoreMutationModel;
            }
        }

        /* compiled from: headerSubtitle */
        public class Serializer extends JsonSerializer<CreateCommerceCartP2pPlatformContextCoreMutationModel> {
            public final void m14038a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CreateCommerceCartP2pPlatformContextCoreMutationModel createCommerceCartP2pPlatformContextCoreMutationModel = (CreateCommerceCartP2pPlatformContextCoreMutationModel) obj;
                if (createCommerceCartP2pPlatformContextCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(createCommerceCartP2pPlatformContextCoreMutationModel.m14039a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    createCommerceCartP2pPlatformContextCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = createCommerceCartP2pPlatformContextCoreMutationModel.w_();
                int u_ = createCommerceCartP2pPlatformContextCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("p2p_platform_context");
                    PaymentPlatformContextParser.m13995b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CreateCommerceCartP2pPlatformContextCoreMutationModel.class, new Serializer());
            }
        }

        public CreateCommerceCartP2pPlatformContextCoreMutationModel() {
            super(1);
        }

        @Nullable
        public final PaymentPlatformContextModel m14041a() {
            this.f13473d = (PaymentPlatformContextModel) super.a(this.f13473d, 0, PaymentPlatformContextModel.class);
            return this.f13473d;
        }

        public final int jK_() {
            return -1135529432;
        }

        public final GraphQLVisitableModel m14040a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14041a() != null) {
                PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) graphQLModelMutatingVisitor.b(m14041a());
                if (m14041a() != paymentPlatformContextModel) {
                    graphQLVisitableModel = (CreateCommerceCartP2pPlatformContextCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13473d = paymentPlatformContextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14039a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14041a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1262228502)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: headerSubtitle */
    public final class CreateP2pPlatformContextCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupCommerceProductItemModel f13476d;
        @Nullable
        private P2pPlatformContextModel f13477e;

        /* compiled from: headerSubtitle */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CreateP2pPlatformContextCoreMutationModel.class, new Deserializer());
            }

            public Object m14042a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CreateP2pPlatformContextCoreMutationParser.m14070a(jsonParser);
                Object createP2pPlatformContextCoreMutationModel = new CreateP2pPlatformContextCoreMutationModel();
                ((BaseModel) createP2pPlatformContextCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (createP2pPlatformContextCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) createP2pPlatformContextCoreMutationModel).a();
                }
                return createP2pPlatformContextCoreMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: headerSubtitle */
        public final class GroupCommerceProductItemModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f13474d;

            /* compiled from: headerSubtitle */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupCommerceProductItemModel.class, new Deserializer());
                }

                public Object m14043a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupCommerceProductItemParser.m14066a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupCommerceProductItemModel = new GroupCommerceProductItemModel();
                    ((BaseModel) groupCommerceProductItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupCommerceProductItemModel instanceof Postprocessable) {
                        return ((Postprocessable) groupCommerceProductItemModel).a();
                    }
                    return groupCommerceProductItemModel;
                }
            }

            /* compiled from: headerSubtitle */
            public class Serializer extends JsonSerializer<GroupCommerceProductItemModel> {
                public final void m14044a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupCommerceProductItemModel groupCommerceProductItemModel = (GroupCommerceProductItemModel) obj;
                    if (groupCommerceProductItemModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupCommerceProductItemModel.m14046a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupCommerceProductItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupCommerceProductItemParser.m14067a(groupCommerceProductItemModel.w_(), groupCommerceProductItemModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupCommerceProductItemModel.class, new Serializer());
                }
            }

            public GroupCommerceProductItemModel() {
                super(1);
            }

            @Nullable
            private String m14045j() {
                this.f13474d = super.a(this.f13474d, 0);
                return this.f13474d;
            }

            @Nullable
            public final String m14048a() {
                return m14045j();
            }

            public final int jK_() {
                return 638661096;
            }

            public final GraphQLVisitableModel m14047a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14046a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14045j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: headerSubtitle */
        public final class P2pPlatformContextModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f13475d;

            /* compiled from: headerSubtitle */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(P2pPlatformContextModel.class, new Deserializer());
                }

                public Object m14049a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(P2pPlatformContextParser.m14068a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object p2pPlatformContextModel = new P2pPlatformContextModel();
                    ((BaseModel) p2pPlatformContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (p2pPlatformContextModel instanceof Postprocessable) {
                        return ((Postprocessable) p2pPlatformContextModel).a();
                    }
                    return p2pPlatformContextModel;
                }
            }

            /* compiled from: headerSubtitle */
            public class Serializer extends JsonSerializer<P2pPlatformContextModel> {
                public final void m14050a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    P2pPlatformContextModel p2pPlatformContextModel = (P2pPlatformContextModel) obj;
                    if (p2pPlatformContextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(p2pPlatformContextModel.m14051a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        p2pPlatformContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    P2pPlatformContextParser.m14069a(p2pPlatformContextModel.w_(), p2pPlatformContextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(P2pPlatformContextModel.class, new Serializer());
                }
            }

            public P2pPlatformContextModel() {
                super(1);
            }

            @Nullable
            public final String m14054j() {
                this.f13475d = super.a(this.f13475d, 0);
                return this.f13475d;
            }

            @Nullable
            public final String m14053a() {
                return m14054j();
            }

            public final int jK_() {
                return -377623267;
            }

            public final GraphQLVisitableModel m14052a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14051a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14054j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: headerSubtitle */
        public class Serializer extends JsonSerializer<CreateP2pPlatformContextCoreMutationModel> {
            public final void m14055a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CreateP2pPlatformContextCoreMutationModel createP2pPlatformContextCoreMutationModel = (CreateP2pPlatformContextCoreMutationModel) obj;
                if (createP2pPlatformContextCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(createP2pPlatformContextCoreMutationModel.m14057a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    createP2pPlatformContextCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = createP2pPlatformContextCoreMutationModel.w_();
                int u_ = createP2pPlatformContextCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_commerce_product_item");
                    GroupCommerceProductItemParser.m14067a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("p2p_platform_context");
                    P2pPlatformContextParser.m14069a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CreateP2pPlatformContextCoreMutationModel.class, new Serializer());
            }
        }

        public CreateP2pPlatformContextCoreMutationModel() {
            super(2);
        }

        @Nullable
        private GroupCommerceProductItemModel m14056j() {
            this.f13476d = (GroupCommerceProductItemModel) super.a(this.f13476d, 0, GroupCommerceProductItemModel.class);
            return this.f13476d;
        }

        @Nullable
        public final P2pPlatformContextModel m14059a() {
            this.f13477e = (P2pPlatformContextModel) super.a(this.f13477e, 1, P2pPlatformContextModel.class);
            return this.f13477e;
        }

        public final int jK_() {
            return -219501181;
        }

        public final GraphQLVisitableModel m14058a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14056j() != null) {
                GroupCommerceProductItemModel groupCommerceProductItemModel = (GroupCommerceProductItemModel) graphQLModelMutatingVisitor.b(m14056j());
                if (m14056j() != groupCommerceProductItemModel) {
                    graphQLVisitableModel = (CreateP2pPlatformContextCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13476d = groupCommerceProductItemModel;
                }
            }
            if (m14059a() != null) {
                P2pPlatformContextModel p2pPlatformContextModel = (P2pPlatformContextModel) graphQLModelMutatingVisitor.b(m14059a());
                if (m14059a() != p2pPlatformContextModel) {
                    graphQLVisitableModel = (CreateP2pPlatformContextCoreMutationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13477e = p2pPlatformContextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14057a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14056j());
            int a2 = ModelHelper.a(flatBufferBuilder, m14059a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1846390582)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: headerSubtitle */
    public final class P2pPlatformContextSetShippingAddressMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PaymentPlatformContextModel f13478d;

        /* compiled from: headerSubtitle */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(P2pPlatformContextSetShippingAddressMutationModel.class, new Deserializer());
            }

            public Object m14060a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = P2pPlatformContextSetShippingAddressMutationParser.m14071a(jsonParser);
                Object p2pPlatformContextSetShippingAddressMutationModel = new P2pPlatformContextSetShippingAddressMutationModel();
                ((BaseModel) p2pPlatformContextSetShippingAddressMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (p2pPlatformContextSetShippingAddressMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) p2pPlatformContextSetShippingAddressMutationModel).a();
                }
                return p2pPlatformContextSetShippingAddressMutationModel;
            }
        }

        /* compiled from: headerSubtitle */
        public class Serializer extends JsonSerializer<P2pPlatformContextSetShippingAddressMutationModel> {
            public final void m14061a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                P2pPlatformContextSetShippingAddressMutationModel p2pPlatformContextSetShippingAddressMutationModel = (P2pPlatformContextSetShippingAddressMutationModel) obj;
                if (p2pPlatformContextSetShippingAddressMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(p2pPlatformContextSetShippingAddressMutationModel.m14062a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    p2pPlatformContextSetShippingAddressMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = p2pPlatformContextSetShippingAddressMutationModel.w_();
                int u_ = p2pPlatformContextSetShippingAddressMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("p2p_platform_context");
                    PaymentPlatformContextParser.m13995b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(P2pPlatformContextSetShippingAddressMutationModel.class, new Serializer());
            }
        }

        public P2pPlatformContextSetShippingAddressMutationModel() {
            super(1);
        }

        @Nullable
        public final PaymentPlatformContextModel m14064a() {
            this.f13478d = (PaymentPlatformContextModel) super.a(this.f13478d, 0, PaymentPlatformContextModel.class);
            return this.f13478d;
        }

        public final int jK_() {
            return -1054154661;
        }

        public final GraphQLVisitableModel m14063a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14064a() != null) {
                PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) graphQLModelMutatingVisitor.b(m14064a());
                if (m14064a() != paymentPlatformContextModel) {
                    graphQLVisitableModel = (P2pPlatformContextSetShippingAddressMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13478d = paymentPlatformContextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14062a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14064a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
