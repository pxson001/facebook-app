package com.facebook.friendsharing.suggestedcoverphotos.prompt;

import android.content.Context;
import com.facebook.ipc.productionprompts.ui.v2.BasePromptViewController;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewBindingObject;
import com.facebook.productionprompts.common.V2ObjectsRequiredForBinding;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mobile_dun */
public class CoverPhotoPromptViewController extends BasePromptViewController {
    private final CoverPhotoPromptClickListenerProvider f13400a;

    @Inject
    public CoverPhotoPromptViewController(CoverPhotoPromptClickListenerProvider coverPhotoPromptClickListenerProvider) {
        this.f13400a = coverPhotoPromptClickListenerProvider;
    }

    public final boolean mo2616e(InlineComposerPromptSession inlineComposerPromptSession) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        Preconditions.checkState(a instanceof ProductionPromptObject);
        ImmutableList s = ((ProductionPromptObject) a).f12765a.s();
        return (s == null || s.isEmpty()) ? false : true;
    }

    public final PromptViewBindingObject mo2617a(InlineComposerPromptSession inlineComposerPromptSession, Context context) {
        return new CoverPhotoPromptViewBindingObject(context, inlineComposerPromptSession);
    }

    public final void mo2612a(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, InlineComposerPromptSession inlineComposerPromptSession) {
        Preconditions.checkArgument(v2ObjectsRequiredForBinding instanceof V2ObjectsRequiredForBinding);
        v2ObjectsRequiredForBinding = v2ObjectsRequiredForBinding;
        v2ObjectsRequiredForBinding.f19913a.setOnClickListener(this.f13400a.m19766a(inlineComposerPromptSession));
    }

    public final void mo2615b(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, InlineComposerPromptSession inlineComposerPromptSession) {
        Preconditions.checkArgument(v2ObjectsRequiredForBinding instanceof V2ObjectsRequiredForBinding);
        v2ObjectsRequiredForBinding.f19913a.setOnClickListener(null);
    }
}
