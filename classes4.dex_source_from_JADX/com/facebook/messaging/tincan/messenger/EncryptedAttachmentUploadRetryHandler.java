package com.facebook.messaging.tincan.messenger;

import android.net.Uri;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.MediaUploadManagerImpl;
import com.facebook.messaging.tincan.database.TincanDbMessagesFetcher;
import com.facebook.messaging.tincan.gatekeepers.TincanGatekeepers;
import com.facebook.ui.media.attachments.MediaResource;
import javax.inject.Inject;

@UserScoped
/* compiled from: mNonce */
public class EncryptedAttachmentUploadRetryHandler {
    private static final Object f8601e = new Object();
    public final MediaUploadManagerImpl f8602a;
    private final DefaultAndroidThreadUtil f8603b;
    private final TincanGatekeepers f8604c;
    private final TincanDbMessagesFetcher f8605d;

    private static EncryptedAttachmentUploadRetryHandler m8853b(InjectorLike injectorLike) {
        return new EncryptedAttachmentUploadRetryHandler(MediaUploadManagerImpl.m8858a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), TincanGatekeepers.b(injectorLike), TincanDbMessagesFetcher.a(injectorLike));
    }

    @Inject
    public EncryptedAttachmentUploadRetryHandler(MediaUploadManagerImpl mediaUploadManagerImpl, DefaultAndroidThreadUtil defaultAndroidThreadUtil, TincanGatekeepers tincanGatekeepers, TincanDbMessagesFetcher tincanDbMessagesFetcher) {
        this.f8602a = mediaUploadManagerImpl;
        this.f8603b = defaultAndroidThreadUtil;
        this.f8604c = tincanGatekeepers;
        this.f8605d = tincanDbMessagesFetcher;
    }

    public final void m8854a() {
        if (this.f8604c.c()) {
            for (MediaResource a : this.f8605d.a()) {
                m8852a(a);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.tincan.messenger.EncryptedAttachmentUploadRetryHandler m8851a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f8601e;	 Catch:{ all -> 0x006c }
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
        r1 = m8853b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f8601e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.EncryptedAttachmentUploadRetryHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.tincan.messenger.EncryptedAttachmentUploadRetryHandler) r0;	 Catch:{  }
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
        r0 = f8601e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.EncryptedAttachmentUploadRetryHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.messenger.EncryptedAttachmentUploadRetryHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.messenger.EncryptedAttachmentUploadRetryHandler");
    }

    public final void m8855a(String str, Uri uri) {
        if (this.f8604c.c()) {
            for (MediaResource mediaResource : this.f8605d.d(str)) {
                if (uri.equals(mediaResource.c)) {
                    m8852a(mediaResource);
                }
            }
        }
    }

    private void m8852a(MediaResource mediaResource) {
        this.f8603b.a(new 1(this, mediaResource));
    }
}
