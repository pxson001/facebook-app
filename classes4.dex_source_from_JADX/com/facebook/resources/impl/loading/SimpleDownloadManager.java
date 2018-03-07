package com.facebook.resources.impl.loading;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.facebook.common.android.DownloadManagerMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.resources.impl.loading.LanguagePrefetcher.1;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@TargetApi(9)
/* compiled from: lockscreen database was full */
public class SimpleDownloadManager implements INeedInit {
    private static final Class<?> f9094a = SimpleDownloadManager.class;
    private static final PrefKey f9095b;
    private static final PrefKey f9096c;
    private static final PrefKey f9097d = ((PrefKey) f9095b.a("id/"));
    private static volatile SimpleDownloadManager f9098k;
    private final Context f9099e;
    private final DownloadManager f9100f;
    private final FbSharedPreferences f9101g;
    private final Map<String, Callback> f9102h = Maps.c();
    private final AtomicBoolean f9103i = new AtomicBoolean(false);
    private DynamicSecureBroadcastReceiver f9104j;

    /* compiled from: lockscreen database was full */
    class C05471 implements ActionReceiver {
        final /* synthetic */ SimpleDownloadManager f11346a;

        C05471(SimpleDownloadManager simpleDownloadManager) {
            this.f11346a = simpleDownloadManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1691965609);
            synchronized (this.f11346a) {
                try {
                    SimpleDownloadManager.m9432a(this.f11346a, intent);
                } finally {
                    LogUtils.e(-1128823939, a);
                }
            }
        }
    }

    public static com.facebook.resources.impl.loading.SimpleDownloadManager m9428a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9098k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.resources.impl.loading.SimpleDownloadManager.class;
        monitor-enter(r1);
        r0 = f9098k;	 Catch:{ all -> 0x003a }
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
        r0 = m9436b(r0);	 Catch:{ all -> 0x0035 }
        f9098k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9098k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.resources.impl.loading.SimpleDownloadManager.a(com.facebook.inject.InjectorLike):com.facebook.resources.impl.loading.SimpleDownloadManager");
    }

    private static SimpleDownloadManager m9436b(InjectorLike injectorLike) {
        return new SimpleDownloadManager((Context) injectorLike.getInstance(Context.class), DownloadManagerMethodAutoProvider.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("simplified_download_manager/");
        f9095b = prefKey;
        f9096c = (PrefKey) prefKey.a("extra/");
    }

    @Inject
    public SimpleDownloadManager(Context context, DownloadManager downloadManager, FbSharedPreferences fbSharedPreferences) {
        this.f9099e = context;
        this.f9100f = downloadManager;
        this.f9101g = fbSharedPreferences;
    }

    public final synchronized void m9440a(String str, String str2, 1 1, @Nullable String str3) {
        if (this.f9103i.get()) {
            Request allowedNetworkTypes = new Request(Uri.parse(str2)).setAllowedNetworkTypes(2);
            m9431a(allowedNetworkTypes);
            if (this.f9102h.containsKey(str)) {
                throw new RuntimeException("There can only be one callback for identifier " + str);
            }
            this.f9102h.put(str, 1);
            long a = this.f9101g.a((PrefKey) f9097d.a(str), -1);
            if (a > 0) {
                m9429a(a);
            } else {
                m9434a(str, str2, str3, allowedNetworkTypes);
            }
        } else {
            throw new IllegalStateException("SimpleDownloadManager used before initialization");
        }
    }

    private void m9434a(String str, String str2, String str3, Request request) {
        this.f9101g.edit().a((PrefKey) f9097d.a(str), this.f9100f.enqueue(request)).a((PrefKey) f9096c.a(str), str3).commit();
        new StringBuilder("Started download task for url: ").append(str2);
    }

    @TargetApi(11)
    private static void m9431a(Request request) {
        if (VERSION.SDK_INT >= 11) {
            request.setNotificationVisibility(2);
        } else {
            request.setShowRunningNotification(false);
        }
    }

    public synchronized void init() {
        this.f9104j = new DynamicSecureBroadcastReceiver(ImmutableBiMap.b("android.intent.action.DOWNLOAD_COMPLETE", new C05471(this)));
        this.f9099e.registerReceiver(this.f9104j, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        this.f9103i.set(true);
    }

    public static void m9432a(SimpleDownloadManager simpleDownloadManager, Intent intent) {
        simpleDownloadManager.m9429a(intent.getExtras().getLong("extra_download_id"));
    }

    private void m9429a(long j) {
        String c = m9439c(j);
        if (c != null) {
            int b = m9435b(j);
            if (b != 1 && b != 2) {
                try {
                    m9430a(j, c, b);
                } finally {
                    m9433a(c);
                }
            }
        }
    }

    private void m9430a(long j, String str, int i) {
        1 c = m9438c(str);
        if (c != null && i != 0) {
            if (i != 8) {
                try {
                    throw new RuntimeException("DownloadManager failed with status code " + i);
                } catch (Throwable e) {
                    c.a(e);
                    return;
                }
            }
            c.a(new AutoCloseInputStream(this.f9100f.openDownloadedFile(j)), m9437b(str));
        }
    }

    private int m9435b(long j) {
        int i = 0;
        Query query = new Query();
        query.setFilterById(new long[]{j});
        Cursor query2 = this.f9100f.query(query);
        try {
            if (query2.moveToFirst()) {
                i = query2.getInt(query2.getColumnIndex("status"));
                query2.close();
            }
            return i;
        } finally {
            query2.close();
        }
    }

    private void m9433a(String str) {
        this.f9101g.edit().a((PrefKey) f9097d.a(str)).a((PrefKey) f9096c.a(str)).commit();
    }

    private String m9439c(long j) {
        for (Entry entry : this.f9101g.e(f9097d).entrySet()) {
            if (entry.getValue().equals(Long.valueOf(j))) {
                return ((PrefKey) entry.getKey()).b(f9097d);
            }
        }
        return null;
    }

    private String m9437b(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f9101g.a((PrefKey) f9096c.a(str), null);
    }

    @Nullable
    private 1 m9438c(@Nullable String str) {
        return str == null ? null : (1) this.f9102h.get(str);
    }
}
