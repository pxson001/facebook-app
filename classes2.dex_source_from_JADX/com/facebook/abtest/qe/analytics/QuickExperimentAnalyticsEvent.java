package com.facebook.abtest.qe.analytics;

import com.facebook.analytics.HoneyExperimentEvent;
import com.fasterxml.jackson.databind.JsonNode;
import javax.annotation.Nullable;

/* compiled from: getStreamTypes */
public class QuickExperimentAnalyticsEvent extends HoneyExperimentEvent {

    /* compiled from: getStreamTypes */
    public enum QuickExperimentEventType {
        EXPOSURE,
        CONVERSION,
        OBSERVATION
    }

    public QuickExperimentAnalyticsEvent(String str, String str2, QuickExperimentEventType quickExperimentEventType, String str3, @Nullable JsonNode jsonNode) {
        super("quick_experiment_event");
        this.f16095c = "__qe__" + str;
        m22924b("group", str2);
        m22924b("event", quickExperimentEventType.toString());
        m22924b("context", str3);
        if (jsonNode != null) {
            m22922a("extras", jsonNode);
        }
    }
}
