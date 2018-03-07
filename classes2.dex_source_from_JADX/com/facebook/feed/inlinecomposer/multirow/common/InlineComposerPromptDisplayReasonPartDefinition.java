package com.facebook.feed.inlinecomposer.multirow.common;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.inlinecomposer.abtest.ExperimentsForInlineComposerTestModule;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptDisplayReasonView;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.model.PromptDisplayReason;
import javax.inject.Inject;

@ContextScoped
/* compiled from: mqtt_publish_send */
public class InlineComposerPromptDisplayReasonPartDefinition<V extends View & HasPromptDisplayReasonView & HasPromptFlyout> extends BaseSinglePartDefinition<PromptDisplayReason, Void, AnyEnvironment, V> {
    private static InlineComposerPromptDisplayReasonPartDefinition f13255d;
    private static final Object f13256e = new Object();
    private final PromptsExperimentHelper f13257a;
    private final TopPromptDisplayReasonPartDefinition f13258b;
    private final HiddenPromptDisplayReasonPartDefinition f13259c;

    private static InlineComposerPromptDisplayReasonPartDefinition m19510b(InjectorLike injectorLike) {
        return new InlineComposerPromptDisplayReasonPartDefinition(PromptsExperimentHelper.m15312b(injectorLike), TopPromptDisplayReasonPartDefinition.m19513a(injectorLike), HiddenPromptDisplayReasonPartDefinition.m19516a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        PromptDisplayReason promptDisplayReason = (PromptDisplayReason) obj;
        Object obj3 = 1;
        if (this.f13257a.f10219a.mo572a(ExperimentsForInlineComposerTestModule.f12762g, 0) != 1) {
            obj3 = null;
        }
        if (obj3 == null || promptDisplayReason == null || promptDisplayReason.textWithEntities == null || promptDisplayReason.textWithEntities.a() == null) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 != null) {
            subParts.mo2756a(this.f13258b, promptDisplayReason);
        } else {
            subParts.mo2756a(this.f13259c, promptDisplayReason);
        }
        return null;
    }

    @Inject
    public InlineComposerPromptDisplayReasonPartDefinition(PromptsExperimentHelper promptsExperimentHelper, TopPromptDisplayReasonPartDefinition topPromptDisplayReasonPartDefinition, HiddenPromptDisplayReasonPartDefinition hiddenPromptDisplayReasonPartDefinition) {
        this.f13257a = promptsExperimentHelper;
        this.f13258b = topPromptDisplayReasonPartDefinition;
        this.f13259c = hiddenPromptDisplayReasonPartDefinition;
    }

    public static InlineComposerPromptDisplayReasonPartDefinition m19509a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerPromptDisplayReasonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13256e) {
                InlineComposerPromptDisplayReasonPartDefinition inlineComposerPromptDisplayReasonPartDefinition;
                if (a2 != null) {
                    inlineComposerPromptDisplayReasonPartDefinition = (InlineComposerPromptDisplayReasonPartDefinition) a2.mo818a(f13256e);
                } else {
                    inlineComposerPromptDisplayReasonPartDefinition = f13255d;
                }
                if (inlineComposerPromptDisplayReasonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19510b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13256e, b3);
                        } else {
                            f13255d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerPromptDisplayReasonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
