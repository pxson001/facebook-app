package com.facebook.reaction.feed.common;

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
@Deprecated
/* compiled from: bellerophon_session_id */
public class ImageBlockLayoutIconPartDefinition extends BaseSinglePartDefinition<String, Void, AnyEnvironment, ImageBlockLayout> {
    private static ImageBlockLayoutIconPartDefinition f18969a;
    private static final Object f18970b = new Object();

    private static ImageBlockLayoutIconPartDefinition m22993a() {
        return new ImageBlockLayoutIconPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m22995a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1595430722);
        String str = (String) obj;
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) view;
        imageBlockLayout.setThumbnailPlaceholderResource(2131361970);
        imageBlockLayout.setThumbnailUri(str);
        Logger.a(8, EntryType.MARK_POP, -1642070756, a);
    }

    public static ImageBlockLayoutIconPartDefinition m22994a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ImageBlockLayoutIconPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f18970b) {
                ImageBlockLayoutIconPartDefinition imageBlockLayoutIconPartDefinition;
                if (a3 != null) {
                    imageBlockLayoutIconPartDefinition = (ImageBlockLayoutIconPartDefinition) a3.a(f18970b);
                } else {
                    imageBlockLayoutIconPartDefinition = f18969a;
                }
                if (imageBlockLayoutIconPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m22993a();
                        if (a3 != null) {
                            a3.a(f18970b, a2);
                        } else {
                            f18969a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = imageBlockLayoutIconPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
