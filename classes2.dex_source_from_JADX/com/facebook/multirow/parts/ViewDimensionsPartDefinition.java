package com.facebook.multirow.parts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
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
/* compiled from: history/ */
public class ViewDimensionsPartDefinition extends BaseSinglePartDefinition<DimensionData, Void, AnyEnvironment, View> {
    private static ViewDimensionsPartDefinition f21019a;
    private static final Object f21020b = new Object();

    /* compiled from: history/ */
    public class DimensionData {
        public int f21999a = 0;
        public boolean f22000b;
        public final int f22001c;
        public final int f22002d;

        public DimensionData(int i, int i2) {
            this.f22001c = i;
            this.f22002d = i2;
        }
    }

    private static ViewDimensionsPartDefinition m28736a() {
        return new ViewDimensionsPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -197794359);
        DimensionData dimensionData = (DimensionData) obj;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            int i;
            layoutParams.width = dimensionData.f22001c;
            if (dimensionData.f22000b) {
                i = dimensionData.f21999a;
            } else {
                i = dimensionData.f22002d;
            }
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
        Logger.a(8, EntryType.MARK_POP, 506240673, a);
    }

    public static ViewDimensionsPartDefinition m28737a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ViewDimensionsPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f21020b) {
                ViewDimensionsPartDefinition viewDimensionsPartDefinition;
                if (a3 != null) {
                    viewDimensionsPartDefinition = (ViewDimensionsPartDefinition) a3.mo818a(f21020b);
                } else {
                    viewDimensionsPartDefinition = f21019a;
                }
                if (viewDimensionsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m28736a();
                        if (a3 != null) {
                            a3.mo822a(f21020b, a2);
                        } else {
                            f21019a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = viewDimensionsPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
