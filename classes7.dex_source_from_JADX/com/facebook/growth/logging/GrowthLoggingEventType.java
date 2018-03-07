package com.facebook.growth.logging;

/* compiled from: preferred_marketplaces */
public enum GrowthLoggingEventType {
    ADD_CONTACTPOINT_FLOW_ENTER("growth_add_contactpoint_flow_enter"),
    ADD_CONTACTPOINT_ATTEMPT("growth_add_contactpoint_attempt"),
    ADD_CONTACTPOINT_FAILURE("growth_add_contactpoint_failure"),
    ADD_CONTACTPOINT_SUCCESS("growth_add_contactpoint_success"),
    ADD_CONTACTPOINT_COUNTRY_SELECTED("growth_add_contactpoint_country_selected"),
    FACEWEB_ADD_CONTACTPOINT_FLOW_ENTER("growth_faceweb_add_contactpoint_flow_enter"),
    FACEWEB_ADD_CONTACTPOINT_CONFIRMED("growth_faceweb_add_contactpoint_confirmed");
    
    private final String mAnalyticsName;

    private GrowthLoggingEventType(String str) {
        this.mAnalyticsName = str;
    }

    public final String getAnalyticsName() {
        return this.mAnalyticsName;
    }

    public final String toString() {
        return this.mAnalyticsName;
    }
}
