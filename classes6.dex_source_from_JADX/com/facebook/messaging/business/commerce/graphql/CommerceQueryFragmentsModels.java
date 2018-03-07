package com.facebook.messaging.business.commerce.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsInterfaces.CommercePaginatedRetailItems;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceOrderReceiptParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceOrderReceiptParser.ReceipientParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceOrderReceiptParser.RetailAdjustmentsParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommercePaginatedRetailItemsParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommercePaginatedRetailItemsParser.RetailItemsParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceShipmentDetailsParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceShipmentDetailsParser.ReceiptParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceShoppingTrendingQueryParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceShoppingTrendingQueryParser.CommerceItemsParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceShoppingTrendingQueryParser.CommerceItemsParser.EdgesParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceShoppingTrendingQueryParser.CommerceItemsParser.EdgesParser.NodeParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceShortOrderReceiptParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.MessengerCommerceFetchProductGroupQueryParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.MessengerCommerceFetchProductGroupQueryParser.CommerceMerchantSettingsParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.MessengerCommerceFetchProductGroupQueryParser.GroupParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.MessengerCommerceFetchProductGroupQueryParser.GroupParser.ProductItemsEdgeParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.MessengerCommerceFetchProductGroupQueryParser.GroupParser.ProductItemsEdgeParser.NodesParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.MessengerCommerceFetchProductGroupQueryParser.GroupParser.ProductItemsEdgeParser.NodesParser.ImageParser;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.MessengerCommerceProductPriceFieldsParser;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceBaseOrderReceipt;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceShipmentBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.LogoImage;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceRetailItemModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.ShipmentTrackingEventsModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.LogoImageModel;
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

