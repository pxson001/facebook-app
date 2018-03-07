package com.facebook.selfupdate;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.appupdate.SelfUpdateLauncher;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.manifest.ManifestReader;
import com.facebook.common.manifest.ManifestReaderMethodAutoProvider;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.downloader.DownloadRequest.DownloadType;
import com.facebook.downloader.FbDownloadManager;
import com.facebook.downloader.event.DownloadBroadcastEvent;
import com.facebook.downloader.event.DownloadCleanupEvent;
import com.facebook.downloader.event.DownloadErrorEvent;
import com.facebook.downloader.event.DownloadEventBus;
import com.facebook.downloader.event.DownloadEventSubscriber;
import com.facebook.downloader.event.DownloadInfoEvent;
import com.facebook.downloader.event.DownloadInfoEvent.InfoEvent;
import com.facebook.downloader.event.DownloadSuccessEvent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.jar.JarFile;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@TargetApi(9)
/* compiled from: reaction_android_composer */
public class SelfUpdateManager {
    private static final Class<?> f8192a = SelfUpdateManager.class;
    private static volatile SelfUpdateManager f8193y;
    private final Context f8194b;
    private final AppInitLock f8195c;
    private final Clock f8196d;
    public final FbSharedPreferences f8197e;
    private final AppVersionInfo f8198f;
    public final Lazy<SelfUpdateLogger> f8199g;
    private final FbDownloadManager f8200h;
    public final Provider<SelfUpdateNotifier> f8201i;
    private final Lazy<PackageValidator> f8202j;
    public final ExecutorService f8203k;
    private final MoreFileUtils f8204l;
    private final StatFsHelper f8205m;
    private final DownloadEventBus f8206n;
    private final SecureContextHelper f8207o;
    private final boolean f8208p;
    public final ObjectMapper f8209q;
    private final SelfUpdateLauncher f8210r;
    private final GatekeeperStoreImpl f8211s;
    private final DownloadBroadcastEventHandler f8212t = new DownloadBroadcastEventHandler(this);
    private final DownloadCleanupEventHandler f8213u = new DownloadCleanupEventHandler(this);
    private final DownloadErrorEventHandler f8214v = new DownloadErrorEventHandler(this);
    private final DownloadInfoEventHandler f8215w = new DownloadInfoEventHandler(this);
    private final DownloadSuccessEventHandler f8216x = new DownloadSuccessEventHandler(this);

    /* compiled from: reaction_android_composer */
    public class DownloadBroadcastEventHandler extends DownloadEventSubscriber<DownloadBroadcastEvent> {
        final /* synthetic */ SelfUpdateManager f8294a;

        protected DownloadBroadcastEventHandler(SelfUpdateManager selfUpdateManager) {
            this.f8294a = selfUpdateManager;
        }

        public final void mo650b(FbEvent fbEvent) {
            DownloadBroadcastEvent downloadBroadcastEvent = (DownloadBroadcastEvent) fbEvent;
            SelfUpdateManager selfUpdateManager = this.f8294a;
            long j = downloadBroadcastEvent.f8299c;
            if (selfUpdateManager.f8197e.mo277a(SelfUpdateConstants.f8172g, -1) == j) {
                ExecutorDetour.a(selfUpdateManager.f8203k, new 2(selfUpdateManager, j), -1878533625);
            }
        }

        public final Class<DownloadBroadcastEvent> mo648a() {
            return DownloadBroadcastEvent.class;
        }
    }

    /* compiled from: reaction_android_composer */
    public class DownloadCleanupEventHandler extends DownloadEventSubscriber<DownloadCleanupEvent> {
        final /* synthetic */ SelfUpdateManager f8295a;

        protected DownloadCleanupEventHandler(SelfUpdateManager selfUpdateManager) {
            this.f8295a = selfUpdateManager;
        }

        public final void mo650b(FbEvent fbEvent) {
            if (((DownloadCleanupEvent) fbEvent).f8300a == DownloadType.APP_UPDATE) {
                ExecutorDetour.a(this.f8295a.f8203k, new 1(this), 1129088693);
            }
        }

