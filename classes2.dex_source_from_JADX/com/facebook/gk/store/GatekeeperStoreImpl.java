package com.facebook.gk.store;

import android.content.Context;
import com.facebook.common.preconditions.Preconditions;
import com.facebook.common.util.TriState;
import com.facebook.gk.store.GatekeeperWriter.Editor;
import com.facebook.gk.store.internal.GatekeeperListenersImpl;
import com.facebook.gk.storelogger.TraceGatekeeperStoreLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: view */
public class GatekeeperStoreImpl implements GatekeeperWriter {
    private final GatekeeperRepository f1078a;
    public final GatekeeperStoreConfig f1079b;
    @Nullable
    private final PreExistingGatekeeperStatesProvider f1080c;
    @Nullable
    private final TraceGatekeeperStoreLogger f1081d;
    @Nullable
    public final GatekeeperStoreUserManager f1082e;
    @Nullable
    private GatekeeperListenersImpl f1083f;
    private GatekeeperIndices f1084g;
    public final GatekeeperCache f1085h;
    private boolean f1086i = false;

    /* compiled from: view */
    public class Builder {
        private final Context f1055a;
        public GatekeeperStoreConfig f1056b;
        public boolean f1057c;
        private PreExistingGatekeeperStatesProvider f1058d;
        public TraceGatekeeperStoreLogger f1059e;

        public Builder(Context context) {
            this.f1055a = context;
        }

        public final GatekeeperStoreImpl m2148b() {
            Preconditions.m2016a(this.f1056b != null);
            File dir = this.f1055a.getDir(this.f1057c ? "sessionless_gatekeepers" : "gatekeepers", 0);
            return new GatekeeperStoreImpl(this.f1056b, new GatekeeperRepository(this.f1056b, dir), this.f1058d, this.f1059e, this.f1057c ? null : new GatekeeperStoreUserManager(this.f1056b, dir));
        }
    }

    public GatekeeperStoreImpl(GatekeeperStoreConfig gatekeeperStoreConfig, GatekeeperRepository gatekeeperRepository, PreExistingGatekeeperStatesProvider preExistingGatekeeperStatesProvider, @Nullable TraceGatekeeperStoreLogger traceGatekeeperStoreLogger, @Nullable GatekeeperStoreUserManager gatekeeperStoreUserManager) {
        this.f1079b = gatekeeperStoreConfig;
        this.f1078a = gatekeeperRepository;
        this.f1080c = preExistingGatekeeperStatesProvider;
        this.f1081d = traceGatekeeperStoreLogger;
        this.f1082e = gatekeeperStoreUserManager;
        this.f1085h = new GatekeeperCache(gatekeeperStoreConfig.mo327a());
    }

    public final synchronized boolean m2189a(int i, boolean z) {
        m2182h();
        return this.f1085h.m2200a(i).asBoolean(z);
    }

    public final synchronized TriState m2185a(int i) {
        m2182h();
        return this.f1085h.m2200a(i);
    }

    @Deprecated
    public final synchronized TriState m2186a(String str) {
        return m2185a(m2179f(this, str));
    }

    public final boolean m2191b(String str) {
        return m2181g().a(str) != null;
    }

    public final synchronized SortedMap<String, String> m2187a() {
        SortedMap<String, String> treeMap;
        treeMap = new TreeMap();
        List b = this.f1079b.mo328b();
        int a = this.f1079b.mo327a();
        for (int i = 0; i < a; i++) {
            treeMap.put((String) b.get(i), m2185a(i).toString().toLowerCase(Locale.US));
        }
        return treeMap;
    }

    public final synchronized void m2190b() {
        m2182h();
    }

    public final synchronized void m2192c() {
        this.f1085h.m2201a();
        this.f1085h.m2205b();
        this.f1078a.m2159b(this.f1085h);
    }

    public final synchronized void m2188a(GatekeeperListenersImpl gatekeeperListenersImpl) {
        this.f1083f = gatekeeperListenersImpl;
    }

