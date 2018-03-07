package com.facebook.messaging.media.upload;

import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Throwables;
import java.io.FileNotFoundException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: loading_type_ */
public class MediaUploadErrorHelper {
    private static volatile MediaUploadErrorHelper f11892b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<QeAccessor> f11893a = UltralightRuntime.b;

    public static com.facebook.messaging.media.upload.MediaUploadErrorHelper m12481a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11892b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.MediaUploadErrorHelper.class;
        monitor-enter(r1);
        r0 = f11892b;	 Catch:{ all -> 0x003a }
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
        r0 = m12482b(r0);	 Catch:{ all -> 0x0035 }
        f11892b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11892b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaUploadErrorHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaUploadErrorHelper");
    }

    private static MediaUploadErrorHelper m12482b(InjectorLike injectorLike) {
        MediaUploadErrorHelper mediaUploadErrorHelper = new MediaUploadErrorHelper();
        mediaUploadErrorHelper.f11893a = IdBasedSingletonScopeProvider.b(injectorLike, 3219);
        return mediaUploadErrorHelper;
    }

    public final boolean m12483a(Throwable th) {
        if (th == null) {
            return false;
        }
        for (Throwable th2 : Throwables.getCausalChain(th)) {
            if ((th2 instanceof ResumableUploadException) || (th2 instanceof RuntimeException) || (th2 instanceof FileNotFoundException)) {
                return false;
            }
            if (th2 instanceof ApiException) {
                ApiErrorResult b = ((ApiException) th2).b();
                if (!(b == null || b.mIsTransient)) {
                    return ((QeAccessor) this.f11893a.get()).a(ExperimentsForMediaUploadModule.f11831c, false);
                }
            }
        }
        return true;
    }
}
