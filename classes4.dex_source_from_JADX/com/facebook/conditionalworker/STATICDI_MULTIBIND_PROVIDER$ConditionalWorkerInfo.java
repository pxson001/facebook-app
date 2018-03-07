package com.facebook.conditionalworker;

import com.facebook.assetdownload.background.AssetDownloadConditionalWorkerInfo;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.composer.minutiae.protocol.MinutiaeConditionalWorkerInfo;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.contacts.background.ContactsReliabilityCheckConditionalWorkerInfo;
import com.facebook.contacts.background.FetchContactsCoefficientConditionalWorkerInfo;
import com.facebook.contacts.ccu.ContactsUploadClient;
import com.facebook.contacts.ccu.ContactsUploadConditionalWorkerInfo;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.internal.GkSessionlessConditionalWorkerInfo;
import com.facebook.gk.sessionless.GatekeeperStoreConfig_SessionlessMethodAutoProvider;
import com.facebook.graphql.cursor.worker.GraphCursorDatabaseConditionalWorkerInfo;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.languages.switcher.task.AutoSyncLoggedInUserLocaleConditionalWorkerInfo;
import com.facebook.malware.permissions.MalwareDetectorConditionalWorkerInfo;
import com.facebook.malware.scanner.MalwareScannerConditionalWorkerInfo;
import com.facebook.messaging.analytics.reliability.ReliabilityLoggerStaleEntriesConditionalWorkerInfo;
import com.facebook.messaging.payment.cache.PaymentRequestCache;
import com.facebook.messaging.payment.prefs.FetchIncomingPaymentRequestsConditionalWorkerInfo;
import com.facebook.orca.background.FetchPinnedThreadsConditionalWorkerInfo;
import com.facebook.orca.background.FetchPinnedThreadsSyncComponent;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.impl.loading.LanguagePrefetchConditionalWorkerInfo;
import com.facebook.search.bootstrap.sync.BootstrapSyncConditionalWorkerInfo;
import com.facebook.search.suggestions.nullstate.NullStateSyncConditionalWorkerInfo;
import com.facebook.ssl.reporter.RootCAReporterConditionalWorkerInfo;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.zero.service.ZeroHeaderRequestConditionalWorkerInfo;
import com.facebook.zero.service.ZeroInterstitialEligibilityConditionalWorkerInfo;
import com.facebook.zero.service.ZeroTokenConditionalWorkerInfo;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$ConditionalWorkerInfo implements MultiBindIndexedProvider<ConditionalWorkerInfo>, Provider<Set<ConditionalWorkerInfo>> {
    private final InjectorLike f10098a;

    private STATICDI_MULTIBIND_PROVIDER$ConditionalWorkerInfo(InjectorLike injectorLike) {
        this.f10098a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10098a.getScopeAwareInjector(), this);
    }

    public static Set<ConditionalWorkerInfo> m10560a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ConditionalWorkerInfo(injectorLike));
    }

    public final int size() {
        return 20;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new AssetDownloadConditionalWorkerInfo(IdBasedProvider.a(injector, 4868), IdBasedProvider.a(injector, 3898), XConfigReader.a(injector));
            case 1:
                return new MinutiaeConditionalWorkerInfo(IdBasedProvider.a(injector, 5251));
            case 2:
                return new ContactsReliabilityCheckConditionalWorkerInfo(IdBasedProvider.a(injector, 5339), IdBasedProvider.a(injector, 3941));
            case 3:
                return new FetchContactsCoefficientConditionalWorkerInfo(IdBasedProvider.a(injector, 5341), IdBasedProvider.a(injector, 939));
            case 4:
                return new ContactsUploadConditionalWorkerInfo(ContactsUploadClient.m10601a((InjectorLike) injector), (FbSharedPreferences) FbSharedPreferencesImpl.a(injector), GatekeeperStoreImplMethodAutoProvider.a(injector), IdBasedProvider.a(injector, 5343));
            case 5:
                return new GkSessionlessConditionalWorkerInfo((FbSharedPreferences) FbSharedPreferencesImpl.a(injector), DefaultProcessUtil.a(injector), IdBasedProvider.a(injector, 2113), GatekeeperStoreConfig_SessionlessMethodAutoProvider.a(injector));
            case 6:
                return new GraphCursorDatabaseConditionalWorkerInfo(IdBasedProvider.a(injector, 6855));
            case 7:
                return new AutoSyncLoggedInUserLocaleConditionalWorkerInfo(IdBasedProvider.a(injector, 7395));
            case 8:
                return new MalwareDetectorConditionalWorkerInfo(IdBasedSingletonScopeProvider.a(injector, 2520), (FbSharedPreferences) FbSharedPreferencesImpl.a(injector));
            case 9:
                return new MalwareScannerConditionalWorkerInfo(IdBasedSingletonScopeProvider.a(injector, 7474), IdBasedProvider.a(injector, 4041));
            case 10:
                return new ReliabilityLoggerStaleEntriesConditionalWorkerInfo(IdBasedProvider.a(injector, 7515));
            case 11:
                return new FetchIncomingPaymentRequestsConditionalWorkerInfo(IdBasedProvider.a(injector, 8079), IdBasedProvider.a(injector, 4182), PaymentRequestCache.m10684a((InjectorLike) injector));
            case 12:
                return new FetchPinnedThreadsConditionalWorkerInfo(IdBasedProvider.a(injector, 8773), FetchPinnedThreadsSyncComponent.m10737a(injector), ProductMethodAutoProvider.b(injector));
            case 13:
                return new LanguagePrefetchConditionalWorkerInfo(IdBasedProvider.a(injector, 4298), IdBasedProvider.a(injector, 10246));
            case 14:
                return new BootstrapSyncConditionalWorkerInfo((QeAccessor) QeInternalImplMethodAutoProvider.a(injector), IdBasedProvider.a(injector, 10477));
            case 15:
                return new NullStateSyncConditionalWorkerInfo(IdBasedProvider.a(injector, 10857), (QeAccessor) QeInternalImplMethodAutoProvider.a(injector));
            case 16:
                return new RootCAReporterConditionalWorkerInfo(IdBasedProvider.a(injector, 11013));
            case 17:
                return new ZeroHeaderRequestConditionalWorkerInfo(IdBasedProvider.a(injector, 11844), IdBasedProvider.a(injector, 817), (FbSharedPreferences) FbSharedPreferencesImpl.a(injector));
            case 18:
                return new ZeroInterstitialEligibilityConditionalWorkerInfo(IdBasedProvider.a(injector, 11845), IdBasedProvider.a(injector, 4387), (FbSharedPreferences) FbSharedPreferencesImpl.a(injector));
            case 19:
                return new ZeroTokenConditionalWorkerInfo(IdBasedProvider.a(injector, 11846), IdBasedProvider.a(injector, 814), (FbSharedPreferences) FbSharedPreferencesImpl.a(injector), IdBasedProvider.a(injector, 3759));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
