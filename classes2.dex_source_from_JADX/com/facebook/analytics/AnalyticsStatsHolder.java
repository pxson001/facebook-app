package com.facebook.analytics;

import com.fasterxml.jackson.annotation.JsonProperty;

/* compiled from: tail_fetch_from_db_enabled_by_cc */
public class AnalyticsStatsHolder {
    @JsonProperty("count")
    public int count;
    @JsonProperty("eventName")
    public final String eventName;

    public AnalyticsStatsHolder(String str) {
        this.eventName = str;
    }
}
