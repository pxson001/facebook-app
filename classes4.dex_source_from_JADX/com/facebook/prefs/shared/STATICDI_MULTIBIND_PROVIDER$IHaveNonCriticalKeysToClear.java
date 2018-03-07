package com.facebook.prefs.shared;

import com.facebook.appirater.InternalStarRatingPrefKeys;
import com.facebook.feed.firstlaunch.FirstLaunchSharedPrefs;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.feedplugins.placetips.PlaceTipsPostComposeNuxPrefs;
import com.facebook.friending.newuserpromotion.NewUserFriendingPrefKeys;
import com.facebook.goodwill.dailydialogue.data.DailyDialoguePrefKeys;
import com.facebook.goodwill.feed.data.ThrowbackFeedPrefKeys;
import com.facebook.groups.preferences.GroupsPrefKeys;
import com.facebook.growth.prefs.FriendFinderPrefKeys;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.instantshopping.InstantShoppingPrefKeys;
import com.facebook.interstitial.manager.InterstitialRepository;
import com.facebook.messaging.contactsyoumayknow.ContactsYouMayKnowPrefKeys;
import com.facebook.messaging.neue.shared.NeuePrefKeys;
import com.facebook.placetips.pulsarcore.PulsarPrefs;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs;
import com.facebook.platform.auth.NativeGdpPrefsKeys;
import com.facebook.privacy.PrivacyPrefKeys;
import com.facebook.selfupdate.remotepushtrigger.RemotePushTriggerPrefs;
import com.facebook.today.prefs.TodayPrefKeys;
import com.facebook.widget.viewdiagnostics.ViewDiagnosticsPrefKeys;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$IHaveNonCriticalKeysToClear implements MultiBindIndexedProvider<IHaveNonCriticalKeysToClear>, Provider<Set<IHaveNonCriticalKeysToClear>> {
    private final InjectorLike f1395a;

    public STATICDI_MULTIBIND_PROVIDER$IHaveNonCriticalKeysToClear(InjectorLike injectorLike) {
        this.f1395a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1395a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 21;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new InternalStarRatingPrefKeys();
            case 1:
                return new FirstLaunchSharedPrefs();
            case 2:
                return new FeedPrefKeys();
            case 3:
                return PlaceTipsPostComposeNuxPrefs.b(injector);
            case 4:
                return new NewUserFriendingPrefKeys();
            case 5:
                return new DailyDialoguePrefKeys();
            case 6:
                return new ThrowbackFeedPrefKeys();
            case 7:
                return new GroupsPrefKeys();
            case 8:
                return new FriendFinderPrefKeys();
            case 9:
                return new GrowthPrefKeys();
            case 10:
                return new InstantShoppingPrefKeys();
            case 11:
                return InterstitialRepository.a(injector);
            case 12:
                return new ContactsYouMayKnowPrefKeys();
            case 13:
                return NeuePrefKeys.a(injector);
            case 14:
                return new PulsarPrefs();
            case 15:
                return new PlaceTipsSettingsPrefs();
            case 16:
                return new NativeGdpPrefsKeys();
            case 17:
                return PrivacyPrefKeys.m2318a(injector);
            case 18:
                return new RemotePushTriggerPrefs();
            case 19:
                return new TodayPrefKeys();
            case 20:
                return new ViewDiagnosticsPrefKeys();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
