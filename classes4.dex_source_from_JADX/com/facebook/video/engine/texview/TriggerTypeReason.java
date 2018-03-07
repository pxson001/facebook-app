package com.facebook.video.engine.texview;

import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.api.UserReason;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: param_name */
public class TriggerTypeReason extends UserReason {
    private static final Map<EventTriggerType, TriggerTypeReason> f5365d = Maps.a(EventTriggerType.class);
    public final EventTriggerType f5366c;

    static {
        for (EventTriggerType eventTriggerType : EventTriggerType.values()) {
            f5365d.put(eventTriggerType, new TriggerTypeReason(eventTriggerType));
        }
    }

    private TriggerTypeReason(EventTriggerType eventTriggerType) {
        this.f5366c = eventTriggerType;
    }

    public String toString() {
        return "TriggerTypeReason(" + this.f5366c + ")";
    }
}
