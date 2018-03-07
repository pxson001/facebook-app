package com.facebook.sideloading;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.content.event.FbEvent;
import com.facebook.downloader.DownloadRequest.DownloadType;
import com.facebook.downloader.FbDownloadManager;
import com.facebook.downloader.event.DownloadBroadcastEvent;
import com.facebook.downloader.event.DownloadCleanupEvent;
import com.facebook.downloader.event.DownloadErrorEvent;
import com.facebook.downloader.event.DownloadErrorEvent.ErrorCode;
import com.facebook.downloader.event.DownloadEventBus;
import com.facebook.downloader.event.DownloadEventSubscriber;
import com.facebook.downloader.event.DownloadInfoEvent;
import com.facebook.downloader.event.DownloadInfoEvent.InfoEvent;
import com.facebook.downloader.event.DownloadSuccessEvent;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.selfupdate.PackageValidator;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.jar.JarFile;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: unknown itemViewType  */
public class SideloadingManager {
    private static final Class<?> f10054a = SideloadingManager.class;
    private static volatile SideloadingManager f10055u;
    private final FbDownloadManager f10056b;
    private final DownloadEventBus f10057c;
    public final FbSharedPreferences f10058d;
    public final ExecutorService f10059e;
    private final StatFsHelper f10060f;
    private final MoreFileUtils f10061g;
    private final PackageValidator f10062h;
    private final DefaultBlueServiceOperationFactory f10063i;
    private final SideloadingNotifier f10064j;
    public final SideloadingFileUtils f10065k;
    private final SideloadingChecker f10066l;
    private final SideloadingLogger f10067m;
    private final DownloadBroadcastEventHandler f10068n = new DownloadBroadcastEventHandler(this);
    private final DownloadCleanupEventHandler f10069o = new DownloadCleanupEventHandler(this);
    private final DownloadErrorEventHandler f10070p = new DownloadErrorEventHandler(this);
    private final DownloadInfoEventHandler f10071q = new DownloadInfoEventHandler(this);
    private final DownloadSuccessEventHandler f10072r = new DownloadSuccessEventHandler(this);
    @Nullable
    public String f10073s;
    public DownloadingButtonListener f10074t;

    /* compiled from: unknown itemViewType  */
    public interface DownloadingButtonListener {
        void mo38a();
    }

    /* compiled from: unknown itemViewType  */
    public class C14782 implements Runnable {
        final /* synthetic */ long f10041a;
        final /* synthetic */ SideloadingManager f10042b;

        public C14782(SideloadingManager sideloadingManager, long j) {
            this.f10042b = sideloadingManager;
            this.f10041a = j;
        }

        public void run() {
            SideloadingManager.m10140a(this.f10042b, this.f10041a);
        }
    }

