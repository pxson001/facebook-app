package com.facebook.feed.inlinecomposer.multirow.common;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.settings. */
public class BaseV3PromptPartDefinition<V extends View & HasPromptFlyout, E extends HasPersistentState & PromptViewStateUpdater & HasPositionInformation> extends BaseSinglePartDefinition<Props, Void, E, V> {
    private static BaseV3PromptPartDefinition f19262h;
    private static final Object f19263i = new Object();
    @Inject
    public InlineComposerPromptFlyoutTitleBarPartDefinition f19264a;
    @Inject
    public PromptChevronMenuHelper f19265b;
    @Inject
    public BackgroundPartDefinition f19266c;
    @Inject
    public ClickListenerPartDefinition f19267d;
    @Inject
    public DefaultPromptActionHandlePartDefinition f19268e;
    @Inject
    public PromptImpressionLoggerPartDefinition f19269f;
    @Inject
    public InlineComposerPersistentStateHelper f19270g;

    /* compiled from: android.settings. */
    public class Props {
        PromptPartDefinitionProps f19260a;
        boolean f19261b;

        public Props(PromptPartDefinitionProps promptPartDefinitionProps, boolean z) {
            this.f19260a = promptPartDefinitionProps;
            this.f19261b = z;
        }

        public static Props m22759a(PromptPartDefinitionProps promptPartDefinitionProps) {
            return new Props(promptPartDefinitionProps, true);
        }
    }

    private static BaseV3PromptPartDefinition m22762b(InjectorLike injectorLike) {
        BaseV3PromptPartDefinition baseV3PromptPartDefinition = new BaseV3PromptPartDefinition(InlineComposerPromptFlyoutTitleBarPartDefinition.a(injectorLike), PromptChevronMenuHelper.m22773a(injectorLike), BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), DefaultPromptActionHandlePartDefinition.m22764a(injectorLike), PromptImpressionLoggerPartDefinition.a(injectorLike), InlineComposerPersistentStateHelper.b(injectorLike));
        baseV3PromptPartDefinition.m22761a(InlineComposerPromptFlyoutTitleBarPartDefinition.a(injectorLike), PromptChevronMenuHelper.m22773a(injectorLike), BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), DefaultPromptActionHandlePartDefinition.m22764a(injectorLike), PromptImpressionLoggerPartDefinition.a(injectorLike), InlineComposerPersistentStateHelper.b(injectorLike));
        return baseV3PromptPartDefinition;
    }

    public final Object m22763a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        subParts.a(this.f19266c, new StylingData(PaddingStyle.i));
        this.f19265b.m22775a(props.f19260a);
        subParts.a(2131560877, this.f19267d, this.f19265b.m22775a(props.f19260a));
        if (props.f19261b) {
            subParts.a(this.f19268e, props.f19260a);
        }
        subParts.a(this.f19264a, new com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPromptFlyoutTitleBarPartDefinition.Props(props.f19260a.c));
        subParts.a(this.f19269f, new com.facebook.feed.inlinecomposer.multirow.common.PromptImpressionLoggerPartDefinition.Props(props.f19260a.c, props.f19260a.a, hasPersistentState, props.f19260a.b));
        return null;
    }

    private void m22761a(InlineComposerPromptFlyoutTitleBarPartDefinition inlineComposerPromptFlyoutTitleBarPartDefinition, PromptChevronMenuHelper promptChevronMenuHelper, BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, DefaultPromptActionHandlePartDefinition defaultPromptActionHandlePartDefinition, PromptImpressionLoggerPartDefinition promptImpressionLoggerPartDefinition, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper) {
        this.f19264a = inlineComposerPromptFlyoutTitleBarPartDefinition;
        this.f19265b = promptChevronMenuHelper;
        this.f19266c = backgroundPartDefinition;
        this.f19267d = clickListenerPartDefinition;
        this.f19268e = defaultPromptActionHandlePartDefinition;
        this.f19269f = promptImpressionLoggerPartDefinition;
        this.f19270g = inlineComposerPersistentStateHelper;
    }

    public static BaseV3PromptPartDefinition m22760a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BaseV3PromptPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19263i) {
                BaseV3PromptPartDefinition baseV3PromptPartDefinition;
                if (a2 != null) {
                    baseV3PromptPartDefinition = (BaseV3PromptPartDefinition) a2.a(f19263i);
                } else {
                    baseV3PromptPartDefinition = f19262h;
                }
                if (baseV3PromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22762b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19263i, b3);
                        } else {
                            f19262h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = baseV3PromptPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public BaseV3PromptPartDefinition(InlineComposerPromptFlyoutTitleBarPartDefinition inlineComposerPromptFlyoutTitleBarPartDefinition, PromptChevronMenuHelper promptChevronMenuHelper, BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, DefaultPromptActionHandlePartDefinition defaultPromptActionHandlePartDefinition, PromptImpressionLoggerPartDefinition promptImpressionLoggerPartDefinition, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper) {
        this.f19264a = inlineComposerPromptFlyoutTitleBarPartDefinition;
        this.f19265b = promptChevronMenuHelper;
        this.f19266c = backgroundPartDefinition;
        this.f19267d = clickListenerPartDefinition;
        this.f19268e = defaultPromptActionHandlePartDefinition;
        this.f19269f = promptImpressionLoggerPartDefinition;
        this.f19270g = inlineComposerPersistentStateHelper;
    }
}
