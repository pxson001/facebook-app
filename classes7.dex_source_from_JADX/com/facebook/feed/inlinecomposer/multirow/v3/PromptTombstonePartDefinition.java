package com.facebook.feed.inlinecomposer.multirow.v3;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.productionprompts.model.PromptViewState.Visibility;

@ContextScoped
/* compiled from: android.intent.extra.ringtone.TYPE */
public class PromptTombstonePartDefinition<E extends AnyEnvironment> extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, Void, E, PromptTombstoneView> {
    public static final ViewType f19312a = new C16781();
    private static PromptTombstonePartDefinition f19313b;
    private static final Object f19314c = new Object();

    /* compiled from: android.intent.extra.ringtone.TYPE */
    final class C16781 extends ViewType {
        C16781() {
        }

        public final View m22785a(Context context) {
            return new PromptTombstoneView(context);
        }
    }

    private static PromptTombstonePartDefinition m22787b() {
        return new PromptTombstonePartDefinition();
    }

    public final boolean m22789a(Object obj) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        return (promptPartDefinitionProps.a == null || promptPartDefinitionProps.a.c == null || promptPartDefinitionProps.a.c.a != Visibility.DISMISSED) ? false : true;
    }

    public final ViewType<PromptTombstoneView> m22788a() {
        return f19312a;
    }

    public static PromptTombstonePartDefinition m22786a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PromptTombstonePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19314c) {
                PromptTombstonePartDefinition promptTombstonePartDefinition;
                if (a2 != null) {
                    promptTombstonePartDefinition = (PromptTombstonePartDefinition) a2.a(f19314c);
                } else {
                    promptTombstonePartDefinition = f19313b;
                }
                if (promptTombstonePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m22787b();
                        if (a2 != null) {
                            a2.a(f19314c, b3);
                        } else {
                            f19313b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = promptTombstonePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
