package com.facebook.timeline.profilemedia.upload;

import android.net.Uri;
import android.os.Handler;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadEventSubscriber;
import com.facebook.photos.upload.event.MediaUploadFailedEvent;
import com.facebook.photos.upload.event.MediaUploadSuccessEvent;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.timeline.profilemedia.ProfileMediaChangeBroadcaster;
import com.facebook.timeline.profilemedia.ProfileMediaOptimisticPostingController;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: mSuggestifierFooterQuestion */
public class ProfileMediaUploadReceiver {
    private static final Object f9197k = new Object();
    private final MediaSuccessBusSubscriber f9198a = new MediaSuccessBusSubscriber(this);
    private final MediaFailureBusSubscriber f9199b = new MediaFailureBusSubscriber(this);
    private final MediaUploadEventBus f9200c;
    public final ProfileMediaChangeBroadcaster f9201d;
    private final Handler f9202e;
    public final ProfileMediaOptimisticPostingController f9203f;
    @Nullable
    public String f9204g;
    @Nullable
    public String f9205h;
    @Nullable
    private Runnable f9206i;
    @Nullable
    private Runnable f9207j;

    /* compiled from: mSuggestifierFooterQuestion */
    class C09521 implements Runnable {
        final /* synthetic */ ProfileMediaUploadReceiver f9192a;

        C09521(ProfileMediaUploadReceiver profileMediaUploadReceiver) {
            this.f9192a = profileMediaUploadReceiver;
        }

        public void run() {
            this.f9192a.m10989b();
        }
    }

    /* compiled from: mSuggestifierFooterQuestion */
    class C09532 implements Runnable {
        final /* synthetic */ ProfileMediaUploadReceiver f9193a;

        C09532(ProfileMediaUploadReceiver profileMediaUploadReceiver) {
            this.f9193a = profileMediaUploadReceiver;
        }

        public void run() {
            this.f9193a.m10986a();
        }
    }

