package com.facebook.feedplugins.friendingcommon;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.friends.ui.SmartButtonLite;
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

@ContextScoped
/* compiled from: TOTAL_SYS_CPU_TIME */
public class SmartButtonTextPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, SmartButtonLite> {
    private static SmartButtonTextPartDefinition f24658a;
    private static final Object f24659b = new Object();

    /* compiled from: TOTAL_SYS_CPU_TIME */
    public class Props {
        public final CharSequence f24656a;
        @Nullable
        public final CharSequence f24657b;

        public Props(CharSequence charSequence, CharSequence charSequence2) {
            this.f24656a = charSequence;
            this.f24657b = charSequence2;
        }
    }

    private static SmartButtonTextPartDefinition m26548a() {
        return new SmartButtonTextPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m26550a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1607504924);
        Props props = (Props) obj;
        ((SmartButtonLite) view).a(props.f24656a, props.f24657b);
        Logger.a(8, EntryType.MARK_POP, -471349093, a);
    }

    public static SmartButtonTextPartDefinition m26549a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SmartButtonTextPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f24659b) {
                SmartButtonTextPartDefinition smartButtonTextPartDefinition;
                if (a3 != null) {
                    smartButtonTextPartDefinition = (SmartButtonTextPartDefinition) a3.a(f24659b);
                } else {
                    smartButtonTextPartDefinition = f24658a;
                }
                if (smartButtonTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m26548a();
                        if (a3 != null) {
                            a3.a(f24659b, a2);
                        } else {
                            f24658a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = smartButtonTextPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
