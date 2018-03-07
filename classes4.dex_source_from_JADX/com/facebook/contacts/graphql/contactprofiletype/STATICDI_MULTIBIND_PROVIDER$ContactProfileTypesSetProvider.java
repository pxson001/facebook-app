package com.facebook.contacts.graphql.contactprofiletype;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$ContactProfileTypesSetProvider implements MultiBindIndexedProvider<ContactProfileTypesSetProvider>, Provider<Set<ContactProfileTypesSetProvider>> {
    private final InjectorLike f3290a;

    public STATICDI_MULTIBIND_PROVIDER$ContactProfileTypesSetProvider(InjectorLike injectorLike) {
        this.f3290a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f3290a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new MessagesProfileTypesSetProvider();
            case 1:
                return new PagesContactProfileTypesSetProvider();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
