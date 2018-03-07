package com.facebook.reaction.feed.common;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
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

@ContextScoped
/* compiled from: bellerophon_skip */
public class BasicReactionTextPartDefinition extends BaseSinglePartDefinition<String, Void, AnyEnvironment, TextView> {
    private static BasicReactionTextPartDefinition f18967a;
    private static final Object f18968b = new Object();

    private static BasicReactionTextPartDefinition m22989a() {
        return new BasicReactionTextPartDefinition();
    }

    public final Object m22991a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return (Void) super.a(subParts, (String) obj, anyEnvironment);
    }

    public final /* bridge */ /* synthetic */ void m22992a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2094466619);
        ((TextView) view).setText((String) obj);
        Logger.a(8, EntryType.MARK_POP, 1794457727, a);
    }

    public static BasicReactionTextPartDefinition m22990a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicReactionTextPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f18968b) {
                BasicReactionTextPartDefinition basicReactionTextPartDefinition;
                if (a3 != null) {
                    basicReactionTextPartDefinition = (BasicReactionTextPartDefinition) a3.a(f18968b);
                } else {
                    basicReactionTextPartDefinition = f18967a;
                }
                if (basicReactionTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m22989a();
                        if (a3 != null) {
                            a3.a(f18968b, a2);
                        } else {
                            f18967a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = basicReactionTextPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
