package com.facebook.gk.internal;

import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: timelineAppCollectionParamsKey */
public class String_DeviceIdForGKsMethodAutoProvider extends AbstractProvider<String> {
    public Object get() {
        return GkInternalModule.m33a(UniqueIdForDeviceHolderMethodAutoProvider.b(this));
    }
}
