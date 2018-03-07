package com.facebook.common.diagnostics;

import android.annotation.SuppressLint;
import android.content.Context;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.init.INeedInit;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.forker.Process;
import com.facebook.gk.listeners.GatekeeperListenersImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperListeners;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.OnGatekeeperChangeListener;
import com.facebook.gk.store.internal.GatekeeperListenersImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: mutual_contacts_count */
public class LogcatFbSdcardLogger implements IHaveUserData, INeedInit {
    private static final Set<PrefKey> f7314a = ImmutableSet.of(DebugLoggingPrefKeys.b, DebugLoggingPrefKeys.g);
    private static volatile LogcatFbSdcardLogger f7315l;
    private final FbSharedPreferences f7316b;
    private final GatekeeperListenersImpl f7317c;
    private final Provider<Boolean> f7318d;
    private final File f7319e;
    private final Context f7320f;
    @GuardedBy("this")
    private boolean f7321g;
    @GuardedBy("this")
    private Process f7322h = null;
    @GuardedBy("this")
    private boolean f7323i;
    private OnSharedPreferenceChangeListener f7324j;
    private OnGatekeeperChangeListener f7325k;

    /* compiled from: mutual_contacts_count */
    class C03481 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ LogcatFbSdcardLogger f7326a;

        C03481(LogcatFbSdcardLogger logcatFbSdcardLogger) {
            this.f7326a = logcatFbSdcardLogger;
        }

