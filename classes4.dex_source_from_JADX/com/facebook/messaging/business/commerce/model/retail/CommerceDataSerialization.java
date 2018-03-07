package com.facebook.messaging.business.commerce.model.retail;

import com.facebook.common.util.JSONUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.facebook.messaging.business.attachments.model.LogoImageBuilder;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItemBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: long_press */
public class CommerceDataSerialization {
    public static CommerceDataSerialization m9161a(InjectorLike injectorLike) {
        return new CommerceDataSerialization();
    }

    public final boolean m9173a(@Nullable JsonNode jsonNode) {
        JsonNode c = m9167c(jsonNode);
        return (c == null || m9168d(c) == CommerceBubbleModelType.UNKNOWN) ? false : true;
    }

    public static ObjectNode m9163a(@Nullable CommerceData commerceData) {
        if (commerceData == null || commerceData.a == null) {
            return null;
        }
        ObjectNode objectNode;
        CommerceBubbleModel commerceBubbleModel = commerceData.a;
        CommerceBubbleModelType b = commerceData.a.b();
        ObjectNode objectNode2;
        if (b == CommerceBubbleModelType.RECEIPT) {
            Receipt receipt = (Receipt) commerceBubbleModel;
            objectNode2 = new ObjectNode(JsonNodeFactory.a);
            objectNode2.a("receipt_id", receipt.a);
            objectNode2.a("order_id", receipt.b);
            objectNode2.a("shipping_method", receipt.c);
            objectNode2.a("payment_method", receipt.d);
            objectNode2.a("order_url", receipt.e != null ? receipt.e.toString() : "");
            objectNode2.a("cancellation_url", receipt.f != null ? receipt.f.toString() : "");
            objectNode2.c("structured_address", m9164a(receipt.g));
            objectNode2.a("status", receipt.h);
            objectNode2.a("total_cost", receipt.i);
            objectNode2.a("total_tax", receipt.j);
            objectNode2.a("shipping_cost", receipt.l);
            objectNode2.a("subtotal", receipt.m);
            objectNode2.a("order_time", receipt.o);
            objectNode2.c("partner_logo", m9162a(receipt.n));
            objectNode2.c("items", m9166a(receipt.t));
            objectNode2.a("recipient_name", receipt.p);
            objectNode2.a("account_holder_name", receipt.q);
            objectNode = objectNode2;
        } else if (b == CommerceBubbleModelType.CANCELLATION) {
            String str;
            ReceiptCancellation receiptCancellation = (ReceiptCancellation) commerceBubbleModel;
            LogoImage logoImage = null;
            ObjectNode objectNode3 = new ObjectNode(JsonNodeFactory.a);
            objectNode3.a("cancellation_id", receiptCancellation.a);
            objectNode3.a("receipt_id", receiptCancellation.b != null ? receiptCancellation.b.a : null);
            String str2 = "order_id";
            if (receiptCancellation.b != null) {
                str = receiptCancellation.b.b;
            } else {
                str = null;
            }
            objectNode3.a(str2, str);
            str = "partner_logo";
            if (receiptCancellation.b != null) {
                logoImage = receiptCancellation.b.n;
            }
            objectNode3.c(str, m9162a(logoImage));
            objectNode3.c("items", m9166a(receiptCancellation.d));
            objectNode = objectNode3;
        } else if (b == CommerceBubbleModelType.SHIPMENT || b == CommerceBubbleModelType.SHIPMENT_FOR_UNSUPPORTED_CARRIER) {
            objectNode = m9165a((Shipment) commerceBubbleModel);
        } else if (b != CommerceBubbleModelType.SHIPMENT_TRACKING_ETA && b != CommerceBubbleModelType.SHIPMENT_TRACKING_IN_TRANSIT && b != CommerceBubbleModelType.SHIPMENT_TRACKING_OUT_FOR_DELIVERY && b != CommerceBubbleModelType.SHIPMENT_TRACKING_DELAYED && b != CommerceBubbleModelType.SHIPMENT_TRACKING_DELIVERED && b != CommerceBubbleModelType.SHIPMENT_ETA) {
            return null;
        } else {
            ShipmentTrackingEvent shipmentTrackingEvent = (ShipmentTrackingEvent) commerceBubbleModel;
            objectNode2 = new ObjectNode(JsonNodeFactory.a);
            objectNode2.a("id", shipmentTrackingEvent.a);
            objectNode2.a("tracking_number", shipmentTrackingEvent.f.c);
            objectNode2.a("timestamp", Long.toString(shipmentTrackingEvent.c / 1000));
            objectNode2.a("display_time", shipmentTrackingEvent.d);
            objectNode2.c("tracking_event_location", m9164a(shipmentTrackingEvent.e));
            if (shipmentTrackingEvent.f != null) {
                objectNode2.a("shipment_id", shipmentTrackingEvent.f.a);
                objectNode2.a("carrier", shipmentTrackingEvent.f.d.a);
                objectNode2.a("carrier_tracking_url", shipmentTrackingEvent.f.d.c != null ? shipmentTrackingEvent.f.d.c.toString() : "");
                objectNode2.c("carrier_logo", m9162a(shipmentTrackingEvent.f.d.b));
                objectNode2.a("service_type", shipmentTrackingEvent.f.n);
                objectNode2.c("items", m9166a(shipmentTrackingEvent.f.p));
            }
            objectNode = objectNode2;
        }
        objectNode.a("messenger_commerce_bubble_type", b.getValue());
        ObjectNode objectNode4 = new ObjectNode(JsonNodeFactory.a);
        objectNode4.c("fb_object_contents", objectNode);
        return objectNode4;
    }

