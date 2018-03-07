package com.facebook.redspace.abtest;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.util.ArrayMap;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ultralight.Inject;
import java.util.Map;

@ContextScoped
/* compiled from: should not dispatch add or move for pre layout */
public class RedSpaceStrings {
    private static RedSpaceStrings f4927d;
    private static final Object f4928e = new Object();
    @Inject
    public Context f4929a;
    @Inject
    public RTLUtil f4930b;
    @Inject
    public QeAccessor f4931c;

    private static RedSpaceStrings m8816b(InjectorLike injectorLike) {
        RedSpaceStrings redSpaceStrings = new RedSpaceStrings();
        RTLUtil a = RTLUtil.m6553a(injectorLike);
        QeAccessor a2 = QeInternalImplMethodAutoProvider.m3744a(injectorLike);
        redSpaceStrings.f4929a = (Context) injectorLike.getInstance(Context.class);
        redSpaceStrings.f4930b = a;
        redSpaceStrings.f4931c = a2;
        return redSpaceStrings;
    }

    public final String m8817a() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7076u, 2131232647);
    }

    public final String m8819b() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7052C, 2131235778);
    }

    public static RedSpaceStrings m8812a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceStrings b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f4928e) {
                RedSpaceStrings redSpaceStrings;
                if (a2 != null) {
                    redSpaceStrings = (RedSpaceStrings) a2.mo818a(f4928e);
                } else {
                    redSpaceStrings = f4927d;
                }
                if (redSpaceStrings == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m8816b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f4928e, b3);
                        } else {
                            f4927d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceStrings;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final String m8821c() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7071p, 2131235760);
    }

    public final String m8823d() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7051B, 2131235752);
    }

    public final String m8818a(String str) {
        String str2 = this.f4930b.m6557a() ? "‏" : "‎";
        return str2 + m8814a(ExperimentsForRedSpaceExperimentsModule.f7073r, 2131235753, m8815a("name", str), str) + str2;
    }

    public final String m8824e() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7080y, 2131235754);
    }

    public final String m8825f() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7081z, 2131235755);
    }

    public final String m8826g() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7050A, 2131235761);
    }

    public final String m8827h() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7074s, 2131235745);
    }

    public final String m8828i() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7075t, 2131235744);
    }

    public final String m8829j() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7055F, 2131235781);
    }

    public final String m8830k() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7072q, 2131235782);
    }

    public final String m8820b(String str) {
        return m8814a(ExperimentsForRedSpaceExperimentsModule.f7068m, 2131235772, m8815a("name", str), str);
    }

    public final String m8831l() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7069n, 2131235771);
    }

    public final String m8822c(String str) {
        return m8814a(ExperimentsForRedSpaceExperimentsModule.f7077v, 2131235777, m8815a("time", str), str);
    }

    public final String m8832m() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7053D, 2131235737);
    }

    public final String m8833n() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7078w, 2131235738);
    }

    public final String m8834o() {
        return m8813a(ExperimentsForRedSpaceExperimentsModule.f7079x, 2131235739);
    }

    private static Map<String, String> m8815a(String str, String str2) {
        ArrayMap arrayMap = new ArrayMap(1);
        arrayMap.put(str, str2);
        return arrayMap;
    }

    private String m8813a(char c, @StringRes int i) {
        return this.f4931c.mo581a(c, this.f4929a.getString(i));
    }

    private String m8814a(char c, @StringRes int i, Map<String, String> map, String... strArr) {
        String a = this.f4931c.mo581a(c, this.f4929a.getString(i, strArr));
        String str = a;
        for (String a2 : map.keySet()) {
            str = str.replace("{" + a2 + "}", (CharSequence) map.get(a2));
        }
        return str;
    }
}
