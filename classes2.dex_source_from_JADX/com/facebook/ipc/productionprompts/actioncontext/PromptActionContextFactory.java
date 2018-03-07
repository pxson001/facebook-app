package com.facebook.ipc.productionprompts.actioncontext;

import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl.Action;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl.Builder;
import com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import javax.inject.Inject;

/* compiled from: mobile_requests_count */
public class PromptActionContextFactory {
    private final PromptImpressionLoggingSessionIdMap f13384a;

    public static PromptActionContextFactory m19725b(InjectorLike injectorLike) {
        return new PromptActionContextFactory(PromptImpressionLoggingSessionIdMap.m19701a(injectorLike));
    }

    @Inject
    public PromptActionContextFactory(PromptImpressionLoggingSessionIdMap promptImpressionLoggingSessionIdMap) {
        this.f13384a = promptImpressionLoggingSessionIdMap;
    }

    public static PromptActionContextImpl m19724a(String str) {
        return m19723a(str, Action.PHOTO_REMINDER_TAP_ON_MORE).a();
    }

    public final Builder m19726a(InlineComposerPromptSession inlineComposerPromptSession) {
        return m19723a(this.f13384a.m19702a(inlineComposerPromptSession.f13409a.mo2493b()), Action.DEFAULT_TAP_ON_PROMPT);
    }

    public static Builder m19723a(String str, Action action) {
        Builder builder = new Builder();
        builder.a = str;
        builder = builder;
        builder.b = action;
        return builder;
    }
}