    @Nullable
    public final CommerceData m9174b(@Nullable JsonNode jsonNode) {
        JsonNode c = m9167c(jsonNode);
        if (c == null) {
            return null;
        }
        CommerceBubbleModelType d = m9168d(c);
        if (d == CommerceBubbleModelType.RECEIPT) {
            ReceiptBuilder receiptBuilder = new ReceiptBuilder();
            receiptBuilder.a = JSONUtil.b(c.b("receipt_id"));
            receiptBuilder.b = JSONUtil.b(c.b("order_id"));
            receiptBuilder.c = JSONUtil.b(c.b("shipping_method"));
            receiptBuilder.d = JSONUtil.b(c.b("payment_method"));
            receiptBuilder.e(JSONUtil.b(c.b("order_url")));
            receiptBuilder.f(JSONUtil.b(c.b("cancellation_url")));
            receiptBuilder.g = m9170h(c.b("structured_address"));
            receiptBuilder.h = JSONUtil.b(c.b("status"));
            receiptBuilder.i = JSONUtil.b(c.b("total_cost"));
            receiptBuilder.j = JSONUtil.b(c.b("total_tax"));
            receiptBuilder.k = JSONUtil.b(c.b("shipping_cost"));
            receiptBuilder.m = JSONUtil.b(c.b("subtotal"));
            receiptBuilder.n = JSONUtil.b(c.b("order_time"));
            receiptBuilder.p = m9172j(c.b("partner_logo"));
            receiptBuilder.q = m9171i(c.b("items"));
            receiptBuilder.r = JSONUtil.b(c.b("recipient_name"));
            receiptBuilder.s = JSONUtil.b(c.b("account_holder_name"));
            return new CommerceData(receiptBuilder.u());
        } else if (d == CommerceBubbleModelType.CANCELLATION) {
            ReceiptCancellationBuilder receiptCancellationBuilder = new ReceiptCancellationBuilder();
            receiptCancellationBuilder.a = JSONUtil.b(c.b("cancellation_id"));
            receiptCancellationBuilder.d = m9171i(c.b("items"));
            ReceiptBuilder receiptBuilder2 = new ReceiptBuilder();
            receiptBuilder2.a = JSONUtil.b(c.b("receipt_id"));
            receiptBuilder2 = receiptBuilder2;
            receiptBuilder2.b = JSONUtil.b(c.b("order_id"));
            receiptBuilder2 = receiptBuilder2;
            receiptBuilder2.p = m9172j(c.b("partner_logo"));
            receiptCancellationBuilder.b = receiptBuilder2.u();
            return new CommerceData(receiptCancellationBuilder.e());
        } else if (d == CommerceBubbleModelType.SHIPMENT) {
            return m9169g(c);
        } else {
            if (d == CommerceBubbleModelType.SHIPMENT_TRACKING_ETA) {
                return m9160a(d, c);
            }
            if (d == CommerceBubbleModelType.SHIPMENT_TRACKING_IN_TRANSIT) {
                return m9160a(d, c);
            }
            if (d == CommerceBubbleModelType.SHIPMENT_TRACKING_OUT_FOR_DELIVERY) {
                return m9160a(d, c);
            }
            if (d == CommerceBubbleModelType.SHIPMENT_TRACKING_DELAYED) {
                return m9160a(d, c);
            }
            if (d == CommerceBubbleModelType.SHIPMENT_TRACKING_DELIVERED) {
                return m9160a(d, c);
            }
            if (d == CommerceBubbleModelType.SHIPMENT_FOR_UNSUPPORTED_CARRIER) {
                return m9169g(c);
            }
            if (d == CommerceBubbleModelType.SHIPMENT_ETA) {
                return m9160a(d, c);
            }
            return null;
        }
    }

