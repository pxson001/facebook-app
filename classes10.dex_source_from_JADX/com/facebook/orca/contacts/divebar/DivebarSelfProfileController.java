package com.facebook.orca.contacts.divebar;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contacts.picker.ContactPickerRowsFactory;
import com.facebook.user.model.User;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: onPeerConnected */
public class DivebarSelfProfileController {
    public final Provider<ContactPickerRowsFactory> f5883a;
    public final Provider<User> f5884b;

    public static DivebarSelfProfileController m5541a(InjectorLike injectorLike) {
        return new DivebarSelfProfileController(IdBasedProvider.a(injectorLike, 7756), IdBasedProvider.a(injectorLike, 3595));
    }

    @Inject
    public DivebarSelfProfileController(Provider<ContactPickerRowsFactory> provider, Provider<User> provider2) {
        this.f5883a = provider;
        this.f5884b = provider2;
    }
}
