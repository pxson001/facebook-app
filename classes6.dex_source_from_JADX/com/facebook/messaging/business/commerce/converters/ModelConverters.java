package com.facebook.messaging.business.commerce.converters;

import com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.attachments.converters.PlatformAttachmentsConverter;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.facebook.messaging.business.attachments.model.LogoImageBuilder;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItemBuilder;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsInterfaces.CommerceReceiptListQuery;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsInterfaces.CommerceShoppingTrendingQuery;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceShoppingTrendingQueryModel.CommerceItemsModel.EdgesModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceShortOrderReceiptModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceShortOrderReceiptModel.RetailItemsModel;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType;
import com.facebook.messaging.business.commerce.model.retail.Receipt;
import com.facebook.messaging.business.commerce.model.retail.ReceiptBuilder;
import com.facebook.messaging.business.commerce.model.retail.RetailAddress;
import com.facebook.messaging.business.commerce.model.retail.RetailAddressBuilder;
import com.facebook.messaging.business.commerce.model.retail.RetailCarrierBuilder;
import com.facebook.messaging.business.commerce.model.retail.Shipment;
import com.facebook.messaging.business.commerce.model.retail.ShipmentBuilder;
import com.facebook.messaging.business.commerce.model.retail.ShipmentTrackingEventBuilder;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceBaseOrderReceipt;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceBaseShipmentTracking;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceRetailItem;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceShipmentBubble;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailCarrierModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: viewTypeOffset */
public class ModelConverters {
    public static ModelConverters m395a(InjectorLike injectorLike) {
        return new ModelConverters();
    }

