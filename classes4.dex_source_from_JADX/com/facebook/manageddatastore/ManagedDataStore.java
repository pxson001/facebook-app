package com.facebook.manageddatastore;

import android.content.Context;
import android.os.SystemClock;
import com.facebook.common.diagnostics.TraceLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.manageddatastore.MDSDatabaseOperationHandler.DiskStoreEntry;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: successful read of key  */
public class ManagedDataStore<K, V> implements InjectableComponentWithContext, NetworkRequestCallback<K, V> {
    public static int f1579a = 60000;
    protected static int f1580b = 0;
    public final Client<K, V> f1581c;
    protected final Mode f1582d;
    protected final Context f1583e;
    public final MDSMemoryCache<K, V> f1584f = new MDSMemoryCache();
    public MDSDatabaseOperationHandler<K, V> f1585g;
    protected int f1586h;
    protected Map<K, Long> f1587i;
    protected Long f1588j;
    public TraceLogger f1589k;
    @Inject
    @MDSSerialExecutor
    public ExecutorService f1590l;
    @Inject
    public AbstractFbErrorReporter f1591m;

    /* compiled from: successful read of key  */
    public interface Client<K, V> {
        V mo110a(String str);

        String mo103a();

        String mo104a(K k);

        void mo111a(Context context, K k, NetworkRequestCallback<K, V> networkRequestCallback);

        boolean mo112a(K k, V v);

        int mo105b(K k, V v);

        int mo107c(K k, V v);
    }

    /* compiled from: successful read of key  */
    public enum Mode {
        UNRESTRICTED,
        SINGLE_REQUEST_BY_KEY,
        SINGLE_REQUEST
    }

    private static <T extends InjectableComponentWithContext> void m1816a(Class<T> cls, T t) {
        m1817a((Object) t, t.getContext());
    }

