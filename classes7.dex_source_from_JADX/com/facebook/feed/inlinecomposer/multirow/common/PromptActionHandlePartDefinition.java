package com.facebook.feed.inlinecomposer.multirow.common;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.permission.CAMERA */
public class PromptActionHandlePartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, View> {
    private static PromptActionHandlePartDefinition f19280c;
    private static final Object f19281d = new Object();
    private final ClickListenerPartDefinition f19282a;
    public final InlineComposerPromptActionHandler f19283b;

    /* compiled from: android.permission.CAMERA */
    public class Props {
        public final PromptActionContextImpl f19278a;
        public final PromptPartDefinitionProps f19279b;

        private Props(PromptActionContextImpl promptActionContextImpl, PromptPartDefinitionProps promptPartDefinitionProps) {
            this.f19278a = promptActionContextImpl;
            this.f19279b = promptPartDefinitionProps;
        }

        public static Props m22769a(PromptActionContextImpl promptActionContextImpl, PromptPartDefinitionProps promptPartDefinitionProps) {
            return new Props(promptActionContextImpl, promptPartDefinitionProps);
        }
    }

    private static PromptActionHandlePartDefinition m22771b(InjectorLike injectorLike) {
        return new PromptActionHandlePartDefinition(ClickListenerPartDefinition.a(injectorLike), InlineComposerPromptActionHandler.b(injectorLike));
    }

    public final Object m22772a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        subParts.a(this.f19282a, new OnClickListener(this) {
            final /* synthetic */ PromptActionHandlePartDefinition f19277b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1708842841);
                this.f19277b.f19283b.a(view, props.f19279b.a, props.f19278a);
                Logger.a(2, EntryType.UI_INPUT_END, -1244006787, a);
            }
        });
        return null;
    }

    @Inject
    public PromptActionHandlePartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, InlineComposerPromptActionHandler inlineComposerPromptActionHandler) {
        this.f19282a = clickListenerPartDefinition;
        this.f19283b = inlineComposerPromptActionHandler;
    }

    public static PromptActionHandlePartDefinition m22770a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PromptActionHandlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19281d) {
                PromptActionHandlePartDefinition promptActionHandlePartDefinition;
                if (a2 != null) {
                    promptActionHandlePartDefinition = (PromptActionHandlePartDefinition) a2.a(f19281d);
                } else {
                    promptActionHandlePartDefinition = f19280c;
                }
                if (promptActionHandlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22771b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19281d, b3);
                        } else {
                            f19280c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = promptActionHandlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
