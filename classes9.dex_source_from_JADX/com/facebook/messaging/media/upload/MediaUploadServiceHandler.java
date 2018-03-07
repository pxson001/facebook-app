package com.facebook.messaging.media.upload;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Cancelable;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.util.MediaUploadStateHelper;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;
import java.util.concurrent.CancellationException;
import javax.annotation.concurrent.ThreadSafe;

@UserScoped
@ThreadSafe
/* compiled from: live_sport_event/{%s}/{%s} */
public class MediaUploadServiceHandler implements BlueServiceHandler, Cancelable {
    private static final ImmutableSet<String> f11943a = ImmutableSet.of("media_upload", "photo_upload", "photo_upload_parallel", "photo_upload_hires", "photo_upload_hires_parallel");
    private static final Object f11944e = new Object();
    private final BaseFbBroadcastManager f11945b;
    private final MediaUploadStateHelper f11946c;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MediaUploadServiceHelper> f11947d = UltralightRuntime.b;

    private static MediaUploadServiceHandler m12511b(InjectorLike injectorLike) {
        MediaUploadServiceHandler mediaUploadServiceHandler = new MediaUploadServiceHandler((BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), MediaUploadStateHelper.m12723a(injectorLike));
        mediaUploadServiceHandler.f11947d = IdBasedLazy.a(injectorLike, 7937);
        return mediaUploadServiceHandler;
    }

    @Inject
    private MediaUploadServiceHandler(BaseFbBroadcastManager baseFbBroadcastManager, MediaUploadStateHelper mediaUploadStateHelper) {
        this.f11945b = baseFbBroadcastManager;
        this.f11946c = mediaUploadStateHelper;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.MediaUploadServiceHandler m12509a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f11944e;	 Catch:{ all -> 0x006c }
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
        r1 = m12511b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f11944e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaUploadServiceHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.upload.MediaUploadServiceHandler) r0;	 Catch:{  }
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
        r0 = f11944e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaUploadServiceHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaUploadServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaUploadServiceHandler");
    }

    public final OperationResult m12512a(OperationParams operationParams) {
        String str = operationParams.b;
        if (f11943a.contains(str)) {
            return m12510b(operationParams);
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    private OperationResult m12510b(OperationParams operationParams) {
        String str = operationParams.a;
        if (this.f11946c.m12725b(str)) {
            Bundle bundle = operationParams.c;
            MediaResource mediaResource = (MediaResource) bundle.getParcelable("mediaResource");
            String a = ((MediaUploadServiceHelper) this.f11947d.get()).m12520a(false, bundle.getBoolean("fullQualityImageUpload"), mediaResource, bundle.getString("originalFbid"), str);
            if (this.f11946c.m12726c(str)) {
                this.f11945b.a(MediaUploadEvents.m12489b(mediaResource));
                return OperationResult.a(a);
            }
            throw new CancellationException();
        }
        throw new CancellationException();
    }

    public final synchronized boolean m12513a(String str) {
        return this.f11946c.m12724a(str);
    }
}
