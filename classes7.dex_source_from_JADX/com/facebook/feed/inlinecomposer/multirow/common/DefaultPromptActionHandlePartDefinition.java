package com.facebook.feed.inlinecomposer.multirow.common;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.inlinecomposer.multirow.common.PromptActionHandlePartDefinition.Props;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.provider.Telephony.ACTION_CHANGE_DEFAULT */
public class DefaultPromptActionHandlePartDefinition extends BaseSinglePartDefinition<PromptPartDefinitionProps, Void, AnyEnvironment, View> {
    private static DefaultPromptActionHandlePartDefinition f19271c;
    private static final Object f19272d = new Object();
    private final PromptActionContextFactory f19273a;
    private final PromptActionHandlePartDefinition f19274b;

    private static DefaultPromptActionHandlePartDefinition m22765b(InjectorLike injectorLike) {
        return new DefaultPromptActionHandlePartDefinition(PromptActionContextFactory.b(injectorLike), PromptActionHandlePartDefinition.m22770a(injectorLike));
    }

    public final Object m22766a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        subParts.a(this.f19274b, Props.m22769a(this.f19273a.a(promptPartDefinitionProps.a).a(), promptPartDefinitionProps));
        return null;
    }

    @Inject
    public DefaultPromptActionHandlePartDefinition(PromptActionContextFactory promptActionContextFactory, PromptActionHandlePartDefinition promptActionHandlePartDefinition) {
        this.f19273a = promptActionContextFactory;
        this.f19274b = promptActionHandlePartDefinition;
    }

    public static DefaultPromptActionHandlePartDefinition m22764a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultPromptActionHandlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19272d) {
                DefaultPromptActionHandlePartDefinition defaultPromptActionHandlePartDefinition;
                if (a2 != null) {
                    defaultPromptActionHandlePartDefinition = (DefaultPromptActionHandlePartDefinition) a2.a(f19272d);
                } else {
                    defaultPromptActionHandlePartDefinition = f19271c;
                }
                if (defaultPromptActionHandlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22765b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19272d, b3);
                        } else {
                            f19271c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultPromptActionHandlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
