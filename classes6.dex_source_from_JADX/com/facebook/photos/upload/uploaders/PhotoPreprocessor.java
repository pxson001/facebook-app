package com.facebook.photos.upload.uploaders;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.base.analytics.upload.UploadBaseParams;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.manager.UploadManager$RequestType;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperationHelper;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.operation.UploadRecords;
import com.facebook.photos.upload.uploaders.PreprocessedResult.Status;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.SortedMapDifferenceImpl;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: friends_locations_feedstory_tap_message */
public class PhotoPreprocessor {
    public static final String f14406a = PhotoPreprocessor.class.getSimpleName();
    private static volatile PhotoPreprocessor f14407x;
    public final Lazy<DirectPhotoUploader> f14408b;
    private final Lazy<ListeningExecutorService> f14409c;
    private final Lazy<TasksManager> f14410d;
    private final Lazy<UploadOperationHelper> f14411e;
    public final Lazy<FbErrorReporter> f14412f;
    private final Lazy<AndroidThreadUtil> f14413g;
    private final Lazy<UploadManager> f14414h;
    public final MediaUploadCancelHandler f14415i;
    public final Clock f14416j;
    public final boolean f14417k;
    public int f14418l;
    public DefaultPhotoFlowLogger f14419m;
    public UploadBaseParams f14420n;
    public final TreeMap<String, PreprocessedResult> f14421o = Maps.f();
    private final Map<String, PhotoInfo> f14422p = Maps.c();
    public ListenableFuture<PreprocessedResult> f14423q = null;
    public String f14424r;
    public ListenableFuture<UploadRecord> f14425s = null;
    public String f14426t;
    public String f14427u;
    public Set<PendingUploadOperation> f14428v = Sets.a();
    public ViewerContext f14429w;

    /* compiled from: friends_locations_feedstory_tap_message */
    class C09335 implements Runnable {
        final /* synthetic */ PhotoPreprocessor f14400a;

        C09335(PhotoPreprocessor photoPreprocessor) {
            this.f14400a = photoPreprocessor;
        }

        public void run() {
            this.f14400a.f14415i.m22005c();
        }
    }

    @VisibleForTesting
    /* compiled from: friends_locations_feedstory_tap_message */
    public class PendingUploadOperation {
        public UploadOperation f14401a;
        public Map<String, UploadRecord> f14402b;

        public PendingUploadOperation(UploadOperation uploadOperation, Map<String, UploadRecord> map) {
            this.f14401a = uploadOperation;
            this.f14402b = map;
        }
    }

    /* compiled from: friends_locations_feedstory_tap_message */
    public class PhotoInfo {
        final /* synthetic */ PhotoPreprocessor f14403a;
        public int f14404b;
        private long f14405c;

        public PhotoInfo(PhotoPreprocessor photoPreprocessor, int i, long j) {
            this.f14403a = photoPreprocessor;
            this.f14404b = i;
            this.f14405c = j;
        }

        public final long m22047b() {
            return this.f14405c;
        }
    }

    /* compiled from: friends_locations_feedstory_tap_message */
    enum TaskType {
        PROCESSING,
        UPLOADING
    }

