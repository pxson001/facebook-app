package com.facebook.multirow.parts;

import android.content.Context;
import android.view.View;
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
/* compiled from: numOfStickers */
public class ImageBlockLayoutContentDescriptionPartDefinition extends BaseSinglePartDefinition<CharSequence, Void, AnyEnvironment, ImageBlockLayout> {
    private static ImageBlockLayoutContentDescriptionPartDefinition f7928a;
    private static final Object f7929b = new Object();

    private static ImageBlockLayoutContentDescriptionPartDefinition m9560a() {
        return new ImageBlockLayoutContentDescriptionPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9562a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -5230358);
        ((ImageBlockLayout) view).setContentDescription((CharSequence) obj);
        Logger.a(8, EntryType.MARK_POP, -2030981035, a);
    }

    public static ImageBlockLayoutContentDescriptionPartDefinition m9561a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ImageBlockLayoutContentDescriptionPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7929b) {
                ImageBlockLayoutContentDescriptionPartDefinition imageBlockLayoutContentDescriptionPartDefinition;
                if (a3 != null) {
                    imageBlockLayoutContentDescriptionPartDefinition = (ImageBlockLayoutContentDescriptionPartDefinition) a3.a(f7929b);
                } else {
                    imageBlockLayoutContentDescriptionPartDefinition = f7928a;
                }
                if (imageBlockLayoutContentDescriptionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9560a();
                        if (a3 != null) {
                            a3.a(f7929b, a2);
                        } else {
                            f7928a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = imageBlockLayoutContentDescriptionPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
