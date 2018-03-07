package com.facebook.feed.rows.qe;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: search_awareness_learning_nux_config_loader_key */
public class RangePreparerExperimentHelper {
    private static RangePreparerExperimentHelper f5890d;
    private static final Object f5891e = new Object();
    private final QeAccessor f5892a;
    private final AndroidComponentsExperimentHelper f5893b;
    @Nullable
    private Integer f5894c;

    private static RangePreparerExperimentHelper m10050b(InjectorLike injectorLike) {
        return new RangePreparerExperimentHelper(QeInternalImplMethodAutoProvider.m3744a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike));
    }

    @Inject
    public RangePreparerExperimentHelper(QeAccessor qeAccessor, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        this.f5892a = qeAccessor;
        this.f5893b = androidComponentsExperimentHelper;
    }

    public final boolean m10051a() {
        return m10052b() > 0;
    }

    public final int m10052b() {
        if (this.f5894c == null) {
            if (this.f5893b.m10064s()) {
                this.f5894c = Integer.valueOf(20);
            } else {
                this.f5894c = Integer.valueOf(this.f5892a.mo572a(ExperimentsForMultiRowQEModule.f5925i, 0));
            }
        }
        return this.f5894c.intValue();
    }

    public static RangePreparerExperimentHelper m10049a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RangePreparerExperimentHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f5891e) {
                RangePreparerExperimentHelper rangePreparerExperimentHelper;
                if (a2 != null) {
                    rangePreparerExperimentHelper = (RangePreparerExperimentHelper) a2.mo818a(f5891e);
                } else {
                    rangePreparerExperimentHelper = f5890d;
                }
                if (rangePreparerExperimentHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m10050b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f5891e, b3);
                        } else {
                            f5890d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = rangePreparerExperimentHelper;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
