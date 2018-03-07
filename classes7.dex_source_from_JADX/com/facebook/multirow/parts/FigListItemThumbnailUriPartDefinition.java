package com.facebook.multirow.parts;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fig.listitem.FigListItem;
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
/* compiled from: num_of_mutual_friends */
public class FigListItemThumbnailUriPartDefinition extends BaseSinglePartDefinition<Uri, Void, AnyEnvironment, FigListItem> {
    private static FigListItemThumbnailUriPartDefinition f7914a;
    private static final Object f7915b = new Object();

    private static FigListItemThumbnailUriPartDefinition m9545a() {
        return new FigListItemThumbnailUriPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9547a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1145036292);
        ((FigListItem) view).setThumbnailUri((Uri) obj);
        Logger.a(8, EntryType.MARK_POP, 1356118314, a);
    }

    public static FigListItemThumbnailUriPartDefinition m9546a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FigListItemThumbnailUriPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7915b) {
                FigListItemThumbnailUriPartDefinition figListItemThumbnailUriPartDefinition;
                if (a3 != null) {
                    figListItemThumbnailUriPartDefinition = (FigListItemThumbnailUriPartDefinition) a3.a(f7915b);
                } else {
                    figListItemThumbnailUriPartDefinition = f7914a;
                }
                if (figListItemThumbnailUriPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9545a();
                        if (a3 != null) {
                            a3.a(f7915b, a2);
                        } else {
                            f7914a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = figListItemThumbnailUriPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
