package com.facebook.multirow.parts;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
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
/* compiled from: n= */
public class ViewPaddingPartDefinition extends BaseSinglePartDefinition<PaddingData, Void, AnyEnvironment, View> {
    private static ViewPaddingPartDefinition f13058a;
    private static final Object f13059b = new Object();

    /* compiled from: n= */
    public class PaddingData {
        public final int f19261a;
        public final int f19262b;
        public final int f19263c;
        public final int f19264d;

        public PaddingData(int i, int i2, int i3, int i4) {
            this.f19261a = i2;
            this.f19262b = i4;
            this.f19263c = i;
            this.f19264d = i3;
        }
    }

    private static ViewPaddingPartDefinition m19206a() {
        return new ViewPaddingPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -559311452);
        PaddingData paddingData = (PaddingData) obj;
        ViewCompat.m10950b(view, paddingData.f19263c == Integer.MIN_VALUE ? view.getPaddingLeft() : paddingData.f19263c, paddingData.f19261a == Integer.MIN_VALUE ? view.getPaddingTop() : paddingData.f19261a, paddingData.f19264d == Integer.MIN_VALUE ? view.getPaddingRight() : paddingData.f19264d, paddingData.f19262b == Integer.MIN_VALUE ? view.getPaddingBottom() : paddingData.f19262b);
        Logger.a(8, EntryType.MARK_POP, 664220097, a);
    }

    public static ViewPaddingPartDefinition m19207a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ViewPaddingPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f13059b) {
                ViewPaddingPartDefinition viewPaddingPartDefinition;
                if (a3 != null) {
                    viewPaddingPartDefinition = (ViewPaddingPartDefinition) a3.mo818a(f13059b);
                } else {
                    viewPaddingPartDefinition = f13058a;
                }
                if (viewPaddingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m19206a();
                        if (a3 != null) {
                            a3.mo822a(f13059b, a2);
                        } else {
                            f13058a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = viewPaddingPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
