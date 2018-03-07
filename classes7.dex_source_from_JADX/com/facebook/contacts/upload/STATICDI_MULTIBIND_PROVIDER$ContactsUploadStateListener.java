package com.facebook.contacts.upload;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.orca.notify.ContactsUploadResultNotifier;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: ्औ */
public final class STATICDI_MULTIBIND_PROVIDER$ContactsUploadStateListener implements MultiBindIndexedProvider<ContactsUploadStateListener>, Provider<Set<ContactsUploadStateListener>> {
    private final InjectorLike f2195a;

    public STATICDI_MULTIBIND_PROVIDER$ContactsUploadStateListener(InjectorLike injectorLike) {
        this.f2195a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2195a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                ContactsUploadResultNotifier contactsUploadResultNotifier = new ContactsUploadResultNotifier();
                Lazy a = IdBasedLazy.a(injector, 8803);
                Lazy b = IdBasedSingletonScopeProvider.b(injector, 2128);
                contactsUploadResultNotifier.a = a;
                contactsUploadResultNotifier.b = b;
                return contactsUploadResultNotifier;
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
