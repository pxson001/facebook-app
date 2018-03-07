package com.facebook.browser.liteclient.logging;

import android.content.Context;
import android.os.Handler;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_cu */
public class BrowserOpenUrlLogger {
    public static final PrefKey f10634a = ((PrefKey) ((PrefKey) SharedPrefKeys.a.a("fb_android")).a("browser_alive_marker"));
    private static final String f10635b = BrowserOpenUrlLogger.class.getSimpleName();
    private static volatile BrowserOpenUrlLogger f10636k;
    private final AnalyticsLogger f10637c;
    private final DeviceConditionHelper f10638d;
    private final FbNetworkManager f10639e;
    private HoneyClientEvent f10640f;
    private long f10641g = -1;
    private Context f10642h;
    private Handler f10643i;
    public FbSharedPreferences f10644j;

    public static com.facebook.browser.liteclient.logging.BrowserOpenUrlLogger m12574a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10636k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.browser.liteclient.logging.BrowserOpenUrlLogger.class;
        monitor-enter(r1);
        r0 = f10636k;	 Catch:{ all -> 0x003a }
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
        r0 = m12577b(r0);	 Catch:{ all -> 0x0035 }
        f10636k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10636k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.browser.liteclient.logging.BrowserOpenUrlLogger.a(com.facebook.inject.InjectorLike):com.facebook.browser.liteclient.logging.BrowserOpenUrlLogger");
    }

    private static BrowserOpenUrlLogger m12577b(InjectorLike injectorLike) {
        return new BrowserOpenUrlLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), DeviceConditionHelper.a(injectorLike), FbNetworkManager.a(injectorLike), (Context) injectorLike.getInstance(Context.class), Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public BrowserOpenUrlLogger(AnalyticsLogger analyticsLogger, DeviceConditionHelper deviceConditionHelper, FbNetworkManager fbNetworkManager, Context context, Handler handler, FbSharedPreferences fbSharedPreferences) {
        this.f10637c = analyticsLogger;
        this.f10638d = deviceConditionHelper;
        this.f10639e = fbNetworkManager;
        this.f10642h = context;
        this.f10643i = handler;
        this.f10644j = fbSharedPreferences;
    }

    public final synchronized void m12581a(String str, String str2, @Nullable String str3, @Nullable String str4) {
        this.f10641g = System.currentTimeMillis();
        this.f10640f = new HoneyClientEvent("fb4a_iab_open_url");
        final Map hashMap = new HashMap();
        hashMap.put("initial_url", str);
        hashMap.put("handler_time", Long.valueOf(this.f10641g));
        hashMap.put("prefetch", str2);
        hashMap.put("click_source", str3);
        if (!(str4 == null || str3 == null || !str3.endsWith("_ads"))) {
            hashMap.put("tracking_codes", str4);
        }
        if (!this.f10639e.d()) {
            hashMap.put("client_network", "offline");
        } else if (this.f10638d.b()) {
            hashMap.put("client_network", "wifi");
        } else {
            hashMap.put("client_network", "mobile");
        }
        this.f10640f.a(hashMap);
        HandlerDetour.a(this.f10643i, new Runnable(this) {
            final /* synthetic */ BrowserOpenUrlLogger f10633b;

            public void run() {
                if (this.f10633b.f10644j.a(BrowserOpenUrlLogger.f10634a, false)) {
                    BrowserOpenUrlLogger.m12575a(this.f10633b);
                }
                BrowserOpenUrlLogger.m12576a(this.f10633b, hashMap);
                this.f10633b.f10644j.edit().putBoolean(BrowserOpenUrlLogger.f10634a, true).commit();
            }
        }, 624559128);
    }

    public static void m12575a(BrowserOpenUrlLogger browserOpenUrlLogger) {
        Map c = browserOpenUrlLogger.m12578c();
        if (c != null) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb4a_iab_open_url");
            honeyClientEvent.a(c);
            honeyClientEvent.b("crash", "1");
            browserOpenUrlLogger.f10637c.a(honeyClientEvent);
        }
    }

    public static void m12576a(BrowserOpenUrlLogger browserOpenUrlLogger, Map map) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Throwable th2;
        File file = new File(browserOpenUrlLogger.f10642h.getFilesDir(), "browser_open_url_logger");
        if (!file.exists() || file.delete()) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                if (file.createNewFile()) {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                    try {
                        objectOutputStream.writeObject(map);
                        try {
                            objectOutputStream.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    } catch (IOException e2) {
                        objectOutputStream2 = objectOutputStream;
                        try {
                            file.delete();
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                    return;
                                } catch (IOException e3) {
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            objectOutputStream = objectOutputStream2;
                            th2 = th;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        throw th2;
                    }
                }
                file.getAbsolutePath();
                return;
            } catch (IOException e5) {
                file.delete();
                if (objectOutputStream2 != null) {
                    objectOutputStream2.close();
                    return;
                }
                return;
            } catch (Throwable th32) {
                th = th32;
                objectOutputStream = null;
                th2 = th;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                throw th2;
            }
        }
        file.getAbsolutePath();
    }

    @Nullable
    private Map<String, Object> m12578c() {
        ObjectInputStream objectInputStream;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        File file = new File(this.f10642h.getFilesDir(), "browser_open_url_logger");
        if (!file.exists()) {
            return null;
        }
        try {
            ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(file));
            try {
                HashMap hashMap = (HashMap) objectInputStream3.readObject();
                try {
                    objectInputStream3.close();
                    return hashMap;
                } catch (Exception e) {
                    return hashMap;
                }
            } catch (Exception e2) {
                objectInputStream = objectInputStream3;
                try {
                    new Object[1][0] = file.getAbsoluteFile();
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    objectInputStream2 = objectInputStream;
                    th = th3;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                objectInputStream2 = objectInputStream3;
                if (objectInputStream2 != null) {
                    objectInputStream2.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            objectInputStream = null;
            new Object[1][0] = file.getAbsoluteFile();
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            throw th;
        }
    }

    private void m12579e() {
        this.f10644j.edit().a(f10634a).commit();
    }

    public final synchronized void m12580a(String str, long j, long j2, long j3, long j4, long j5, boolean z) {
        if (this.f10640f != null) {
            long max;
            m12579e();
            this.f10640f.b("current_url", str);
            this.f10640f.a("load_starts_ms", j);
            this.f10640f.a("response_end_ms", j2);
            this.f10640f.a("dom_content_loaded_ms", j3);
            this.f10640f.a("load_event_end_ms", j4);
            this.f10640f.a("scroll_ready_ms", j5);
            this.f10640f.b("refresh", z ? "1" : "0");
            this.f10637c.a(this.f10640f);
            long j6 = j > 0 ? j - this.f10641g : -1;
            if (j3 <= 0 || j5 <= 0) {
                max = Math.max(j3, j5);
            } else {
                max = Math.min(j3, j5);
            }
            max = max > 0 ? max - this.f10641g : -1;
            Long.valueOf(j6);
            Long.valueOf(max);
            this.f10640f = null;
            this.f10641g = -1;
        }
    }
}
