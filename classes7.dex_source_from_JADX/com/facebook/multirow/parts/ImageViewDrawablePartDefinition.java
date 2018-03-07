package com.facebook.multirow.parts;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
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
/* compiled from: numItems */
public class ImageViewDrawablePartDefinition extends BaseSinglePartDefinition<Drawable, Void, AnyEnvironment, ImageView> {
    private static ImageViewDrawablePartDefinition f7942a;
    private static final Object f7943b = new Object();

    private static ImageViewDrawablePartDefinition m9569a() {
        return new ImageViewDrawablePartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9571a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 481738965);
        ((ImageView) view).setImageDrawable((Drawable) obj);
        Logger.a(8, EntryType.MARK_POP, 1336419507, a);
    }

    public final void m9572b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ImageView) view).setImageDrawable(null);
    }

    public static ImageViewDrawablePartDefinition m9570a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ImageViewDrawablePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7943b) {
                ImageViewDrawablePartDefinition imageViewDrawablePartDefinition;
                if (a3 != null) {
                    imageViewDrawablePartDefinition = (ImageViewDrawablePartDefinition) a3.a(f7943b);
                } else {
                    imageViewDrawablePartDefinition = f7942a;
                }
                if (imageViewDrawablePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9569a();
                        if (a3 != null) {
                            a3.a(f7943b, a2);
                        } else {
                            f7942a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = imageViewDrawablePartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
