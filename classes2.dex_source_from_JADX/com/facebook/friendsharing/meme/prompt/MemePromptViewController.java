package com.facebook.friendsharing.meme.prompt;

import android.content.Context;
import com.facebook.ipc.productionprompts.ui.v2.BasePromptViewController;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewBindingObject;
import com.facebook.productionprompts.common.V2ObjectsRequiredForBinding;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptObject;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mobile_http_flow */
public class MemePromptViewController extends BasePromptViewController {
    QeAccessor f13398a;
    MemePromptClickListenerProvider f13399b;

    @Inject
    public MemePromptViewController(QeAccessor qeAccessor, MemePromptClickListenerProvider memePromptClickListenerProvider) {
        this.f13398a = qeAccessor;
        this.f13399b = memePromptClickListenerProvider;
    }

    public final boolean mo2616e(InlineComposerPromptSession inlineComposerPromptSession) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        Preconditions.checkState(a instanceof ProductionPromptObject);
        if (this.f13398a.mo596a(ExperimentsForMemePromptModule.a, false)) {
            return ((ProductionPromptObject) a).f12765a.r() != null;
        } else {
            return false;
        }
    }

    public final PromptViewBindingObject mo2617a(InlineComposerPromptSession inlineComposerPromptSession, Context context) {
        return new MemePromptViewBindingObject(context, inlineComposerPromptSession);
    }

    public final void mo2612a(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, InlineComposerPromptSession inlineComposerPromptSession) {
        Preconditions.checkArgument(v2ObjectsRequiredForBinding instanceof V2ObjectsRequiredForBinding);
        v2ObjectsRequiredForBinding = v2ObjectsRequiredForBinding;
        v2ObjectsRequiredForBinding.f19913a.setOnClickListener(this.f13399b.m19761a(inlineComposerPromptSession));
    }

    public final void mo2615b(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, InlineComposerPromptSession inlineComposerPromptSession) {
        Preconditions.checkArgument(v2ObjectsRequiredForBinding instanceof V2ObjectsRequiredForBinding);
        v2ObjectsRequiredForBinding.f19913a.setOnClickListener(null);
    }
}
