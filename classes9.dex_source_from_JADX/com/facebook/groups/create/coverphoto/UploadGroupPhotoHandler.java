package com.facebook.groups.create.coverphoto;

import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.media.MediaItemFactory.PhotoItemBuilder;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.protocol.UploadPhotoParams;
import com.facebook.photos.upload.protocol.UploadPhotoParams.Builder;
import com.facebook.photos.upload.protocol.UploadPhotoSource;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.facebook.photos.upload.retry.NoImmediateRetryPolicy;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader.DirectUploadListener;
import com.facebook.photos.upload.uploaders.MediaUploadCancelHandler;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: pdus */
public class UploadGroupPhotoHandler {
    public final DirectPhotoUploader f6781a;
    public final DefaultPhotoFlowLogger f6782b;
    public final ImmediateRetryPolicy f6783c = new NoImmediateRetryPolicy();
    public final AbstractFbErrorReporter f6784d;
    private final ExecutorService f6785e;

    @Inject
    public UploadGroupPhotoHandler(DirectPhotoUploader directPhotoUploader, DefaultPhotoFlowLogger defaultPhotoFlowLogger, AbstractFbErrorReporter abstractFbErrorReporter, ExecutorService executorService) {
        this.f6781a = directPhotoUploader;
        this.f6782b = defaultPhotoFlowLogger;
        this.f6784d = abstractFbErrorReporter;
        this.f6785e = executorService;
    }

    public final ListenableFuture<String> m7096a(Uri uri, String str) {
        final SettableFuture f = SettableFuture.f();
        try {
            PhotoItem a = new PhotoItemBuilder().b(uri.getPath()).a();
            String uuid = SafeUUIDGenerator.a().toString();
            final HashSet a2 = Sets.a();
            a2.add(new Builder(new UploadPhotoSource(a.e(), a.o())).a(Long.parseLong(str)).a());
            this.f6782b.a(uuid);
            final MediaUploadCancelHandler mediaUploadCancelHandler = new MediaUploadCancelHandler();
            ExecutorDetour.a(this.f6785e, new Runnable(this) {
                final /* synthetic */ UploadGroupPhotoHandler f6780d;

                /* compiled from: pdus */
                class C06961 extends DirectUploadListener {
                    final /* synthetic */ C06971 f6776a;

                    C06961(C06971 c06971) {
                        this.f6776a = c06971;
                    }

                    public final void m7095a(UploadPhotoParams uploadPhotoParams, UploadRecord uploadRecord) {
                        FutureDetour.a(f, String.valueOf(uploadRecord.fbid), 731790214);
                    }
                }

                public void run() {
                    try {
                        this.f6780d.f6781a.a(a2, new C06961(this), mediaUploadCancelHandler, this.f6780d.f6782b, this.f6780d.f6782b.j("2.0"), null, this.f6780d.f6783c);
                    } catch (Throwable e) {
                        this.f6780d.f6784d.a(UploadGroupPhotoHandler.class.getName(), "Failed to upload group cover photo");
                        f.a(e);
                    }
                }
            }, -1284884546);
        } catch (Throwable th) {
            this.f6784d.a(UploadGroupPhotoHandler.class.getName(), "Failed to upload group cover photo");
            f.a(th);
        }
        return f;
    }
}
