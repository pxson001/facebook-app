package com.facebook.productionprompts.events;

import com.facebook.productionprompts.model.PromptObject;

/* compiled from: metric */
public class PromptsInvalidateEvent extends PromptsEvent {
    public final Class<? extends PromptObject> f13539a;

    public PromptsInvalidateEvent(Class<? extends PromptObject> cls) {
        this.f13539a = cls;
    }
}
