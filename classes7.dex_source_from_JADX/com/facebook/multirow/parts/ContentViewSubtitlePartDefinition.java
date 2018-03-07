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
/* compiled from: nux_dismiss */
public class ContentViewSubtitlePartDefinition extends BaseSinglePartDefinition<CharSequence, Void, AnyEnvironment, ContentView> {
    private static ContentViewSubtitlePartDefinition f7874a;
    private static final Object f7875b = new Object();

    private static ContentViewSubtitlePartDefinition m9511a() {
        return new ContentViewSubtitlePartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9513a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1292267460);
        ((ContentView) view).setSubtitleText((CharSequence) obj);
        Logger.a(8, EntryType.MARK_POP, 32480360, a);
    }

    public static ContentViewSubtitlePartDefinition m9512a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentViewSubtitlePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7875b) {
                ContentViewSubtitlePartDefinition contentViewSubtitlePartDefinition;
                if (a3 != null) {
                    contentViewSubtitlePartDefinition = (ContentViewSubtitlePartDefinition) a3.a(f7875b);
                } else {
                    contentViewSubtitlePartDefinition = f7874a;
                }
                if (contentViewSubtitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9511a();
                        if (a3 != null) {
                            a3.a(f7875b, a2);
                        } else {
                            f7874a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = contentViewSubtitlePartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