    /* compiled from: unknown itemViewType  */
    public /* synthetic */ class C14793 {
        public static final /* synthetic */ int[] f10043a = new int[ErrorCode.values().length];

        static {
            try {
                f10043a[ErrorCode.ERROR_DOWNLOAD_MANAGER_COMPLETION_EXCEPTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10043a[ErrorCode.ERROR_DOWNLOAD_MANAGER_FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: unknown itemViewType  */
    class DownloadBroadcastEventHandler extends DownloadEventSubscriber<DownloadBroadcastEvent> {
        final /* synthetic */ SideloadingManager f10044a;

        public DownloadBroadcastEventHandler(SideloadingManager sideloadingManager) {
            this.f10044a = sideloadingManager;
        }

        public final void m10130b(FbEvent fbEvent) {
            DownloadBroadcastEvent downloadBroadcastEvent = (DownloadBroadcastEvent) fbEvent;
            SideloadingManager sideloadingManager = this.f10044a;
            long j = downloadBroadcastEvent.c;
            if (sideloadingManager.f10058d.a(SideloadingPrefKeys.m10158b(sideloadingManager.f10073s), -1) == j) {
                ExecutorDetour.a(sideloadingManager.f10059e, new C14782(sideloadingManager, j), -12188835);
            }
        }

        public final Class<DownloadBroadcastEvent> m10129a() {
            return DownloadBroadcastEvent.class;
        }
    }

    /* compiled from: unknown itemViewType  */
    class DownloadCleanupEventHandler extends DownloadEventSubscriber<DownloadCleanupEvent> {
        final /* synthetic */ SideloadingManager f10046a;

        /* compiled from: unknown itemViewType  */
        class C14801 implements Runnable {
            final /* synthetic */ DownloadCleanupEventHandler f10045a;

            C14801(DownloadCleanupEventHandler downloadCleanupEventHandler) {
                this.f10045a = downloadCleanupEventHandler;
            }

            public void run() {
                this.f10045a.f10046a.f10065k.m10118a(this.f10045a.f10046a.f10073s);
            }
        }

        public DownloadCleanupEventHandler(SideloadingManager sideloadingManager) {
            this.f10046a = sideloadingManager;
        }

        public final void m10132b(FbEvent fbEvent) {
            if (((DownloadCleanupEvent) fbEvent).a == DownloadType.APP_UPDATE) {
                ExecutorDetour.a(this.f10046a.f10059e, new C14801(this), 56116101);
            }
        }

        public final Class<DownloadCleanupEvent> m10131a() {
            return DownloadCleanupEvent.class;
        }
    }

    /* compiled from: unknown itemViewType  */
    class DownloadErrorEventHandler extends DownloadEventSubscriber<DownloadErrorEvent> {
        final /* synthetic */ SideloadingManager f10049a;

        public DownloadErrorEventHandler(SideloadingManager sideloadingManager) {
            this.f10049a = sideloadingManager;
        }

        public final void m10134b(FbEvent fbEvent) {
            final DownloadErrorEvent downloadErrorEvent = (DownloadErrorEvent) fbEvent;
            if (downloadErrorEvent.a == DownloadType.APP_UPDATE) {
                ExecutorDetour.a(this.f10049a.f10059e, new Runnable(this) {
                    final /* synthetic */ DownloadErrorEventHandler f10048b;

                    public void run() {
                        SideloadingManager sideloadingManager = this.f10048b.f10049a;
                        switch (C14793.f10043a[downloadErrorEvent.c.ordinal()]) {
                            case 1:
                                sideloadingManager.f10065k.m10118a(sideloadingManager.f10073s);
                                return;
                            case 2:
                                sideloadingManager.f10065k.m10118a(sideloadingManager.f10073s);
                                return;
                            default:
                                return;
                        }
                    }
                }, 685041127);
            }
        }

        public final Class<DownloadErrorEvent> m10133a() {
            return DownloadErrorEvent.class;
        }
    }

    /* compiled from: unknown itemViewType  */
    class DownloadInfoEventHandler extends DownloadEventSubscriber<DownloadInfoEvent> {
        final /* synthetic */ SideloadingManager f10050a;

        public DownloadInfoEventHandler(SideloadingManager sideloadingManager) {
            this.f10050a = sideloadingManager;
        }

        public final void m10136b(FbEvent fbEvent) {
            DownloadInfoEvent downloadInfoEvent = (DownloadInfoEvent) fbEvent;
            if (downloadInfoEvent.a == DownloadType.APP_UPDATE) {
                SideloadingManager sideloadingManager = this.f10050a;
                InfoEvent infoEvent = downloadInfoEvent.c;
                infoEvent.name();
                if (infoEvent == InfoEvent.CREATED_FILE) {
                    sideloadingManager.f10058d.edit().a(SideloadingPrefKeys.m10158b(sideloadingManager.f10073s)).commit();
                }
            }
        }

        public final Class<DownloadInfoEvent> m10135a() {
            return DownloadInfoEvent.class;
        }
    }

    /* compiled from: unknown itemViewType  */
    class DownloadSuccessEventHandler extends DownloadEventSubscriber<DownloadSuccessEvent> {
        final /* synthetic */ SideloadingManager f10053a;

        public DownloadSuccessEventHandler(SideloadingManager sideloadingManager) {
            this.f10053a = sideloadingManager;
        }

        public final void m10138b(FbEvent fbEvent) {
            final DownloadSuccessEvent downloadSuccessEvent = (DownloadSuccessEvent) fbEvent;
            if (downloadSuccessEvent.a == DownloadType.APP_UPDATE) {
                ExecutorDetour.a(this.f10053a.f10059e, new Runnable(this) {
                    final /* synthetic */ DownloadSuccessEventHandler f10052b;

                    public void run() {
                        SideloadingManager.m10141a(this.f10052b.f10053a, downloadSuccessEvent.d, downloadSuccessEvent.e);
                    }
                }, 1661132999);
            }
        }

        public final Class<DownloadSuccessEvent> m10137a() {
            return DownloadSuccessEvent.class;
        }
    }

    public static com.facebook.sideloading.SideloadingManager m10139a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10055u;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sideloading.SideloadingManager.class;
        monitor-enter(r1);
        r0 = f10055u;	 Catch:{ all -> 0x003a }
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
        r0 = m10144b(r0);	 Catch:{ all -> 0x0035 }
        f10055u = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10055u;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sideloading.SideloadingManager.a(com.facebook.inject.InjectorLike):com.facebook.sideloading.SideloadingManager");
    }

    private static SideloadingManager m10144b(InjectorLike injectorLike) {
        return new SideloadingManager(FbDownloadManager.a(injectorLike), DownloadEventBus.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), StatFsHelperMethodAutoProvider.a(injectorLike), MoreFileUtils.a(injectorLike), PackageValidator.m10074b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), SideloadingNotifier.m10150a(injectorLike), SideloadingFileUtils.m10115b(injectorLike), SideloadingChecker.m10113b(injectorLike), SideloadingLogger.m10126b(injectorLike));
    }

    @Inject
    public SideloadingManager(FbDownloadManager fbDownloadManager, DownloadEventBus downloadEventBus, FbSharedPreferences fbSharedPreferences, ExecutorService executorService, StatFsHelper statFsHelper, MoreFileUtils moreFileUtils, PackageValidator packageValidator, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, SideloadingNotifier sideloadingNotifier, SideloadingFileUtils sideloadingFileUtils, SideloadingChecker sideloadingChecker, SideloadingLogger sideloadingLogger) {
        this.f10057c = downloadEventBus;
        this.f10056b = fbDownloadManager;
        this.f10058d = fbSharedPreferences;
        this.f10059e = executorService;
        this.f10060f = statFsHelper;
        this.f10061g = moreFileUtils;
        this.f10062h = packageValidator;
        this.f10063i = defaultBlueServiceOperationFactory;
        this.f10064j = sideloadingNotifier;
        this.f10065k = sideloadingFileUtils;
        this.f10066l = sideloadingChecker;
        this.f10067m = sideloadingLogger;
        this.f10057c.a(this.f10068n);
        this.f10057c.a(this.f10069o);
        this.f10057c.a(this.f10070p);
        this.f10057c.a(this.f10071q);
        this.f10057c.a(this.f10072r);
    }

    public final void m10148a() {
        this.f10074t = null;
    }

    public final void m10149a(String str) {
        m10143a(true, str);
    }

    private void m10143a(boolean z, String str) {
        if (this.f10066l.m10114a()) {
            this.f10073s = str;
            this.f10056b.a();
            switch (this.f10058d.a(SideloadingPrefKeys.m10162g(str), 0)) {
                case 0:
                    m10146c();
                    return;
                case 1:
                    m10145b();
                    return;
                case 2:
                    m10142a(z);
                    return;
                default:
                    return;
            }
        }
    }

    private void m10142a(boolean z) {
        if (!this.f10065k.m10119b(this.f10073s)) {
            m10147d();
        } else if (z) {
            this.f10064j.m10156a(this.f10058d.a(SideloadingPrefKeys.m10159d(this.f10073s), null), this.f10073s, "diode_screen");
        } else {
            this.f10065k.m10118a(this.f10073s);
        }
    }

    private void m10145b() {
        final long a = this.f10058d.a(SideloadingPrefKeys.m10158b(this.f10073s), -1);
        if (a != -1) {
            ExecutorDetour.a(this.f10059e, new Runnable(this) {
                final /* synthetic */ SideloadingManager f10040b;

                public void run() {
                    SideloadingManager.m10140a(this.f10040b, a);
                }
            }, 1898240937);
        } else {
            m10147d();
        }
    }

    private void m10146c() {
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.f10073s);
        bundle.putBoolean("force_download", true);
        BlueServiceOperationFactoryDetour.a(this.f10063i, "sideload_app", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), -197811637).a();
    }

