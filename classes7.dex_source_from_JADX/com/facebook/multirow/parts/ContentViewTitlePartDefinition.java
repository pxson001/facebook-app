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
/* compiled from: number_of_stickers_added */
public class ContentViewTitlePartDefinition extends BaseSinglePartDefinition<CharSequence, Void, AnyEnvironment, ContentView> {
    private static ContentViewTitlePartDefinition f7880a;
    private static final Object f7881b = new Object();

    private static ContentViewTitlePartDefinition m9520a() {
        return new ContentViewTitlePartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9522a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 992317279);
        ((ContentView) view).setTitleText((CharSequence) obj);
        Logger.a(8, EntryType.MARK_POP, 1605009116, a);
    }

    public static ContentViewTitlePartDefinition m9521a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentViewTitlePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7881b) {
                ContentViewTitlePartDefinition contentViewTitlePartDefinition;
                if (a3 != null) {
                    contentViewTitlePartDefinition = (ContentViewTitlePartDefinition) a3.a(f7881b);
                } else {
                    contentViewTitlePartDefinition = f7880a;
                }
                if (contentViewTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9520a();
                        if (a3 != null) {
                            a3.a(f7881b, a2);
                        } else {
                            f7880a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = contentViewTitlePartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
