package com.facebook.location.write;

import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.LocationAgeUtil;

/* compiled from: log_megaphone */
public class LocationMutationModelCreatorProvider extends AbstractAssistedProvider<LocationMutationModelCreator> {
    public final LocationMutationModelCreator m23083a(LocationMutationModelCreatorParams locationMutationModelCreatorParams) {
        return new LocationMutationModelCreator(locationMutationModelCreatorParams, AppStateManager.m2245a((InjectorLike) this), UniqueIdForDeviceHolderMethodAutoProvider.m4339b(this), LocationAgeUtil.m8265a((InjectorLike) this), RealtimeSinceBootClockMethodAutoProvider.m6582a(this));
    }
}
