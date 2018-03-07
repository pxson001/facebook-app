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
/* compiled from: number_of_stickers_removed */
public class ContentViewThumbnailUriStringPartDefinition extends BaseSinglePartDefinition<String, Void, AnyEnvironment, ContentView> {
    private static ContentViewThumbnailUriStringPartDefinition f7878a;
    private static final Object f7879b = new Object();

    private static ContentViewThumbnailUriStringPartDefinition m9517a() {
        return new ContentViewThumbnailUriStringPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9519a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1593305691);
        ((ContentView) view).setThumbnailUri((String) obj);
        Logger.a(8, EntryType.MARK_POP, -133417658, a);
    }

    public static ContentViewThumbnailUriStringPartDefinition m9518a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentViewThumbnailUriStringPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7879b) {
                ContentViewThumbnailUriStringPartDefinition contentViewThumbnailUriStringPartDefinition;
                if (a3 != null) {
                    contentViewThumbnailUriStringPartDefinition = (ContentViewThumbnailUriStringPartDefinition) a3.a(f7879b);
                } else {
                    contentViewThumbnailUriStringPartDefinition = f7878a;
                }
                if (contentViewThumbnailUriStringPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9517a();
                        if (a3 != null) {
                            a3.a(f7879b, a2);
                        } else {
                            f7878a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = contentViewThumbnailUriStringPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
