package com.facebook.common.init;

import android.content.Context;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.bluetoothsupportreporter.BluetoothSupportReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.persisteduid.UserIdFileTrigger;
import com.facebook.composer.shareintent.AlphabeticalShareIntentAliasPrefsWatcher;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.debug.pref.NonEmployeeModePreference;
import com.facebook.deeplinking.DeepLinkingPrefsWatcher;
import com.facebook.gk.internal.OnUpgradeGkRefresher;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.interstitial.manager.UpgradeInterstitialOnAppUpgrade;
import com.facebook.katana.binding.sessioninfo.SessionInfoHelper;
import com.facebook.katana.urimap.LinkSharingNativeComposerPrefsWatcher;
import com.facebook.messaging.database.threads.ServerMutedUntilPostUpgradeInit;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.xconfig.sync.XConfigPostUpgradeSyncer;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class C0067xab9c254b implements MultiBindIndexedProvider<INeedInit>, Provider<Set<INeedInit>> {
    private final InjectorLike f1165a;

    public C0067xab9c254b(InjectorLike injectorLike) {
        this.f1165a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1165a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 11;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new BluetoothSupportReporter((Context) injector.getInstance(Context.class), IdBasedSingletonScopeProvider.m1809a(injector, 175), IdBasedSingletonScopeProvider.m1810b(injector, 5133));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return UserIdFileTrigger.a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return AlphabeticalShareIntentAliasPrefsWatcher.a(injector);
            case 3:
                return NonEmployeeModePreference.b(injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return DeepLinkingPrefsWatcher.a(injector);
            case 5:
                return OnUpgradeGkRefresher.a(injector);
            case 6:
                return new UpgradeInterstitialOnAppUpgrade(IdBasedSingletonScopeProvider.m1810b(injector, 2360));
            case 7:
                return SessionInfoHelper.m8877b((InjectorLike) injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return LinkSharingNativeComposerPrefsWatcher.a(injector);
            case 9:
                return new ServerMutedUntilPostUpgradeInit(ProductMethodAutoProvider.m4524b(injector), FbSharedPreferencesImpl.m1826a((InjectorLike) injector), IdBasedProvider.m1811a(injector, 7815), LoggedInUserSessionManager.m2511a((InjectorLike) injector), FbErrorReporterImpl.m2317a((InjectorLike) injector));
            case 10:
                return XConfigPostUpgradeSyncer.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
