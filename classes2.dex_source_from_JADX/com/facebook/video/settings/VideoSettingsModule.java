package com.facebook.video.settings;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.video.settings.VideoPrefs.AutoPlaySettingValue;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: is_favorited */
public class VideoSettingsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @DefaultAutoPlaySettingsFromServer
    @Singleton
    public static AutoPlaySettingValue m26899a(Provider<Boolean> provider, Provider<Boolean> provider2) {
        if (((Boolean) provider.get()).booleanValue()) {
            return AutoPlaySettingValue.OFF;
        }
        if (((Boolean) provider2.get()).booleanValue()) {
            return AutoPlaySettingValue.WIFI_ONLY;
        }
        return AutoPlaySettingValue.ON;
    }
}
