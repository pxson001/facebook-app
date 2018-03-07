package com.facebook.composer.location;

import android.content.Context;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.location.LocationLightweightPickerSproutItem.Listener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCheckinSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.places.checkin.analytics.LightweightPlacePickerAnalytics;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: full_session */
public class LocationLightweightPickerSproutItemProvider extends AbstractAssistedProvider<LocationLightweightPickerSproutItem> {
    public final <DataProvider extends ProvidesIsCheckinSupported & ProvidesSessionId & ProvidesLocationInfo> LocationLightweightPickerSproutItem<DataProvider> m8114a(DataProvider dataProvider, Listener listener) {
        return new LocationLightweightPickerSproutItem((ComposerDataProviderImpl) dataProvider, listener, (Context) getInstance(Context.class), LightweightPlacePickerAnalytics.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
