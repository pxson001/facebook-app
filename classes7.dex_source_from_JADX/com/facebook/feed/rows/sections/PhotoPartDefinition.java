package com.facebook.feed.rows.sections;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
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
/* compiled from: ]  */
public class PhotoPartDefinition extends BaseSinglePartDefinition<PhotoProps, Void, AnyEnvironment, GenericDraweeView> {
    private static PhotoPartDefinition f20391a;
    private static final Object f20392b = new Object();

    /* compiled from: ]  */
    public class PhotoProps {
        public final DraweeController f20389a;
        public final float f20390b;

        public PhotoProps(DraweeController draweeController) {
            this(draweeController, 1.0f);
        }

        public PhotoProps(DraweeController draweeController, float f) {
            this.f20389a = draweeController;
            this.f20390b = f;
        }
    }

    private static PhotoPartDefinition m23514a() {
        return new PhotoPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m23516a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1411664281);
        PhotoProps photoProps = (PhotoProps) obj;
        GenericDraweeView genericDraweeView = (GenericDraweeView) view;
        genericDraweeView.setAspectRatio(photoProps.f20390b);
        genericDraweeView.setController(photoProps.f20389a);
        Logger.a(8, EntryType.MARK_POP, 1430690223, a);
    }

    public final void m23517b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((GenericDraweeView) view).setController(null);
    }

    public static PhotoPartDefinition m23515a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f20392b) {
                PhotoPartDefinition photoPartDefinition;
                if (a3 != null) {
                    photoPartDefinition = (PhotoPartDefinition) a3.a(f20392b);
                } else {
                    photoPartDefinition = f20391a;
                }
                if (photoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m23514a();
                        if (a3 != null) {
                            a3.a(f20392b, a2);
                        } else {
                            f20391a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = photoPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
