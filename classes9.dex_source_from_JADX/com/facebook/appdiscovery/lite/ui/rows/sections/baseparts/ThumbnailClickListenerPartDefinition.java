package com.facebook.appdiscovery.lite.ui.rows.sections.baseparts;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
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
/* compiled from: selected_shipping_address */
public class ThumbnailClickListenerPartDefinition extends BaseSinglePartDefinition<OnClickListener, Void, AnyEnvironment, ImageBlockLayout> {
    private static ThumbnailClickListenerPartDefinition f4165a;
    private static final Object f4166b = new Object();

    private static ThumbnailClickListenerPartDefinition m4217a() {
        return new ThumbnailClickListenerPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m4219a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 362276306);
        OnClickListener onClickListener = (OnClickListener) obj;
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) view;
        if (imageBlockLayout.f != null) {
            imageBlockLayout.f.setOnClickListener(onClickListener);
        }
        Logger.a(8, EntryType.MARK_POP, 428990801, a);
    }

    public final void m4220b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) view;
        if (imageBlockLayout.f != null) {
            imageBlockLayout.f.setOnClickListener(null);
        }
    }

    public static ThumbnailClickListenerPartDefinition m4218a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThumbnailClickListenerPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f4166b) {
                ThumbnailClickListenerPartDefinition thumbnailClickListenerPartDefinition;
                if (a3 != null) {
                    thumbnailClickListenerPartDefinition = (ThumbnailClickListenerPartDefinition) a3.a(f4166b);
                } else {
                    thumbnailClickListenerPartDefinition = f4165a;
                }
                if (thumbnailClickListenerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m4217a();
                        if (a3 != null) {
                            a3.a(f4166b, a2);
                        } else {
                            f4165a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = thumbnailClickListenerPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
