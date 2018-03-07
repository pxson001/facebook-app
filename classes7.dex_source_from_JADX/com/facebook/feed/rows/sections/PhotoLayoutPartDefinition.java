package com.facebook.feed.rows.sections;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.view.DraweeView;
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
/* compiled from: ] [ */
public class PhotoLayoutPartDefinition extends BaseSinglePartDefinition<Integer, Void, AnyEnvironment, DraweeView> {
    private static PhotoLayoutPartDefinition f20387a;
    private static final Object f20388b = new Object();

    private static PhotoLayoutPartDefinition m23510a() {
        return new PhotoLayoutPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m23512a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1573312705);
        Integer num = (Integer) obj;
        DraweeView draweeView = (DraweeView) view;
        LayoutParams layoutParams = draweeView.getLayoutParams();
        layoutParams.height = num.intValue();
        layoutParams.width = num.intValue();
        draweeView.setLayoutParams(layoutParams);
        Logger.a(8, EntryType.MARK_POP, -1913365495, a);
    }

    public final void m23513b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        DraweeView draweeView = (DraweeView) view;
        LayoutParams layoutParams = draweeView.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        draweeView.setLayoutParams(layoutParams);
    }

    public static PhotoLayoutPartDefinition m23511a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoLayoutPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f20388b) {
                PhotoLayoutPartDefinition photoLayoutPartDefinition;
                if (a3 != null) {
                    photoLayoutPartDefinition = (PhotoLayoutPartDefinition) a3.a(f20388b);
                } else {
                    photoLayoutPartDefinition = f20387a;
                }
                if (photoLayoutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m23510a();
                        if (a3 != null) {
                            a3.a(f20388b, a2);
                        } else {
                            f20387a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = photoLayoutPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
