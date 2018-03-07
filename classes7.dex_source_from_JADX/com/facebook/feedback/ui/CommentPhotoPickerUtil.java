package com.facebook.feedback.ui;

import android.content.Intent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.simplecamera.SimpleCamera;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.Iterables;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: secondary_actions */
public class CommentPhotoPickerUtil {
    private static final String[] f4288a = new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static volatile CommentPhotoPickerUtil f4289g;
    private final ActivityRuntimePermissionsManagerProvider f4290b;
    public final SecureContextHelper f4291c;
    public final Lazy<SimpleCamera> f4292d;
    private final Toaster f4293e;
    public final QeAccessor f4294f;

    public static com.facebook.feedback.ui.CommentPhotoPickerUtil m4885a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4289g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.ui.CommentPhotoPickerUtil.class;
        monitor-enter(r1);
        r0 = f4289g;	 Catch:{ all -> 0x003a }
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
        r0 = m4887b(r0);	 Catch:{ all -> 0x0035 }
        f4289g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4289g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.ui.CommentPhotoPickerUtil.a(com.facebook.inject.InjectorLike):com.facebook.feedback.ui.CommentPhotoPickerUtil");
    }

    private static CommentPhotoPickerUtil m4887b(InjectorLike injectorLike) {
        return new CommentPhotoPickerUtil((ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), IdBasedLazy.a(injectorLike, 9418), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), Toaster.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CommentPhotoPickerUtil(ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, Lazy<SimpleCamera> lazy, SecureContextHelper secureContextHelper, Toaster toaster, QeAccessor qeAccessor) {
        this.f4290b = activityRuntimePermissionsManagerProvider;
        this.f4292d = lazy;
        this.f4291c = secureContextHelper;
        this.f4293e = toaster;
        this.f4294f = qeAccessor;
    }

    public static MediaItem m4886a(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 954) {
            return (MediaItem) Iterables.a(intent.getParcelableArrayListExtra("extra_media_items"), null);
        }
        return null;
    }
}
