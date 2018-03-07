package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;

@ContextScoped
@Deprecated
/* compiled from: fetch_zero_header_request */
public class AngoraClearPartDefinition<V extends View & AttachmentHasClear> extends BaseSinglePartDefinition<Void, Void, AnyEnvironment, V> {
    private static AngoraClearPartDefinition f23830a;
    private static final Object f23831b = new Object();

    private static AngoraClearPartDefinition m32223a() {
        return new AngoraClearPartDefinition();
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasClear) view).a();
    }

    public static AngoraClearPartDefinition m32224a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AngoraClearPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f23831b) {
                AngoraClearPartDefinition angoraClearPartDefinition;
                if (a3 != null) {
                    angoraClearPartDefinition = (AngoraClearPartDefinition) a3.mo818a(f23831b);
                } else {
                    angoraClearPartDefinition = f23830a;
                }
                if (angoraClearPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m32223a();
                        if (a3 != null) {
                            a3.mo822a(f23831b, a2);
                        } else {
                            f23830a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = angoraClearPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
