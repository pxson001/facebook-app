package com.facebook.multirow.parts;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentView;
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
/* compiled from: nux_message */
public class ContentViewContentDescriptionPartDefinition extends BaseSinglePartDefinition<CharSequence, Void, AnyEnvironment, ContentView> {
    private static ContentViewContentDescriptionPartDefinition f7870a;
    private static final Object f7871b = new Object();

    private static ContentViewContentDescriptionPartDefinition m9505a() {
        return new ContentViewContentDescriptionPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9507a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1180535090);
        ((ContentView) view).setContentDescription((CharSequence) obj);
        Logger.a(8, EntryType.MARK_POP, -457853527, a);
    }

    public static ContentViewContentDescriptionPartDefinition m9506a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentViewContentDescriptionPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7871b) {
                ContentViewContentDescriptionPartDefinition contentViewContentDescriptionPartDefinition;
                if (a3 != null) {
                    contentViewContentDescriptionPartDefinition = (ContentViewContentDescriptionPartDefinition) a3.a(f7871b);
                } else {
                    contentViewContentDescriptionPartDefinition = f7870a;
                }
                if (contentViewContentDescriptionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9505a();
                        if (a3 != null) {
                            a3.a(f7871b, a2);
                        } else {
                            f7870a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = contentViewContentDescriptionPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
