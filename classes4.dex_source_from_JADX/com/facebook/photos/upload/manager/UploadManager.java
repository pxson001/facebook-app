package com.facebook.photos.upload.manager;

import android.os.Bundle;
import android.util.Log;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.process.ProcessName;
import com.facebook.common.process.ProcessUtil;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.data.MediaData;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.LoggingTypes.UploadMethodType;
import com.facebook.photos.base.analytics.LoggingTypes.UploadType;
import com.facebook.photos.base.analytics.LoggingTypes.VideoProductType;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.upload.abtest.GCMBasedNetworkRetryQuickExperiment;
import com.facebook.photos.upload.abtest.ImmediateRetryTimingQEConfig;
import com.facebook.photos.upload.abtest.OptimisticVideoUploadQuickExperiment;
import com.facebook.photos.upload.compost.CompostPendingPostStore;
import com.facebook.photos.upload.disk.UploadTempFileManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.photos.upload.operation.UploadOperationCounters;
import com.facebook.photos.upload.operation.UploadOperationHelper;
import com.facebook.photos.upload.operation.UploadRecords;
import com.facebook.photos.upload.receiver.ConnectivityChangeHelper;
import com.facebook.photos.upload.retry.FailedUploadRetryPolicy;
import com.facebook.photos.upload.retry.FailedUploadRetryTask;
import com.facebook.photos.upload.serverprocessing.FeedVideoStatusChecker;
import com.facebook.photos.upload.serverprocessing.FeedVideoStatusChecker.1;
import com.facebook.photos.upload.serverprocessing.FeedVideoStatusCheckerProvider;
import com.facebook.photos.upload.uploaders.PhotoPreprocessor;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: non-null */
public class UploadManager extends AbstractAuthComponent {
    private static volatile UploadManager f7026C;
    public static final boolean f7027a = Log.isLoggable("MediaUpload", 3);
    public final Lazy<CompostPendingPostStore> f7028A;
    public final QeAccessor f7029B;
    private final Lazy<BlueServiceOperationFactory> f7030b;
    public final Lazy<UploadNotificationManager> f7031c;
    private final Lazy<UploadCrashMonitor> f7032d;
    public final Lazy<UploadOperationHelper> f7033e;
    private final Lazy<Executor> f7034f;
    private final Lazy<FailedUploadRetryTask> f7035g;
    public final FailedUploadRetryPolicy f7036h;
    private final Lazy<ImmediateRetryTimingQEConfig> f7037i;
    public final Lazy<UploadTempFileManager> f7038j;
    private final NetworkMonitor f7039k;
    public final SystemClock f7040l;
    public final Lazy<FbErrorReporter> f7041m;
    private final Lazy<AndroidThreadUtil> f7042n;
    private final Lazy<ProcessUtil> f7043o;
    private final Lazy<ConnectivityChangeHelper> f7044p;
    private final Lazy<PhotoPreprocessor> f7045q;
    private final boolean f7046r;
    private final ExecutorService f7047s;
    public final Lazy<OptimisticVideoUploadHelper> f7048t;
    private final FeedVideoStatusCheckerProvider f7049u;
    public boolean f7050v;
    @GuardedBy("ui-thread")
    public final Map<String, QueuedOperation> f7051w = Maps.c();
    @GuardedBy("ui-thread")
    public final Map<String, UploadOperation> f7052x = new HashMap();
    @GuardedBy("ui-thread")
    public final LinkedList<UploadOperation> f7053y = Lists.b();
    @GuardedBy("this")
    public final Set<String> f7054z = Sets.a();

    /* compiled from: non-null */
    class C03341 implements Runnable {
        final /* synthetic */ UploadManager f7067a;

        C03341(UploadManager uploadManager) {
            this.f7067a = uploadManager;
        }

        public void run() {
            if (!this.f7067a.f7050v) {
                UploadManager.m7307g(this.f7067a, "Network connected retry");
            }
        }
    }

