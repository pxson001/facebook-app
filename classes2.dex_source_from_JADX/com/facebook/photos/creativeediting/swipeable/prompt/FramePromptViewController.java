package com.facebook.photos.creativeediting.swipeable.prompt;

import android.content.Context;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.ui.v2.BasePromptViewController;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewBindingObject;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.V2ObjectsRequiredForBinding;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptObject;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ultralight.Inject;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: mobile_device_bytes_received_since_boot */
public class FramePromptViewController extends BasePromptViewController {
    @Inject
    public QeAccessor f13401a;
    @Inject
    public FramePromptProvider f13402b;
    private final FramePromptClickListener f13403c;
    private FramePrompt f13404d;

    @Inject
    public FramePromptViewController(FramePromptClickListener framePromptClickListener) {
        this.f13403c = framePromptClickListener;
    }

    public final boolean mo2616e(InlineComposerPromptSession inlineComposerPromptSession) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        Preconditions.checkState(a instanceof ProductionPromptObject);
        return ((ProductionPromptObject) a).f12765a.m() != null && this.f13401a.mo596a(ExperimentsForSwipeablePromptModule.a, false);
    }

    public final PromptViewBindingObject mo2617a(InlineComposerPromptSession inlineComposerPromptSession, Context context) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        Preconditions.checkState(a instanceof ProductionPromptObject);
        ProductionPromptObject productionPromptObject = (ProductionPromptObject) a;
        if (this.f13404d == null || !this.f13404d.d.equals(productionPromptObject.f12765a)) {
            InjectorLike injectorLike = this.f13402b;
            this.f13404d = new FramePrompt(context, inlineComposerPromptSession, V2PromptUtil.m18713b(injectorLike), PromptsExperimentHelper.m15312b(injectorLike));
        }
        return this.f13404d;
    }

    public final void mo2612a(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, InlineComposerPromptSession inlineComposerPromptSession) {
        Preconditions.checkArgument(v2ObjectsRequiredForBinding instanceof V2ObjectsRequiredForBinding);
        v2ObjectsRequiredForBinding = v2ObjectsRequiredForBinding;
        this.f13403c.f13407c = inlineComposerPromptSession;
        v2ObjectsRequiredForBinding.f19913a.setOnClickListener(this.f13403c);
    }

    public final void mo2615b(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, InlineComposerPromptSession inlineComposerPromptSession) {
        Preconditions.checkArgument(v2ObjectsRequiredForBinding instanceof V2ObjectsRequiredForBinding);
        v2ObjectsRequiredForBinding = v2ObjectsRequiredForBinding;
        this.f13403c.f13407c = null;
        v2ObjectsRequiredForBinding.f19913a.setOnClickListener(null);
    }
}
