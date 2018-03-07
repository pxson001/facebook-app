package com.facebook.ipc.productionprompts.ui.v2;

import android.content.Context;
import com.facebook.productionprompts.common.V2ObjectsRequiredForBinding;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: moved_count */
public abstract class DelegatingPromptViewController implements PromptViewController {
    protected ImmutableSet<PromptViewController> f13299a;

    public DelegatingPromptViewController(Set<PromptViewController> set) {
        Preconditions.checkNotNull(set);
        this.f13299a = ImmutableSet.copyOf((Collection) set);
    }

    public final PromptViewBindingObject mo2617a(@Nullable InlineComposerPromptSession inlineComposerPromptSession, Context context) {
        PromptViewController d = mo2624d(inlineComposerPromptSession);
        if (d != null) {
            return d.mo2617a(inlineComposerPromptSession, context);
        }
        return null;
    }

    public void mo2612a(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, @Nullable InlineComposerPromptSession inlineComposerPromptSession) {
        PromptViewController d = mo2624d(inlineComposerPromptSession);
        if (d != null) {
            d.mo2612a(v2ObjectsRequiredForBinding, inlineComposerPromptSession);
        }
    }

    public void mo2615b(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, @Nullable InlineComposerPromptSession inlineComposerPromptSession) {
        PromptViewController d = mo2624d(inlineComposerPromptSession);
        if (d != null) {
            d.mo2615b(v2ObjectsRequiredForBinding, inlineComposerPromptSession);
        }
    }

    public void mo2614a(boolean z, @Nullable InlineComposerPromptSession inlineComposerPromptSession) {
        PromptViewController d = mo2624d(inlineComposerPromptSession);
        if (d != null) {
            d.mo2614a(z, inlineComposerPromptSession);
        }
    }

    public void mo2613a(@Nullable InlineComposerPromptSession inlineComposerPromptSession) {
        PromptViewController d = mo2624d(inlineComposerPromptSession);
        if (d != null) {
            d.mo2613a(inlineComposerPromptSession);
        }
    }

    public final void mo2618b(@Nullable InlineComposerPromptSession inlineComposerPromptSession) {
        PromptViewController d = mo2624d(inlineComposerPromptSession);
        if (d != null) {
            d.mo2618b(inlineComposerPromptSession);
        }
    }

    public final void mo2619c(@Nullable InlineComposerPromptSession inlineComposerPromptSession) {
        PromptViewController d = mo2624d(inlineComposerPromptSession);
        if (d != null) {
            d.mo2619c(inlineComposerPromptSession);
        }
    }

    @Nullable
    @VisibleForTesting
    protected PromptViewController mo2624d(InlineComposerPromptSession inlineComposerPromptSession) {
        PromptViewController promptViewController = null;
        Iterator it = this.f13299a.iterator();
        while (it.hasNext()) {
            PromptPartDefinitionHelper promptPartDefinitionHelper = (PromptViewController) it.next();
            if (!promptPartDefinitionHelper.mo2616e(inlineComposerPromptSession)) {
                promptPartDefinitionHelper = promptViewController;
            } else if (promptViewController != null) {
                throw new IllegalStateException("Two prompt view controllers should not be enabled for the same prompt object");
            }
            PromptPartDefinitionHelper promptPartDefinitionHelper2 = promptPartDefinitionHelper;
        }
        return promptViewController;
    }
}
