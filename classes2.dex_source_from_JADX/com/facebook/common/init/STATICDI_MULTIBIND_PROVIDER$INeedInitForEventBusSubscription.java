package com.facebook.common.init;

import com.facebook.auth.event.AuthEventBus;
import com.facebook.feed.firstlaunch.FirstLaunchAuthSubscriber;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedplugins.placetips.PlaceTipsFeedEventBusSubscriber;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.platform.C0162xf3aead23;
import com.facebook.katana.platform.C0164x1ce73bed;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.progresspage.MediaUploadActivityReceiver$MediaFailedBusSubscriber;
import com.facebook.photos.upload.progresspage.MediaUploadActivityReceiver$MediaProgressBusSubscriber;
import com.facebook.photos.upload.progresspage.MediaUploadActivityReceiver$MediaServerProcessingBusSubscriber;
import com.facebook.photos.upload.progresspage.MediaUploadActivityReceiver$MediaSuccessBusSubscriber;
import com.facebook.placetips.bootstrap.event.PlaceTipsEventBus;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.reaction.placetips.PlaceTipsPresenceChangedSubscriber;
import com.facebook.reaction.placetips.PlaceTipsPresenceStayedTheSameSubscriber;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$INeedInitForEventBusSubscription implements MultiBindIndexedProvider<INeedInitForEventBusSubscription>, Provider<Set<INeedInitForEventBusSubscription>> {
    private final InjectorLike f2385a;

    public STATICDI_MULTIBIND_PROVIDER$INeedInitForEventBusSubscription(InjectorLike injectorLike) {
        this.f2385a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2385a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 10;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new FirstLaunchAuthSubscriber(AuthEventBus.m4563a(injector), IdBasedLazy.m1808a(injector, 1339));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new PlaceTipsFeedEventBusSubscriber(FeedEventBus.m4573a(injector), IdBasedLazy.m1808a(injector, 3017));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new C0162xf3aead23(MediaUploadEventBus.m4577a(injector), IdBasedSingletonScopeProvider.m1810b(injector, 7349));
            case 3:
                return new C0164x1ce73bed(MediaUploadEventBus.m4577a(injector), IdBasedSingletonScopeProvider.m1810b(injector, 7349));
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return new MediaUploadActivityReceiver$MediaFailedBusSubscriber(MediaUploadEventBus.m4577a(injector), IdBasedSingletonScopeProvider.m1810b(injector, 9472));
            case 5:
                return new MediaUploadActivityReceiver$MediaProgressBusSubscriber(MediaUploadEventBus.m4577a(injector), IdBasedSingletonScopeProvider.m1810b(injector, 9472));
            case 6:
                return new MediaUploadActivityReceiver$MediaServerProcessingBusSubscriber(MediaUploadEventBus.m4577a(injector), IdBasedSingletonScopeProvider.m1810b(injector, 9472));
            case 7:
                return new MediaUploadActivityReceiver$MediaSuccessBusSubscriber(MediaUploadEventBus.m4577a(injector), IdBasedSingletonScopeProvider.m1810b(injector, 9472));
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return new PlaceTipsPresenceChangedSubscriber(PlaceTipsEventBus.m4590a((InjectorLike) injector), IdBasedLazy.m1808a(injector, 3263));
            case 9:
                return new PlaceTipsPresenceStayedTheSameSubscriber(PlaceTipsEventBus.m4590a((InjectorLike) injector), IdBasedLazy.m1808a(injector, 3263));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