        public final Class<DownloadCleanupEvent> mo648a() {
            return DownloadCleanupEvent.class;
        }
    }

    /* compiled from: reaction_android_composer */
    public class DownloadErrorEventHandler extends DownloadEventSubscriber<DownloadErrorEvent> {
        final /* synthetic */ SelfUpdateManager f8296a;

        protected DownloadErrorEventHandler(SelfUpdateManager selfUpdateManager) {
            this.f8296a = selfUpdateManager;
        }

        public final void mo650b(FbEvent fbEvent) {
            DownloadErrorEvent downloadErrorEvent = (DownloadErrorEvent) fbEvent;
            if (downloadErrorEvent.f8300a == DownloadType.APP_UPDATE) {
                ExecutorDetour.a(this.f8296a.f8203k, new 1(this, downloadErrorEvent), 1281382887);
            }
        }

        public final Class<DownloadErrorEvent> mo648a() {
            return DownloadErrorEvent.class;
        }
    }

    /* compiled from: reaction_android_composer */
    public class DownloadInfoEventHandler extends DownloadEventSubscriber<DownloadInfoEvent> {
        final /* synthetic */ SelfUpdateManager f8297a;

        protected DownloadInfoEventHandler(SelfUpdateManager selfUpdateManager) {
            this.f8297a = selfUpdateManager;
        }

        public final void mo650b(FbEvent fbEvent) {
            DownloadInfoEvent downloadInfoEvent = (DownloadInfoEvent) fbEvent;
            if (downloadInfoEvent.f8300a == DownloadType.APP_UPDATE) {
                SelfUpdateManager selfUpdateManager = this.f8297a;
                InfoEvent infoEvent = downloadInfoEvent.f8305c;
                if (infoEvent == InfoEvent.QUEUE_DOWNLOAD) {
                    ((SelfUpdateLogger) selfUpdateManager.f8199g.get()).m12757a("selfupdate_queue_download", ImmutableBiMap.m978b("extra_args", downloadInfoEvent.f8306d));
                } else if (infoEvent == InfoEvent.CREATED_FILE) {
                    selfUpdateManager.f8197e.edit().mo1271a(SelfUpdateConstants.f8172g).commit();
                }
            }
        }

        public final Class<DownloadInfoEvent> mo648a() {
            return DownloadInfoEvent.class;
        }
    }

    /* compiled from: reaction_android_composer */
    public class DownloadSuccessEventHandler extends DownloadEventSubscriber<DownloadSuccessEvent> {
        final /* synthetic */ SelfUpdateManager f8298a;

        protected DownloadSuccessEventHandler(SelfUpdateManager selfUpdateManager) {
            this.f8298a = selfUpdateManager;
        }

        public final void mo650b(FbEvent fbEvent) {
            DownloadSuccessEvent downloadSuccessEvent = (DownloadSuccessEvent) fbEvent;
            if (downloadSuccessEvent.f8300a == DownloadType.APP_UPDATE) {
                ExecutorDetour.a(this.f8298a.f8203k, new 1(this, downloadSuccessEvent), -59907294);
            }
        }

        public final Class<DownloadSuccessEvent> mo648a() {
            return DownloadSuccessEvent.class;
        }
    }

