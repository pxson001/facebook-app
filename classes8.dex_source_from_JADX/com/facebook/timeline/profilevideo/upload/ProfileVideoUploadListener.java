package com.facebook.timeline.profilevideo.upload;

import android.os.Handler;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.subscription.NotificationSubscriptionsManager;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadEventSubscriber;
import com.facebook.photos.upload.event.MediaUploadFailedEvent;
import com.facebook.photos.upload.event.MediaUploadSuccessEvent;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.timeline.profilemedia.ProfileMediaChangeBroadcaster;
import com.facebook.timeline.profilevideo.store.OptimisticProfileVideoStore;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: mIsEnabled */
public class ProfileVideoUploadListener {
    public final String f9439a;
    public final MediaUploadEventBus f9440b;
    public final OptimisticProfileVideoStore f9441c;
    public final ProfileMediaChangeBroadcaster f9442d;
    public final Handler f9443e;
    public final ProfileVideoNotificationListenerProvider f9444f;
    public final Runnable f9445g = new C09851(this);
    public final MediaSuccessBusSubscriber f9446h = new MediaSuccessBusSubscriber(this);
    public final MediaFailedBusSubscriber f9447i = new MediaFailedBusSubscriber(this);

    /* compiled from: mIsEnabled */
    class C09851 implements Runnable {
        final /* synthetic */ ProfileVideoUploadListener f9435a;

        C09851(ProfileVideoUploadListener profileVideoUploadListener) {
            this.f9435a = profileVideoUploadListener;
        }

        public void run() {
            ProfileVideoUploadListener.m11192b(this.f9435a);
        }
    }

    /* compiled from: mIsEnabled */
    /* synthetic */ class C09862 {
        static final /* synthetic */ int[] f9436a = new int[Type.values().length];

        static {
            try {
                f9436a[Type.PROFILE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* compiled from: mIsEnabled */
    class MediaFailedBusSubscriber extends MediaUploadEventSubscriber<MediaUploadFailedEvent> {
        final /* synthetic */ ProfileVideoUploadListener f9437a;

        public MediaFailedBusSubscriber(ProfileVideoUploadListener profileVideoUploadListener) {
            this.f9437a = profileVideoUploadListener;
        }

        public final void m11189b(FbEvent fbEvent) {
            MediaUploadFailedEvent mediaUploadFailedEvent = (MediaUploadFailedEvent) fbEvent;
            switch (C09862.f9436a[mediaUploadFailedEvent.a.r.ordinal()]) {
                case 1:
                    if (this.f9437a.f9439a.equals(mediaUploadFailedEvent.a.p)) {
                        this.f9437a.f9441c.m11184b(this.f9437a.f9439a);
                        this.f9437a.f9442d.m10948e();
                        ProfileVideoUploadListener.m11192b(this.f9437a);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final Class<MediaUploadFailedEvent> m11188a() {
            return MediaUploadFailedEvent.class;
        }
    }

    /* compiled from: mIsEnabled */
    class MediaSuccessBusSubscriber extends MediaUploadEventSubscriber<MediaUploadSuccessEvent> {
        final /* synthetic */ ProfileVideoUploadListener f9438a;

        public MediaSuccessBusSubscriber(ProfileVideoUploadListener profileVideoUploadListener) {
            this.f9438a = profileVideoUploadListener;
        }

        public final void m11191b(FbEvent fbEvent) {
            MediaUploadSuccessEvent mediaUploadSuccessEvent = (MediaUploadSuccessEvent) fbEvent;
            switch (C09862.f9436a[mediaUploadSuccessEvent.a.r.ordinal()]) {
                case 1:
                    if (this.f9438a.f9439a.equals(mediaUploadSuccessEvent.a.p)) {
                        String str = mediaUploadSuccessEvent.a;
                        this.f9438a.f9441c.m11183a(this.f9438a.f9439a, str);
                        this.f9438a.f9442d.m10948e();
                        InjectorLike injectorLike = this.f9438a.f9444f;
                        ProfileVideoNotificationListener profileVideoNotificationListener = new ProfileVideoNotificationListener(str, NotificationSubscriptionsManager.a(injectorLike), OptimisticProfileVideoStore.m11170a(injectorLike), ProfileMediaChangeBroadcaster.m10942a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike));
                        profileVideoNotificationListener.f9429c.a(profileVideoNotificationListener.f9433g, ProfileVideoNotificationListener.f9427a);
                        HandlerDetour.b(profileVideoNotificationListener.f9432f, profileVideoNotificationListener.f9434h, 86400000, 1760139480);
                        ProfileVideoUploadListener.m11192b(this.f9438a);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final Class<MediaUploadSuccessEvent> m11190a() {
            return MediaUploadSuccessEvent.class;
        }
    }

    @Inject
    public ProfileVideoUploadListener(@Assisted String str, MediaUploadEventBus mediaUploadEventBus, OptimisticProfileVideoStore optimisticProfileVideoStore, ProfileMediaChangeBroadcaster profileMediaChangeBroadcaster, Handler handler, ProfileVideoNotificationListenerProvider profileVideoNotificationListenerProvider) {
        this.f9439a = (String) Preconditions.checkNotNull(str);
        this.f9440b = mediaUploadEventBus;
        this.f9441c = optimisticProfileVideoStore;
        this.f9442d = profileMediaChangeBroadcaster;
        this.f9443e = handler;
        this.f9444f = profileVideoNotificationListenerProvider;
    }

    public static void m11192b(ProfileVideoUploadListener profileVideoUploadListener) {
        profileVideoUploadListener.f9440b.b(profileVideoUploadListener.f9446h);
        profileVideoUploadListener.f9440b.b(profileVideoUploadListener.f9447i);
        HandlerDetour.a(profileVideoUploadListener.f9443e, profileVideoUploadListener.f9445g);
    }
}
