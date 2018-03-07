package com.facebook.crudolib.prefs;

import android.os.Handler;
import android.os.Looper;
import com.facebook.crudolib.prefs.LightSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.File;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: uvm/ */
public class LightSharedPreferencesImpl {
    public static final Object f1380a = new Object();
    private static final Handler f1381b = new Handler(Looper.getMainLooper());
    public final Object f1382c = new Object();
    public final Executor f1383d;
    public final CountDownLatch f1384e;
    public final LightSharedPreferencesStorage f1385f;
    @GuardedBy("this")
    private final Map<String, Map<OnSharedPreferenceChangeListener, Handler>> f1386g;
    @GuardedBy("mCacheLock")
    public final Map<String, Object> f1387h;
    public final AtomicBoolean f1388i = new AtomicBoolean(false);
    private volatile boolean f1389j = false;

    /* compiled from: uvm/ */
    public class C00941 implements Runnable {
        final /* synthetic */ LightSharedPreferencesImpl f1392a;

        public C00941(LightSharedPreferencesImpl lightSharedPreferencesImpl) {
            this.f1392a = lightSharedPreferencesImpl;
        }

        public void run() {
            try {
                synchronized (this.f1392a.f1382c) {
                    this.f1392a.f1385f.m2655a(this.f1392a.f1387h);
                }
            } catch (Throwable e) {
                BLog.a("LightSharedPreferencesImpl", "Failed to load preference file from Disk!", e);
            } catch (UnknownVersionException e2) {
                BLog.a("LightSharedPreferencesImpl", "Failed to parse the preference file!", e2);
            } finally {
                this.f1392a.f1389j = true;
                this.f1392a.f1384e.countDown();
            }
        }
    }

    /* compiled from: uvm/ */
    public class EditorImpl implements LightSharedPreferences$Editor {
        final /* synthetic */ LightSharedPreferencesImpl f22509a;
        private final Map<String, Object> f22510b = new HashMap(4);
        private volatile boolean f22511c = false;
        private volatile boolean f22512d = false;

        /* compiled from: uvm/ */
        class C09181 implements Runnable {
            final /* synthetic */ EditorImpl f22513a;

            C09181(EditorImpl editorImpl) {
                this.f22513a = editorImpl;
            }

            public void run() {
                EditorImpl.m30362d(this.f22513a);
            }
        }

        public EditorImpl(LightSharedPreferencesImpl lightSharedPreferencesImpl) {
            this.f22509a = lightSharedPreferencesImpl;
        }

        public final LightSharedPreferences$Editor mo3285a(String str, boolean z) {
            m30364f();
            this.f22510b.put(LightSharedPreferencesImpl.m2638b(str), Boolean.valueOf(z));
            return this;
        }

        public final LightSharedPreferences$Editor mo3281a(String str, int i) {
            m30364f();
            this.f22510b.put(LightSharedPreferencesImpl.m2638b(str), Integer.valueOf(i));
            return this;
        }

        public final LightSharedPreferences$Editor mo3282a(String str, long j) {
            m30364f();
            this.f22510b.put(LightSharedPreferencesImpl.m2638b(str), Long.valueOf(j));
            return this;
        }

        public final LightSharedPreferences$Editor mo3280a(String str, float f) {
            m30364f();
            this.f22510b.put(LightSharedPreferencesImpl.m2638b(str), Float.valueOf(f));
            return this;
        }

        public final LightSharedPreferences$Editor mo3283a(String str, String str2) {
            m30364f();
            if (str2 == null) {
                this.f22510b.put(LightSharedPreferencesImpl.m2638b(str), LightSharedPreferencesImpl.f1380a);
            } else {
                this.f22510b.put(LightSharedPreferencesImpl.m2638b(str), str2);
            }
            return this;
        }

        public final LightSharedPreferences$Editor mo3284a(String str, Set<String> set) {
            m30364f();
            if (set == null) {
                this.f22510b.put(LightSharedPreferencesImpl.m2638b(str), LightSharedPreferencesImpl.f1380a);
            } else {
                this.f22510b.put(LightSharedPreferencesImpl.m2638b(str), set);
            }
            return this;
        }

        public final LightSharedPreferences$Editor mo3279a(String str) {
            m30364f();
            this.f22510b.put(LightSharedPreferencesImpl.m2638b(str), LightSharedPreferencesImpl.f1380a);
            return this;
        }

        public final LightSharedPreferences$Editor mo3278a() {
            m30364f();
            this.f22511c = true;
            return this;
        }

        public final boolean mo3286b() {
            try {
                Set a = m30360a(m30363e());
                if (a.isEmpty()) {
                    m30365g();
                    return true;
                }
                LightSharedPreferencesImpl.m2636a(this.f22509a, a);
                boolean d = m30362d(this);
                return d;
            } finally {
                m30365g();
            }
        }

        public final void mo3287c() {
            try {
                Set a = m30360a(m30363e());
                if (!a.isEmpty()) {
                    LightSharedPreferencesImpl.m2636a(this.f22509a, a);
                    ExecutorDetour.a(this.f22509a.f1383d, new C09181(this), 1446647426);
                }
                m30365g();
            } catch (Throwable th) {
                m30365g();
            }
        }

