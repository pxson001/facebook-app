package com.facebook.productionprompts.events;

import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.PromptObject;

/* compiled from: mime_type */
public class PromptCompleteFlowEvent extends PromptsEvent {
    public final Class<? extends PromptObject> f13530a;
    public final PromptAnalytics f13531b;
    public final boolean f13532c;

    public PromptCompleteFlowEvent(Class<? extends PromptObject> cls, PromptAnalytics promptAnalytics, boolean z) {
        this.f13530a = cls;
        this.f13531b = promptAnalytics;
        this.f13532c = z;
    }
}
