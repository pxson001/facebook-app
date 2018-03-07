package com.facebook.feed.inlinecomposer.multirow;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.inlinecomposer.InlineComposerV2HeaderView;
import com.facebook.feed.inlinecomposer.abtest.WorkInlineComposerGateKeepers;
import com.facebook.feed.inlinecomposer.inspiration.row.InlineComposerCameraPartDefinition;
import com.facebook.feed.inlinecomposer.inspiration.row.InlineComposerCameraPartDefinition.Props;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerEnvironment;
import com.facebook.feed.inlinecomposer.multirow.v3.PromptGroupPartDefinition;
import com.facebook.feed.inlinecomposer.v2attachment.CanRenderV2Prompt;
import com.facebook.feed.photoreminder.MediaReminderPromptsPromptPartDefinition;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.friendsharing.meme.prompt.MemePromptPartDefinition;
import com.facebook.friendsharing.souvenirs.prompt.SouvenirPromptsPromptPartDefinition;
import com.facebook.friendsharing.suggestedcoverphotos.prompt.CoverPhotoPromptPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.photos.creativeediting.swipeable.prompt.FramePromptsPromptPartDefinition;
import com.facebook.productionprompts.ClipboardPromptsPromptPartDefinition;
import com.facebook.productionprompts.ProductionPromptsPromptPartDefinition;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.InlineComposerPromptViewController;
import com.facebook.productionprompts.model.PromptObject.PromptSurface;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: mutation_data */
public class InlineComposerGroupPartDefinition extends BaseMultiRowGroupPartDefinition<InlineComposerModel, Void, InlineComposerEnvironment> {
    private static InlineComposerGroupPartDefinition f13104p;
    private static final Object f13105q = new Object();
    private final InlineComposerFooterPartDefinition f13106a;
    private final InlineComposerV2HeaderPartDefinition f13107b;
    public final Lazy<ProductionPromptsPromptPartDefinition<InlineComposerEnvironment, InlineComposerV2HeaderView>> f13108c;
    public final Lazy<ClipboardPromptsPromptPartDefinition<InlineComposerEnvironment, InlineComposerV2HeaderView>> f13109d;
    public final Lazy<MediaReminderPromptsPromptPartDefinition<InlineComposerEnvironment>> f13110e;
    public final Lazy<FramePromptsPromptPartDefinition<InlineComposerEnvironment>> f13111f;
    public final Lazy<MemePromptPartDefinition> f13112g;
    public final Lazy<SouvenirPromptsPromptPartDefinition> f13113h;
    public final Lazy<CoverPhotoPromptPartDefinition> f13114i;
    private final Provider<InlineComposerPromptViewController> f13115j;
    private final WorkInlineComposerGateKeepers f13116k;
    private final PromptsExperimentHelper f13117l;
    private final PromptGroupPartDefinition f13118m;
    private final InlineComposerCameraPartDefinition f13119n;
    private final ScrollAwayComposerController f13120o;

