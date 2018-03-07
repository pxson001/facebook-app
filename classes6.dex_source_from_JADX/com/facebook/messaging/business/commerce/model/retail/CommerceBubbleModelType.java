package com.facebook.messaging.business.commerce.model.retail;

/* compiled from: video_trim_start_time_ms */
public enum CommerceBubbleModelType {
    UNKNOWN(0),
    RECEIPT(1),
    CANCELLATION(2),
    SHIPMENT(3),
    SHIPMENT_TRACKING_ETA(4),
    SHIPMENT_TRACKING_IN_TRANSIT(5),
    SHIPMENT_TRACKING_OUT_FOR_DELIVERY(6),
    SHIPMENT_TRACKING_DELAYED(7),
    SHIPMENT_TRACKING_DELIVERED(8),
    SHIPMENT_FOR_UNSUPPORTED_CARRIER(9),
    SHIPMENT_ETA(10),
    AGENT_ITEM_SUGGESTION(11),
    PRODUCT_SUBSCRIPTION(12);
    
    private final int mType;

    private CommerceBubbleModelType(int i) {
        this.mType = i;
    }

    public final int getValue() {
        return this.mType;
    }

    public final String getTypeName() {
        if (this.mType == RECEIPT.getValue()) {
            return "retail_receipt";
        }
        if (this.mType == CANCELLATION.getValue()) {
            return "retail_cancellation";
        }
        if (this.mType == SHIPMENT.getValue()) {
            return "retail_shipment";
        }
        if (this.mType == SHIPMENT_TRACKING_ETA.getValue()) {
            return "retail_shipment_tracking_event";
        }
        if (this.mType == SHIPMENT_TRACKING_IN_TRANSIT.getValue()) {
            return "retail_shipment_tracking_event";
        }
        if (this.mType == SHIPMENT_TRACKING_OUT_FOR_DELIVERY.getValue()) {
            return "retail_shipment_tracking_event";
        }
        if (this.mType == SHIPMENT_TRACKING_DELAYED.getValue()) {
            return "retail_shipment_tracking_event";
        }
        if (this.mType == SHIPMENT_TRACKING_DELIVERED.getValue()) {
            return "retail_shipment_tracking_event";
        }
        if (this.mType == SHIPMENT_FOR_UNSUPPORTED_CARRIER.getValue()) {
            return "retail_shipment";
        }
        if (this.mType == SHIPMENT_ETA.getValue()) {
            return "retail_shipment";
        }
        if (this.mType == AGENT_ITEM_SUGGESTION.getValue()) {
            return "retail_agent_item_suggestion";
        }
        if (this.mType == PRODUCT_SUBSCRIPTION.getValue()) {
            return "retail_now_in_stock";
        }
        return "unknown";
    }

    public static CommerceBubbleModelType getModelType(int i) {
        if (i == RECEIPT.getValue()) {
            return RECEIPT;
        }
        if (i == CANCELLATION.getValue()) {
            return CANCELLATION;
        }
        if (i == SHIPMENT.getValue()) {
            return SHIPMENT;
        }
        if (i == SHIPMENT_TRACKING_ETA.getValue()) {
            return SHIPMENT_TRACKING_ETA;
        }
        if (i == SHIPMENT_TRACKING_IN_TRANSIT.getValue()) {
            return SHIPMENT_TRACKING_IN_TRANSIT;
        }
        if (i == SHIPMENT_TRACKING_OUT_FOR_DELIVERY.getValue()) {
            return SHIPMENT_TRACKING_OUT_FOR_DELIVERY;
        }
        if (i == SHIPMENT_TRACKING_DELAYED.getValue()) {
            return SHIPMENT_TRACKING_DELAYED;
        }
        if (i == SHIPMENT_TRACKING_DELIVERED.getValue()) {
            return SHIPMENT_TRACKING_DELIVERED;
        }
        if (i == SHIPMENT_FOR_UNSUPPORTED_CARRIER.getValue()) {
            return SHIPMENT_FOR_UNSUPPORTED_CARRIER;
        }
        if (i == SHIPMENT_ETA.getValue()) {
            return SHIPMENT_ETA;
        }
        if (i == AGENT_ITEM_SUGGESTION.getValue()) {
            return AGENT_ITEM_SUGGESTION;
        }
        if (i == PRODUCT_SUBSCRIPTION.getValue()) {
            return PRODUCT_SUBSCRIPTION;
        }
        return UNKNOWN;
    }

    public static boolean isShippingBubble(CommerceBubbleModelType commerceBubbleModelType) {
        return commerceBubbleModelType == SHIPMENT || commerceBubbleModelType == SHIPMENT_ETA || commerceBubbleModelType == SHIPMENT_TRACKING_ETA || commerceBubbleModelType == SHIPMENT_TRACKING_IN_TRANSIT || commerceBubbleModelType == SHIPMENT_TRACKING_OUT_FOR_DELIVERY || commerceBubbleModelType == SHIPMENT_TRACKING_DELAYED || commerceBubbleModelType == SHIPMENT_TRACKING_DELIVERED || commerceBubbleModelType == SHIPMENT_FOR_UNSUPPORTED_CARRIER;
    }

    public static boolean isReceiptBubble(CommerceBubbleModelType commerceBubbleModelType) {
        return commerceBubbleModelType == RECEIPT || commerceBubbleModelType == CANCELLATION;
    }
}