    public static com.facebook.selfupdate.SelfUpdateManager m12703a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8193y;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.selfupdate.SelfUpdateManager.class;
        monitor-enter(r1);
        r0 = f8193y;	 Catch:{ all -> 0x003a }
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
        r0 = m12705b(r0);	 Catch:{ all -> 0x0035 }
        f8193y = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8193y;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.selfupdate.SelfUpdateManager.a(com.facebook.inject.InjectorLike):com.facebook.selfupdate.SelfUpdateManager");
    }

    private static SelfUpdateManager m12705b(InjectorLike injectorLike) {
        return new SelfUpdateManager(AppInitLock.m2271a(injectorLike), AppVersionInfoMethodAutoProvider.m2629a(injectorLike), (Context) injectorLike.getInstance(Context.class), SystemClockMethodAutoProvider.m1498a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3413), FbDownloadManager.m12711a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 10960), IdBasedLazy.m1808a(injectorLike, 10957), C0055x2995691a.m1881a(injectorLike), MoreFileUtils.m5023a(injectorLike), StatFsHelperMethodAutoProvider.m2307a(injectorLike), DownloadEventBus.m12730a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), ManifestReaderMethodAutoProvider.m12733a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), SelfUpdateLauncherMethodAutoProvider.m12738a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public SelfUpdateManager(AppInitLock appInitLock, AppVersionInfo appVersionInfo, Context context, Clock clock, FbSharedPreferences fbSharedPreferences, Lazy<SelfUpdateLogger> lazy, FbDownloadManager fbDownloadManager, Provider<SelfUpdateNotifier> provider, Lazy<PackageValidator> lazy2, ExecutorService executorService, MoreFileUtils moreFileUtils, StatFsHelper statFsHelper, DownloadEventBus downloadEventBus, SecureContextHelper secureContextHelper, ManifestReader manifestReader, ObjectMapper objectMapper, SelfUpdateLauncher selfUpdateLauncher, GatekeeperStore gatekeeperStore) {
        this.f8195c = appInitLock;
        this.f8198f = appVersionInfo;
        this.f8194b = context;
        this.f8196d = clock;
        this.f8197e = fbSharedPreferences;
        this.f8199g = lazy;
        this.f8200h = fbDownloadManager;
        this.f8201i = provider;
        this.f8202j = lazy2;
        this.f8203k = executorService;
        this.f8204l = moreFileUtils;
        this.f8205m = statFsHelper;
        this.f8206n = downloadEventBus;
        this.f8207o = secureContextHelper;
        this.f8209q = objectMapper;
        this.f8210r = selfUpdateLauncher;
        this.f8211s = gatekeeperStore;
        this.f8206n.m4568a(this.f8212t);
        this.f8206n.m4568a(this.f8213u);
        this.f8206n.m4568a(this.f8214v);
        this.f8206n.m4568a(this.f8215w);
        this.f8206n.m4568a(this.f8216x);
        String a = manifestReader.a("com.facebook.selfupdate.enabled");
        boolean z = a == null || "true".equals(a);
        this.f8208p = z;
    }

    public final void m12706a() {
        if (this.f8208p) {
            long a;
            this.f8195c.m2277b();
            int a2 = this.f8197e.mo276a(SelfUpdateConstants.f8179n, 0);
            if (a2 == 2) {
                a2 = this.f8197e.mo276a(SelfUpdateConstants.f8169d, 0);
                if (this.f8198f.mo368b() >= a2) {
                    ObjectNode e = this.f8209q.m6668e();
                    e.m5129a("current_version", this.f8198f.mo368b());
                    e.m5129a("downloaded_version", a2);
                    ((SelfUpdateNotifier) this.f8201i.get()).a("scheduleservice_newer_version_running", e);
                } else {
                    Object obj;
                    CharSequence a3 = this.f8197e.mo278a(SelfUpdateConstants.f8183r, null);
                    if (StringUtil.m3589a(a3)) {
                        obj = "emptyOrNull";
                    } else {
                        CharSequence charSequence = a3;
                    }
                    ((SelfUpdateLogger) this.f8199g.get()).m12757a("selfupdate_start_showing_activity", ImmutableBiMap.m978b("source", obj));
                    ((SelfUpdateNotifier) this.f8201i.get()).a();
                }
            } else if (a2 == 1) {
                a = this.f8197e.mo277a(SelfUpdateConstants.f8172g, -1);
                if (a != -1) {
                    ExecutorDetour.a(this.f8203k, new 1(this, a), 1326754127);
                }
            }
            this.f8200h.m12721a();
            a = this.f8197e.mo277a(SelfUpdateConstants.f8167b, 0);
            long a4 = this.f8197e.mo277a(SelfUpdateConstants.f8168c, 43200000);
            long a5 = this.f8196d.mo211a();
            if (Math.abs(a5 - a) > a4) {
                this.f8197e.edit().mo1275a(SelfUpdateConstants.f8167b, a5).commit();
                m12709a(false);
            }
        }
    }

    public final void m12709a(boolean z) {
        this.f8200h.m12721a();
        Intent intent = new Intent(this.f8194b, SelfUpdateFetchService.class);
        intent.putExtra("force_update", z);
        this.f8194b.startService(intent);
    }

    public final void m12707a(Activity activity) {
        if (this.f8211s.m2189a(805, false)) {
            this.f8210r.m12792a(activity);
        }
    }

    public static synchronized void m12704a(SelfUpdateManager selfUpdateManager, long j) {
        synchronized (selfUpdateManager) {
            selfUpdateManager.f8200h.m12722a(j, DownloadType.APP_UPDATE, null);
        }
    }

    protected final void m12708a(String str, long j) {
        Throwable e;
        Object obj;
        ObjectNode e2 = this.f8209q.m6668e();
        try {
            Object obj2;
            File a = this.f8200h.m12720a(str, j, DownloadType.APP_UPDATE, null);
            e2.m5138a("file_null", a == null);
            int i;
            if (a != null) {
                JarFile b;
                String path = a.getPath();
                this.f8197e.edit().mo1276a(SelfUpdateConstants.f8173h, path).mo1274a(SelfUpdateConstants.f8179n, 2).commit();
                try {
                    b = MoreFileUtils.m5033b(a);
                } catch (Throwable e3) {
                    ((SelfUpdateLogger) this.f8199g.get()).m12756a("Failed to open JarFile: " + path, e3);
                    b = null;
                } catch (OutOfMemoryError e4) {
                    ((SelfUpdateLogger) this.f8199g.get()).m12755a("Failed to open JarFile by OOM: " + path);
                    b = null;
                }
                String a2 = this.f8197e.mo278a(SelfUpdateConstants.f8183r, "");
                e2.m5137a("source", a2);
                ((SelfUpdateLogger) this.f8199g.get()).m12757a("selfupdate_download_success_file_uri", ImmutableMap.of("local_file_uri", path, "source", a2));
                String a3 = this.f8197e.mo278a(SelfUpdateConstants.f8181p, "application/vnd.android.package-archive");
                e2.m5137a("mime_type", a3);
                boolean a4 = ((PackageValidator) this.f8202j.get()).a(b, a3);
                long a5 = this.f8205m.m2314a(StorageType.INTERNAL);
                long a6 = this.f8197e.mo277a(SelfUpdateConstants.f8182q, 31457280);
                boolean z = a5 >= a6;
                e2.m5138a("valid_file", a4);
                e2.m5130a("free_space", a5);
                e2.m5130a("file_size", a6);
                e2.m5138a("has_required_space", z);
                if (a4 && z) {
                    if (!a3.equals("application/java-archive")) {
                        ((SelfUpdateNotifier) this.f8201i.get()).b();
                    }
                    obj2 = null;
                    try {
                        ((SelfUpdateLogger) this.f8199g.get()).m12757a("selfupdate_download_success", ImmutableBiMap.m978b("source", a2));
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        obj = null;
                        e3 = th2;
                        if (obj != null) {
                            ((SelfUpdateNotifier) this.f8201i.get()).a("selfupdate_download_validation_failure", e2);
                        }
                        throw e3;
                    }
                }
                ((SelfUpdateLogger) this.f8199g.get()).m12755a("Downloaded package is invalid or corrupt");
                i = 1;
                if (b != null) {
                    try {
                        b.close();
                    } catch (IOException e5) {
                        ((SelfUpdateLogger) this.f8199g.get()).m12755a("Failed to close JarFile: " + path);
                    }
                }
            } else {
                ((SelfUpdateLogger) this.f8199g.get()).m12755a("Download succeeded, but file the is missing: id= " + j);
                i = 1;
            }
            if (obj2 != null) {
                ((SelfUpdateNotifier) this.f8201i.get()).a("selfupdate_download_validation_failure", e2);
            }
        } catch (Throwable th3) {
            e3 = th3;
            int i2 = 1;
            if (obj != null) {
                ((SelfUpdateNotifier) this.f8201i.get()).a("selfupdate_download_validation_failure", e2);
            }
            throw e3;
        }
    }
}
