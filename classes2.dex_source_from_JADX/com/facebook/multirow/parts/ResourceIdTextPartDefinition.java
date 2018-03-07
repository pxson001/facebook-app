package com.facebook.multirow.parts;

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

@ContextScoped
/* compiled from: in_login_flow */
public class ResourceIdTextPartDefinition extends BaseSinglePartDefinition<Integer, Void, AnyEnvironment, TextView> {
    private static ResourceIdTextPartDefinition f20273a;
    private static final Object f20274b = new Object();

    private static ResourceIdTextPartDefinition m27942a() {
        return new ResourceIdTextPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2136893978);
        ((TextView) view).setText(((Integer) obj).intValue());
        Logger.a(8, EntryType.MARK_POP, -1240811922, a);
    }

    public static ResourceIdTextPartDefinition m27943a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ResourceIdTextPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f20274b) {
                ResourceIdTextPartDefinition resourceIdTextPartDefinition;
                if (a3 != null) {
                    resourceIdTextPartDefinition = (ResourceIdTextPartDefinition) a3.mo818a(f20274b);
                } else {
                    resourceIdTextPartDefinition = f20273a;
                }
                if (resourceIdTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m27942a();
                        if (a3 != null) {
                            a3.mo822a(f20274b, a2);
                        } else {
                            f20273a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = resourceIdTextPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
