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
/* compiled from: nux_impression */
public class ContentViewMetaTextPartDefinition extends BaseSinglePartDefinition<CharSequence, Void, AnyEnvironment, ContentView> {
    private static ContentViewMetaTextPartDefinition f7872a;
    private static final Object f7873b = new Object();

    private static ContentViewMetaTextPartDefinition m9508a() {
        return new ContentViewMetaTextPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9510a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1073615842);
        ((ContentView) view).setMetaText((CharSequence) obj);
        Logger.a(8, EntryType.MARK_POP, -1170573374, a);
    }

    public static ContentViewMetaTextPartDefinition m9509a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentViewMetaTextPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7873b) {
                ContentViewMetaTextPartDefinition contentViewMetaTextPartDefinition;
                if (a3 != null) {
                    contentViewMetaTextPartDefinition = (ContentViewMetaTextPartDefinition) a3.a(f7873b);
                } else {
                    contentViewMetaTextPartDefinition = f7872a;
                }
                if (contentViewMetaTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9508a();
                        if (a3 != null) {
                            a3.a(f7873b, a2);
                        } else {
                            f7872a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = contentViewMetaTextPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
