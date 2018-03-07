package com.facebook.friendsharing.souvenirs.prompt;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerEnvironment;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutPartDefinition.Props;
import com.facebook.feed.inlinecomposer.multirow.common.views.V2PromptFlyoutView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.friendsharing.souvenirs.manager.SouvenirPromptManager;
import com.facebook.friendsharing.souvenirs.prompt.model.SouvenirPromptObject;
import com.facebook.friendsharing.souvenirs.util.SouvenirsLogger;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REQUIRED_CHECKBOX_ERROR */
public class SouvenirPromptsPromptPartDefinition extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, State, InlineComposerEnvironment, V2PromptFlyoutView> {
    public static final ViewType f24110a = new C20991();
    private static SouvenirPromptsPromptPartDefinition f24111i;
    private static final Object f24112j = new Object();
    private final InlineComposerPromptFlyoutPartDefinition f24113b;
    private final SouvenirPromptTitleGenerator f24114c;
    public final SouvenirsLogger f24115d;
    public final SouvenirPromptManager f24116e;
    public final InlineComposerPromptActionHandler f24117f;
    public final PromptActionContextFactory f24118g;
    private final InlineComposerPersistentStateHelper f24119h;

    /* compiled from: REQUIRED_CHECKBOX_ERROR */
    final class C20991 extends ViewType {
        C20991() {
        }

        public final View m26231a(Context context) {
            Object v2PromptFlyoutView = new V2PromptFlyoutView(context);
            v2PromptFlyoutView.getAttachmentInsertPoint().addView(new SouvenirPromptAttachment(context).mo1476a());
            return v2PromptFlyoutView;
        }
    }

    /* compiled from: REQUIRED_CHECKBOX_ERROR */
    public class State {
        public final Uri f24105a;
        public final String f24106b;
        public final SpannableStringBuilder f24107c;
        public final OnClickListener f24108d;
        public boolean f24109e = false;

        public State(Uri uri, String str, SpannableStringBuilder spannableStringBuilder, OnClickListener onClickListener) {
            this.f24105a = uri;
            this.f24106b = str;
            this.f24107c = spannableStringBuilder;
            this.f24108d = onClickListener;
        }
    }

    private static SouvenirPromptsPromptPartDefinition m26233b(InjectorLike injectorLike) {
        return new SouvenirPromptsPromptPartDefinition(InlineComposerPromptFlyoutPartDefinition.a(injectorLike), SouvenirPromptTitleGenerator.b(injectorLike), SouvenirsLogger.b(injectorLike), SouvenirPromptManager.a(injectorLike), InlineComposerPromptActionHandler.b(injectorLike), PromptActionContextFactory.b(injectorLike), InlineComposerPersistentStateHelper.b(injectorLike));
    }

    public final Object m26235a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        InlineComposerEnvironment inlineComposerEnvironment = (InlineComposerEnvironment) anyEnvironment;
        subParts.a(this.f24113b, new Props(promptPartDefinitionProps.c, promptPartDefinitionProps.c.g(), promptPartDefinitionProps.a, promptPartDefinitionProps.b, this.f24119h.b(promptPartDefinitionProps.a)));
        SouvenirPromptObject souvenirPromptObject = (SouvenirPromptObject) promptPartDefinitionProps.a.a;
        return new State(souvenirPromptObject.m26256e(), this.f24114c.a(souvenirPromptObject), this.f24114c.a(inlineComposerEnvironment.getContext().getResources(), inlineComposerEnvironment.getContext().getString(2131238467)), new OnClickListener(this) {
            final /* synthetic */ SouvenirPromptsPromptPartDefinition f24104b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1571591908);
                Preconditions.checkNotNull(promptPartDefinitionProps.a);
                this.f24104b.f24117f.a(view, promptPartDefinitionProps.a, this.f24104b.f24118g.a(promptPartDefinitionProps.a).a());
                Logger.a(2, EntryType.UI_INPUT_END, -1216758351, a);
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m26236a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 428944116);
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        State state = (State) obj2;
        V2PromptFlyoutView v2PromptFlyoutView = (V2PromptFlyoutView) view;
        v2PromptFlyoutView.getV2AttachmentView();
        ((SouvenirPromptAttachment) v2PromptFlyoutView.getV2AttachmentView()).m26218a(state.f24105a, state.f24106b, state.f24107c);
        v2PromptFlyoutView.getFlyoutView().setOnClickListener(state.f24108d);
        v2PromptFlyoutView.getAttachmentInsertPoint().setVisibility(0);
        PromptObject a2 = InlineComposerPromptSession.a(promptPartDefinitionProps.a);
        Preconditions.checkArgument(a2 instanceof SouvenirPromptObject, "Didn't get a souvenir prompt object");
        SouvenirPromptObject souvenirPromptObject = (SouvenirPromptObject) a2;
        if (!state.f24109e) {
            this.f24115d.b(souvenirPromptObject);
            this.f24116e.a(a2.b());
            state.f24109e = true;
        }
        Logger.a(8, EntryType.MARK_POP, 136105645, a);
    }

    public final boolean m26237a(Object obj) {
        return InlineComposerPromptSession.a(((PromptPartDefinitionProps) obj).a) instanceof SouvenirPromptObject;
    }

    public final void m26238b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        V2PromptFlyoutView v2PromptFlyoutView = (V2PromptFlyoutView) view;
        v2PromptFlyoutView.getFlyoutView().setOnClickListener(null);
        v2PromptFlyoutView.getAttachmentInsertPoint().setVisibility(8);
    }

    public static SouvenirPromptsPromptPartDefinition m26232a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SouvenirPromptsPromptPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24112j) {
                SouvenirPromptsPromptPartDefinition souvenirPromptsPromptPartDefinition;
                if (a2 != null) {
                    souvenirPromptsPromptPartDefinition = (SouvenirPromptsPromptPartDefinition) a2.a(f24112j);
                } else {
                    souvenirPromptsPromptPartDefinition = f24111i;
                }
                if (souvenirPromptsPromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26233b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24112j, b3);
                        } else {
                            f24111i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = souvenirPromptsPromptPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SouvenirPromptsPromptPartDefinition(InlineComposerPromptFlyoutPartDefinition inlineComposerPromptFlyoutPartDefinition, SouvenirPromptTitleGenerator souvenirPromptTitleGenerator, SouvenirsLogger souvenirsLogger, SouvenirPromptManager souvenirPromptManager, InlineComposerPromptActionHandler inlineComposerPromptActionHandler, PromptActionContextFactory promptActionContextFactory, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper) {
        this.f24113b = inlineComposerPromptFlyoutPartDefinition;
        this.f24114c = souvenirPromptTitleGenerator;
        this.f24115d = souvenirsLogger;
        this.f24116e = souvenirPromptManager;
        this.f24117f = inlineComposerPromptActionHandler;
        this.f24118g = promptActionContextFactory;
        this.f24119h = inlineComposerPersistentStateHelper;
    }

    public final ViewType m26234a() {
        return f24110a;
    }
}