    @Nullable
    public static ImmutableList<Receipt> m400a(@Nullable CommerceReceiptListQuery commerceReceiptListQuery) {
        if (commerceReceiptListQuery == null) {
            return null;
        }
        Builder builder = ImmutableList.builder();
        if (!(commerceReceiptListQuery.m495a() == null || commerceReceiptListQuery.m495a().m489a() == null)) {
            ImmutableList a = commerceReceiptListQuery.m495a().m489a().m483a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                CommerceShortOrderReceiptModel commerceShortOrderReceiptModel = (CommerceShortOrderReceiptModel) a.get(i);
                RetailItemsModel cb_ = commerceShortOrderReceiptModel.cb_();
                if (!(cb_ == null || cb_.m570b().isEmpty())) {
                    Builder builder2 = ImmutableList.builder();
                    ImmutableList b = cb_.m570b();
                    int size2 = b.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        PlatformGenericAttachmentItem a2 = PlatformAttachmentsConverter.m388a((CommerceRetailItem) b.get(i2));
                        if (a2 != null) {
                            builder2.c(a2);
                        }
                    }
                    ReceiptBuilder receiptBuilder = new ReceiptBuilder();
                    receiptBuilder.f595a = commerceShortOrderReceiptModel.m577b();
                    ReceiptBuilder receiptBuilder2 = receiptBuilder;
                    receiptBuilder2.f602h = commerceShortOrderReceiptModel.m580g();
                    receiptBuilder2 = receiptBuilder2;
                    receiptBuilder2.f608n = commerceShortOrderReceiptModel.m579d();
                    receiptBuilder2 = receiptBuilder2;
                    receiptBuilder2.f609o = cb_.m566a();
                    receiptBuilder2 = receiptBuilder2;
                    receiptBuilder2.f614t = commerceShortOrderReceiptModel.m578c();
                    receiptBuilder2.f611q = builder2.b();
                    builder.c(receiptBuilder.m694u());
                }
            }
        }
        return builder.b();
    }

    @Nullable
    public static RetailAddress m397a(@Nullable CommerceLocationModel commerceLocationModel) {
        if (commerceLocationModel == null) {
            return null;
        }
        RetailAddressBuilder retailAddressBuilder = new RetailAddressBuilder();
        if (!(commerceLocationModel.av_() == null || commerceLocationModel.av_().isEmpty())) {
            retailAddressBuilder.f632a = (String) commerceLocationModel.av_().get(0);
        }
        if (commerceLocationModel.av_() != null && commerceLocationModel.av_().size() > 1) {
            retailAddressBuilder.f633b = (String) commerceLocationModel.av_().get(1);
        }
        retailAddressBuilder.f634c = commerceLocationModel.m1037a();
        retailAddressBuilder.f635d = commerceLocationModel.m1042g();
        retailAddressBuilder.f637f = commerceLocationModel.m1039b();
        retailAddressBuilder.f636e = commerceLocationModel.au_();
        retailAddressBuilder.f638g = commerceLocationModel.aw_();
        retailAddressBuilder.f639h = commerceLocationModel.m1040c();
        retailAddressBuilder.f640i = commerceLocationModel.m1041d();
        return retailAddressBuilder.m699j();
    }

    @Nullable
    public static LogoImage m394a(@Nullable CommerceThreadFragmentsInterfaces.LogoImage logoImage) {
        if (logoImage == null) {
            return null;
        }
        LogoImageBuilder a = new LogoImageBuilder().m389a(logoImage.mo111b());
        a.f435b = logoImage.mo112c();
        a = a;
        a.f436c = logoImage.mo110a();
        return a.m390d();
    }

    @Nullable
    public static ReceiptBuilder m396a(@Nullable CommerceBaseOrderReceipt commerceBaseOrderReceipt) {
        if (commerceBaseOrderReceipt == null) {
            return null;
        }
        ReceiptBuilder receiptBuilder = new ReceiptBuilder();
        receiptBuilder.f595a = commerceBaseOrderReceipt.mo58c();
        receiptBuilder.f596b = commerceBaseOrderReceipt.aD_();
        receiptBuilder.m692e(commerceBaseOrderReceipt.ar_());
        receiptBuilder.f602h = commerceBaseOrderReceipt.as_();
        receiptBuilder.f603i = commerceBaseOrderReceipt.aH_();
        receiptBuilder.f610p = m394a(commerceBaseOrderReceipt.at_());
        return receiptBuilder;
    }

    @Nullable
    public static ShipmentTrackingEventBuilder m399a(@Nullable CommerceBaseShipmentTracking commerceBaseShipmentTracking) {
        if (commerceBaseShipmentTracking == null) {
            return null;
        }
        CommerceBubbleModelType commerceBubbleModelType;
        ShipmentTrackingEventBuilder shipmentTrackingEventBuilder = new ShipmentTrackingEventBuilder();
        shipmentTrackingEventBuilder.f695b = commerceBaseShipmentTracking.mo78c();
        shipmentTrackingEventBuilder.f696c = commerceBaseShipmentTracking.mo81n();
        GraphQLMessengerCommerceBubbleType b = commerceBaseShipmentTracking.mo77b();
        if (b == GraphQLMessengerCommerceBubbleType.FB_RETAIL_RECEIPT) {
            commerceBubbleModelType = CommerceBubbleModelType.RECEIPT;
        } else if (b == GraphQLMessengerCommerceBubbleType.FB_RETAIL_CANCELLATION) {
            commerceBubbleModelType = CommerceBubbleModelType.CANCELLATION;
        } else if (b == GraphQLMessengerCommerceBubbleType.FB_RETAIL_SHIPMENT_FOR_UNSUPPORTED_CARRIER) {
            commerceBubbleModelType = CommerceBubbleModelType.SHIPMENT_FOR_UNSUPPORTED_CARRIER;
        } else if (b == GraphQLMessengerCommerceBubbleType.FB_RETAIL_SHIPMENT) {
            commerceBubbleModelType = CommerceBubbleModelType.SHIPMENT;
        } else if (b == GraphQLMessengerCommerceBubbleType.FB_RETAIL_SHIPMENT_ETA) {
            commerceBubbleModelType = CommerceBubbleModelType.SHIPMENT_ETA;
        } else if (b == GraphQLMessengerCommerceBubbleType.FB_RETAIL_SHIPMENT_TRACKING_EVENT_ETA) {
            commerceBubbleModelType = CommerceBubbleModelType.SHIPMENT_TRACKING_ETA;
        } else if (b == GraphQLMessengerCommerceBubbleType.FB_RETAIL_SHIPMENT_TRACKING_EVENT_IN_TRANSIT) {
            commerceBubbleModelType = CommerceBubbleModelType.SHIPMENT_TRACKING_IN_TRANSIT;
        } else if (b == GraphQLMessengerCommerceBubbleType.FB_RETAIL_SHIPMENT_TRACKING_EVENT_OUT_FOR_DELIVERY) {
            commerceBubbleModelType = CommerceBubbleModelType.SHIPMENT_TRACKING_OUT_FOR_DELIVERY;
        } else if (b == GraphQLMessengerCommerceBubbleType.FB_RETAIL_SHIPMENT_TRACKING_EVENT_DELIVERED) {
            commerceBubbleModelType = CommerceBubbleModelType.SHIPMENT_TRACKING_DELIVERED;
        } else if (b == GraphQLMessengerCommerceBubbleType.FB_RETAIL_SHIPMENT_TRACKING_EVENT_DELAYED) {
            commerceBubbleModelType = CommerceBubbleModelType.SHIPMENT_TRACKING_DELAYED;
        } else if (b == GraphQLMessengerCommerceBubbleType.FB_RETAIL_NOW_IN_STOCK) {
            commerceBubbleModelType = CommerceBubbleModelType.PRODUCT_SUBSCRIPTION;
        } else if (b == GraphQLMessengerCommerceBubbleType.FB_RETAIL_AGENT_ITEM_SUGGESTION) {
            commerceBubbleModelType = CommerceBubbleModelType.AGENT_ITEM_SUGGESTION;
        } else {
            commerceBubbleModelType = CommerceBubbleModelType.UNKNOWN;
        }
        shipmentTrackingEventBuilder.f694a = commerceBubbleModelType;
        shipmentTrackingEventBuilder.f698e = commerceBaseShipmentTracking.mo82o();
        shipmentTrackingEventBuilder.f699f = m397a(commerceBaseShipmentTracking.mo79l());
        return shipmentTrackingEventBuilder;
    }

    @Nullable
    public static Shipment m398a(CommerceShipmentBubble commerceShipmentBubble) {
        int i = 0;
        Preconditions.checkNotNull(commerceShipmentBubble);
        ShipmentBuilder shipmentBuilder = new ShipmentBuilder();
        shipmentBuilder.f670a = commerceShipmentBubble.mo68c();
        shipmentBuilder.f671b = commerceShipmentBubble.mo60A();
        shipmentBuilder.f672c = commerceShipmentBubble.mo66G();
        RetailCarrierModel B = commerceShipmentBubble.mo61B();
        Preconditions.checkNotNull(B);
        RetailCarrierBuilder retailCarrierBuilder = new RetailCarrierBuilder();
        retailCarrierBuilder.f649a = B.m1165d();
        retailCarrierBuilder.f650b = m394a(B.m1164c());
        if (B.m1163b() != null) {
            retailCarrierBuilder.f652d = B.m1163b().m1154a();
        }
        shipmentBuilder.f673d = retailCarrierBuilder.m701e();
        shipmentBuilder.m705d(commerceShipmentBubble.mo69v());
        shipmentBuilder.f676g = commerceShipmentBubble.mo64E();
        shipmentBuilder.f677h = m397a(commerceShipmentBubble.mo71x());
        shipmentBuilder.f678i = m397a(commerceShipmentBubble.mo70w());
        shipmentBuilder.f680k = commerceShipmentBubble.mo73z();
        shipmentBuilder.f682m = commerceShipmentBubble.mo72y();
        shipmentBuilder.f683n = commerceShipmentBubble.mo63D();
        if (commerceShipmentBubble.mo61B() != null) {
            shipmentBuilder.f684o = m394a(commerceShipmentBubble.mo61B().m1164c());
        }
        if (commerceShipmentBubble.mo62C() != null) {
            List arrayList = new ArrayList();
            if (!(commerceShipmentBubble.mo62C() == null || commerceShipmentBubble.mo62C().m1173b() == null)) {
                ImmutableList b = commerceShipmentBubble.mo62C().m1173b();
                int size = b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(PlatformAttachmentsConverter.m388a((CommerceRetailItem) b.get(i2)));
                }
            }
            shipmentBuilder.f685p = arrayList;
        }
        if (!(commerceShipmentBubble.mo65F() == null || commerceShipmentBubble.mo65F().m1180a() == null)) {
            List arrayList2 = new ArrayList();
            ImmutableList a = commerceShipmentBubble.mo65F().m1180a();
            int size2 = a.size();
            while (i < size2) {
                ShipmentTrackingEventBuilder a2 = m399a((CommerceBaseShipmentTracking) a.get(i));
                if (a2 != null) {
                    arrayList2.add(a2.m710h());
                }
                i++;
            }
            shipmentBuilder.f686q = arrayList2;
        }
        return shipmentBuilder.m706r();
    }

    public static ImmutableList<PlatformGenericAttachmentItem> m401a(@Nullable CommerceShoppingTrendingQuery commerceShoppingTrendingQuery) {
        Builder builder = ImmutableList.builder();
        if (!(commerceShoppingTrendingQuery == null || commerceShoppingTrendingQuery.m560a() == null || commerceShoppingTrendingQuery.m560a().m554a() == null)) {
            ImmutableList a = commerceShoppingTrendingQuery.m560a().m554a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                if (edgesModel.m550a() != null) {
                    PlatformGenericAttachmentItemBuilder platformGenericAttachmentItemBuilder = new PlatformGenericAttachmentItemBuilder();
                    platformGenericAttachmentItemBuilder.f460a = edgesModel.m550a().m543c();
                    platformGenericAttachmentItemBuilder.f461b = edgesModel.m550a().ca_();
                    platformGenericAttachmentItemBuilder.m391d(edgesModel.m550a().m544d());
                    platformGenericAttachmentItemBuilder.f462c = edgesModel.m550a().m542b();
                    platformGenericAttachmentItemBuilder.m392j(edgesModel.m550a().m545g());
                    builder.c(platformGenericAttachmentItemBuilder.m393n());
                }
            }
        }
        return builder.b();
    }
}