    @Nullable
    private static JsonNode m9167c(@Nullable JsonNode jsonNode) {
        if (jsonNode == null || !jsonNode.i() || jsonNode.e() == 0) {
            return null;
        }
        JsonNode b;
        if (!jsonNode.d("fb_object_contents")) {
            jsonNode = (JsonNode) jsonNode.iterator().next();
        }
        Object obj = (jsonNode == null || !jsonNode.i()) ? null : 1;
        if (obj != null) {
            b = jsonNode.b("fb_object_contents");
        } else {
            b = null;
        }
        if (b == null || b.e() == 0) {
            return null;
        }
        return b;
    }

    private static CommerceBubbleModelType m9168d(JsonNode jsonNode) {
        JsonNode b = jsonNode.b("messenger_commerce_bubble_type");
        if (b == null) {
            return CommerceBubbleModelType.UNKNOWN;
        }
        return CommerceBubbleModelType.getModelType(JSONUtil.d(b));
    }

    private static ObjectNode m9165a(Shipment shipment) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("shipment_id", shipment.a);
        objectNode.a("receipt_id", shipment.b);
        objectNode.a("tracking_number", shipment.c);
        objectNode.a("carrier", shipment.d.a);
        objectNode.a("carrier_tracking_url", shipment.e != null ? shipment.e.toString() : "");
        objectNode.a("ship_date", Long.toString(shipment.f / 1000));
        objectNode.a("display_ship_date", shipment.g);
        objectNode.c("origin", m9164a(shipment.h));
        objectNode.c("destination", m9164a(shipment.i));
        objectNode.a("estimated_delivery_time", shipment.j != 0 ? Long.toString(shipment.j / 1000) : "");
        objectNode.a("estimated_delivery_display_time", shipment.k);
        objectNode.a("delayed_delivery_time", shipment.l != 0 ? Long.toString(shipment.l / 1000) : "");
        objectNode.a("delayed_delivery_display_time", shipment.m);
        objectNode.a("service_type", shipment.n);
        objectNode.c("carrier_logo", m9162a(shipment.o));
        objectNode.c("items", m9166a(shipment.p));
        return objectNode;
    }

    @Nullable
    private static CommerceData m9169g(JsonNode jsonNode) {
        long j;
        long j2 = 0;
        String b = JSONUtil.b(jsonNode.b("carrier"));
        LogoImage j3 = m9172j(jsonNode.b("carrier_logo"));
        String b2 = JSONUtil.b(jsonNode.b("carrier_tracking_url"));
        RetailCarrierBuilder retailCarrierBuilder = new RetailCarrierBuilder();
        retailCarrierBuilder.a = b;
        RetailCarrierBuilder retailCarrierBuilder2 = retailCarrierBuilder;
        retailCarrierBuilder2.b = j3;
        RetailCarrier e = retailCarrierBuilder2.b(b2).e();
        ShipmentBuilder shipmentBuilder = new ShipmentBuilder();
        shipmentBuilder.a = JSONUtil.b(jsonNode.b("shipment_id"));
        shipmentBuilder.b = JSONUtil.b(jsonNode.b("receipt_id"));
        shipmentBuilder.c = JSONUtil.b(jsonNode.b("tracking_number"));
        shipmentBuilder.d = e;
        shipmentBuilder.d(b2);
        shipmentBuilder.f = Long.parseLong(JSONUtil.b(jsonNode.b("ship_date"))) * 1000;
        shipmentBuilder.g = JSONUtil.b(jsonNode.b("display_ship_date"));
        shipmentBuilder.h = m9170h(jsonNode.b("origin"));
        shipmentBuilder.i = m9170h(jsonNode.b("destination"));
        b = JSONUtil.b(jsonNode.b("estimated_delivery_time"));
        if (Strings.isNullOrEmpty(b)) {
            j = 0;
        } else {
            j = Long.parseLong(b) * 1000;
        }
        shipmentBuilder.j = j;
        shipmentBuilder.k = JSONUtil.b(jsonNode.b("estimated_delivery_display_time"));
        b = JSONUtil.b(jsonNode.b("delayed_delivery_time"));
        if (!Strings.isNullOrEmpty(b)) {
            j2 = Long.parseLong(b) * 1000;
        }
        shipmentBuilder.l = j2;
        shipmentBuilder.m = JSONUtil.b(jsonNode.b("delayed_delivery_display_time"));
        shipmentBuilder.n = JSONUtil.b(jsonNode.b("service_type"));
        shipmentBuilder.o = j3;
        shipmentBuilder.p = m9171i(jsonNode.b("items"));
        return new CommerceData(shipmentBuilder.r());
    }

    @Nullable
    private static CommerceData m9160a(CommerceBubbleModelType commerceBubbleModelType, JsonNode jsonNode) {
        ShipmentTrackingEventBuilder shipmentTrackingEventBuilder = new ShipmentTrackingEventBuilder();
        shipmentTrackingEventBuilder.b = JSONUtil.b(jsonNode.b("id"));
        shipmentTrackingEventBuilder.a = commerceBubbleModelType;
        shipmentTrackingEventBuilder.d = Long.parseLong(JSONUtil.b(jsonNode.b("timestamp"))) * 1000;
        shipmentTrackingEventBuilder.e = JSONUtil.b(jsonNode.b("display_time"));
        shipmentTrackingEventBuilder.f = m9170h(jsonNode.b("tracking_event_location"));
        if (jsonNode.b("shipment_id") != null) {
            ShipmentBuilder shipmentBuilder = new ShipmentBuilder();
            RetailCarrierBuilder retailCarrierBuilder = new RetailCarrierBuilder();
            retailCarrierBuilder.a = JSONUtil.b(jsonNode.b("carrier"));
            retailCarrierBuilder = retailCarrierBuilder;
            retailCarrierBuilder.b = m9172j(jsonNode.b("carrier_logo"));
            shipmentBuilder.d = retailCarrierBuilder.b(JSONUtil.b(jsonNode.b("carrier_tracking_url"))).e();
            shipmentBuilder.a = JSONUtil.b(jsonNode.b("shipment_id"));
            shipmentBuilder.c = JSONUtil.b(jsonNode.b("tracking_number"));
            shipmentBuilder.n = JSONUtil.b(jsonNode.b("service_type"));
            shipmentBuilder.p = m9171i(jsonNode.b("items"));
            shipmentTrackingEventBuilder.g = shipmentBuilder.r();
        }
        return new CommerceData(shipmentTrackingEventBuilder.h());
    }

    public static ObjectNode m9164a(RetailAddress retailAddress) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        if (retailAddress != null) {
            objectNode.a("street_1", retailAddress.a);
            objectNode.a("street_2", retailAddress.b);
            objectNode.a("city", retailAddress.c);
            objectNode.a("state", retailAddress.d);
            objectNode.a("postal_code", retailAddress.e);
            objectNode.a("country", retailAddress.f);
            objectNode.a("timezone", retailAddress.g);
            objectNode.a("latitude", Double.toString(retailAddress.h));
            objectNode.a("longitude", Double.toString(retailAddress.i));
        }
        return objectNode;
    }

    @Nullable
    public static RetailAddress m9170h(@Nullable JsonNode jsonNode) {
        if (jsonNode == null) {
            return null;
        }
        RetailAddressBuilder retailAddressBuilder = new RetailAddressBuilder();
        retailAddressBuilder.a = JSONUtil.b(jsonNode.b("street_1"));
        retailAddressBuilder.b = JSONUtil.b(jsonNode.b("street_2"));
        retailAddressBuilder.c = JSONUtil.b(jsonNode.b("city"));
        retailAddressBuilder.d = JSONUtil.b(jsonNode.b("state"));
        retailAddressBuilder.e = JSONUtil.b(jsonNode.b("postal_code"));
        retailAddressBuilder.f = JSONUtil.b(jsonNode.b("country"));
        retailAddressBuilder.g = JSONUtil.b(jsonNode.b("timezone"));
        retailAddressBuilder.h = JSONUtil.e(jsonNode.b("latitude"));
        retailAddressBuilder.i = JSONUtil.e(jsonNode.b("longitude"));
        return retailAddressBuilder.j();
    }

    public static ObjectNode m9166a(List<PlatformGenericAttachmentItem> list) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        if (list == null || list.isEmpty()) {
            return objectNode;
        }
        for (PlatformGenericAttachmentItem platformGenericAttachmentItem : list) {
            ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
            objectNode2.a("location", platformGenericAttachmentItem.a);
            objectNode2.a("title", platformGenericAttachmentItem.b);
            objectNode2.a("desc", platformGenericAttachmentItem.c);
            objectNode2.a("price", platformGenericAttachmentItem.e);
            objectNode2.a("quantity", Integer.toString(platformGenericAttachmentItem.f));
            objectNode2.a("thumb_url", platformGenericAttachmentItem.d != null ? platformGenericAttachmentItem.d.toString() : "");
            ObjectNode objectNode3 = new ObjectNode(JsonNodeFactory.a);
            objectNode3.a("metaline_1", platformGenericAttachmentItem.g);
            objectNode3.a("metaline_2", platformGenericAttachmentItem.h);
            objectNode3.a("metaline_3", platformGenericAttachmentItem.i);
            objectNode2.c("metalines", objectNode3);
            objectNode.c(platformGenericAttachmentItem.a, objectNode2);
        }
        return objectNode;
    }

    public static List<PlatformGenericAttachmentItem> m9171i(@Nullable JsonNode jsonNode) {
        if (jsonNode == null || jsonNode.e() == 0) {
            return Collections.emptyList();
        }
        Builder builder = ImmutableList.builder();
        Iterator it = jsonNode.iterator();
        while (it.hasNext()) {
            JsonNode jsonNode2 = (JsonNode) it.next();
            PlatformGenericAttachmentItemBuilder platformGenericAttachmentItemBuilder = new PlatformGenericAttachmentItemBuilder();
            platformGenericAttachmentItemBuilder.a = JSONUtil.b(jsonNode2.b("location"));
            platformGenericAttachmentItemBuilder.b = JSONUtil.b(jsonNode2.b("title"));
            platformGenericAttachmentItemBuilder.c = JSONUtil.b(jsonNode2.b("desc"));
            platformGenericAttachmentItemBuilder.e = JSONUtil.b(jsonNode2.b("price"));
            platformGenericAttachmentItemBuilder.f = JSONUtil.d(jsonNode2.b("quantity"));
            platformGenericAttachmentItemBuilder.d(JSONUtil.b(jsonNode2.b("thumb_url")));
            jsonNode2 = jsonNode2.b("metalines");
            if (jsonNode2 != null) {
                platformGenericAttachmentItemBuilder.g = JSONUtil.b(jsonNode2.b("metaline_1"));
                platformGenericAttachmentItemBuilder.h = JSONUtil.b(jsonNode2.b("metaline_2"));
                platformGenericAttachmentItemBuilder.i = JSONUtil.b(jsonNode2.b("metaline_3"));
            }
            builder.c(platformGenericAttachmentItemBuilder.n());
        }
        return builder.b();
    }

    public static ObjectNode m9162a(@Nullable LogoImage logoImage) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        if (logoImage != null) {
            objectNode.a("url", logoImage.a != null ? logoImage.a.toString() : "");
            objectNode.a("width", logoImage.b);
            objectNode.a("height", logoImage.c);
        }
        return objectNode;
    }

    @Nullable
    public static LogoImage m9172j(@Nullable JsonNode jsonNode) {
        if (jsonNode == null) {
            return null;
        }
        LogoImageBuilder logoImageBuilder = new LogoImageBuilder();
        logoImageBuilder.a(JSONUtil.b(jsonNode.b("url")));
        logoImageBuilder.b = JSONUtil.d(jsonNode.b("width"));
        logoImageBuilder.c = JSONUtil.d(jsonNode.b("height"));
        return logoImageBuilder.d();
    }
}
