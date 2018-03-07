package com.facebook.qe.api.impl;

import android.content.res.Resources;
import android.os.SystemClock;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.common.iterables.Iterables.1;
import com.facebook.common.preconditions.Preconditions;
import com.facebook.debug.log.BLog;
import com.facebook.qe.api.ExposureLoggerFilter;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.api.UniqueDeviceIdentityProvider;
import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.api.manager.QeManager;
import com.facebook.qe.api.manager.SyncedExperimentData;
import com.facebook.qe.module.QeExposureLogger;
import com.facebook.qe.module.QeLoggedInUserIdentityProvider;
import com.facebook.qe.module.QeMigratedExperimentProvider;
import com.facebook.qe.module.QeRecentUserIdentitiesProvider;
import com.facebook.qe.observer.QeAccessorObserver;
import com.facebook.qe.schema.LocatorUtils;
import com.facebook.qe.schema.Schema;
import com.facebook.qe.store.ExperimentDataSyncIndexVisitor;
import com.facebook.qe.store.ExperimentParametersCollectingIndexVisitor;
import com.facebook.qe.store.Index;
import com.facebook.qe.store.Index.Visitor;
import com.facebook.qe.store.OverrideRevertIndexVisitor;
import com.facebook.qe.store.OverrideWithDataIndexVisitor;
import com.facebook.qe.store.OverrideWithRemovalIndexVisitor;
import com.facebook.qe.store.Store;
import com.facebook.qe.store.StoreFs;
import com.facebook.qe.store.View;
import com.facebook.qe.store.ViewBuilder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: unhandled exception */
public class QeInternalImpl implements QeAccessor, QeManager {
    public static final Class<QeInternalImpl> f1956a = QeInternalImpl.class;
    private static long f1957t;
    private static long f1958u;
    public final Schema f1959b;
    public final StoreFs f1960c;
    private final Index f1961d = Index.m4009a(this.f1959b);
    private final ExposureLoggerFilter f1962e;
    public final Schema f1963f;
    public final StoreFs f1964g;
    private final Index f1965h;
    private final ExposureLoggerFilter f1966i;
    private final QeExposureLogger f1967j;
    public final UniqueDeviceIdentityProvider f1968k;
    public final QeLoggedInUserIdentityProvider f1969l;
    public final QeRecentUserIdentitiesProvider f1970m;
    private final QeMigratedExperimentProvider f1971n;
    public final boolean f1972o;
    private final boolean f1973p;
    @Nullable
    private volatile Store f1974q;
    @Nullable
    public volatile Store f1975r;
    @Nullable
    private QeAccessorObserver f1976s;

