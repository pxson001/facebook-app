package com.facebook.config.background;

import com.facebook.abtest.qe.service.QuickExperimentConfigurationComponent;
import com.facebook.appirater.Appirater;
import com.facebook.appirater.InternalStarRatingController;
import com.facebook.appirater.api.AppRaterShouldAskUserApiMethod;
import com.facebook.appirater.api.InternalStarRatingConfigComponent;
import com.facebook.auth.login.FacebookEmployeeStatusFetchComponent;
import com.facebook.contacts.upload.config.ContactsUploadUserSettingsConfigComponent;
import com.facebook.contacts.upload.data.ContactsUploadDbHandler;
import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.contacts.upload.protocol.GetContactsUploadSettingsMethod;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.internal.GkConfigurationComponent;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.interstitial.configuration.InterstitialConfigurationComponent;
import com.facebook.katana.urimap.fetchable.FacewebUriComponent;
import com.facebook.mqttlite.MqttConfigurationComponent;
import com.facebook.placetips.settings.graphql.GravitySettingsConfigurationComponent;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.privacy.audience.AudienceEducatorManager;
import com.facebook.privacy.audience.AudienceInfoFetchComponent;
import com.facebook.privacy.audience.ComposerPrivacyGuardrailFetchComponent;
import com.facebook.privacy.protocol.FetchAudienceInfoMethod;
import com.facebook.privacy.service.ComposerPrivacyOptionsFetchComponent;
import com.facebook.xconfig.sync.XSyncComponent;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$ConfigurationComponent implements MultiBindIndexedProvider<ConfigurationComponent>, Provider<Set<ConfigurationComponent>> {
    private final InjectorLike f3259a;

    private STATICDI_MULTIBIND_PROVIDER$ConfigurationComponent(InjectorLike injectorLike) {
        this.f3259a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f3259a.getScopeAwareInjector(), this);
    }

    public static Set<ConfigurationComponent> m3453a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ConfigurationComponent(injectorLike));
    }

    public final int size() {
        return 13;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new QuickExperimentConfigurationComponent(IdBasedLazy.a(injector, 94), GatekeeperStoreImplMethodAutoProvider.a(injector));
            case 1:
                return new InternalStarRatingConfigComponent(Appirater.m7681a((InjectorLike) injector), InternalStarRatingController.m7692a((InjectorLike) injector), AppRaterShouldAskUserApiMethod.m3468b(injector));
            case 2:
                return FacebookEmployeeStatusFetchComponent.m3487a(injector);
            case 3:
                return new ContactsUploadUserSettingsConfigComponent((FbSharedPreferences) FbSharedPreferencesImpl.a(injector), ContactsUploadDbHandler.m12834b((InjectorLike) injector), new GetContactsUploadSettingsMethod(), ContactUploadStatusHelper.m11414b(injector));
            case 4:
                return GkConfigurationComponent.m1759a(injector);
            case 5:
                return InterstitialConfigurationComponent.m1771b(injector);
            case 6:
                return FacewebUriComponent.m1780b(injector);
            case 7:
                return MqttConfigurationComponent.m3526a(injector);
            case 8:
                return new GravitySettingsConfigurationComponent(IdBasedProvider.a(injector, 3025), IdBasedLazy.a(injector, 3023));
            case 9:
                return new AudienceInfoFetchComponent(FetchAudienceInfoMethod.m3537b(injector), AudienceEducatorManager.m2134a((InjectorLike) injector));
            case 10:
                return ComposerPrivacyGuardrailFetchComponent.m3543a(injector);
            case 11:
                return ComposerPrivacyOptionsFetchComponent.m2175b(injector);
            case 12:
                return XSyncComponent.m1854b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