    public static com.facebook.photos.upload.uploaders.PhotoPreprocessor m22048a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14407x;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.uploaders.PhotoPreprocessor.class;
        monitor-enter(r1);
        r0 = f14407x;	 Catch:{ all -> 0x003a }
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
        r0 = m22050b(r0);	 Catch:{ all -> 0x0035 }
        f14407x = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14407x;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.uploaders.PhotoPreprocessor.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.uploaders.PhotoPreprocessor");
    }

    private static PhotoPreprocessor m22050b(InjectorLike injectorLike) {
        return new PhotoPreprocessor(IdBasedLazy.a(injectorLike, 9495), IdBasedSingletonScopeProvider.b(injectorLike, 3834), IdBasedLazy.a(injectorLike, 3561), IdBasedLazy.a(injectorLike, 9468), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 517), IdBasedSingletonScopeProvider.b(injectorLike, 2984), MediaUploadCancelHandler.m21997b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 734));
    }

    @Inject
    public PhotoPreprocessor(Lazy<DirectPhotoUploader> lazy, Lazy<ListeningExecutorService> lazy2, Lazy<TasksManager> lazy3, Lazy<UploadOperationHelper> lazy4, Lazy<FbErrorReporter> lazy5, Lazy<AndroidThreadUtil> lazy6, Lazy<UploadManager> lazy7, MediaUploadCancelHandler mediaUploadCancelHandler, Clock clock, Provider<TriState> provider) {
        this.f14408b = lazy;
        this.f14409c = lazy2;
        this.f14410d = lazy3;
        this.f14411e = lazy4;
        this.f14412f = lazy5;
        this.f14413g = lazy6;
        this.f14414h = lazy7;
        this.f14415i = mediaUploadCancelHandler;
        this.f14416j = clock;
        this.f14417k = ((TriState) provider.get()).asBoolean(false);
        this.f14418l = 1;
    }

    public final void m22059a(List<MediaItem> list, String str, ViewerContext viewerContext) {
        ((DefaultAndroidThreadUtil) this.f14413g.get()).a();
        if (!StringUtil.a(this.f14427u, str)) {
            this.f14427u = str;
            this.f14419m = ((UploadOperationHelper) this.f14411e.get()).m21585a(str);
            this.f14420n = this.f14419m.m19944j("2.0");
            if (!this.f14421o.isEmpty()) {
                ((AbstractFbErrorReporter) this.f14412f.get()).a(f14406a, "Composer start with a non-empty resultMap");
                this.f14421o.clear();
            }
            if (this.f14417k) {
                this.f14418l = 1;
            }
            this.f14429w = viewerContext;
        }
        Map c = Maps.c();
        for (MediaItem mediaItem : list) {
            if (mediaItem.l() == MediaType.PHOTO) {
                String e = mediaItem.e();
                c.put(e, mediaItem);
                if (this.f14422p.containsKey(e) && !(((PhotoInfo) this.f14422p.get(e)).f14404b == mediaItem.g() && ((PhotoInfo) this.f14422p.get(e)).m22047b() == mediaItem.j())) {
                    this.f14421o.remove(e);
                }
                this.f14422p.put(mediaItem.e(), new PhotoInfo(this, mediaItem.g(), mediaItem.j()));
            }
        }
        SortedMapDifferenceImpl a = Maps.a(this.f14421o, c);
        for (String a2 : a.a().keySet()) {
            m22049a(a2);
        }
        for (String a22 : a.b().keySet()) {
            this.f14421o.put(a22, new PreprocessedResult(Status.NEW, null, null));
        }
        if (this.f14423q == null) {
            m22051c(this);
        }
        if (this.f14417k && this.f14425s == null) {
            m22052d(this);
        }
    }

    public static void m22052d(PhotoPreprocessor photoPreprocessor) {
        String str;
        photoPreprocessor.f14415i.m21999a();
        for (Entry entry : photoPreprocessor.f14421o.entrySet()) {
            PreprocessedResult preprocessedResult = (PreprocessedResult) entry.getValue();
            if (!preprocessedResult.f14431b.equals(Status.PREPROCESSED) && !preprocessedResult.f14431b.equals(Status.USE_ORIGINAL)) {
                if (preprocessedResult.f14431b.equals(Status.UPLOADED)) {
                    Object obj;
                    if (photoPreprocessor.f14416j.a() - preprocessedResult.f14432c.uploadTime > 72000000) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                    }
                }
            }
            str = (String) entry.getKey();
        }
        str = null;
        final String str2 = str;
        if (str2 == null) {
            photoPreprocessor.f14421o.toString();
            return;
        }
        photoPreprocessor.f14426t = photoPreprocessor.f14427u;
        photoPreprocessor.f14425s = ((ListeningExecutorService) photoPreprocessor.f14409c.get()).a(new Callable<UploadRecord>(photoPreprocessor) {
            final /* synthetic */ PhotoPreprocessor f14397b;

            public Object call() {
                MediaUploadCancelHandler mediaUploadCancelHandler = this.f14397b.f14415i;
                ViewerContext viewerContext = this.f14397b.f14429w;
                PhotoPreprocessor photoPreprocessor = this.f14397b;
                int i = photoPreprocessor.f14418l;
                photoPreprocessor.f14418l = i + 1;
                return ((DirectPhotoUploader) this.f14397b.f14408b.get()).m21991a(str2, this.f14397b.f14426t, "photo_preuploading_batch", mediaUploadCancelHandler, viewerContext, i, this.f14397b.f14421o.size());
            }
        });
        ((TasksManager) photoPreprocessor.f14410d.get()).a(TaskType.UPLOADING, photoPreprocessor.f14425s, new AbstractDisposableFutureCallback<UploadRecord>(photoPreprocessor) {
            final /* synthetic */ PhotoPreprocessor f14399b;

            protected final void m22044a(Object obj) {
                UploadRecord uploadRecord = (UploadRecord) obj;
                String str = PhotoPreprocessor.f14406a;
                str = this.f14399b.f14426t;
                PhotoPreprocessor photoPreprocessor = this.f14399b;
                String str2 = this.f14399b.f14426t;
                for (PendingUploadOperation pendingUploadOperation : photoPreprocessor.f14428v) {
                    if (StringUtil.a(str2, pendingUploadOperation.f14401a.f13793p)) {
                        break;
                    }
                }
                PendingUploadOperation pendingUploadOperation2 = null;
                PendingUploadOperation pendingUploadOperation3 = pendingUploadOperation2;
                if (pendingUploadOperation3 != null) {
                    pendingUploadOperation3.f14402b.put(str2, uploadRecord);
                } else if (StringUtil.a(this.f14399b.f14426t, this.f14399b.f14427u) && this.f14399b.f14421o.containsKey(str2)) {
                    this.f14399b.f14421o.put(str2, new PreprocessedResult(Status.UPLOADED, null, uploadRecord));
                }
                this.f14399b.f14426t = null;
                this.f14399b.f14425s = null;
                PhotoPreprocessor.m22054g(this.f14399b);
                PhotoPreprocessor.m22052d(this.f14399b);
            }

            protected final void m22045a(Throwable th) {
                String str = PhotoPreprocessor.f14406a;
                str = this.f14399b.f14426t;
                if (th instanceof Exception) {
                    boolean z = new ExceptionInterpreter((Exception) th).f12628m;
                } else {
                    ((AbstractFbErrorReporter) this.f14399b.f14412f.get()).a(PhotoPreprocessor.f14406a, "Upload Fail and get a throwable that is not an exception.");
                }
                if (StringUtil.a(this.f14399b.f14426t, this.f14399b.f14427u) && this.f14399b.f14421o.containsKey(str2)) {
                    this.f14399b.f14421o.put(str2, new PreprocessedResult(Status.FATAL, null, null));
                }
                this.f14399b.f14426t = null;
                this.f14399b.f14425s = null;
                PhotoPreprocessor.m22054g(this.f14399b);
                PhotoPreprocessor.m22052d(this.f14399b);
            }

            protected final void m22046a(CancellationException cancellationException) {
                super.a(cancellationException);
                String str = PhotoPreprocessor.f14406a;
                str = this.f14399b.f14426t;
                this.f14399b.f14426t = null;
                this.f14399b.f14425s = null;
                PhotoPreprocessor.m22054g(this.f14399b);
                PhotoPreprocessor.m22052d(this.f14399b);
            }
        });
    }

    public static void m22051c(PhotoPreprocessor photoPreprocessor) {
        String str;
        for (Entry entry : photoPreprocessor.f14421o.entrySet()) {
            if (((PreprocessedResult) entry.getValue()).f14431b.equals(Status.NEW)) {
                str = (String) entry.getKey();
                break;
            }
        }
        str = null;
        final String str2 = str;
        if (str2 == null) {
            Integer.valueOf(photoPreprocessor.f14421o.size());
            photoPreprocessor.f14421o.toString();
            return;
        }
        photoPreprocessor.f14424r = photoPreprocessor.f14427u;
        photoPreprocessor.f14423q = ((ListeningExecutorService) photoPreprocessor.f14409c.get()).a(new Callable<PreprocessedResult>(photoPreprocessor) {
            final /* synthetic */ PhotoPreprocessor f14393b;

            public Object call() {
                return ((DirectPhotoUploader) this.f14393b.f14408b.get()).m21992a(str2, this.f14393b.f14419m, this.f14393b.f14420n, this.f14393b.f14415i);
            }
        });
        ((TasksManager) photoPreprocessor.f14410d.get()).a(TaskType.PROCESSING, photoPreprocessor.f14423q, new AbstractDisposableFutureCallback<PreprocessedResult>(photoPreprocessor) {
            final /* synthetic */ PhotoPreprocessor f14395b;

            protected final void m22042a(Object obj) {
                PreprocessedResult preprocessedResult = (PreprocessedResult) obj;
                String str = PhotoPreprocessor.f14406a;
                str = this.f14395b.f14424r;
                if (StringUtil.a(this.f14395b.f14424r, this.f14395b.f14427u) && this.f14395b.f14421o.containsKey(str2)) {
                    this.f14395b.f14421o.put(str2, preprocessedResult);
                } else {
                    Object obj2;
                    PhotoPreprocessor photoPreprocessor = this.f14395b;
                    String str2 = this.f14395b.f14424r;
                    for (PendingUploadOperation pendingUploadOperation : photoPreprocessor.f14428v) {
                        if (StringUtil.a(str2, pendingUploadOperation.f14401a.f13793p)) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        preprocessedResult.m22060c();
                    }
                }
                this.f14395b.f14424r = null;
                this.f14395b.f14423q = null;
                PhotoPreprocessor.m22054g(this.f14395b);
                PhotoPreprocessor.m22051c(this.f14395b);
                if (this.f14395b.f14417k && this.f14395b.f14425s == null) {
                    PhotoPreprocessor.m22052d(this.f14395b);
                }
            }

            protected final void m22043a(Throwable th) {
                ((AbstractFbErrorReporter) this.f14395b.f14412f.get()).b(PhotoPreprocessor.f14406a, "Unexpected exception when pre process", th);
                if (StringUtil.a(this.f14395b.f14424r, this.f14395b.f14427u) && this.f14395b.f14421o.containsKey(str2)) {
                    this.f14395b.f14421o.put(str2, new PreprocessedResult(Status.FATAL, null, null));
                }
                this.f14395b.f14424r = null;
                this.f14395b.f14423q = null;
                PhotoPreprocessor.m22054g(this.f14395b);
                PhotoPreprocessor.m22051c(this.f14395b);
            }
        });
    }

    private void m22049a(String str) {
        PreprocessedResult preprocessedResult = (PreprocessedResult) this.f14421o.remove(str);
        Preconditions.checkNotNull(preprocessedResult);
        preprocessedResult.m22060c();
    }

    public final void m22057a() {
        ((DefaultAndroidThreadUtil) this.f14413g.get()).a();
        for (PreprocessedResult c : this.f14421o.values()) {
            c.m22060c();
        }
        if (this.f14417k && StringUtil.a(this.f14426t, this.f14427u)) {
            m22056i();
        }
        this.f14421o.clear();
        this.f14427u = null;
    }

    public final void m22058a(UploadOperation uploadOperation) {
        ((DefaultAndroidThreadUtil) this.f14413g.get()).a();
        if (m22053d(uploadOperation.f13793p)) {
            uploadOperation.f13757F = new UploadRecords(m22055h());
            ((UploadManager) this.f14414h.get()).a(uploadOperation, UploadManager$RequestType.InitialPost, null);
        } else {
            this.f14428v.add(new PendingUploadOperation(uploadOperation, m22055h()));
        }
        if (this.f14417k && StringUtil.a(this.f14426t, this.f14427u)) {
            m22056i();
        }
        this.f14421o.clear();
        this.f14427u = null;
    }

    public static void m22054g(PhotoPreprocessor photoPreprocessor) {
        if (!photoPreprocessor.f14428v.isEmpty()) {
            if (photoPreprocessor.f14428v.size() > 2) {
                ((AbstractFbErrorReporter) photoPreprocessor.f14412f.get()).a(f14406a, "More than two waiting operations.");
            }
            for (PendingUploadOperation pendingUploadOperation : Sets.b(photoPreprocessor.f14428v)) {
                if (photoPreprocessor.m22053d(pendingUploadOperation.f14401a.f13793p)) {
                    photoPreprocessor.f14428v.remove(pendingUploadOperation);
                    pendingUploadOperation.f14401a.f13757F = new UploadRecords(pendingUploadOperation.f14402b);
                    ((UploadManager) photoPreprocessor.f14414h.get()).a(pendingUploadOperation.f14401a, UploadManager$RequestType.InitialPost, null);
                }
            }
        }
    }

    private Map<String, UploadRecord> m22055h() {
        Map<String, UploadRecord> c = Maps.c();
        for (Entry entry : this.f14421o.entrySet()) {
            if (((PreprocessedResult) entry.getValue()).f14432c != null) {
                c.put(entry.getKey(), ((PreprocessedResult) entry.getValue()).f14432c);
            }
        }
        return c;
    }

    private boolean m22053d(String str) {
        return (StringUtil.a(this.f14424r, str) || (this.f14417k && StringUtil.a(this.f14426t, str))) ? false : true;
    }

    private synchronized void m22056i() {
        ExecutorDetour.a((ListeningExecutorService) this.f14409c.get(), new C09335(this), 645301806);
    }
}