    /* compiled from: mSuggestifierFooterQuestion */
    /* synthetic */ class C09543 {
        static final /* synthetic */ int[] f9194a = new int[Type.values().length];

        static {
            try {
                f9194a[Type.PROFILE_PIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9194a[Type.COVER_PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: mSuggestifierFooterQuestion */
    class MediaFailureBusSubscriber extends MediaUploadEventSubscriber<MediaUploadFailedEvent> {
        final /* synthetic */ ProfileMediaUploadReceiver f9195a;

        public MediaFailureBusSubscriber(ProfileMediaUploadReceiver profileMediaUploadReceiver) {
            this.f9195a = profileMediaUploadReceiver;
        }

        public final void m10982b(FbEvent fbEvent) {
            MediaUploadFailedEvent mediaUploadFailedEvent = (MediaUploadFailedEvent) fbEvent;
            switch (C09543.f9194a[mediaUploadFailedEvent.a.r.ordinal()]) {
                case 1:
                    if (this.f9195a.f9204g != null && this.f9195a.f9204g.equals(mediaUploadFailedEvent.a.p)) {
                        this.f9195a.m10989b();
                    }
                    this.f9195a.f9203f.m10952a(mediaUploadFailedEvent.a.p);
                    return;
                case 2:
                    if ((this.f9195a.f9205h != null && this.f9195a.f9205h.equals(mediaUploadFailedEvent.a.p)) || "unsupportedSessionId".equals(mediaUploadFailedEvent.a.p)) {
                        this.f9195a.m10986a();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final Class<MediaUploadFailedEvent> m10981a() {
            return MediaUploadFailedEvent.class;
        }
    }

    /* compiled from: mSuggestifierFooterQuestion */
    class MediaSuccessBusSubscriber extends MediaUploadEventSubscriber<MediaUploadSuccessEvent> {
        final /* synthetic */ ProfileMediaUploadReceiver f9196a;

        public MediaSuccessBusSubscriber(ProfileMediaUploadReceiver profileMediaUploadReceiver) {
            this.f9196a = profileMediaUploadReceiver;
        }

        public final void m10984b(FbEvent fbEvent) {
            MediaUploadSuccessEvent mediaUploadSuccessEvent = (MediaUploadSuccessEvent) fbEvent;
            switch (C09543.f9194a[mediaUploadSuccessEvent.a.r.ordinal()]) {
                case 1:
                    if (this.f9196a.f9204g != null && this.f9196a.f9204g.equals(mediaUploadSuccessEvent.a.p)) {
                        this.f9196a.m10989b();
                    }
                    this.f9196a.f9203f.m10952a(mediaUploadSuccessEvent.a.p);
                    this.f9196a.f9201d.m10945b();
                    return;
                case 2:
                    if ((this.f9196a.f9205h != null && this.f9196a.f9205h.equals(mediaUploadSuccessEvent.a.p)) || "unsupportedSessionId".equals(mediaUploadSuccessEvent.a.p)) {
                        this.f9196a.m10986a();
                    }
                    this.f9196a.f9203f.m10954b(mediaUploadSuccessEvent.a.p);
                    this.f9196a.f9201d.m10947d();
                    return;
                default:
                    return;
            }
        }

        public final Class<MediaUploadSuccessEvent> m10983a() {
            return MediaUploadSuccessEvent.class;
        }
    }

    private static ProfileMediaUploadReceiver m10988b(InjectorLike injectorLike) {
        return new ProfileMediaUploadReceiver(MediaUploadEventBus.a(injectorLike), ProfileMediaChangeBroadcaster.m10942a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), ProfileMediaOptimisticPostingController.m10949a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.timeline.profilemedia.upload.ProfileMediaUploadReceiver m10985a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9197k;	 Catch:{ all -> 0x006c }
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
        r1 = m10988b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9197k;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.timeline.profilemedia.upload.ProfileMediaUploadReceiver) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.timeline.profilemedia.upload.ProfileMediaUploadReceiver) r0;	 Catch:{  }
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
        r0 = f9197k;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.timeline.profilemedia.upload.ProfileMediaUploadReceiver) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.profilemedia.upload.ProfileMediaUploadReceiver.a(com.facebook.inject.InjectorLike):com.facebook.timeline.profilemedia.upload.ProfileMediaUploadReceiver");
    }

    @Inject
    public ProfileMediaUploadReceiver(MediaUploadEventBus mediaUploadEventBus, ProfileMediaChangeBroadcaster profileMediaChangeBroadcaster, Handler handler, ProfileMediaOptimisticPostingController profileMediaOptimisticPostingController) {
        this.f9200c = mediaUploadEventBus;
        this.f9201d = profileMediaChangeBroadcaster;
        this.f9202e = handler;
        this.f9203f = profileMediaOptimisticPostingController;
    }

    public final void m10992a(@Nullable Uri uri, String str) {
        this.f9203f.m10951a(uri, str);
        this.f9200c.a(this.f9198a);
        this.f9200c.a(this.f9199b);
        this.f9204g = str;
        if (this.f9206i != null) {
            HandlerDetour.a(this.f9202e, this.f9206i);
        }
        this.f9206i = new C09521(this);
        HandlerDetour.b(this.f9202e, this.f9206i, 3600000, -2003217675);
    }

    public final void m10993b(@Nullable Uri uri, String str) {
        this.f9203f.m10953b(uri, str);
        this.f9200c.a(this.f9198a);
        this.f9200c.a(this.f9199b);
        this.f9205h = str;
        if (this.f9207j != null) {
            HandlerDetour.a(this.f9202e, this.f9207j);
        }
        this.f9207j = new C09532(this);
        HandlerDetour.b(this.f9202e, this.f9207j, 3600000, -1249911611);
    }

    private void m10986a() {
        this.f9205h = null;
        if (this.f9207j != null) {
            HandlerDetour.a(this.f9202e, this.f9207j);
            this.f9207j = null;
        }
        m10991c();
    }

    private void m10989b() {
        this.f9204g = null;
        if (this.f9206i != null) {
            HandlerDetour.a(this.f9202e, this.f9206i);
            this.f9206i = null;
        }
        m10991c();
    }

    private void m10991c() {
        if (this.f9204g == null && this.f9205h == null) {
            this.f9200c.b(this.f9198a);
            this.f9200c.b(this.f9199b);
        }
    }
}
