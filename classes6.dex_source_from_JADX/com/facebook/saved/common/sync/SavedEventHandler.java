package com.facebook.saved.common.sync;

import com.facebook.bookmark.iface.BookmarkSyncListener;
import com.facebook.bookmark.iface.STATICDI_MULTIBIND_PROVIDER;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.saved.common.nux.SavedBookmarksNuxInterstitialController;
import com.facebook.saved.data.SavedDashboardPrefetcher;
import com.facebook.saved.data.SavedDashboardPrefetcher.1;
import com.facebook.saved.prefs.SavedPrefKeys;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: setComposerType */
public class SavedEventHandler {
    public final FbSharedPreferences f4869a;
    public final Lazy<Set<BookmarkSyncListener>> f4870b;
    public final InterstitialManager f4871c;
    private final Lazy<Set<Listener>> f4872d;

    public static SavedEventHandler m7671b(InjectorLike injectorLike) {
        return new SavedEventHandler((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), STATICDI_MULTIBIND_PROVIDER.BookmarkSyncListener.a(injectorLike), InterstitialManager.a(injectorLike), ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$SavedEventHandler_Listener(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public SavedEventHandler(FbSharedPreferences fbSharedPreferences, Lazy<Set<BookmarkSyncListener>> lazy, InterstitialManager interstitialManager, Lazy<Set<Listener>> lazy2) {
        this.f4869a = fbSharedPreferences;
        this.f4870b = lazy;
        this.f4871c = interstitialManager;
        this.f4872d = lazy2;
    }

    public final void m7672a() {
        if (!this.f4869a.a(SavedPrefKeys.c, false)) {
            for (BookmarkSyncListener a : (Set) this.f4870b.get()) {
                a.a();
            }
            this.f4869a.edit().putBoolean(SavedPrefKeys.c, true).commit();
        }
        SavedBookmarksNuxInterstitialController savedBookmarksNuxInterstitialController = (SavedBookmarksNuxInterstitialController) this.f4871c.a("3907", SavedBookmarksNuxInterstitialController.class);
        savedBookmarksNuxInterstitialController.a.edit().a(SavedPrefKeys.d, savedBookmarksNuxInterstitialController.b.a()).commit();
        for (SavedDashboardPrefetcher savedDashboardPrefetcher : (Set) this.f4872d.get()) {
            savedDashboardPrefetcher.b.a(new 1(savedDashboardPrefetcher));
        }
    }
}
