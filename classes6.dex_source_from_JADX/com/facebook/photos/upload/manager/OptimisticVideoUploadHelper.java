package com.facebook.photos.upload.manager;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.upload.abtest.OptimisticVideoUploadQuickExperiment;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.photos.upload.uploaders.UploadSessionContext;
import com.facebook.photos.upload.uploaders.VideoUploader;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: graph_search_results_page_event */
public class OptimisticVideoUploadHelper {
    private static final Class<?> f13627a = OptimisticVideoUploadHelper.class;
    private static volatile OptimisticVideoUploadHelper f13628g;
    private final Lazy<UploadManager> f13629b;
    private final UploadOperationFactory f13630c;
    private final Lazy<AndroidThreadUtil> f13631d;
    private final QeAccessor f13632e;
    @VisibleForTesting
    public final Map<String, UploadOperation> f13633f = new HashMap();

    public static com.facebook.photos.upload.manager.OptimisticVideoUploadHelper m21362a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13628g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.manager.OptimisticVideoUploadHelper.class;
        monitor-enter(r1);
        r0 = f13628g;	 Catch:{ all -> 0x003a }
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
        r0 = m21365b(r0);	 Catch:{ all -> 0x0035 }
        f13628g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13628g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.manager.OptimisticVideoUploadHelper.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.manager.OptimisticVideoUploadHelper");
    }

    private static OptimisticVideoUploadHelper m21365b(InjectorLike injectorLike) {
        return new OptimisticVideoUploadHelper(IdBasedSingletonScopeProvider.b(injectorLike, 2984), UploadOperationFactory.m21557b(injectorLike), IdBasedLazy.a(injectorLike, 517), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public OptimisticVideoUploadHelper(Lazy<UploadManager> lazy, UploadOperationFactory uploadOperationFactory, Lazy<AndroidThreadUtil> lazy2, QeAccessor qeAccessor) {
        this.f13629b = lazy;
        this.f13630c = uploadOperationFactory;
        this.f13632e = qeAccessor;
        this.f13631d = lazy2;
    }

    public final void m21369a(List<MediaItem> list, String str, ViewerContext viewerContext, long j) {
        ((DefaultAndroidThreadUtil) this.f13631d.get()).a();
        Preconditions.checkState(m21363a());
        UploadOperation uploadOperation = (UploadOperation) this.f13633f.get(str);
        if (uploadOperation != null && (list == null || list.isEmpty() || !((MediaItem) list.get(0)).e().equals(((MediaItem) uploadOperation.f13778a.get(0)).e()))) {
            m21366c(str);
        }
        if (list != null && !list.isEmpty() && ((MediaItem) list.get(0)).m() == MediaType.VIDEO) {
            Preconditions.checkState(list.size() == 1);
            ((MediaItem) list.get(0)).e();
            ((UploadManager) this.f13629b.get()).a(this.f13630c.m21563a((MediaItem) list.get(0), str, j, viewerContext));
        }
    }

    private boolean m21363a() {
        return this.f13632e.a((short) -28636, OptimisticVideoUploadQuickExperiment.f13532a.booleanValue());
    }

    public final void m21368a(String str) {
        ((DefaultAndroidThreadUtil) this.f13631d.get()).a();
        Preconditions.checkState(m21363a());
        m21366c(str);
    }

    public final void m21367a(UploadOperation uploadOperation) {
        this.f13633f.remove(uploadOperation.f13793p);
    }

    public final void m21371b(UploadOperation uploadOperation) {
        UploadOperation uploadOperation2 = (UploadOperation) this.f13633f.get(uploadOperation.f13793p);
        if (uploadOperation2 == null) {
            return;
        }
        if (uploadOperation.f13784g.equals("cancel") || m21364a(uploadOperation2, uploadOperation)) {
            this.f13633f.remove(uploadOperation.f13793p);
        }
    }

    public final void m21372c(UploadOperation uploadOperation) {
        if (uploadOperation.m21520Y() && uploadOperation.f13777Z) {
            this.f13633f.put(uploadOperation.f13793p, uploadOperation);
        }
    }

    public final void m21373d(UploadOperation uploadOperation) {
        UploadOperation uploadOperation2 = (UploadOperation) this.f13633f.get(uploadOperation.f13793p);
        if (uploadOperation2 != null) {
            uploadOperation2.f13777Z = uploadOperation.f13777Z;
            UploadSessionContext e = VideoUploader.m22137e(uploadOperation);
            Preconditions.checkNotNull(e);
            Preconditions.checkState(((MediaItem) e.f14467a.f13778a.get(0)).e().equals(((MediaItem) uploadOperation.f13778a.get(0)).e()));
            e.f14467a.f13777Z = uploadOperation.f13777Z;
            e.f14467a = uploadOperation;
            if (!uploadOperation.f13777Z) {
                e.m22075a(true);
            }
            this.f13633f.put(uploadOperation.f13793p, uploadOperation);
        }
    }

    public final UploadOperation m21370b(String str) {
        return (UploadOperation) this.f13633f.get(str);
    }

    private void m21366c(String str) {
        Preconditions.checkState(m21363a());
        if (str != null && this.f13633f.containsKey(str)) {
            BLog.b(f13627a, "Canceling optimistic upload for %s", new Object[]{str});
            ((UploadManager) this.f13629b.get()).c((UploadOperation) this.f13633f.get(str));
        }
    }

    public static boolean m21364a(UploadOperation uploadOperation, UploadOperation uploadOperation2) {
        return ((MediaItem) uploadOperation.f13778a.get(0)).e().equals(((MediaItem) uploadOperation2.f13778a.get(0)).e());
    }
}
