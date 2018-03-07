package com.facebook.productionprompts;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.feed.inlinecomposer.multirow.common.views.V2PromptFlyoutView;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.multirow.api.ViewType;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.ClipboardPromptObject;
import javax.inject.Inject;

@ContextScoped
/* compiled from: resize */
public class ClipboardPromptsPromptPartDefinition<E extends HasPersistentState & PromptViewStateUpdater, V extends View & HasPromptFlyout> extends ProductionPromptsPromptPartDefinition<E, V> {
    public static final ViewType f4490a = new C05891();
    private static ClipboardPromptsPromptPartDefinition f4491c;
    private static final Object f4492d = new Object();

    /* compiled from: resize */
    final class C05891 extends ViewType {
        C05891() {
        }

        public final View m4326a(Context context) {
            V2PromptFlyoutView v2PromptFlyoutView = new V2PromptFlyoutView(context);
            v2PromptFlyoutView.getAttachmentInsertPoint().addView(new ClipboardPromptV2Attachment(context).m4325a());
            return v2PromptFlyoutView;
        }
    }

    private static ClipboardPromptsPromptPartDefinition m4338c(InjectorLike injectorLike) {
        return new ClipboardPromptsPromptPartDefinition(InlineComposerPromptActionHandler.b(injectorLike), InlineComposerPromptFlyoutPartDefinition.a(injectorLike), PromptActionContextFactory.b(injectorLike), InlineComposerPersistentStateHelper.b(injectorLike));
    }

    @Inject
    public ClipboardPromptsPromptPartDefinition(InlineComposerPromptActionHandler inlineComposerPromptActionHandler, InlineComposerPromptFlyoutPartDefinition inlineComposerPromptFlyoutPartDefinition, PromptActionContextFactory promptActionContextFactory, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper) {
        super(inlineComposerPromptActionHandler, promptActionContextFactory, inlineComposerPromptFlyoutPartDefinition, inlineComposerPersistentStateHelper);
    }

    public final ViewType mo203a() {
        return f4490a;
    }

    public final boolean mo206a(PromptPartDefinitionProps promptPartDefinitionProps) {
        return promptPartDefinitionProps != null && promptPartDefinitionProps.a.a.c().equals(GraphQLPromptType.CLIPBOARD.toString());
    }

    public static ClipboardPromptsPromptPartDefinition m4337a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ClipboardPromptsPromptPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4492d) {
                ClipboardPromptsPromptPartDefinition clipboardPromptsPromptPartDefinition;
                if (a2 != null) {
                    clipboardPromptsPromptPartDefinition = (ClipboardPromptsPromptPartDefinition) a2.a(f4492d);
                } else {
                    clipboardPromptsPromptPartDefinition = f4491c;
                }
                if (clipboardPromptsPromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        c = m4338c(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4492d, c);
                        } else {
                            f4491c = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = clipboardPromptsPromptPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }

    public final void mo204a(PromptPartDefinitionProps promptPartDefinitionProps, OnClickListener onClickListener, E e, V v) {
        super.mo204a(promptPartDefinitionProps, onClickListener, (HasPersistentState) e, (View) v);
        ((TextView) ((HasPromptFlyout) v).getV2AttachmentView()).setText(((ClipboardPromptObject) promptPartDefinitionProps.a.a).a.f());
        ((HasPromptFlyout) v).getAttachmentInsertPoint().setVisibility(0);
    }

    public final void mo208b(PromptPartDefinitionProps promptPartDefinitionProps, OnClickListener onClickListener, E e, V v) {
        super.mo208b(promptPartDefinitionProps, onClickListener, (HasPersistentState) e, (View) v);
        ((TextView) ((HasPromptFlyout) v).getV2AttachmentView()).setText(null);
        ((HasPromptFlyout) v).getAttachmentInsertPoint().setVisibility(8);
    }
}
