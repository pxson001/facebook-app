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
import javax.inject.Inject;

@ContextScoped
/* compiled from: search_awareness_android_spotlight_enabled */
public class AndroidComponentsExperimentHelper {
    private static AndroidComponentsExperimentHelper f5895u;
    private static final Object f5896v = new Object();
    public final QeAccessor f5897a;
    public Boolean f5898b;
    private Boolean f5899c;
    public Boolean f5900d;
    private Boolean f5901e;
    private Boolean f5902f;
    private Boolean f5903g;
    public Boolean f5904h;
    private Boolean f5905i;
    public Boolean f5906j;
    public Boolean f5907k;
    private Boolean f5908l;
    private Boolean f5909m;
    private Boolean f5910n;
    public Boolean f5911o;
    public Boolean f5912p;
    private Boolean f5913q;
    public Boolean f5914r;
    public Boolean f5915s;
    public Boolean f5916t;

    private static AndroidComponentsExperimentHelper m10055b(InjectorLike injectorLike) {
        return new AndroidComponentsExperimentHelper(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public AndroidComponentsExperimentHelper(QeAccessor qeAccessor) {
        this.f5897a = qeAccessor;
    }

    public static AndroidComponentsExperimentHelper m10053a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AndroidComponentsExperimentHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f5896v) {
                AndroidComponentsExperimentHelper androidComponentsExperimentHelper;
                if (a2 != null) {
                    androidComponentsExperimentHelper = (AndroidComponentsExperimentHelper) a2.mo818a(f5896v);
                } else {
                    androidComponentsExperimentHelper = f5895u;
                }
                if (androidComponentsExperimentHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m10055b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f5896v, b3);
                        } else {
                            f5895u = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = androidComponentsExperimentHelper;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final boolean m10056b() {
        if (this.f5899c == null) {
            this.f5899c = Boolean.valueOf(this.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5930n, false));
        }
        if (this.f5899c.booleanValue() || m10064s()) {
            return true;
        }
        return false;
    }

    public final boolean m10057f() {
        if (this.f5901e == null) {
            this.f5901e = Boolean.valueOf(this.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5935s, false));
        }
        if (this.f5901e.booleanValue() || m10064s()) {
            return true;
        }
        return false;
    }

    public final boolean m10058g() {
        if (this.f5902f == null) {
            this.f5902f = Boolean.valueOf(this.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5934r, false));
        }
        if (this.f5902f.booleanValue() || m10064s()) {
            return true;
        }
        return false;
    }

    public final boolean m10059h() {
        if (this.f5903g == null) {
            this.f5903g = Boolean.valueOf(this.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5937u, false));
        }
        if (this.f5903g.booleanValue() || m10064s()) {
            return true;
        }
        return false;
    }

    public final boolean m10060j() {
        if (this.f5905i == null) {
            this.f5905i = Boolean.valueOf(m10054a(this.f5897a.mo572a(ExperimentsForMultiRowQEModule.f5918b, 0)));
        }
        if (this.f5905i.booleanValue() || m10064s()) {
            return true;
        }
        return false;
    }

    public final boolean m10061m() {
        if (this.f5908l == null) {
            this.f5908l = Boolean.valueOf(m10054a(this.f5897a.mo572a(ExperimentsForMultiRowQEModule.f5924h, 0)));
        }
        if (this.f5908l.booleanValue() || m10064s()) {
            return true;
        }
        return false;
    }

    public final boolean m10062n() {
        if (this.f5909m == null) {
            this.f5909m = Boolean.valueOf(this.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5928l, false));
        }
        if (this.f5909m.booleanValue() || m10064s()) {
            return true;
        }
        return false;
    }

    public final boolean m10063o() {
        if (this.f5910n == null) {
            this.f5910n = Boolean.valueOf(this.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5932p, false));
        }
        if (this.f5910n.booleanValue() || m10064s()) {
            return true;
        }
        return false;
    }

    public final boolean m10064s() {
        if (this.f5913q == null) {
            this.f5913q = Boolean.valueOf(this.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5917a, false));
        }
        return this.f5913q.booleanValue();
    }

    public static boolean m10054a(int i) {
        return i == 1 || i == 2;
    }
}