/* compiled from: video_url */
public class CommerceQueryFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -405235969)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_url */
    public final class CommerceOrderReceiptModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CommercePaginatedRetailItems, CommerceBaseOrderReceipt {
        @Nullable
        private String f478d;
        @Nullable
        private GraphQLMessengerCommerceBubbleType f479e;
        @Nullable
        private String f480f;
        @Nullable
        private String f481g;
        @Nullable
        private String f482h;
        @Nullable
        private String f483i;
        @Nullable
        private LogoImageModel f484j;
        @Nullable
        private ReceipientModel f485k;
        @Nullable
        private String f486l;
        @Nullable
        private String f487m;
        @Nullable
        private String f488n;
        @Nullable
        private List<RetailAdjustmentsModel> f489o;
        @Nullable
        private RetailItemsModel f490p;
        @Nullable
        private String f491q;
        @Nullable
        private String f492r;
        @Nullable
        private String f493s;
        @Nullable
        private CommerceLocationModel f494t;
        @Nullable
        private String f495u;
        @Nullable
        private String f496v;
        @Nullable
        private String f497w;

        /* compiled from: video_url */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceOrderReceiptModel.class, new Deserializer());
            }

            public Object m425a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommerceOrderReceiptParser.m643a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commerceOrderReceiptModel = new CommerceOrderReceiptModel();
                ((BaseModel) commerceOrderReceiptModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commerceOrderReceiptModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceOrderReceiptModel).a();
                }
                return commerceOrderReceiptModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 415735059)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_url */
        public final class ReceipientModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f473d;
            @Nullable
            private String f474e;
            @Nullable
            private String f475f;

            /* compiled from: video_url */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReceipientModel.class, new Deserializer());
                }

                public Object m426a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReceipientParser.m639a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object receipientModel = new ReceipientModel();
                    ((BaseModel) receipientModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (receipientModel instanceof Postprocessable) {
                        return ((Postprocessable) receipientModel).a();
                    }
                    return receipientModel;
                }
            }

            /* compiled from: video_url */
            public class Serializer extends JsonSerializer<ReceipientModel> {
                public final void m427a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReceipientModel receipientModel = (ReceipientModel) obj;
                    if (receipientModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(receipientModel.m431a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        receipientModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReceipientParser.m640a(receipientModel.w_(), receipientModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ReceipientModel.class, new Serializer());
                }
            }

            public ReceipientModel() {
                super(3);
            }

            public final void m434a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m435a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m428j() {
                this.f473d = super.a(this.f473d, 0);
                return this.f473d;
            }

            @Nullable
            private String m429k() {
                this.f474e = super.a(this.f474e, 1);
                return this.f474e;
            }

            @Nullable
            private String m430l() {
                this.f475f = super.a(this.f475f, 2);
                return this.f475f;
            }

            @Nullable
            public final String m433a() {
                return m428j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m432a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m431a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m428j());
                int b2 = flatBufferBuilder.b(m429k());
                int b3 = flatBufferBuilder.b(m430l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -631875134)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_url */
        public final class RetailAdjustmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f476d;
            @Nullable
            private String f477e;

            /* compiled from: video_url */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RetailAdjustmentsModel.class, new Deserializer());
                }

                public Object m436a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RetailAdjustmentsParser.m642b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object retailAdjustmentsModel = new RetailAdjustmentsModel();
                    ((BaseModel) retailAdjustmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (retailAdjustmentsModel instanceof Postprocessable) {
                        return ((Postprocessable) retailAdjustmentsModel).a();
                    }
                    return retailAdjustmentsModel;
                }
            }

            /* compiled from: video_url */
            public class Serializer extends JsonSerializer<RetailAdjustmentsModel> {
                public final void m437a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RetailAdjustmentsModel retailAdjustmentsModel = (RetailAdjustmentsModel) obj;
                    if (retailAdjustmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(retailAdjustmentsModel.m438a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        retailAdjustmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RetailAdjustmentsParser.m641a(retailAdjustmentsModel.w_(), retailAdjustmentsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RetailAdjustmentsModel.class, new Serializer());
                }
            }

            public RetailAdjustmentsModel() {
                super(2);
            }

            @Nullable
            public final String m440a() {
                this.f476d = super.a(this.f476d, 0);
                return this.f476d;
            }

            @Nullable
            public final String m441b() {
                this.f477e = super.a(this.f477e, 1);
                return this.f477e;
            }

            public final int jK_() {
                return -540687646;
            }

            public final GraphQLVisitableModel m439a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m438a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m440a());
                int b2 = flatBufferBuilder.b(m441b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_url */
        public class Serializer extends JsonSerializer<CommerceOrderReceiptModel> {
            public final void m442a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceOrderReceiptModel commerceOrderReceiptModel = (CommerceOrderReceiptModel) obj;
                if (commerceOrderReceiptModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceOrderReceiptModel.m447a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceOrderReceiptModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceOrderReceiptParser.m644a(commerceOrderReceiptModel.w_(), commerceOrderReceiptModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommerceOrderReceiptModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CommerceLocationModel aE_() {
            return m446y();
        }

        @Nullable
        public final /* synthetic */ LogoImage at_() {
            return m443v();
        }

        @Nullable
        public final /* synthetic */ RetailItemsModel mo59u() {
            return m445x();
        }

        public CommerceOrderReceiptModel() {
            super(20);
        }

        @Nullable
        public final String m452l() {
            this.f478d = super.a(this.f478d, 0);
            return this.f478d;
        }

        @Nullable
        public final GraphQLMessengerCommerceBubbleType mo57b() {
            this.f479e = (GraphQLMessengerCommerceBubbleType) super.b(this.f479e, 1, GraphQLMessengerCommerceBubbleType.class, GraphQLMessengerCommerceBubbleType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f479e;
        }

        @Nullable
        public final String m453m() {
            this.f480f = super.a(this.f480f, 2);
            return this.f480f;
        }

        @Nullable
        public final String mo58c() {
            this.f481g = super.a(this.f481g, 3);
            return this.f481g;
        }

        @Nullable
        public final String aC_() {
            this.f482h = super.a(this.f482h, 4);
            return this.f482h;
        }

        @Nullable
        public final String m454n() {
            this.f483i = super.a(this.f483i, 5);
            return this.f483i;
        }

        @Nullable
        private LogoImageModel m443v() {
            this.f484j = (LogoImageModel) super.a(this.f484j, 6, LogoImageModel.class);
            return this.f484j;
        }

        @Nullable
        private ReceipientModel m444w() {
            this.f485k = (ReceipientModel) super.a(this.f485k, 7, ReceipientModel.class);
            return this.f485k;
        }

        @Nullable
        public final String aD_() {
            this.f486l = super.a(this.f486l, 8);
            return this.f486l;
        }

        @Nullable
        public final String ar_() {
            this.f487m = super.a(this.f487m, 9);
            return this.f487m;
        }

        @Nullable
        public final String m455o() {
            this.f488n = super.a(this.f488n, 10);
            return this.f488n;
        }

        @Nonnull
        public final ImmutableList<RetailAdjustmentsModel> m456p() {
            this.f489o = super.a(this.f489o, 11, RetailAdjustmentsModel.class);
            return (ImmutableList) this.f489o;
        }

        @Nullable
        private RetailItemsModel m445x() {
            this.f490p = (RetailItemsModel) super.a(this.f490p, 12, RetailItemsModel.class);
            return this.f490p;
        }

        @Nullable
        public final String m457q() {
            this.f491q = super.a(this.f491q, 13);
            return this.f491q;
        }

        @Nullable
        public final String m458r() {
            this.f492r = super.a(this.f492r, 14);
            return this.f492r;
        }

        @Nullable
        public final String as_() {
            this.f493s = super.a(this.f493s, 15);
            return this.f493s;
        }

        @Nullable
        private CommerceLocationModel m446y() {
            this.f494t = (CommerceLocationModel) super.a(this.f494t, 16, CommerceLocationModel.class);
            return this.f494t;
        }

        @Nullable
        public final String m459s() {
            this.f495u = super.a(this.f495u, 17);
            return this.f495u;
        }

        @Nullable
        public final String m460t() {
            this.f496v = super.a(this.f496v, 18);
            return this.f496v;
        }

        @Nullable
        public final String aH_() {
            this.f497w = super.a(this.f497w, 19);
            return this.f497w;
        }

        @Nullable
        public final String m449a() {
            return mo58c();
        }

        public final int jK_() {
            return -1649510526;
        }

        public final GraphQLVisitableModel m448a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m443v() != null) {
                LogoImageModel logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(m443v());
                if (m443v() != logoImageModel) {
                    graphQLVisitableModel = (CommerceOrderReceiptModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f484j = logoImageModel;
                }
            }
            if (m444w() != null) {
                ReceipientModel receipientModel = (ReceipientModel) graphQLModelMutatingVisitor.b(m444w());
                if (m444w() != receipientModel) {
                    graphQLVisitableModel = (CommerceOrderReceiptModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f485k = receipientModel;
                }
            }
            if (m456p() != null) {
                Builder a = ModelHelper.a(m456p(), graphQLModelMutatingVisitor);
                if (a != null) {
                    CommerceOrderReceiptModel commerceOrderReceiptModel = (CommerceOrderReceiptModel) ModelHelper.a(graphQLVisitableModel, this);
                    commerceOrderReceiptModel.f489o = a.b();
                    graphQLVisitableModel = commerceOrderReceiptModel;
                }
            }
            if (m445x() != null) {
                RetailItemsModel retailItemsModel = (RetailItemsModel) graphQLModelMutatingVisitor.b(m445x());
                if (m445x() != retailItemsModel) {
                    graphQLVisitableModel = (CommerceOrderReceiptModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f490p = retailItemsModel;
                }
            }
            if (m446y() != null) {
                CommerceLocationModel commerceLocationModel = (CommerceLocationModel) graphQLModelMutatingVisitor.b(m446y());
                if (m446y() != commerceLocationModel) {
                    graphQLVisitableModel = (CommerceOrderReceiptModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f494t = commerceLocationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m447a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m452l());
            int a = flatBufferBuilder.a(mo57b());
            int b2 = flatBufferBuilder.b(m453m());
            int b3 = flatBufferBuilder.b(mo58c());
            int b4 = flatBufferBuilder.b(aC_());
            int b5 = flatBufferBuilder.b(m454n());
            int a2 = ModelHelper.a(flatBufferBuilder, m443v());
            int a3 = ModelHelper.a(flatBufferBuilder, m444w());
            int b6 = flatBufferBuilder.b(aD_());
            int b7 = flatBufferBuilder.b(ar_());
            int b8 = flatBufferBuilder.b(m455o());
            int a4 = ModelHelper.a(flatBufferBuilder, m456p());
            int a5 = ModelHelper.a(flatBufferBuilder, m445x());
            int b9 = flatBufferBuilder.b(m457q());
            int b10 = flatBufferBuilder.b(m458r());
            int b11 = flatBufferBuilder.b(as_());
            int a6 = ModelHelper.a(flatBufferBuilder, m446y());
            int b12 = flatBufferBuilder.b(m459s());
            int b13 = flatBufferBuilder.b(m460t());
            int b14 = flatBufferBuilder.b(aH_());
            flatBufferBuilder.c(20);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, b4);
            flatBufferBuilder.b(5, b5);
            flatBufferBuilder.b(6, a2);
            flatBufferBuilder.b(7, a3);
            flatBufferBuilder.b(8, b6);
            flatBufferBuilder.b(9, b7);
            flatBufferBuilder.b(10, b8);
            flatBufferBuilder.b(11, a4);
            flatBufferBuilder.b(12, a5);
            flatBufferBuilder.b(13, b9);
            flatBufferBuilder.b(14, b10);
            flatBufferBuilder.b(15, b11);
            flatBufferBuilder.b(16, a6);
            flatBufferBuilder.b(17, b12);
            flatBufferBuilder.b(18, b13);
            flatBufferBuilder.b(19, b14);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 277205907)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_url */
    public final class CommercePaginatedRetailItemsModel extends BaseModel implements GraphQLVisitableModel, CommercePaginatedRetailItems {
        @Nullable
        private RetailItemsModel f501d;

        /* compiled from: video_url */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommercePaginatedRetailItemsModel.class, new Deserializer());
            }

            public Object m462a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommercePaginatedRetailItemsParser.m647a(jsonParser);
                Object commercePaginatedRetailItemsModel = new CommercePaginatedRetailItemsModel();
                ((BaseModel) commercePaginatedRetailItemsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commercePaginatedRetailItemsModel instanceof Postprocessable) {
                    return ((Postprocessable) commercePaginatedRetailItemsModel).a();
                }
                return commercePaginatedRetailItemsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -479616362)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_url */
        public final class RetailItemsModel extends BaseModel implements GraphQLVisitableModel {
            private int f498d;
            @Nullable
            private List<CommerceRetailItemModel> f499e;
            @Nullable
            private DefaultPageInfoFieldsModel f500f;

            /* compiled from: video_url */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RetailItemsModel.class, new Deserializer());
                }

                public Object m463a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RetailItemsParser.m645a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object retailItemsModel = new RetailItemsModel();
                    ((BaseModel) retailItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (retailItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) retailItemsModel).a();
                    }
                    return retailItemsModel;
                }
            }

            /* compiled from: video_url */
            public class Serializer extends JsonSerializer<RetailItemsModel> {
                public final void m464a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RetailItemsModel retailItemsModel = (RetailItemsModel) obj;
                    if (retailItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(retailItemsModel.m467a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        retailItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RetailItemsParser.m646a(retailItemsModel.w_(), retailItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RetailItemsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultPageInfoFields m471c() {
                return m465j();
            }

            public RetailItemsModel() {
                super(3);
            }

            public final int m466a() {
                a(0, 0);
                return this.f498d;
            }

            @Nonnull
            public final ImmutableList<CommerceRetailItemModel> m470b() {
                this.f499e = super.a(this.f499e, 1, CommerceRetailItemModel.class);
                return (ImmutableList) this.f499e;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m465j() {
                this.f500f = (DefaultPageInfoFieldsModel) super.a(this.f500f, 2, DefaultPageInfoFieldsModel.class);
                return this.f500f;
            }

            public final int jK_() {
                return -1053041047;
            }

            public final GraphQLVisitableModel m468a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m470b() != null) {
                    Builder a = ModelHelper.a(m470b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        RetailItemsModel retailItemsModel = (RetailItemsModel) ModelHelper.a(null, this);
                        retailItemsModel.f499e = a.b();
                        graphQLVisitableModel = retailItemsModel;
                        if (m465j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m465j());
                            if (m465j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (RetailItemsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f500f = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m465j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m465j());
                    if (m465j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (RetailItemsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f500f = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m467a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m470b());
                int a2 = ModelHelper.a(flatBufferBuilder, m465j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f498d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m469a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f498d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: video_url */
        public class Serializer extends JsonSerializer<CommercePaginatedRetailItemsModel> {
            public final void m472a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommercePaginatedRetailItemsModel commercePaginatedRetailItemsModel = (CommercePaginatedRetailItemsModel) obj;
                if (commercePaginatedRetailItemsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commercePaginatedRetailItemsModel.m474a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commercePaginatedRetailItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commercePaginatedRetailItemsModel.w_();
                int u_ = commercePaginatedRetailItemsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("retail_items");
                    RetailItemsParser.m646a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommercePaginatedRetailItemsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RetailItemsModel mo59u() {
            return m473a();
        }

        public CommercePaginatedRetailItemsModel() {
            super(1);
        }

        @Nullable
        private RetailItemsModel m473a() {
            this.f501d = (RetailItemsModel) super.a(this.f501d, 0, RetailItemsModel.class);
            return this.f501d;
        }

        public final int jK_() {
            return -1649510526;
        }

        public final GraphQLVisitableModel m475a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m473a() != null) {
                RetailItemsModel retailItemsModel = (RetailItemsModel) graphQLModelMutatingVisitor.b(m473a());
                if (m473a() != retailItemsModel) {
                    graphQLVisitableModel = (CommercePaginatedRetailItemsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f501d = retailItemsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m474a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m473a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -735298518)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_url */
    public final class CommerceReceiptListQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f506d;
        @Nullable
        private MessengerCommerceModel f507e;

        /* compiled from: video_url */
        public class Deserializer extends FbJsonDeserializer {
            public Deserializer() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.Deserializer.<init>():void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.class;
                r1 = new com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m477a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r2 = com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceReceiptListQueryParser.m652a(r6);
                r1 = new com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1825723723)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_url */
        public final class MessengerCommerceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private RetailReceiptsModel f505d;

            /* compiled from: video_url */
            public class Deserializer extends FbJsonDeserializer {
                public Deserializer() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.Deserializer.<init>():void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.class;
                    r1 = new com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel$MessengerCommerceModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m478a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceReceiptListQueryParser.MessengerCommerceParser.m650a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel$MessengerCommerceModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 694291154)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: video_url */
            public final class RetailReceiptsModel extends BaseModel implements GraphQLVisitableModel {
                private int f502d;
                @Nullable
                private List<CommerceShortOrderReceiptModel> f503e;
                @Nullable
                private DefaultPageInfoFieldsModel f504f;

                /* compiled from: video_url */
                public class Deserializer extends FbJsonDeserializer {
                    public Deserializer() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.Deserializer.<init>():void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.class;
                        r1 = new com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel$MessengerCommerceModel$RetailReceiptsModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m479a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceReceiptListQueryParser.MessengerCommerceParser.RetailReceiptsParser.m648a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel$MessengerCommerceModel$RetailReceiptsModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: video_url */
                public class Serializer extends JsonSerializer<RetailReceiptsModel> {
                    public Serializer() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.Serializer.<init>():void");
                    }

                    public final void m480a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m481a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceReceiptListQueryParser.MessengerCommerceParser.RetailReceiptsParser.m649a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.class;
                        r1 = new com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel$MessengerCommerceModel$RetailReceiptsModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.Serializer.<clinit>():void");
                    }
                }

                public RetailReceiptsModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 3;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.<init>():void");
                }

                @javax.annotation.Nonnull
                public final com.google.common.collect.ImmutableList<com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceShortOrderReceiptModel> m483a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f503e;
                    r1 = 1;
                    r2 = com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceShortOrderReceiptModel.class;
                    r0 = super.a(r0, r1, r2);
                    r3.f503e = r0;
                    r0 = r3.f503e;
                    r0 = (com.google.common.collect.ImmutableList) r0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.a():com.google.common.collect.ImmutableList<com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceShortOrderReceiptModel>");
                }

                @javax.annotation.Nullable
                public final com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel m485j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f504f;
                    r1 = 2;
                    r2 = com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel) r0;
                    r3.f504f = r0;
                    r0 = r3.f504f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.j():com.facebook.graphql.querybuilder.common.CommonGraphQL2Models$DefaultPageInfoFieldsModel");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = -2077100566; // 0xffffffff8431f5ea float:-2.0919168E-36 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m482a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = 0;
                    r3.h();
                    r1 = r3.m483a();
                    if (r1 == 0) goto L_0x0047;
                L_0x000a:
                    r1 = r3.m483a();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r4);
                    if (r1 == 0) goto L_0x0047;
                L_0x0014:
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                    r0 = (com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel) r0;
                    r1 = r1.b();
                    r0.f503e = r1;
                    r1 = r0;
                L_0x0021:
                    r0 = r3.m485j();
                    if (r0 == 0) goto L_0x003f;
                L_0x0027:
                    r0 = r3.m485j();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel) r0;
                    r2 = r3.m485j();
                    if (r2 == r0) goto L_0x003f;
                L_0x0037:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel) r1;
                    r1.f504f = r0;
                L_0x003f:
                    r3.i();
                    if (r1 != 0) goto L_0x0045;
                L_0x0044:
                    return r3;
                L_0x0045:
                    r3 = r1;
                    goto L_0x0044;
                L_0x0047:
                    r1 = r0;
                    goto L_0x0021;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m481a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r3 = 0;
                    r4.h();
                    r0 = r4.m483a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
                    r1 = r4.m485j();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r1);
                    r2 = 3;
                    r5.c(r2);
                    r2 = r4.f502d;
                    r5.a(r3, r2, r3);
                    r2 = 1;
                    r5.b(r2, r0);
                    r0 = 2;
                    r5.b(r0, r1);
                    r4.i();
                    r0 = r5.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m484a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 0;
                    super.a(r2, r3, r4);
                    r0 = r2.a(r3, r0, r0);
                    r1.f502d = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: video_url */
            public class Serializer extends JsonSerializer<MessengerCommerceModel> {
                public Serializer() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.Serializer.<init>():void");
                }

                public final void m486a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m487a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceReceiptListQueryParser.MessengerCommerceParser.m651a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.class;
                    r1 = new com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel$MessengerCommerceModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.Serializer.<clinit>():void");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel m489a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m490j();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.a():com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel$MessengerCommerceModel$RetailReceiptsModel");
            }

            public MessengerCommerceModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 1;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel m490j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f505d;
                r1 = 0;
                r2 = com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel) r0;
                r3.f505d = r0;
                r0 = r3.f505d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.j():com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel$MessengerCommerceModel$RetailReceiptsModel");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = -1387886866; // 0xffffffffad4686ee float:-1.1284957E-11 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m488a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r1 = 0;
                r3.h();
                r0 = r3.m490j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m490j();
                r0 = r4.b(r0);
                r0 = (com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.RetailReceiptsModel) r0;
                r2 = r3.m490j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel) r1;
                r1.f505d = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m487a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r2.h();
                r0 = r2.m490j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: video_url */
        public class Serializer extends JsonSerializer<CommerceReceiptListQueryModel> {
            public Serializer() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.Serializer.<init>():void");
            }

            public final void m491a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r8 = this;
                r9 = (com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m493a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r9.a(r0, r1);
            L_0x0035:
                r0 = r9.w_();
                r1 = r9.u_();
                r7 = 0;
                r10.f();
                r6 = r0.g(r1, r7);
                if (r6 == 0) goto L_0x004f;
            L_0x0047:
                r6 = "__type__";
                r10.a(r6);
                com.facebook.graphql.modelutil.SerializerHelpers.b(r0, r1, r7, r10);
            L_0x004f:
                r6 = 1;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x005e;
            L_0x0056:
                r7 = "messenger_commerce";
                r10.a(r7);
                com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsParsers.CommerceReceiptListQueryParser.MessengerCommerceParser.m651a(r0, r6, r10, r11);
            L_0x005e:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.class;
                r1 = new com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.Serializer.<clinit>():void");
            }
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel m495a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m498j();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.a():com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel$MessengerCommerceModel");
        }

        public CommerceReceiptListQueryModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 2;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.<init>():void");
        }

        public final void m496a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r2.a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m497a(java.lang.String r1, java.lang.Object r2, boolean r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        private com.facebook.graphql.enums.GraphQLObjectType m492k() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.b;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r4.f506d;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r4.b;
            r1 = r4.c;
            r2 = 0;
            r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
            r0 = r0.d(r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
            r4.f506d = r0;
        L_0x0017:
            r0 = r4.f506d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.k():com.facebook.graphql.enums.GraphQLObjectType");
        }

        @javax.annotation.Nullable
        public final com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel m498j() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f507e;
            r1 = 1;
            r2 = com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel) r0;
            r3.f507e = r0;
            r0 = r3.f507e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.j():com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels$CommerceReceiptListQueryModel$MessengerCommerceModel");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 63093205; // 0x3c2b9d5 float:1.144496E-36 double:3.1172185E-316;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m494a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r1 = 0;
            r3.h();
            r0 = r3.m498j();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m498j();
            r0 = r4.b(r0);
            r0 = (com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.MessengerCommerceModel) r0;
            r2 = r3.m498j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel) r1;
            r1.f507e = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m493a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r3.h();
            r0 = r3.m492k();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
            r1 = r3.m498j();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r1);
            r2 = 2;
            r4.c(r2);
            r2 = 0;
            r4.b(r2, r0);
            r0 = 1;
            r4.b(r0, r1);
            r3.i();
            r0 = r4.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceReceiptListQueryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1582980019)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_url */
    public final class CommerceShipmentDetailsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CommerceShipmentBubble {
        @Nullable
        private GraphQLMessengerCommerceBubbleType f512d;
        @Nullable
        private String f513e;
        @Nullable
        private CommerceLocationModel f514f;
        @Nullable
        private CommerceLocationModel f515g;
        @Nullable
        private String f516h;
        @Nullable
        private String f517i;
        @Nullable
        private String f518j;
        @Nullable
        private String f519k;
        @Nullable
        private ReceiptModel f520l;
        @Nullable
        private RetailCarrierModel f521m;
        @Nullable
        private RetailShipmentItemsModel f522n;
        @Nullable
        private String f523o;
        @Nullable
        private String f524p;
        @Nullable
        private ShipmentTrackingEventsModel f525q;
        @Nullable
        private String f526r;

        /* compiled from: video_url */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceShipmentDetailsModel.class, new Deserializer());
            }

            public Object m499a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommerceShipmentDetailsParser.m655a(jsonParser);
                Object commerceShipmentDetailsModel = new CommerceShipmentDetailsModel();
                ((BaseModel) commerceShipmentDetailsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commerceShipmentDetailsModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceShipmentDetailsModel).a();
                }
                return commerceShipmentDetailsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1802455852)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_url */
        public final class ReceiptModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f508d;
            @Nullable
            private String f509e;
            @Nullable
            private LogoImageModel f510f;
            @Nullable
            private String f511g;

            /* compiled from: video_url */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReceiptModel.class, new Deserializer());
                }

                public Object m500a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReceiptParser.m653a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object receiptModel = new ReceiptModel();
                    ((BaseModel) receiptModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (receiptModel instanceof Postprocessable) {
                        return ((Postprocessable) receiptModel).a();
                    }
                    return receiptModel;
                }
            }

            /* compiled from: video_url */
            public class Serializer extends JsonSerializer<ReceiptModel> {
                public final void m501a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReceiptModel receiptModel = (ReceiptModel) obj;
                    if (receiptModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(receiptModel.m504a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        receiptModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReceiptParser.m654a(receiptModel.w_(), receiptModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReceiptModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ LogoImage m508c() {
                return m503k();
            }

            public ReceiptModel() {
                super(4);
            }

            @Nullable
            private String m502j() {
                this.f508d = super.a(this.f508d, 0);
                return this.f508d;
            }

            @Nullable
            public final String m507b() {
                this.f509e = super.a(this.f509e, 1);
                return this.f509e;
            }

            @Nullable
            private LogoImageModel m503k() {
                this.f510f = (LogoImageModel) super.a(this.f510f, 2, LogoImageModel.class);
                return this.f510f;
            }

            @Nullable
            public final String m509d() {
                this.f511g = super.a(this.f511g, 3);
                return this.f511g;
            }

            @Nullable
            public final String m506a() {
                return m507b();
            }

            public final int jK_() {
                return -1649510526;
            }

            public final GraphQLVisitableModel m505a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m503k() != null) {
                    LogoImageModel logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(m503k());
                    if (m503k() != logoImageModel) {
                        graphQLVisitableModel = (ReceiptModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f510f = logoImageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m504a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m502j());
                int b2 = flatBufferBuilder.b(m507b());
                int a = ModelHelper.a(flatBufferBuilder, m503k());
                int b3 = flatBufferBuilder.b(m509d());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_url */
        public class Serializer extends JsonSerializer<CommerceShipmentDetailsModel> {
            public final void m510a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceShipmentDetailsModel commerceShipmentDetailsModel = (CommerceShipmentDetailsModel) obj;
                if (commerceShipmentDetailsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceShipmentDetailsModel.m523a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceShipmentDetailsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceShipmentDetailsParser.m656a(commerceShipmentDetailsModel.w_(), commerceShipmentDetailsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommerceShipmentDetailsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RetailCarrierModel mo61B() {
            return m514n();
        }

        @Nullable
        public final /* synthetic */ RetailShipmentItemsModel mo62C() {
            return m515o();
        }

        @Nullable
        public final /* synthetic */ ShipmentTrackingEventsModel mo65F() {
            return m529j();
        }

        @Nullable
        public final /* synthetic */ ReceiptModel m528d() {
            return m513m();
        }

        @Nullable
        public final /* synthetic */ CommerceLocationModel mo70w() {
            return m511k();
        }

        @Nullable
        public final /* synthetic */ CommerceLocationModel mo71x() {
            return m512l();
        }

        public CommerceShipmentDetailsModel() {
            super(15);
        }

        @Nullable
        public final GraphQLMessengerCommerceBubbleType mo67b() {
            this.f512d = (GraphQLMessengerCommerceBubbleType) super.b(this.f512d, 0, GraphQLMessengerCommerceBubbleType.class, GraphQLMessengerCommerceBubbleType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f512d;
        }

        @Nullable
        public final String mo69v() {
            this.f513e = super.a(this.f513e, 1);
            return this.f513e;
        }

        @Nullable
        private CommerceLocationModel m511k() {
            this.f514f = (CommerceLocationModel) super.a(this.f514f, 2, CommerceLocationModel.class);
            return this.f514f;
        }

        @Nullable
        private CommerceLocationModel m512l() {
            this.f515g = (CommerceLocationModel) super.a(this.f515g, 3, CommerceLocationModel.class);
            return this.f515g;
        }

        @Nullable
        public final String mo72y() {
            this.f516h = super.a(this.f516h, 4);
            return this.f516h;
        }

        @Nullable
        public final String mo73z() {
            this.f517i = super.a(this.f517i, 5);
            return this.f517i;
        }

        @Nullable
        public final String mo68c() {
            this.f518j = super.a(this.f518j, 6);
            return this.f518j;
        }

        @Nullable
        public final String mo60A() {
            this.f519k = super.a(this.f519k, 7);
            return this.f519k;
        }

        @Nullable
        private ReceiptModel m513m() {
            this.f520l = (ReceiptModel) super.a(this.f520l, 8, ReceiptModel.class);
            return this.f520l;
        }

        @Nullable
        private RetailCarrierModel m514n() {
            this.f521m = (RetailCarrierModel) super.a(this.f521m, 9, RetailCarrierModel.class);
            return this.f521m;
        }

        @Nullable
        private RetailShipmentItemsModel m515o() {
            this.f522n = (RetailShipmentItemsModel) super.a(this.f522n, 10, RetailShipmentItemsModel.class);
            return this.f522n;
        }

        @Nullable
        public final String mo63D() {
            this.f523o = super.a(this.f523o, 11);
            return this.f523o;
        }

        @Nullable
        public final String mo64E() {
            this.f524p = super.a(this.f524p, 12);
            return this.f524p;
        }

        @Nullable
        public final ShipmentTrackingEventsModel m529j() {
            this.f525q = (ShipmentTrackingEventsModel) super.a(this.f525q, 13, ShipmentTrackingEventsModel.class);
            return this.f525q;
        }

        @Nullable
        public final String mo66G() {
            this.f526r = super.a(this.f526r, 14);
            return this.f526r;
        }

        @Nullable
        public final String m525a() {
            return mo68c();
        }

        public final int jK_() {
            return 697177488;
        }

        public final GraphQLVisitableModel m524a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            CommerceLocationModel commerceLocationModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m511k() != null) {
                commerceLocationModel = (CommerceLocationModel) graphQLModelMutatingVisitor.b(m511k());
                if (m511k() != commerceLocationModel) {
                    graphQLVisitableModel = (CommerceShipmentDetailsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f514f = commerceLocationModel;
                }
            }
            if (m512l() != null) {
                commerceLocationModel = (CommerceLocationModel) graphQLModelMutatingVisitor.b(m512l());
                if (m512l() != commerceLocationModel) {
                    graphQLVisitableModel = (CommerceShipmentDetailsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f515g = commerceLocationModel;
                }
            }
            if (m513m() != null) {
                ReceiptModel receiptModel = (ReceiptModel) graphQLModelMutatingVisitor.b(m513m());
                if (m513m() != receiptModel) {
                    graphQLVisitableModel = (CommerceShipmentDetailsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f520l = receiptModel;
                }
            }
            if (m514n() != null) {
                RetailCarrierModel retailCarrierModel = (RetailCarrierModel) graphQLModelMutatingVisitor.b(m514n());
                if (m514n() != retailCarrierModel) {
                    graphQLVisitableModel = (CommerceShipmentDetailsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f521m = retailCarrierModel;
                }
            }
            if (m515o() != null) {
                RetailShipmentItemsModel retailShipmentItemsModel = (RetailShipmentItemsModel) graphQLModelMutatingVisitor.b(m515o());
                if (m515o() != retailShipmentItemsModel) {
                    graphQLVisitableModel = (CommerceShipmentDetailsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f522n = retailShipmentItemsModel;
                }
            }
            if (m529j() != null) {
                ShipmentTrackingEventsModel shipmentTrackingEventsModel = (ShipmentTrackingEventsModel) graphQLModelMutatingVisitor.b(m529j());
                if (m529j() != shipmentTrackingEventsModel) {
                    graphQLVisitableModel = (CommerceShipmentDetailsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f525q = shipmentTrackingEventsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m523a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(mo67b());
            int b = flatBufferBuilder.b(mo69v());
            int a2 = ModelHelper.a(flatBufferBuilder, m511k());
            int a3 = ModelHelper.a(flatBufferBuilder, m512l());
            int b2 = flatBufferBuilder.b(mo72y());
            int b3 = flatBufferBuilder.b(mo73z());
            int b4 = flatBufferBuilder.b(mo68c());
            int b5 = flatBufferBuilder.b(mo60A());
            int a4 = ModelHelper.a(flatBufferBuilder, m513m());
            int a5 = ModelHelper.a(flatBufferBuilder, m514n());
            int a6 = ModelHelper.a(flatBufferBuilder, m515o());
            int b6 = flatBufferBuilder.b(mo63D());
            int b7 = flatBufferBuilder.b(mo64E());
            int a7 = ModelHelper.a(flatBufferBuilder, m529j());
            int b8 = flatBufferBuilder.b(mo66G());
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, b4);
            flatBufferBuilder.b(7, b5);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, a5);
            flatBufferBuilder.b(10, a6);
            flatBufferBuilder.b(11, b6);
            flatBufferBuilder.b(12, b7);
            flatBufferBuilder.b(13, a7);
            flatBufferBuilder.b(14, b8);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1944571044)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_url */
    public final class CommerceShoppingTrendingQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private CommerceItemsModel f534d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 769237363)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_url */
        public final class CommerceItemsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f533d;

            /* compiled from: video_url */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommerceItemsModel.class, new Deserializer());
                }

                public Object m535a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommerceItemsParser.m661a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object commerceItemsModel = new CommerceItemsModel();
                    ((BaseModel) commerceItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (commerceItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) commerceItemsModel).a();
                    }
                    return commerceItemsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1962520709)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: video_url */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f532d;

                /* compiled from: video_url */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m536a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m659b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 762586141)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: video_url */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private String f527d;
                    @Nullable
                    private String f528e;
                    @Nullable
                    private String f529f;
                    @Nullable
                    private String f530g;
                    @Nullable
                    private String f531h;

                    /* compiled from: video_url */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m537a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m657a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: video_url */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m538a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m539a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m658a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(5);
                    }

                    @Nullable
                    public final String m542b() {
                        this.f527d = super.a(this.f527d, 0);
                        return this.f527d;
                    }

                    @Nullable
                    public final String m543c() {
                        this.f528e = super.a(this.f528e, 1);
                        return this.f528e;
                    }

                    @Nullable
                    public final String m544d() {
                        this.f529f = super.a(this.f529f, 2);
                        return this.f529f;
                    }

                    @Nullable
                    public final String ca_() {
                        this.f530g = super.a(this.f530g, 3);
                        return this.f530g;
                    }

                    @Nullable
                    public final String m545g() {
                        this.f531h = super.a(this.f531h, 4);
                        return this.f531h;
                    }

                    @Nullable
                    public final String m541a() {
                        return m543c();
                    }

                    public final int jK_() {
                        return 170624107;
                    }

                    public final GraphQLVisitableModel m540a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m539a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m542b());
                        int b2 = flatBufferBuilder.b(m543c());
                        int b3 = flatBufferBuilder.b(m544d());
                        int b4 = flatBufferBuilder.b(ca_());
                        int b5 = flatBufferBuilder.b(m545g());
                        flatBufferBuilder.c(5);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.b(2, b3);
                        flatBufferBuilder.b(3, b4);
                        flatBufferBuilder.b(4, b5);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: video_url */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m546a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m548a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m660b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ NodeModel m550a() {
                    return m547j();
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m547j() {
                    this.f532d = (NodeModel) super.a(this.f532d, 0, NodeModel.class);
                    return this.f532d;
                }

                public final int jK_() {
                    return 1741581903;
                }

                public final GraphQLVisitableModel m549a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m547j() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m547j());
                        if (m547j() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f532d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m548a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m547j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: video_url */
            public class Serializer extends JsonSerializer<CommerceItemsModel> {
                public final void m551a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommerceItemsModel commerceItemsModel = (CommerceItemsModel) obj;
                    if (commerceItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commerceItemsModel.m552a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commerceItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommerceItemsParser.m662a(commerceItemsModel.w_(), commerceItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CommerceItemsModel.class, new Serializer());
                }
            }

            public CommerceItemsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m554a() {
                this.f533d = super.a(this.f533d, 0, EdgesModel.class);
                return (ImmutableList) this.f533d;
            }

            public final int jK_() {
                return -244233744;
            }

            public final GraphQLVisitableModel m553a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m554a() != null) {
                    Builder a = ModelHelper.a(m554a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CommerceItemsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f533d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m552a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m554a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_url */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceShoppingTrendingQueryModel.class, new Deserializer());
            }

            public Object m555a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommerceShoppingTrendingQueryParser.m663a(jsonParser);
                Object commerceShoppingTrendingQueryModel = new CommerceShoppingTrendingQueryModel();
                ((BaseModel) commerceShoppingTrendingQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commerceShoppingTrendingQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceShoppingTrendingQueryModel).a();
                }
                return commerceShoppingTrendingQueryModel;
            }
        }

        /* compiled from: video_url */
        public class Serializer extends JsonSerializer<CommerceShoppingTrendingQueryModel> {
            public final void m556a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommerceShoppingTrendingQueryModel commerceShoppingTrendingQueryModel = (CommerceShoppingTrendingQueryModel) obj;
                if (commerceShoppingTrendingQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceShoppingTrendingQueryModel.m558a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceShoppingTrendingQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commerceShoppingTrendingQueryModel.w_();
                int u_ = commerceShoppingTrendingQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("commerce_items");
                    CommerceItemsParser.m662a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommerceShoppingTrendingQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CommerceItemsModel m560a() {
            return m557j();
        }

        public CommerceShoppingTrendingQueryModel() {
            super(1);
        }

        public final void m561a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m562a(String str, Object obj, boolean z) {
        }

        @Nullable
        private CommerceItemsModel m557j() {
            this.f534d = (CommerceItemsModel) super.a(this.f534d, 0, CommerceItemsModel.class);
            return this.f534d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m559a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m557j() != null) {
                CommerceItemsModel commerceItemsModel = (CommerceItemsModel) graphQLModelMutatingVisitor.b(m557j());
                if (m557j() != commerceItemsModel) {
                    graphQLVisitableModel = (CommerceShoppingTrendingQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f534d = commerceItemsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m558a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m557j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 284819750)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_url */
    public final class CommerceShortOrderReceiptModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f537d;
        private boolean f538e;
        @Nullable
        private String f539f;
        @Nullable
        private RetailItemsModel f540g;
        @Nullable
        private String f541h;

        /* compiled from: video_url */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceShortOrderReceiptModel.class, new Deserializer());
            }

            public Object m563a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CommerceShortOrderReceiptParser.m666b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object commerceShortOrderReceiptModel = new CommerceShortOrderReceiptModel();
                ((BaseModel) commerceShortOrderReceiptModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (commerceShortOrderReceiptModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceShortOrderReceiptModel).a();
                }
                return commerceShortOrderReceiptModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1050581796)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_url */
        public final class RetailItemsModel extends BaseModel implements GraphQLVisitableModel {
            private int f535d;
            @Nullable
            private List<CommerceRetailItemModel> f536e;

            /* compiled from: video_url */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RetailItemsModel.class, new Deserializer());
                }

                public Object m564a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommerceShortOrderReceiptParser.RetailItemsParser.m664a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object retailItemsModel = new RetailItemsModel();
                    ((BaseModel) retailItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (retailItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) retailItemsModel).a();
                    }
                    return retailItemsModel;
                }
            }

            /* compiled from: video_url */
            public class Serializer extends JsonSerializer<RetailItemsModel> {
                public final void m565a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RetailItemsModel retailItemsModel = (RetailItemsModel) obj;
                    if (retailItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(retailItemsModel.m567a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        retailItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommerceShortOrderReceiptParser.RetailItemsParser.m665a(retailItemsModel.w_(), retailItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RetailItemsModel.class, new Serializer());
                }
            }

            public RetailItemsModel() {
                super(2);
            }

            public final int m566a() {
                a(0, 0);
                return this.f535d;
            }

            @Nonnull
            public final ImmutableList<CommerceRetailItemModel> m570b() {
                this.f536e = super.a(this.f536e, 1, CommerceRetailItemModel.class);
                return (ImmutableList) this.f536e;
            }

            public final int jK_() {
                return -1053041047;
            }

            public final GraphQLVisitableModel m568a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m570b() != null) {
                    Builder a = ModelHelper.a(m570b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (RetailItemsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f536e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m567a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m570b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f535d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m569a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f535d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: video_url */
        public class Serializer extends JsonSerializer<CommerceShortOrderReceiptModel> {
            public final void m571a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CommerceShortOrderReceiptModel commerceShortOrderReceiptModel = (CommerceShortOrderReceiptModel) obj;
                if (commerceShortOrderReceiptModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceShortOrderReceiptModel.m573a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceShortOrderReceiptModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CommerceShortOrderReceiptParser.m667b(commerceShortOrderReceiptModel.w_(), commerceShortOrderReceiptModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CommerceShortOrderReceiptModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RetailItemsModel cb_() {
            return m572j();
        }

        public CommerceShortOrderReceiptModel() {
            super(5);
        }

        @Nullable
        public final String m577b() {
            this.f537d = super.a(this.f537d, 0);
            return this.f537d;
        }

        public final boolean m578c() {
            a(0, 1);
            return this.f538e;
        }

        @Nullable
        public final String m579d() {
            this.f539f = super.a(this.f539f, 2);
            return this.f539f;
        }

        @Nullable
        private RetailItemsModel m572j() {
            this.f540g = (RetailItemsModel) super.a(this.f540g, 3, RetailItemsModel.class);
            return this.f540g;
        }

        @Nullable
        public final String m580g() {
            this.f541h = super.a(this.f541h, 4);
            return this.f541h;
        }

        @Nullable
        public final String m575a() {
            return m577b();
        }

        public final int jK_() {
            return -1649510526;
        }

        public final GraphQLVisitableModel m574a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m572j() != null) {
                RetailItemsModel retailItemsModel = (RetailItemsModel) graphQLModelMutatingVisitor.b(m572j());
                if (m572j() != retailItemsModel) {
                    graphQLVisitableModel = (CommerceShortOrderReceiptModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f540g = retailItemsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m573a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m577b());
            int b2 = flatBufferBuilder.b(m579d());
            int a = ModelHelper.a(flatBufferBuilder, m572j());
            int b3 = flatBufferBuilder.b(m580g());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f538e);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, b3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m576a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f538e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1781813230)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_url */
    public final class MessengerCommerceFetchProductGroupQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f553d;
        @Nullable
        private CommerceMerchantSettingsModel f554e;
        @Nullable
        private GroupModel f555f;
        @Nullable
        private String f556g;
        @Nullable
        private String f557h;
        @Nullable
        private String f558i;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 443603954)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_url */
        public final class CommerceMerchantSettingsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private LogoImageModel f542d;

            /* compiled from: video_url */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CommerceMerchantSettingsModel.class, new Deserializer());
                }

                public Object m581a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CommerceMerchantSettingsParser.m668a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object commerceMerchantSettingsModel = new CommerceMerchantSettingsModel();
                    ((BaseModel) commerceMerchantSettingsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (commerceMerchantSettingsModel instanceof Postprocessable) {
                        return ((Postprocessable) commerceMerchantSettingsModel).a();
                    }
                    return commerceMerchantSettingsModel;
                }
            }

            /* compiled from: video_url */
            public class Serializer extends JsonSerializer<CommerceMerchantSettingsModel> {
                public final void m582a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CommerceMerchantSettingsModel commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) obj;
                    if (commerceMerchantSettingsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(commerceMerchantSettingsModel.m584a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        commerceMerchantSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CommerceMerchantSettingsParser.m669a(commerceMerchantSettingsModel.w_(), commerceMerchantSettingsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CommerceMerchantSettingsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ LogoImage m586a() {
                return m583j();
            }

            public CommerceMerchantSettingsModel() {
                super(1);
            }

            @Nullable
            private LogoImageModel m583j() {
                this.f542d = (LogoImageModel) super.a(this.f542d, 0, LogoImageModel.class);
                return this.f542d;
            }

            public final int jK_() {
                return -1128014042;
            }

            public final GraphQLVisitableModel m585a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m583j() != null) {
                    LogoImageModel logoImageModel = (LogoImageModel) graphQLModelMutatingVisitor.b(m583j());
                    if (m583j() != logoImageModel) {
                        graphQLVisitableModel = (CommerceMerchantSettingsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f542d = logoImageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m584a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m583j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_url */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessengerCommerceFetchProductGroupQueryModel.class, new Deserializer());
            }

            public Object m587a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MessengerCommerceFetchProductGroupQueryParser.m678a(jsonParser);
                Object messengerCommerceFetchProductGroupQueryModel = new MessengerCommerceFetchProductGroupQueryModel();
                ((BaseModel) messengerCommerceFetchProductGroupQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (messengerCommerceFetchProductGroupQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) messengerCommerceFetchProductGroupQueryModel).a();
                }
                return messengerCommerceFetchProductGroupQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1750204866)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_url */
        public final class GroupModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ProductItemsEdgeModel f551d;
            @Nullable
            private List<String> f552e;

            /* compiled from: video_url */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m588a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupParser.m676a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupModel = new GroupModel();
                    ((BaseModel) groupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupModel instanceof Postprocessable) {
                        return ((Postprocessable) groupModel).a();
                    }
                    return groupModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1759862278)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: video_url */
            public final class ProductItemsEdgeModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f550d;

                /* compiled from: video_url */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProductItemsEdgeModel.class, new Deserializer());
                    }

                    public Object m589a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProductItemsEdgeParser.m674a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object productItemsEdgeModel = new ProductItemsEdgeModel();
                        ((BaseModel) productItemsEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (productItemsEdgeModel instanceof Postprocessable) {
                            return ((Postprocessable) productItemsEdgeModel).a();
                        }
                        return productItemsEdgeModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1111320251)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: video_url */
                public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    private int f544d;
                    @Nullable
                    private MessengerCommerceProductPriceFieldsModel f545e;
                    @Nullable
                    private String f546f;
                    @Nullable
                    private ImageModel f547g;
                    @Nullable
                    private MessengerCommerceProductPriceFieldsModel f548h;
                    @Nullable
                    private List<String> f549i;

                    /* compiled from: video_url */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m590a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodesParser.m672b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodesModel = new NodesModel();
                            ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodesModel instanceof Postprocessable) {
                                return ((Postprocessable) nodesModel).a();
                            }
                            return nodesModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 842551240)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: video_url */
                    public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f543d;

                        /* compiled from: video_url */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                            }

                            public Object m591a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ImageParser.m670a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: video_url */
                        public class Serializer extends JsonSerializer<ImageModel> {
                            public final void m592a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ImageModel imageModel = (ImageModel) obj;
                                if (imageModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(imageModel.m593a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ImageParser.m671a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ImageModel.class, new Serializer());
                            }
                        }

                        public ImageModel() {
                            super(1);
                        }

                        @Nullable
                        public final String m595a() {
                            this.f543d = super.a(this.f543d, 0);
                            return this.f543d;
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m594a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m593a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m595a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: video_url */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m596a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m600a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodesParser.m673b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ MessengerCommerceProductPriceFieldsModel m605c() {
                        return m597j();
                    }

                    @Nullable
                    public final /* synthetic */ ImageModel cd_() {
                        return m598k();
                    }

                    @Nullable
                    public final /* synthetic */ MessengerCommerceProductPriceFieldsModel m607g() {
                        return m599l();
                    }

                    public NodesModel() {
                        super(6);
                    }

                    public final int m604b() {
                        a(0, 0);
                        return this.f544d;
                    }

                    @Nullable
                    private MessengerCommerceProductPriceFieldsModel m597j() {
                        this.f545e = (MessengerCommerceProductPriceFieldsModel) super.a(this.f545e, 1, MessengerCommerceProductPriceFieldsModel.class);
                        return this.f545e;
                    }

                    @Nullable
                    public final String m606d() {
                        this.f546f = super.a(this.f546f, 2);
                        return this.f546f;
                    }

                    @Nullable
                    private ImageModel m598k() {
                        this.f547g = (ImageModel) super.a(this.f547g, 3, ImageModel.class);
                        return this.f547g;
                    }

                    @Nullable
                    private MessengerCommerceProductPriceFieldsModel m599l() {
                        this.f548h = (MessengerCommerceProductPriceFieldsModel) super.a(this.f548h, 4, MessengerCommerceProductPriceFieldsModel.class);
                        return this.f548h;
                    }

                    @Nonnull
                    public final ImmutableList<String> cc_() {
                        this.f549i = super.a(this.f549i, 5);
                        return (ImmutableList) this.f549i;
                    }

                    @Nullable
                    public final String m602a() {
                        return m606d();
                    }

                    public final int jK_() {
                        return 175920258;
                    }

                    public final GraphQLVisitableModel m601a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        MessengerCommerceProductPriceFieldsModel messengerCommerceProductPriceFieldsModel;
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m597j() != null) {
                            messengerCommerceProductPriceFieldsModel = (MessengerCommerceProductPriceFieldsModel) graphQLModelMutatingVisitor.b(m597j());
                            if (m597j() != messengerCommerceProductPriceFieldsModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f545e = messengerCommerceProductPriceFieldsModel;
                            }
                        }
                        if (m598k() != null) {
                            ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m598k());
                            if (m598k() != imageModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f547g = imageModel;
                            }
                        }
                        if (m599l() != null) {
                            messengerCommerceProductPriceFieldsModel = (MessengerCommerceProductPriceFieldsModel) graphQLModelMutatingVisitor.b(m599l());
                            if (m599l() != messengerCommerceProductPriceFieldsModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f548h = messengerCommerceProductPriceFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m600a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m597j());
                        int b = flatBufferBuilder.b(m606d());
                        int a2 = ModelHelper.a(flatBufferBuilder, m598k());
                        int a3 = ModelHelper.a(flatBufferBuilder, m599l());
                        int c = flatBufferBuilder.c(cc_());
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.a(0, this.f544d, 0);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.b(2, b);
                        flatBufferBuilder.b(3, a2);
                        flatBufferBuilder.b(4, a3);
                        flatBufferBuilder.b(5, c);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m603a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f544d = mutableFlatBuffer.a(i, 0, 0);
                    }
                }

                /* compiled from: video_url */
                public class Serializer extends JsonSerializer<ProductItemsEdgeModel> {
                    public final void m608a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProductItemsEdgeModel productItemsEdgeModel = (ProductItemsEdgeModel) obj;
                        if (productItemsEdgeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(productItemsEdgeModel.m609a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            productItemsEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProductItemsEdgeParser.m675a(productItemsEdgeModel.w_(), productItemsEdgeModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ProductItemsEdgeModel.class, new Serializer());
                    }
                }

                public ProductItemsEdgeModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<NodesModel> m611a() {
                    this.f550d = super.a(this.f550d, 0, NodesModel.class);
                    return (ImmutableList) this.f550d;
                }

                public final int jK_() {
                    return 768593391;
                }

                public final GraphQLVisitableModel m610a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m611a() != null) {
                        Builder a = ModelHelper.a(m611a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (ProductItemsEdgeModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f550d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m609a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m611a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: video_url */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m612a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m614a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupParser.m677a(groupModel.w_(), groupModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ProductItemsEdgeModel m616a() {
                return m613j();
            }

            public GroupModel() {
                super(2);
            }

            @Nullable
            private ProductItemsEdgeModel m613j() {
                this.f551d = (ProductItemsEdgeModel) super.a(this.f551d, 0, ProductItemsEdgeModel.class);
                return this.f551d;
            }

            @Nonnull
            public final ImmutableList<String> m617b() {
                this.f552e = super.a(this.f552e, 1);
                return (ImmutableList) this.f552e;
            }

            public final int jK_() {
                return 1156664048;
            }

            public final GraphQLVisitableModel m615a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m613j() != null) {
                    ProductItemsEdgeModel productItemsEdgeModel = (ProductItemsEdgeModel) graphQLModelMutatingVisitor.b(m613j());
                    if (m613j() != productItemsEdgeModel) {
                        graphQLVisitableModel = (GroupModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f551d = productItemsEdgeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m614a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m613j());
                int c = flatBufferBuilder.c(m617b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, c);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_url */
        public class Serializer extends JsonSerializer<MessengerCommerceFetchProductGroupQueryModel> {
            public final void m618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessengerCommerceFetchProductGroupQueryModel messengerCommerceFetchProductGroupQueryModel = (MessengerCommerceFetchProductGroupQueryModel) obj;
                if (messengerCommerceFetchProductGroupQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messengerCommerceFetchProductGroupQueryModel.m624a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messengerCommerceFetchProductGroupQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messengerCommerceFetchProductGroupQueryModel.w_();
                int u_ = messengerCommerceFetchProductGroupQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("commerce_merchant_settings");
                    CommerceMerchantSettingsParser.m669a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupParser.m677a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                if (mutableFlatBuffer.g(u_, 5) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 5));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessengerCommerceFetchProductGroupQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CommerceMerchantSettingsModel m629b() {
            return m620k();
        }

        @Nullable
        public final /* synthetic */ GroupModel m630c() {
            return m621l();
        }

        public MessengerCommerceFetchProductGroupQueryModel() {
            super(6);
        }

        public final void m627a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m628a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m619j() {
            if (this.b != null && this.f553d == null) {
                this.f553d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f553d;
        }

        @Nullable
        private CommerceMerchantSettingsModel m620k() {
            this.f554e = (CommerceMerchantSettingsModel) super.a(this.f554e, 1, CommerceMerchantSettingsModel.class);
            return this.f554e;
        }

        @Nullable
        private GroupModel m621l() {
            this.f555f = (GroupModel) super.a(this.f555f, 2, GroupModel.class);
            return this.f555f;
        }

        @Nullable
        private String m622m() {
            this.f556g = super.a(this.f556g, 3);
            return this.f556g;
        }

        @Nullable
        public final String m631d() {
            this.f557h = super.a(this.f557h, 4);
            return this.f557h;
        }

        @Nullable
        private String m623n() {
            this.f558i = super.a(this.f558i, 5);
            return this.f558i;
        }

        @Nullable
        public final String m626a() {
            return m622m();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m625a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m620k() != null) {
                CommerceMerchantSettingsModel commerceMerchantSettingsModel = (CommerceMerchantSettingsModel) graphQLModelMutatingVisitor.b(m620k());
                if (m620k() != commerceMerchantSettingsModel) {
                    graphQLVisitableModel = (MessengerCommerceFetchProductGroupQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f554e = commerceMerchantSettingsModel;
                }
            }
            if (m621l() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m621l());
                if (m621l() != groupModel) {
                    graphQLVisitableModel = (MessengerCommerceFetchProductGroupQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f555f = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m624a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m619j());
            int a2 = ModelHelper.a(flatBufferBuilder, m620k());
            int a3 = ModelHelper.a(flatBufferBuilder, m621l());
            int b = flatBufferBuilder.b(m622m());
            int b2 = flatBufferBuilder.b(m631d());
            int b3 = flatBufferBuilder.b(m623n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1404649757)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_url */
    public final class MessengerCommerceProductPriceFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f559d;
        private int f560e;
        @Nullable
        private String f561f;

        /* compiled from: video_url */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessengerCommerceProductPriceFieldsModel.class, new Deserializer());
            }

            public Object m632a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MessengerCommerceProductPriceFieldsParser.m679a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object messengerCommerceProductPriceFieldsModel = new MessengerCommerceProductPriceFieldsModel();
                ((BaseModel) messengerCommerceProductPriceFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (messengerCommerceProductPriceFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) messengerCommerceProductPriceFieldsModel).a();
                }
                return messengerCommerceProductPriceFieldsModel;
            }
        }

        /* compiled from: video_url */
        public class Serializer extends JsonSerializer<MessengerCommerceProductPriceFieldsModel> {
            public final void m633a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MessengerCommerceProductPriceFieldsModel messengerCommerceProductPriceFieldsModel = (MessengerCommerceProductPriceFieldsModel) obj;
                if (messengerCommerceProductPriceFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messengerCommerceProductPriceFieldsModel.m634a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messengerCommerceProductPriceFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MessengerCommerceProductPriceFieldsParser.m680a(messengerCommerceProductPriceFieldsModel.w_(), messengerCommerceProductPriceFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(MessengerCommerceProductPriceFieldsModel.class, new Serializer());
            }
        }

        public MessengerCommerceProductPriceFieldsModel() {
            super(3);
        }

        @Nullable
        public final String m636a() {
            this.f559d = super.a(this.f559d, 0);
            return this.f559d;
        }

        @Nullable
        public final String m638b() {
            this.f561f = super.a(this.f561f, 2);
            return this.f561f;
        }

        public final int jK_() {
            return 753818588;
        }

        public final GraphQLVisitableModel m635a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m634a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m636a());
            int b2 = flatBufferBuilder.b(m638b());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f560e, 0);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m637a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f560e = mutableFlatBuffer.a(i, 1, 0);
        }
    }
}
