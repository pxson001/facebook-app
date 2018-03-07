package com.facebook.database.supplier;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.platform.database.PendingMediaUploadsSchemaPart;
import com.facebook.platform.database.PendingAppCallsSchemaPart;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class C0545xf11fd559 implements MultiBindIndexedProvider<SharedSQLiteSchemaPart>, Provider<Set<SharedSQLiteSchemaPart>> {
    private final InjectorLike f11259a;

    public C0545xf11fd559(InjectorLike injectorLike) {
        this.f11259a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f11259a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PendingMediaUploadsSchemaPart.m11679a(injector);
            case 1:
                return PendingAppCallsSchemaPart.m11682a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
