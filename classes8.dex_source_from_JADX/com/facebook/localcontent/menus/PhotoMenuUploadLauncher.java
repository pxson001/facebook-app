package com.facebook.localcontent.menus;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplecamera.SimpleCameraCallback;
import com.facebook.photos.simplecamera.SimpleCamera;
import com.facebook.photos.simplecamera.SimpleCamera.CameraType;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ec_cards_page_download */
public class PhotoMenuUploadLauncher {
    private static volatile PhotoMenuUploadLauncher f15056d;
    public final ActivityRuntimePermissionsManagerProvider f15057a;
    public final SecureContextHelper f15058b;
    public final SimpleCamera f15059c;

    /* compiled from: ec_cards_page_download */
    public class C16381 extends AbstractRuntimePermissionsListener {
        final /* synthetic */ Activity f15050a;
        final /* synthetic */ PhotoMenuUploadLauncher f15051b;

        public C16381(PhotoMenuUploadLauncher photoMenuUploadLauncher, Activity activity) {
            this.f15051b = photoMenuUploadLauncher;
            this.f15050a = activity;
        }

        public final void m17479a() {
            this.f15051b.f15058b.b(this.f15051b.f15059c.b(CameraType.IMAGE), 26003, this.f15050a);
        }
    }

    public static com.facebook.localcontent.menus.PhotoMenuUploadLauncher m17481a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15056d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.localcontent.menus.PhotoMenuUploadLauncher.class;
        monitor-enter(r1);
        r0 = f15056d;	 Catch:{ all -> 0x003a }
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
        r0 = m17483b(r0);	 Catch:{ all -> 0x0035 }
        f15056d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15056d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.localcontent.menus.PhotoMenuUploadLauncher.a(com.facebook.inject.InjectorLike):com.facebook.localcontent.menus.PhotoMenuUploadLauncher");
    }

    private static PhotoMenuUploadLauncher m17483b(InjectorLike injectorLike) {
        return new PhotoMenuUploadLauncher((ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SimpleCamera.b(injectorLike));
    }

    @Inject
    public PhotoMenuUploadLauncher(ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, SecureContextHelper secureContextHelper, SimpleCamera simpleCamera) {
        this.f15057a = activityRuntimePermissionsManagerProvider;
        this.f15058b = secureContextHelper;
        this.f15059c = simpleCamera;
    }

    public final void m17484a(int i, final Fragment fragment, final Long l, final ViewerContext viewerContext, @Nullable Intent intent) {
        if (i == 26002) {
            m17482a(this, fragment, l, viewerContext, intent.getParcelableArrayListExtra("extra_media_items"));
        } else if (i == 26003) {
            this.f15059c.a(CameraType.IMAGE, intent, new SimpleCameraCallback(this) {
                final /* synthetic */ PhotoMenuUploadLauncher f15055d;

                public final void m17480a(ImmutableList<MediaItem> immutableList, boolean z) {
                    PhotoMenuUploadLauncher.m17482a(this.f15055d, fragment, l, viewerContext, (List) immutableList);
                }
            });
        }
    }

    public static void m17482a(PhotoMenuUploadLauncher photoMenuUploadLauncher, Fragment fragment, Long l, ViewerContext viewerContext, List list) {
        Intent intent = new Intent(fragment.getContext(), PhotoMenuUploadActivity.class);
        intent.putExtra("com.facebook.katana.profile.id", l);
        intent.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", viewerContext);
        intent.putParcelableArrayListExtra("extra_media_items", new ArrayList(list));
        photoMenuUploadLauncher.f15058b.b(intent, 26001, fragment);
    }
}
