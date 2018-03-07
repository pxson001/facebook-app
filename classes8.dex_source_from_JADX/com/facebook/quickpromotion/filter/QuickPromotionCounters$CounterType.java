package com.facebook.quickpromotion.filter;

/* compiled from: reaction_product_item_image_size */
public enum QuickPromotionCounters$CounterType {
    IMPRESSION("Impression"),
    PRIMARY_ACTION("Primary Action Clicks"),
    SECONDARY_ACTION("Secondary Action Clicks"),
    DISMISS_ACTION("Dismiss Action Clicks"),
    DISMISSAL("Dismissal");
    
    private final String mReadableName;

    private QuickPromotionCounters$CounterType(String str) {
        this.mReadableName = str;
    }

    public final String getReadableName() {
        return this.mReadableName;
    }
}