    public static com.facebook.photos.upload.manager.UploadManager m7304a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7026C;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.manager.UploadManager.class;
        monitor-enter(r1);
        r0 = f7026C;	 Catch:{ all -> 0x003a }
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
        r0 = m7306b(r0);	 Catch:{ all -> 0x0035 }
        f7026C = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7026C;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.manager.UploadManager.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.manager.UploadManager");
    }

    private static UploadManager m7306b(InjectorLike injectorLike) {
        return new UploadManager(IdBasedLazy.a(injectorLike, 1144), IdBasedSingletonScopeProvider.b(injectorLike, 9465), IdBasedSingletonScopeProvider.b(injectorLike, 2983), IdBasedLazy.a(injectorLike, 9468), IdBasedSingletonScopeProvider.b(injectorLike, 3863), IdBasedSingletonScopeProvider.b(injectorLike, 2994), FailedUploadRetryPolicy.m7343a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9449), IdBasedSingletonScopeProvider.b(injectorLike, 9458), NetworkMonitor.a(injectorLike), SystemClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 517), IdBasedSingletonScopeProvider.b(injectorLike, 594), IdBasedSingletonScopeProvider.b(injectorLike, 2991), IdBasedSingletonScopeProvider.b(injectorLike, 9499), IdBasedProvider.a(injectorLike, 733), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9462), (FeedVideoStatusCheckerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoStatusCheckerProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 9452), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public UploadManager(Lazy<BlueServiceOperationFactory> lazy, Lazy<UploadNotificationManager> lazy2, Lazy<UploadCrashMonitor> lazy3, Lazy<UploadOperationHelper> lazy4, Lazy<Executor> lazy5, Lazy<FailedUploadRetryTask> lazy6, FailedUploadRetryPolicy failedUploadRetryPolicy, Lazy<ImmediateRetryTimingQEConfig> lazy7, Lazy<UploadTempFileManager> lazy8, NetworkMonitor networkMonitor, SystemClock systemClock, Lazy<FbErrorReporter> lazy9, Lazy<AndroidThreadUtil> lazy10, Lazy<ProcessUtil> lazy11, Lazy<ConnectivityChangeHelper> lazy12, Lazy<PhotoPreprocessor> lazy13, Provider<TriState> provider, ExecutorService executorService, Lazy<OptimisticVideoUploadHelper> lazy14, FeedVideoStatusCheckerProvider feedVideoStatusCheckerProvider, Lazy<CompostPendingPostStore> lazy15, QeAccessor qeAccessor) {
        this.f7030b = lazy;
        this.f7031c = lazy2;
        this.f7032d = lazy3;
        this.f7033e = lazy4;
        this.f7034f = lazy5;
        this.f7035g = lazy6;
        this.f7036h = failedUploadRetryPolicy;
        this.f7037i = lazy7;
        this.f7038j = lazy8;
        this.f7039k = networkMonitor;
        this.f7040l = systemClock;
        this.f7041m = lazy9;
        this.f7042n = lazy10;
        this.f7043o = lazy11;
        this.f7029B = qeAccessor;
        this.f7044p = lazy12;
        this.f7039k.a(State.CONNECTED, new C03341(this));
        if (this.f7029B.a((short) -31272, GCMBasedNetworkRetryQuickExperiment.f7068a.booleanValue())) {
            this.f7039k.a(State.CONNECTED, new 2(this));
        }
        ((FailedUploadRetryTask) this.f7035g.get()).m7375a(this);
        this.f7045q = lazy13;
        this.f7046r = ((TriState) provider.get()).asBoolean(false);
        this.f7047s = executorService;
        this.f7048t = lazy14;
        this.f7049u = feedVideoStatusCheckerProvider;
        this.f7050v = false;
        this.f7028A = lazy15;
    }

    public static void m7307g(UploadManager uploadManager, String str) {
        if (!uploadManager.f7053y.isEmpty()) {
            uploadManager.m7327b(str);
        }
    }

    public final void m7322a(UploadOperation uploadOperation) {
        ((ImmediateRetryTimingQEConfig) this.f7037i.get()).a();
        if (!this.f7046r || uploadOperation.Y()) {
            m7323a(uploadOperation, RequestType.InitialPost, null);
        } else {
            ((PhotoPreprocessor) this.f7045q.get()).a(uploadOperation);
        }
    }

    public final void m7324a(ImmutableList<MediaItem> immutableList, String str, ViewerContext viewerContext, long j) {
        if (this.f7046r) {
            ((PhotoPreprocessor) this.f7045q.get()).a(immutableList, str, viewerContext);
        }
        if (m7320p(this)) {
            ((OptimisticVideoUploadHelper) this.f7048t.get()).a(immutableList, str, viewerContext, j);
        }
    }

    public final void m7325a(String str) {
        if (this.f7046r) {
            ((PhotoPreprocessor) this.f7045q.get()).a();
        }
        if (m7320p(this)) {
            ((OptimisticVideoUploadHelper) this.f7048t.get()).a(str);
        }
    }

    public final void m7323a(UploadOperation uploadOperation, RequestType requestType, String str) {
        ((DefaultAndroidThreadUtil) this.f7042n.get()).a();
        ProcessName a = ((DefaultProcessUtil) this.f7043o.get()).a();
        if (a.e()) {
            boolean z;
            if (m7320p(this) && uploadOperation.Y()) {
                ((OptimisticVideoUploadHelper) this.f7048t.get()).d(uploadOperation);
            } else if (this.f7051w.containsKey(uploadOperation.N())) {
                ((AbstractFbErrorReporter) this.f7041m.get()).b("MediaUpload", "double-enqueue");
            }
            UploadOperation i = m7310i(uploadOperation);
            switch (8.a[requestType.ordinal()]) {
                case 1:
                    i.a(this.f7040l.a());
                    z = false;
                    break;
                case 2:
                    i.b(this.f7040l.a());
                    z = true;
                    break;
                case 3:
                case 4:
                    z = true;
                    break;
                case 5:
                case 6:
                    i.d(this.f7040l.a());
                    break;
            }
            z = false;
            DefaultPhotoFlowLogger d = ((UploadOperationHelper) this.f7033e.get()).d(i);
            if (!uploadOperation.ar()) {
                if (requestType == RequestType.InitialPost) {
                    d.a("2.0", i.a(), m7340g(i), m7319o(i), i.b(), i.c(), i.M().size(), i.C().e, Long.toString(i.B()), m7314l());
                } else {
                    d.a("2.0", i.a(), m7340g(i), i, z, this.f7040l.a() - i.ae(), str, this.f7050v);
                }
            }
            ((UploadNotificationManager) this.f7031c.get()).b(i);
            if (m7320p(this) && uploadOperation.Y() && this.f7051w.containsKey(uploadOperation.N())) {
                uploadOperation.N();
                return;
            }
            String str2;
            if (i.Z() || m7309h(i)) {
                str2 = "multimedia_upload_op";
            } else if (i.Y()) {
                str2 = "video_upload_op";
            } else {
                str2 = "photo_upload_op";
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("uploadOp", i);
            if (i.T() != null) {
                bundle.putParcelable("overridden_viewer_context", i.T());
            }
            OperationFuture a2 = BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f7030b.get(), str2, bundle, ErrorPropagation.BY_EXCEPTION, 1495267259).a();
            if (m7320p(this) && i.Y()) {
                ((OptimisticVideoUploadHelper) this.f7048t.get()).c(i);
            }
            this.f7051w.put(i.N(), new QueuedOperation(a2, i));
            ((UploadCrashMonitor) this.f7032d.get()).f(i);
            m7318n(i);
            Futures.a(a2, new 3(this, i, uploadOperation, z), (Executor) this.f7034f.get());
            return;
        }
        ((AbstractFbErrorReporter) this.f7041m.get()).b("MediaUpload", "Uploads not supported from process " + a.b());
    }

    private static VideoProductType m7319o(UploadOperation uploadOperation) {
        if (uploadOperation.r == Type.PROFILE_VIDEO) {
            return VideoProductType.PROFILE_VIDEO;
        }
        if (uploadOperation.r == Type.LIVE_VIDEO) {
            return VideoProductType.FACECAST_LIVE_VIDEO;
        }
        String P = uploadOperation.P();
        if ("ANIMATED_GIFS".equals(P)) {
            return VideoProductType.GIF;
        }
        if ("CORE_VIDEOS".equals(P)) {
            return VideoProductType.COMPOSER;
        }
        return VideoProductType.NOT_RELEVANT;
    }

    public final UploadMethodType m7340g(UploadOperation uploadOperation) {
        return m7303a(uploadOperation.r);
    }

    public static boolean m7313k(UploadManager uploadManager) {
        return uploadManager.f7029B.a(ExperimentsForCompostAbTestModule.z, false);
    }

    private static boolean m7309h(UploadOperation uploadOperation) {
        if (uploadOperation.a.size() == 1) {
            MediaItem mediaItem = (MediaItem) uploadOperation.a.get(0);
            if (mediaItem.b().mType == MediaData.Type.Video && !Strings.isNullOrEmpty(mediaItem.f)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.photos.upload.operation.UploadOperation m7310i(com.facebook.photos.upload.operation.UploadOperation r6) {
        /*
        r5 = this;
        r0 = m7320p(r5);
        if (r0 == 0) goto L_0x004e;
    L_0x0006:
        r0 = r6.Y();
        if (r0 == 0) goto L_0x004e;
    L_0x000c:
        r0 = r5.f7048t;
        r0 = r0.get();
        r0 = (com.facebook.photos.upload.manager.OptimisticVideoUploadHelper) r0;
        r1 = r0.f;
        r1 = r1.get(r6);
        r1 = (com.facebook.photos.upload.operation.UploadOperation) r1;
        if (r1 == 0) goto L_0x0051;
    L_0x001e:
        r2 = r1.Z;
        r1 = r2;
        if (r1 != 0) goto L_0x0051;
    L_0x0023:
        r1 = 1;
    L_0x0024:
        r0 = r1;
        if (r0 == 0) goto L_0x004e;
    L_0x0027:
        r2 = 0;
        r1 = m7320p(r5);
        if (r1 == 0) goto L_0x0053;
    L_0x002e:
        r4 = r6.Z;
        r1 = r4;
        if (r1 == 0) goto L_0x0053;
    L_0x0033:
        r1 = r5.f7048t;
        r1 = r1.get();
        r1 = (com.facebook.photos.upload.manager.OptimisticVideoUploadHelper) r1;
        r4 = r6.p;
        r3 = r4;
        r1 = r1.b(r3);
        r4 = r1.Z;
        r3 = r4;
        if (r3 != 0) goto L_0x0053;
    L_0x0047:
        r0 = r1;
        if (r0 == 0) goto L_0x004f;
    L_0x004a:
        r0 = 1;
    L_0x004b:
        com.google.common.base.Preconditions.checkState(r0);
    L_0x004e:
        return r6;
    L_0x004f:
        r0 = 0;
        goto L_0x004b;
    L_0x0051:
        r1 = 0;
        goto L_0x0024;
    L_0x0053:
        r1 = r2;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.manager.UploadManager.i(com.facebook.photos.upload.operation.UploadOperation):com.facebook.photos.upload.operation.UploadOperation");
    }

    public static void m7312k(UploadManager uploadManager, UploadOperation uploadOperation) {
        if (uploadManager.f7051w.isEmpty() && uploadManager.f7053y.isEmpty()) {
            ExecutorDetour.a(uploadManager.f7047s, new 4(uploadManager, "UploadManager", "CleanupAllPersistedFiles"), -597927875);
            return;
        }
        UploadManager uploadManager2 = uploadManager;
        ExecutorDetour.a(uploadManager.f7047s, new 5(uploadManager2, "UploadManager", "CleanupPersistedFiles", uploadOperation.p, uploadOperation), -885872856);
    }

    public static void m7315l(UploadManager uploadManager, UploadOperation uploadOperation) {
        ((DefaultAndroidThreadUtil) uploadManager.f7042n.get()).a();
        String N = uploadOperation.N();
        uploadManager.f7051w.remove(N);
        uploadManager.f7052x.remove(N);
        ((UploadCrashMonitor) uploadManager.f7032d.get()).a(uploadOperation, uploadManager.f7051w.size());
        synchronized (uploadManager) {
            uploadManager.f7054z.remove(N);
        }
    }

    public static void m7316m(UploadManager uploadManager, UploadOperation uploadOperation) {
        if (uploadOperation.h()) {
            uploadManager.f7053y.addLast(uploadOperation);
            UploadCrashMonitor uploadCrashMonitor = (UploadCrashMonitor) uploadManager.f7032d.get();
            if (uploadCrashMonitor.t) {
                uploadCrashMonitor.o.a(uploadOperation);
            }
            ((ConnectivityChangeHelper) uploadManager.f7044p.get()).a();
        } else {
            ((UploadOperationHelper) uploadManager.f7033e.get()).d(uploadOperation).a("2.0", uploadOperation.a(), uploadManager.m7340g(uploadOperation), uploadOperation);
        }
        ((UploadNotificationManager) uploadManager.f7031c.get()).a(uploadOperation);
    }

    private void m7318n(UploadOperation uploadOperation) {
        ListIterator listIterator = this.f7053y.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equal(((UploadOperation) listIterator.next()).p, uploadOperation.p)) {
                listIterator.remove();
                UploadCrashMonitor uploadCrashMonitor = (UploadCrashMonitor) this.f7032d.get();
                int size = this.f7053y.size();
                if (uploadCrashMonitor.t) {
                    if (size == 0) {
                        uploadCrashMonitor.o.a();
                    } else {
                        uploadCrashMonitor.o.b(uploadOperation);
                    }
                }
                if (this.f7053y.isEmpty()) {
                    ((ConnectivityChangeHelper) this.f7044p.get()).b();
                    return;
                }
                return;
            }
        }
    }

    private int m7314l() {
        return this.f7051w.size();
    }

    public final void m7327b(String str) {
        ((DefaultAndroidThreadUtil) this.f7042n.get()).a();
        this.f7036h.m7346a(this, this.f7053y, str);
        m7317n();
    }

    public final synchronized boolean m7341i() {
        boolean z;
        z = this.f7051w.isEmpty() && this.f7054z.isEmpty();
        return z;
    }

    public final void m7321a(long j) {
        ((FailedUploadRetryTask) this.f7035g.get()).m7374a(j);
    }

    public final void m7333c(String str) {
        ((DefaultAndroidThreadUtil) this.f7042n.get()).a();
        String uuid = SafeUUIDGenerator.a().toString();
        Iterator it = this.f7053y.iterator();
        while (it.hasNext()) {
            UploadOperation uploadOperation = (UploadOperation) it.next();
            ((UploadOperationHelper) this.f7033e.get()).d(uploadOperation).a("2.0", uploadOperation.a(), m7340g(uploadOperation), uploadOperation, this.f7051w.size(), uuid);
        }
        this.f7036h.m7348b(this, this.f7053y, str);
        m7317n();
    }

    public final boolean m7328b(UploadOperation uploadOperation) {
        FailedUploadRetryPolicy failedUploadRetryPolicy = this.f7036h;
        long a = this.f7040l.a();
        UploadOperationCounters uploadOperationCounters = uploadOperation.D;
        boolean z = uploadOperationCounters.d < failedUploadRetryPolicy.f7059d.m7362d() && uploadOperationCounters.b + failedUploadRetryPolicy.f7059d.m7360b() > a;
        return z;
    }

    private void m7317n() {
        long a = this.f7040l.a();
        Iterator it = this.f7053y.iterator();
        while (it.hasNext()) {
            UploadOperation uploadOperation = (UploadOperation) it.next();
            if (uploadOperation.h() && uploadOperation.k() && !this.f7036h.m7349b(uploadOperation, a)) {
                uploadOperation.D.j = false;
                ((UploadNotificationManager) this.f7031c.get()).a(uploadOperation);
            }
        }
    }

    public final void m7331c(UploadOperation uploadOperation) {
        ((DefaultAndroidThreadUtil) this.f7042n.get()).a();
        m7308h(uploadOperation.p);
        ((UploadNotificationManager) this.f7031c.get()).c(uploadOperation);
        m7315l(this, uploadOperation);
        if (m7320p(this)) {
            ((OptimisticVideoUploadHelper) this.f7048t.get()).b(uploadOperation);
        }
        UploadOperation i = m7311i(uploadOperation.p);
        if (i != null) {
            m7318n(i);
            ((UploadOperationHelper) this.f7033e.get()).d(i).a("2.0", i.a(), m7340g(i), i, i.E, this.f7040l.a() - i.ae());
        }
        m7312k(this, uploadOperation);
    }

    public final void m7335d(UploadOperation uploadOperation) {
        ((DefaultAndroidThreadUtil) this.f7042n.get()).a();
        if (this.f7051w.containsKey(uploadOperation.p)) {
            this.f7052x.put(uploadOperation.p, uploadOperation);
            m7308h(uploadOperation.p);
            m7312k(this, uploadOperation);
            ((UploadNotificationManager) this.f7031c.get()).d(uploadOperation);
            return;
        }
        m7322a(uploadOperation);
    }

    public final UploadOperation m7334d(String str) {
        UploadOperation uploadOperation;
        ((DefaultAndroidThreadUtil) this.f7042n.get()).a();
        QueuedOperation queuedOperation = (QueuedOperation) this.f7051w.get(str);
        if (queuedOperation != null) {
            uploadOperation = queuedOperation.b;
        } else {
            uploadOperation = null;
        }
        if (uploadOperation == null) {
            return m7311i(str);
        }
        return uploadOperation;
    }

    private void m7308h(String str) {
        QueuedOperation queuedOperation = (QueuedOperation) this.f7051w.get(str);
        if (queuedOperation == null || queuedOperation.a == null || queuedOperation.a.isDone()) {
            BLog.a("UploadManager", "Can't cancel local upload %s", new Object[]{str});
            return;
        }
        queuedOperation.a.f();
    }

    public final void m7336e(UploadOperation uploadOperation) {
        ((DefaultAndroidThreadUtil) this.f7042n.get()).a();
        if (m7320p(this)) {
            ((OptimisticVideoUploadHelper) this.f7048t.get()).b(uploadOperation);
        }
        UploadOperation i = m7311i(uploadOperation.p);
        if (i != null) {
            int size;
            m7318n(i);
            ((UploadNotificationManager) this.f7031c.get()).c(i);
            UploadRecords uploadRecords = i.F;
            DefaultPhotoFlowLogger d = ((UploadOperationHelper) this.f7033e.get()).d(i);
            String str = "2.0";
            UploadType a = i.a();
            UploadMethodType g = m7340g(i);
            if (uploadRecords != null) {
                size = uploadRecords.a().size();
            } else {
                size = -1;
            }
            d.a(str, a, g, i, size, i.k(), i.E, this.f7040l.a() - i.ae());
            m7312k(this, i);
            return;
        }
        m7331c(uploadOperation);
    }

    public final boolean m7337e(String str) {
        if (!this.f7051w.containsKey(str) && m7311i(str) == null) {
            return false;
        }
        return true;
    }

    public final void m7332c(UploadOperation uploadOperation, RequestType requestType, String str) {
        ((DefaultAndroidThreadUtil) this.f7042n.get()).a();
        if (!this.f7051w.containsKey(uploadOperation.p)) {
            m7323a(uploadOperation, requestType, str);
        }
    }

    private UploadOperation m7311i(String str) {
        ListIterator listIterator = this.f7053y.listIterator();
        while (listIterator.hasNext()) {
            UploadOperation uploadOperation = (UploadOperation) listIterator.next();
            if (Objects.equal(uploadOperation.p, str)) {
                return uploadOperation;
            }
        }
        return null;
    }

    public final boolean m7326a(String str, RequestType requestType) {
        String str2;
        if (requestType == RequestType.UserRetry) {
            str2 = "Composer user retry";
        } else {
            Object obj;
            if (this.f7036h.m7347a()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                return false;
            }
            str2 = "Composer auto retry";
        }
        Iterator it = this.f7053y.iterator();
        while (it.hasNext()) {
            UploadOperation uploadOperation = (UploadOperation) it.next();
            if (Objects.equal(uploadOperation.p, str)) {
                m7332c(uploadOperation, requestType, str2);
                return true;
            }
        }
        return false;
    }

    public final boolean m7329b(String str, RequestType requestType) {
        Iterator it = this.f7053y.iterator();
        while (it.hasNext()) {
            UploadOperation uploadOperation = (UploadOperation) it.next();
            if (Objects.equal(uploadOperation.p, str)) {
                m7332c(uploadOperation, requestType, "Composer auto retry");
                return true;
            }
        }
        for (Entry entry : this.f7051w.entrySet()) {
            if (Objects.equal(entry.getKey(), str)) {
                m7335d(((QueuedOperation) entry.getValue()).b);
                return true;
            }
        }
        return false;
    }

    public final void m7338f(UploadOperation uploadOperation) {
        ((DefaultAndroidThreadUtil) this.f7042n.get()).a();
        if (!this.f7051w.containsKey(uploadOperation.p)) {
            m7316m(this, uploadOperation);
        }
    }

    public final void m7330c() {
        super.c();
        ((DefaultAndroidThreadUtil) this.f7042n.get()).a(new 6(this));
    }

    public final synchronized void m7339f(String str) {
        this.f7054z.add(str);
    }

    public static UploadMethodType m7303a(Type type) {
        if (type == Type.VIDEO || type == Type.PROFILE_VIDEO || type == Type.LIVE_VIDEO) {
            return UploadMethodType.CHUNKED;
        }
        return UploadMethodType.NOT_RELEVANT;
    }

    public static void m7305a(UploadManager uploadManager, UploadOperation uploadOperation, String str, Bundle bundle, String str2) {
        Builder builder = ImmutableList.builder();
        ImmutableList immutableList = uploadOperation.a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MediaItem mediaItem = (MediaItem) immutableList.get(i);
            if ((mediaItem instanceof VideoItem) && bundle.containsKey(mediaItem.e())) {
                builder.c(bundle.getString(mediaItem.e()));
            }
        }
        if (uploadOperation.aa()) {
            builder.c(str2);
        }
        FeedVideoStatusChecker a = uploadManager.f7049u.m7371a(str2, uploadOperation.Z(), builder.b(), new 7(uploadManager, uploadOperation, str));
        a.d.a(a.h, new 1(a)).a();
    }

    public static boolean m7320p(UploadManager uploadManager) {
        return uploadManager.f7029B.a((short) -28636, OptimisticVideoUploadQuickExperiment.a.booleanValue());
    }
}