        private Set<String> m30360a(Map<String, Object> map) {
            Set<String> hashSet = new HashSet();
            synchronized (this.f22509a.f1382c) {
                if (this.f22511c) {
                    hashSet.addAll(this.f22509a.f1387h.keySet());
                    this.f22509a.f1387h.clear();
                }
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value == LightSharedPreferencesImpl.f1380a) {
                        this.f22509a.f1387h.remove(str);
                    } else if (!LightSharedPreferencesImpl.m2638b(value).equals(this.f22509a.f1387h.get(str))) {
                        this.f22509a.f1387h.put(str, value);
                    }
                    hashSet.add(str);
                }
                this.f22509a.f1388i.compareAndSet(false, !hashSet.isEmpty());
            }
            this.f22511c = false;
            map.clear();
            return hashSet;
        }

        public static boolean m30362d(EditorImpl editorImpl) {
            if (!editorImpl.f22509a.f1388i.get()) {
                return true;
            }
            Map hashMap;
            synchronized (editorImpl.f22509a.f1382c) {
                editorImpl.f22509a.f1388i.set(false);
                hashMap = new HashMap(editorImpl.f22509a.f1387h);
            }
            return editorImpl.m30361b(hashMap);
        }

        private boolean m30361b(Map<String, Object> map) {
            try {
                this.f22509a.f1385f.m2656b((Map) LightSharedPreferencesImpl.m2638b(map));
                return true;
            } catch (Throwable e) {
                BLog.a("LightSharedPreferencesImpl", "Commit to disk failed.", e);
                return false;
            }
        }

        private synchronized Map<String, Object> m30363e() {
            if (this.f22512d) {
                throw new RuntimeException("Trying to freeze an editor that is already frozen!");
            }
            this.f22512d = true;
            return this.f22510b;
        }

        private void m30364f() {
            if (this.f22512d) {
                throw new ConcurrentModificationException("Editors shouldn't be modified during commit!");
            }
        }

        private synchronized void m30365g() {
            this.f22512d = false;
        }
    }

    LightSharedPreferencesImpl(File file, Executor executor) {
        this.f1385f = new LightSharedPreferencesStorage((File) m2638b(file));
        this.f1387h = new HashMap();
        this.f1386g = new HashMap();
        this.f1383d = (Executor) m2638b(executor);
        this.f1384e = new CountDownLatch(1);
        ExecutorDetour.a(this.f1383d, new C00941(this), 1385397497);
    }

    private void m2639e() {
        while (!this.f1389j) {
            try {
                this.f1384e.await();
                return;
            } catch (InterruptedException e) {
            }
        }
    }

    public final Map<String, ?> m2644a() {
        Map hashMap;
        m2639e();
        synchronized (this.f1382c) {
            hashMap = new HashMap(this.f1387h);
        }
        return hashMap;
    }

    public final boolean m2647a(String str, boolean z) {
        m2639e();
        synchronized (this.f1382c) {
            try {
                Boolean bool = (Boolean) this.f1387h.get(str);
                if (bool != null) {
                    z = bool.booleanValue();
                }
            } catch (Exception e) {
                throw m2635a(e, str);
            }
        }
        return z;
    }

    public final int m2641a(String str, int i) {
        m2639e();
        synchronized (this.f1382c) {
            try {
                Integer num = (Integer) this.f1387h.get(str);
                if (num != null) {
                    i = num.intValue();
                }
            } catch (Exception e) {
                throw m2635a(e, str);
            }
        }
        return i;
    }

    public final long m2642a(String str, long j) {
        m2639e();
        synchronized (this.f1382c) {
            try {
                Long l = (Long) this.f1387h.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            } catch (Exception e) {
                throw m2635a(e, str);
            }
        }
        return j;
    }

    public final float m2640a(String str, float f) {
        m2639e();
        synchronized (this.f1382c) {
            try {
                Float f2 = (Float) this.f1387h.get(str);
                if (f2 != null) {
                    f = f2.floatValue();
                }
            } catch (Exception e) {
                throw m2635a(e, str);
            }
        }
        return f;
    }

    public final String m2643a(String str, String str2) {
        String str3;
        m2639e();
        synchronized (this.f1382c) {
            try {
                str3 = (String) this.f1387h.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
            } catch (Exception e) {
                throw m2635a(e, str);
            }
        }
        return str3;
    }

    public final Set<String> m2645a(String str, Set<String> set) {
        Set<String> set2;
        m2639e();
        synchronized (this.f1382c) {
            try {
                set2 = (Set) this.f1387h.get(str);
                if (set2 == null) {
                    set2 = set;
                }
            } catch (Exception e) {
                throw m2635a(e, str);
            }
        }
        return set2;
    }

    public final boolean m2646a(String str) {
        boolean containsKey;
        m2639e();
        synchronized (this.f1382c) {
            containsKey = this.f1387h.containsKey(str);
        }
        return containsKey;
    }

    public final LightSharedPreferences$Editor m2648b() {
        m2639e();
        return new EditorImpl(this);
    }

    public static synchronized void m2636a(LightSharedPreferencesImpl lightSharedPreferencesImpl, Set set) {
        synchronized (lightSharedPreferencesImpl) {
            for (String str : set) {
                Map map = (Map) lightSharedPreferencesImpl.f1386g.get(str);
                if (map != null) {
                    for (Entry entry : map.entrySet()) {
                        HandlerDetour.a((Handler) entry.getValue(), new 2(lightSharedPreferencesImpl, (OnSharedPreferenceChangeListener) entry.getKey(), str), -1502616101);
                    }
                }
            }
        }
    }

    public static <T> T m2638b(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    private RuntimeException m2635a(Exception exception, String str) {
        String str2 = null;
        try {
            str2 = this.f1385f.m2654a();
        } catch (Throwable e) {
            BLog.a("LightSharedPreferencesImpl", e, "Failed to load the file for soft report!", new Object[0]);
        }
        return new RuntimeException("LightSharedPreferences threw an exception for Key: " + str + "; Raw file: " + str2, exception);
    }
}