    private synchronized GatekeeperListenersImpl m2180f() {
        return this.f1083f;
    }

    private int m2178e(String str) {
        Integer a = m2181g().a(str);
        return a == null ? -1 : a.intValue();
    }

    public static int m2179f(GatekeeperStoreImpl gatekeeperStoreImpl, String str) {
        int e = gatekeeperStoreImpl.m2178e(str);
        if (e != -1) {
            return e;
        }
        throw new IllegalArgumentException("Unknown gatekeeper: " + str);
    }

    private synchronized GatekeeperIndices m2181g() {
        if (this.f1084g == null) {
            this.f1084g = new GatekeeperIndices(this.f1079b);
        }
        return this.f1084g;
    }

    private void m2182h() {
        if (!this.f1086i) {
            this.f1086i = true;
            if (this.f1081d != null) {
                this.f1081d.m2146c();
            }
            try {
                m2183i();
            } finally {
                if (this.f1081d != null) {
                    this.f1081d.m2147d();
                }
            }
        }
    }

    private void m2183i() {
        if (!this.f1078a.m2158a(this.f1085h) && this.f1080c != null) {
            Map a = this.f1080c.a();
            ArrayList b = this.f1079b.mo328b();
            int a2 = this.f1079b.mo327a();
            for (int i = 0; i < a2; i++) {
                Boolean bool = (Boolean) a.get((String) b.get(i));
                if (bool != null) {
                    this.f1085h.m2202a(i, bool.booleanValue());
                }
            }
            this.f1078a.m2159b(this.f1085h);
        }
    }

    public final void m2193c(String str) {
        if (this.f1082e != null) {
            GatekeeperCache a = this.f1082e.m2174a(str);
            synchronized (this) {
                this.f1085h.m2203a(a);
            }
        }
    }

    public final boolean m2194d() {
        return this.f1085h.m2208c();
    }

    public final Editor mo332e() {
        return new Editor(this);
    }

    public static void m2176a(GatekeeperStoreImpl gatekeeperStoreImpl, TriState[] triStateArr, TriState[] triStateArr2, boolean z, boolean z2) {
        Collection b = gatekeeperStoreImpl.m2177b(triStateArr, triStateArr2, z, z2);
        GatekeeperListenersImpl f = gatekeeperStoreImpl.m2180f();
        if (f != null) {
            f.f1827b.m2118a(b, (Object) gatekeeperStoreImpl, f.f1826a);
        }
    }

    private synchronized List<Integer> m2177b(TriState[] triStateArr, TriState[] triStateArr2, boolean z, boolean z2) {
        List<Integer> arrayList;
        int i = 0;
        synchronized (this) {
            m2182h();
            arrayList = new ArrayList();
            int length = triStateArr.length;
            while (i < length) {
                if (!z || !this.f1085h.m2209d(i)) {
                    TriState a = this.f1085h.m2200a(i);
                    TriState triState = triStateArr[i];
                    if (triState != null) {
                        if (triState == TriState.UNSET) {
                            this.f1085h.m2210e(i);
                        } else {
                            this.f1085h.m2202a(i, triState.asBoolean(false));
                        }
                    }
                    triState = triStateArr2[i];
                    if (triState != null) {
                        if (triState == TriState.UNSET) {
                            this.f1085h.m2211f(i);
                        } else {
                            this.f1085h.m2206b(i, triState.asBoolean(false));
                        }
                    }
                    if (z2 && a != this.f1085h.m2200a(i)) {
                        arrayList.add(Integer.valueOf(i));
                    }
                }
                i++;
            }
            m2184k();
        }
        return arrayList;
    }

    private void m2184k() {
        if (this.f1081d != null) {
            this.f1081d.m2144a();
        }
        try {
            this.f1078a.m2159b(this.f1085h);
        } finally {
            if (this.f1081d != null) {
                this.f1081d.m2145b();
            }
        }
    }
}
