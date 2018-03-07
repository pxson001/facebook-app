package com.facebook.device_id;

import android.content.Context;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.phoneid.PhoneIdRequester;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: |url_ */
public class DeviceIdModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ShareDeviceId
    static Boolean m30a() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @Singleton
    static PhoneIdRequester m29a(Context context, DefaultPhoneIdStore defaultPhoneIdStore, DefaultPhoneIdUpdatedCallback defaultPhoneIdUpdatedCallback, FbPhoneIdSyncStatsReporter fbPhoneIdSyncStatsReporter) {
        return new PhoneIdRequester(context, defaultPhoneIdStore, defaultPhoneIdUpdatedCallback, fbPhoneIdSyncStatsReporter);
    }
}
