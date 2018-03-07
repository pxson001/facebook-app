package com.facebook.productionprompts.events;

import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.PromptObject;

/* compiled from: mid */
public class PromptCancelFlowEvent extends PromptsEvent {
    public final Class<? extends PromptObject> f13533a;
    public final PromptAnalytics f13534b;

    public PromptCancelFlowEvent(Class<? extends PromptObject> cls, PromptAnalytics promptAnalytics) {
        this.f13533a = cls;
        this.f13534b = promptAnalytics;
    }
}
