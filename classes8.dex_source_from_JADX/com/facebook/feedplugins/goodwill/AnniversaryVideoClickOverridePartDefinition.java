package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.photos.ui.HasPhotoAttachment;
import com.facebook.attachments.photos.ui.HasPhotoAttachment.OnPhotoClickListener;
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
import com.facebook.multirow.api.SubParts;

@ContextScoped
/* compiled from: gravity_no_location_change */
public class AnniversaryVideoClickOverridePartDefinition<V extends View & HasPhotoAttachment> extends BaseSinglePartDefinition<Void, OnPhotoClickListener, AnyEnvironment, V> {
    private static AnniversaryVideoClickOverridePartDefinition f12136a;
    private static final Object f12137b = new Object();

    /* compiled from: gravity_no_location_change */
    public class C12951 implements OnPhotoClickListener {
        final /* synthetic */ AnniversaryVideoClickOverridePartDefinition f12135a;

        public C12951(AnniversaryVideoClickOverridePartDefinition anniversaryVideoClickOverridePartDefinition) {
            this.f12135a = anniversaryVideoClickOverridePartDefinition;
        }

        public final <T extends View & HasPhotoAttachment> void m14135a(T t, boolean z, int i) {
        }
    }

    private static AnniversaryVideoClickOverridePartDefinition m14138c() {
        return new AnniversaryVideoClickOverridePartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m14140a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1009294302);
        m14137a((OnPhotoClickListener) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -202995896, a);
    }

    private static void m14137a(OnPhotoClickListener onPhotoClickListener, V v) {
        ((HasPhotoAttachment) v).setOnPhotoClickListener(onPhotoClickListener);
    }

    public final void m14141b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((HasPhotoAttachment) view).setOnPhotoClickListener(null);
    }

    public final Object m14139a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new C12951(this);
    }

    public static AnniversaryVideoClickOverridePartDefinition m14136a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AnniversaryVideoClickOverridePartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12137b) {
                AnniversaryVideoClickOverridePartDefinition anniversaryVideoClickOverridePartDefinition;
                if (a2 != null) {
                    anniversaryVideoClickOverridePartDefinition = (AnniversaryVideoClickOverridePartDefinition) a2.a(f12137b);
                } else {
                    anniversaryVideoClickOverridePartDefinition = f12136a;
                }
                if (anniversaryVideoClickOverridePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m14138c();
                        if (a2 != null) {
                            a2.a(f12137b, c);
                        } else {
                            f12136a = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = anniversaryVideoClickOverridePartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