    private void m10147d() {
        this.f10058d.edit().a(SideloadingPrefKeys.m10158b(this.f10073s), 0).commit();
        m10146c();
    }

    public static synchronized void m10140a(SideloadingManager sideloadingManager, long j) {
        synchronized (sideloadingManager) {
            sideloadingManager.f10056b.a(j, DownloadType.APP_UPDATE, null);
        }
    }

    public static void m10141a(SideloadingManager sideloadingManager, String str, long j) {
        Throwable th;
        sideloadingManager.f10067m.m10127a("sideloading_on_download_success");
        Object obj;
        try {
            File a = sideloadingManager.f10056b.a(str, j, DownloadType.APP_UPDATE, null);
            int i;
            if (a != null) {
                String path = a.getPath();
                sideloadingManager.f10058d.edit().a(SideloadingPrefKeys.m10159d(sideloadingManager.f10073s), path).a(SideloadingPrefKeys.m10162g(sideloadingManager.f10073s), 2).commit();
                try {
                    JarFile b = MoreFileUtils.b(a);
                    String a2 = sideloadingManager.f10058d.a(SideloadingPrefKeys.m10161f(sideloadingManager.f10073s), "application/vnd.android.package-archive");
                    long a3 = sideloadingManager.f10058d.a(SideloadingPrefKeys.m10160e(sideloadingManager.f10073s), 31457280);
                    long a4 = sideloadingManager.f10060f.a(StorageType.INTERNAL);
                    if (!sideloadingManager.f10062h.m10075a(b, a2) || a4 < a3) {
                        i = 1;
                    } else {
                        if (!a2.equals("application/java-archive")) {
                            if (sideloadingManager.f10074t != null) {
                                sideloadingManager.f10074t.mo38a();
                            }
                            sideloadingManager.f10064j.m10155a(path, sideloadingManager.f10073s);
                        }
                        obj = null;
                    }
                    if (b != null) {
                        try {
                            b.close();
                        } catch (IOException e) {
                        } catch (Throwable th2) {
                            th = th2;
                            if (obj != null) {
                                sideloadingManager.f10065k.m10118a(sideloadingManager.f10073s);
                            }
                            throw th;
                        }
                    }
                } catch (IOException e2) {
                    sideloadingManager.f10065k.m10118a(sideloadingManager.f10073s);
                    return;
                } catch (OutOfMemoryError e3) {
                    sideloadingManager.f10065k.m10118a(sideloadingManager.f10073s);
                    return;
                }
            }
            Long.valueOf(j);
            i = 1;
            if (obj != null) {
                sideloadingManager.f10065k.m10118a(sideloadingManager.f10073s);
            }
        } catch (Throwable th3) {
            th = th3;
            obj = 1;
            if (obj != null) {
                sideloadingManager.f10065k.m10118a(sideloadingManager.f10073s);
            }
            throw th;
        }
    }
}
