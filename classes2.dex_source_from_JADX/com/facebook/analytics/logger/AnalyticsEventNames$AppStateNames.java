package com.facebook.analytics.logger;

/* compiled from: qp_dismiss_event_counter */
public enum AnalyticsEventNames$AppStateNames {
    INIT("init"),
    LAUNCH("launch"),
    ACTIVE("active"),
    RESIGN("resign"),
    FOREGROUNDED("foreground"),
    BACKGROUNDED("background");
    
    private String stateName;

    private AnalyticsEventNames$AppStateNames(String str) {
        this.stateName = str;
    }

    public final String toString() {
        return this.stateName;
    }
}
