package com.facebook.messaging.media.upload;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.media.bandwidth.MediaBandwidthManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: local_registration_id */
public class MediaPreUploadPhotoHelper {
    public final ListeningExecutorService f11860a;
    private final DefaultAndroidThreadUtil f11861b;
    private final MediaResourceHelper f11862c;
    public final Lazy<MediaUploadManager> f11863d;
    public final Executor f11864e;
    public final Cache<MediaResource, ListenableFuture<MediaResource>> f11865f = CacheBuilder.newBuilder().a(5, TimeUnit.MINUTES).q();
    public final QeAccessor f11866g;
    public final MediaBandwidthManager f11867h;

    /* compiled from: local_registration_id */
    public class C13381 implements Callable<MediaResource> {
        final /* synthetic */ MediaResource f11855a;
        final /* synthetic */ Context f11856b;
        final /* synthetic */ MediaPreUploadPhotoHelper f11857c;

        public C13381(MediaPreUploadPhotoHelper mediaPreUploadPhotoHelper, MediaResource mediaResource, Context context) {
            this.f11857c = mediaPreUploadPhotoHelper;
            this.f11855a = mediaResource;
            this.f11856b = context;
        }

        public Object call() {
            return MediaPreUploadPhotoHelper.m12466c(this.f11857c, this.f11855a, this.f11856b);
        }
    }

    /* compiled from: local_registration_id */
    public class C13392 implements FutureCallback<MediaResource> {
        final /* synthetic */ MediaResource f11858a;
        final /* synthetic */ MediaPreUploadPhotoHelper f11859b;

        public C13392(MediaPreUploadPhotoHelper mediaPreUploadPhotoHelper, MediaResource mediaResource) {
            this.f11859b = mediaPreUploadPhotoHelper;
            this.f11858a = mediaResource;
        }

        public void onSuccess(Object obj) {
            ((MediaUploadManagerImpl) this.f11859b.f11863d.get()).a((MediaResource) obj);
        }

        public void onFailure(Throwable th) {
            BLog.b("MediaPreUploadPhotoHelper", "Media resource preparation interrupted or failed. Uri: %s, type: %s, fbid: %s", new Object[]{this.f11858a.c.toString(), this.f11858a.d.toString(), this.f11858a.u});
        }
    }

    public static MediaPreUploadPhotoHelper m12465b(InjectorLike injectorLike) {
        return new MediaPreUploadPhotoHelper(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), MediaResourceHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 2644), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), MediaBandwidthManager.a(injectorLike));
    }

    @Inject
    public MediaPreUploadPhotoHelper(ListeningExecutorService listeningExecutorService, AndroidThreadUtil androidThreadUtil, MediaResourceHelper mediaResourceHelper, Lazy<MediaUploadManager> lazy, Executor executor, QeAccessor qeAccessor, MediaBandwidthManager mediaBandwidthManager) {
        this.f11860a = listeningExecutorService;
        this.f11861b = androidThreadUtil;
        this.f11862c = mediaResourceHelper;
        this.f11863d = lazy;
        this.f11864e = executor;
        this.f11866g = qeAccessor;
        this.f11867h = mediaBandwidthManager;
    }

    public static MediaResource m12466c(MediaPreUploadPhotoHelper mediaPreUploadPhotoHelper, MediaResource mediaResource, Context context) {
        mediaPreUploadPhotoHelper.f11861b.b();
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(mediaResource.c);
        context.sendBroadcast(intent);
        if (MediaResourceHelper.a(mediaResource)) {
            return mediaResource;
        }
        MediaResourceBuilder a = MediaResource.a().a(mediaResource);
        mediaPreUploadPhotoHelper.f11862c.a(a);
        return a.C();
    }
}
