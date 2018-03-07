package com.facebook.commerce.core.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceEvent;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceProductSectionType;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceSubEvent;

/* compiled from: privacy_education_preference */
public class CommerceAnalyticsEventBuilder {
    public static HoneyClientEvent m10502a(String str, long j, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent(CommerceEvent.PRODUCT_ITEM_CLICK.value).b("product_id", str).a("collection_id", j).b(z);
        b.c = "collection_grid";
        return b;
    }

    public static HoneyClientEvent m10501a(long j, int i, long j2, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent(CommerceEvent.COLLECTION_LOAD_TIME.value).a("collection_id", j).a("load_time", j2).a("collection_size", i).b(z);
        b.c = "collection_grid";
        return b;
    }

    public static HoneyClientEvent m10503a(String str, Boolean bool, CommerceProductSectionType commerceProductSectionType) {
        HoneyClientEvent b = new HoneyClientEvent(CommerceSubEvent.EXIT_COLLECTION_OPENED.value).b("collection_id", str).b(bool.booleanValue()).b("container", commerceProductSectionType.value);
        b.c = "collection_grid";
        return b;
    }

    public static HoneyClientEvent m10504b(String str, Boolean bool, CommerceProductSectionType commerceProductSectionType) {
        HoneyClientEvent b = new HoneyClientEvent(CommerceSubEvent.RECOMMENDED_PRODUCT_OPENED.value).b("product_id", str).b(bool.booleanValue()).b("container", commerceProductSectionType.value);
        b.c = "collection_grid";
        return b;
    }
}
