package com.facebook.multirow.parts;

import android.content.Context;
import android.net.Uri;
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
/* compiled from: number_of_tags_removed */
public class ContentViewThumbnailUriPartDefinition extends BaseSinglePartDefinition<Uri, Void, AnyEnvironment, ContentView> {
    private static ContentViewThumbnailUriPartDefinition f7876a;
    private static final Object f7877b = new Object();

    private static ContentViewThumbnailUriPartDefinition m9514a() {
        return new ContentViewThumbnailUriPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9516a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2011808416);
        ((ContentView) view).setThumbnailUri((Uri) obj);
        Logger.a(8, EntryType.MARK_POP, 38588072, a);
    }

    public static ContentViewThumbnailUriPartDefinition m9515a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentViewThumbnailUriPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7877b) {
                ContentViewThumbnailUriPartDefinition contentViewThumbnailUriPartDefinition;
                if (a3 != null) {
                    contentViewThumbnailUriPartDefinition = (ContentViewThumbnailUriPartDefinition) a3.a(f7877b);
                } else {
                    contentViewThumbnailUriPartDefinition = f7876a;
                }
                if (contentViewThumbnailUriPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9514a();
                        if (a3 != null) {
                            a3.a(f7877b, a2);
                        } else {
                            f7876a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = contentViewThumbnailUriPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
