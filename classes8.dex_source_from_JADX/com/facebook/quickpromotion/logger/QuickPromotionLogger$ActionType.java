package com.facebook.quickpromotion.logger;

/* compiled from: reaction_fragment_scroll_perf */
public enum QuickPromotionLogger$ActionType {
    PRIMARY_ACTION("primary"),
    SECONDARY_ACTION("secondary"),
    DISMISS_ACTION("dismiss");
    
    private final String mAnalyticEventName;

    private QuickPromotionLogger$ActionType(String str) {
        this.mAnalyticEventName = str;
    }

    public final String toAnalyticEventName() {
        return this.mAnalyticEventName;
    }
}