    public final long mo577a(Liveness liveness, ExposureLogging exposureLogging, long j, long j2) {
        boolean z;
        if ((1 & j) != 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        int b = LocatorUtils.m4740b(j);
        Store store = z2 ? this.f1974q : this.f1975r;
        if (!m3928a(store, z2)) {
            return j2;
        }
        if (exposureLogging == ExposureLogging.On) {
            m3925a(liveness, z2, b);
        }
        if (this.f1976s != null && this.f1976s.a()) {
            m3926a(this.f1976s, liveness, z2, b);
        }
        return (liveness == Liveness.Live ? store.m4297d() : store.m4296c()).m4316a(Authority.EFFECTIVE, b, j2);
    }

    private float m3924a(Liveness liveness, ExposureLogging exposureLogging, float f, float f2) {
        boolean z;
        if ((((int) f) & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        int b = LocatorUtils.m4739b(f);
        Store store = z2 ? this.f1974q : this.f1975r;
        if (!m3928a(store, z2)) {
            return f2;
        }
        View view;
        if (exposureLogging == ExposureLogging.On) {
            m3925a(liveness, z2, b);
        }
        if (this.f1976s != null && this.f1976s.a()) {
            m3926a(this.f1976s, liveness, z2, b);
        }
        if (liveness == Liveness.Live) {
            view = store.f2111j;
        } else {
            view = store.f2110i;
        }
        return view.m4314a(Authority.EFFECTIVE, b, f2);
    }

    public final <T extends Enum> T mo579a(Liveness liveness, ExposureLogging exposureLogging, double d, Class<T> cls, T t) {
        boolean z;
        if ((((int) d) & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        int b = LocatorUtils.m4738b(d);
        Store store = z2 ? this.f1974q : this.f1975r;
        if (!m3928a(store, z2)) {
            return t;
        }
        View view;
        if (exposureLogging == ExposureLogging.On) {
            m3925a(liveness, z2, b);
        }
        if (this.f1976s != null && this.f1976s.a()) {
            m3926a(this.f1976s, liveness, z2, b);
        }
        if (liveness == Liveness.Live) {
            view = store.f2111j;
        } else {
            view = store.f2110i;
        }
        return view.m4317a(Authority.EFFECTIVE, b, cls, t);
    }

    public QeInternalImpl(Schema schema, Schema schema2, StoreFs storeFs, StoreFs storeFs2, ExposureLoggerFilter exposureLoggerFilter, ExposureLoggerFilter exposureLoggerFilter2, QeExposureLogger qeExposureLogger, QeLoggedInUserIdentityProvider qeLoggedInUserIdentityProvider, UniqueDeviceIdentityProvider uniqueDeviceIdentityProvider, QeRecentUserIdentitiesProvider qeRecentUserIdentitiesProvider, QeMigratedExperimentProvider qeMigratedExperimentProvider, boolean z, boolean z2, @Nullable QeAccessorObserver qeAccessorObserver) {
        this.f1959b = schema;
        this.f1960c = storeFs;
        this.f1962e = exposureLoggerFilter;
        this.f1963f = schema2;
        this.f1964g = storeFs2;
        this.f1965h = Index.m4009a(this.f1963f);
        this.f1966i = exposureLoggerFilter2;
        this.f1967j = qeExposureLogger;
        this.f1968k = uniqueDeviceIdentityProvider;
        this.f1969l = qeLoggedInUserIdentityProvider;
        this.f1970m = qeRecentUserIdentitiesProvider;
        this.f1971n = qeMigratedExperimentProvider;
        this.f1972o = z;
        this.f1973p = z2;
        this.f1976s = qeAccessorObserver;
    }

    public final void mo586a() {
        Store a = Store.m4286a(this.f1964g, this.f1963f, this.f1965h, this.f1968k.m3856a(), this.f1971n, this.f1972o, this.f1973p);
        a.m4293a();
        this.f1974q = a;
        String a2 = this.f1969l.m3747a();
        if (a2 != null) {
            a = Store.m4289b(this.f1960c, this.f1959b, this.f1961d, a2, this.f1971n, this.f1972o, this.f1973p);
            a.m4293a();
            this.f1975r = a;
        }
    }

    @Nullable
    public final String mo597b(Authority authority, String str) {
        Store f = m3929f(str);
        Index g = m3930g(str);
        int a = g == null ? -1 : g.m4015a(str);
        if (f == null || a == -1) {
            BLog.b(f1956a, "Unrecognized experiment: %s", new Object[]{str});
            return null;
        }
        a = g.m4021c(a) + 2;
        View view = f.f2111j;
        if (view.m4327f(authority, a)) {
            return view.m4318a(authority, a);
        }
        return null;
    }

    @Nullable
    public final String mo601c(Authority authority, String str) {
        Store f = m3929f(str);
        Index g = m3930g(str);
        int a = g == null ? -1 : g.m4015a(str);
        if (f == null || a == -1) {
            BLog.b(f1956a, "Unrecognized experiment: %s", new Object[]{str});
            return null;
        }
        a = g.m4021c(a) + 3;
        View view = f.f2111j;
        if (view.m4327f(authority, a)) {
            return view.m4318a(authority, a);
        }
        return null;
    }

    @Nullable
    public final Map<String, String> mo604d(Authority authority, String str) {
        Store f = m3929f(str);
        Index g = m3930g(str);
        int a = g == null ? -1 : g.m4015a(str);
        if (f == null || a == -1) {
            BLog.b(f1956a, "Unrecognized experiment: %s", new Object[]{str});
            return null;
        }
        View view = f.f2111j;
        Map<String, String> hashMap = new HashMap();
        g.m4017a(new ExperimentParametersCollectingIndexVisitor(authority, view, str, hashMap));
        return hashMap;
    }

    public final boolean mo602c(String str) {
        Store f = m3929f(str);
        Index g = m3930g(str);
        int a = g == null ? -1 : g.m4015a(str);
        if (f == null || a == -1) {
            BLog.b(f1956a, "Unrecognized experiment: %s", new Object[]{str});
            return false;
        }
        a = g.m4021c(a) + 3;
        View view = f.f2111j;
        if (view.m4327f(Authority.OVERRIDE, a) || view.m4321a(a)) {
            return true;
        }
        return false;
    }

    public final void mo605d(String str) {
        Store f = m3929f(str);
        Index g = m3930g(str);
        int a = g == null ? -1 : g.m4015a(str);
        if (f == null || a == -1) {
            BLog.b(f1956a, "Unrecognized experiment: %s", new Object[]{str});
            return;
        }
        ViewBuilder viewBuilder = new ViewBuilder(f.f2104c.mo567a());
        m3927a(f, g, viewBuilder, new OverrideRevertIndexVisitor(g, f.f2111j, viewBuilder, a));
    }

    public final void mo607e(String str) {
        Store f = m3929f(str);
        Index g = m3930g(str);
        int a = g == null ? -1 : g.m4015a(str);
        if (f == null || a == -1) {
            BLog.b(f1956a, "Unrecognized experiment: %s", new Object[]{str});
            return;
        }
        ViewBuilder viewBuilder = new ViewBuilder(f.f2104c.mo567a());
        m3927a(f, g, viewBuilder, new OverrideWithRemovalIndexVisitor(g, f.f2111j, viewBuilder, a));
    }

    public final void mo587a(QuickExperimentInfo quickExperimentInfo) {
        String a = quickExperimentInfo.m15051a();
        Store f = m3929f(a);
        Index g = m3930g(a);
        int a2 = g == null ? -1 : g.m4015a(a);
        if (f == null || a2 == -1) {
            BLog.b(f1956a, "Unrecognized experiment: %s", new Object[]{a});
            return;
        }
        ViewBuilder viewBuilder = new ViewBuilder(f.f2104c.mo567a());
        m3927a(f, g, viewBuilder, new OverrideWithDataIndexVisitor(g, f.f2111j, viewBuilder, a2, quickExperimentInfo));
    }

    public final void mo592a(Map<String, SyncedExperimentData> map, boolean z) {
        Store store = z ? this.f1974q : this.f1975r;
        if (store != null) {
            ViewBuilder viewBuilder = new ViewBuilder(store.f2104c.mo567a());
            Index.m4009a(store.f2104c).m4017a(new ExperimentDataSyncIndexVisitor(map, store.f2111j, viewBuilder));
            store.m4294a(viewBuilder.a());
        }
    }

    public final boolean mo599b(String str) {
        return this.f1961d.m4020b(str) || this.f1965h.m4020b(str);
    }

    public final Iterable<String> mo600c() {
        Iterable[] iterableArr = new Iterable[]{mo603d(), mo606e()};
        Preconditions.m2017b(iterableArr != null);
        return new 1(iterableArr);
    }

    public final Iterable<String> mo603d() {
        return this.f1961d.m4018b();
    }

    public final Iterable<String> mo606e() {
        return this.f1965h.m4018b();
    }

    public final void mo591a(String str) {
        if (this.f1975r != null) {
            BLog.b(f1956a, "User was already logged in when handleUserLogin was called");
        }
        this.f1962e.m4007a();
        Store b = Store.m4289b(this.f1960c, this.f1959b, this.f1961d, str, this.f1971n, this.f1972o, this.f1973p);
        b.m4293a();
        this.f1975r = b;
    }

    public final void mo598b() {
        if (this.f1975r == null) {
            BLog.b(f1956a, "User was already logged out when handleUserLogout was called");
        }
        if (!this.f1972o) {
            String a = this.f1968k.m3856a();
            Set hashSet = new HashSet(1);
            hashSet.add(a);
            this.f1964g.m3875a(hashSet);
            this.f1964g.m3880e(a, this.f1963f.mo569c());
            if (this.f1975r == null) {
                BLog.b(f1956a, "Attempted to call cleanupOnUserLogout when we didn't have a sessioned store.");
            } else {
                a = this.f1969l.m3747a();
                List a2 = this.f1970m.f1854a.m3754a();
                Set hashSet2 = new HashSet(a2.size() + 1);
                hashSet2.addAll(a2);
                hashSet2.add(a);
                this.f1960c.m3875a(hashSet2);
                this.f1960c.m3880e(a, this.f1959b.mo569c());
            }
        }
        this.f1975r = null;
    }

    public final boolean mo595a(Authority authority, String str) {
        boolean z;
        boolean b = this.f1961d.m4020b(str);
        if (b) {
            z = b;
        } else if (!this.f1965h.m4020b(str)) {
            return false;
        } else {
            z = false;
        }
        Store store = z ? this.f1975r : this.f1974q;
        if (z) {
            b = false;
        } else {
            b = true;
        }
        if (!m3928a(store, b)) {
            return false;
        }
        Index index = z ? this.f1961d : this.f1965h;
        return store.f2111j.m4322a(authority, index.m4021c(index.m4015a(str)) + 1, false);
    }

    public final String mo581a(char c, String str) {
        return mo585a(Liveness.Cached, ExposureLogging.On, c, str);
    }

    public final String mo580a(char c, int i, Resources resources) {
        String a = mo581a(c, null);
        return a != null ? a : resources.getString(i);
    }

    public final int mo572a(int i, int i2) {
        return mo574a(Liveness.Cached, ExposureLogging.On, i, i2);
    }

    public final long mo575a(long j, long j2) {
        return mo577a(Liveness.Cached, ExposureLogging.On, j, j2);
    }

    public final float mo571a(float f, float f2) {
        return m3924a(Liveness.Cached, ExposureLogging.On, f, f2);
    }

    public final <T extends Enum> T mo578a(double d, Class<T> cls, T t) {
        return mo579a(Liveness.Cached, ExposureLogging.On, d, (Class) cls, (Enum) t);
    }

    public final boolean mo596a(short s, boolean z) {
        return mo593a(Liveness.Cached, ExposureLogging.On, s, z);
    }

    public final String mo583a(Liveness liveness, char c, String str) {
        return mo585a(liveness, ExposureLogging.On, c, str);
    }

    public final String mo582a(Liveness liveness, char c, int i, Resources resources) {
        String a = mo583a(liveness, c, null);
        return a != null ? a : resources.getString(i);
    }

    public final int mo573a(Liveness liveness, int i, int i2) {
        return mo574a(liveness, ExposureLogging.On, i, i2);
    }

    public final long mo576a(Liveness liveness, long j, long j2) {
        return mo577a(liveness, ExposureLogging.On, j, j2);
    }

    public final boolean mo594a(Liveness liveness, short s, boolean z) {
        return mo593a(liveness, ExposureLogging.On, s, z);
    }

    public final String mo585a(Liveness liveness, ExposureLogging exposureLogging, char c, String str) {
        boolean a = LocatorUtils.m4735a(c);
        int i = c >> 1;
        Store store = a ? this.f1974q : this.f1975r;
        if (!m3928a(store, a)) {
            return str;
        }
        View view;
        if (exposureLogging == ExposureLogging.On) {
            m3925a(liveness, a, i);
        }
        if (this.f1976s != null && this.f1976s.a()) {
            m3926a(this.f1976s, liveness, a, i);
        }
        if (liveness == Liveness.Live) {
            view = store.f2111j;
        } else {
            view = store.f2110i;
        }
        return view.m4319a(Authority.EFFECTIVE, i, str);
    }

    public final String mo584a(Liveness liveness, ExposureLogging exposureLogging, char c, int i, Resources resources) {
        String a = mo585a(liveness, exposureLogging, c, null);
        return a != null ? a : resources.getString(i);
    }

    public final int mo574a(Liveness liveness, ExposureLogging exposureLogging, int i, int i2) {
        boolean a = LocatorUtils.m4736a(i);
        int i3 = i >> 1;
        Store store = a ? this.f1974q : this.f1975r;
        if (!m3928a(store, a)) {
            return i2;
        }
        View view;
        if (exposureLogging == ExposureLogging.On) {
            m3925a(liveness, a, i3);
        }
        if (this.f1976s != null && this.f1976s.a()) {
            m3926a(this.f1976s, liveness, a, i3);
        }
        if (liveness == Liveness.Live) {
            view = store.f2111j;
        } else {
            view = store.f2110i;
        }
        return view.m4315a(Authority.EFFECTIVE, i3, i2);
    }

    public final boolean mo593a(Liveness liveness, ExposureLogging exposureLogging, short s, boolean z) {
        boolean a = LocatorUtils.m4737a(s);
        int b = LocatorUtils.m4741b(s);
        Store store = a ? this.f1974q : this.f1975r;
        if (!m3928a(store, a)) {
            return z;
        }
        View view;
        if (exposureLogging == ExposureLogging.On) {
            m3925a(liveness, a, b);
        }
        if (this.f1976s != null && this.f1976s.a()) {
            m3926a(this.f1976s, liveness, a, b);
        }
        if (liveness == Liveness.Live) {
            view = store.f2111j;
        } else {
            view = store.f2110i;
        }
        return view.m4322a(Authority.EFFECTIVE, b, z);
    }

    private static void m3927a(Store store, Index index, ViewBuilder viewBuilder, Visitor visitor) {
        index.m4017a(visitor);
        store.m4294a(viewBuilder.a());
    }

    @Nullable
    private Store m3929f(String str) {
        boolean b = this.f1965h.m4020b(str);
        if (b || this.f1961d.m4020b(str)) {
            return b ? this.f1974q : this.f1975r;
        } else {
            return null;
        }
    }

    @Nullable
    private Index m3930g(String str) {
        boolean b = this.f1965h.m4020b(str);
        if (b || this.f1961d.m4020b(str)) {
            return b ? this.f1965h : this.f1961d;
        } else {
            return null;
        }
    }

    private static boolean m3928a(Store store, boolean z) {
        if (store != null) {
            return true;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (z) {
            if (uptimeMillis - f1958u > 5000) {
                BLog.a(f1956a, "The sessionless store is not available.");
                f1958u = uptimeMillis;
            }
        } else if (uptimeMillis - f1957t > 5000) {
            BLog.a(f1956a, "The sessioned store is not available. Are you fetching sessioned quick experiment data while the user is logged out?");
            f1957t = uptimeMillis;
        }
        return false;
    }

    private void m3925a(Liveness liveness, boolean z, int i) {
        Store store = z ? this.f1974q : this.f1975r;
        String str;
        if (store == null) {
            Class cls = f1956a;
            String str2 = "Exposure logged while session%s store was null";
            Object[] objArr = new Object[1];
            if (z) {
                str = "less";
            } else {
                str = "ed";
            }
            objArr[0] = str;
            BLog.b(cls, str2, objArr);
            return;
        }
        View view;
        if (liveness == Liveness.Cached) {
            view = store.f2110i;
        } else {
            view = store.f2111j;
        }
        Index index = z ? this.f1965h : this.f1961d;
        ExposureLoggerFilter exposureLoggerFilter = z ? this.f1966i : this.f1962e;
        int a = index.m4014a(i);
        int i2 = 1;
        if (exposureLoggerFilter.f1977a.compareAndSet(a, 0, 1)) {
            i2 = 0;
        }
        if (i2 == 0) {
            str = index.m4019b(a);
            int c = index.m4021c(a);
            this.f1967j.m3756a(view.m4322a(Authority.EFFECTIVE, c + 1, false), str, view.m4319a(Authority.EFFECTIVE, c + 2, null));
        }
    }

    public final void mo588a(Liveness liveness, char c) {
        m3925a(liveness, LocatorUtils.m4735a(c), c >> 1);
    }

    public final void mo589a(Liveness liveness, int i) {
        m3925a(liveness, LocatorUtils.m4736a(i), i >> 1);
    }

    public final void mo590a(Liveness liveness, short s) {
        m3925a(liveness, LocatorUtils.m4737a(s), LocatorUtils.m4741b(s));
    }

    public final boolean mo608f() {
        Store store = this.f1975r;
        if (store == null) {
            return true;
        }
        View view = store.f2111j;
        if (view != null) {
            return view.f2181c;
        }
        return true;
    }

    private void m3926a(QeAccessorObserver qeAccessorObserver, Liveness liveness, boolean z, int i) {
        Store store = z ? this.f1974q : this.f1975r;
        if (store != null) {
            View view;
            if (liveness == Liveness.Cached) {
                view = store.f2110i;
            } else {
                view = store.f2111j;
            }
            Index index = z ? this.f1965h : this.f1961d;
            int a = index.m4014a(i);
            String b = index.m4019b(a);
            int c = index.m4021c(a);
            view.m4319a(Authority.EFFECTIVE, c + 2, null);
            if (view.m4322a(Authority.EFFECTIVE, c + 1, false)) {
                mo604d(Authority.EFFECTIVE, b);
            }
        }
    }
}
