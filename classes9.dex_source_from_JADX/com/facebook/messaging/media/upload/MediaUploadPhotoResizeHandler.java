package com.facebook.messaging.media.upload;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.bitmaps.ImageResizer;
import com.facebook.bitmaps.ImageScaleParam;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.common.tempfile.BackingFileResolver.BackingFileResult;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.util.ExifOrientation;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Cancelable;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.photoquality.PhotoQuality;
import com.facebook.messaging.media.photoquality.PhotoQualityHelper;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.facebook.ui.media.attachments.MediaResourceUtil;
import com.google.common.base.Preconditions;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: loadHiddenBookmarksFromDB */
public class MediaUploadPhotoResizeHandler implements BlueServiceHandler, Cancelable {
    private static final Object f11937f = new Object();
    private final TempFileManager f11938a;
    private final BackingFileResolver f11939b;
    private final Provider<ImageResizer> f11940c;
    private final MediaResourceHelper f11941d;
    private final PhotoUploadServiceHandlerLogger f11942e;

    private static MediaUploadPhotoResizeHandler m12506b(InjectorLike injectorLike) {
        return new MediaUploadPhotoResizeHandler(TempFileManager.a(injectorLike), BackingFileResolver.a(injectorLike), IdBasedProvider.a(injectorLike, 4975), MediaResourceHelper.a(injectorLike), PhotoUploadServiceHandlerLogger.m12545a(injectorLike));
    }

    @Inject
    public MediaUploadPhotoResizeHandler(TempFileManager tempFileManager, BackingFileResolver backingFileResolver, Provider<ImageResizer> provider, MediaResourceHelper mediaResourceHelper, PhotoUploadServiceHandlerLogger photoUploadServiceHandlerLogger) {
        this.f11938a = tempFileManager;
        this.f11939b = backingFileResolver;
        this.f11940c = provider;
        this.f11941d = mediaResourceHelper;
        this.f11942e = photoUploadServiceHandlerLogger;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.MediaUploadPhotoResizeHandler m12502a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f11937f;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m12506b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f11937f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaUploadPhotoResizeHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.upload.MediaUploadPhotoResizeHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f11937f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaUploadPhotoResizeHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaUploadPhotoResizeHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaUploadPhotoResizeHandler");
    }

    public final OperationResult m12507a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("photo_resize".equals(str)) {
            return m12505b(operationParams);
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    public final boolean m12508a(String str) {
        return false;
    }

    private OperationResult m12505b(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        MediaResource mediaResource = (MediaResource) bundle.getParcelable("mediaResource");
        if (!MediaResourceUtil.b(mediaResource)) {
            return OperationResult.a(ErrorCode.OTHER, "MediaResource is not a photo.");
        }
        File a = m12503a(mediaResource, (PhotoQuality) bundle.getParcelable("photoQuality"), bundle.getInt("phase"));
        MediaResourceBuilder a2 = MediaResource.a().a(mediaResource);
        a2.e = mediaResource;
        MediaResourceBuilder mediaResourceBuilder = a2;
        mediaResourceBuilder.a = Uri.fromFile(a);
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.m = "image/jpeg";
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.h = 0;
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.i = 0;
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.j = ExifOrientation.UNDEFINED;
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.n = 0;
        return OperationResult.a(this.f11941d.b(mediaResourceBuilder.C()));
    }

    private File m12503a(MediaResource mediaResource, PhotoQuality photoQuality, int i) {
        Preconditions.checkNotNull(mediaResource.c);
        File a = this.f11938a.a("media_upload" + i, ".jpg", Privacy.REQUIRE_PRIVATE);
        this.f11942e.m12550a(mediaResource, i);
        BackingFileResult a2 = this.f11939b.a(mediaResource.c, Privacy.PREFER_SDCARD);
        try {
            m12504a(photoQuality, a2.a, a, mediaResource, i);
            a2.a();
            return a;
        } catch (Throwable th) {
            a2.a();
        }
    }

    private void m12504a(PhotoQuality photoQuality, File file, File file2, MediaResource mediaResource, int i) {
        this.f11942e.m12553a(mediaResource, ((ImageResizer) this.f11940c.get()).a(file.getPath(), file2.getPath(), new ImageScaleParam(photoQuality.f11788b, photoQuality.f11788b, true, Math.max(photoQuality.f11789c, PhotoQualityHelper.a(Math.max(mediaResource.j, mediaResource.k))))), file2, i);
    }
}
