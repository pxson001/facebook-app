package com.facebook.browser.prefetch;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import com.facebook.analytics.CounterLogger;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.browser.liteclient.qe.ExperimentsForBrowserLiteQEModule;
import com.facebook.browser.prefetch.qe.ExperimentsForBrowserPrefetchModule;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"EmptyCatchBlock"})
/* compiled from: pre_login */
public class BrowserPrefetchCacheManager implements IHaveUserData {
    public static final String f9340a = BrowserPrefetchCacheManager.class.getSimpleName();
    private static volatile BrowserPrefetchCacheManager f9341o;
    private final Context f9342b;
    private final CounterLogger f9343c;
    private final LocalStatsLoggerImpl f9344d;
    private final MoreFileUtils f9345e;
    public final AbstractFbErrorReporter f9346f;
    public final QeAccessor f9347g;
    private final ArticlePreviewer f9348h;
    @Nullable
    private BrowserPrefetchDiskCache f9349i;
    public final Map<String, String> f9350j = Collections.synchronizedMap(new HashMap());
    @Nullable
    private Map<String, Boolean> f9351k;
    private final BaseFbBroadcastManager f9352l;
    @Nullable
    private SelfRegistrableReceiverImpl f9353m;
    private final Handler f9354n;

    public static com.facebook.browser.prefetch.BrowserPrefetchCacheManager m14306a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9341o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.browser.prefetch.BrowserPrefetchCacheManager.class;
        monitor-enter(r1);
        r0 = f9341o;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m14308b(r0);	 Catch:{ all -> 0x0035 }
        f9341o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9341o;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.browser.prefetch.BrowserPrefetchCacheManager.a(com.facebook.inject.InjectorLike):com.facebook.browser.prefetch.BrowserPrefetchCacheManager");
    }

    private static BrowserPrefetchCacheManager m14308b(InjectorLike injectorLike) {
        return new BrowserPrefetchCacheManager(MoreFileUtils.m5023a(injectorLike), CounterLogger.m12608a(injectorLike), LocalStatsLoggerMethodAutoProvider.m13608a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), (Context) injectorLike.getInstance(Context.class), ArticlePreviewer.m14323a(injectorLike), Handler_BackgroundBroadcastThreadMethodAutoProvider.m4110a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike));
    }

    @Inject
    public BrowserPrefetchCacheManager(MoreFileUtils moreFileUtils, CounterLogger counterLogger, LocalStatsLoggerImpl localStatsLoggerImpl, AbstractFbErrorReporter abstractFbErrorReporter, QeAccessor qeAccessor, Context context, ArticlePreviewer articlePreviewer, Handler handler, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f9345e = moreFileUtils;
        this.f9343c = counterLogger;
        this.f9344d = localStatsLoggerImpl;
        this.f9346f = abstractFbErrorReporter;
        this.f9347g = qeAccessor;
        this.f9342b = context;
        this.f9348h = articlePreviewer;
        this.f9354n = handler;
        this.f9352l = baseFbBroadcastManager;
    }

    public final boolean m14317a(String str) {
        return this.f9350j.containsKey(str);
    }

    protected final boolean m14319b(String str) {
        return this.f9350j.containsKey(str) || (this.f9351k != null && this.f9351k.containsKey(str));
    }

    public final String m14320c(String str) {
        if (str == null) {
            return str;
        }
        String str2 = (String) this.f9350j.get(str);
        return str2 != null ? str2 : str;
    }

    public void clearUserData() {
        this.f9351k = null;
        m14309d();
    }

    @TargetApi(12)
    private void m14309d() {
        this.f9350j.clear();
        this.f9349i = null;
        File h = m14315h();
        if (h.exists() && h.isDirectory()) {
            FileTree.a(h);
        }
    }

    @TargetApi(12)
    @Nullable
    public final CacheEntry m14321d(@Nullable String str) {
        if (this.f9349i == null || Strings.isNullOrEmpty(str)) {
            return null;
        }
        CacheEntry cacheEntry = (CacheEntry) this.f9349i.get(str);
        if (cacheEntry == null || cacheEntry.f) {
            return null;
        }
        if (cacheEntry.f) {
            return cacheEntry;
        }
        cacheEntry.f = true;
        this.f9343c.m12611a("browser_prefetch_cache_used");
        this.f9344d.m13616a(1835017);
        return cacheEntry;
    }

    public final String m14322e(String str) {
        if (this.f9349i == null || Strings.isNullOrEmpty(str)) {
            return null;
        }
        CacheEntry cacheEntry = (CacheEntry) this.f9349i.get(str);
        if (cacheEntry == null) {
            return null;
        }
        return cacheEntry.c;
    }

    protected final boolean m14318b() {
        File h = m14315h();
        if (this.f9349i != null && h.exists()) {
            return true;
        }
        boolean mkdirs;
        m14310e();
        m14309d();
        if (!h.exists()) {
            mkdirs = h.mkdirs();
        } else if (!h.isDirectory()) {
            return false;
        } else {
            mkdirs = FileTree.a(h);
        }
        if (mkdirs) {
            int a = this.f9347g.mo572a(ExperimentsForBrowserPrefetchModule.f9372a, 2097152);
            long usableSpace = h.getUsableSpace();
            if (usableSpace < ((long) a)) {
                return false;
            }
            this.f9349i = new BrowserPrefetchDiskCache(this, (int) Math.min((long) a, usableSpace / 2));
        }
        if (this.f9349i == null) {
            return false;
        }
        return true;
    }

    private void m14310e() {
        ObjectInputStream objectInputStream;
        LinkedList linkedList;
        Iterator it;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        int a = this.f9347g.mo572a(ExperimentsForBrowserPrefetchModule.f9378g, 0);
        if (a > 0) {
            File g = m14313g();
            if (g.exists()) {
                ObjectInputStream objectInputStream3;
                try {
                    objectInputStream3 = new ObjectInputStream(new FileInputStream(g));
                } catch (Exception e) {
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                            linkedList = null;
                        } catch (Exception e2) {
                            linkedList = null;
                        }
                        this.f9351k = Collections.synchronizedMap(new FifoMap(a));
                        if (linkedList != null) {
                            Integer.valueOf(linkedList.size());
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                this.f9351k.put((String) it.next(), Boolean.TRUE);
                            }
                        }
                        if (this.f9353m == null) {
                            this.f9353m = this.f9352l.m2951a().mo506a(AppStateManager.f1111c, new 1(this)).mo505a(this.f9354n).mo503a();
                            this.f9353m.m3296b();
                        }
                    }
                    linkedList = null;
                    this.f9351k = Collections.synchronizedMap(new FifoMap(a));
                    if (linkedList != null) {
                        Integer.valueOf(linkedList.size());
                        it = linkedList.iterator();
                        while (it.hasNext()) {
                            this.f9351k.put((String) it.next(), Boolean.TRUE);
                        }
                    }
                    if (this.f9353m == null) {
                        this.f9353m = this.f9352l.m2951a().mo506a(AppStateManager.f1111c, new 1(this)).mo505a(this.f9354n).mo503a();
                        this.f9353m.m3296b();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
                try {
                    linkedList = (LinkedList) objectInputStream3.readObject();
                    try {
                        objectInputStream3.close();
                    } catch (Exception e4) {
                    }
                } catch (Exception e5) {
                    objectInputStream = objectInputStream3;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                        linkedList = null;
                        this.f9351k = Collections.synchronizedMap(new FifoMap(a));
                        if (linkedList != null) {
                            Integer.valueOf(linkedList.size());
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                                this.f9351k.put((String) it.next(), Boolean.TRUE);
                            }
                        }
                        if (this.f9353m == null) {
                            this.f9353m = this.f9352l.m2951a().mo506a(AppStateManager.f1111c, new 1(this)).mo505a(this.f9354n).mo503a();
                            this.f9353m.m3296b();
                        }
                    }
                    linkedList = null;
                    this.f9351k = Collections.synchronizedMap(new FifoMap(a));
                    if (linkedList != null) {
                        Integer.valueOf(linkedList.size());
                        it = linkedList.iterator();
                        while (it.hasNext()) {
                            this.f9351k.put((String) it.next(), Boolean.TRUE);
                        }
                    }
                    if (this.f9353m == null) {
                        this.f9353m = this.f9352l.m2951a().mo506a(AppStateManager.f1111c, new 1(this)).mo505a(this.f9354n).mo503a();
                        this.f9353m.m3296b();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    objectInputStream2 = objectInputStream3;
                    if (objectInputStream2 != null) {
                        objectInputStream2.close();
                    }
                    throw th;
                }
                this.f9351k = Collections.synchronizedMap(new FifoMap(a));
                if (linkedList != null) {
                    Integer.valueOf(linkedList.size());
                    it = linkedList.iterator();
                    while (it.hasNext()) {
                        this.f9351k.put((String) it.next(), Boolean.TRUE);
                    }
                }
                if (this.f9353m == null) {
                    this.f9353m = this.f9352l.m2951a().mo506a(AppStateManager.f1111c, new 1(this)).mo505a(this.f9354n).mo503a();
                    this.f9353m.m3296b();
                }
            }
            linkedList = null;
            this.f9351k = Collections.synchronizedMap(new FifoMap(a));
            if (linkedList != null) {
                Integer.valueOf(linkedList.size());
                it = linkedList.iterator();
                while (it.hasNext()) {
                    this.f9351k.put((String) it.next(), Boolean.TRUE);
                }
            }
            if (this.f9353m == null) {
                this.f9353m = this.f9352l.m2951a().mo506a(AppStateManager.f1111c, new 1(this)).mo505a(this.f9354n).mo503a();
                this.f9353m.m3296b();
            }
        }
    }

    public static void m14312f(BrowserPrefetchCacheManager browserPrefetchCacheManager) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        if (browserPrefetchCacheManager.f9351k != null && browserPrefetchCacheManager.f9351k.size() > 0) {
            Integer.valueOf(browserPrefetchCacheManager.f9351k.size());
            LinkedList linkedList = new LinkedList(browserPrefetchCacheManager.f9351k.keySet());
            ObjectOutputStream objectOutputStream2 = null;
            File g = browserPrefetchCacheManager.m14313g();
            if (!g.exists() || g.delete()) {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(g));
                    try {
                        objectOutputStream.writeObject(linkedList);
                        try {
                            objectOutputStream.close();
                        } catch (IOException e) {
                        }
                    } catch (IOException e2) {
                        try {
                            g.delete();
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            objectOutputStream2 = objectOutputStream;
                            th = th3;
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (IOException e4) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (IOException e5) {
                    objectOutputStream = null;
                    g.delete();
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                    throw th;
                }
            }
        }
    }

    @SuppressLint({"StringReferenceComparison"})
    @TargetApi(12)
    protected final void m14316a(String str, String str2, InputStream inputStream, @Nullable String str3) {
        if (str != str2) {
            this.f9350j.put(str, str2);
        }
        if (this.f9351k != null) {
            this.f9351k.put(str, Boolean.TRUE);
        }
        this.f9349i.remove(str2);
        File g = m14314g(str2);
        if (!g.exists()) {
            try {
                this.f9345e.m5035a(inputStream, g);
                File a = m14307a(g, str2);
                if (a != null) {
                    a.getAbsolutePath();
                    this.f9349i.put(str2, new CacheEntry(a, str, str3));
                    if (str == str2) {
                        this.f9350j.put(str, str2);
                    }
                    this.f9343c.m12611a("browser_prefetch_cache_stored");
                    this.f9344d.m13616a(1835016);
                    if (this.f9347g.mo596a(ExperimentsForBrowserLiteQEModule.f24028b, false)) {
                        this.f9348h.m14325a(str, a);
                    }
                    g.delete();
                }
            } finally {
                g.delete();
            }
        } else if (!g.delete()) {
            this.f9346f.m2340a(f9340a + ".putInCache", "Failed delete existing tmp cache file for " + str2);
        }
    }

    @Nullable
    private File m14307a(File file, String str) {
        File f = m14311f(str);
        if (f.exists() && !f.delete()) {
            this.f9346f.m2340a(f9340a + ".moveTmpFileToProd", "Failed delete existing cache file for " + str);
            file.delete();
            return null;
        } else if (file.renameTo(f)) {
            return f;
        } else {
            this.f9346f.m2340a(f9340a + ".moveTmpFileToProd", "Failed rename tmp file to production " + str);
            file.delete();
            return null;
        }
    }

    private File m14311f(String str) {
        return new File(m14315h(), SecureHashUtil.b(str));
    }

    private File m14314g(String str) {
        return new File(m14315h(), SecureHashUtil.b(str) + ".tmp");
    }

    private File m14313g() {
        return new File(m14315h(), "skip_prefetch_urls");
    }

    private File m14315h() {
        return new File(this.f9342b.getCacheDir(), "browser_prefetch_cache");
    }
}
