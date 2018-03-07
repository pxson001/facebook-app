package com.facebook.messaging.business.commerceui.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: nux_banner_trigger_count */
public class MessengerCommerceAnalyticsLogger {
    public final AnalyticsLogger f8365a;

    /* compiled from: nux_banner_trigger_count */
    public enum CommerceNetworkRequestTypes {
        RECEIPT("receipt"),
        RECEIPT_ITEM("receipt_item"),
        SHIPMENT("shipment"),
        ORDER_HISTORY("order_history"),
        TRENDING_ITEMS("trending_items"),
        CHECKOUT_SELECTIONS("checkout_selections"),
        UNLINK_BUSINESS("unlink_business");
        
        public final String name;

        private CommerceNetworkRequestTypes(String str) {
            this.name = str;
        }
    }

    public static MessengerCommerceAnalyticsLogger m8651b(InjectorLike injectorLike) {
        return new MessengerCommerceAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public static MessengerCommerceAnalyticsLogger m8650a(InjectorLike injectorLike) {
        return m8651b(injectorLike);
    }

    @Inject
    public MessengerCommerceAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f8365a = analyticsLogger;
    }

    public final void m8654a(CommerceBubbleModelType commerceBubbleModelType, String str) {
        String str2;
        Preconditions.checkNotNull(str);
        AnalyticsLogger analyticsLogger = this.f8365a;
        HoneyClientEvent b = m8653f("did_tap_commerce_bubble").b("bubble_type", commerceBubbleModelType.getTypeName());
        if (CommerceBubbleModelType.isReceiptBubble(commerceBubbleModelType)) {
            str2 = "receipt_id";
        } else if (commerceBubbleModelType == CommerceBubbleModelType.SHIPMENT || commerceBubbleModelType == CommerceBubbleModelType.SHIPMENT_FOR_UNSUPPORTED_CARRIER) {
            str2 = "shipment_id";
        } else if (CommerceBubbleModelType.isShippingBubble(commerceBubbleModelType)) {
            str2 = "shipment_tracking_id";
        } else if (commerceBubbleModelType == CommerceBubbleModelType.PRODUCT_SUBSCRIPTION) {
            str2 = "subscription_id";
        } else {
            Preconditions.checkState(false, "Unsupported bubble type");
            str2 = null;
        }
        analyticsLogger.a(b.b(str2, str));
    }

    public final void m8657c(String str) {
        Preconditions.checkNotNull(str);
        m8652b("did_tap_notyou_message", str);
    }

    public final void m8655a(CommerceNetworkRequestTypes commerceNetworkRequestTypes, boolean z, long j, String str) {
        this.f8365a.a(m8653f(z ? "network_request_success" : "network_error").b("network_request_type", commerceNetworkRequestTypes.name).a("network_time", j).b("error_code", str));
    }

    public final void m8658d(String str) {
        Preconditions.checkNotNull(str);
        m8652b("did_click_trending_shopping_cart", str);
    }

    public final void m8659e(String str) {
        Preconditions.checkNotNull(str);
        m8652b("did_click_trending_item", str);
    }

    public final void m8656a(String str, String str2) {
        Preconditions.checkNotNull(str);
        m8652b("did_show_wifi_notification", str);
        this.f8365a.a(m8653f("did_show_wifi_notification").b("business_id", str).b("notification_resource", str2));
    }

    public static HoneyClientEvent m8653f(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "messenger_commerce";
        return honeyClientEvent;
    }

    private void m8652b(String str, String str2) {
        this.f8365a.a(m8653f(str).b("business_id", str2));
    }
}
