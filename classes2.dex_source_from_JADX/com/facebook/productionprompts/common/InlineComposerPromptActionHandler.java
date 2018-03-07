package com.facebook.productionprompts.common;

import android.view.View;
import com.facebook.feed.photoreminder.model.PhotoReminderPromptObject;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.HasPromptSessionId;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.SetsComposerSessionId;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextInterfaces.TapOnV1SecondaryAction;
import com.facebook.ipc.productionprompts.actionhandler.C0536x514af43f;
import com.facebook.ipc.productionprompts.actionhandler.DelegatingPromptActionHandler;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionContext;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionHandler;
import com.facebook.productionprompts.logging.ProductionPromptsLogger;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptObject;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: money_penny_place_order */
public class InlineComposerPromptActionHandler<CONTEXT extends PromptActionContext & HasPromptSessionId & SetsComposerSessionId & TapOnV1SecondaryAction> extends DelegatingPromptActionHandler<CONTEXT> {
    private final ProductionPromptsLogger f13338b;

    public static InlineComposerPromptActionHandler m19641b(InjectorLike injectorLike) {
        return new InlineComposerPromptActionHandler(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0536x514af43f(injectorLike)), ProductionPromptsLogger.m18862a(injectorLike));
    }

    @Inject
    public InlineComposerPromptActionHandler(Set<PromptActionHandler> set, ProductionPromptsLogger productionPromptsLogger) {
        super(set);
        this.f13338b = productionPromptsLogger;
    }

    public final boolean mo2621b(InlineComposerPromptSession inlineComposerPromptSession) {
        return true;
    }

    public final void mo2620a(View view, InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        if (((PromptActionContextImpl) context).e()) {
            m19642b(inlineComposerPromptSession, context);
        } else {
            m19640a(inlineComposerPromptSession, context);
        }
        super.mo2620a(view, inlineComposerPromptSession, context);
    }

    private void m19640a(InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        if (!(InlineComposerPromptSession.m19774a(inlineComposerPromptSession) instanceof PhotoReminderPromptObject)) {
            ((PromptActionContextImpl) context).a(this.f13338b.m18867a(inlineComposerPromptSession, ((PromptActionContextImpl) context).a));
        }
    }

    private void m19642b(InlineComposerPromptSession inlineComposerPromptSession, CONTEXT context) {
        PromptObject a = InlineComposerPromptSession.m19774a(inlineComposerPromptSession);
        if (a instanceof ProductionPromptObject) {
            ((PromptActionContextImpl) context).a(this.f13338b.m18868a(((ProductionPromptObject) a).f12765a, ((PromptActionContextImpl) context).a));
        }
    }
}
