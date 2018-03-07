package com.facebook.timeline.editfeaturedcontainers.utils;

import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.protocol.UploadPhotoParams;
import com.facebook.photos.upload.retry.NoImmediateRetryPolicy;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader.DirectUploadListener;
import com.facebook.photos.upload.uploaders.MediaUploadCancelHandler;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Collections;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: geofence_end_time_ms */
public class UploadFeaturedPhotoController {
    public final DirectPhotoUploader f10977a;
    public final MediaUploadCancelHandler f10978b;
    public final DefaultPhotoFlowLogger f10979c;
    public final ListeningExecutorService f10980d;

    /* compiled from: geofence_end_time_ms */
    public class C15941 extends DirectUploadListener {
        final /* synthetic */ SettableFuture f10971a;
        final /* synthetic */ UploadFeaturedPhotoController f10972b;

        public C15941(UploadFeaturedPhotoController uploadFeaturedPhotoController, SettableFuture settableFuture) {
            this.f10972b = uploadFeaturedPhotoController;
            this.f10971a = settableFuture;
        }

        public final void m11094a(UploadPhotoParams uploadPhotoParams, UploadRecord uploadRecord) {
            FutureDetour.a(this.f10971a, String.valueOf(uploadRecord.fbid), -1630233759);
        }
    }

    /* compiled from: geofence_end_time_ms */
    public class C15952 implements Runnable {
        final /* synthetic */ UploadPhotoParams f10973a;
        final /* synthetic */ DirectUploadListener f10974b;
        final /* synthetic */ SettableFuture f10975c;
        final /* synthetic */ UploadFeaturedPhotoController f10976d;

        public C15952(UploadFeaturedPhotoController uploadFeaturedPhotoController, UploadPhotoParams uploadPhotoParams, DirectUploadListener directUploadListener, SettableFuture settableFuture) {
            this.f10976d = uploadFeaturedPhotoController;
            this.f10973a = uploadPhotoParams;
            this.f10974b = directUploadListener;
            this.f10975c = settableFuture;
        }

        public void run() {
            try {
                this.f10976d.f10977a.a(Collections.singletonList(this.f10973a), this.f10974b, this.f10976d.f10978b, this.f10976d.f10979c, this.f10976d.f10979c.j("1.0"), null, new NoImmediateRetryPolicy());
            } catch (Exception e) {
                this.f10975c.a(new Throwable("Error while uploading photo"));
            }
        }
    }

    @Inject
    public UploadFeaturedPhotoController(DirectPhotoUploader directPhotoUploader, MediaUploadCancelHandler mediaUploadCancelHandler, Provider<PhotoFlowLogger> provider, ListeningExecutorService listeningExecutorService) {
        this.f10977a = directPhotoUploader;
        this.f10978b = mediaUploadCancelHandler;
        this.f10979c = (DefaultPhotoFlowLogger) provider.get();
        this.f10980d = listeningExecutorService;
        this.f10979c.a(SafeUUIDGenerator.a().toString());
    }
}
