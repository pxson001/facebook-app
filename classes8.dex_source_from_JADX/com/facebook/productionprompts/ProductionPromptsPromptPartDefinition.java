package com.facebook.productionprompts;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutPartDefinition.Props;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.feed.inlinecomposer.multirow.common.views.V2PromptFlyoutView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import javax.inject.Inject;

@ContextScoped
/* compiled from: reshare_video */
public class ProductionPromptsPromptPartDefinition<E extends HasPersistentState & PromptViewStateUpdater, V extends View & HasPromptFlyout> extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, OnClickListener, E, V> {
    public static final ViewType f4483b = new C05901();
    private static ProductionPromptsPromptPartDefinition f4484f;
    private static final Object f4485g = new Object();
    public final InlineComposerPromptActionHandler f4486a;
    public final PromptActionContextFactory f4487c;
    private final InlineComposerPromptFlyoutPartDefinition f4488d;
    private final InlineComposerPersistentStateHelper f4489e;

    /* compiled from: reshare_video */
    final class C05901 extends ViewType {
        C05901() {
        }

        public final View m4360a(Context context) {
            return new V2PromptFlyoutView(context);
        }
    }

    private static ProductionPromptsPromptPartDefinition m4327a(InjectorLike injectorLike) {
        return new ProductionPromptsPromptPartDefinition(InlineComposerPromptActionHandler.b(injectorLike), PromptActionContextFactory.b(injectorLike), InlineComposerPromptFlyoutPartDefinition.a(injectorLike), InlineComposerPersistentStateHelper.b(injectorLike));
    }

    public final Object m4330a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        subParts.a(this.f4488d, new Props(promptPartDefinitionProps.c, promptPartDefinitionProps.c.g(), promptPartDefinitionProps.a, promptPartDefinitionProps.b, this.f4489e.b(promptPartDefinitionProps.a)));
        final InlineComposerPromptSession inlineComposerPromptSession = promptPartDefinitionProps.a;
        return new OnClickListener(this) {
            final /* synthetic */ ProductionPromptsPromptPartDefinition f4505b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1881925494);
                this.f4505b.f4486a.a(view, inlineComposerPromptSession, this.f4505b.f4487c.a(inlineComposerPromptSession).m1383a());
                Logger.a(2, EntryType.UI_INPUT_END, 2146939520, a);
            }
        };
    }

    public ViewType mo203a() {
        return f4483b;
    }

    @Inject
    public ProductionPromptsPromptPartDefinition(InlineComposerPromptActionHandler inlineComposerPromptActionHandler, PromptActionContextFactory promptActionContextFactory, InlineComposerPromptFlyoutPartDefinition inlineComposerPromptFlyoutPartDefinition, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper) {
        this.f4486a = inlineComposerPromptActionHandler;
        this.f4487c = promptActionContextFactory;
        this.f4488d = inlineComposerPromptFlyoutPartDefinition;
        this.f4489e = inlineComposerPersistentStateHelper;
    }

    public static ProductionPromptsPromptPartDefinition m4328b(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProductionPromptsPromptPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f4485g) {
                ProductionPromptsPromptPartDefinition productionPromptsPromptPartDefinition;
                if (a3 != null) {
                    productionPromptsPromptPartDefinition = (ProductionPromptsPromptPartDefinition) a3.a(f4485g);
                } else {
                    productionPromptsPromptPartDefinition = f4484f;
                }
                if (productionPromptsPromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        a2 = m4327a(injectorThreadStack.e());
                        if (a3 != null) {
                            a3.a(f4485g, a2);
                        } else {
                            f4484f = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = productionPromptsPromptPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }

    public boolean mo206a(PromptPartDefinitionProps promptPartDefinitionProps) {
        return (promptPartDefinitionProps == null || promptPartDefinitionProps.c == null) ? false : true;
    }

    public void mo204a(PromptPartDefinitionProps promptPartDefinitionProps, OnClickListener onClickListener, E e, V v) {
        ((HasPromptFlyout) v).getFlyoutView().setOnClickListener(onClickListener);
    }

    public void mo208b(PromptPartDefinitionProps promptPartDefinitionProps, OnClickListener onClickListener, E e, V v) {
        ((HasPromptFlyout) v).getFlyoutView().setOnClickListener(null);
    }
}
