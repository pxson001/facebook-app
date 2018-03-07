package com.facebook.messaging.newphoto;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.photoreminders.MessagingPhotoRemindersModule;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$NewPhotoIntentListenerGK implements MultiBindIndexedProvider<NewPhotoIntentListenerGK>, Provider<Set<NewPhotoIntentListenerGK>> {
    private final InjectorLike f2437a;

    public STATICDI_MULTIBIND_PROVIDER$NewPhotoIntentListenerGK(InjectorLike injectorLike) {
        this.f2437a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2437a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return MessagingPhotoRemindersModule.m4654a();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
