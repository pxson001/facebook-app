package com.facebook.device_id;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: tuzi_fb4a_scoped_search_filter */
public class UniqueIdForDeviceHolderMethodAutoProvider extends AbstractProvider<UniqueIdForDeviceHolder> {
    public static UniqueIdForDeviceHolderImpl m4339b(InjectorLike injectorLike) {
        return UniqueIdForDeviceHolderImpl.m4341a(injectorLike);
    }

    public Object get() {
        return UniqueIdForDeviceHolderImpl.m4341a((InjectorLike) this);
    }

    public static UniqueIdForDeviceHolderImpl m4338a(InjectorLike injectorLike) {
        return m4339b(injectorLike);
    }
}