    private static void m1817a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ManagedDataStore managedDataStore = (ManagedDataStore) obj;
        ExecutorService a = ExecutorService_MDSSerialExecutorMethodAutoProvider.m1844a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        managedDataStore.f1590l = a;
        managedDataStore.f1591m = abstractFbErrorReporter;
    }

    public Context getContext() {
        return this.f1583e;
    }

    public static void m1815a() {
        synchronized (ManagedDataStore.class) {
            f1580b++;
        }
    }

    public ManagedDataStore(Client<K, V> client, Mode mode, Context context) {
        this.f1581c = client;
        this.f1582d = mode;
        this.f1583e = context.getApplicationContext();
        this.f1585g = new MDSDatabaseOperationHandler(client, this.f1583e.getContentResolver());
        if (mode == Mode.SINGLE_REQUEST_BY_KEY) {
            this.f1587i = new HashMap();
        }
        synchronized (ManagedDataStore.class) {
            this.f1586h = f1580b;
        }
        m1816a(ManagedDataStore.class, (InjectableComponentWithContext) this);
        this.f1589k = new TraceLogger(16384, 128);
    }

    @Nullable
    public V m1823a(@Nullable K k) {
        Preconditions.checkNotNull(this.f1583e);
        this.f1589k.a("request for key " + m1818c(k));
        m1821d();
        CheckResult d = m1820d(k);
        if (d.a == DataState.VALID_AND_FRESH) {
            return d.b;
        }
        CheckResult checkResult;
        DiskStoreEntry a = this.f1585g.m1838a((Object) k);
        DataState dataState = d.a;
        Object obj = d.b;
        if (a != null) {
            if (a.b != -1 && System.currentTimeMillis() < a.b + ((long) (this.f1581c.mo107c(k, a.a) * 1000))) {
                this.f1584f.m1833a(k, a.a, a.b);
                this.f1589k.a("successful read of key " + k + " from disk");
                checkResult = new CheckResult(DataState.VALID_AND_FRESH, a.a);
                d = checkResult;
                if (d.a == DataState.VALID_AND_FRESH) {
                    return d.b;
                }
                m1822e(k);
                return d.b;
            } else if (this.f1581c.mo112a(k, a.a)) {
                dataState = DataState.VALID_AND_EXPIRED;
                obj = a.a;
            } else {
                this.f1585g.m1842b(k);
            }
        }
        checkResult = new CheckResult(dataState, obj);
        d = checkResult;
        if (d.a == DataState.VALID_AND_FRESH) {
            return d.b;
        }
        m1822e(k);
        return d.b;
    }

    public final synchronized void m1825a(ClearType clearType) {
        if (clearType == ClearType.CLEAR_DISK || clearType == ClearType.CLEAR_ALL) {
            m1819c();
            this.f1585g.m1839a();
        }
        if (clearType == ClearType.CLEAR_MEMORY || clearType == ClearType.CLEAR_ALL) {
            this.f1584f.m1831a();
        }
    }

    public final synchronized void m1826a(ClearType clearType, long j) {
        if (clearType == ClearType.CLEAR_DISK || clearType == ClearType.CLEAR_ALL) {
            m1819c();
            this.f1585g.m1840a(j);
        }
        if (clearType == ClearType.CLEAR_MEMORY || clearType == ClearType.CLEAR_ALL) {
            this.f1584f.m1832a(j);
        }
    }

    public void mo113a(Context context, boolean z, @Nullable K k, String str, V v) {
        this.f1589k.a("got callback at MDS for key " + m1818c(k));
        switch (this.f1582d) {
            case SINGLE_REQUEST_BY_KEY:
                synchronized (this.f1587i) {
                    this.f1587i.remove(k);
                }
                break;
            case SINGLE_REQUEST:
                synchronized (this) {
                    this.f1589k.a("released global lock (key: %s)", new Object[]{m1818c(k)});
                    this.f1588j = null;
                }
                break;
        }
        if (z) {
            final long currentTimeMillis = System.currentTimeMillis();
            int b = this.f1581c.mo105b(k, v);
            if (b > 0) {
                this.f1584f.m1833a(k, v, currentTimeMillis);
            }
            if (this.f1581c.mo107c(k, v) > 0) {
                this.f1589k.a("Writing key " + k + " to disk");
                if (b > 0) {
                    final K k2 = k;
                    final String str2 = str;
                    ExecutorDetour.a(this.f1590l, new Runnable(this) {
                        final /* synthetic */ ManagedDataStore f2015d;

                        public void run() {
                            this.f2015d.f1585g.m1841a(k2, str2, currentTimeMillis);
                        }
                    }, 1208598209);
                    return;
                }
                this.f1585g.m1841a(k, str, currentTimeMillis);
            }
        }
    }

    public final TraceLogger mo114b() {
        return this.f1589k;
    }

    private static String m1818c(@Nullable K k) {
        return k == null ? "(null)" : k.toString();
    }

    @VisibleForTesting
    private void m1819c() {
        try {
            FutureDetour.a(ExecutorDetour.a(this.f1590l, new 2(this), -1893928925), 969921401);
        } catch (InterruptedException e) {
        } catch (ExecutionException e2) {
        }
    }

    private void m1821d() {
        synchronized (ManagedDataStore.class) {
            synchronized (this) {
                if (this.f1586h != f1580b) {
                    this.f1584f.m1831a();
                    this.f1586h = f1580b;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.manageddatastore.ManagedDataStore.CheckResult<V> m1820d(@javax.annotation.Nullable K r9) {
        /*
        r8 = this;
        r0 = 0;
        r1 = com.facebook.manageddatastore.ManagedDataStore.DataState.INVALID;
        monitor-enter(r8);
        r2 = r8.f1584f;	 Catch:{ all -> 0x006f }
        r2 = r2.m1830a(r9);	 Catch:{ all -> 0x006f }
        if (r2 == 0) goto L_0x0072;
    L_0x000c:
        r1 = r2.f2010a;	 Catch:{ all -> 0x006f }
        r4 = r2.f2011b;	 Catch:{ all -> 0x006f }
        r6 = -1;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 == 0) goto L_0x0053;
    L_0x0016:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x006f }
        r6 = r2.f2011b;	 Catch:{ all -> 0x006f }
        r3 = r8.f1581c;	 Catch:{ all -> 0x006f }
        r2 = r2.f2010a;	 Catch:{ all -> 0x006f }
        r2 = r3.mo105b(r9, r2);	 Catch:{ all -> 0x006f }
        r2 = r2 * 1000;
        r2 = (long) r2;	 Catch:{ all -> 0x006f }
        r2 = r2 + r6;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0053;
    L_0x002c:
        r0 = r8.f1589k;	 Catch:{ all -> 0x006f }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006f }
        r3 = "successful read of key ";
        r2.<init>(r3);	 Catch:{ all -> 0x006f }
        r3 = m1818c(r9);	 Catch:{ all -> 0x006f }
        r2 = r2.append(r3);	 Catch:{ all -> 0x006f }
        r3 = " from memory";
        r2 = r2.append(r3);	 Catch:{ all -> 0x006f }
        r2 = r2.toString();	 Catch:{ all -> 0x006f }
        r0.a(r2);	 Catch:{ all -> 0x006f }
        r0 = new com.facebook.manageddatastore.ManagedDataStore$CheckResult;	 Catch:{ all -> 0x006f }
        r2 = com.facebook.manageddatastore.ManagedDataStore.DataState.VALID_AND_FRESH;	 Catch:{ all -> 0x006f }
        r0.<init>(r2, r1);	 Catch:{ all -> 0x006f }
        monitor-exit(r8);	 Catch:{ all -> 0x006f }
    L_0x0052:
        return r0;
    L_0x0053:
        r2 = r8.f1581c;	 Catch:{ all -> 0x006f }
        r2 = r2.mo112a(r9, r1);	 Catch:{ all -> 0x006f }
        if (r2 != 0) goto L_0x006b;
    L_0x005b:
        r1 = r8.f1584f;	 Catch:{ all -> 0x006f }
        r1.m1834b(r9);	 Catch:{ all -> 0x006f }
        r1 = com.facebook.manageddatastore.ManagedDataStore.DataState.INVALID;	 Catch:{ all -> 0x006f }
        r2 = r1;
        r1 = r0;
    L_0x0064:
        monitor-exit(r8);	 Catch:{ all -> 0x006f }
        r0 = new com.facebook.manageddatastore.ManagedDataStore$CheckResult;
        r0.<init>(r2, r1);
        goto L_0x0052;
    L_0x006b:
        r0 = com.facebook.manageddatastore.ManagedDataStore.DataState.VALID_AND_EXPIRED;	 Catch:{  }
        r2 = r0;
        goto L_0x0064;
    L_0x006f:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{  }
        throw r0;
    L_0x0072:
        r2 = r1;
        r1 = r0;
        goto L_0x0064;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.manageddatastore.ManagedDataStore.d(java.lang.Object):com.facebook.manageddatastore.ManagedDataStore$CheckResult<V>");
    }

    private void m1822e(@Nullable K k) {
        Object obj;
        Object obj2 = null;
        int i;
        int i2;
        switch (this.f1582d) {
            case SINGLE_REQUEST_BY_KEY:
                synchronized (this.f1587i) {
                    Long l = (Long) this.f1587i.get(k);
                    if (l == null) {
                        obj = null;
                        obj2 = 1;
                    } else if (l.longValue() + ((long) f1579a) < SystemClock.uptimeMillis()) {
                        this.f1589k.a("per-key lock had to be stolen (old lock timestamp: %d; key: %s)", new Object[]{l, m1818c(k)});
                        i = 1;
                        i2 = 1;
                    } else {
                        obj = null;
                    }
                    if (obj2 != null) {
                        this.f1587i.put(k, Long.valueOf(SystemClock.uptimeMillis()));
                    }
                }
                break;
            case SINGLE_REQUEST:
                synchronized (this) {
                    if (this.f1588j == null) {
                        this.f1589k.a("successfully acquired global lock (key: %s)", new Object[]{m1818c(k)});
                        obj = null;
                        obj2 = 1;
                    } else if (this.f1588j.longValue() + ((long) f1579a) < SystemClock.uptimeMillis()) {
                        this.f1589k.a("global lock had to be stolen (old lock timestamp: %d; key: %s)", new Object[]{this.f1588j, m1818c(k)});
                        i = 1;
                        i2 = 1;
                    } else {
                        obj = null;
                    }
                    if (obj2 != null) {
                        this.f1588j = Long.valueOf(SystemClock.uptimeMillis());
                        this.f1589k.a("mGlobalLock set to %d", new Object[]{this.f1588j});
                    }
                }
                break;
            case UNRESTRICTED:
                obj = null;
                i2 = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj2 != null) {
            this.f1581c.mo111a(this.f1583e, k, this);
        }
        if (obj != null) {
            this.f1591m.a(this.f1581c.getClass().toString(), this.f1589k.toString());
            this.f1589k.a();
        }
    }
}
