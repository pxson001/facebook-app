package com.facebook.ipc.productionprompts.actionhandler;

import android.view.View;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: moments_upsell_prefs/ */
public abstract class DelegatingPromptActionHandler<CONTEXT extends PromptActionContext> implements PromptActionHandler<CONTEXT> {
    protected ImmutableSet<PromptActionHandler> f13339a;

    public DelegatingPromptActionHandler(Set<PromptActionHandler> set) {
        Preconditions.checkNotNull(set);
        this.f13339a = ImmutableSet.copyOf((Collection) set);
    }

    public void mo2620a(View view, InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        PromptActionHandler a = mo2623a(inlineComposerPromptSession);
        if (a != null) {
            a.mo2620a(view, inlineComposerPromptSession, context);
        }
    }

    public final void mo2622a(@Nullable ComposerPluginConfig composerPluginConfig, InlineComposerPromptSession inlineComposerPromptSession) {
        PromptActionHandler a = mo2623a(inlineComposerPromptSession);
        if (a != null) {
            a.mo2622a(composerPluginConfig, inlineComposerPromptSession);
        }
    }

    @Nullable
    @VisibleForTesting
    protected PromptActionHandler mo2623a(InlineComposerPromptSession inlineComposerPromptSession) {
        PromptActionHandler promptActionHandler = null;
        Iterator it = this.f13339a.iterator();
        while (it.hasNext()) {
            PromptActionHandler promptActionHandler2 = (PromptActionHandler) it.next();
            if (!promptActionHandler2.mo2621b(inlineComposerPromptSession)) {
                promptActionHandler2 = promptActionHandler;
            } else if (promptActionHandler != null) {
                throw new IllegalStateException("Two prompt action handlers should not be enabled for the same prompt object");
            }
            promptActionHandler = promptActionHandler2;
        }
        return promptActionHandler;
    }
}
