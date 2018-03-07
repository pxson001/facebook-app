package com.facebook.feedplugins.attachments.video;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ufi/reactions/v2/84x84/anger */
public class MultiRunnableAutoplayPartDefinition<E extends HasPersistentState> extends BaseSinglePartDefinition<Props, InlineVideoPersistentState, E, View> {
    private static MultiRunnableAutoplayPartDefinition f121b;
    private static final Object f122c = new Object();
    public final CallToActionUtil f123a;

    private static MultiRunnableAutoplayPartDefinition m121b(InjectorLike injectorLike) {
        return new MultiRunnableAutoplayPartDefinition(CallToActionUtil.b(injectorLike));
    }

    public final Object m122a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        return (InlineVideoPersistentState) ((HasPersistentState) anyEnvironment).a(props.b, props.c);
    }

    public final /* bridge */ /* synthetic */ void m123a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -206911937);
        Props props = (Props) obj;
        if (!(((InlineVideoPersistentState) obj2).a && this.f123a.c(props.d))) {
            props.a.d(view);
        }
        Logger.a(8, EntryType.MARK_POP, 570539945, a);
    }

    public final void m124b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((Props) obj).a.a();
    }

    @Inject
    public MultiRunnableAutoplayPartDefinition(CallToActionUtil callToActionUtil) {
        this.f123a = callToActionUtil;
    }

    public static MultiRunnableAutoplayPartDefinition m120a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultiRunnableAutoplayPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f122c) {
                MultiRunnableAutoplayPartDefinition multiRunnableAutoplayPartDefinition;
                if (a2 != null) {
                    multiRunnableAutoplayPartDefinition = (MultiRunnableAutoplayPartDefinition) a2.a(f122c);
                } else {
                    multiRunnableAutoplayPartDefinition = f121b;
                }
                if (multiRunnableAutoplayPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m121b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f122c, b3);
                        } else {
                            f121b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = multiRunnableAutoplayPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