        public final void m7660a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            LogcatFbSdcardLogger.m7654c(this.f7326a);
        }
    }

    /* compiled from: mutual_contacts_count */
    class C03492 extends OnGatekeeperChangeListener {
        final /* synthetic */ LogcatFbSdcardLogger f7327a;

        C03492(LogcatFbSdcardLogger logcatFbSdcardLogger) {
            this.f7327a = logcatFbSdcardLogger;
        }

        public final void m7661a(GatekeeperStoreImpl gatekeeperStoreImpl, int i) {
            LogcatFbSdcardLogger.m7654c(this.f7327a);
        }
    }

    public static com.facebook.common.diagnostics.LogcatFbSdcardLogger m7648a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f7315l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.diagnostics.LogcatFbSdcardLogger.class;
        monitor-enter(r1);
        r0 = f7315l;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m7652b(r0);	 Catch:{ all -> 0x0035 }
        f7315l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7315l;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.diagnostics.LogcatFbSdcardLogger.a(com.facebook.inject.InjectorLike):com.facebook.common.diagnostics.LogcatFbSdcardLogger");
    }

    private static LogcatFbSdcardLogger m7652b(InjectorLike injectorLike) {
        return new LogcatFbSdcardLogger((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GatekeeperListenersImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3925));
    }

    @Inject
    public LogcatFbSdcardLogger(Context context, FbSharedPreferences fbSharedPreferences, GatekeeperListeners gatekeeperListeners, Provider<Boolean> provider) {
        this.f7320f = context;
        this.f7316b = fbSharedPreferences;
        this.f7317c = gatekeeperListeners;
        this.f7318d = provider;
        this.f7319e = this.f7320f.getDir("logcat_flash_logs", 0);
    }

    public synchronized void init() {
        this.f7324j = new C03481(this);
        this.f7316b.a(f7314a, this.f7324j);
        this.f7325k = new C03492(this);
        this.f7317c.a(this.f7325k, 556);
        m7654c(this);
        m7653b();
    }

    private void m7653b() {
        File dir = this.f7320f.getDir("logcat", 0);
        if (dir.exists()) {
            m7649a(dir);
        }
    }

    private static void m7649a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    m7649a(file2);
                } else {
                    file2.delete();
                }
            }
        }
        file.delete();
    }

    public static synchronized void m7654c(LogcatFbSdcardLogger logcatFbSdcardLogger) {
        synchronized (logcatFbSdcardLogger) {
            logcatFbSdcardLogger.f7321g = ((Boolean) logcatFbSdcardLogger.f7318d.get()).booleanValue();
            if (logcatFbSdcardLogger.f7321g) {
                logcatFbSdcardLogger.m7655d();
            } else {
                logcatFbSdcardLogger.m7658g();
            }
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.Thread.start"})
    private synchronized void m7655d() {
        if (this.f7322h == null && !this.f7323i) {
            this.f7323i = true;
            ThreadInitDetour.a(new 3(this), "logcat-manager", -511013069).start();
        }
    }

    public static void m7656e(LogcatFbSdcardLogger logcatFbSdcardLogger) {
        Throwable th;
        FileOutputStream fileOutputStream = new FileOutputStream(logcatFbSdcardLogger.f7319e.getCanonicalPath() + "/lock");
        Throwable th2 = null;
        try {
            fileOutputStream.getChannel().lock();
            logcatFbSdcardLogger.m7657f();
            fileOutputStream.close();
            return;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (th22 != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable th4) {
                AndroidCompat.addSuppressed(th22, th4);
            }
        } else {
            fileOutputStream.close();
        }
        throw th;
        throw th;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7657f() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = 0;
        r5.f7323i = r0;	 Catch:{ all -> 0x006e }
        r0 = r5.f7322h;	 Catch:{ all -> 0x006e }
        if (r0 != 0) goto L_0x000c;
    L_0x0008:
        r0 = r5.f7321g;	 Catch:{ all -> 0x006e }
        if (r0 != 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r5);	 Catch:{ all -> 0x006e }
    L_0x000d:
        return;
    L_0x000e:
        r0 = new com.facebook.forker.ProcessBuilder;	 Catch:{ all -> 0x006e }
        r1 = "/system/bin/logcat";
        r2 = 0;
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x006e }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x006e }
        r1 = 6;
        r1 = new java.lang.String[r1];	 Catch:{ all -> 0x006e }
        r2 = 0;
        r3 = "-v";
        r1[r2] = r3;	 Catch:{ all -> 0x006e }
        r2 = 1;
        r3 = "threadtime";
        r1[r2] = r3;	 Catch:{ all -> 0x006e }
        r2 = 2;
        r3 = "-f";
        r1[r2] = r3;	 Catch:{ all -> 0x006e }
        r2 = 3;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006e }
        r3.<init>();	 Catch:{ all -> 0x006e }
        r4 = r5.f7319e;	 Catch:{ all -> 0x006e }
        r4 = r4.getCanonicalPath();	 Catch:{ all -> 0x006e }
        r3 = r3.append(r4);	 Catch:{ all -> 0x006e }
        r4 = "/logs";
        r3 = r3.append(r4);	 Catch:{ all -> 0x006e }
        r3 = r3.toString();	 Catch:{ all -> 0x006e }
        r1[r2] = r3;	 Catch:{ all -> 0x006e }
        r2 = 4;
        r3 = "-r4096";
        r1[r2] = r3;	 Catch:{ all -> 0x006e }
        r2 = 5;
        r3 = "-n4";
        r1[r2] = r3;	 Catch:{ all -> 0x006e }
        r0 = r0.addArguments(r1);	 Catch:{ all -> 0x006e }
        r0 = r0.create();	 Catch:{ all -> 0x006e }
        r5.f7322h = r0;	 Catch:{ all -> 0x006e }
        monitor-exit(r5);	 Catch:{ all -> 0x006e }
        r0.waitForUninterruptibly();	 Catch:{ all -> 0x0071 }
        r0.destroy();
        monitor-enter(r5);
        r1 = r5.f7322h;	 Catch:{ all -> 0x006b }
        if (r1 != r0) goto L_0x0069;
    L_0x0066:
        r0 = 0;
        r5.f7322h = r0;	 Catch:{ all -> 0x006b }
    L_0x0069:
        monitor-exit(r5);	 Catch:{ all -> 0x006b }
        goto L_0x000d;
    L_0x006b:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x006b }
        throw r0;
    L_0x006e:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{  }
        throw r0;
    L_0x0071:
        r1 = move-exception;
        r0.destroy();
        monitor-enter(r5);
        r2 = r5.f7322h;	 Catch:{ all -> 0x007f }
        if (r2 != r0) goto L_0x007d;
    L_0x007a:
        r0 = 0;
        r5.f7322h = r0;	 Catch:{ all -> 0x007f }
    L_0x007d:
        monitor-exit(r5);	 Catch:{ all -> 0x007f }
        throw r1;
    L_0x007f:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.diagnostics.LogcatFbSdcardLogger.f():void");
    }

    private synchronized void m7658g() {
        this.f7321g = false;
        if (this.f7322h != null) {
            this.f7322h.destroy();
            this.f7322h = null;
        }
    }

    public synchronized void clearUserData() {
        m7658g();
        File[] listFiles = this.f7319e.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (m7651a(file.getName())) {
                    file.delete();
                }
            }
        }
    }

    private static boolean m7651a(String str) {
        return !"lock".equals(str);
    }

    public final synchronized List<File> m7659a() {
        List<File> emptyList;
        if (!this.f7321g) {
            emptyList = Collections.emptyList();
        } else if (this.f7319e == null) {
            emptyList = Collections.emptyList();
        } else {
            File[] listFiles = this.f7319e.listFiles();
            if (listFiles == null) {
                emptyList = Collections.emptyList();
            } else {
                m7650a(listFiles);
                emptyList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    if (m7651a(file.getName())) {
                        emptyList.add(file);
                    }
                }
            }
        }
        return emptyList;
    }

    @VisibleForTesting
    private static void m7650a(File[] fileArr) {
        Arrays.sort(fileArr, new 4());
    }
}
