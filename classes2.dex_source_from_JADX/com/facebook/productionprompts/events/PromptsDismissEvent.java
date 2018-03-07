package com.facebook.productionprompts.events;

import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.InlineComposerPromptSession;

/* compiled from: mf_story_key */
public class PromptsDismissEvent extends PromptsEvent {
    public final InlineComposerPromptSession f13535a;
    public final PromptAnalytics f13536b;
    public final boolean f13537c;
    public final boolean f13538d;

    public PromptsDismissEvent(InlineComposerPromptSession inlineComposerPromptSession, PromptAnalytics promptAnalytics, boolean z, boolean z2) {
        this.f13535a = inlineComposerPromptSession;
        this.f13536b = promptAnalytics;
        this.f13537c = z;
        this.f13538d = z2;
    }
}