    private static InlineComposerGroupPartDefinition m19334b(InjectorLike injectorLike) {
        return new InlineComposerGroupPartDefinition(InlineComposerFooterPartDefinition.m19338a(injectorLike), InlineComposerV2HeaderPartDefinition.m19357a(injectorLike), IdBasedLazy.m1808a(injectorLike, 9724), IdBasedLazy.m1808a(injectorLike, 9723), IdBasedLazy.m1808a(injectorLike, 5874), IdBasedLazy.m1808a(injectorLike, 9294), IdBasedLazy.m1808a(injectorLike, 6711), IdBasedLazy.m1808a(injectorLike, 6723), IdBasedLazy.m1808a(injectorLike, 6732), IdBasedProvider.m1811a(injectorLike, 3137), WorkInlineComposerGateKeepers.m15307a(injectorLike), PromptsExperimentHelper.m15311a(injectorLike), PromptGroupPartDefinition.m19544a(injectorLike), InlineComposerCameraPartDefinition.m19548a(injectorLike), ScrollAwayComposerController.m15502a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        int i;
        obj = (InlineComposerModel) obj;
        InlineComposerEnvironment inlineComposerEnvironment = (InlineComposerEnvironment) anyEnvironment;
        boolean z2 = true;
        boolean z3 = !this.f13120o.m15504a();
        CanRenderV2Prompt a = ((InlineComposerPromptViewController) this.f13115j.get()).m19563a((InlineComposerModel) obj, inlineComposerEnvironment.getContext());
        if (this.f13117l.m15314c() && this.f13106a.m19343a((InlineComposerModel) obj)) {
            z = true;
        } else {
            z = false;
        }
        baseMultiRowSubParts.m19112a(this.f13119n, new Props());
        if (z3) {
            boolean z4;
            MultiRowPartWithIsNeeded multiRowPartWithIsNeeded = this.f13107b;
            if (!this.f13117l.m15313b() || this.f13117l.m15314c()) {
                z4 = false;
            } else {
                z4 = true;
            }
            baseMultiRowSubParts.m19112a(multiRowPartWithIsNeeded, InlineComposerV2HeaderPartDefinition.Props.m19775a(obj, a, z4, z));
        }
        if (!(this.f13117l.m15313b() && a != null && this.f13117l.m15315d())) {
            z2 = false;
        }
        Object promptPartDefinitionProps = new PromptPartDefinitionProps(obj.f12908c, obj, a);
        if (obj.f12908c == null || !obj.f12908c.f13409a.mo2495d().equals(PromptSurface.INLINE_COMPOSER)) {
            i = 0;
        } else {
            i = 1;
        }
        boolean z5 = i & z2;
        SubPartsSelector.m19117a(baseMultiRowSubParts, z5, this.f13110e, promptPartDefinitionProps).m19121a(z5, this.f13111f, promptPartDefinitionProps).m19121a(z5, this.f13112g, promptPartDefinitionProps).m19121a(z5, this.f13114i, promptPartDefinitionProps).m19121a(z5, this.f13109d, promptPartDefinitionProps).m19121a(z5, this.f13113h, promptPartDefinitionProps).m19121a(z5, this.f13108c, promptPartDefinitionProps);
        if (z3) {
            baseMultiRowSubParts.m19112a(this.f13106a, obj);
        }
        m19333a(obj, z2);
        if (this.f13117l.m15314c() && a != null) {
            baseMultiRowSubParts.m19112a(this.f13118m, promptPartDefinitionProps);
        }
        return null;
    }

    public static InlineComposerGroupPartDefinition m19332a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13105q) {
                InlineComposerGroupPartDefinition inlineComposerGroupPartDefinition;
                if (a2 != null) {
                    inlineComposerGroupPartDefinition = (InlineComposerGroupPartDefinition) a2.mo818a(f13105q);
                } else {
                    inlineComposerGroupPartDefinition = f13104p;
                }
                if (inlineComposerGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19334b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13105q, b3);
                        } else {
                            f13104p = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public InlineComposerGroupPartDefinition(InlineComposerFooterPartDefinition inlineComposerFooterPartDefinition, InlineComposerV2HeaderPartDefinition inlineComposerV2HeaderPartDefinition, Lazy<ProductionPromptsPromptPartDefinition> lazy, Lazy<ClipboardPromptsPromptPartDefinition> lazy2, Lazy<MediaReminderPromptsPromptPartDefinition> lazy3, Lazy<FramePromptsPromptPartDefinition> lazy4, Lazy<MemePromptPartDefinition> lazy5, Lazy<SouvenirPromptsPromptPartDefinition> lazy6, Lazy<CoverPhotoPromptPartDefinition> lazy7, Provider<InlineComposerPromptViewController> provider, WorkInlineComposerGateKeepers workInlineComposerGateKeepers, PromptsExperimentHelper promptsExperimentHelper, PromptGroupPartDefinition promptGroupPartDefinition, InlineComposerCameraPartDefinition inlineComposerCameraPartDefinition, ScrollAwayComposerController scrollAwayComposerController) {
        this.f13106a = inlineComposerFooterPartDefinition;
        this.f13107b = inlineComposerV2HeaderPartDefinition;
        this.f13108c = lazy;
        this.f13109d = lazy2;
        this.f13110e = lazy3;
        this.f13111f = lazy4;
        this.f13112g = lazy5;
        this.f13113h = lazy6;
        this.f13114i = lazy7;
        this.f13115j = provider;
        this.f13116k = workInlineComposerGateKeepers;
        this.f13117l = promptsExperimentHelper;
        this.f13118m = promptGroupPartDefinition;
        this.f13119n = inlineComposerCameraPartDefinition;
        this.f13120o = scrollAwayComposerController;
    }

    private static void m19333a(InlineComposerModel inlineComposerModel, boolean z) {
        if (inlineComposerModel.f12908c != null) {
            inlineComposerModel.f12908c.f13409a.mo2495d().equals(PromptSurface.STICKY_FEED);
        }
    }

    public final boolean mo2536a(Object obj) {
        return !this.f13116k.m15309a();
    }
}
