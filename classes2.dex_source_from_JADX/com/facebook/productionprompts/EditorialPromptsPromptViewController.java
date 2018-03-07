package com.facebook.productionprompts;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.ipc.productionprompts.ui.v2.BasePromptViewController;
import com.facebook.ipc.productionprompts.ui.v2.PromptViewBindingObject;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.common.V2ObjectsRequiredForBinding;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptDisplayReason;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mobile_power_attribution_stats */
public class EditorialPromptsPromptViewController extends BasePromptViewController {
    private static final CallerContext f13389a = CallerContext.m9061a(ProductionPromptsPromptViewController.class, "inline_composer");
    private static final EditorialPromptViewBindingObject f13390b = new EditorialPromptViewBindingObject();
    public final InlineComposerPromptActionHandler f13391c;
    public final PromptActionContextFactory f13392d;
    private final EditorialPromptClickListener f13393e = new EditorialPromptClickListener(this);
    private final ProductionPromptV2PromptProvider f13394f;

    /* compiled from: mobile_power_attribution_stats */
    public class EditorialPromptViewBindingObject implements PromptViewBindingObject {
        public ProductionPromptV2Prompt f13395a = null;

        @Nullable
        public final String mo2625a() {
            Preconditions.checkNotNull(this.f13395a);
            return this.f13395a.a();
        }

        @Nullable
        public final String mo2626b() {
            Preconditions.checkNotNull(this.f13395a);
            return this.f13395a.b();
        }

        @Nullable
        public final Integer mo2627c() {
            Preconditions.checkNotNull(this.f13395a);
            return this.f13395a.c();
        }

        @Nullable
        public final Drawable mo2628d() {
            Preconditions.checkNotNull(this.f13395a);
            return this.f13395a.d();
        }

        @Nullable
        public final Drawable mo2629e() {
            Preconditions.checkNotNull(this.f13395a);
            return this.f13395a.e();
        }

        @Nullable
        public final Uri mo2630f() {
            Preconditions.checkNotNull(this.f13395a);
            return this.f13395a.f();
        }

        @Nullable
        public final V2Attachment mo2631g() {
            Preconditions.checkNotNull(this.f13395a);
            return this.f13395a.g();
        }

        @Nullable
        public final PromptDisplayReason mo2632h() {
            Preconditions.checkNotNull(this.f13395a);
            return this.f13395a.h();
        }
    }

    /* compiled from: mobile_power_attribution_stats */
    public class EditorialPromptClickListener implements OnClickListener {
        final /* synthetic */ EditorialPromptsPromptViewController f13396a;
        public InlineComposerPromptSession f13397b = null;

        public EditorialPromptClickListener(EditorialPromptsPromptViewController editorialPromptsPromptViewController) {
            this.f13396a = editorialPromptsPromptViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1833290947);
            view.setOnClickListener(null);
            if (this.f13397b == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1407844886, a);
                return;
            }
            this.f13396a.f13391c.mo2620a(view, this.f13397b, this.f13396a.f13392d.m19726a(this.f13397b).a());
            LogUtils.a(-1650577518, a);
        }
    }

    @Inject
    public EditorialPromptsPromptViewController(InlineComposerPromptActionHandler inlineComposerPromptActionHandler, PromptActionContextFactory promptActionContextFactory, ProductionPromptV2PromptProvider productionPromptV2PromptProvider) {
        this.f13391c = inlineComposerPromptActionHandler;
        this.f13392d = promptActionContextFactory;
        this.f13394f = productionPromptV2PromptProvider;
    }

    public boolean mo2616e(InlineComposerPromptSession inlineComposerPromptSession) {
        return true;
    }

    public PromptViewBindingObject mo2617a(InlineComposerPromptSession inlineComposerPromptSession, Context context) {
        ProductionPromptObject productionPromptObject = (ProductionPromptObject) inlineComposerPromptSession.f13409a;
        InjectorLike injectorLike = this.f13394f;
        return m19729a(new ProductionPromptV2Prompt(productionPromptObject.f12765a, V2PromptUtil.m18713b(injectorLike), PromptsExperimentHelper.m15312b(injectorLike)));
    }

    protected static PromptViewBindingObject m19729a(ProductionPromptV2Prompt productionPromptV2Prompt) {
        f13390b.f13395a = productionPromptV2Prompt;
        return f13390b;
    }

    public final void mo2612a(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, InlineComposerPromptSession inlineComposerPromptSession) {
        Preconditions.checkArgument(v2ObjectsRequiredForBinding instanceof V2ObjectsRequiredForBinding);
        v2ObjectsRequiredForBinding = v2ObjectsRequiredForBinding;
        this.f13393e.f13397b = inlineComposerPromptSession;
        v2ObjectsRequiredForBinding.f19913a.setOnClickListener(this.f13393e);
    }

    public final void mo2615b(@Nullable V2ObjectsRequiredForBinding v2ObjectsRequiredForBinding, InlineComposerPromptSession inlineComposerPromptSession) {
        Preconditions.checkArgument(v2ObjectsRequiredForBinding instanceof V2ObjectsRequiredForBinding);
        v2ObjectsRequiredForBinding = v2ObjectsRequiredForBinding;
        this.f13393e.f13397b = null;
        v2ObjectsRequiredForBinding.f19913a.setOnClickListener(null);
    }
}
