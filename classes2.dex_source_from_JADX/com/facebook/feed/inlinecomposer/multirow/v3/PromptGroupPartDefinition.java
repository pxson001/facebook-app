package com.facebook.feed.inlinecomposer.multirow.v3;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.inlinecomposer.abtest.WorkInlineComposerGateKeepers;
import com.facebook.feed.photoreminder.v3.MediaReminderPromptSelector;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.friendsharing.souvenirs.prompt.v3.SouvenirPromptSmallPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.photos.creativeediting.swipeable.prompt.v3.FramePromptSmallPartDefinition;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.v3.ClipboardPromptSmallPartDefinition;
import com.facebook.productionprompts.v3.ProductionPromptSmallPartDefintion;
import javax.inject.Inject;

@ContextScoped
/* compiled from: mqtt */
public class PromptGroupPartDefinition<E extends HasPositionInformation & PromptViewStateUpdater & HasContext & HasPersistentState> extends BaseMultiRowGroupPartDefinition<PromptPartDefinitionProps, Void, E> {
    private static PromptGroupPartDefinition f13274i;
    private static final Object f13275j = new Object();
    private final PromptsExperimentHelper f13276a;
    private final WorkInlineComposerGateKeepers f13277b;
    private final Lazy<ProductionPromptSmallPartDefintion<E>> f13278c;
    private final Lazy<ClipboardPromptSmallPartDefinition<E>> f13279d;
    private final Lazy<MediaReminderPromptSelector<E>> f13280e;
    private final Lazy<FramePromptSmallPartDefinition<E>> f13281f;
    private final Lazy<PromptTombstonePartDefinition<E>> f13282g;
    private final Lazy<SouvenirPromptSmallPartDefinition<E>> f13283h;

    private static PromptGroupPartDefinition m19545b(InjectorLike injectorLike) {
        return new PromptGroupPartDefinition(PromptsExperimentHelper.m15312b(injectorLike), WorkInlineComposerGateKeepers.m15308b(injectorLike), IdBasedLazy.m1808a(injectorLike, 9729), IdBasedLazy.m1808a(injectorLike, 9728), IdBasedLazy.m1808a(injectorLike, 5861), IdBasedLazy.m1808a(injectorLike, 6725), IdBasedLazy.m1808a(injectorLike, 5879), IdBasedLazy.m1808a(injectorLike, 9296));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (PromptPartDefinitionProps) obj;
        SubPartsSelector.m19115a(baseMultiRowSubParts, this.f13282g, obj).m19119a(this.f13280e, obj).m19119a(this.f13279d, obj).m19119a(this.f13281f, obj).m19119a(this.f13283h, obj).m19119a(this.f13278c, obj);
        return null;
    }

    @Inject
    public PromptGroupPartDefinition(PromptsExperimentHelper promptsExperimentHelper, WorkInlineComposerGateKeepers workInlineComposerGateKeepers, Lazy<ProductionPromptSmallPartDefintion> lazy, Lazy<ClipboardPromptSmallPartDefinition> lazy2, Lazy<PromptTombstonePartDefinition> lazy3, Lazy<SouvenirPromptSmallPartDefinition> lazy4, Lazy<MediaReminderPromptSelector> lazy5, Lazy<FramePromptSmallPartDefinition> lazy6) {
        this.f13276a = promptsExperimentHelper;
        this.f13277b = workInlineComposerGateKeepers;
        this.f13278c = lazy;
        this.f13279d = lazy2;
        this.f13280e = lazy5;
        this.f13281f = lazy6;
        this.f13282g = lazy3;
        this.f13283h = lazy4;
    }

    public static PromptGroupPartDefinition m19544a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PromptGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13275j) {
                PromptGroupPartDefinition promptGroupPartDefinition;
                if (a2 != null) {
                    promptGroupPartDefinition = (PromptGroupPartDefinition) a2.mo818a(f13275j);
                } else {
                    promptGroupPartDefinition = f13274i;
                }
                if (promptGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19545b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13275j, b3);
                        } else {
                            f13274i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = promptGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final boolean mo2536a(Object obj) {
        return !this.f13277b.m15309a() && this.f13276a.m15314c();
    }
}
