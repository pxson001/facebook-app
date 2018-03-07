package com.facebook.prefs.shared;

import com.facebook.abtest.qe.data.QuickExperimentConfigPrefKeys;
import com.facebook.account.recovery.constants.AccountRecoveryPrefKeys;
import com.facebook.apptab.state.AppTabPrefKeys;
import com.facebook.bookmark.nux.BookmarkNuxPrefKeys;
import com.facebook.composer.minutiae.prefs.MinutiaePrefKeys;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.conditionalworker.ConditionalWorkerExecutionRecordManager;
import com.facebook.config.background.impl.ConfigPrefKeys;
import com.facebook.contactlogs.prefs.ContactLogsPrefKeys;
import com.facebook.contacts.upload.prefs.ContactsUploadPrefKeys;
import com.facebook.events.prefs.EventsPrefKeys;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.katana.prefs.NotificationPrefKeys;
import com.facebook.languages.switchercommonex.LanguageSwitcherCommonExPrefKeys;
import com.facebook.messaging.neue.shared.NeuePrefKeys;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.mqttlite.MqttPrefKeys;
import com.facebook.placetips.presence.PlaceTipsPresencePrefs;
import com.facebook.privacy.PrivacyPrefKeys;
import com.facebook.saved.prefs.SavedPrefKeys;
import com.facebook.saved2.prefs.Saved2PrefKeys;
import com.facebook.video.videohome.prefs.VideoHomePrefKeys;
import com.facebook.work.workprefkeys.WorkSetupProfilePrefKeys;
import com.facebook.zero.service.FbZeroTokenManager;
import com.facebook.zero.service.ZeroHeaderRequestManager;
import com.facebook.zero.service.ZeroInterstitialEligibilityManager;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$IHavePrivacyCriticalKeysToClear implements MultiBindIndexedProvider<IHavePrivacyCriticalKeysToClear>, Provider<Set<IHavePrivacyCriticalKeysToClear>> {
    private final InjectorLike f1394a;

    public STATICDI_MULTIBIND_PROVIDER$IHavePrivacyCriticalKeysToClear(InjectorLike injectorLike) {
        this.f1394a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1394a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 26;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new QuickExperimentConfigPrefKeys();
            case 1:
                return new AccountRecoveryPrefKeys();
            case 2:
                return new AppTabPrefKeys();
            case 3:
                return new BookmarkNuxPrefKeys();
            case 4:
                return new MinutiaePrefKeys();
            case 5:
                return new ComposerPrefKeys();
            case 6:
                return ConditionalWorkerExecutionRecordManager.m10561a(injector);
            case 7:
                return new ConfigPrefKeys();
            case 8:
                return new ContactLogsPrefKeys();
            case 9:
                return new ContactsUploadPrefKeys();
            case 10:
                return new EventsPrefKeys();
            case 11:
                return new FbandroidPrefKeys();
            case 12:
                return new NotificationPrefKeys();
            case 13:
                return new LanguageSwitcherCommonExPrefKeys();
            case 14:
                return NeuePrefKeys.a(injector);
            case 15:
                return new MessagingPrefKeys();
            case 16:
                return new MqttPrefKeys();
            case 17:
                return new PlaceTipsPresencePrefs();
            case 18:
                return PrivacyPrefKeys.m2318a(injector);
            case 19:
                return new SavedPrefKeys();
            case 20:
                return new Saved2PrefKeys();
            case 21:
                return new VideoHomePrefKeys();
            case 22:
                return new WorkSetupProfilePrefKeys();
            case 23:
                return FbZeroTokenManager.b(injector);
            case 24:
                return ZeroHeaderRequestManager.m2190a((InjectorLike) injector);
            case 25:
                return ZeroInterstitialEligibilityManager.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
