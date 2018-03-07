package com.facebook.offlinemode.intentchecker;

import com.facebook.adinterfaces.component.AdInterfacesOfflineChecker;
import com.facebook.attachments.angora.actionbutton.SavedOfflineSnackbarActionControllerProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.activity.faceweb.FacewebOfflineIntentChecker;
import com.facebook.pages.identity.intent.uri.PagesOfflineIntentChecker;
import com.facebook.ui.browser.BrowserOfflineIntentChecker;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: unknown relative layout param =  */
public final class STATICDI_MULTIBIND_PROVIDER$OfflineIntentChecker implements MultiBindIndexedProvider<OfflineIntentChecker>, Provider<Set<OfflineIntentChecker>> {
    private final InjectorLike f16536a;

    public STATICDI_MULTIBIND_PROVIDER$OfflineIntentChecker(InjectorLike injectorLike) {
        this.f16536a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f16536a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new AdInterfacesOfflineChecker();
            case 1:
                return new FacewebOfflineIntentChecker();
            case 2:
                return new PagesOfflineIntentChecker((SavedOfflineSnackbarActionControllerProvider) injector.getOnDemandAssistedProviderForStaticDi(SavedOfflineSnackbarActionControllerProvider.class), IdBasedProvider.a(injector, 768));
            case 3:
                return new BrowserOfflineIntentChecker((SavedOfflineSnackbarActionControllerProvider) injector.getOnDemandAssistedProviderForStaticDi(SavedOfflineSnackbarActionControllerProvider.class), IdBasedProvider.a(injector, 768), GatekeeperStoreImplMethodAutoProvider.a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
